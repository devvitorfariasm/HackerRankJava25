/**
 * Problem Statement - Day 27: Testing
 * [Day 27: Testing](https://www.hackerrank.com/challenges/30-testing)
 *
 * CONTEXTO:
 * Esse desafio não pede para resolver um problema novo ele pede para
 * VALIDAR casos de teste do problema "Angry Professor" (resolvido em
 * dia anterior da série). O HackerRank sempre espera exatamente os
 * mesmos 5 casos de teste fixos abaixo (hardcoded); por isso main()
 * apenas os imprime.
 *
 * O método testCaseGeneration() (e os dois auxiliares que ele chama)
 * ficam desativados (comentados) de propósito eles até geram casos
 * de teste ALEATÓRIOS e válidos para o problema Angry Professor, mas
 * o HackerRank rejeitaria a submissão, já que valida contra os casos
 * fixos específicos. Ficam aqui só como material de estudo.
 *
 * GLOSSÁRIO DAS VARIÁVEIS (nomes curtos do código original):
 * - n: número de alunos naquele caso de teste.
 * - k: limite mínimo de alunos que precisam chegar a tempo, senão a
 *      aula é cancelada.
 * - a: um horário de chegada gerado aleatoriamente para um aluno
 *      (negativo = chegou adiantado, positivo = chegou atrasado).
 * - tc ("test case"): a String sendo montada aos poucos, concatenando
 *      os valores de "a" separados por espaço, formando a linha de
 *      entrada final daquele caso de teste.
 * - studentCount: contador de quantos alunos já satisfazem a condição
 *      que o método está tentando forçar.
 * - generateTcForFailure: monta um caso onde a aula É cancelada (menos
 *      de k alunos a tempo).
 * - generateTcForSuccess: monta um caso onde a aula NÃO é cancelada.
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 *    - Antes: package + imports explícitos (Random, Scanner — sendo
 *      que Scanner nunca era usado em lugar nenhum do código, era
 *      import morto) + classe pública com main estático.
 *    - Agora: compact source file (JEP 512) sem package, sem imports
 *      explícitos (java.util é importado implicitamente), sem classe
 *      externa obrigatória, main() sem parâmetros. O import morto de
 *      Scanner simplesmente deixou de existir, já que nunca era usado.
 *
 * 2. Saída de dados
 *    - Antes: System.out.println(...) / System.out.print(...)
 *    - Agora: IO.println(...) / IO.print(...).
 *
 * 3. Concatenação de String -> StringBuilder (nos métodos comentados)
 *    - Antes: tc += a + " " dentro do loop, recriando uma nova String
 *      imutável a cada iteração, seguido de tc.trim() no final para
 *      remover o espaço sobrando.
 *    - Agora: StringBuilder.append(...), evitando recriar Strings a
 *      cada iteração. Como o espaço é adicionado ANTES de cada valor
 *      (exceto o primeiro), não sobra espaço no final — eliminando a
 *      necessidade do trim().
 *
 * LÓGICA (sem alterações no resultado):
 * main() imprime os 5 casos de teste fixos esperados pelo HackerRank.
 */


/*
 * Autor: Vitor De Farias Metzner
 */

void main() {
    IO.println(5);
    IO.println("4 3");
    IO.println("0 -3 4 2");
    IO.println("5 2");
    IO.println("0 -3 4 2 2");
    IO.println("3 3");
    IO.println("0 -3 4");
    IO.println("7 2");
    IO.println("0 -3 1 1 1 1 1");
    IO.println("6 3");
    IO.println("0 -3 4 2 1 1");
    testCaseGeneration();
}

/**
 * Gera 5 casos de teste aleatórios para o problema Angry Professor,
 * alternando entre casos de "aula cancelada" e "aula não cancelada",
 * conforme o array lectures.
 */
private void testCaseGeneration() {
    String[] lectures = {"YES", "NO", "YES", "NO", "YES"};
    int t = 5, m = 0;
    IO.println(t);

    while (t-- > 0) {
        String classCancel = lectures[m++];
        Random gen = new Random();
        int n = gen.nextInt(197) + 3;
        int k = gen.nextInt(n - 1) + 1;
        IO.println(n + " " + k);

        if (classCancel.equalsIgnoreCase("YES")) {
            generateTcForFailure(n, k, gen);
        } else {
            generateTcForSuccess(n, k, gen);
        }
        IO.println();
    }
}

/**
 * Monta um caso de teste onde a aula É cancelada: gera n horários de
 * chegada, garantindo que menos de k alunos cheguem a tempo (studentCount
 * fica travado em k-1 no máximo).
 */
private void generateTcForFailure(int n, int k, Random random) {
    int studentCount = 0;
    StringBuilder tc = new StringBuilder();

    while (n > 0) {
        int a = random.nextInt(2000) - 1000;
        if (a < k && studentCount < k - 1) {
            if (!tc.isEmpty()) tc.append(" ");
            tc.append(a);
            studentCount++;
            n--;
        } else if (a > k) {
            if (!tc.isEmpty()) tc.append(" ");
            tc.append(a);
            n--;
        }
    }
    IO.print(tc.toString());
}

/**
 * Monta um caso de teste onde a aula NÃO é cancelada: gera n horários de
 * chegada, garantindo que pelo menos k alunos cheguem a tempo.
 */
private void generateTcForSuccess(int n, int k, Random random) {
    int studentCount = 0;
    StringBuilder tc = new StringBuilder();

    while (n > 0) {
        int a = random.nextInt(2000) - 1000;
        if (studentCount >= k) {
            if (!tc.isEmpty()) tc.append(" ");
            tc.append(a);
            n--;
        } else if (a <= k && studentCount < k) {
            studentCount++;
            if (!tc.isEmpty()) tc.append(" ");
            tc.append(a);
            n--;
        }
    }
    IO.print(tc.toString());
}