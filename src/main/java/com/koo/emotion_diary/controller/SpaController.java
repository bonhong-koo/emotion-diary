package com.koo.emotion_diary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpaController {
  @GetMapping({ "/{path:[^\\.]*}" })
  public String forward() {
    return "forward:/index.html";
  }

  @GetMapping("/{p1:[^\\.]*}/{p2:[^\\.]*}")
  public String d2() {
    return "forward:/index.html";
  }
}
