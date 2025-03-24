package br.com.softplan.report.application;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(SubstituirCamelCase.class)
public class GeradoresDeObservacaoTest {

    @ParameterizedTest
    @MethodSource("obterGeradoresDeObservacao")
    public void deveGerarObservacaoSemNota(GeradorDeObservacao<Integer> geradorDeObservacao) {
        List<Integer> numerosNotaFiscal = new ArrayList<>();

        String observacao = geradorDeObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals("", observacao);
    }

    @ParameterizedTest
    @MethodSource("obterGeradoresDeObservacao")
    public void deveGerarObservacaoComUmaNota(GeradorDeObservacao<Integer> geradorDeObservacao) {
        List<Integer> numerosNotaFiscal = singletonList(1);

        String observacao = geradorDeObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals("Fatura da nota fiscal de simples remessa: 1.", observacao);
    }

    @ParameterizedTest
    @MethodSource("obterGeradoresDeObservacao")
    public void deveGerarObservacaoComDuasNotas(GeradorDeObservacao<Integer> geradorDeObservacao) {
        List<Integer> numerosNotaFiscal = asList(1, 3);

        String observacao = geradorDeObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals("Fatura das notas fiscais de simples remessa: 1 e 3.", observacao);
    }

    @ParameterizedTest
    @MethodSource("obterGeradoresDeObservacao")
    public void deveGerarObservacaoComDiversasNotas(GeradorDeObservacao<Integer> geradorDeObservacao) {
        List<Integer> numerosNotaFiscal = asList(1, 2, 3, 4, 5);

        String observacao = geradorDeObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals("Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.", observacao);
    }

    private static Stream<Arguments> obterGeradoresDeObservacao() {
        return Stream.of(
                Arguments.of(new NovoGeradorDeObservacao()),
                Arguments.of(new AntigoGeradorDeObservacao()),
                Arguments.of(new GeradorDeObservacaoRecursivo()),
                Arguments.of(new GeradorDeObservacaoSemStringBuilder())
        );
    }
}
