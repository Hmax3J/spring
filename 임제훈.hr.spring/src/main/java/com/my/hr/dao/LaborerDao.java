package com.my.hr.dao;

import java.util.List;

import com.my.hr.domain.Laborer;

public interface LaborerDao {
	List<Laborer> selectLaborers();
	Laborer selectLaborer(int laborerId);
	void insertLaborer(Laborer laborer);
	void updateLaborer(Laborer laborer);
	void deleteLaborer(int laborerId);
}