package com.nikhil.RecaptchaValidation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
	private String name;
	private Double salary;
	private String address;

    public Integer getId() {
		return id;
	}

}
