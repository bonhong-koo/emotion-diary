package com.koo.emotion_diary.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koo.emotion_diary.domain.UserDTO;
import com.koo.emotion_diary.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/api/login")
  public Map<String, Object> login(@RequestBody UserDTO param, HttpSession session) {
    Map<String, Object> result = new HashMap<>();

    boolean flag = userService.login(param);

    if (flag) {
      result.put("success", true);
      result.put("message", "로그인 성공!");

      UserDTO user = userService.selectUser(param.getId());

      session.setAttribute("loginUser", user);

    } else {
      result.put("success", false);
      result.put("message", "로그인 실패!");
    }

    return result;
  }

  @PostMapping("/api/create")
  public Map<String, Object> createUser(@RequestBody UserDTO param) {
    Map<String, Object> result = new HashMap<>();

    int flag = userService.createUser(param);

    if (flag == 1) {
      result.put("success", true);
      result.put(("message"), "회원가입 성공!");
    } else {
      result.put("success", false);
      result.put("message", "회원가입 실패!");
    }

    return result;
  }

  @GetMapping("/api/logout")
  public Map<String, Object> logout(HttpSession session) {
    Map<String, Object> result = new HashMap<>();

    result.put("success", true);
    result.put("message", "로그아웃!");

    session.invalidate();

    return result;
  }

  @GetMapping("/api/checkId")
  public Map<String, Object> checkId(@RequestParam("id") String id) {
    Map<String, Object> result = new HashMap<>();
    int flag = userService.checkId(id);
    if (flag == 1) {
      result.put("duplicated", true);
      result.put("message", "중복된 ID 입니다.");
    } else {
      result.put("duplicated", false);
      result.put("message", "사용가능한 ID 입니다.");
    }

    return result;
  }

  @GetMapping("/api/getSession")
  public Map<String, Object> getSession(HttpSession session) {
    Map<String, Object> result = new HashMap<>();
    UserDTO user = (UserDTO) session.getAttribute("loginUser");
    if (user != null) {
      result.put("success", true);
      result.put("user", user);
    } else {
      result.put("success", false);
    }
    return result;

  }

}
