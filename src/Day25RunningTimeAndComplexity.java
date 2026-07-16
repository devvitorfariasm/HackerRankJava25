/**
 * Problem Statement - Running Time and Complexity
 * [RunningTimeAndComplexity](https://www.hackerrank.com/challenges/30-running-time-and-complexity)
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 *    - Compact source file (JEP 512): sem package, sem import explícito
 *      (java.util é importado implicitamente), sem classe externa,
 *      main() sem parâmetros.
 *
 * 2. Fechamento do Scanner
 *    - try-with-resources no lugar de sc.close() manual.
 *
 * 3. Saída de dados
 *    - IO.println(...) no lugar de System.out.println(...).
 *
 * 4. isPrime(n) reescrito com IntStream (Stream API, existe desde o
 *    Java 8 — não é exclusivo do 25, mas reduz o método a algumas linhas):
 *    - Antes: loop for manual, retornando false assim que encontrasse
 *      um divisor, e true no final.
 *    - Agora: n >= 2 && IntStream.rangeClosed(2, sqrt(n)).noneMatch(...)
 *      noneMatch retorna true se nenhum divisor no intervalo dividir
 *      n exatamente, equivalente à mesma lógica. Por causa do
 *      short-circuit do &&, se n < 2 o stream nem chega a ser avaliado,
 *      preservando o mesmo comportamento e custo do if original.
 *
 * LÓGICA (resultado idêntico ao original):
 * 1. isPrime(n) retorna false para n < 2, e verifica se algum número
 *    de 2 até sqrt(n) divide n; se nenhum dividir, é primo.
 * 2. main() lê a quantidade de casos n, e para cada um lê um número e
 *    imprime "Prime" ou "Not prime".
 */


/*
 * Autor: Vitor De Farias Metzner
 */

boolean isPrime(int n) {
    return n >= 2 && IntStream.rangeClosed(2, (int) Math.sqrt(n))
            .noneMatch(i -> n % i == 0);
}

void main() {
    try (Scanner sc = new Scanner(System.in)) {
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String result = isPrime(sc.nextInt()) ? "Prime" : "Not prime";
            IO.println(result);
        }
    }
}