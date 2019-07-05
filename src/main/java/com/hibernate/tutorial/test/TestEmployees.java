package com.hibernate.tutorial.test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hibernate.tutorial.models.Employee;

public class TestEmployees {

	private static EntityManager em;
	private static EntityManagerFactory emf;

	public static void main(String args[]) {

		emf = Persistence.createEntityManagerFactory("Persistence");
		em = emf.createEntityManager();

		Employee e = new Employee(1L, "Vasquez", "Joan", LocalDate.of(1988, 04, 14));

		em.getTransaction().begin();

		em.persist(e);

		em.getTransaction().commit();

		printEmployees();
	}

	@SuppressWarnings("unchecked")
	private static void printEmployees() {
		List<Employee> employees = (List<Employee>) em.createQuery("FROM Employee").getResultList();

		System.out.println("Amount of employees " + employees.size());

		employees.forEach(employee -> System.out.println(employee.toString()));
	}

}
