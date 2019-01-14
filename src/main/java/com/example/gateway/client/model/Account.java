package com.example.gateway.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class Account {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    @JsonProperty("balance")
    private double balance;
    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("accountType")
    private String accountType;
}
