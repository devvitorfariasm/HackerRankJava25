/**
 * Problem Statement - BST Level Order Traversal
 * [BSTLevelOrderTraversal](https://www.hackerrank.com/challenges/30-binary-trees)
 *
 * OBSERVAÇÃO SOBRE UM BUG NO CÓDIGO ORIGINAL:
 * Em levelOrder(root), quando root == null, o código imprimia "nothing
 * to display" mas NÃO retornava continuava executando, adicionava
 * root (null) na fila, e depois tentava acessar node.data sobre um nó
 * nulo, lançando NullPointerException. Corrigido adicionando um
 * "return" logo após o print. Na prática, os casos de teste desse
 * desafio no HackerRank sempre garantem uma árvore não vazia, então
 * esse caminho provavelmente nunca era exercitado mas o bug existia.
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 *    - Antes: package + imports explícitos (LinkedList, Queue, Scanner)
 *      + classe pública com main estático.
 *    - Agora: compact source file (JEP 512) sem package, sem imports
 *      explícitos (java.util é importado implicitamente), sem classe
 *      externa obrigatória, main() sem parâmetros.
 *
 * 2. Queue<Node> com LinkedList -> ArrayDeque
 *    - Antes: new LinkedList<Node>() como implementação de Queue.
 *    - Agora: new ArrayDeque<>() a documentação da Oracle recomenda
 *      ArrayDeque no lugar de LinkedList para filas, por ser mais
 *      rápida e usar menos memória (sem overhead de nós encadeados
 *      individuais). LinkedList só compensa quando há necessidade de
 *      inserção/remoção no meio da lista, o que não é o caso aqui.
 *
 * 3. Cast desnecessário removido
 *    - Antes: Node node = (Node) q.poll() cast redundante, já que
 *      a fila é declarada como Queue<Node>, então poll() já retorna
 *      Node diretamente.
 *    - Agora: Node node = q.poll() — sem cast.
 *
 * 4. Fechamento do Scanner
 *    - Antes: sc.close() manual.
 *    - Agora: try-with-resources.
 *
 * 5. Saída de dados
 *    - Antes: System.out.println(...) / System.out.print(...)
 *    - Agora: IO.println(...) / IO.print(...).
 *
 * LÓGICA (com a correção do bug):
 * 1. Node representa um nó da árvore binária (valor + filhos).
 * 2. insert(root, data) insere respeitando a regra de BST.
 * 3. levelOrder(root) percorre a árvore em largura (BFS), usando uma
 *    fila: processa o nó atual, depois enfileira filho esquerdo e
 *    direito (se existirem), imprimindo cada valor visitado.
 * 4. main() lê T valores, monta a árvore, e imprime o percurso em
 *    largura.
 */

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
    }
}

void levelOrder(Node root) {
    if (root == null) {
        IO.println("nothing to display");
        return;
    }

    Queue<Node> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
        Node node = q.poll();
        IO.print(node.data + " ");

        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
    }
}

Node insert(Node root, int data) {
    if (root == null) {
        return new Node(data);
    }
    if (data <= root.data) {
        root.left = insert(root.left, data);
    } else {
        root.right = insert(root.right, data);
    }
    return root;
}

void main() {
    try (Scanner sc = new Scanner(System.in)) {
        int t = sc.nextInt();
        Node root = null;

        while (t-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }

        levelOrder(root);
    }
}