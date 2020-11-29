package com.kgc.ssm2020.homework1123.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.ssm2020.homework1123.mapper.StandardMapper;
import com.kgc.ssm2020.homework1123.pojo.Standard;
import com.kgc.ssm2020.homework1123.pojo.StandardExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StandardServiceImpl implements StandardService{
    @Resource
    StandardMapper standardMapper;



    @Override
    public int addStandard(Standard standard) {
        return standardMapper.insertSelective(standard);
    }

    @Override
    public int delStandard(int id) {
        return standardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateStandard(Standard standard) {
        return standardMapper.updateByPrimaryKeySelective(standard);
    }

    @Override
    public PageInfo<Standard> selectStandards(String stand, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("std_num");
        StandardExample example=new StandardExample();
        example.createCriteria().andStdNumLike("%"+stand+"%");
        StandardExample.Criteria criteria = example.createCriteria();
        criteria.andZhnameLike("%" + stand + "%");
        example.or(criteria);
        List<Standard> list=standardMapper.selectByExample(example);
        PageInfo<Standard> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int getByStdNum(String stdNum) {
        StandardExample example=new StandardExample();
        example.createCriteria().andStdNumEqualTo(stdNum);
        return standardMapper.countByExample(example);
    }
}
