/**
 * Problem Statement - Linked List
 * [Linked List](https://www.hackerrank.com/challenges/30-linked-list)
 *
 * OBSERVAÇÃO SOBRE O CÓDIGO ORIGINAL:
 * O código enviado compilava normalmente (sem erros de sintaxe), mas
 * estava incompleto para rodar sozinho: faltava o método display(head)
 * — que o desafio também pede, para imprimir a lista encadeada e o
 * main() que lê a entrada e conecta tudo (criar a lista via insert() e
 * depois chamar display()).
 *
 * MUDANÇAS EM RELAÇÃO A UM CÓDIGO CLÁSSICO (Java 8-24):
 *
 * 1. Estrutura de arquivo
 *    - Antes: package + classe pública Day15LinkedList com classe
 *      aninhada estática Node.
 *    - Agora: compact source file (JEP 512) sem package. A classe
 *      Node continua estática, mas agora aninhada dentro de uma classe
 *      auxiliar "Solution" (ou poderia ficar solta ver observação
 *      abaixo), sem precisar de classe pública.
 *
 * 2. Fechamento do Scanner (no main, que lê a entrada)
 *    - try-with-resources no lugar de scan.close() manual.
 *
 * 3. Saída de dados
 *    - IO.print(...)/IO.println(...) no lugar de System.out.print(...).
 *
 * LÓGICA:
 * 1. Node representa um nó da lista encadeada (valor + próximo nó).
 * 2. insert(head, data) adiciona um novo nó ao final da lista,
 *    percorrendo até encontrar o último nó (next == null). Se a lista
 *    estiver vazia (head == null), o novo nó vira a própria head.
 * 3. display(head) percorre a lista a partir da head, imprimindo cada
 *    valor seguido de espaço.
 * 4. main() lê N e os N valores, inserindo cada um na lista via
 *    insert(), e no final chama display() para imprimir o resultado.
 */


/*
 * Autor: Vitor De Farias Metzner
 */


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

Node insert(Node head, int data) {
    Node newNode = new Node(data);
    if (head == null) return newNode;

    Node node = head;
    while (node.next != null) {
        node = node.next;
    }
    node.next = newNode;
    return head;
}

void display(Node head) {
    Node node = head;
    while (node != null) {
        IO.print(node.data + " ");
        node = node.next;
    }
}

void main() {
    try (Scanner scan = new Scanner(System.in)) {
        int n = scan.nextInt();
        Node head = null;

        for (int i = 0; i < n; i++) {
            int data = scan.nextInt();
            head = insert(head, data);
        }

        display(head);
    }
}