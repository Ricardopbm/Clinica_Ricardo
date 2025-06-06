import java.time.LocalDateTime;

public class AgendamentoDeConsulta {

    public static boolean agendar(Medico medica, Paciente paciente, LocalDateTime horario) {
        // 1. A médica tem esse horário?
        if (!medica.getAgenda().containsKey(horario)) {
            System.out.println("Esse horário não está na agenda do médico.");
            return false;
        }

        // 2. O horário já está ocupado?
        if (medica.getAgenda().get(horario) != null) {
            System.out.println("Esse horário já está ocupado.");
            return false;
        }

        // 3. Tudo certo, podemos agendar!
        Consulta novaConsulta = new Consulta(horario, medica, paciente);

        // 4. Registrar nos dois lados
        medica.getAgenda().put(horario, novaConsulta);
        paciente.adicionarConsultaAoHistorico(novaConsulta);

        System.out.println("Consulta agendada com sucesso.");
        return true;
    }
}
