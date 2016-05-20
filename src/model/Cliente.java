package model;

/**
 * Classe base para gerar objetos do tipo Cliente
 * @author Eduana Carvalho
 * @since 11/05/2016
 */
public class Cliente {
    private String nome;
    private String cpf;
    private float renda;
    private boolean ativo;
    
    public Cliente(){
        
    }

    public Cliente(String nome, String cpf, float renda, boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.renda = renda;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getRenda() {
        return renda;
    }

    public void setRenda(float renda) {
        this.renda = renda;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
}