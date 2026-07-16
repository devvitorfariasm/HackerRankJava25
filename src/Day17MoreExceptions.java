/**
 * Problem Statement - More Exceptions
 * [MoreExceptions](https://www.hackerrank.com/challenges/30-more-exceptions)
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 * - Antes: package + import explícito de Scanner + classe pública
 * com main estático recebendo String[] args.
 * - Agora: compact source file (JEP 512) sem package, sem import
 * explícito (java.util é importado implicitamente), sem classe
 * externa obrigatória, main() sem parâmetros.
 *
 * 2. Fechamento do Scanner
 * - Antes: in.close() chamado manualmente no final do main.
 * - Agora: try-with-resources fecha automaticamente ao sair do
 * bloco, mesmo se ocorrer uma exceção antes.
 *
 * 3. Saída de dados
 * - Antes: System.out.println(...)
 * - Agora: IO.println(...) API utilitária do JEP 512.
 *
 * 4. Classe Calculator
 * - Sem alterações de lógica. Continua lançando uma Exception genérica
 * com a mensagem "n and p should be non-negative" quando n ou p são
 * negativos esse é o comportamento oficialmente esperado por esse
 * desafio específico do HackerRank (que pede Exception simples, não
 * uma classe de exceção customizada).
 *
 * SOBRE REDUZIR COM STREAMS:
 * Não compensa aqui. O loop mistura leitura, cálculo, impressão e
 * tratamento de exceção por item forçar isso em um Stream exigiria
 * capturar checked exceptions dentro de uma lambda, o que deixaria o
 * código mais confuso, não mais enxuto. O while tradicional já é a
 * forma mais clara para esse padrão.
 *
 * LÓGICA (sem alterações):
 * 1. Lê t (número de casos de teste).
 * 2. Para cada caso, lê n e p, calcula n elevado a p via
 * Calculator.power(n, p).
 * 3. Se n ou p forem negativos, power lança uma Exception; o catch
 * imprime a mensagem da exceção. Caso contrário, imprime o resultado.
 */


/*
 * Autor: Vitor De Farias Metzner
 */

class Calculator {
    int power(int n, int p) throws Exception {
        if (p < 0 || n < 0) {
            throw new Exception("n and p should be non-negative");
        }
        return (int) Math.pow(n, p);
    }
}

void main() {
    try (Scanner in = new Scanner(System.in)) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();

            try {
                int ans = myCalculator.power(n, p);
                IO.println(ans);
            } catch (Exception e) {
                IO.println(e.getMessage());
            }
        }
    }
}