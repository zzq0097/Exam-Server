package com.zyg.exam.common;

import com.zyg.exam.dao.PaperDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Slf4j

public class AllRandom  {

@Autowired
private PaperDao paperDao;




    public static List<Integer> randomQuestion(List<Integer> list,int n){
        System.out.println("listSize"+list.size());
        //把随机取得的数据存储在 listRandom 中
        List<Integer> listRandom = new ArrayList<Integer>();
        if (list.size()-1>0) {
            //随机取出n条不重复的数据,这里我设置随机取3条数据
            for (int i = n; i >= 1; i--) {
                Random random = new Random();
                Math.random();
                //在数组大小之间产生一个随机数 j
                int j = random.nextInt(list.size() - 1);
                //取得list 中下标为j 的数据存储到 listRandom 中
                listRandom.add(list.get(j));
                //把已取到的数据移除,避免下次再次取到出现重复
                list.remove(j);
            }
        }
        return listRandom;
    }
    public void insertPaperQuestion(List<List<Integer>> list,Integer paperid){

        for (int i=0;i<list.size();i++){
            for (int n=0;n<list.get(i).size();n++){
                System.out.println(list.get(i).get(n)+"  "+paperid);
                paperDao.insertPaperQuestion(list.get(i).get(n),paperid);
            }
        }
    }

}
