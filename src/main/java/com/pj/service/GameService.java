package com.pj.service;


import java.util.ArrayList;

/**
 * Created on 2019/5/13 17:33
 * 游戏服务接口 / interface of game service
 * game interface
 * @author pj Deng
 */
public interface GameService {

    /**
     * 执行开始游戏的动作 / start game
     * @param pupilSize  学生的数量 / amount of pupil
     * @param stageNo  游戏的类型  / type of game
     * @return  学生发言集合  / collection of pupil speaking
     */
    ArrayList<String> playGame(Integer pupilSize, Integer stageNo);

}
