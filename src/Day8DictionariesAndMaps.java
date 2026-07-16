/**
 * Problem Statement - Dictionaries and Maps
 * [Dictionaries and Maps](https://www.hackerrank.com/challenges/30-dictionaries-and-maps)
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 *    - Antes: package + imports explícitos (Scanner, HashMap) + classe
 *      pública com main estático recebendo String[] argh.
 *    - Agora: compact source file (JEP 512) sem package, sem imports
 *      explícitos (java.util é importado implicitamente, cobrindo tanto
 *      Scanner quanto HashMap), sem classe externa, e main() sem
 *      parâmetros (já que args nunca era usado).
 *
 * 2. Fechamento do Scanner
 *    - Antes: in.close() chamado manualmente no final do main.
 *    - Agora: try-with-resources fecha automaticamente ao sair do
 *      bloco, mesmo se ocorrer uma exceção antes.
 *
 * 3. Uso de diamond operator no HashMap
 *    - Antes: new HashMap<String, Integer>() — tipos repetidos dos
 *      dois lados.
 *    - Agora: new HashMap<>() o compilador infere os tipos genéricos
 *      a partir da declaração da variável (diamond operator, recurso
 *      que já existe desde o Java 7, mas que o código original não
 *      usava).
 *
 * 4. Saída de dados
 *    - Antes: System.out.println(...)
 *    - Agora: IO.println(...) API utilitária do JEP 512. Como não há
 *      necessidade de formatação (%s, %d, etc.) aqui, IO.println supre
 *      bem o caso, diferente dos desafios anteriores que precisavam de
 *      printf/String.format.
 *
 * LÓGICA (sem alterações):
 * 1. Lê n pares de (nome, telefone) e guarda no HashMap.
 * 2. Lê nomes restantes da entrada até acabar (in.hasNext()) e imprime
 *    "nome=telefone" se encontrado, ou "Not found" caso contrário.
 */

void main() {
    try (Scanner in = new Scanner(System.in)) {
        HashMap<String, Integer> hmap = new HashMap<>();
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();
            hmap.put(name, phone);
        }

        while (in.hasNext()) {
            String s = in.next();
            if (hmap.containsKey(s)) {
                IO.println(s + "=" + hmap.get(s));
            } else {
                IO.println("Not found");
            }
        }
    }
}