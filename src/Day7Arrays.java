/**
 * Problem Statement - Arrays
 * [Arrays](https://www.hackerrank.com/challenges/30-arrays)
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
 *    - Antes: in.close() chamado manualmente logo após o loop de leitura.
 *    - Agora: try-with-resources fecha automaticamente ao sair do
 *      bloco, mesmo se ocorrer uma exceção antes.
 *
 * 3. Saída de dados
 *    - Antes: System.out.print(...) dentro do loop, imprimindo cada
 *      valor seguido de espaço.
 *    - Agora: IO.print(...) API utilitária do JEP 512, equivalente
 *      direto ao System.out.print (sem quebra de linha automática).
 *
 * LÓGICA (sem alterações):
 * 1. Lê (n) e depois (n) inteiros, guardando em um array.
 * 2. Percorre o array de trás para frente, imprimindo cada valor
 *    seguido de um espaço.
 */

/*
 * Autor: Vitor De Farias Metzner
 */


void main() {
    try (Scanner in = new Scanner(System.in)) {
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = n - 1; i >= 0; i--) {
            IO.print(arr[i] + " ");
        }
    }
}