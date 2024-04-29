package com.example.crud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.Entity.Student;
import com.example.crud.Repository.Stu_Repo;

@Service
public class Stu_service {
	@Autowired 
    Stu_Repo repo;
	public void save(Student s) {
		// TODO Auto-generated method stub
		repo.save(s);
	}
	public List<Student> findallstudents() {
		// TODO Auto-generated method stub
		
		return repo.findAll();
	}
	public void deleteid(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	public Student findid(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

}
