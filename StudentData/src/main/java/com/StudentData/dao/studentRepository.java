package com.StudentData.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentData.entity.Student;

@Repository
public interface studentRepository extends JpaRepository<Student, Integer>{


}
