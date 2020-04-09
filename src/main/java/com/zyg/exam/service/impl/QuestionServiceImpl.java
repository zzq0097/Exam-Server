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
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
        int num = questionDao.insertSelective(question);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"添加成功",null);
        }else {
            return new JsonBean(500,"添加失败",null);
        }
    }

    @Override
    public JsonBean deleteQuestion(int[] subjectids) {
        return new JsonBean(200,"删除了"+questionDao.deleteByPrimaryKey(subjectids)+"条数据",null);
    }

    @Override
    public JsonBean updateQuestion(Question question) {
        int num = questionDao.updateByPrimaryKeySelective(question);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"修改成功");
        }else {
            return new JsonBean(500,null,"修改失败");
        }
    }

    @Override
    public ResVO selectQuestion(QuestionDTO questionDTO) {
        List<Object> questions = new ArrayList<>();
        long count;
        int total=0;
        String difficulty = questionDTO.getDifficulty();
        Integer chapterid = questionDTO.getChapterid();
        Integer courseid = questionDTO.getCourseid();
        String key = questionDTO.getKey();

        if(!difficulty.isEmpty()&&difficulty!=null){
            System.out.println("只执行难度");
            questions = questionDao.selectByDifficulty(questionDTO).get(0);
            count = (long)questionDao.selectByDifficulty(questionDTO).get(1).get(0);
            total=(int)count;
        }else if(chapterid!=null){
            System.out.println("执行chapterid");
            questions = chapterDao.selectQuestion(chapterid);
        }else if(courseid!=null){
            System.out.println("只执行courseid");
            questions = courseDao.selectQuestion(courseid);
        }else if(!key.isEmpty()&&key!=null){
            questions = questionDao.selectByContent(questionDTO).get(0);
            count = (long)questionDao.selectByContent(questionDTO).get(1).get(0);
            total=(int)count;
        }else if(difficulty!=null&&chapterid!=null&&!difficulty.isEmpty()){
            questions = questionDao.selectByCHapterAndDifficulty(questionDTO).get(0);
            count = (long)questionDao.selectByCHapterAndDifficulty(questionDTO).get(1).get(0);
            total=(int)count;
        }else if(difficulty!=null&&courseid!=null&&!difficulty.isEmpty()){
            questions = questionDao.selectByCourseAndDifficulty(questionDTO).get(0);
            count = (long)questionDao.selectByCourseAndDifficulty(questionDTO).get(1).get(0);
            total=(int)count;
        }
        else {
            questions = questionDao.listQuestion(questionDTO).get(0);
             count=(long)questionDao.listQuestion(questionDTO).get(1).get(0);
             total=(int)count;
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
            String option1 = row.getCell(2).getStringCellValue();

            String option2 = row.getCell(3).getStringCellValue();

            String option3 = row.getCell(4).getStringCellValue();

            String option4 = row.getCell(5).getStringCellValue();

            String answer = row.getCell(6).getStringCellValue();

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
             num=questionDao.insertQuestionDTO(questionDTO1);
        }
        JsonBean jsonBean=new JsonBean();
      if (num>0){
           jsonBean= new JsonBean(200,"导入成功","");
      }
        return jsonBean;
    }
}
