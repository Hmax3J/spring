package com.my.spring.web.ch04.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.web.ch04.dao.TodayDao;

@Service // service layer를 나타내기 위해 service annotation로 정의했다.
public class TodayServiceImpl implements TodayService {
	@Autowired private TodayDao todayDao;
	
	@Override
	public LocalDate getToday() {
		return todayDao.selectToday();
	}
}
