package br.com.chronosAcademy.logica;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicaTest {

    @Test
    public void validarTerrenoGrande(){

        Logica logica = new Logica();
        assertEquals("Terreno grande", logica.getTipoTerreno(101));
    }

    @Test
    public void validarTerrenoPequeno(){

        Logica logica = new Logica();
        assertEquals("Terreno pequeno", logica.getTipoTerreno(100));
    }

}