package com.example.example.dtos;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@EqualsAndHashCode
public class AccountDto {
    private Integer id;
    private String name;
    private Double balance;

}
