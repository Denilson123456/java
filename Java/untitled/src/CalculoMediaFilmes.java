public class CalculoMediaFilmes {
    public static void main (String[] args) {
        double notaUm = 9.82;
        double notaDois = 6.35;
        int media = (int) (notaUm + notaDois) / 2;
        String mensagem = String.format("O resultado do cálculo da média das notas disponíveis foi: %d", media);
        System.out.println("***************************");
        System.out.println("*A média das nota de Filme*");
        System.out.println("***************************");
        System.out.println("\n");
        System.out.println(mensagem);
    }
}
