package com.pj.controller;

import com.pj.service.AbstractExecutor;
import com.pj.service.impl.GameServiceImpl;
import com.pj.service.impl.MathTeacher;
import com.pj.utils.GameConstant;
import net.minidev.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created on 2019/5/14 3:09
 *
 * @author pj Deng
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    //spring的RestTemplate，它实现的是RestOperations接口
    private RestTemplate template = new RestTemplate();

    @Autowired
    private GameServiceImpl gameServiceImpl;
    @SuppressWarnings("unchecked")
    @Test
    public void printGameInfo(){

        //程序开始运行时间
        long start = System.currentTimeMillis();

        //模拟学生数量
        Integer pupilSize = 33 ;
        //模拟游戏类型
        Integer stageNo = 1 ;
        //实例化“执行者”的实现类 数学老师
        AbstractExecutor mathTeacher = new MathTeacher();
        //通过数学老师，调用启动游戏的方法
        mathTeacher.setGameService(gameServiceImpl);
        ArrayList<String> list = mathTeacher.playGame(pupilSize,stageNo);
        //打印结果
        System.out.println("......game type is:"+stageNo);
        for(int i = 1; i <= list.size() ; i++){
            System.out.println("......index:"+i+"   ......speak:"+list.get(i-1));
        }


        //程序运行结束时间
        long end = System.currentTimeMillis();

        System.out.println("程序运行时间：" + (end - start) + "ms");
    }

}