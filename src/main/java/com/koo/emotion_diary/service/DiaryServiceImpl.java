package com.koo.emotion_diary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koo.emotion_diary.domain.DiaryDTO;
import com.koo.emotion_diary.mapper.DiaryMapper;

@Service
public class DiaryServiceImpl implements DiaryService {

  private final DiaryMapper diaryMapper;

  public DiaryServiceImpl(DiaryMapper diaryMapper) {
    this.diaryMapper = diaryMapper;
  }

  @Override
  public int createDiary(DiaryDTO param) {
    return diaryMapper.createDiary(param);
  }

  @Override
  public List<DiaryDTO> diaryList(String id) {
    return diaryMapper.diaryList(id);
  }

  @Override
  public DiaryDTO selectDiary(int no) {
    return diaryMapper.selectDiary(no);
  }

  @Override
  public int updateDiary(DiaryDTO param) {
    return diaryMapper.updateDiary(param);
  }

  @Override
  public int deleteDiary(int no) {
    return diaryMapper.deleteDiary(no);
  }

}
