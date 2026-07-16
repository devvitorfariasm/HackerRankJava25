/**
 * Problem Statement - Bitwise AND
 * [Bitwise AND](https://www.hackerrank.com/challenges/30-bitwise-and)
 *
 * BUG CRÍTICO NO CÓDIGO ORIGINAL:
 * in.close() estava dentro do loop for, sendo executado logo na
 * primeira iteração. Se houvesse mais de um caso de teste (t > 1), a
 * segunda iteração tentaria ler do Scanner já fechado, lançando
 * IllegalStateException: Scanner closed. Corrigido movendo o
 * fechamento para fora do loop, via try-with-resources.
 *
 * GLOSSÁRIO DAS VARIÁVEIS (nomes originais confusos):
 * - t: quantidade de casos de teste (test cases).
 * - a0: nome gerado automaticamente pelo template do HackerRank para
 *       o índice do loop sem significado especial, renomeado para
 *       "i" por clareza.
 * - n: limite superior o valor máximo permitido para os dois números
 *      que serão comparados via AND bit a bit.
 * - k: valor de referência o problema pede o maior resultado possível
 *      de A & B (com 1 <= A < B <= n) que seja ESTRITAMENTE MENOR que k.
 *
 * LÓGICA DO CÁLCULO (o "truque" matemático, sem alteração):
 * A resposta ótima é sempre k-1 ou k-2:
 * - Se (k-1) | k (OU bit a bit entre k-1 e k) for <= n, dá para
 *   escolher A = k-1 e B = (k-1)|k, e o resultado do AND será k-1 
 *   a melhor resposta possível.
 * - Caso contrário, k-1 não cabe dentro do limite n, então a resposta
 *   cai para k-2.
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 *    - Compact source file (JEP 512): sem package, sem import explícito
 *      (java.util é importado implicitamente), sem classe externa,
 *      main() sem parâmetros.
 *
 * 2. Fechamento do Scanner (CORREÇÃO DE BUG)
 *    - Antes: in.close() dentro do loop, causando erro em múltiplos
 *      casos de teste.
 *    - Agora: try-with-resources fecha automaticamente uma única vez,
 *      ao sair do bloco, depois de todos os casos de teste processados.
 *
 * 3. Saída de dados
 *    - Antes: System.out.println(...)
 *    - Agora: IO.println(...).
 *
 * LÓGICA (sem alteração no resultado, só na correção do bug):
 * 1. Lê t casos de teste.
 * 2. Para cada caso, lê n e k, e calcula a resposta ótima usando a
 *    verificação de (k-1)|k <= n.
 * 3. Imprime k-1 se a condição for satisfeita, senão k-2.
 */


/*
 * Autor: Vitor De Farias Metzner
 */

void main() {
    try (Scanner in = new Scanner(System.in)) {
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (((k - 1) | k) <= n) {
                IO.println(k - 1);
            } else {
                IO.println(k - 2);
            }
        }
    }
}