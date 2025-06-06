
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {

    private LocalDate dtNascimento;
    private String sexo;
    private String tipoSanguineo;

    private List<Consulta> historicoConsultas;

//construtor
    public Paciente(String nome, String cpf, String email, String telefone,
            LocalDate dtNascimento, String sexo, String tipoSanguineo) {

//superclasse: cria a parte da Pessoa dentro do Paciente com esses dados
        super(nome, cpf, email, telefone);
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
        this.tipoSanguineo = tipoSanguineo;
        this.historicoConsultas = new ArrayList<>();
//arraylist vazio sem ser parametro porque pode ser a primeira consulta do paciente        
            }

//getters

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public List<Consulta> getHistoricoConsultas() {
        return historicoConsultas;
    }

    // adiciona uma consulta no histórico
    public void adicionarConsultaAoHistorico(Consulta consulta) {
        historicoConsultas.add(consulta);
    }

    public void mostrarHistorico() {
    System.out.println("\n--- Histórico de Consultas de " + getNome() + " ---");
    
    if (historicoConsultas.isEmpty()) {
        System.out.println("Nenhuma consulta realizada ainda.");
    } else {
        for (Consulta consulta : historicoConsultas) {
            System.out.println("\nConsulta em: " + consulta.getDataHora());
            System.out.println("Médico: " + consulta.getMedico().getNome());

            Prontuario prontuario = consulta.getProntuario();
            if (prontuario != null) {
                System.out.println("- Detalhes: " + prontuario.getDetalhes());
                System.out.println("- Sintomas: " + prontuario.getSintomas());
                System.out.println("- Exames solicitados: " + prontuario.getExamesSolicitados());
                System.out.println("- Medicamentos: " + prontuario.getMedicamentos());
            } else {
                System.out.println("- Consulta ainda não foi encerrada.");
            }
        }
    }
}

}
