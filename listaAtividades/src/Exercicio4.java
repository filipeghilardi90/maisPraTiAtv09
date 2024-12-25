import java.util.Scanner;

class Nodo {
    String texto;
    Nodo anterior;
    Nodo proximo;

    public Nodo(String texto) {
        this.texto = texto;
        this.anterior = null;
        this.proximo = null;
    }
}

public class Exercicio4 {
    static Nodo atual = null;
    static Nodo inicio = null;

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("Editor de Texto com Undo/Redo:");
            System.out.println("1. Inserir Texto");
            System.out.println("2. Desfazer (Undo)");
            System.out.println("3. Refazer (Redo)");
            System.out.println("4. Voltar ao Menu Principal");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o texto: ");
                    String texto = scanner.nextLine();
                    inserirTexto(texto);
                    break;
                case 2:
                    desfazer();
                    break;
                case 3:
                    refazer();
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            exibirTexto();
        }
    }

    private static void inserirTexto(String texto) {
        Nodo novo = new Nodo(texto);
        if (atual == null) {
            inicio = novo;
            atual = novo;
        } else {
            atual.proximo = novo;
            novo.anterior = atual;
            atual = novo;
        }
    }

    private static void desfazer() {
        if (atual != null) {
            atual = atual.anterior;
        } else {
            System.out.println("Nada para desfazer.");
        }
    }

    private static void refazer() {
        if (atual != null && atual.proximo != null) {
            atual = atual.proximo;
        } else {
            System.out.println("Nada para refazer.");
        }
    }

    private static void exibirTexto() {
        Nodo temp = inicio;
        while (temp != null) {
            System.out.print(temp.texto + " ");
            temp = temp.proximo;
        }
        System.out.println();
    }
}

