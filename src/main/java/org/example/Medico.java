package org.example;

public class Medico extends HandlerAtendimento {

    @Override
    protected boolean podeAtender(TipoSolicitacao tipo) {
        return tipo == TipoSolicitacao.CONSULTA;
    }

    @Override
    protected String processar(TipoSolicitacao tipo) {
        return "Consulta realizada pelo médico";
    }
}