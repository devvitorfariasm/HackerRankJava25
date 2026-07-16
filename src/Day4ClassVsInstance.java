/**
 * Problem Statement - Class vs. Instance
 * [Class vs. Instance](https://www.hackerrank.com/challenges/30-class-vs-instance)
 *
 * MUDANÇAS EM RELAÇÃO AO CÓDIGO ANTERIOR:
 *
 * 1. Estrutura de arquivo
 *    - Antes: package declarado + classe "Person" solta (package-private)
 *      em arquivo próprio, sem classe principal explícita para o main.
 *    - Agora: compact source file (JEP 512). A classe "Person" continua
 *      sendo uma classe auxiliar solta no mesmo arquivo do main(), mas
 *      SEM os modificadores "public" e "static" nenhum dos dois é
 *      válido aqui: "public" exigiria que o arquivo se chamasse
 *      Person.java, e "static" só se aplica a classes aninhadas dentro
 *      de outra classe (o que não é o caso).
 *
 * 2. Correção de bug no construtor
 *    - Antes: quando initialAge era negativo, o código imprimia o aviso
 *      "Age is not valid..." mas mesmo assim executava
 *      this.age = initialAge, guardando o valor negativo.
 *    - Agora: se initialAge < 0, a idade é explicitamente zerada
 *      (this.age = 0) em vez de aceitar o valor negativo.
 *
 * 3. amIOld() — mantido como if / else if / else
 *    - Tentativa inicial: usar switch com pattern matching
 *      ("case int a when ..."), no estilo de guarded patterns.
 *    - Problema: pattern matching em switch funciona sobre o TIPO de
 *      uma expressão (normalmente tipos de referência). Como "age" já
 *      é um int primitivo, "case int a when ..." gera erro de
 *      compilação ("Unexpected type int, expected class or array type"),
 *      pois o compilador não reinterpreta o mesmo tipo primitivo como
 *      um pattern válido nesse contexto.
 *    - Correção: manter a lógica original com if / else if / else,
 *      que é a forma correta e suportada, sem depender de recursos
 *      em preview.
 *
 * 4. Saída
 *    - Antes: System.out.println(...)
 *    - Agora: IO.println(...) — API utilitária do JEP 512.
 */

// Classe auxiliar no mesmo compact source file — sem "public", sem "static"
class Person {
    private int age;

    public Person(int initialAge) {
        // CORREÇÃO: garante que idades negativas sejam forçadas a zero
        if (initialAge < 0) {
            IO.println("Age is not valid, setting age to 0.");
            this.age = 0;
        } else {
            this.age = initialAge;
        }
    }

    public void amIOld() {
        if (age < 13) {
            IO.println("You are young.");
        } else if (age < 18) {
            IO.println("You are a teenager.");
        } else {
            IO.println("You are old.");
        }
    }

    public void yearPasses() {
        this.age++;
    }
}

void main() {
    try (Scanner scan = new Scanner(System.in)) {
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int age = scan.nextInt();
            Person p = new Person(age);
            p.amIOld();

            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }

            p.amIOld();
            IO.println();
        }
    }
}