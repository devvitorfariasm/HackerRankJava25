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

O Java 25 (LTS) trouxe, entre outras coisas, o recurso final do **JEP 512 — Compact Source Files and Instance Main Methods**, que simplifica bastante a forma como escrevemos programas simples em Java. Os principais pontos explorados aqui são:

| Recurso | O que muda | Antes (Java tradicional) | Agora (Java 25) |
|---|---|---|---|
| 🧩 **Classes implícitas** | Não é mais necessário declarar explicitamente `public class NomeDaClasse`. O compilador cria a classe "por baixo dos panos", usando o nome do arquivo. | `public class Solution { ... }` | *(sem declaração de classe)* |
| ▶️ **Método `main` de instância** | O `main` não precisa mais ser `public static void main(String[] args)`. Pode ser um método de instância simples, sem parâmetros. | `public static void main(String[] args)` | `void main()` |
| 📦 **Sem parâmetros obrigatórios** | Não é mais necessário lidar com o array `String[] args` quando ele não é utilizado. | `main(String[] args)` | `main()` |

> 💡 **Por que isso importa?** Esse recurso foi pensado para reduzir a barreira de entrada no aprendizado de Java, eliminando "boilerplate" que confundia iniciantes (como `public static void main(String[] args)`) sem tirar poder da linguagem — o código continua 100% compatível com o modelo tradicional quando necessário.

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
| 00 | 30 Days of Code — Day 0: Hello, World. | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-hello-world/problem) | [📄 Day0HelloWorld.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day0HelloWorld.java) |
| 01 | 30 Days of Code — Day 0: Hello, World. | [🔗 HackerRank](https://www.hackerrank.com/challenges/30-operators) | [📄 Day2Operators.java](https://github.com/devvitorfariasm/HackerRankJava25/blob/main/src/Day2Operators.java) |
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

Este projeto está sob a licença MIT — sinta-se livre para usar como referência de estudo.

<div align="center">

⭐ Se este repositório te ajudou de alguma forma, considere deixar uma estrela!

</div>