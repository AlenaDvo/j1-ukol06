package cz.czechitas.ukol06.svatky;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.MonthDay;
import java.util.List;
import java.util.stream.Stream;

public class SvatkySluzba {

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();
    private final Path cestaKDatum = Path.of("data/svatky.json");
    private final SeznamSvatku seznamSvatku;

    public SvatkySluzba() throws IOException {
        // TODO načíst seznam svátků ze souboru svatky.json
        seznamSvatku = objectMapper.readValue(cestaKDatum.toFile(), SeznamSvatku.class);
        // Následující řádek po vlastní implementaci smažete.
//        seznamSvatku = null;
    }

    public List<String> vyhledatSvatkyDnes() {
        return vyhledatSvatkyKeDni(MonthDay.now());
    }

//    public Stream<Svatek> svatkyStream() {
//        try {
//            Path path = Paths.get(SeznamSvatku.class.getResource(cestaKDatum.toURI());
//            return Files.lines(path).map(SeznamSvatku::parseLine);
//        } catch (URISyntaxException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public List<String> vyhledatSvatkyKeDni(MonthDay day) {
        // TODO
        // získat seznam svátků pro tento den
        // převést na Stream
        // pomocí metody filter() vybrat jen ty, které odpovídají zadanému dni (porovnat MonthDay pomocí metodyequals())
        // pomocí metody map() získat z objektu jméno
        // pomocí toList() převést na List

        List<Svatek> vsechnySvatky = seznamSvatku.getSvatky();
        return vsechnySvatky.stream()
                .filter(svatek -> svatek.getDen().equals(day))
//                .filter(svatek -> svatek.getJmeno().length() > 3)
                .map(Svatek::getJmeno)
                .toList();

        // Následující řádek po vlastní implementaci smažete.
//        return List.of();
    }
}
