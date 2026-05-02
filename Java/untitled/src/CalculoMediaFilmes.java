import java.util.Scanner;

public class CalculoMediaFilmes {
    public static void main (String[] args) {
        Scanner entrada = new Scanner(System.in);
        double nota = 0;
        double mediaAvaliacao = 0;

        System.out.println("""
                *********************************************************
                *Bem Vindo ao sistema de cálculo de média de avaliações!*
                *********************************************************
                \n
                """);
        System.out.println("Quantas avaliações serão cálculadas? ");
        int quantidadeNotas = entrada.nextInt();
        int quantidadeLoops = 1;
        String numeroOrdinal = "nenhum";



        for (int i = 0; i < quantidadeNotas; i++)  {
            switch (quantidadeLoops) {
                case 1:
                    numeroOrdinal = "primeira";
                    break;
                case 2:
                    numeroOrdinal = "segunda";
                    break;
                case 3:
                    numeroOrdinal = "terceira";
                    break;
                case 4:
                    numeroOrdinal = "quarta";
                    break;
                case 5:
                    numeroOrdinal = "quinta";
                    break;
                case 6:
                    numeroOrdinal = "sexta";
                    break;
                case 7:
                    numeroOrdinal = "sétima";
                    break;
                case 8:
                    numeroOrdinal = "oitava";
                    break;
                case 9:
                    numeroOrdinal = "nona";
                    break;
                case 10:
                    numeroOrdinal = "décima";
                    break;
            }

            System.out.println(String.format("Digite o valor da %s avaliação: ", numeroOrdinal));
            nota = entrada.nextDouble();

            mediaAvaliacao += nota;
            quantidadeLoops+= 1;
        }

        System.out.println(String.format("O resultado da média das avaliações é: %.2f", mediaAvaliacao / quantidadeNotas ));


    }
}
