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
import com.koo.emotion_diary.service.UserService;

@SpringBootTest
public class UserServiceTest {
  private final UserService userService;
  private final UserMapper userMapper;

  @Autowired
  public UserServiceTest(UserService userService, UserMapper userMapper) {
    this.userService = userService;
    this.userMapper = userMapper;
  }

  UserDTO user;

  Logger log = LoggerFactory.getLogger(getClass());

  @BeforeEach
  void setUp() {
    user = new UserDTO("user", "1234", "구본홍", "2025-10-10");

  }

  @AfterEach
  void tearDown() {
    userMapper.deleteAll();
  }

  @Test
  void createUser() {
    // 회원가입
    int flag = userService.createUser(user);
    assertEquals(1, flag);

    UserDTO dto = userMapper.selectUser(user.getId());
    log.info("dto:{}", dto);

  }

  @Test
  void login() {
    // 회원가입
    int flag = userService.createUser(user);
    assertEquals(1, flag);

    user.setPassword("1234");

    boolean isMatch = userService.login(user);
    assertEquals(true, isMatch);

    user.setPassword("2345");
    isMatch = userService.login(user);
    assertEquals(false, isMatch);

  }
}
