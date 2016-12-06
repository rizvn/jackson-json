import model.elec.D0062;
import model.elec.D0063;
import model.base.Group;
import model.V8Response;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Riz
 */
public class AppTest {

  @Test
  public void testDeserialise() throws Exception{
    V8Client v8Client = new V8Client();

    String jsonFlow = loadStringFromFile("src/test/resources/flow.json");

    V8Response v8Response = v8Client.parse(jsonFlow, "RGMA", false);

    //get 1st group
    D0062 d0062 = v8Response.getGroups().get(0).typed();

    //get d0062.d0063
    D0063 d0063 = d0062.getGroups().get(0).typed();

    Assert.assertNotNull("should not be null, but was",d0062);
    Assert.assertNotNull("should not be null but was", d0063);
    Assert.assertEquals("Did not match contents of json file", "123", d0062.getJ0003());
  }

  private String loadStringFromFile(String path){
    try(Scanner scanner = new Scanner(new File(path), "UTF-8" )){
      return scanner.useDelimiter("\\A").next();
    }
    catch (Exception ex)
    {
      throw new IllegalStateException(ex);
    }
  }

  @Test
  public void testSerialise() throws Exception{
    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
    mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
    V8Response v8Response = new V8Response();
    D0062 d0062 = new D0062();

    d0062.setJ0003("300J");
    d0062.setJ0010("010J");

    D0063 d0063 = new D0063();
    d0063.setJ0018("8100J");
    d0063.setJ0102("2010J");
    d0063.setJ0103("300J");

    d0062.getGroups().add(d0063);
    v8Response.getGroups().add(d0062);

    String jsonDataString = mapper.writeValueAsString(v8Response);
    System.out.println(jsonDataString);
  }


  @Test
  public void testReturnGroupsOfType() throws Exception{
    V8Client v8Client = new V8Client();

    String jsonFlow = loadStringFromFile("src/test/resources/flow.json");

    V8Response v8Response = v8Client.parse(jsonFlow, "RGMA", false);

    //get 1st group
    List<Group> d0062s = v8Response.getGroupsOfType(D0062.class);


    Assert.assertFalse("Should return group of type d0062, but didnt", d0062s.isEmpty());
  }
}
