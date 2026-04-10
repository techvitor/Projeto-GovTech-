import java.util.Scanner;

public class ObservaAcaoApp {
    private static ServicoSolicitacoes servico = new ServicoSolicitacoes();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== OBSERVAAÇÃO: GOVTECH ===");
            System.out.println("1. Registrar Solicitação\n2. Consultar Protocolo\n3. Painel Gestor (Listar)\n4. Sair");
            int opcao = Integer.parseInt(sc.nextLine());

            if (opcao == 1) registrar();
            else if (opcao == 2) consultar();
            else if (opcao == 3) painelGestor();
            else break;
        }
    }

    private static void registrar() {
        System.out.print("Categoria: "); String cat = sc.nextLine();
        System.out.print("Descrição: "); String desc = sc.nextLine();
        System.out.print("Bairro: "); String bairro = sc.nextLine();
        System.out.print("Prioridade (1-Baixa a 4-Urgente): "); int p = Integer.parseInt(sc.nextLine());
        System.out.print("Anônimo? (s/n): "); boolean anon = sc.nextLine().equalsIgnoreCase("s");

        String protocolo = servico.criar(cat, desc, bairro, p, anon);
        System.out.println("SUCESSO! Guarde seu protocolo: " + protocolo);
    }

    private static void consultar() {
        System.out.print("Informe o protocolo: ");
        String prot = sc.nextLine();
        Solicitacao s = servico.buscar(prot);
        if (s != null) s.exibirDetalhes();
        else System.out.println("Protocolo não encontrado.");
    }

    private static void painelGestor() {
        System.out.println("\n--- LISTAGEM DE DEMANDAS ---");
        servico.listarTodas().forEach(s ->
                System.out.println(s.getProtocolo() + " | " + s.getStatusAtual() + " | " + s.getBairro()));
    }
}
