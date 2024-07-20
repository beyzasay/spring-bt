package com.javac.project.hibernateandJpa.DataAccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javac.project.hibernateandJpa.Entities.City;
import org.hibernate.Session;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class HibernateCityDal implements ICityDal {

	private EntityManager entityManager;

	@Autowired
	public HibernateCityDal(EntityManager entityManager) {

		this.entityManager = entityManager;
	}

//AOP
	@Override
	@Transactional
	public List<City> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<City> cities = session.createQuery("from City", City.class).getResultList();
		return cities;
	}

	@Override
	//if()
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);

	@Override
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);

	}

	@Override
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class);
		City cityToDelete = session.get(City.class, city.getId());
		session.delete(cityToDelete);

	}

	@Override
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);

		City city = session.get(City.class, id);
		return city;

	}
}