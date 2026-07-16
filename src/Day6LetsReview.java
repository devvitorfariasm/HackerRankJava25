/**
 * Problem Statement - Let's Review
 * [Let's Review](https://www.hackerrank.com/challenges/30-review-loop)
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 *    - Antes: package + import de Scanner + classe pública com main estático.
 *    - Agora: compact source file (JEP 512) sem package, sem import
 *      explícito, sem classe externa.
 *
 * 2. Fechamento do Scanner
 *    - Antes: sc.close() chamado manualmente no final do main.
 *    - Agora: try-with-resources fecha automaticamente ao sair do
 *      bloco, mesmo se ocorrer uma exceção antes.
 *
 * 3. Leitura da entrada dentro do loop (MUDANÇA FUNCIONAL, não só estética)
 *    - Antes: sc.next() lê apenas um token (até o próximo espaço).
 *    - Agora: sc.nextLine() lê a linha inteira, incluindo espaços.
 *    - Isso só é equivalente se cada linha de entrada for garantidamente
 *      uma única palavra sem espaços (que é o caso deste desafio no
 *      HackerRank). Se houvesse espaços na linha, o resultado mudaria.
 *
 * 4. Concatenação de String -> StringBuilder
 *    - Antes: str1 = str1 + char1[j] dentro do loop, reatribuindo uma
 *      nova String imutável a cada iteração.
 *    - Agora: StringBuilder.append(...), evitando recriar objetos
 *      String a cada caractere processado.
 *
 * 5. Reset das variáveis por iteração
 *    - Antes: str1 = str2 = "" no final de cada iteração do loop
 *      externo, reaproveitando as mesmas variáveis.
 *    - Agora: evenChars e oddChars são declaradas (e recriadas) dentro
 *      do próprio loop externo cada iteração começa com StringBuilders
 *      novos, sem precisar resetar manualmente no final.
 *
 * 6. Saída formatada
 *    - Antes: System.out.println(str1 + " " + str2) — concatenação manual.
 *    - Agora: System.out.printf("%s %s%n", evenChars, oddChars).
 *    - Observação: diferente dos desafios anteriores desta série, aqui
 *      foi mantido System.out.printf em vez de IO.println, pois
 *      java.lang.IO (JEP 512) não possui um método de formatação
 *      equivalente ao printf.
 */


/*
 * Autor: Vitor De Farias Metzner
 */


void main() {
    try (Scanner sc = new Scanner(System.in)) {
        int noOfTest = sc.nextInt();
        sc.nextLine(); // Limpa o buffer do teclado após ler o inteiro

        for (int i = 0; i < noOfTest; i++) {
            String input = sc.nextLine();

            StringBuilder evenChars = new StringBuilder();
            StringBuilder oddChars = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                if (j % 2 == 0) {
                    evenChars.append(input.charAt(j));
                } else {
                    oddChars.append(input.charAt(j));
                }
            }

            IO.println(String.format("%s %s", evenChars, oddChars));
        }
    }
}