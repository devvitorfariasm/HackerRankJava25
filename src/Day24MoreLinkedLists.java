/**
 * Problem Statement - More Linked Lists
 * [MoreLinkedLists](https://www.hackerrank.com/challenges/30-linked-list-deletion)
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 *    - Antes: package + imports explícitos (HashSet, Scanner, Set) +
 *      classe pública com main estático recebendo String[] args.
 *    - Agora: compact source file (JEP 512) sem package, sem nenhum
 *      desses imports explícitos, já que java.util.* inteiro é
 *      importado implicitamente (cobre HashSet, Set e Scanner ao
 *      mesmo tempo), sem classe externa obrigatória, main() sem
 *      parâmetros.
 *
 * 2. Diamond operator
 *    - Antes: new HashSet<Integer>() tipo repetido.
 *    - Agora: new HashSet<>() inferido pela declaração da variável.
 *
 * 3. Fechamento do Scanner
 *    - Antes: sc.close() manual no final do main.
 *    - Agora: try-with-resources.
 *
 * 4. Saída de dados
 *    - Antes: System.out.print(...)
 *    - Agora: IO.print(...).
 *
 * LÓGICA (sem alterações):
 * 1. Node representa um nó da lista encadeada (valor + próximo).
 * 2. insert(head, data) adiciona um novo nó ao final da lista.
 * 3. removeDuplicates(head) percorre a lista mantendo um Set com os
 *    valores já vistos; constrói uma nova lista contendo apenas a
 *    primeira ocorrência de cada valor, na ordem original.
 * 4. display(head) imprime os valores da lista, separados por espaço.
 * 5. main() lê T valores, monta a lista, remove duplicatas e imprime
 *    o resultado.
 */

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

Node removeDuplicates(Node head) {
    if (head == null) return head;

    Set<Integer> seen = new HashSet<>();
    Node node = head;

    seen.add(node.data);
    Node newHead = new Node(node.data);
    Node newNode = newHead;
    node = node.next;

    while (node != null) {
        if (!seen.contains(node.data)) {
            seen.add(node.data);
            newNode.next = new Node(node.data);
            newNode = newNode.next;
        }
        node = node.next;
    }

    return newHead;
}

Node insert(Node head, int data) {
    Node p = new Node(data);

    if (head == null) {
        head = p;
    } else if (head.next == null) {
        head.next = p;
    } else {
        Node start = head;
        while (start.next != null) {
            start = start.next;
        }
        start.next = p;
    }

    return head;
}

void display(Node head) {
    Node start = head;
    while (start != null) {
        IO.print(start.data + " ");
        start = start.next;
    }
}

void main() {
    try (Scanner sc = new Scanner(System.in)) {
        Node head = null;
        int t = sc.nextInt();

        while (t-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }

        head = removeDuplicates(head);
        display(head);
    }
}