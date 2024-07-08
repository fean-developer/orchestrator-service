package br.com.fean.orchestrator.domain.dtos;

import lombok.Data;

@Data
public class Customer {

    private String id;
    private String name;
    private String email;
    private String cpf;
    private String phone;

}
