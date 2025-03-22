package br.com.softplan.report.application;

import java.util.List;

/**
 * Gera observações, com texto pre-definido, incluindo os números, das notas fiscais, recebidos no parâmetro
 */
@FunctionalInterface
public interface GeradorDeObservacao<T> {

    String MENSAGEM_PADRAO = "Fatura da%s nota%s fisca%s de simples remessa: ";

    String geraObservacao(List<T> numerosNotaFiscal);

    default String obterMensagemConformeAFlexaoNumerica(List<Integer> quantidadeDeErros) {
        final String pluralSimples = quantidadeDeErros.size() < 2 ? "" : "s";
        final String pluralDeFiscais = quantidadeDeErros.size() < 2 ? "l" : "is";
        return String.format(MENSAGEM_PADRAO, pluralSimples, pluralSimples, pluralDeFiscais);
    }
}
