package model;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

public abstract class Group {

  List<Group> groups = new ArrayList<Group>();

  @JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "type",
    include = JsonTypeInfo.As.PROPERTY,
    defaultImpl = Group.class
  )
  @JsonSubTypes({
    @JsonSubTypes.Type(name = "D0062", value = D0062.class),
    @JsonSubTypes.Type(name = "D0063", value = D0063.class)
  })
  public List<Group> getGroups() {
    return groups;
  }

  public void setGroups(List<Group> groups) {
    this.groups = groups;
  }

  public <T> T typed(){
    return (T) this;
  }
}