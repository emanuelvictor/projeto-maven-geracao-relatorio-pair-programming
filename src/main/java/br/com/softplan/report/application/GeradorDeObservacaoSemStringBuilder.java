package br.com.softplan.report.application;

import java.util.List;
import java.util.stream.Collectors;

public class GeradorDeObservacaoSemStringBuilder implements GeradorDeObservacao<Integer> {

    public String geraObservacao(List<Integer> numerosNotaFiscal) {
        if (listaDeNumerosDaNotaFiscalNaoEhValida(numerosNotaFiscal))
            return "";
        final String mensagem = obterMensagemConformeAFlexaoNumerica(numerosNotaFiscal);
        return obterMensagemPreenchidaComOsNumerosDaNotaFiscal(numerosNotaFiscal, mensagem);
    }

    private static String obterMensagemPreenchidaComOsNumerosDaNotaFiscal(List<Integer> numerosNotaFiscal, final String mensagemPadrao) {
        return mensagemPadrao + formatarPalavras(numerosNotaFiscal) + ".";
    }

    private static String formatarPalavras(List<?> palavras) {
        if (palavras.isEmpty()) {
            return "";
        }
        if (palavras.size() == 1) {
            return palavras.get(0).toString();
        }
        return palavras.subList(0, palavras.size() - 1).stream()
                .map(Object::toString)
                .map(String::toLowerCase)
                .collect(Collectors.joining(", ")) +
                " e " + palavras.get(palavras.size() - 1).toString().toLowerCase();
    }

    private static boolean listaDeNumerosDaNotaFiscalNaoEhValida(List<Integer> numerosDaNotaFiscal) {
        return numerosDaNotaFiscal.isEmpty();
    }
}