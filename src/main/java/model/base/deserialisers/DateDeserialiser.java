package model.base.deserialisers;


import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Riz
 */
public class DateDeserialiser extends StdDeserializer<LocalDate> {

  private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMDD");

  public DateDeserialiser(){
    super(LocalDate.class);
  }

  @Override
  public LocalDate deserialize(JsonParser parser, DeserializationContext ctx) throws IOException, JsonProcessingException {
    String value = parser.getText();
    return LocalDate.parse(value, fmt);
  }
}
