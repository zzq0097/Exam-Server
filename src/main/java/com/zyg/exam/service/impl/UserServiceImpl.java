package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.UserDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.common.VO.QuestionVO;
import com.zyg.exam.common.VO.UserVO;
import com.zyg.exam.dao.UserDao;
import com.zyg.exam.exception.MyException;
import com.zyg.exam.model.User;
import com.zyg.exam.service.UserService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public JsonBean isLogin(String username, String password) {
        List<User> user = userDao.login(username,password);
        if ( user.size() == 1){
            Map<String,String> map = new HashMap<>();
            map.put("name",user.get(0).getName());
            map.put("role",user.get(0).getRole());
            return new JsonBean(200,"登录成功",map);
        }else {
            return new JsonBean(502,"登录失败",null);
        }
    }

    @Override
    public JsonBean updateUser(User user) {
        int num=userDao.updateByPrimaryKeySelective(user);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"更新成功",null);
        }else {
            return new JsonBean(500,"更新失败",null);
        }
    }

    @Override
    public JsonBean deleteUser(int[] ids) {
        return new JsonBean(200,"删除了"+userDao.deleteByPrimaryKey(ids)+"条数据",null);
    }

    @Override
    public JsonBean insertUser(User user) {
        int num = userDao.insertSelective(user);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"插入成功",null);
        }else {
            return new JsonBean(500,"插入失败",null);
        }
    }

    @Override
    public ResVO selectUser(UserDTO userDTO) {
        List<Object> users = userDao.selectUser(userDTO).get(0);
        long count = (long)userDao.selectUser(userDTO).get(1).get(0);
        return new ResVO(users,count);
    }

    @Override
    public List<String> selectCourse(int id) {
        return userDao.selectCourse(id);
    }

    @Override
    public JsonBean batchImport(String fileName, MultipartFile file) throws Exception {
        boolean notNull = false;
        List<UserVO> userVOS = new ArrayList();
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
        UserVO userVO;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }

            userVO = new UserVO();

            if( row.getCell(0).getCellType() !=1){
                throw new MyException(500,"导入失败(第"+(r+1)+"行,工号请设为文本格式)");
            }
            String username = row.getCell(0).getStringCellValue();

            if(username == null || username.isEmpty()){
                throw new MyException(500,"导入失败(第"+(r+1)+"行,工号未填写)");
            }

            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            String password = row.getCell(1).getStringCellValue();
            if(password==null || password.isEmpty()){
                throw new MyException(500,"导入失败(第"+(r+1)+"行,密码未填写)");
            }

            row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
            String name = row.getCell(1).getStringCellValue();
            if(name==null || name.isEmpty()){
                throw new MyException(500,"导入失败(第"+(r+1)+"行,姓名未填写)");
            }

            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
            String tel = row.getCell(3).getStringCellValue();
            if(password==null || password.isEmpty()){
                throw new MyException(500,"导入失败(第"+(r+1)+"行,电话未填写)");
            }

            row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
            String role = row.getCell(1).getStringCellValue();
            if(password==null || password.isEmpty()){
                throw new MyException(500,"导入失败(第"+(r+1)+"行,角色未填写)");
            }

            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
            String classname = row.getCell(1).getStringCellValue();
            if(classname==null || classname.isEmpty()){
                throw new MyException(500,"导入失败(第"+(r+1)+"行,班级未填写)");
            }



            userVO.setUsername(username);
            userVO.setPassword(password);
            userVO.setName(name);
            userVO.setTel(tel);
            userVO.setRole(role);
            userVO.setClassname(classname);



            System.out.println(userVO);
        }
        int num=0;

        for (UserVO userVO1 : userVOS) {
            System.out.println(userVO1);
            num=userDao.importUser(userVO1);
        }
        JsonBean jsonBean=new JsonBean();
        if (num>0){
            jsonBean= new JsonBean(200,"导入成功","");
        }
        return jsonBean;
    }

}
