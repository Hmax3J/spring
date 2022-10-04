package com.my.hr.service;

import java.util.List;

import com.my.hr.domain.Laborer;

public interface LaborerService {
	List<Laborer> getLaborers();
	void addLaborer(Laborer laborer);
	void fixLaborer(Laborer laborer);
	void delLaborer(int laborerId);
}