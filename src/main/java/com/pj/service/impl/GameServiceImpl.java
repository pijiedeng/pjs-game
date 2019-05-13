package com.pj.service.impl;

import com.pj.model.Pupil;
import com.pj.model.StageCondition;
import com.pj.service.GameService;
import com.pj.utils.GameUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created on 2019/5/13 23:25
 * 游戏服务接口实现类 / Game Service Interface Implementation
 * @author pj Deng
 */
@Service
public class GameServiceImpl implements GameService {

    @Override
    public ArrayList<String> playGame(Integer pupilSize, Integer stageNo) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 1 ; i <= pupilSize ; i++){
            list.add(this.initPupil(i,stageNo).getSpeakWords());
        }
        return list;
    }

    /**
     * 给单个学生赋值  /  set info for single pupil
     * @param index  学生的序号 /  index of pupil
     * @param stageNo 游戏的类型  /  type of game
     * @return   单个学生信息  / info for single pupil
     */
    public Pupil initPupil(Integer index, Integer stageNo){
        StageCondition stageCondition = GameUtil.setStageCondition(index, stageNo);
        if(stageCondition.isCaseThreeAndFive()){
            return new Pupil(index,"FizzBuzz");
        }else if(stageCondition.isCaseThree() || stageCondition.isCaseFive()){
            if(stageCondition.isCaseThree()){
                return new Pupil(index,"Fizz");
            }else {
                return new Pupil(index,"Buzz");
            }
        }else {
            return new Pupil(index, String.valueOf(index));
        }
    }

}
