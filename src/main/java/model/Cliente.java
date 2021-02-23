package model;

import java.time.LocalDate;

public class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private LocalDate dtNasc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    public Cliente(String nome, String cpf, String email, LocalDate dtNasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dtNasc = dtNasc;

    }


}
