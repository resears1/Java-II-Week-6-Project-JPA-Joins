package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.District;

public class DistrictHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PetCatalog");

	public void insertDistrict(District d) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<District> showAllDistricts() {
		EntityManager em = emfactory.createEntityManager();
		List<District> allDistricts = em.createQuery("SELECT d FROM District d").getResultList();
		return allDistricts;
	}
}
