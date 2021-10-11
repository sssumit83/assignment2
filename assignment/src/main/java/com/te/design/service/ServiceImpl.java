package com.te.design.service;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.design.dao.DaoImpl;
import com.te.design.dto.Student;


public class ServiceImpl implements ServiceInterface{
	Scanner scanner = new Scanner(System.in);

	@Override
	public void insert() {

		System.out.println("enter id :");
		int id = scanner.nextInt();
		System.out.println("enter name :");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("enter the course :");
		String course = scanner.nextLine();
		if((id!=0)&&(name!=null)&&(course!=null)) {
			DaoImpl daoImpl = new DaoImpl();
			daoImpl.insert(id, name, course);
		}else {
			System.err.println("please enter valid information!!!");
		}
	}

	@Override
	public void update() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter your id :");
		int id = scanner.nextInt();
		System.out.println("choose one option:");
		System.out.println("press 1 for update name");
		System.out.println("press 2 for update course");
		System.out.println("waiting for response :");
		int option = scanner.nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		switch (option) {
		case 1:
			System.out.println("enter the updated name :");
			scanner.nextLine();
			String name = scanner.nextLine();
			transaction.begin();
			Student student = manager.find(Student.class, name);
			student.setName(name);
			transaction.commit();
			System.out.println("name updated successfully!!!");
			break;
		case 2:
			System.out.println("enter the updated course :");
			scanner.nextLine();
			String course = scanner.nextLine();
			transaction.begin();
			Student student1 = manager.find(Student.class, id);
			student1.setCourse(course);
			transaction.commit();
			System.out.println("course updated successfully!!!");
		default:
			System.out.println("please enter a valid option!!!");
			break;
		}
	}

	@Override
	public void readById() {
		System.out.println("enter the id :");
		int id = scanner.nextInt();
		if(id!=0) {
			DaoImpl daoImpl = new DaoImpl();
			daoImpl.readById(id);
		}else {
			System.err.println("please the the valid input!!!");
		}
	}

	@Override
	public void readAll() {
		DaoImpl daoImpl = new DaoImpl();
		daoImpl.readAll();
	}

	@Override
	public void delete() {
		System.out.println("enter the id :");
		int id = scanner.nextInt();
		if(id!=0) {
			DaoImpl daoImpl = new DaoImpl();
			daoImpl.delete(id);
		}else {
			System.err.println("please enter the valid id number");
		}
	}
}
