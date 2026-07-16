/**
 * Problem Statement - Exceptions - String to Integer
 * [Exceptions - String to Integer](https://www.hackerrank.com/challenges/30-exceptions-string-to-integer)
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 *    - Antes: package + import explícito de Scanner + classe pública
 *      com main estático recebendo String[] args.
 *    - Agora: compact source file (JEP 512) sem package, sem import
 *      explícito (java.util é importado implicitamente), sem classe
 *      externa, e main() sem parâmetros (args nunca era usado).
 *
 * 2. Fechamento do Scanner
 *    - Antes: in.close() chamado manualmente logo após a leitura.
 *    - Agora: try-with-resources fecha automaticamente ao sair do
 *      bloco, mesmo se ocorrer uma exceção antes.
 *
 * 3. Saída de dados
 *    - Antes: System.out.println(...)
 *    - Agora: IO.println(...) — API utilitária do JEP 512.
 *
 * SOBRE REDUZIR O TRY/CATCH:
 * Não existe hoje (nem no Java 25) uma API padrão que faça o parse de
 * inteiros "sem lançar exceção" de forma nativa Integer.parseInt()
 * sempre lança NumberFormatException para entradas inválidas, e
 * capturar essa exceção é o padrão idiomático da linguagem. Esse
 * try/catch já é a forma mais direta de resolver esse problema em Java.
 *
 * LÓGICA (sem alterações):
 * 1. Lê uma String S.
 * 2. Tenta converter para int com Integer.parseInt(S).
 * 3. Se conseguir, imprime o número. Se lançar NumberFormatException
 *    (ou seja, S não é um número válido), imprime "Bad String".
 */

void main() {
    try (Scanner in = new Scanner(System.in)) {
        String s = in.next();

        try {
            int i = Integer.parseInt(s);
            IO.println(i);
        } catch (NumberFormatException e) {
            IO.println("Bad String");
        }
    }
}