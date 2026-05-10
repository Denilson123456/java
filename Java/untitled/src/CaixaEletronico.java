import java.util.Scanner;

public class CaixaEletronico {
    static Scanner entrada = new Scanner(System.in);
    static double saldo = 1000;


    public static void verSaldo() {
        System.out.println(String.format("Seu saldo é: %.2f", saldo));
    }
    public static void realizarDeposito() {
        System.out.println("Digite o valor do Depósito: ");
        double depositar = entrada.nextDouble();
        saldo += depositar;
        System.out.println(String.format("O novo Saldo após o depósito é: %.2f", saldo));
    }

      public static void realizarSaque() {
        System.out.println("Digite o valor do Saque: ");
        double saque = entrada.nextDouble();
        saldo -= saque;
        System.out.println(String.format("O novo Saldo após o saque é: %.2f", saldo));
    }

    private static void Menu() {
        System.out.println("""
                1 - Ver Saldo atual
                2 - Realizar um Depósito
                3 - Realizar um Saque
                4 - Encerrar programa.
                """);
    }


    public static void main(String[] args) {
        Scanner leitor  = new Scanner(System.in);
        System.out.println("""
              *********************************
              * Bem-vindo ao Caixa Eletrônico *
              *********************************
              \n""");
        int numero = 0;

        while (numero != 4) {
            Menu();
            System.out.println("Escolha um número correspondente ao menu: ");
            numero = leitor.nextInt();
            switch (numero) {
                case 1:
                    verSaldo();
                    break;
                case 2:
                    realizarDeposito();
                    break;
                case 3:
                    realizarSaque();
                    break;
            }
        }
    }
}
