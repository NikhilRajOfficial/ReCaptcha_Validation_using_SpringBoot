package com.nikhil.RecaptchaValidation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.RecaptchaValidation.entity.Student;

public interface StudentRepo extends JpaRepository<Student , Integer> {

}
