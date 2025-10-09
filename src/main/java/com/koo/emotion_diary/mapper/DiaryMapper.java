package com.koo.emotion_diary.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.koo.emotion_diary.domain.DiaryDTO;

@Mapper
public interface DiaryMapper {

  // 일기 작성
  public int createDiary(DiaryDTO param);

  // 일기 목록 전체 조회
  public List<DiaryDTO> diaryList(String id);

  // 일기 단건 조회
  public DiaryDTO selectDiary(int no);

  // 일기 수정
  public int updateDiary(DiaryDTO param);

  // 일기 삭제
  public int deleteDiary(int no);

  // 전체 삭제
  public int deleteAll();

  // 전체 일기 수 조회
  public int getAll();

  // 일기 no 조회 test용
  public int getNo(String id);

}
