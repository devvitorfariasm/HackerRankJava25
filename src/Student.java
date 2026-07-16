/**
 * Problem Statement - Inheritance
 * [Inheritance](https://www.hackerrank.com/challenges/30-inheritance)
 *
 * OBSERVAÇÃO IMPORTANTE:
 * No HackerRank, a classe "Person" normalmente vem PRONTA e TRAVADA no
 * editor — você só precisa completar "Student". Aqui reconstruí "Person"
 * também, seguindo o padrão oficial do desafio (conforme Sample Input/
 * Output e constraints), para o arquivo ficar completo e executável.
 *
 * MUDANÇAS EM RELAÇÃO A UM CÓDIGO CLÁSSICO (Java 8-24):
 *
 * 1. Estrutura de arquivo
 *    - Compact source file (JEP 512): sem package, sem import explícito
 *      de Scanner/TreeMap/Arrays/Map (java.util é importado
 *      implicitamente), sem classe pública obrigatória, main() sem
 *      parâmetros.
 *
 * 2. Fechamento do Scanner
 *    - try-with-resources no lugar de scan.close() manual.
 *
 * 3. Saída de dados
 *    - IO.println(...) no lugar de System.out.println(...).
 *
 * 4. idNumber como String, não int
 *    - A constraint "length of idNumber == 7" indica que o idNumber é
 *      tratado como String (você não mede "tamanho" de um int). Isso
 *      bate com o padrão oficial desse desafio no HackerRank.
 *
 * 5. calculate() reescrito com Stream API + TreeMap
 *    (nenhum dos dois é exclusivo do Java 25 Stream existe desde o
 *    Java 8, TreeMap desde o Java 1.2  mas ambos reduzem bastante o
 *    código em relação à versão com loop + if/else em cascata)
 *
 *    a) Soma/média:
 *       - Antes: for (int score : testScores) { sum += score; } seguido
 *         de divisão manual.
 *       - Agora: Arrays.stream(testScores).average() calcula a média
 *         diretamente. Retorna um OptionalDouble, por isso o
 *         .orElseThrow() (nunca deveria disparar aqui, já que sempre há
 *         pelo menos uma nota) e o cast para int, para manter o mesmo
 *         comportamento de truncamento do código original.
 *
 *    b) Faixas de nota -> letra:
 *       - Antes: cascata de if/else comparando avg >= 90, >= 80, etc.
 *       - Agora: um NavigableMap (TreeMap) estático mapeia a nota
 *         MÍNIMA de cada faixa para a letra correspondente. O método
 *         floorEntry(avg) busca a maior chave que seja <= avg  ou
 *         seja, a faixa correta em que a média se encaixa  e
 *         getValue() retorna a letra daquela faixa.
 *       - Exemplo: se avg = 82, floorEntry(82) encontra a chave 80
 *         (maior chave <= 82), retornando 'E'. Bate exatamente com a
 *         tabela de faixas do enunciado (Grading Scale).
 *
 * LÓGICA (sem alterações no resultado final):
 * 1. Person guarda firstName, lastName e idNumber; printPerson()
 *    imprime "Name: sobrenome, nome" e "ID: idNumber".
 * 2. Student estende Person, adicionando um array de notas (testScores).
 * 3. calculate() tira a média das notas e retorna a letra de conceito
 *    correspondente, conforme a tabela de faixas do enunciado:
 *    O (90-100), E (80-89), A (70-79), P (55-69), D (40-54), T (<40).
 * 4. Student sobrescreve printPerson() para também imprimir "Grade: X".
 */

class Person {
    protected String firstName;
    protected String lastName;
    protected String idNumber;

    Person(String firstName, String lastName, String idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }

    public void printPerson() {
        IO.println("Name: " + lastName + ", " + firstName);
        IO.println("ID: " + idNumber);
    }
}

class Student extends Person {

    // Mapa estático: nota mínima da faixa -> letra correspondente.
    // TreeMap mantém as chaves ordenadas, o que é essencial para o
    // floorEntry funcionar corretamente (busca pela maior chave <= avg).
    private static final NavigableMap<Integer, Character> GRADES = new TreeMap<>(Map.of(
            0, 'T',
            40, 'D',
            55, 'P',
            70, 'A',
            80, 'E',
            90, 'O'
    ));

    private int[] testScores;

    Student(String firstName, String lastName, String idNumber, int[] testScores) {
        super(firstName, lastName, idNumber);
        this.testScores = testScores;
    }

    public char calculate() {
        int avg = (int) Arrays.stream(testScores).average().orElseThrow();
        return GRADES.floorEntry(avg).getValue();
    }

    @Override
    public void printPerson() {
        super.printPerson();
        IO.println("Grade: " + calculate());
    }
}

void main() {
    try (Scanner scan = new Scanner(System.in)) {
        String firstName = scan.next();
        String lastName = scan.next();
        String id = scan.next();
        int numScores = scan.nextInt();

        int[] testScores = new int[numScores];
        for (int i = 0; i < numScores; i++) {
            testScores[i] = scan.nextInt();
        }

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
    }
}