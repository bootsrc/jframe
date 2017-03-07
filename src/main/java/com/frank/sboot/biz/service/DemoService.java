package com.frank.sboot.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frank.sboot.biz.dao.DemoDAO;

@Service
public class DemoService {
	@Autowired
	private DemoDAO demoDAO;

	public int updateName(int id, String name) {
		int result = demoDAO.updateName(id, name);
		return result;
	}
}
