import java.util.Scanner;

class Acao {
    String descricao;
    Acao proxima;

    public Acao(String descricao) {
        this.descricao = descricao;
        this.proxima = null;
    }
}

public class Exercicio3 {
    static Acao inicio = null;

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("Sistema de Controle de Reversão (Undo):");
            System.out.println("1. Adicionar Ação");
            System.out.println("2. Desfazer Última Ação");
            System.out.println("3. Voltar ao Menu Principal");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Descrição da ação: ");
                    String descricao = scanner.nextLine();
                    adicionarAcao(descricao);
                    break;
                case 2:
                    desfazerAcao();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            listarAcoes();
        }
    }

    private static void adicionarAcao(String descricao) {
        Acao nova = new Acao(descricao);
        if (inicio == null) {
            inicio = nova;
        } else {
            nova.proxima = inicio;
            inicio = nova;
        }
    }

    private static void desfazerAcao() {
        if (inicio == null) {
            System.out.println("Nenhuma ação para desfazer.");
        } else {
            inicio = inicio.proxima;
            System.out.println("Ação desfeita.");
        }
    }

    private static void listarAcoes() {
        Acao temp = inicio;
        System.out.println("Ações:");
        while (temp != null) {
            System.out.println(temp.descricao);
            temp = temp.proxima;
        }
    }
}
