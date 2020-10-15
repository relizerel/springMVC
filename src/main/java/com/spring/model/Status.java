package com.spring.model;

import org.springframework.security.core.Transient;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Transient
@Table(name = "status")
public class Status {
}
