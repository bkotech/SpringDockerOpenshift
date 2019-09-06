package com.cgi.springdockeropenshift.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    private Integer id;

    private String name;

    private Integer salary;

    private String team;

}
