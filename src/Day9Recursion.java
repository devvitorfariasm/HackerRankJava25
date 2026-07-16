/**
 * Problem Statement - Recursion
 * [Recursion](https://www.hackerrank.com/challenges/30-recursion)
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
 *    - Antes: sc.close() chamado manualmente no final do main.
 *    - Agora: try-with-resources fecha automaticamente ao sair do
 *      bloco, mesmo se ocorrer uma exceção antes.
 *
 * 3. Saída de dados
 *    - Antes: System.out.println(factorial(i))
 *    - Agora: IO.println(factorial(i)) API utilitária do JEP 512.
 *
 * 4. Método factorial() — static vs. instância
 *    - Antes (main estático clássico): métodos chamados diretamente de
 *      dentro do main() geralmente PRECISAVAM ser static, já que um
 *      método estático não pode instanciar implicitamente a própria
 *      classe para chamar um método de instância sem "new".
 *    - Agora (main de instância, JEP 512): como o próprio main() passou
 *      a ser um método de instância, factorial() poderia deixar de ser
 *      static e funcionar exatamente igual, sendo chamado normalmente
 *      dentro do main(). Manter "static" aqui não é uma exigência do
 *      Java 25 é só uma escolha estilística, já que static continua
 *      sendo perfeitamente chamável a partir de um método de instância.
 *      Optei por manter "static" por ser mais próximo do código
 *      original e por não haver necessidade de estado de instância
 *      dentro de factorial().
 *
 * LÓGICA (sem alterações):
 * 1. Lê um inteiro i.
 * 2. Calcula o fatorial de i recursivamente (caso base: 0 ou 1 -> 1).
 * 3. Imprime o resultado.
 */


/*
 * Autor: Vitor De Farias Metzner
 */

public static int factorial(int i) {
    if (i == 1 || i == 0) {
        return 1;
    } else {
        return i * factorial(i - 1);
    }
}

void main() {
    try (Scanner sc = new Scanner(System.in)) {
        int i = sc.nextInt();
        IO.println(factorial(i));
    }
}