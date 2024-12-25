import java.util.Scanner;

class URL {
    String endereco;
    URL proxima;

    public URL(String endereco) {
        this.endereco = endereco;
        this.proxima = null;
    }
}

public class Exercicio2 {
    static URL inicio = null;
    static final int MAX_URLS = 5; // Limite para o histórico

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("Histórico de Navegação:");
            System.out.println("1. Adicionar URL");
            System.out.println("2. Listar URLs");
            System.out.println("3. Voltar ao Menu Principal");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite a URL: ");
                    String endereco = scanner.nextLine();
                    adicionarURL(endereco);
                    break;
                case 2:
                    listarURLs();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarURL(String endereco) {
        URL nova = new URL(endereco);
        if (inicio == null) {
            inicio = nova;
        } else {
            URL temp = inicio;
            int count = 1;
            while (temp.proxima != null && count < MAX_URLS) {
                temp = temp.proxima;
                count++;
            }
            if (temp.proxima == null) {
                temp.proxima = nova;
            } else {
                // Remove a URL mais antiga
                inicio = inicio.proxima;
                temp.proxima = nova;
            }
        }
    }

    private static void listarURLs() {
        URL temp = inicio;
        while (temp != null) {
            System.out.println(temp.endereco);
            temp = temp.proxima;
        }
    }
}
