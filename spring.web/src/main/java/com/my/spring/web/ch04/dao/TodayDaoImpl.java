package com.my.spring.web.ch04.dao;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.spring.web.ch04.dao.map.TodayMap;

@Repository // Repository layer 입니다. 라고 표현하려고 이 annotation을 정의했다.
public class TodayDaoImpl implements TodayDao {
	@Autowired private TodayMap todayMap;
	
	@Override
	public LocalDate selectToday() {
		return todayMap.selectToday();
	}
}
