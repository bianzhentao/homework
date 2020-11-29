package com.kgc.ssm2020.homework1123.service;

import com.github.pagehelper.PageInfo;
import com.kgc.ssm2020.homework1123.pojo.Standard;

import java.util.List;

public interface StandardService {
    int addStandard(Standard standard);
    int delStandard(int id);
    int updateStandard(Standard standard);
    public PageInfo<Standard> selectStandards(String stand,Integer pageNum,Integer pageSize);
    int getByStdNum(String stdNum);

}
