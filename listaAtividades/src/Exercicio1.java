import java.util.Scanner;

class Tarefa {
    String descricao;
    boolean concluida;
    Tarefa proxima;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
        this.proxima = null;
    }
}

public class Exercicio1 {
    static Tarefa inicio = null;

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("Gerenciador de Tarefas:");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Remover Tarefa");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Voltar ao Menu Principal");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    adicionarTarefa(descricao);
                    break;
                case 2:
                    System.out.print("Descrição da tarefa a remover: ");
                    descricao = scanner.nextLine();
                    removerTarefa(descricao);
                    break;
                case 3:
                    System.out.print("Descrição da tarefa a marcar como concluída: ");
                    descricao = scanner.nextLine();
                    marcarTarefaConcluida(descricao);
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            listarTarefas();
        }
    }

    private static void adicionarTarefa(String descricao) {
        Tarefa nova = new Tarefa(descricao);
        if (inicio == null) {
            inicio = nova;
        } else {
            Tarefa temp = inicio;
            while (temp.proxima != null) {
                temp = temp.proxima;
            }
            temp.proxima = nova;
        }
    }

    private static void removerTarefa(String descricao) {
        if (inicio == null) {
            System.out.println("Nenhuma tarefa para remover.");
            return;
        }

        if (inicio.descricao.equals(descricao)) {
            inicio = inicio.proxima;
            return;
        }

        Tarefa atual = inicio;
        Tarefa anterior = null;

        while (atual != null && !atual.descricao.equals(descricao)) {
            anterior = atual;
            atual = atual.proxima;
        }

        if (atual == null) {
            System.out.println("Tarefa não encontrada.");
        } else {
            anterior.proxima = atual.proxima;
        }
    }

    private static void marcarTarefaConcluida(String descricao) {
        Tarefa temp = inicio;
        while (temp != null) {
            if (temp.descricao.equals(descricao)) {
                temp.concluida = true;
                return;
            }
            temp = temp.proxima;
        }
        System.out.println("Tarefa não encontrada.");
    }

    private static void listarTarefas() {
        Tarefa temp = inicio;
        while (temp != null) {
            System.out.println(temp.descricao + " - " + (temp.concluida ? "Concluída" : "Pendente"));
            temp = temp.proxima;
        }
    }
}
