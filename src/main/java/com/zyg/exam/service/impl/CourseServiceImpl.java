package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.ChapterDTO;
import com.zyg.exam.common.DTO.CourseDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.common.VO.CourseVO;
import com.zyg.exam.common.VO.UserVO;
import com.zyg.exam.dao.CourseDao;
import com.zyg.exam.exception.MyException;
import com.zyg.exam.model.Course;
import com.zyg.exam.service.CourseService;
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
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public ResVO listCourse(CourseDTO courseDTO) {
        List<Object> courses = courseDao.listCourse(courseDTO).get(0);
        int total = (int)courseDao.listCourse(courseDTO).get(1).get(0);
        return new ResVO(courses,total);
    }

    @Override
    public JsonBean insertCourse(Course course) {
        int num = courseDao.insertSelective(course);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"添加成功",null);
        }else {
            return new JsonBean(500,"添加失败",null);
        }
    }

    @Override
    public JsonBean updateCourse(Course course) {
        int num = courseDao.updateByPrimaryKeySelective(course);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"修改成功",null);
        }else {
            return new JsonBean(500,"修改失败",null);
        }
    }

    @Override
    public JsonBean deleteCourse(int[] courseids) {
        return new JsonBean(200,"删除了"+courseDao.deleteByPrimaryKey(courseids)+"条数据",null);
    }

    @Override
    public ResVO selectChapter(ChapterDTO chapterDTO) {
        List<Object> chapters=courseDao.selectChapter(chapterDTO).get(0);
        long count = (long)courseDao.selectChapter(chapterDTO).get(1).get(0);
        return new ResVO(chapters,count);
    }

    @Override
    public JsonBean selectQuestion(Integer courseid) {
        List<Object> questions = courseDao.selectQuestion(courseid);
        if (questions.size()>0){
            return new JsonBean(HttpStatus.OK.value(),"",questions);
        }else {
            return new JsonBean(500,"没有相关信息",null);
        }
    }

    @Override
    public JsonBean batchImport(String fileName, MultipartFile file) throws Exception {
//        boolean notNull = false;
//        List<CourseVO> courseVOS = new ArrayList();
//        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
//            throw new MyException(500,"上传文件格式不正确");
//        }
//        boolean isExcel2003 = true;
//        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
//            isExcel2003 = false;
//        }
//        InputStream is = file.getInputStream();
//        Workbook wb = null;
//        if (isExcel2003) {
//            wb = new HSSFWorkbook(is);
//        } else {
//            wb = new XSSFWorkbook(is);
//        }
//        Sheet sheet = wb.getSheetAt(0);
//        if(sheet!=null){
//            notNull = true;
//        }
//        CourseVO courseVO;
//        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
//            Row row = sheet.getRow(r);
//            if (row == null){
//                continue;
//            }
//
//            courseVO=new CourseVO();
//
//            if( row.getCell(0).getCellType() !=1){
//                throw new MyException(500,"导入失败(第"+(r+1)+"行,题目类型请设为文本格式)");
//            }
//            String coursename = row.getCell(0).getStringCellValue();
//
//            if(coursename == null || coursename.isEmpty()){
//                throw new MyException(500,"导入失败(第"+(r+1)+"行,工号未填写)");
//            }
//
//            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
//
//            String name = row.getCell(1).getStringCellValue();
//            if(name==null || name.isEmpty()){
//                throw new MyException(500,"导入失败(第"+(r+1)+"行,题目内容未填写)");
//            }
//
//
//
//           courseVO.setCoursename(coursename);
//            courseVO.setName(name);
//
//
//
//
//            courseVOS.add(courseVO);
//            System.out.println(courseVO);
//        }
//        int num=0;
//
//        for (CourseVO courseVO1 : courseVOS) {
//            System.out.println(courseVO1);
//            num=courseDao.importCourse(courseVO1);
//        }
//        JsonBean jsonBean=new JsonBean();
//        if (num>0){
//            jsonBean= new JsonBean(200,"导入成功","");
//        }
//        return jsonBean;
        return null;
    }
}
