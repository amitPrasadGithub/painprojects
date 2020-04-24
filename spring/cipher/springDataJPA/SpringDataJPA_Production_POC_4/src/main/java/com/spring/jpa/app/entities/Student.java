package com.spring.jpa.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="student")
@NamedQueries(
			value = {
				@NamedQuery(name="Student.findByFirstName", query="select s from Student s where s.firstName = ?1"),
				@NamedQuery(name="Student.findByLastName", query="select s from Student s where s.lastName = ?1")
			}
		)
@NamedNativeQueries(
			value = {
					@NamedNativeQuery(name="Student.findByEmail", query="select * from student_table s where s.email = ?1", resultClass=Student.class)
			}
		)
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="studentId")
	private Long studentId;
	
	@Column(name="firstName", length=60, nullable=false)
	private String firstName;
	
	@Column(name="lastName", length=60, nullable=false)
	private String lastName;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="creationDate")
	private Date creationDate;
	
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId", referencedColumnName = "studentId")
	private List<Address> address;
	
	Student() {}

	public Student(String firstName, String lastName, String email, Date creationDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creationDate = creationDate;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
}
