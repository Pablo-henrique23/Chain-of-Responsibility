package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandlerAtendimentoTest {

    private HandlerAtendimento cadeia;

    @BeforeEach
    void configurarCadeia() {

        Recepcao recepcao = new Recepcao();
        Enfermagem enfermagem = new Enfermagem();
        Medico medico = new Medico();

        recepcao.setProximo(enfermagem);
        enfermagem.setProximo(medico);

        cadeia = recepcao;
    }

    @Test
    void deveRealizarCadastro() {
        assertEquals(
                "Cadastro realizado pela recepção",
                cadeia.atender(TipoSolicitacao.CADASTRO)
        );
    }

    @Test
    void deveRealizarTriagem() {
        assertEquals(
                "Triagem realizada pela enfermagem",
                cadeia.atender(TipoSolicitacao.TRIAGEM)
        );
    }

    @Test
    void deveRealizarConsulta() {
        assertEquals(
                "Consulta realizada pelo médico",
                cadeia.atender(TipoSolicitacao.CONSULTA)
        );
    }

    @Test
    void deveLancarExcecaoQuandoNaoExisteResponsavel() {

        Recepcao recepcao = new Recepcao();

        assertThrows(
                IllegalArgumentException.class,
                () -> recepcao.atender(TipoSolicitacao.CONSULTA)
        );
    }

    @Test
    void devePermitirAlterarCadeia() {

        Recepcao recepcao = new Recepcao();
        Medico medico = new Medico();

        recepcao.setProximo(medico);

        assertEquals(
                "Consulta realizada pelo médico",
                recepcao.atender(TipoSolicitacao.CONSULTA)
        );
    }
}