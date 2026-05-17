import java.util.Scanner;

public class ConjuntoProgramas {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int num = 0;

        while (num != 7) {

            System.out.println("""
                    
                    Olá seja bem-vindo ao programa, digite um Número correspondente ao Menu abaixo:
                    1 - Paridade
                    2 - Comparação entre números
                    3 - Cálculo da Área de Retângulos e Círculos
                    4 - Tabuada
                    5 - Tipo de um Número
                    6 - Fatorial
                    7 - Finalizar
                    """);

            num = entrada.nextInt();

            switch (num) {

                case 1:
                    NumeroParidade(entrada);
                    break;

                case 2:
                    comparacao(entrada);
                    break;

                case 3:
                    calculoArea(entrada);
                    break;

                case 4:
                    tabuada(entrada);
                    break;

                case 5:
                    tipo(entrada);
                    break;

                case 6:
                    fatorial(entrada);
                    break;

                case 7:
                    System.out.println("O programa será finalizado.");
                    break;

                default:
                    System.out.println("Entrada inválida.");
            }
        }

        entrada.close();
    }

    private static void NumeroParidade(Scanner entrada) {

        System.out.println("Digite o número que deseja verificar paridade: ");
        int numero = entrada.nextInt();

        if (numero % 2 == 0) {

            System.out.println("O número " + numero + " é PAR.");

        } else {

            System.out.println("O número " + numero + " é ÍMPAR.");
        }
    }

    private static void comparacao(Scanner entrada) {

        System.out.println("Digite um número inteiro: ");
        int primeiroNumero = entrada.nextInt();

        System.out.println("Digite o segundo número: ");
        int segundoNumero = entrada.nextInt();

        if (primeiroNumero == segundoNumero) {

            System.out.println("Os números são iguais.");

        } else if (primeiroNumero > segundoNumero) {

            System.out.println(
                    "O primeiro número (" + primeiroNumero +
                            ") é maior que o segundo (" + segundoNumero + ")."
            );

        } else {

            System.out.println(
                    "O segundo número (" + segundoNumero +
                            ") é maior que o primeiro (" + primeiroNumero + ")."
            );
        }
    }

    private static void calculoArea(Scanner entrada) {

        System.out.println("""
                Digite um número correspondente ao menu abaixo:
                1 - Calcular área de um quadrilátero
                2 - Calcular área de um círculo
                """);

        int numMenu = entrada.nextInt();

        double primeiraMedida;
        double segundaMedida;

        switch (numMenu) {

            case 1:

                System.out.println("Digite o valor da Base em centímetros: ");
                primeiraMedida = entrada.nextDouble();

                System.out.println("Digite o valor da Altura em centímetros: ");
                segundaMedida = entrada.nextDouble();

                double areaQuadrilatero = primeiraMedida * segundaMedida;

                System.out.println(String.format(
                        "A área do quadrilátero é: %.2f cm²",
                        areaQuadrilatero
                ));

                break;

            case 2:

                System.out.println("Digite o valor do Raio em centímetros: ");
                primeiraMedida = entrada.nextDouble();

                double areaCirculo = 3.14 * Math.pow(primeiraMedida, 2);

                System.out.println(String.format(
                        "A área do círculo é: %.2f cm²",
                        areaCirculo
                ));

                break;

            default:

                System.out.println("Opção inválida.");
        }
    }

    private static void tabuada(Scanner entrada) {

        System.out.println("Digite um número que deseja saber a tabuada:");
        int numero = entrada.nextInt();

        System.out.println("Qual o último multiplicador?");
        int multiplicador = entrada.nextInt();

        for (int i = 0; i <= multiplicador; i++) {

            int produto = numero * i;

            System.out.println(
                    String.format("%d x %d = %d", numero, i, produto)
            );
        }
    }

    private static void tipo(Scanner entrada) {

        System.out.println("Digite um número: ");
        int numero = entrada.nextInt();

        if (numero > 0) {

            System.out.println("Esse número é POSITIVO.");

        } else if (numero < 0) {

            System.out.println("Esse número é NEGATIVO.");

        } else {

            System.out.println("Esse número é ZERO.");
        }
    }

    private static void fatorial(Scanner entrada) {

        System.out.println("Digite um número: ");
        int numero = entrada.nextInt();

        int fatorial = 1;

        for (int i = 1; i <= numero; i++) {
            fatorial *= i;
        }

        System.out.println("O fatorial de " + numero + " é " + fatorial);
    }
}