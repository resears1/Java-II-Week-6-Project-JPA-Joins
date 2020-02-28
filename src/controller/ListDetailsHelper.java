package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;

public class ListDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PetCatalog");

	public void insertNewListDetails(ListDetails d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListDetails> showAllDistricts() {
		EntityManager em = emfactory.createEntityManager();
		List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteItem(ListDetails listToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDetails> typedQuery = em.createQuery("select d from ListDetails d where d.id = :selectedId",ListDetails.class);

		typedQuery.setParameter("selectedId", listToDelete.getId());
		typedQuery.setMaxResults(1);

		ListDetails result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public ListDetails searchForListById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListDetails found = em.find(ListDetails.class, tempId);
		em.close();
		return found;
	}
}
