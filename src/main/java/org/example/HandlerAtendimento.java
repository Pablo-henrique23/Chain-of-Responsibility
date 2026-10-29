package org.example;

public abstract class HandlerAtendimento {

    protected HandlerAtendimento proximo;

    public void setProximo(HandlerAtendimento proximo) {
        this.proximo = proximo;
    }

    public String atender(TipoSolicitacao tipo) {

        if (podeAtender(tipo)) {
            return processar(tipo);
        }

        if (proximo != null) {
            return proximo.atender(tipo);
        }

        throw new IllegalArgumentException(
                "Nenhum setor pode atender a solicitação"
        );
    }

    protected abstract boolean podeAtender(TipoSolicitacao tipo);

    protected abstract String processar(TipoSolicitacao tipo);
}