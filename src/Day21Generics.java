/**
 * Problem Statement - Generics
 * [Generics](https://www.hackerrank.com/challenges/30-generics)
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
 *    - Agora: try-with-resources fecha automaticamente ao sair do
 *      bloco, mesmo se ocorrer uma exceção antes.
 *
 * 3. Diamond operator (não é exclusivo do Java 25, mas o código
 *    original não usava)
 *    - Antes: new Printer<Integer>(), new Printer<String>() tipo
 *      genérico repetido nos dois lados.
 *    - Agora: new Printer<>() o compilador infere o tipo a partir da
 *      declaração da variável (recurso do Java 7 em diante).
 *
 * 4. Saída de dados
 *    - Antes: System.out.println(...)
 *    - Agora: IO.println(...) API utilitária do JEP 512.
 *
 * SOBRE GENERICS E JAVA 25:
 * Não existe um recurso novo do Java 25 voltado especificamente para
 * generics o Java continua usando type erasure (sem generics
 * reificados em tempo de execução), igual sempre foi. O que é "moderno"
 * aqui é a estrutura do arquivo (compact source file, instance main,
 * IO) e o diamond operator, que já existiam mas não estavam em uso.
 *
 * LÓGICA (sem alterações):
 * 1. Printer<T> é uma classe genérica com um único método,
 *    printArray(T[] inputArray), que imprime cada elemento do array.
 * 2. main() lê um array de Integer e um array de String, cria um
 *    Printer<Integer> e um Printer<String>, e imprime ambos os arrays.
 * 3. Uma checagem via reflection (Printer.class.getDeclaredMethods())
 *    garante que a classe Printer não tenha métodos extras além de
 *    printArray essa é uma validação de integridade do próprio
 *    desafio, não algo relacionado a mudanças de versão do Java.
 */


/*
 * Autor: Vitor De Farias Metzner
 */

class Printer<T> {
    void printArray(T[] inputArray) {
        for (T t : inputArray) {
            IO.println(t);
        }
    }
}

void main() {
    try (Scanner sc = new Scanner(System.in)) {
        int n = sc.nextInt();
        Integer[] intArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = sc.nextInt();
        }

        n = sc.nextInt();
        String[] stringArray = new String[n];
        for (int i = 0; i < n; i++) {
            stringArray[i] = sc.next();
        }

        Printer<Integer> intPrinter = new Printer<>();
        Printer<String> stringPrinter = new Printer<>();

        intPrinter.printArray(intArray);
        stringPrinter.printArray(stringArray);

        if (Printer.class.getDeclaredMethods().length > 1) {
            IO.println("The Printer class should only have 1 method named printArray.");
        }
    }
}