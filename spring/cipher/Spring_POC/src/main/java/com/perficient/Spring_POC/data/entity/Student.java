package com.perficient.Spring_POC.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
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
                @NamedNativeQuery(name="Student.findByEmail", query="select * from student s where s.email = ?1", resultClass=Student.class)
        }
)
public class Student {
    @Id
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
}