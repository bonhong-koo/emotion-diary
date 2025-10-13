package com.koo.emotion_diary.domain;

public class UserDTO {
  private String id;
  private String password;
  private String name;
  private String createDate;

  public UserDTO() {
  }

  public UserDTO(String id, String password, String name, String createDate) {
    this.id = id;
    this.password = password;
    this.name = name;
    this.createDate = createDate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  @Override
  public String toString() {
    return "UserDTO [id=" + id + ", password=" + password + ", name=" + name + ", createDate=" + createDate + "]";
  }
}
