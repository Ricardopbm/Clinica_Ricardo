import java.time.LocalDateTime;

public class Exame implements Agendavel {

    private String nome;
    private LocalDateTime dataHora;
    private Paciente paciente;
    private Tecnico tecnico;
    private String laudo;
    private boolean encerrado;

    public Exame(String nome, LocalDateTime dataHora, Paciente paciente, Tecnico tecnico) {
        this.nome = nome;
        this.dataHora = dataHora;
        this.paciente = paciente;
        this.tecnico = tecnico;
        this.laudo = "";
        this.encerrado = false;
    }

    // Métodos da interface Agendavel
    @Override
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public Paciente getPaciente() {
        return paciente;
    }

    // Getters e setters restantes
    public String getNome() {
        return nome;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public String getLaudo() {
        return laudo;
    }

    public boolean isEncerrado() {
        return encerrado;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public void setEncerrado(boolean encerrado) {
        this.encerrado = encerrado;
    }
}
