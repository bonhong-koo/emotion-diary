package com.koo.emotion_diary.service;

import com.koo.emotion_diary.domain.UserDTO;

public interface UserService {

  // 로그인
  public boolean login(UserDTO param);

  // 회원가입
  public int createUser(UserDTO param);
}
