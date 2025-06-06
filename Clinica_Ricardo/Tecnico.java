import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Pessoa {

    private List<Exame> examesMarcados;

    public Tecnico(String nome, String cpf, String email, String telefone) {
        super(nome, cpf, email, telefone);
        this.examesMarcados = new ArrayList<>();
    }

    // método para marcar um exame
    public void marcarExame(Exame exame) {
        examesMarcados.add(exame);
    }

    // método para encerrar exame e gerar o laudo
    public void encerrarExame(Exame exame, String laudo) {
        exame.setLaudo(laudo);
        exame.setEncerrado(true);
    }

    public List<Exame> getExamesMarcados() {
        return examesMarcados;
    }

}
