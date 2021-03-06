package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.QuestionDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.VO.QuestionVO;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.dao.ChapterDao;
import com.zyg.exam.dao.CourseDao;
import com.zyg.exam.dao.QuestionDao;
import com.zyg.exam.exception.MyException;
import com.zyg.exam.model.Question;
import com.zyg.exam.service.QuestionService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@Transactional(rollbackFor = Exception.class)
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private ChapterDao chapterDao;

    @Override
    public JsonBean insertQuestion(Question question) {
        int num =0;
        try {
            num= questionDao.insertSelective(question);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"添加成功",null);
        }else {
            return new JsonBean(500,"添加失败",null);
        }
    }

    @Override
    public JsonBean deleteQuestion(int[] subjectids) {
        int num=0;
        try {
            num=questionDao.deleteByPrimaryKey(subjectids);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new JsonBean(200,"删除了"+num+"条数据",null);
    }

    @Override
    public JsonBean updateQuestion(Question question) {
        int num =0;
        try {
            num= questionDao.updateByPrimaryKeySelective(question);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"修改成功");
        }else {
            return new JsonBean(500,null,"修改失败");
        }
    }

    @Override
    public ResVO selectQuestion(QuestionDTO questionDTO) {
        Integer courseid=questionDTO.getCourseid();
        Integer chapterid=questionDTO.getChapterid();
        String difficulty=questionDTO.getDifficulty();
        String key=questionDTO.getKey();
        List<Object> questions = new ArrayList<>();
        long total;
        if (courseid==null&&chapterid==null&&(difficulty==null||difficulty.isEmpty())&&(key==null||key.isEmpty())){
            System.out.println("全查询");
            questions = questionDao.listQuestion(questionDTO).get(0);
            total = (long)questionDao.listQuestion(questionDTO).get(1).get(0);
        }else {
            System.out.println("条件查询");
            questions = questionDao.selectQuestion(questionDTO).get(0);
            total = (long)questionDao.selectQuestion(questionDTO).get(1).get(0);
        }
        return new ResVO(questions,total);
    }

    @Override
    public JsonBean batchImport(String fileName, MultipartFile file) throws Exception {

        boolean notNull = false;
        List<QuestionVO> questionDTOS = new ArrayList();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException(500,"上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }
        QuestionVO questionDTO;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }

            questionDTO = new QuestionVO();

            if( row.getCell(0).getCellType() !=1){
                throw new MyException(500,"导入失败(第"+(r+1)+"行,题目类型请设为文本格式)");
            }
            String type = row.getCell(0).getStringCellValue();

            if(type == null || type.isEmpty()){
                throw new MyException(500,"导入失败(第"+(r+1)+"行,题目类型未填写)");
            }

            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            String content = row.getCell(1).getStringCellValue();
            if(content==null || content.isEmpty()){
                throw new MyException(500,"导入失败(第"+(r+1)+"行,题目内容未填写)");
            }
            String option1="";
            String option2="";
            String option3="";
            String option4="";
            String answer="";



                 try {
                   option1=  row.getCell(2).getStringCellValue();
                   option2=row.getCell(3).getStringCellValue();
                   option3=row.getCell(4).getStringCellValue();
                   option4=row.getCell(5).getStringCellValue();
                      answer = row.getCell(6).getStringCellValue();
                 }catch (Exception e){
                     e.printStackTrace();

                 }





            if(answer==null || content.isEmpty()){
                throw new MyException(500,"导入失败(第"+(r+1)+"行,答案未填写)");
            }

           String difficulty = row.getCell(7).getStringCellValue();

            if(difficulty==null || content.isEmpty()){
                throw new MyException(500,"导入失败(第"+(r+1)+"行,难度未填写)");
            }

            String chapterName = row.getCell(8).getStringCellValue();

            if(chapterName==null || content.isEmpty()){
                throw new MyException(500,"导入失败(第"+(r+1)+"行,所属章节未填写)");
            }

            questionDTO.setType(type);
            questionDTO.setContent(content);
            questionDTO.setOption1(option1);
            questionDTO.setOption2(option2);
            questionDTO.setOption3(option3);
            questionDTO.setOption4(option4);
            questionDTO.setAnswer(answer);
            questionDTO.setDifficulty(difficulty);
            questionDTO.setChapterName(chapterName);

            questionDTOS.add(questionDTO);
            System.out.println(questionDTO);
        }
        int num=0;

        for (QuestionVO questionDTO1 : questionDTOS) {
            System.out.println(questionDTO1);
             try {
                 num=questionDao.insertQuestionDTO(questionDTO1);
             }catch (Exception e){
                 e.printStackTrace();
                 throw new RuntimeException(e);
             }
        }
        JsonBean jsonBean=new JsonBean();
      if (num>0){
           jsonBean= new JsonBean(200,"导入成功","");
      }
        return jsonBean;
    }
}
