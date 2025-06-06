import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // criar médica
        ArrayList<String> especialidades = new ArrayList<>();
        especialidades.add("Clínica Geral");
        especialidades.add("Cardiologia");

        Medico medico = new Medico(
            "Dr. Ricardo Meio Surdo", 
            "123.456.789-10", 
            "ric@clinica.com", 
            "53 99974-2404",
            "CRM04092005", 
            especialidades
        );

        // criar paciente
        Paciente paciente = new Paciente(
            "Otavio Mesquita", 
            "987.654.321-00", 
            "mesquitao@gmail.com", 
            "53 98888-8888",
            LocalDate.of(1990, 5, 20),  
            "Masculino", 
            "O+"
        );

        // criar técnico
        Tecnico tecnico = new Tecnico(
            "Marcio tecnico", 
            "111.222.333-44", 
            "java@clinica.com", 
            "53 99999-9999"
        );

        // médica abrindo agenda
        LocalDate dataHoje = LocalDate.now();
        medico.abrirAgenda(dataHoje);
        System.out.println("\nAgenda do médico:");
        medico.mostrarHorariosDisponiveis();

        // agendando consulta 
        LocalDateTime horarioConsulta = dataHoje.atTime(10, 0);
        boolean agendado = AgendamentoDeConsulta.agendar(medico, paciente, horarioConsulta);

        // encerrar consulta 
        if (agendado) {  //(se foi agendada)
            Consulta consulta = medico.getAgenda().get(horarioConsulta);
            consulta.encerrarConsulta(
                "Consulta de rotina",
                "Dor no peito",
                "Raio-X do tórax",
                "Doril, somente quando sentir dor"
            );
            System.out.println("\nConsulta encerrada com sucesso!");
        } else {
            System.out.println("\nNão foi possível agendar a consulta.");
        }

        // marcar exame
        Exame exame = new Exame(
            "Raio-X do tórax", 
            dataHoje.atTime(14, 0), 
            paciente, 
            tecnico
        );

        tecnico.marcarExame(exame);
        System.out.println("\nExame marcado com sucesso.");

        // encerrar exame / gerar laudo
        tecnico.encerrarExame(exame, "Imagem normal, sem alterações.");
        System.out.println("Exame encerrado e laudo gerado.");

        // mostrar histórico do paciente
        paciente.mostrarHistorico();
    }
}
