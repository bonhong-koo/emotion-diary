package com.koo.emotion_diary.service;

import com.koo.emotion_diary.domain.UserDTO;

public interface UserService {

  // 로그인
  public boolean login(UserDTO param);

  // 회원가입
  public int createUser(UserDTO param);

  // 회원 조회
  public UserDTO selectUser(String id);

  // id 중복 체크
  public int checkId(String id);
}
