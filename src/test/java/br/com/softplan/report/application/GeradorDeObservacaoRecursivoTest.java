package br.com.softplan.report.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(SubstituirCamelCase.class)
public class GeradorDeObservacaoRecursivoTest {

    private GeradorDeObservacaoRecursivo geradorDeObservacaoRecursivo;

    @BeforeEach
    public void setUp() {
        geradorDeObservacaoRecursivo = new GeradorDeObservacaoRecursivo();
    }

    @Test
    public void deveGerarObservacaoSemNota() {
        List<Integer> numerosNotaFiscal = new ArrayList<>();

        String observacao = geradorDeObservacaoRecursivo.geraObservacao(numerosNotaFiscal);

        assertEquals("", observacao);
    }

    @Test
    public void deveGerarObservacaoComUmaNota() {
        List<Integer> numerosNotaFiscal = singletonList(1);

        String observacao = geradorDeObservacaoRecursivo.geraObservacao(numerosNotaFiscal);

        assertEquals("Fatura da nota fiscal de simples remessa: 1.", observacao);
    }

    @Test
    public void deveGerarObservacaoComDuasNotas() {
        List<Integer> numerosNotaFiscal = asList(1, 3);

        String observacao = geradorDeObservacaoRecursivo.geraObservacao(numerosNotaFiscal);

        assertEquals("Fatura das notas fiscais de simples remessa: 1 e 3.", observacao);
    }

    @Test
    public void deveGerarObservacaoComDiversasNotas() {
        List<Integer> numerosNotaFiscal = asList(1, 2, 3, 4, 5);

        String observacao = geradorDeObservacaoRecursivo.geraObservacao(numerosNotaFiscal);

        assertEquals("Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.", observacao);
    }

}
