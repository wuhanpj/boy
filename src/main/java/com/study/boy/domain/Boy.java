package com.study.boy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Boy {
	@Id
	@GeneratedValue
	private Integer id;
	//姓名
	@NotNull(message="姓名必填")
	private String name;
	//年龄
	@Min(value=16, message="年龄必须大于15岁")
	@NotNull(message="年龄必填")
	private Integer age;
	//身高
	private double high;
	//体重
	private double weight;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}	
}
