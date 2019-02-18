package com.basic.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.basic.bean.Succession;
import com.basic.dao.SuccessionMapper;
import com.basic.service.SuccessionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class SuccessionServiceImpl implements SuccessionService{

	@Autowired
	private SuccessionMapper mapper;
	
	@Override
	public PageInfo<Succession> getAll() {
		PageHelper.startPage(2, 3);
		List<Succession> result = mapper.selectAll();
		PageInfo<Succession> info = new PageInfo<>(result,8);
		return info;
	}
	
	@Override
	public void testTransactional() {
		Succession succ = new Succession();
		for (int i = 0; i < 10; i++) {
			if(i==5) {
				throw new NullPointerException();
			}
			succ.setId(i);
			succ.setType(i+10);
			succ.setCount(i*100);
			mapper.insert(succ);
		}
	}

}
