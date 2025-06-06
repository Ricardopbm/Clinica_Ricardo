
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Medico extends Pessoa {

    private String crm;
    private ArrayList<String> especialidades;
    private HashMap<LocalDateTime, Consulta> agenda;

    public Medico(String nome, String cpf, String email, String telefone, String crm, ArrayList<String> especialidades) {
        super(nome, cpf, email, telefone);
        this.crm = crm;
        this.especialidades = especialidades;
        this.agenda = new HashMap<>();
    }

    public void abrirAgenda(LocalDate data) {
        for (int hora = 9; hora <= 16; hora++) {
            LocalDateTime horario = data.atTime(hora, 0);
            agenda.put(horario, null);
        }
    }

    public HashMap<LocalDateTime, Consulta> getAgenda() {
        return agenda;
    }

    
    public void mostrarHorariosDisponiveis() {
        System.out.println("Dr. " + this.getNome());

        System.out.print("Especialidades: ");
        for (String esp : especialidades) {
            System.out.print(esp + " ");
        }
        System.out.println();

        System.out.println("Horários disponíveis:");
        for (LocalDateTime horario : agenda.keySet()) {
            if (agenda.get(horario) == null) {
                System.out.println(horario);
            }
        }
    }

}
