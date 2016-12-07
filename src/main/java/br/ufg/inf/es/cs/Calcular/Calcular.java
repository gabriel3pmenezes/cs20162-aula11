/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.inf.es.cs.Calcular;

import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;

/**
 * Classe de implementação do cálculo de expressão inserida em linha de comando
 * através do Parser.
 * Comando para execução: java -jar Calcular.jar "expressão"
 */
public class Calcular {

    /**
     * Classe que contém operações "static", evitando assim que sejam
     * instanciadas de forma errônea
     */
    protected Calcular() {
    }

    /**
     * Variável de armazenamento do resultado final obtido da expressão
     */
    private static float resultadoFinal;

    /**
     * Método de leitura da expressão inserida na linha de comandos
     * @param args Valor da expressão inserida na linha
     */
    public static void main(final String[] args) {
        int valorDeSaida = executaCalculo(args[0]);
        if (valorDeSaida == 0) {
            System.out.println(resultadoFinal);
        }

        System.exit(valorDeSaida);
    }

    /**
     * Método executor do o Parser.
     * @param expressao Valor da expressão para o cálculo
     * @return Resultado final da expressão
     */
    public static int executaCalculo(final String expressao) {
                try {
            Lexer lexer = new Lexer(expressao);
            Parser parser = new Parser(lexer.tokenize());
            resultadoFinal = parser.expressao().valor();

            return 0;

        } catch (Exception excecaoGerada) {

            return 1;
        }
    }
}
