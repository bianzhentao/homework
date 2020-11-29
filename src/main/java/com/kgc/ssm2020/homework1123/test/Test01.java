package com.kgc.ssm2020.homework1123.test;

import com.github.pagehelper.PageInfo;
import com.kgc.ssm2020.homework1123.pojo.Standard;
import com.kgc.ssm2020.homework1123.service.StandardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class Test01 {
    @Resource
    StandardService standardService;
    @Test
    public void test01(){
//        PageInfo<Standard> pageInfo = standardService.selectStandards("范", 2, 2);
//        System.out.println(pageInfo);
    }
}
