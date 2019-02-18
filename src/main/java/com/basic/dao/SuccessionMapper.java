package com.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.basic.bean.Succession;

public interface SuccessionMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Succession record);

    Succession selectByPrimaryKey(Integer id);

    List<Succession> selectAll();

    int updateByPrimaryKey(Succession record);

    @Select("select * from succession")
	List<Succession> getAll();
}