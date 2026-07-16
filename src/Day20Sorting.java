/**
 * Problem Statement - Sorting
 * [Sorting](https://www.hackerrank.com/challenges/30-sorting)
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
 * 3. Declaração de array (estilo, não é sobre Java 25)
 *    - Antes: int a[] = new int[n] — sintaxe "C-style".
 *    - Agora: int[] a = new int[n] — sintaxe idiomática do Java.
 *
 * 4. Nome da variável de índice do loop de leitura
 *    - Antes: a_i (underscore em nome de variável, estilo incomum
 *      em Java).
 *    - Agora: i, mais idiomático.
 *
 * 5. Saída de dados
 *    - Antes: System.out.println(...)
 *    - Agora: IO.println(...) — API utilitária do JEP 512.
 *
 * SOBRE USAR MAIS RECURSOS DO JAVA 25:
 * Não existe uma API nova voltada para algoritmos de ordenação em si 
 * bubble sort continua sendo escrito manualmente, já que o próprio
 * objetivo do desafio é implementar o algoritmo e contar as trocas
 * (usar Arrays.sort() descaracterizaria o exercício). O que realmente
 * é "Java 25" aqui é a estrutura do arquivo (compact source file,
 * instance main, IO), que já está aplicada.
 *
 * LÓGICA (sem alterações):
 * 1. Lê n e os n elementos do array.
 * 2. Executa bubble sort, contando o número de trocas (count) e
 *    parando antecipadamente se uma passada inteira não fizer troca
 *    nenhuma (swapped == false).
 * 3. Imprime o número de trocas, o primeiro e o último elemento do
 *    array já ordenado.
 */

void main() {
    try (Scanner in = new Scanner(System.in)) {
        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int count = 0;
        boolean swapped = true;

        for (int j = a.length - 1; j >= 0 && swapped; j--) {
            swapped = false;
            for (int k = 0; k < j; k++) {
                if (a[k] > a[k + 1]) {
                    int temp = a[k];
                    a[k] = a[k + 1];
                    a[k + 1] = temp;
                    count++;
                    swapped = true;
                }
            }
        }

        IO.println("Array is sorted in " + count + " swaps.");
        IO.println("First Element: " + a[0]);
        IO.println("Last Element: " + a[a.length - 1]);
    }
}