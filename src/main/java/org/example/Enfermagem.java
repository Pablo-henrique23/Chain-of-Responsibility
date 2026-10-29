package org.example;

public class Enfermagem extends HandlerAtendimento {

    @Override
    protected boolean podeAtender(TipoSolicitacao tipo) {
        return tipo == TipoSolicitacao.TRIAGEM;
    }

    @Override
    protected String processar(TipoSolicitacao tipo) {
        return "Triagem realizada pela enfermagem";
    }
}