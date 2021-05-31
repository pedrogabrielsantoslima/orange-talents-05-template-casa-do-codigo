package br.com.zup.pedro.casadocodigo.request;

import br.com.zup.pedro.casadocodigo.model.Cliente;
import br.com.zup.pedro.casadocodigo.model.Estados;
import br.com.zup.pedro.casadocodigo.model.Pais;
import br.com.zup.pedro.casadocodigo.validator.CPFOrCNPJ;
import br.com.zup.pedro.casadocodigo.validator.ExistsId;
import br.com.zup.pedro.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O sobrenome é obrigatório")
    private String sobrenome;

    @UniqueValue(fieldName = "email", model = Cliente.class)
    @Email
    private String email;

    @UniqueValue(fieldName = "cpf_cnpj", model = Cliente.class)
    @CPFOrCNPJ
    private String cpf_cnpj;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "O complemento é obrigatório")
    private String complemento;

    @NotBlank(message = "A cidade é obrigatório")
    private String cidade;

    @NotNull(message = "O país é obrigatório")
    @ExistsId(fieldName = "id", model = Pais.class)
    private Integer idPais;

    @NotNull(message = "O estado é obrigatório")
    @ExistsId(fieldName = "id", model = Estados.class)
    private Integer idEstados;

    @NotNull(message = "O telefone é obrigatório")
    private Integer telefone;

    @NotNull(message = "O cep é obrigatório")
    private Integer cep;

    public ClienteRequest(String nome, String sobrenome, String email, String cpf_cnpj, String endereco,
                          String complemento, String cidade, Integer idPais, Integer idEstados, Integer telefone, Integer cep) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstados = idEstados;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public Integer getIdEstados() {
        return idEstados;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public Integer getCep() {
        return cep;
    }

    public Cliente toModel() {
        Pais pais = new Pais(idPais);
        Estados estados = new Estados(idEstados);

        return new Cliente(nome, sobrenome, email, cpf_cnpj, endereco, complemento, cidade, pais, estados, telefone, cep);
    }
}
