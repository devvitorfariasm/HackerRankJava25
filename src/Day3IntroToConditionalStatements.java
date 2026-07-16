/**
 * Problem Statement - Intro to Conditional Statements
 * [Intro to Conditional Statements](https://www.hackerrank.com/challenges/30-conditional-statements)
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 *    - Antes: package + import + class + main estático.
 *    - Agora: compact source file (JEP 512) sem package, sem import
 *      explícito de Scanner, sem classe externa.
 *
 * 2. Fechamento do Scanner
 *    - Antes: scan.close() chamado manualmente após a leitura.
 *    - Agora: try-with-resources o Scanner fecha sozinho ao sair do
 *      bloco, mesmo se ocorrer uma exceção antes.
 *
 * 3. Teste de número ímpar
 *    - Antes: n % 2 == 1
 *    - Agora: n % 2 != 0
 *    - Diferença prática: só importa se n puder ser negativo (em Java,
 *      o resto de um número negativo ímpar é -1, não 1). Se o desafio
 *      garante n positivo, isso é só uma robustez extra, não correção
 *      de bug.
 *
 * 4. Ranges explícitos para os números pares
 *    - Antes: só existia um "if (6 a 20) -> Weird / else -> Not Weird"
 *      dentro do bloco par. Isso já cobria 2-5 e >20 como "Not Weird"
 *      de forma implícita (via else).
 *    - Agora: os três intervalos (2-5, 6-20, >20) são escritos de forma
 *      explícita. O comportamento final é o mesmo a mudança é só de
 *      clareza/legibilidade, não de lógica.
 *
 * 5. Remoção da variável "ans"
 *    - Antes: existia uma variável "ans" que só era usada no caminho
 *      ímpar, misturada com prints diretos no caminho par — deixava o
 *      fluxo inconsistente (às vezes imprimia via variável, às vezes
 *      via System.out direto).
 *    - Agora: cada branch imprime o resultado diretamente na hora,
 *      sem variável intermediária. Fluxo mais linear.
 *
 * 6. Saída
 *    - Antes: System.out.println(...)
 *    - Agora: IO.println(...) — API utilitária do JEP 512.
 */

void main() {
    try (Scanner scan = new Scanner(System.in)) {
        int n = scan.nextInt();

        if (n % 2 != 0) {
            IO.println("Weird");
        } else {
            if (n >= 2 && n <= 5) {
                IO.println("Not Weird");
            } else if (n >= 6 && n <= 20) {
                IO.println("Weird");
            } else if (n > 20) {
                IO.println("Not Weird");
            }
        }
    }
}