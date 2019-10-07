package com.java.samples.tdd;

public class ProcessoDeVacinacao {

    private final EnfermeiraId enfermeira;

    private final PacienteId paciente;
    
    private boolean aplicado;

    public ProcessoDeVacinacao(EnfermeiraId enfermeira, PacienteId paciente) {
        this.enfermeira = enfermeira;
        this.paciente = paciente;
        this.aplicado = false;
    }

    public EnfermeiraId getEnfermeira() {
        return enfermeira;
    }

    public PacienteId getPaciente() {
        return paciente;
    }

    public void administrarVacina(Vacina vacina, int dose) {
        System.out.println("Vacina: " + vacina + ", dose:" + dose + "ml.");
        if (dose != vacina.getVirus().getDosePadrao()) {
            throw new RuntimeException("Dose diferente da padrão.");
        }
        this.aplicado = true;
    }

    public boolean isAplicado() {
        return aplicado;
    }

}
