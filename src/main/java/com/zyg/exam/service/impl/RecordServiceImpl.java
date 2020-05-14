package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.CorrectPaperDTO;
import com.zyg.exam.common.DTO.CreditDTO;
import org.apache.ibatis.annotations.Param;
import com.zyg.exam.common.DTO.LineChartDTO;
import com.zyg.exam.common.DTO.RecordDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.common.VO.*;
import com.zyg.exam.dao.AnswerDao;
import com.zyg.exam.dao.QuestionDao;
import com.zyg.exam.dao.RecordDao;
import com.zyg.exam.model.Class;
import com.zyg.exam.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;
    @Autowired
    private AnswerDao answerDao;
    @Autowired
    private QuestionDao questionDao;
    @Override
    public ResVO selectRecordByUserName(RecordDTO recordDTO) {
        System.out.println(recordDTO);
      Integer courseid=recordDTO.getCourseid();
      Integer classid=recordDTO.getClassid();
      String name=recordDTO.getName();
        List<Object> records = new ArrayList<>();
        long total;
        if (courseid!=null){
            System.out.println("courseName");
            records=recordDao.selectByCourse(recordDTO).get(0);
            System.out.println(records);
            total=(long)recordDao.selectByCourse(recordDTO).get(1).get(0);

        }else if (name!=null&&!name.isEmpty()){
            records=recordDao.selectByUserId(recordDTO).get(0);
            total=(long)recordDao.selectByUserId(recordDTO).get(1).get(0);

        }else if (classid!=null){
            records=recordDao.selectByClass(recordDTO).get(0);
            total=(long)recordDao.selectByClass(recordDTO).get(1).get(0);

        }else {
            records=recordDao.listRecord(recordDTO).get(0);
            total=(long)recordDao.listRecord(recordDTO).get(1).get(0);

        }
        return new ResVO(records,total);
    }

    @Override
    public String selectMonitor(Integer recordId) {
        return recordDao.selectMonitor(recordId);
    }

    @Override
    public JsonBean correctPaper( CorrectPaperDTO correctPaperDTO) {
        //计算客观题分数

        List<Object> stuAnswer = answerDao.correctSubject(correctPaperDTO.getRecordid()).get(0);
        List<Object> answers = answerDao.correctSubject(correctPaperDTO.getRecordid()).get(1);
        //计算正确答题数
        int num1=(int)stuAnswer.stream().filter(answers::contains).count();
        int subjectiveCredit = answerDao.selectValue(correctPaperDTO.getRecordid())*num1;
        //计算主观题分数
       List<CreditDTO>  lists = correctPaperDTO.getCreditDTOS();
        for (CreditDTO creditDTO:lists){
            answerDao.correctObject(correctPaperDTO.getRecordid(),creditDTO.getQuestionid(),creditDTO.getCredit());
        }
        int objectiveCredit = answerDao.selectObjectiveCredit(correctPaperDTO.getRecordid());
        //总分
        int grade=subjectiveCredit+objectiveCredit;
        //插入数据库
        int num =0;
        try {
           recordDao.setGrade(correctPaperDTO.getRecordid(),grade);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if (num>0){
            return new JsonBean(200,"批改",null);
        }else {
            return new JsonBean(500,"批改失败",null);
        }
    }

    @Override
    public JsonBean selectQuestionByRecord(Integer recordid) {
        List<Object> questions = questionDao.selectByRecord(recordid);


        return new JsonBean(200,"",questions);
    }

    @Override
    public List<BarVO> selectAverage(Integer paperid,int[] classids) {
        return recordDao.selectAverage(paperid,classids);
    }

    @Override
    public int[] selectSpread(Integer paperid, Integer classid) {
        List<SpreadVO> spreadVOS= recordDao.selectSpread(paperid,classid);

        int[] nums=new int[5];

         nums[4]= spreadVOS.stream().collect(Collectors.summingInt(SpreadVO::getNum1));
         nums[3]= spreadVOS.stream().collect(Collectors.summingInt(SpreadVO::getNum2));
         nums[2]= spreadVOS.stream().collect(Collectors.summingInt(SpreadVO::getNum3));
         nums[1]= spreadVOS.stream().collect(Collectors.summingInt(SpreadVO::getNum4));
         nums[0]= spreadVOS.stream().collect(Collectors.summingInt(SpreadVO::getNum5));

         return nums;
    }

    @Override
    public List<Class> selectClass(Integer paperid) {
        return recordDao.selectClass(paperid);
    }

    @Override
    public List<EverQuestion> selectEverQues(Integer paperid,Integer classid) {
       return recordDao.selectEverQues(paperid,classid);

    }

    @Override
    public List<LineVO> selectTendency(LineChartDTO lineChartDTO) {
        Timestamp firsttime =null;
        Timestamp lasttime=null;
        try {
            Timestamp.valueOf(lineChartDTO.getLine_time()[0]);
            Timestamp.valueOf(lineChartDTO.getLine_time()[1]);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }


        return recordDao.selectTendency(lineChartDTO.getCourseid(),firsttime,lasttime);
    }

    @Override
    public void insertWord(Integer paperid)  {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        InputStream in = null;
        try {
            Map<String,String> map = new HashMap<>();
            List<LittlePaper> littlePapers = recordDao.littlePaper(paperid);

            //String srcPath = "D:\\littlePaper.docx";//模板路径
            //InputStream inputStream = new FileInputStream(srcPath);

            for (LittlePaper littlePaper : littlePapers) {
                inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("module/littlePaper.docx");
                map.put("coursename",littlePaper.getCoursename()) ;
                map.put("teachername",littlePaper.getTeachname()) ;
                map.put("classname", littlePaper.getClassname()) ;
                map.put("stunum", "学生数: "+littlePaper.getStunum().toString());
                map.put("avgnum","平均值: "+littlePaper.getAvgnum().toString());
                map.put("num0",littlePaper.getNum0().toString());
                map.put("num1",littlePaper.getNum1().toString());
                map.put("num2",littlePaper.getNum2().toString());
                map.put("num3",littlePaper.getNum3().toString());
                map.put("num4",littlePaper.getNum4().toString());
                map.put("time",littlePaper.getNo());
                //String destPath = "D:\\" + "examLoad\\"+littlePaper.getNo()+littlePaper.getClassname()+littlePaper.getCoursename()+"考试信息.docx";
                String c=System.getProperty("user.dir");
                String filename="p"+littlePaper.getPaperid()+"c"+littlePaper.getClassid()+".docx";
                File file1=new File(c+"\\src\\main\\resources\\cache");
                outputStream = new FileOutputStream(file1+"\\"+filename);
                replaceText(inputStream, outputStream, map);//通过此方法来将map中的数据添加到模板中

                Long end=System.currentTimeMillis();
                Thread.sleep(1000);
                in = Thread.currentThread().getContextClassLoader().getResourceAsStream("cache/"+filename);
                System.out.println("上传流"+in);
                System.out.println("filename"+filename);
                boolean flag=uploadFile("122.51.73.146",21,"zzq","zzq123","/","analyse/small",filename,in);
                System.out.println(flag);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null){
                    outputStream.close();
                }
                if (in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void largePaper(Integer paperid) {
        Map<String,String> map=new HashMap<>();
        LargePaper1 largePaper1=recordDao.largePaper1(paperid);
        LargePaper2 largePaper2=recordDao.largePaper2(paperid);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        InputStream in = null;
        try {
            //String srcPath = "D:\\largePaper.docx";//模板路径
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("module/largePaper.docx");
            //InputStream inputStream = new FileInputStream(srcPath);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            map.put("time",largePaper1.getTime());
            map.put("courseName",largePaper1.getCoursename());
            map.put("courseId",largePaper1.getCourseid().toString());
            map.put("paperId",largePaper1.getPaperid().toString());
            map.put("type",largePaper2.getType());
            map.put("chapternum",largePaper2.getChapternum().toString());
            map.put("num",largePaper2.getNum().toString());
            map.put("stunum","考生数:"+largePaper2.getStunum());
            map.put("avgnum","平均分"+largePaper2.getAvgnum());
            map.put("maxnum","最高分"+largePaper2.getMaxnum());
            map.put("minnum","最低分"+largePaper2.getMinnum());
            map.put("spread","小于60分的人数:"+largePaper2.getNum0()+"  大于60小于70的人数:"+largePaper2.getNum1()+"  大于70小于80的人数:"+largePaper2.getNum2()+"  大于80小于90的人数:"+largePaper2.getNum3()+"  大于90的人数:"+largePaper2.getNum4());
            String c=System.getProperty("user.dir");
            String filename="p"+largePaper1.getPaperid()+".docx";
            File file1=new File(c+"\\src\\main\\resources\\cache");
            outputStream = new FileOutputStream(file1+"\\"+filename);
            replaceText(inputStream, outputStream, map);//通过此方法来将map中的数据添加到模板中


            Thread.sleep(1000);
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream("cache/"+filename);
            System.out.println("大文件上传流："+in);
            boolean flag=uploadFile("122.51.73.146",21,"zzq","zzq123","/","analyse/big",filename,in);
            System.out.println(flag);

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null){
                    outputStream.close();
                }
                if (in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }








    //此方法中的代码无需改动，本人已调试过。如果不满足您的需求（那你随便玩）
    public static void replaceText(InputStream inputStream, OutputStream outputStream, Map<String, String> map) {
        try {

            XWPFDocument document = new XWPFDocument(inputStream);
            //1. 替换段落中的指定文字（本人模板中 对应的编号）
            Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
            String text;
            Set<String> set;
            XWPFParagraph paragraph;
            List<XWPFRun> run;
            String key;
            while (itPara.hasNext()) {
                paragraph = itPara.next();
                set = map.keySet();
                Iterator<String> iterator = set.iterator();
                while (iterator.hasNext()) {
                    key = iterator.next();
                    run = paragraph.getRuns();
                    for (int i = 0, runSie = run.size(); i < runSie; i++) {
                        text = run.get(i).getText(run.get(i).getTextPosition());
                        if (text != null && text.equals(key)) {
                            run.get(i).setText( map.get(key), 0);
                        }
                    }
                }
            }
            //2. 替换表格中的指定文字（本人模板中 对应的姓名、性别等）
            Iterator<XWPFTable> itTable = document.getTablesIterator();
            XWPFTable table;
            int rowsCount;
            while (itTable.hasNext()) {
                XWPFParagraph p = document.createParagraph();
                XWPFRun headRun0 = p.createRun();
                table = itTable.next();
                rowsCount = table.getNumberOfRows();
                for (int i = 0; i < rowsCount; i++) {
                    XWPFTableRow row = table.getRow(i);
                    List<XWPFTableCell> cells = row.getTableCells();
                    for (XWPFTableCell cell : cells) {
                        for (Map.Entry<String, String> e : map.entrySet()) {
                            if (cell.getText().equals(e.getKey())) {
                                cell.removeParagraph(0);
                                // cell.setText(e.getValue());
                                //设置单元格文本样式
                                XWPFParagraph xwpfParagraph = cell.addParagraph();
                                XWPFRun run1 = xwpfParagraph.createRun();
                                run1.setFontSize(12);
                                run1.setText( e.getValue());
                                //设置内容水平居中
                                CTTc cttc = cell.getCTTc();
                                CTTcPr ctPr = cttc.addNewTcPr();
                                ctPr.addNewVAlign().setVal(STVerticalJc.CENTER);
                                 cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
                            }
                        }
                    }
                }
            }
            //3.输出流
            document.write(outputStream);
            System.out.println("shuchule");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean uploadFile(String host, int port, String username, String password, String basePath,
                                     String filePath, String filename, InputStream input) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        System.out.println("not ok");
        try {
            System.out.println("ok");
            int reply;
            ftp.connect(host, port);
            ftp.login(username, password);
            if (!ftp.changeWorkingDirectory(basePath+filePath)) {
                //如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) continue;
                    tempPath += "/" + dir;
                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        if (!ftp.makeDirectory(tempPath)) {
                            return result;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            //设置上传文件的类型为二进制类型
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            //上传文件
            if (!ftp.storeFile(filename, input)) {
                return result;
            }
            input.close();
            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }


}
