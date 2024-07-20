package com.javac.project.hibernateandJpa.Business;

import java.util.List;

import com.javac.project.hibernateandJpa.Entities.City;

public interface ICityService {

	List<City> getAll();

	void add(City city);

	void update(City city);

	void delete(City city);

}
