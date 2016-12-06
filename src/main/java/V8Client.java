import model.V8Response;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by Riz
 */
public class V8Client {

  /**
   * @param flow - will be the flow file, however for testing purposes this is json
   * @param industry
   * @return V8Response
   */
  public V8Response parse(String flow, String industry)
  {
    try
    {
      ObjectMapper mapper = new ObjectMapper();
      mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES); //ignore unmapped

      //read json as v8 response
      return mapper.readValue(flow, V8Response.class);
    }
    catch (Exception ex)
    {
      throw new IllegalStateException(ex);
    }
  }
}
