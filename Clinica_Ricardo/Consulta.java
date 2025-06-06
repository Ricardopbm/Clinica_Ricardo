import java.time.LocalDateTime;

public class Consulta implements Agendavel {
    private LocalDateTime dataHora;
    private Medico medico;
    private Paciente paciente;
    private Prontuario prontuario;

    public Consulta(LocalDateTime dataHora, Medico medico, Paciente paciente){
        this.dataHora = dataHora;
        this.medico = medico;
        this.paciente = paciente;
        this.prontuario = null; //começa sem prontuário
    }

    public void encerrarConsulta(String detalhes, String sintomas, String examesSolicitados, String medicomentos) {
        this.prontuario = new Prontuario(detalhes, sintomas, examesSolicitados, medicomentos);
        paciente.adicionarConsultaAoHistorico(this); 
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

    // Getters adicionais
    public Prontuario getProntuario() {
        return prontuario;
    }

    public Medico getMedico() {
        return medico;
    }
}
