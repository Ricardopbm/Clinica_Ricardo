import java.time.LocalDateTime;

public class AgendamentoDeConsulta {

    public static boolean agendar(Medico medico, Paciente paciente, LocalDateTime horario) {
        // 1. A médica tem esse horário?
        if (!medico.getAgenda().containsKey(horario)) {
            System.out.println("Esse horário não está na agenda do médico.");
            return false;
        }

        // 2. O horário já está ocupado?
        if (medico.getAgenda().get(horario) != null) {
            System.out.println("Esse horário já está ocupado.");
            return false;
        }

        // 3. Tudo certo, podemos agendar!
        Consulta novaConsulta = new Consulta(horario, medico, paciente);

        // 4. Registrar nos dois lados
        medico.getAgenda().put(horario, novaConsulta);
        paciente.adicionarConsultaAoHistorico(novaConsulta);

        System.out.println("Consulta agendada com sucesso.");
        return true;
    }
}
