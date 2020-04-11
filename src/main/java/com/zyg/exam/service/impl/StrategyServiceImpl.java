package com.zyg.exam.service.impl;

import com.zyg.exam.common.AllRandom;
import com.zyg.exam.common.DTO.AddPaperDTO;
import com.zyg.exam.common.DTO.StrategyDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.dao.ConditionDao;
import com.zyg.exam.dao.PaperDao;
import com.zyg.exam.dao.QuestionDao;
import com.zyg.exam.dao.StrategyDao;
import com.zyg.exam.model.Condition;
import com.zyg.exam.model.Paper;
import com.zyg.exam.model.Strategy;
import com.zyg.exam.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

@Service
public class StrategyServiceImpl extends  AllRandom implements StrategyService {
    @Autowired
    private StrategyDao strategyDao;
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private ConditionDao conditionDao;

    @Override
    public JsonBean insertStrategy(Strategy strategy) {
        int num = strategyDao.insertSelective(strategy);
        if (num>0){
            return new JsonBean(200,null,"添加成功");
        }else {
            return new JsonBean(500,null,"添加失败");
        }
    }

    @Override
    public JsonBean formPaper(AddPaperDTO addPaperDTO) {
        System.out.println(addPaperDTO);
//        AllRandom allRandom = new AllRandom();
        Paper paper = new Paper();
        paper.setCourseid(addPaperDTO.getCourseid());
        paper.setFinishtime(addPaperDTO.getFinishtime());
        paper.setIsmonitor(addPaperDTO.getIsmonitor());
        paper.setPattern(addPaperDTO.getPattern());
        paper.setStarttime(addPaperDTO.getStarttime());

        int num = paperDao.insertSelective(paper);

        //全随机
        if (addPaperDTO.getMode()==1){
            int selectNum=15;
            int fillNum=10;
            int judgeNum=10;
            int quesNum=4;
            List<Integer> selects = questionDao.selectByType("选择");
            List<Integer> fills = questionDao.selectByType("填空");
            List<Integer> judges = questionDao.selectByType("判断");
            List<Integer> ques = questionDao.selectByType("简答");

            //随机后的结果

            List<Integer> selects1= this.randomQuestion(selects,selectNum);
            List<Integer> fill1 = this.randomQuestion(fills,fillNum);
            List<Integer> judge1 = this.randomQuestion(judges,judgeNum);
            List<Integer> ques1 = this.randomQuestion(ques,quesNum);

            List<List<Integer>> lists = new ArrayList<>();
            lists.add(selects1);
            lists.add(fill1);
            lists.add(judge1);
            lists.add(ques1);
            this.insertPaperQuestion(lists,paper.getPaperid());

        }else if (addPaperDTO.getMode()==2){//部分随机
            List<List<Integer>> lists = new ArrayList<>();
            for (StrategyDTO strategy:addPaperDTO.getStrategyDTOS()) {
                Strategy strategy1=new Strategy();
                strategy1.setCount(strategy.getCount());
                strategy1.setPaperid(paper.getPaperid());
                strategy1.setType(strategy.getType());
                strategy1.setValue(strategy.getScore());

                strategyDao.insertSelective(strategy1);

                int strategyid=strategy1.getStrategyid();

                Condition condition =new Condition();
                condition.setChapterid(strategy.getChapterid());
                condition.setCount(strategy.getCount());
                condition.setDifficulty(strategy.getDifficulty());
                condition.setStrategyid(strategyid);

                conditionDao.insertSelective(condition);
                System.out.println(strategy.getType());
                System.out.println(strategy.getCount());
                List<Integer> questionid = questionDao.selectByChapter(strategy.getDifficulty(),strategy.getChapterid(),strategy.getType());



                List<Integer> question = this.randomQuestion(questionid,strategy.getCount());

                lists.add(question);

            }
            this.insertPaperQuestion(lists,paper.getPaperid());


        }else if (addPaperDTO.getMode()==3){//手动组卷
            int[] questionids = addPaperDTO.getQuestionids();
            for (int i=0;i<questionids.length;i++){
                paperDao.insertPaperQuestion(questionids[i],paper.getPaperid());
            }

        }
        return null;
    }
}
