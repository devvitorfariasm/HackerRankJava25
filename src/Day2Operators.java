/**
 * Problem Statement - Operators
 * [Operators](https://www.hackerrank.com/challenges/30-operators)
 *
 * NOTA SOBRE O JAVA 25:
 * Embora o Java 25 puro permita omitir a classe externa, aqui estruturamos o código
 * dentro da classe 'Day2Operators' mantendo o método tradicional de execução.
 *
 * Principais mudanças em relação à versão clássica (Java 8+):
 *
 * 1. Sem "package" e sem "class Day2Operators":
 *    Assim como no desafio anterior, usamos "compact source files" (JEP 512),
 *    então não é necessário declarar pacote nem classe explicitamente.
 *
 * 2. Sem "import java.util.Scanner":
 *    O Scanner já vem disponível automaticamente pelos imports implícitos
 *    do java.base em compact source files.
 *
 * 3. "void main()" no lugar de "public static void main(String[] args)":
 *    Instance main method — sem static, sem public, sem args.
 *
 * 4. try-with-resources no lugar de "scan.close()" manual:
 *    Na versão original, o scan.close() era chamado manualmente logo após
 *    as leituras. Aqui o Scanner é fechado automaticamente ao sair do
 *    bloco try, mesmo que ocorra alguma exceção durante a leitura.
 *
 * 5. Lógica de cálculo extraída para o método "solve(...)":
 *    Na versão original, todo o cálculo ficava dentro do main.
 *    Aqui, separamos a responsabilidade: main() só lê a entrada e delega
 *    o cálculo/impressão para solve(), deixando o código mais organizado
 *    e testável.
 *
 * 6. Gorjeta e imposto calculados separadamente ("tip" e "tax"):
 *    Na versão original, tudo era somado em uma única expressão
 *    (mealCost + tip + tax) na mesma linha. Aqui quebramos em variáveis
 *    intermediárias (tip, tax, total_cost) só para deixar mais legível
 *    o que cada parte representa.
 *
 * 7. Uso de "100.0" explícito na divisão:
 *    Garante que a divisão seja feita em ponto flutuante desde o início,
 *    evitando qualquer risco de divisão inteira (mesmo que aqui não houvesse
 *    risco real, já que meal_cost já é double).
 *
 * 8. "IO.println(...)" no lugar de "System.out.println(...)":
 *    Nova API utilitária do JEP 512, reduz verbosidade.
 *
 * 9. ATENÇÃO - Mudança no formato da saída:
 *    A versão original imprimia uma frase completa:
 *    "The total meal cost is X dollars."
 *    Esta versão imprime apenas o número (rounded_total).
 *    Se o HackerRank espera o texto completo como "Output Format",
 *    é necessário ajustar o IO.println para reproduzir a mesma frase,
 *    caso contrário a submissão pode ser considerada incorreta mesmo
 *    com o cálculo certo.
 */


/*
 * Autor: Vitor De Farias Metzner
 */

void main() {
    // try-with-resources: Garante o fechamento automático do Scanner
    try (Scanner scan = new Scanner(System.in)) {

        // Lendo as 3 linhas de entrada numérica do console
        double meal_cost = scan.nextDouble();
        int tip_percent = scan.nextInt();
        int tax_percent = scan.nextInt();

        // Chamando o método para calcular e exibir o custo total
        solve(meal_cost, tip_percent, tax_percent);
    }
}

/**
 * Calcula e imprime o custo total da refeição arredondado para o inteiro mais próximo.
 */
public static void solve(double meal_cost, int tip_percent, int tax_percent) {
    // Calcula o valor da gorjeta usando 100.0 para não perder as casas decimais
    double tip = meal_cost * tip_percent / 100.0;

    // Calcula o valor do imposto
    double tax = meal_cost * tax_percent / 100.0;

    // Soma tudo para obter o valor total com os decimais
    double total_cost = meal_cost + tip + tax;

    // Math.round() arredonda para o inteiro mais próximo.
    // Usamos o cast (int) porque o Math.round retorna um tipo long.
    int rounded_total = (int) Math.round(total_cost);

    // Imprime o resultado final
    IO.println(rounded_total);
}