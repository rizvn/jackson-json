package model;

import model.base.Group;
import model.elec.D0062;
import model.elec.D0063;
import model.gas.UD02;
import model.gas.UD03;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class V8Response {
    private List<Group> groups = new ArrayList<Group>();

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.PROPERTY, defaultImpl = Group.class)
    @JsonSubTypes({
      //---- ELEC GROUPS ---
      @JsonSubTypes.Type(name = "D0062", value = D0062.class),
      @JsonSubTypes.Type(name = "D0063", value = D0063.class),

      //---- GAS GROUPS ---
      @JsonSubTypes.Type(name = "UD02", value = UD02.class),
      @JsonSubTypes.Type(name = "UD03", value = UD03.class),
    })
    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Group> getGroupsOfType(Class<?> type){
       return getGroups().stream()
                .filter(group -> group.getClass().getCanonicalName().equals(type.getCanonicalName())) //return only groups of type
                .collect(Collectors.toList()); //return list
    }
}