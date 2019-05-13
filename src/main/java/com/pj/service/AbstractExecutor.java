package com.pj.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created on 2019/5/13 18:01
 * 游戏执行者抽象类 / game executor abstraction
 * @author pj Deng
 */
public abstract class AbstractExecutor {


    /**
     * 注入游戏服务接口  / inject interface of game service
     */
    @Autowired
    public  GameService gameService;

    public void setGameService(GameService gameService){
        this.gameService = gameService;
    }

    /**
     * 执行开始游戏的动作 / start game
     * @param pupilSize  学生的数量 / amount of pupil
     * @param stageNo  游戏的类型  / type of game
     * @return  学生发言集合  / collection of pupil speaking
     */
    public abstract ArrayList<String> playGame(Integer pupilSize , Integer stageNo);

}
