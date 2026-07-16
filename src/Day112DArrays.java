/**
 * Problem Statement - 2D Arrays
 * [2D Arrays](https://www.hackerrank.com/challenges/30-2d-arrays)
 *
 * VERSÃO COM STREAM API:
 * Não é um recurso novo do Java 25 (Stream API existe desde o Java 8),
 * mas reduz os loops aninhados manuais para calcular e comparar as
 * somas de cada ampulheta possível na matriz.
 *
 * Como funciona:
 * - IntStream.range(0, 4) gera os índices válidos de "i" e "j" (só até
 *   3, já que a ampulheta ocupa 3 linhas/colunas equivalente à
 *   condição "(i+2) < 6" do código original, mas expressa diretamente
 *   no range em vez de um "if" dentro do loop).
 * - flatMap "achata" as combinações de i e j em um único stream de
 *   somas (equivalente ao loop duplo original).
 * - hourglassSum(arr, i, j) calcula a soma de uma ampulheta específica.
 * - .max(...) substitui o "if (sum > maxSum)" manual.
 */


/*
 * Autor: Vitor De Farias Metzner
 */

void main() {
    try (Scanner in = new Scanner(System.in)) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int maxSum = IntStream.range(0, 4)
                .flatMap(i -> IntStream.range(0, 4)
                        .map(j -> hourglassSum(arr, i, j)))
                .max()
                .orElseThrow();

        IO.println(maxSum);
    }
}

static int hourglassSum(int[][] arr, int i, int j) {
    return arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
         + arr[i + 1][j + 1]
         + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
}