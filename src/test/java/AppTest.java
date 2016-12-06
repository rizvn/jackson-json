import model.*;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by Riz
 */
public class AppTest {

  @Test
  public void bindTest() throws Exception{
    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
    User user = mapper.readValue(new File("src/test/resources/test.json"), User.class);
    Assert.assertNotNull(user);
  }

  @Test
  public void bindInheritance() throws Exception{
    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
    mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
    Fleet fleet = mapper.readValue(new File("src/test/resources/vehicles2.json"), Fleet.class);
    Assert.assertNotNull(fleet);
  }

  @Test
  public void generate() throws Exception{
    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
    mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
    Fleet fleet = new Fleet();
    Car car = new Car();
    car.setSeatingCapacity(5);
    car.setTopSpeed(120);

    Truck truck = new Truck();
    truck.setPayloadCapacity(100);

    fleet.getVehicles().add(car);
    fleet.getVehicles().add(truck);

    String jsonDataString = mapper.writeValueAsString(fleet);

    System.out.println(jsonDataString);

  }
}
