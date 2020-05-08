package com.perficient.Spring_POC.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    @Id
    @Column(name="addressId")
    private Long addressId;

    @Column(name="area", length=60)
    private String area;

    @Column(name="city", length=60)
    private String city;

    @Column(name="state", length=60)
    private String state;

    @Column(name="country", length=60)
    private String country;
}