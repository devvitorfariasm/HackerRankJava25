/**
 * Problem Statement - Loops
 * [Loops](https://www.hackerrank.com/challenges/30-loops)
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 *    - Antes: package + import de Scanner + classe pública com main estático.
 *    - Agora: compact source file (JEP 512) sem package, sem import
 *      explícito, sem classe externa.
 *
 * 2. Fechamento do Scanner
 *    - Antes: in.close() chamado manualmente após a leitura.
 *    - Agora: try-with-resources fecha automaticamente ao sair do
 *      bloco, mesmo se houver uma exceção antes.
 *
 * 3. Formatação da saída
 *    - Antes: concatenação manual com "+" (n + " x " + i + " = " + n * i).
 *    - Agora: String.format(...) com placeholders (%d), passada para
 *      IO.println(...). Mantém o mesmo resultado, só troca a
 *      concatenação por uma formatação mais legível para strings com
 *      vários valores numéricos.
 *    - Observação: java.lang.IO (JEP 512) não tem um método "printf"
 *      equivalente ao System.out.printf por isso a formatação é
 *      feita com String.format e o resultado é passado para
 *      IO.println, mantendo a consistência com o restante dos
 *      exercícios que já usam IO.println.
 */


/*
 * Autor: Vitor De Farias Metzner
 */


void main() {
    try (Scanner in = new Scanner(System.in)) {
        int n = in.nextInt();

        for (int i = 1; i <= 10; i++) {
            IO.println(String.format("%d x %d = %d", n, i, n * i));
        }
    }
}