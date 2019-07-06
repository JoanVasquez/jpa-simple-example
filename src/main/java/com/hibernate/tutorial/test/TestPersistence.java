package com.hibernate.tutorial.test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hibernate.tutorial.models.Address;
import com.hibernate.tutorial.models.Author;
import com.hibernate.tutorial.models.Book;
import com.hibernate.tutorial.models.Employee;

public class TestPersistence {

	private EntityManager em;
	private EntityManagerFactory emf;

	public TestPersistence() {
		emf = Persistence.createEntityManagerFactory("Persistence");
	}

	public static void main(String args[]) {

		TestPersistence testPersistence = new TestPersistence();

		/*
		 * Employee e = new Employee(1L, "Vasquez", "Joan", LocalDate.of(1988, 04, 14));
		 * e.setAddress(new Address(1L, "My House", "Somewhere", "Dom Rep",
		 * "Somewhere"));
		 * 
		 * em.getTransaction().begin();
		 * 
		 * em.persist(e);
		 * 
		 * em.getTransaction().commit();
		 * 
		 * printEmployees();
		 */
		testPersistence.createEntity();
		testPersistence.printEntities();
	}

	private void createEntity() {
		em = emf.createEntityManager();

		em.getTransaction().begin();

		Author autor1 = new Author(1L, "Pablo Perez", "Espanola");
		Author autor2 = new Author(2L, "Elena Gomez", "Mexina");
		Author autor3 = new Author(3L, "Miguel Lopez", "Chilena");

		em.persist(autor1);
		em.persist(autor2);
		em.persist(autor3);

		em.persist(new Book(1L, "Programar en Java Es Facil", autor2));
		em.persist(new Book(2L, "Como vestirse con estilo", autor3));
		em.persist(new Book(3L, "Como cocinar sin quemar la cocina", autor1));
		em.persist(new Book(4L, "Programar en cobol es divertido", autor2));
		em.persist(new Book(5L, "Programar en cobol no es divertido", autor2));

		em.getTransaction().commit();

		em.close();
	}

	@SuppressWarnings("unchecked")
	private void printEntities() {
		em = emf.createEntityManager();

		List<Author> authors = (List<Author>) em.createQuery("FROM Author").getResultList();
		authors.forEach(item -> System.out.println(item.toString()));

		List<Book> books = (List<Book>) em.createQuery("FROM Book").getResultList();
		books.forEach(item -> System.out.println(item.toString()));

		em.close();

		// List<Employee> employees = (List<Employee>) em.createQuery("FROM
		// Employee").getResultList();

		// System.out.println("Amount of employees " + employees.size());

		// employees.forEach(employee -> System.out.println(employee.toString()));
	}

}
