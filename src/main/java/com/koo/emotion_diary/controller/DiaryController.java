package com.koo.emotion_diary.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koo.emotion_diary.domain.DiaryDTO;
import com.koo.emotion_diary.domain.UserDTO;
import com.koo.emotion_diary.service.DiaryService;

import jakarta.servlet.http.HttpSession;

@RestController
public class DiaryController {
  private final DiaryService diaryService;

  public DiaryController(DiaryService diaryService) {
    this.diaryService = diaryService;
  }

  // 일기 목록
  @GetMapping("/diaryList")
  public List<DiaryDTO> diaryList(HttpSession session) {
    UserDTO user = (UserDTO) session.getAttribute("loginUser");
    List<DiaryDTO> list = diaryService.diaryList(user.getId());

    return list;
  }

  // 일기 작성
  @PostMapping("/createDiary")
  public Map<String, Object> createDiary(DiaryDTO param) {
    Map<String, Object> result = new HashMap<>();
    int flag = diaryService.createDiary(param);

    if (flag == 1) {
      result.put("success", true);
      result.put("message", "일기 작성!");
    } else {
      result.put("success", false);
      result.put("message", "일기 작성 실패!");
    }
    return result;
  }

  @PostMapping("/updateDiary")
  public Map<String, Object> updateDiary(DiaryDTO param) {
    Map<String, Object> result = new HashMap<>();
    int flag = diaryService.updateDiary(param);

    if (flag == 1) {
      result.put("success", true);
      result.put("message", "일기 수정 성공!");
    } else {
      result.put("success", false);
      result.put("message", "일기 수정 실패!");
    }
    return result;
  }

  @PostMapping("/deleteDiary")
  public Map<String, Object> deleteDiary(DiaryDTO param) {
    Map<String, Object> result = new HashMap<>();
    int flag = diaryService.deleteDiary(param.getNo());

    if (flag == 1) {
      result.put("success", true);
      result.put("message", "일기 삭제 성공!");
    } else {
      result.put("success", false);
      result.put("message", "일기 삭제 실패!");
    }
    return result;
  }

}
