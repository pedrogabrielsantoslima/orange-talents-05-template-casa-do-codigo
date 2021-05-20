package br.com.zup.pedro.casadocodigo.response;

public class ErroDeValidacaoResponse {

    private String campo;
    private String mensagem;

    public ErroDeValidacaoResponse(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}