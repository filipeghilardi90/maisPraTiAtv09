import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TrabalhoImpressao {
    String nome;

    public TrabalhoImpressao(String nome) {
        this.nome = nome;
    }
}

public class Exercicio7 {
    static Queue<TrabalhoImpressao> filaImpressao = new LinkedList<>();

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("Sistema de Gerenciamento de Impressões:");
            System.out.println("1. Adicionar Trabalho de Impressão");
            System.out.println("2. Processar Próximo Trabalho de Impressão");
            System.out.println("3. Voltar ao Menu Principal");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do trabalho de impressão: ");
                    String nome = scanner.nextLine();
                    adicionarTrabalho(nome);
                    break;
                case 2:
                    processarProximoTrabalho();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarTrabalho(String nome) {
        filaImpressao.add(new TrabalhoImpressao(nome));
        System.out.println("Trabalho de impressão \"" + nome + "\" adicionado à fila.");
    }

    private static void processarProximoTrabalho() {
        TrabalhoImpressao trabalho = filaImpressao.poll();
        if (trabalho != null) {
            System.out.println("Processando trabalho de impressão: " + trabalho.nome);
        } else {
            System.out.println("Não há trabalhos de impressão na fila.");
        }
    }
}

