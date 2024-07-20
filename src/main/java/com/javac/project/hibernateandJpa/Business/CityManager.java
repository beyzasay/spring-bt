package com.javac.project.hibernateandJpa.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javac.project.hibernateandJpa.DataAccess.ICityDal;
import com.javac.project.hibernateandJpa.Entities.City;

import jakarta.transaction.Transactional;

@Service
public class CityManager implements ICityService {

	private ICityDal cityDal;

	@Autowired
	public CityManager(ICityDal cityDal) {

		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> getAll() {

		return this.cityDal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		// business
		this.cityDal.add(city);

	}

	@Override
	@Transactional
	public void update(City city) {
		this.cityDal.update(city);

	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDal.delete(city);

	}

	public City getById(int id) {
		return this.cityDal.getById(id);

	}

}
