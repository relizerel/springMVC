package com.spring.model;

import org.springframework.security.core.Transient;

import javax.persistence.Entity;
import javax.persistence.Table;

@Transient
//manyToMany
@Entity
@Table(name = "role")
public class Role {
}
