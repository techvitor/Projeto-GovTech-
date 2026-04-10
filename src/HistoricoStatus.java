import java.time.LocalDateTime;

public class HistoricoStatus {
    private Status status;
    private LocalDateTime data;
    private String responsavel;
    private String comentario;

    public HistoricoStatus(Status status, String responsavel, String comentario) {
        this.status = status;
        this.data = LocalDateTime.now();
        this.responsavel = responsavel;
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "[" + data + "] Status: " + status + " | Por: " + responsavel + " | Obs: " + comentario;
    }

}
