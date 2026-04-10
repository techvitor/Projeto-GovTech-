import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solicitacao {
    private String protocolo;
    private String categoria;
    private String descricao;
    private String bairro;
    private Prioridade prioridade;
    private boolean isAnonimo;
    private Status statusAtual;
    private List<HistoricoStatus> historico = new ArrayList<>();

    public Solicitacao(String categoria, String descricao, String bairro, Prioridade prioridade, boolean isAnonimo) {
        this.protocolo = "PRT" + new Random().nextInt(10000, 99999);
        this.categoria = categoria;
        this.descricao = descricao;
        this.bairro = bairro;
        this.prioridade = prioridade;
        this.isAnonimo = isAnonimo;
        this.statusAtual = Status.ABERTO;
        adicionarHistorico(Status.ABERTO, "Sistema", "Solicitação criada pelo cidadão.");
    }

    public void adicionarHistorico(Status novoStatus, String responsavel, String comentario) {
        this.statusAtual = novoStatus;
        this.historico.add(new HistoricoStatus(novoStatus, responsavel, comentario));
    }


    public String getProtocolo() {
        return protocolo;
    }

    public Status getStatusAtual() {
        return statusAtual;
    }

    public void exibirDetalhes() {
        System.out.println("\n--- DETALHES DA SOLICITAÇÃO ---");
        System.out.println("Protocolo: " + protocolo + (isAnonimo ? " (ANÔNIMO)" : " (IDENTIFICADO)"));
        System.out.println("Categoria: " + categoria + " | Prioridade: " + prioridade);
        System.out.println("Bairro: " + bairro);
        System.out.println("Descrição: " + descricao);
        System.out.println("Status Atual: " + statusAtual);
        System.out.println("Histórico:");
        historico.forEach(h -> System.out.println("  " + h));
    }
}
