/**
 * Problem Statement - Nested Logic
 * [Nested Logic](https://www.hackerrank.com/challenges/30-nested-logic)
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
 * 4. Parsing das datas com Stream (reduz 6 linhas para 2)
 *    - Antes: 3 chamadas de Integer.parseInt(...) para cada data
 *      (6 linhas no total).
 *    - Agora: Arrays.stream(partes).mapToInt(Integer::parseInt).toArray()
 *      converte o array de Strings em um array de int de uma vez.
 *
 * SOBRE USAR java.time.LocalDate PARA REDUZIR AINDA MAIS:
 * Não se aplica aqui. A multa não é calculada pela diferença real entre
 * as datas (o que ChronoUnit.DAYS.between(...) resolveria) são 3
 * regras mutuamente exclusivas com multiplicadores diferentes por
 * prioridade (ano > mês > dia). Isso é uma cascata de regras de
 * negócio, não uma distância entre datas, então o if/else if já é a
 * forma mais direta de expressar essa lógica.
 *
 * LÓGICA (sem alterações):
 * 1. Lê a data real de entrega e a data esperada (formato "dd mm yyyy").
 * 2. Se o ano de entrega for maior que o esperado: multa fixa de 10000.
 * 3. Senão, se o mesmo ano mas mês maior: multa de 500 por mês de atraso.
 * 4. Senão, se mesmo ano e mês mas dia maior: multa de 15 por dia de atraso.
 * 5. Caso contrário (entregue no prazo ou antes): multa = 0.
 */

void main() {
    try (Scanner sc = new Scanner(System.in)) {
        int[] actual = parseDate(sc.nextLine());
        int[] expected = parseDate(sc.nextLine());

        int aDate = actual[0], aMonth = actual[1], aYear = actual[2];
        int eDate = expected[0], eMonth = expected[1], eYear = expected[2];

        int fine = 0;
        if (aYear > eYear) {
            fine = 10000;
        } else if (aYear == eYear && aMonth > eMonth) {
            fine = 500 * (aMonth - eMonth);
        } else if (aYear == eYear && aMonth == eMonth && aDate > eDate) {
            fine = 15 * (aDate - eDate);
        }

        IO.println(fine);
    }
}

int[] parseDate(String date) {
    return Arrays.stream(date.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
}