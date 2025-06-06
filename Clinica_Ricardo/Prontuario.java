public class Prontuario {
    private String detalhes;
    private String sintomas;
    private String examesSolicitados;
    private String medicamentos;

    public Prontuario(String detalhes, String sintomas, String examesSolicitados, String medicamentos) {
        this.detalhes = detalhes;
        this.sintomas = sintomas;
        this.examesSolicitados = examesSolicitados;
        this.medicamentos = medicamentos;
    }

    // Getters 
    public String getDetalhes(){
        return detalhes;
    }

    public String getSintomas(){
        return sintomas;
    }

    public String getExamesSolicitados(){
        return examesSolicitados;
    }

    public String getMedicamentos(){
        return medicamentos;
    }



}
