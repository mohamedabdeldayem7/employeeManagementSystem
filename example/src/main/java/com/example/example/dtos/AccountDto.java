package com.example.example.dtos;

import lombok.*;

//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter(AccessLevel.PUBLIC)
//@Setter(AccessLevel.PUBLIC)
//@EqualsAndHashCode
public class AccountDto {
    private Integer id;
    private String name;
    private Double balance;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    public AccountDto() {
    }

    public AccountDto(Integer id, String name, Double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
}
