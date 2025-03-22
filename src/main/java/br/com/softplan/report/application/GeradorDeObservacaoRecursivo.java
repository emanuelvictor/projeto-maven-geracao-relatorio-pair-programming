package br.com.softplan.report.application;

import java.util.Iterator;
import java.util.List;

public class GeradorDeObservacaoRecursivo implements GeradorDeObservacao<Integer> {

    public String geraObservacao(List<Integer> numerosNotaFiscal) {
        if (listaDeNumerosDaNotaFiscalNaoEhValida(numerosNotaFiscal))
            return "";
        final String mensagem = obterMensagemConformeAFlexaoNumerica(numerosNotaFiscal);
        return obterMensagemPreenchidaComOsNumerosDaNotaFiscal(numerosNotaFiscal, mensagem);
    }

    private static String obterMensagemPreenchidaComOsNumerosDaNotaFiscal(List<Integer> numerosNotaFiscal, final String mensagemPadrao) {
        final Iterator<Integer> iterator = numerosNotaFiscal.iterator();
        return mensagemPadrao + tralala(iterator.next(), iterator, new StringBuilder());
    }

    private static String tralala(Integer anterior, Iterator<Integer> iterator, StringBuilder conteudoDaMensagemBuilder) {
        conteudoDaMensagemBuilder.append(anterior);
        if (iterator.hasNext()) {
            int proximo = iterator.next();
            if (iterator.hasNext())
                conteudoDaMensagemBuilder.append(", ");
            else {
                conteudoDaMensagemBuilder.append(" e ");
            }
            return tralala(proximo, iterator, conteudoDaMensagemBuilder);
        } else {
            return conteudoDaMensagemBuilder.append(".").toString();
        }
    }

    private static boolean listaDeNumerosDaNotaFiscalNaoEhValida(List<Integer> numerosDaNotaFiscal) {
        return numerosDaNotaFiscal.isEmpty();
    }
}