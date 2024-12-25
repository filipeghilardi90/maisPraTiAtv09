import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercicio6 {
    static Queue<String> fila = new LinkedList<>();

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("Simulador de Fila de Atendimento:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Chamar Próximo Cliente");
            System.out.println("3. Voltar ao Menu Principal");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String cliente = scanner.nextLine();
                    adicionarCliente(cliente);
                    break;
                case 2:
                    chamarProximoCliente();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarCliente(String cliente) {
        fila.add(cliente);
        System.out.println("Cliente " + cliente + " adicionado à fila.");
    }

    private static void chamarProximoCliente() {
        String cliente = fila.poll();
        if (cliente != null) {
            System.out.println("Chamando cliente: " + cliente);
        } else {
            System.out.println("Não há clientes na fila.");
        }
    }
}

