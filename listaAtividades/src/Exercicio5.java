import java.util.Scanner;

class Carta {
    String valor;
    Carta anterior;
    Carta proximo;

    public Carta(String valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}

public class Exercicio5 {
    static Carta inicio = null;
    static Carta fim = null;

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("Jogo de Cartas:");
            System.out.println("1. Adicionar Carta");
            System.out.println("2. Remover Carta");
            System.out.println("3. Reorganizar Cartas");
            System.out.println("4. Exibir Cartas");
            System.out.println("5. Voltar ao Menu Principal");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor da carta: ");
                    String valor = scanner.nextLine();
                    adicionarCarta(valor);
                    break;
                case 2:
                    System.out.print("Digite o valor da carta a remover: ");
                    valor = scanner.nextLine();
                    removerCarta(valor);
                    break;
                case 3:
                    System.out.print("Digite o valor da carta a mover: ");
                    String carta = scanner.nextLine();
                    System.out.print("Digite a nova posição: ");
                    int posicao = scanner.nextInt();
                    scanner.nextLine(); // Consome a nova linha
                    reorganizarCarta(carta, posicao);
                    break;
                case 4:
                    exibirCartas();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarCarta(String valor) {
        Carta nova = new Carta(valor);
        if (inicio == null) {
            inicio = nova;
            fim = nova;
        } else {
            fim.proximo = nova;
            nova.anterior = fim;
            fim = nova;
        }
    }

    private static void removerCarta(String valor) {
        Carta temp = inicio;
        while (temp != null && !temp.valor.equals(valor)) {
            temp = temp.proximo;
        }
        if (temp == null) {
            System.out.println("Carta não encontrada.");
            return;
        }
        if (temp.anterior != null) {
            temp.anterior.proximo = temp.proximo;
        } else {
            inicio = temp.proximo;
        }
        if (temp.proximo != null) {
            temp.proximo.anterior = temp.anterior;
        } else {
            fim = temp.anterior;
        }
    }

    private static void reorganizarCarta(String valor, int posicao) {
        removerCarta(valor);
        Carta nova = new Carta(valor);
        if (posicao == 0) {
            nova.proximo = inicio;
            if (inicio != null) {
                inicio.anterior = nova;
            }
            inicio = nova;
            if (fim == null) {
                fim = nova;
            }
            return;
        }
        Carta temp = inicio;
        for (int i = 0; i < posicao - 1 && temp != null; i++) {
            temp = temp.proximo;
        }
        if (temp != null) {
            nova.proximo = temp.proximo;
            nova.anterior = temp;
            if (temp.proximo != null) {
                temp.proximo.anterior = nova;
            }
            temp.proximo = nova;
            if (nova.proximo == null) {
                fim = nova;
            }
        }
    }

    private static void exibirCartas() {
        Carta temp = inicio;
        while (temp != null) {
            System.out.print(temp.valor + " ");
            temp = temp.proximo;
        }
        System.out.println();
    }
}
