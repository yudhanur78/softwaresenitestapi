package com.softwaresenitest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "TRX_TRANSACTION")
public class Trax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID", nullable = false)
    private Long id;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "PARENT_ID")
    private Long parentId;
}
