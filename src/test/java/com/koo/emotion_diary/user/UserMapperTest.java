package com.koo.emotion_diary.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.koo.emotion_diary.domain.UserDTO;
import com.koo.emotion_diary.mapper.UserMapper;

@SpringBootTest
public class UserMapperTest {

  private UserMapper userMapper;

  @Autowired
  public UserMapperTest(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  UserDTO dto01;
  UserDTO dto02;

  Logger log = LoggerFactory.getLogger(getClass());

  @BeforeEach
  void setUp() {
    log.info("┌────────────────────┐");
    log.info("│ setUp()            │");
    log.info("└────────────────────┘");

    dto01 = new UserDTO("user1", "1234", "구본홍1", "not use");
    dto02 = new UserDTO("user2", "1234", "구본홍2", "not use");

  }

  @AfterEach
  void tearDown() {

  }

  // ID 중복확인
  @Test
  void checkId() {
    // 회원가입
    int flag = userMapper.createUser(dto01);
    assertEquals(1, flag);
    // 중복확인 O
    flag = userMapper.checkId(dto01.getId());
    assertEquals(1, flag);

    // 중복확인 X
    flag = userMapper.checkId("IAMUSER");
    assertEquals(0, flag);

    userMapper.deleteAll();

  }

  // 로그인 테스트
  @Test
  void loginUser() {
    // 회원가입
    int flag = userMapper.createUser(dto01);
    assertEquals(1, flag);
    // 로그인 성공
    int isLogin = userMapper.loginUser(dto01.getId(), dto01.getPassword());
    assertEquals(1, isLogin);
    // 로그인 실패
    isLogin = userMapper.loginUser("1234", "1234");
    assertEquals(0, isLogin);

    // 회원 삭제
    userMapper.deleteUser(dto01.getId());
    int count = userMapper.getCount();
    assertEquals(0, count);
  }

  // 회원가입테스트
  @Test
  void createUser() {
    int flag = userMapper.createUser(dto01);
    assertEquals(1, flag);

    flag = userMapper.createUser(dto02);
    assertEquals(1, flag);

    // 전체 회원 수 조회
    int count = userMapper.getCount();
    assertEquals(2, count);

    // 전체 삭제
    userMapper.deleteAll();
    count = userMapper.getCount();
    assertEquals(0, count);

  }

}
