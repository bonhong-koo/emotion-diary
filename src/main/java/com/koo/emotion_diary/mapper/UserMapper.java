package com.koo.emotion_diary.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.koo.emotion_diary.domain.UserDTO;

@Mapper
public interface UserMapper {

  // 회원가입
  public int createUser(UserDTO param);

  // 로그인
  public int loginUser(String id, String password);

  // 아이디 중복 확인
  public int checkId(String id);

  // 회원삭제
  public int deleteUser(String id);

  // 회원 전체 삭제
  public int deleteAll();

  // 전체 회원 수 조회
  public int getCount();

}
