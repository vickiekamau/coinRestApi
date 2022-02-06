package com.jokam.code.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    Bitcoin bitcoin;


    public Coin(){}





}
