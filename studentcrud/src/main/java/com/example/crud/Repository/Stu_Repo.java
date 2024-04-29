package com.example.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.Entity.Student;

@Repository
public interface Stu_Repo extends JpaRepository<Student,Integer> {

}
