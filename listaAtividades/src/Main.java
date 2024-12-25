//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 9) {
            System.out.println("Escolha o exercício para executar:");
            System.out.println("1. Gerenciador de tarefas");
            System.out.println("2. Histórico de navegação");
            System.out.println("3. Sistema de controle de reversão (undo)");
            System.out.println("4. Editor de texto com undo/redo");
            System.out.println("5. Jogo de cartas");
            System.out.println("6. Simulador de fila de atendimento em banco");
            System.out.println("7. Sistema de gerenciamento de impressões");
            System.out.println("8. Fila de processos prontos para execução");
            System.out.println("9. Sair");
            //opcao = scanner.nextInt();
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                opcao = -1; // Valor inválido
                scanner.next(); // Limpa a entrada inválida
            }
            scanner.nextLine(); // Consome a nova linha
            switch (opcao) {
                case 1:
                    Exercicio1.executar();
                    break;
                case 2:
                    Exercicio2.executar();
                    break;
                case 3:
                    Exercicio3.executar();
                    break;
                case 4:
                    Exercicio4.executar();
                    break;
                case 5:
                    Exercicio5.executar();
                    break;
                case 6:
                    Exercicio6.executar();
                    break;
                case 7:
                    Exercicio7.executar();
                    break;
                case 8:
                    Exercicio8.executar();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
