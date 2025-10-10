package com.koo.emotion_diary.service;

import java.util.List;

import com.koo.emotion_diary.domain.DiaryDTO;

public interface DiaryService {

  // 일기 작성
  public int createDiary(DiaryDTO param);

  // 일기 목록 조회
  public List<DiaryDTO> diaryList(String id);

  // 일기 단건 조회
  public DiaryDTO selectDiary(int no);

  // 일기 수정
  public int updateDiary(DiaryDTO param);

  // 일기 삭제
  public int deleteDiary(int no);
}
