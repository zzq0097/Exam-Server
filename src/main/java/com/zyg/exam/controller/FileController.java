package com.zyg.exam.controller;

import com.zyg.exam.dao.AnswerDao;
import com.zyg.exam.dao.RecordDao;
import com.zyg.exam.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@Controller
public class FileController {
    @Autowired
    private RecordDao recordDao;
    @Autowired
    private AnswerDao answerDao;

    String path = "D:/";

    @RequestMapping()
    public int VideoFile(MultipartFile file,Integer recordid){
        try {
            String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String filePath = path + UUID.randomUUID().toString() + "." + type;
            InputStream is = file.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            is.close();
            fileOutputStream.close();
            output.close();

            Record record = Record.builder()
                    .recordid(recordid)
                    .grade(filePath)
                    .build();
            recordDao.updateById(record);

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    @RequestMapping()
    public int AnswerFile(MultipartFile file,Integer recordid,Integer questionid) {


        return 0;
    }
}
