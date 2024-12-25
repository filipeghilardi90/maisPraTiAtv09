import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Processo {
    String nome;

    public Processo(String nome) {
        this.nome = nome;
    }
}

public class Exercicio8 {
    static Queue<Processo> filaProcessos = new LinkedList<>();

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("Fila de Processos Prontos para Execução:");
            System.out.println("1. Adicionar Processo");
            System.out.println("2. Executar Processo Mais Antigo");
            System.out.println("3. Voltar ao Menu Principal");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do processo: ");
                    String nome = scanner.nextLine();
                    adicionarProcesso(nome);
                    break;
                case 2:
                    executarProcesso();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarProcesso(String nome) {
        filaProcessos.add(new Processo(nome));
        System.out.println("Processo " + nome + " adicionado à fila.");
    }

    private static void executarProcesso() {
        Processo processo = filaProcessos.poll();
        if (processo != null) {
            System.out.println("Executando processo: " + processo.nome);
        } else {
            System.out.println("Não há processos na fila.");
        }
    }
}
