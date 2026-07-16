/**
 * Problem Statement - Binary Search Trees
 * [BinarySearchTrees](https://www.hackerrank.com/challenges/30-binary-search-trees)
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 *    - Antes: package + import explícito de Scanner + classe pública
 *      com main estático recebendo String[] args.
 *    - Agora: compact source file (JEP 512) sem package, sem import
 *      explícito, sem classe externa obrigatória, main() sem parâmetros.
 *
 * 2. Fechamento do Scanner
 *    - Antes: sc.close() chamado manualmente no final do main.
 *    - Agora: try-with-resources.
 *
 * 3. Saída de dados
 *    - Antes: System.out.println(...)
 *    - Agora: IO.println(...).
 *
 * SOBRE USAR TreeSet/TreeMap PARA REDUZIR CÓDIGO:
 * Não se aplica aqui. TreeSet/TreeMap são árvores rubro-negras
 * (auto-balanceadas), então nunca ficam com altura degenerada mas o
 * próprio objetivo do desafio é calcular a altura de uma BST SEM
 * balanceamento (mostrando que a ordem de inserção afeta a altura
 * final). Usar uma estrutura balanceada pronta descaracterizaria o
 * problema, além da API dessas classes não expor "altura da árvore"
 * como conceito. Por isso a árvore e a recursão continuam manuais.
 *
 * LÓGICA (sem alterações):
 * 1. Node representa um nó da árvore binária de busca (valor + filhos
 *    esquerdo e direito).
 * 2. insert(root, data) insere um valor na posição correta, seguindo a
 *    regra de BST (menor ou igual vai à esquerda, maior vai à direita).
 * 3. getHeight(root) calcula recursivamente a altura da árvore (número
 *    de arestas do nó raiz até a folha mais distante); árvore vazia
 *    tem altura -1.
 * 4. main() lê T valores e os insere um a um na árvore, depois imprime
 *    a altura final.
 */


/*
 * Autor: Vitor De Farias Metzner
 */

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
    }
}

int getHeight(Node root) {
    return (root == null) ? -1 : Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
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

        IO.println(getHeight(root));
    }
}