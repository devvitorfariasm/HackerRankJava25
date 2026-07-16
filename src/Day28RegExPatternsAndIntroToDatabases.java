/**
 * Problem Statement - RegEx, Patterns, and Intro to Databases
 * [RegEx,Patterns,and Intro to Databases](https://www.hackerrank.com/challenges/30-regex-patterns)
 *
 * OBSERVAÇÃO IMPORTANTE — BUG NO REGEX ORIGINAL:
 * O padrão original era "[a-z].@gmail.com", que tinha 3 problemas:
 * 1. Sem âncoras ^ e $: find() aceitava o padrão aparecendo em
 *    QUALQUER posição da string, então e-mails como
 *    "user@gmail.com.evil.net" seriam aceitos incorretamente.
 * 2. O "." antes de "@" não estava escapado em regex, "." significa
 *    "qualquer caractere", não um ponto literal (aqui não gerava erro
 *    visível, mas não era a intenção real).
 * 3. Os pontos dentro de "gmail.com" também não estavam escapados,
 *    então "gmailXcom" (com qualquer caractere no lugar do ponto)
 *    também seria aceito como válido.
 * Corrigido para "^[a-zA-Z0-9_.+-]+@gmail\\.com$", que valida
 * corretamente um nome de usuário seguido de "@gmail.com" exato, do
 * início ao fim da string.
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo e TODOS os imports removidos
 *    - Antes: package + 6 imports explícitos (ArrayList, Collections,
 *      List, Scanner, Matcher, Pattern) + classe pública com main
 *      estático.
 *    - Agora: compact source file (JEP 512) — sem package. O compilador
 *      importa implicitamente o módulo java.base inteiro, o que cobre
 *      não só java.util.* (ArrayList, Collections, List, Scanner), mas
 *      também java.util.regex.* (Pattern, Matcher). Nenhum import
 *      manual é necessário.
 *
 * 2. Diamond operator
 *    - Antes: new ArrayList<String>()
 *    - Agora: new ArrayList<>()
 *
 * 3. Fechamento do Scanner
 *    - Antes: in.close() manual no final do main.
 *    - Agora: try-with-resources.
 *
 * 4. Saída de dados
 *    - Antes: System.out.println(...)
 *    - Agora: IO.println(...).
 *
 * 5. Pattern compilado uma única vez, fora do loop
 *    - Antes: Pattern p = Pattern.compile(regExPattern) era recriado
 *      dentro do loop, a cada iteração — desperdício, já que o padrão
 *      nunca muda.
 *    - Agora: compilado uma única vez, antes do loop.
 *
 * LÓGICA (mesma estrutura, regex corrigido):
 * 1. Lê N pares de (nome, e-mail).
 * 2. Para cada par, verifica se o e-mail bate com o padrão de Gmail
 *    válido; se sim, guarda o nome na lista.
 * 3. Ordena a lista de nomes e imprime um por linha.
 */


/*
 * Autor: Vitor De Farias Metzner
 */

void main() {
    try (Scanner in = new Scanner(System.in)) {
        int n = in.nextInt();
        List<String> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@gmail\\.com$");

        for (int i = 0; i < n; i++) {
            String firstName = in.next();
            String emailId = in.next();

            Matcher m = pattern.matcher(emailId);
            if (m.matches()) {
                list.add(firstName);
            }
        }

        Collections.sort(list);
        for (String name : list) {
            IO.println(name);
        }
    }
}