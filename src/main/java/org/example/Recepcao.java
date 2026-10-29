package org.example;

public class Recepcao extends HandlerAtendimento {

    @Override
    protected boolean podeAtender(TipoSolicitacao tipo) {
        return tipo == TipoSolicitacao.CADASTRO;
    }

    @Override
    protected String processar(TipoSolicitacao tipo) {
        return "Cadastro realizado pela recepção";
    }
}