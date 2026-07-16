/**
 * Problem Statement - Scope
 * [Scope](https://www.hackerrank.com/challenges/30-scope)
 *
 * OBSERVAÇÃO IMPORTANTE SOBRE O CÓDIGO ORIGINAL:
 * O código enviado tinha um bloco de comentário Javadoc aberto
 * ("/ **  @param elements") que nunca foi fechado antes do construtor e
 * do método computeDifference(). Isso fez com que TODO o código real
 * (construtor, loop, cálculo) ficasse dentro do comentário ou seja,
 * a classe "Day14Scope" compilava vazia, sem nenhuma lógica executável.
 * Além disso, o nome da classe esperado pelo desafio é "Difference",
 * não "Day14Scope" (conforme a Sample Input mostra "Function: __elements
 * = ..." sendo passado para um construtor de Difference).
 *
 * MUDANÇAS EM RELAÇÃO A UM CÓDIGO CLÁSSICO (Java 8-24):
 *
 * 1. Estrutura de arquivo
 *    - Compact source file (JEP 512): sem package, sem classe pública
 *      obrigatória, main() sem parâmetros.
 *
 * 2. Fechamento do Scanner (na leitura, dentro do main)
 *    - try-with-resources no lugar de scan.close() manual.
 *
 * 3. Saída de dados
 *    - IO.println(...) no lugar de System.out.println(...).
 *
 * LÓGICA (conforme enunciado e Sample Input/Output):
 * 1. Difference guarda um array de inteiros (elements) e um campo
 *    público maximumDifference.
 * 2. computeDifference() percorre o array encontrando o maior e o
 *    menor valor, e guarda em maximumDifference a diferença absoluta
 *    entre eles (Math.abs(max - min)).
 * 3. O main() lê N e os N elementos, cria um Difference, chama
 *    computeDifference() e imprime o resultado.
 *
 * Conferindo com o Sample Input/Output:
 * Entrada: N=3, elements=[1,2,5]
 * max=5, min=1, diferença = |5-1| = 4 -> bate com a Sample Output "4".
 */


/*
 * Autor: Vitor De Farias Metzner
 */


class Difference {
    private int[] elements;
    public int maximumDifference;

    Difference(int[] elements) {
        this.elements = elements;
    }

    void computeDifference() {
        int maxNum = elements[0];
        int minNum = elements[0];

        for (int i = 1; i < elements.length; i++) {
            maxNum = elements[i] > maxNum ? elements[i] : maxNum;
            minNum = elements[i] < minNum ? elements[i] : minNum;
        }

        maximumDifference = Math.abs(maxNum - minNum);
    }
}

void main() {
    try (Scanner scan = new Scanner(System.in)) {
        int n = scan.nextInt();
        int[] elements = new int[n];

        for (int i = 0; i < n; i++) {
            elements[i] = scan.nextInt();
        }

        Difference d = new Difference(elements);
        d.computeDifference();
        IO.println(d.maximumDifference);
    }
}