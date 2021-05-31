package br.com.zup.pedro.casadocodigo.response;

import br.com.zup.pedro.casadocodigo.model.Cliente;
import br.com.zup.pedro.casadocodigo.request.ClienteRequest;

public class ClienteResponse extends ClienteRequest {

    private Integer id;

    public ClienteResponse(String nome, String sobrenome, String email, String cpf_cnpj, String endereco,
                           String complemento, String cidade, Integer idPais, Integer idEstados, Integer telefone, Integer cep) {

        super(nome, sobrenome, email, cpf_cnpj, endereco, complemento, cidade, idPais, idEstados, telefone, cep);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static ClienteResponse converterDe(Cliente cliente) {
        final ClienteResponse clienteResponse = new ClienteResponse(cliente.getNome(), cliente.getSobrenome(), cliente.getEmail(),
                cliente.getCpf_cnpj(), cliente.getEndereco(), cliente.getComplemento(), cliente.getCidade(),
                cliente.getPais().getId(), cliente.getEstados().getId(), cliente.getTelefone(), cliente.getCep());

        clienteResponse.id = cliente.getId();

        return clienteResponse;
    }
}
