<div align="center">

# ☕ HackerRank Java 25

### Desafios do HackerRank resolvidos explorando os recursos mais recentes do **Java 25**

[![Java](https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/projects/jdk/25/)
[![HackerRank](https://img.shields.io/badge/HackerRank-Challenges-2EC866?style=for-the-badge&logo=hackerrank&logoColor=white)](https://www.hackerrank.com/)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](#-licença)
[![Status](https://img.shields.io/badge/Status-Em%20andamento-yellow?style=for-the-badge)](#-progresso)

</div>

---

## 📖 Sobre o projeto

Este repositório reúne minhas soluções para desafios do **HackerRank**, com um diferencial: em vez de usar a sintaxe tradicional do Java, todo o código aqui é escrito aproveitando os **recursos mais novos introduzidos no Java 25**, como classes implícitas e métodos `main` de instância.

A ideia é dupla:

- 🧠 **Praticar lógica de programação e resolução de problemas** com os clássicos desafios do HackerRank;
- 🚀 **Explorar na prática as mudanças mais recentes da linguagem Java**, entendendo como elas simplificam a escrita de código, principalmente para quem está começando.

Cada solução mantém comentários no próprio arquivo `.java` destacando **qual novidade do Java 25 está sendo usada** e por quê.

---

## ✨ Novidades do Java 25 usadas neste projeto

O Java 25 (LTS) trouxe, entre outras coisas, o recurso final do **JEP 512 Compact Source Files and Instance Main Methods**, que simplifica bastante a forma como escrevemos programas simples em Java. Os principais pontos explorados aqui são:

| Recurso | O que muda | Antes (Java tradicional) | Agora (Java 25) |
|---|---|---|---|
| 🧩 **Classes implícitas** | Não é mais necessário declarar explicitamente `public class NomeDaClasse`. O compilador cria a classe "por baixo dos panos", usando o nome do arquivo. | `public class Solution { ... }` | *(sem declaração de classe)* |
| ▶️ **Método `main` de instância** | O `main` não precisa mais ser `public static void main(String[] args)`. Pode ser um método de instância simples, sem parâmetros. | `public static void main(String[] args)` | `void main()` |
| 📦 **Sem parâmetros obrigatórios** | Não é mais necessário lidar com o array `String[] args` quando ele não é utilizado. | `main(String[] args)` | `main()` |

> 💡 **Por que isso importa?** Esse recurso foi pensado para reduzir a barreira de entrada no aprendizado de Java, eliminando "boilerplate" que confundia iniciantes (como `public static void main(String[] args)`) sem tirar poder da linguagem o código continua 100% compatível com o modelo tradicional quando necessário.

### Exemplo prático

```java
// Antes (Java tradicional)
public class Solution {
    public static void main(String[] args) {
        System.out.println("Hello, World.");
    }
}
```

```java
// Agora (Java 25 - JEP 512)
void main() {
    System.out.println("Hello, World.");
}
```

---

## 📋 Desafios resolvidos

| # | Desafio | Link HackerRank | Código |
|---|---|:---:|:---:|
| 01 | 30 Days of Code — Day 1: Hello, World | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-hello-world/problem) | [📄 Day0HelloWorld.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day0HelloWorld.java) |
| 02 | 30 Days of Code — Day 2: Operators | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-operators) | [📄 Day2Operators.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day2Operators.java) |
| 03 | 30 Days of Code — Day 3: Intro to Conditional Statements | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-conditional-statements) | [📄 Day3IntroToConditionalStatements.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day3IntroToConditionalStatements.java) |
| 04 | 30 Days of Code — Day 4: Class vs. Instance | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-class-vs-instance) | [📄 Day4ClassVsInstance.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day4ClassVsInstance.java) |
| 05 | 30 Days of Code — Day 5: Loops | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-loops) | [📄 Day5Loops.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day5Loops.java) |
| 06 | 30 Days of Code — Day 6: Let's Review | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-review-loop) | [📄 Day6LetsReview.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day6LetsReview.java) |
| 07 | 30 Days of Code — Day 7: Arrays | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-arrays) | [📄 Day7Arrays.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day7Arrays.java) |
| 08 | 30 Days of Code — Day 8: Dictionaries and Maps | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-dictionaries-and-maps) | [📄 Day8DictionariesAndMaps.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day8DictionariesAndMaps.java) |
| 09 | 30 Days of Code — Day 9: Recursion | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-recursion) | [📄 Day9Recursion.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day9Recursion.java) |
| 10 | 30 Days of Code — Day 10: Binary Numbers | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-binary-numbers) | [📄 Day10BinaryNumbers.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day10BinaryNumbers.java) |
| 11 | 30 Days of Code — Day 11: 2D Arrays | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-2d-arrays) | [📄 Day112DArrays.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day112DArrays.java) |
| 12 | 30 Days of Code — Day 12: Inheritance | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-inheritance) | [📄 Student.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Student.java) |
| 13 | 30 Days of Code — Day 14: Abstract Classes | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-abstract-classes) | [📄 MyBook.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/MyBook.java) |
| 14 | 30 Days of Code — Day 14: Scope | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-scope) | [📄 Day14Scope.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day14Scope.java) |
| 15 | 30 Days of Code — Day 15: Linked List | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-linked-list) | [📄 Day15LinkedList.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day15LinkedList.java) |
| 16 | 30 Days of Code — Day 16: String to Integer | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-exceptions-string-to-integer) | [📄 Day16ExceptionsStringToInteger.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day16ExceptionsStringToInteger.java) |
| 17 | 30 Days of Code — Day 17: More Exceptions | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-more-exceptions) | [📄 Day17MoreExceptions.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day17MoreExceptions.java) |
| 18 | 30 Days of Code — Day 18: Queues and Stacks | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-queues-stacks) | [📄 Day18QueuesAndStacks.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day18QueuesAndStacks.java) |
| 19 | 30 Days of Code — Day 19: Interfaces | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-interfaces) | [📄 Day19Interfaces.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day19Interfaces.java) |
| 20 | 30 Days of Code — Day 20: Sorting | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-sorting) | [📄 Day20Sorting.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day20Sorting.java) |
| 21 | 30 Days of Code — Day 21: Generics | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-generics) | [📄 Day21Generics.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day21Generics.java) |
| 22 | 30 Days of Code — Day 22: Binary Search Trees | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-binary-search-trees) | [📄 Day22BinarySearchTrees.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day22BinarySearchTrees.java) |
| 23 | 30 Days of Code — Day 23: BST Level Order Traversal | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-binary-trees) | [📄 Day23BSTLevelOrderTraversal.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day23BSTLevelOrderTraversal.java) |
| 24 | 30 Days of Code — Day 24: More Linked Lists | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-linked-list-deletion) | [📄 Day24MoreLinkedLists.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day24MoreLinkedLists.java) |
| 25 | 30 Days of Code — Day 25: Running Time and Complexity | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-running-time-and-complexity) | [📄 Day25RunningTimeAndComplexity.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day25RunningTimeAndComplexity.java) |
| 26 | 30 Days of Code — Day 26: Nested Logic | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-nested-logic) | [📄 Day26NestedLogic.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day26NestedLogic.java) |
| 27 | 30 Days of Code — Day 27: Testing | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-testing) | [📄 Day27Testing.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day27Testing.java) |
| 28 | 30 Days of Code — Day 28: RegEx, Patterns, and Intro to Databases | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-regex-patterns) | [📄 Day28RegExPatternsAndIntroToDatabases.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day28RegExPatternsAndIntroToDatabases.java) |
| 29 | 30 Days of Code — Bitwise AND | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-bitwise-and) | [📄 Day28RegExPatternsAndIntroToDatabases.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day28RegExPatternsAndIntroToDatabases.java) |


> 📌 A tabela será atualizada conforme novos desafios forem resolvidos e adicionados manualmente.

---

## 🚀 Como executar

Uma das vantagens do Java 25 é poder rodar um arquivo `.java` diretamente, sem precisar compilar antes com `javac`:

```bash
java src/Day0HelloWorld.java
```

### Pré-requisitos

- [JDK 25](https://jdk.java.net/25/) ou superior instalado
- Verifique a versão com:

```bash
java -version
```

---

## 🛠️ Tecnologias

- **Linguagem:** Java 25 (LTS)
- **Plataforma:** HackerRank

## 👤 Autor

**Vitor De Farias Metzner**

[![GitHub](https://img.shields.io/badge/GitHub-devvitorfariasm-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/devvitorfariasm)

---

## 📄 Licença

Este projeto está sob a licença MIT sinta-se livre para usar como referência de estudo.

<div align="center">

⭐ Se este repositório te ajudou de alguma forma, considere deixar uma estrela!

</div>