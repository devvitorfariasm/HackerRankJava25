/**
 * 
 * Problem Statement-
 * [Data Types](https://www.hackerrank.com/challenges/30-data-types)
 * 
 * Versão modernizada para Java 25, usando o JEP 512
 * (Compact Source Files and Instance Main Methods).
 * 
 * Principais mudanças em relação à versão clássica :
 * 
 * 1. Sem "package" e sem "class Day1DataTypes":
 *    Em "compact source files", o arquivo não precisa pertencer a um pacote
 *    nem declarar uma classe explicitamente. O compilador cria uma classe
 *    implícita por trás dos panos.
 * 
 * 2. Sem "import java.util.Scanner":
 *    Compact source files importam automaticamente vários pacotes comuns
 *    do módulo java.base (como java.util e java.io), então o Scanner
 *    já fica disponível sem import manual.
 * 
 * 3. "void main()" no lugar de "public static void main(String[] args)":
 *    Isso é o "instance main method". Não precisa mais ser static,
 *    nem public, nem receber args (a menos que você realmente use args).
 *    Simplifica MUITO o boilerplate para exemplos e scripts pequenos.
 * 
 * 4. "IO.println(...)" no lugar de "System.out.println(...)":
 *    Nova API utilitária (java.lang.IO) trazida também pelo JEP 512,
 *    pensada para reduzir verbosidade em código simples/didático.
 * 
 * 5. try-with-resources no lugar de "scan.close()" manual:
 *    Ao invés de chamar scan.close() na mão no final do método (o que é
 *    arriscado se uma exceção acontecer antes), o Scanner é aberto dentro
 *    de um bloco try (Scanner scan = new Scanner(System.in)) { ... }.
 *    Isso garante o fechamento automático do recurso, mesmo em caso de erro.
 * 
 * 6. Ordem de leitura ajustada (nextInt -> nextDouble -> nextLine -> nextLine):
 *    Na versão original havia um scan.nextLine() extra logo após o nextInt(),
 *    que na prática "engolia" a quebra de linha no lugar errado dependendo
 *    da entrada. Aqui, o nextLine() de limpeza é chamado uma única vez,
 *    logo depois do nextDouble(), que é o ponto correto onde sobra o '\n'
 *    no buffer antes de ler a String com scan.nextLine().
 */


/*
 * Autor: Vitor De Farias Metzner
 */


void main() {
    // Variáveis já fornecidas e inicializadas pelo desafio
    int i = 4;
    double d = 4.0;
    String s = "HackerRank ";

    // try-with-resources: Garante o fechamento automático do Scanner ao final do bloco
    try (Scanner scan = new Scanner(System.in)) {

        // 1. Lê o valor inteiro da entrada
        int ii = scan.nextInt();

        // 2. Lê o valor double da entrada
        double dd = scan.nextDouble();

        // CORREÇÃO ESSENCIAL: Limpa a quebra de linha (\n) deixada pelo nextDouble() no buffer do teclado
        scan.nextLine();

        // 3. Lê a linha de texto inteira com segurança após a limpeza do buffer
        String ss = scan.nextLine();

        // Imprime os resultados no console seguindo o 'Output Format' exigido
        IO.println(i + ii); // Soma dos inteiros
        IO.println(d + dd); // Soma dos decimais (double)
        IO.println(s + ss); // Concatenação das strings
    }
}