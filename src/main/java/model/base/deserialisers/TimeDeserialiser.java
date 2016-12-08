package model.base.deserialisers;


import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Riz
 */
public class TimeDeserialiser extends StdDeserializer<LocalTime> {

  private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HHmmss");

  public TimeDeserialiser(){
    super(LocalTime.class);
  }

  @Override
  public LocalTime deserialize(JsonParser parser, DeserializationContext ctx) throws IOException, JsonProcessingException {
    String value = parser.getText();
    return LocalTime.parse(value, fmt);
  }
}
