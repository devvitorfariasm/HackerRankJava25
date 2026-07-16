/**
 * Problem Statement - Binary Numbers
 * [Binary Numbers](https://www.hackerrank.com/challenges/30-binary-numbers)
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
 *    - Antes: in.close() chamado manualmente logo após a leitura.
 *    - Agora: try-with-resources fecha automaticamente ao sair do
 *      bloco, mesmo se ocorrer uma exceção antes.
 *
 * 3. Saída de dados
 *    - Antes: System.out.println(maxOne)
 *    - Agora: IO.println(maxOne) API utilitária do JEP 512.
 *
 * 4. Variável "s" removida (limpeza, sem impacto na lógica)
 *    - No código original, a variável String s ia sendo montada
 *      dentro do loop (s = r + s), reconstruindo o número em binário
 *      caractere por caractere. Porém, essa variável NUNCA era usada
 *      no resultado final (só maxOne era impresso) ou seja, era
 *      código morto (trabalho feito à toa a cada iteração, incluindo
 *      concatenação de String dentro de loop, que é custosa).
 *    - Removida aqui por não ter nenhuma função no resultado. Se no
 *      futuro for necessário also exibir a representação binária,
 *      dá pra reconstruir com Integer.toBinaryString(n) em vez de
 *      montar manualmente no loop.
 *
 * LÓGICA (sem alterações):
 * 1. Lê um inteiro n.
 * 2. Percorre os bits de n (via % 2 e / 2), contando sequências
 *    consecutivas de bits "1" e guardando a maior sequência encontrada
 *    em maxOne.
 * 3. Imprime maxOne.
 */


/*
 * Autor: Vitor De Farias Metzner
 */


void main() {
    try (Scanner in = new Scanner(System.in)) {
        int n = in.nextInt();
        int r, counter = 0, maxOne = 0;

        while (n > 0) {
            r = n % 2;
            if (r == 1) {
                counter++;
                if (counter > maxOne) {
                    maxOne = counter;
                }
            } else {
                counter = 0;
            }
            n = n / 2;
        }

        IO.println(maxOne);
    }
}