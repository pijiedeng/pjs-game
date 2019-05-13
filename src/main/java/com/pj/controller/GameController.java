package com.pj.controller;

import com.pj.service.AbstractExecutor;
import com.pj.service.GameService;
import com.pj.service.impl.MathTeacher;
import com.pj.utils.GameConstant;
import com.pj.utils.RespResult;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;

/**
 * Created on 2019/5/12 10:32
 * 游戏服务对外接口  /  outer restful interface of game service
 * @author pj Deng
 */
@RestController
@RequestMapping(value = "/game")
public class GameController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 注入游戏服务接口  / inject game service interface
     */
    @Autowired
    private GameService gameServiceImpl;
    /**
     * 启动游戏 / start game
     * @param pupilSize 学生数量  /  amount of pupil
     * @param stageNo 游戏的类型  /  type of game
     * @return  学生发言集合  / collection of pupil speaking
     */
    @ApiOperation(value = "启动游戏 / start game", notes = "启动游戏 / start game")
    @RequestMapping(value = "/start" ,method = RequestMethod.GET)
    public RespResult<ArrayList<String>> printGameInfo(
            @RequestParam(value = "pupilSize")Integer pupilSize,
            @RequestParam(value = "stageNo")Integer stageNo
    ){
        //使用桥接模式，将执行者，执行动作的抽象与实现分离，增强代码扩展性
        AbstractExecutor mathTeacher = new MathTeacher();
        mathTeacher.setGameService(gameServiceImpl);
        ArrayList<String> list = mathTeacher.playGame((pupilSize==null? GameConstant.PUPIL_SIZE :pupilSize),(stageNo==null?GameConstant.STAGE_ONE:stageNo));
        if (list.isEmpty()){
            logger.info("no found......");
            return new RespResult<>(HttpStatus.NOT_FOUND);
        }else {
            return new RespResult<>(list);
        }
    }

}
