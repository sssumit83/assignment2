package com.te.design.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.design.dto.Student;


public class DaoImpl implements DaoInterface{

	@Override
	public void insert(int id, String name , String course) {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			Student student = new Student();
			student.setId(id);
			student.setName(name);
			student.setCourse(course);
			factory = Persistence.createEntityManagerFactory("details");
			entityManager = factory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
			factory.close();
		}
	}

	@Override
	public void update(int id) {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the name :");
		String name = scanner.nextLine();
		System.out.println("enter the course :");
		String course = scanner.nextLine();
		try {
			factory = Persistence.createEntityManagerFactory("details");
			entityManager = factory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Student student = entityManager.getReference(Student.class, id);
			student.setName(name);
			student.setCourse(course);
			entityManager.persist(student);
			entityTransaction.commit();
		} catch (Exception e) {
		}finally {
			entityManager.close();
			factory.close();
		}
	}

	@Override
	public void readById(int id) {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		try {
			factory = Persistence.createEntityManagerFactory("details");
			entityManager = factory.createEntityManager();
			Student student = entityManager.find(Student.class, id);
			System.out.println("=====================================================");
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
		} catch (Exception e) {
		}finally {
			entityManager.close();
			factory.close();
		}
	}

	@Override
	public void readAll() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		String findAll = "from Student";
		try {
			factory = Persistence.createEntityManagerFactory("details");
			entityManager = factory.createEntityManager();
			Query query = entityManager.createQuery(findAll);
			List<Student> list = query.getResultList();
			System.out.println(list);
			System.out.println("==================================");
			for (Student student : list) {
				System.out.println(student);
			}
		}finally {
			entityManager.close();
			factory.close();
		}
	}

	@Override
	public void delete(int id) {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("details");
			entityManager = factory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Student student = entityManager.getReference(Student.class, id);
			entityManager.remove(student);
			entityTransaction.commit();
		} catch (Exception e) {
		}finally {
			entityManager.close();
			factory.close();
		}
	}
}