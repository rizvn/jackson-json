package model;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class V8Response {
    private List<Group> groups = new ArrayList<Group>();

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.PROPERTY, defaultImpl = Group.class)
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

    public List<Group> getGroupsOfType(Class<?> type){
       return getGroups().stream()
                .filter(group -> group.getClass().getCanonicalName().equals(type.getCanonicalName())) //return only groups of type
                .collect(Collectors.toList()); //return list
    }
}