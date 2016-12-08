package model.base.deserialisers;


import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Riz
 */
public class DateTimeDeserialiser extends StdDeserializer<LocalDateTime> {

  private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMDDHHmmss");

  public DateTimeDeserialiser(){
    super(LocalDateTime.class);
  }

  @Override
  public LocalDateTime deserialize(JsonParser parser, DeserializationContext ctx) throws IOException, JsonProcessingException {
    String value = parser.getText();
    return LocalDateTime.parse(value, fmt);
  }
}
