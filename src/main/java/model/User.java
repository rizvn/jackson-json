package model;

import sun.plugin2.message.Message;

import java.util.List;

public class User {

  private String name;
  private int age;
  private List<Message> messages;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }



  //getters and setters
}