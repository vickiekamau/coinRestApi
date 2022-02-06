package com.jokam.code.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Bitcoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String usd;

}
