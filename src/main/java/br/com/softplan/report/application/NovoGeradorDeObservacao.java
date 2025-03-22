package br.com.softplan.report.application;

import java.util.Iterator;
import java.util.List;

public class NovoGeradorDeObservacao implements GeradorDeObservacao<Integer> {

    public String geraObservacao(List<Integer> numerosNotaFiscal) {
        if (listaDeNumerosDaNotaFiscalNaoEhValida(numerosNotaFiscal))
            return "";
        final String mensagem = obterMensagemConformeAFlexaoNumerica(numerosNotaFiscal);
        return obterMensagemPreenchidaComOsNumerosDaNotaFiscal(numerosNotaFiscal, mensagem);
    }

    private static String obterMensagemPreenchidaComOsNumerosDaNotaFiscal(List<Integer> numerosNotaFiscal, final String mensagemPadrao) {
        final StringBuilder conteudoDaMensagemBuilder = new StringBuilder();
        for (Iterator<Integer> iterator = numerosNotaFiscal.iterator(); iterator.hasNext(); ) {
            final Integer numeroDaNotaFiscal = iterator.next();
            if (conteudoDaMensagemBuilder.length() > 0) {
                if (iterator.hasNext()) {
                    conteudoDaMensagemBuilder.append(", ");
                } else {
                    conteudoDaMensagemBuilder.append(" e ");
                }
            }
            conteudoDaMensagemBuilder.append(numeroDaNotaFiscal);
        }
        return mensagemPadrao + conteudoDaMensagemBuilder + ".";
    }

    private static boolean listaDeNumerosDaNotaFiscalNaoEhValida(List<Integer> numerosDaNotaFiscal) {
        return numerosDaNotaFiscal.isEmpty();
    }
}