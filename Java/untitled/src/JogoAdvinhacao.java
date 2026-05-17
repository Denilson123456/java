import java.util.Random;
import java.util.Scanner;

public class JogoAdvinhacao {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo de Advinhação!");
        String repetir = "S";

        while (!repetir.equalsIgnoreCase("N")) {

            jogo(entrada);

            System.out.println("Gostaria de jogar novamente? (N para finalizar)");
            repetir = entrada.next();
        }

        entrada.close();
    }

    private static int dificuldade(int complexidade) {

        int tentativasMax;

        switch (complexidade) {

            case 1:
                tentativasMax = 15;
                break;

            case 2:
                tentativasMax = 10;
                break;

            case 3:
                tentativasMax = 5;
                break;

            default:
                System.out.println("Dificuldade inválida. Usando modo Fácil.");
                tentativasMax = 15;
        }

        return tentativasMax;
    }

    private static void jogo(Scanner entrada) {

        int numero = new Random().nextInt(100) + 1;

        System.out.println("""
                Escolha a dificuldade:

                1 - Fácil
                2 - Intermediário
                3 - Difícil
                """);

        int complexidade = entrada.nextInt();
        int tentativasMax = dificuldade(complexidade);

        System.out.println("Número máximo de tentativas: " + tentativasMax);

        boolean acertou = false;

        for (int tentativas = 0; tentativas < tentativasMax; tentativas++) {

            System.out.println("Digite seu palpite:");
            int palpite = entrada.nextInt();

            if (palpite == numero) {

                System.out.println("Parabéns! Você acertou o número!");
                System.out.println("Tentativas usadas: " + (tentativas + 1));

                acertou = true;
                break;

            } else if (palpite < numero) {

                System.out.println("O número secreto é maior.");

            } else {

                System.out.println("O número secreto é menor.");
            }

            System.out.println("Tentativas restantes: " +
                    (tentativasMax - (tentativas + 1)));
        }

        if (!acertou) {

            System.out.println("Você perdeu! Acabaram as tentativas.");
            System.out.println("O número era: " + numero);
        }
    }
}