package com.te.design.dao;

public interface DaoInterface {
	void insert(int id, String name , String course);
	void update(int id);
	void readById(int id);
	void readAll();
	void delete(int id);
}
