package cz.czechitas.ukol06.svatky;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SvatkySluzbaTest {

    @Test
    void vyhledatSvatekKeDniKdyMaSvatekJedenClovek() throws IOException {
        // test metody vyhledatSvatkyKeDni
        // den, kdy má svátek jedno jméno
        SvatkySluzba svatkySluzba = new SvatkySluzba();
        assertEquals(List.of("Diana"), svatkySluzba.vyhledatSvatkyKeDni(MonthDay.parse("--01-04")));
    }

    @Test
    void vyhledatSvatekKeDniKdyMaSvatekVicLidi() throws IOException {
        // den, kdy ma svatek více jmen
        SvatkySluzba svatkySluzba = new SvatkySluzba();
        assertEquals(List.of("Vladan", "Valtr"), svatkySluzba.vyhledatSvatkyKeDni(MonthDay.parse("--01-09")));
    }

    @Test
    void vyhledatSvatekKeDniKdyNemaSvatekNikdo() throws IOException {
        // den, kdy nema svatek nikdo
        SvatkySluzba svatkySluzba = new SvatkySluzba();
        assertEquals(List.of(), svatkySluzba.vyhledatSvatkyKeDni(MonthDay.parse("--01-01")));
    }
}
