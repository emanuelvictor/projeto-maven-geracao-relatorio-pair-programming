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
        final Iterator<Integer> iterador = numerosNotaFiscal.iterator();
        return mensagemPadrao + adicionarNumero(iterador.next(), iterador, new StringBuilder());
    }

    private static String adicionarNumero(Integer numeroAtual, Iterator<Integer> iterador, StringBuilder conteudoDaMensagemBuilder) {
        conteudoDaMensagemBuilder.append(numeroAtual);
        if (iterador.hasNext()) {
            int proximo = iterador.next();
            if (iterador.hasNext())
                conteudoDaMensagemBuilder.append(", ");
            else {
                conteudoDaMensagemBuilder.append(" e ");
            }
            return adicionarNumero(proximo, iterador, conteudoDaMensagemBuilder);
        } else {
            return conteudoDaMensagemBuilder.append(".").toString();
        }
    }

    private static boolean listaDeNumerosDaNotaFiscalNaoEhValida(List<Integer> numerosDaNotaFiscal) {
        return numerosDaNotaFiscal.isEmpty();
    }
}