package com.frank.sboot.biz.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface DemoDAO {
	int updateName(@Param("id") int id, @Param("name") String name);
}
