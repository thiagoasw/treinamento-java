package com.treinamento.java;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.java.samples.tdd.EnfermeiraId;
import com.java.samples.tdd.PacienteId;
import com.java.samples.tdd.ProcessoDeVacinacao;
import com.java.samples.tdd.Seringa;
import com.java.samples.tdd.Vacina;
import com.java.samples.tdd.Virus;

public class TDDCaseTest {

    @Test
    void testEnfermeiraAplicaVacinaDaGripeEmDosePadrao() throws Exception {
        
        // GIVEN (DADO)
        
        Seringa seringa = new Seringa();
        Vacina gripe = new Vacina(Virus.GRIPE, seringa);
        
        PacienteId paciente = new PacienteId();
        EnfermeiraId enfermeira = new EnfermeiraId();
        

        ProcessoDeVacinacao processo = new ProcessoDeVacinacao(enfermeira, paciente);
        
        // WHEN (QUANDO)
        processo.administrarVacina(gripe, gripe.getVirus().getDosePadrao());
        
        // THEN (ENTAO)
        assertTrue(processo.isAplicado());
    }
    
    @Test
    void testEnfermeiraAplicaVacinaDaGripeEmDoseFatal() throws Exception {
        
        // GIVEN (DADO)        
        Seringa seringa = new Seringa();
        Vacina gripe = new Vacina(Virus.GRIPE, seringa);
        
        PacienteId paciente = new PacienteId();
        EnfermeiraId enfermeira = new EnfermeiraId();

        ProcessoDeVacinacao processo = new ProcessoDeVacinacao(enfermeira, paciente);

        // THEN (ENTAO)
        assertThrows(RuntimeException.class, () -> {
            // WHEN (QUANDO)
            processo.administrarVacina(gripe, 999);    
        });
    }
    
}
