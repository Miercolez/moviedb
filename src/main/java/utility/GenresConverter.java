package utility;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class GenresConverter implements AttributeConverter<Genres, String> {

    @Override
    public String convertToDatabaseColumn(Genres genres) {
        if (genres == null) {
            return null;
        }
        return genres.label;
    }

    @Override
    public Genres convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return Stream.of(Genres.values())
                .filter(g -> g.getLabel().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
