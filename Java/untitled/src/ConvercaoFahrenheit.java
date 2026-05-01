import java.util.Scanner;

public class ConvercaoFahrenheit {
    public static void main (String[] args) {
        // Definição das variáveis de temperatura e estrutura de mensagem.
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o valor da temperatura em Celsius: ");
        String temperaturaCelsius = entrada.nextLine();
        //Convertendo entrada para Double.
        double celsius = Double.parseDouble(temperaturaCelsius);
        double temperaturaFahrenheit =  (celsius * 1.8) + 32;
        String mensagem = String.format("A temperatura atual em Celsius é %fº é equivalente a %fº em Fahrenheit.", celsius, temperaturaFahrenheit);

        System.out.println(mensagem);

        //Utilizando Casting para conversão dos tipos de váriaveis Double para int.
        int temperaturaFahrenheitInteira = (int) temperaturaFahrenheit;
        String mensagemConvertida = String.format("A temperatura em Fahrenheit convertida para inteiro é %dº", temperaturaFahrenheitInteira);
        System.out.println(mensagemConvertida);
    }
}