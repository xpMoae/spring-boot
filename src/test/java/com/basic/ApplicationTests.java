package com.basic;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.basic.bean.Succession;
import com.basic.dao.SuccessionMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired private SuccessionMapper mapper;
	
	@Test
	public void contextLoads() {
		List<Succession> result = mapper.getAll();
		
		for (Succession succession : result) {
			System.out.println(succession.toString());
		}
		
	}

}
