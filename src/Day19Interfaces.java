/**
 * Problem Statement - Interfaces
 * [Interfaces](https://www.hackerrank.com/challenges/30-interfaces)
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 *    - Antes: package + import explícito de Scanner + classe pública
 *      com main estático recebendo String[] args.
 *    - Agora: compact source file (JEP 512) sem package, sem import
 *      explícito, sem classe externa obrigatória, main() sem parâmetros.
 *
 * 2. ATENÇÃO — impacto do "sem package" na saída em tempo de execução:
 *    - O código usa getClass().getInterfaces()[0].getName() para
 *      imprimir o nome da interface implementada.
 *    - Antes (com package): imprimia o nome totalmente qualificado,
 *      ex: "com.javaaid.hackerrank.solutions.thirtydaysofcode.AdvancedArithmetic".
 *    - Agora (sem package, pacote padrão): imprime apenas o nome simples,
 *      ex: "AdvancedArithmetic".
 *    - Isso não é um erro é uma consequência direta e esperada de
 *      remover o package. O HackerRank espera exatamente o nome simples
 *      "AdvancedArithmetic" nesse desafio, então essa mudança na
 *      verdade ALINHA melhor a saída com o formato esperado.
 *
 * 3. Fechamento do Scanner
 *    - Antes: scan.close() chamado manualmente.
 *    - Agora: try-with-resources.
 *
 * 4. Saída de dados
 *    - Antes: System.out.println(...)
 *    - Agora: IO.println(...) — API utilitária do JEP 512.
 *
 * 5. Nome da classe "Calculator2"
 *    - Mantido como no original, já que o comentário do próprio autor
 *      explica o motivo (evitar colisão com a classe Calculator do
 *      desafio "More Exceptions" - Day17). Em compact source files,
 *      essa colisão só seria um problema real se ambos os arquivos
 *      fossem compilados juntos no mesmo classpath/módulo mantendo
 *      o nome diferente, evita-se qualquer risco.
 *
 * LÓGICA (sem alterações):
 * 1. AdvancedArithmetic define o contrato divisorSum(int n).
 * 2. Calculator2 implementa divisorSum somando todos os divisores de n
 *    menores que n, mais o próprio n (exceto quando n == 1, que retorna 1).
 * 3. main() lê n, calcula a soma dos divisores, imprime o nome da
 *    interface implementada e o resultado da soma.
 */

interface AdvancedArithmetic {
    int divisorSum(int n);
}

class Calculator2 implements AdvancedArithmetic {
    public int divisorSum(int n) {
        if (n == 1) return 1;

        int sum = 1 + n;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}

void main() {
    try (Scanner scan = new Scanner(System.in)) {
        int n = scan.nextInt();

        AdvancedArithmetic myCalculator = new Calculator2();
        int sum = myCalculator.divisorSum(n);

        IO.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
        IO.println(sum);
    }
}