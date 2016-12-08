import model.V8Response;
import model.base.deserialisers.DateDeserialiser;
import model.base.deserialisers.DateTimeDeserialiser;
import model.base.deserialisers.TimeDeserialiser;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Riz
 */
public class V8Client {

  /**
   * @param flow - will be the flow file, however for testing purposes this is json
   * @param industry
   * @return V8Response
   */
  public V8Response parse(String flow, String industry, boolean strictValidation)
  {
    try
    {
      ObjectMapper mapper = new ObjectMapper();

      SimpleModule module = new SimpleModule("base", new Version(1, 1, 1, "1"));
      module.addDeserializer(LocalDate.class, new DateDeserialiser());
      module.addDeserializer(LocalDateTime.class, new DateTimeDeserialiser());
      module.addDeserializer(LocalTime.class, new TimeDeserialiser());
      mapper.registerModule(module);

      if(!strictValidation)
      {
        mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES); //ignore unmapped items
      }

      //read json as v8 response
      return mapper.readValue(flow, V8Response.class);
    }
    catch (Exception ex)
    {
      throw new IllegalStateException(ex);
    }
  }
}
