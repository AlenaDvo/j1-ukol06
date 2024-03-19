package cz.czechitas.ukol06.svatky;

import org.junit.jupiter.api.Test;

import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SvatkySluzbaTest {

    private final SvatkySluzba svatkySluzba= new SvatkySluzba();

    @Test
    void vyhledatSvatekKeDniKdyMaSvatekJedenClovek() {
        //TODO implementovat test metody vyhledatSvatkyKeDni
        //den, kdy má svátek jedno jméno
        List<String> jednoJmeno = List.of("Diana");
        List<String> vysledek = svatkySluzba.vyhledatSvatkyKeDni(MonthDay.parse("--02-04"));

        assertEquals(jednoJmeno, vysledek);
    }

    @Test
    void vyhledatSvatekKeDniKdyMaSvatekVicLidi() {
        //dem. kdy ma svatek více jmen

    }

    @Test
    void vyhledatSvatekKeDniKdyNemaSvatekNikdo() {
        //den, kdy nema svatek nikdo
    }
}
