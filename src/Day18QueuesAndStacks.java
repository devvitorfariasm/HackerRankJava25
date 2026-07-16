/**
 * Problem Statement - Queues and Stacks
 * [Queues and Stacks](https://www.hackerrank.com/challenges/30-queues-stacks)
 *
 * OBSERVAÇÕES SOBRE O CÓDIGO ORIGINAL:
 *
 * 1. Faltava o main() o trecho enviado só continha os métodos
 *    auxiliares (pushCharacter, enqueueCharacter, popCharacter,
 *    dequeueCharacter), sem a lógica que lê a palavra e verifica se
 *    é palíndromo. Reconstruí essa parte seguindo o padrão oficial
 *    do desafio.
 *
 * 2. Stack<Character> -> ArrayDeque<Character>
 *    - java.util.Stack é uma classe legada (desde Java 1.0), que
 *      estende Vector e carrega sincronização desnecessária para uso
 *      single-thread, além de método de acesso menos consistente com
 *      o resto do Collections Framework.
 *    - A própria documentação da Oracle recomenda usar Deque
 *      (ArrayDeque) como pilha moderna, via push()/pop(), que têm a
 *      mesma assinatura de método, então a troca é direta.
 *    - Não é uma exigência do Java 25, é uma boa prática atual de
 *      qualquer versão moderna do Java.
 *
 * MUDANÇAS EM RELAÇÃO A UM CÓDIGO CLÁSSICO (Java 8-24):
 *
 * 3. Estrutura de arquivo
 *    - Compact source file (JEP 512): sem package, sem imports
 *      explícitos (java.util é importado implicitamente), sem classe
 *      pública obrigatória, main() sem parâmetros.
 *
 * 4 Fechamento do Scanner
 *    - try-with-resources no lugar de scan.close() manual.
 *
 * 5. Saída de dados
 *    - IO.println(...) no lugar de System.out.println(...).
 *
 * LÓGICA:
 * 1. A classe guarda uma pilha (deque) e uma fila de caracteres.
 * 2. Cada caractere da palavra é empilhado e enfileirado ao mesmo tempo.
 * 3. Para verificar palíndromo, desempilha e desenfileira um caractere
 *    por vez, comparando: se todos forem iguais, a palavra é palíndromo.
 */

class QueueAndStack {
    private ArrayDeque<Character> stack = new ArrayDeque<>();
    private Queue<Character> queue = new LinkedList<>();

    void pushCharacter(char character) {
        stack.push(character);
    }

    void enqueueCharacter(char character) {
        queue.add(character);
    }

    char popCharacter() {
        return stack.pop();
    }

    char dequeueCharacter() {
        return queue.poll();
    }
}

void main() {
    try (Scanner scan = new Scanner(System.in)) {
        String word = scan.next();
        QueueAndStack qs = new QueueAndStack();

        for (char c : word.toCharArray()) {
            qs.pushCharacter(c);
            qs.enqueueCharacter(c);
        }

        boolean isPalindrome = true;
        int length = word.length();

        for (int i = 0; i < length / 2; i++) {
            if (qs.popCharacter() != qs.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        IO.println(isPalindrome ? "Is a palindrome." : "Is not a palindrome.");
    }
}