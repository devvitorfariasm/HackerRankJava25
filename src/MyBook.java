/**
 * Problem Statement - Abstract Classes
 * [Abstract Classes](https://www.hackerrank.com/challenges/30-abstract-classes)
 *
 * OBSERVAÇÕES SOBRE O CÓDIGO ORIGINAL:
 *
 * 1. Faltava o main() o trecho enviado só continha as classes Book e
 *    MyBook, sem o ponto de entrada que lê a entrada e chama display().
 *    Reconstruí o main() seguindo o padrão oficial desse desafio.
 *
 * 2. Book não era realmente abstrata — apesar do desafio se chamar
 *    "Abstract Classes", a classe Book original era uma classe comum
 *    (sem "abstract"), sem nenhum método abstrato. O padrão oficial do
 *    HackerRank declara Book como "abstract class Book" com um método
 *    "abstract void display();", obrigando MyBook a implementá-lo.
 *    Corrigido para refletir o conceito que o desafio pretende ensinar.
 *
 * 3. Nomes de parâmetros com "$" ($title, $author, $price) — válido em
 *    Java, mas incomum e não idiomático. Renomeado para title, author,
 *    price (usando "this.title = title" para diferenciar do parâmetro).
 *
 * MUDANÇAS EM RELAÇÃO A UM CÓDIGO CLÁSSICO (Java 8-24):
 *
 * 4. Estrutura de arquivo
 *    - Antes: package + classes soltas, sem classe pública, sem main.
 *    - Agora: compact source file (JEP 512) — sem package, sem import
 *      explícito de Scanner, main() sem parâmetros.
 *
 * 5. Fechamento do Scanner
 *    - try-with-resources no lugar de scan.close() manual.
 *
 * 6. Saída de dados
 *    - IO.println(...) no lugar de System.out.println(...).
 *
 * LÓGICA:
 * 1. Book é uma classe abstrata com título, autor e um método abstrato
 *    display(), que cada subclasse deve implementar.
 * 2. MyBook estende Book, adiciona o campo price, e implementa display()
 *    imprimindo título, autor e preço.
 * 3. main() lê título, autor e preço da entrada, cria um MyBook e chama
 *    display().
 */


/*
 * Autor: Vitor De Farias Metzner
 */

abstract class Book {
    protected String title;
    protected String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    abstract void display();
}

class MyBook extends Book {
    private int price;

    MyBook(String title, String author, int price) {
        super(title, author);
        this.price = price;
    }

    @Override
    void display() {
        IO.println("Title: " + title);
        IO.println("Author: " + author);
        IO.println("Price: " + price);
    }
}

void main() {
    try (Scanner scan = new Scanner(System.in)) {
        String title = scan.nextLine();
        String author = scan.nextLine();
        int price = scan.nextInt();

        MyBook myBook = new MyBook(title, author, price);
        myBook.display();
    }
}