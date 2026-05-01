import java.util.Scanner;

public class CalculoMediaFilmes {
    public static void main (String[] args) {
        Scanner entrada = new Scanner(System.in);

        //entrada do primeiro valor.
        System.out.println("Digite o valor da primeira nota: ");
        double notaUm = entrada.nextDouble();

        //entrada do segundo valor.
        System.out.println("Digite o valor da segunda nota: ");
        double notaDois = entrada.nextDouble();
        
        //cálculo média.
        int media = (int) (notaUm + notaDois) / 2;
        String mensagem = String.format("""
        ***************************
        *A média das nota de Filme*
        ***************************
        \n
        O resultado do cálculo da média das avaliações é: %d
        """, media);
        System.out.println(mensagem);
    }
}
