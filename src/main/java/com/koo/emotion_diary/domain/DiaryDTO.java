package com.koo.emotion_diary.domain;

public class DiaryDTO {
  private int no;
  private String id;
  private int emotion;
  private String title;
  private String content;
  private String date;

  public DiaryDTO() {
  }

  public DiaryDTO(int no, String id, int emotion, String title, String content, String date) {
    this.no = no;
    this.id = id;
    this.emotion = emotion;
    this.title = title;
    this.content = content;
    this.date = date;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getEmotion() {
    return emotion;
  }

  public void setEmotion(int emotion) {
    this.emotion = emotion;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "DiaryDTO [no=" + no + ", id=" + id + ", emotion=" + emotion + ", title=" + title + ", content=" + content
        + ", date=" + date + "]";
  }
}
