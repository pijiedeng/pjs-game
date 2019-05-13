package com.pj.utils;

import com.pj.model.StageCondition;

/**
 * Created on 2019/5/14 0:52
 * 游戏工具类 / utils of game service
 * @author pj Deng
 */
public class GameUtil {
    /**
     * 根据游戏类型设置游戏规则  /  set role by game type
     * @param index  学生的序号 /  index of pupil
     * @param stageNo 游戏的类型  /  type of game
     * @return   游戏规则  / role of game
     */
    public static StageCondition setStageCondition(Integer index, Integer stageNo){
        //游戏类型为1时默认规则 / set default role when type of game is 1
        StageCondition stageCondition = new StageCondition(index);
        //游戏类型为2 / type of game is 2
        if(stageNo.equals(GameConstant.STAGE_TWO) ){
            //当序号能被3整除，或者序号包含3  / index can be division by 3 or index it contains 3
            stageCondition.setCaseThree(stageCondition.isCaseThree()
                    ||(String.valueOf(index).contains("3")));
            //当序号能被5整除，或者序号包含5  / index can be division by 3 or index it contains 5
            stageCondition.setCaseFive(stageCondition.isCaseFive()
                    ||(String.valueOf(index).contains("5")));
            //当序号能被3和5整除，或者序号包含3和5  / index can be division by 3 and 5, or index it contains 3 and 5
            stageCondition.setCaseThreeAndFive((stageCondition.isCaseThree()&&stageCondition.isCaseFive())
                    ||((String.valueOf(index).contains("3"))&&(String.valueOf(index).contains("5"))));
        }
        return stageCondition;
    }
}
