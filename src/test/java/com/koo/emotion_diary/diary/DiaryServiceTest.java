package com.koo.emotion_diary.diary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.koo.emotion_diary.domain.DiaryDTO;
import com.koo.emotion_diary.domain.UserDTO;
import com.koo.emotion_diary.mapper.DiaryMapper;
import com.koo.emotion_diary.mapper.UserMapper;
import com.koo.emotion_diary.service.DiaryService;
import com.koo.emotion_diary.service.UserService;

@SpringBootTest
public class DiaryServiceTest {
  private final DiaryService diaryService;
  private final UserService userService;
  private final DiaryMapper diaryMapper;
  private final UserMapper userMapper;

  @Autowired
  public DiaryServiceTest(DiaryService diaryService, UserService userService, DiaryMapper diaryMapper,
      UserMapper userMapper) {
    this.diaryService = diaryService;
    this.userService = userService;
    this.diaryMapper = diaryMapper;
    this.userMapper = userMapper;
  }

  Logger log = LoggerFactory.getLogger(getClass());

  UserDTO user;

  DiaryDTO diary1;
  DiaryDTO diary2;
  DiaryDTO diary3;

  @BeforeEach
  void setUp() {
    user = new UserDTO("user", "1234", "구본홍", "2025-10-10");
    diary1 = new DiaryDTO(0, "user", 1, "일기1", "내용1", "2025-10-10");
    diary2 = new DiaryDTO(0, "user", 2, "일기2", "내용2", "2025-10-09");
    diary3 = new DiaryDTO(0, "user", 3, "일기3", "내용3", "2025-10-08");
  }

  @AfterEach
  void tearDown() {
    // 전체 삭제
    diaryMapper.deleteAll();
    userMapper.deleteAll();
  }

  // 일기 삭제
  @Test
  void deleteDiary() {
    // 유저 생성 -> foreinkey 때문에 유저 생성
    int flag = userService.createUser(user);
    assertEquals(1, flag);
    // 일기 작성
    flag = diaryService.createDiary(diary1);
    assertEquals(1, flag);

    int count = diaryMapper.getAll();
    assertEquals(1, count);

    int no = diaryMapper.getNo(diary1.getId());
    flag = diaryService.deleteDiary(no);
    assertEquals(1, flag);

    count = diaryMapper.getAll();
    assertEquals(0, count);

  }

  // 일기 수정
  @Test
  void updateDiary() {
    // 유저 생성 -> foreinkey 때문에 유저 생성
    int flag = userService.createUser(user);
    assertEquals(1, flag);
    // 일기 작성
    flag = diaryService.createDiary(diary1);
    assertEquals(1, flag);

    int no = diaryMapper.getNo(diary1.getId());
    DiaryDTO diary = diaryMapper.selectDiary(no);
    assertNotNull(diary);
    log.info("일기 :{}", diary);

    // 일기 수정
    diary.setTitle("수정된 제목");
    diary.setContent("수정된 내용");
    flag = diaryService.updateDiary(diary);
    assertEquals(1, flag);
    log.info("수정된 일기:{}", diary);
  }

  // 일기 단건 조회
  @Test
  void selectDiary() {
    // 유저 생성 -> foreinkey 때문에 유저 생성
    int flag = userService.createUser(user);
    assertEquals(1, flag);
    // 일기 작성
    flag = diaryService.createDiary(diary1);
    assertEquals(1, flag);
    int count = diaryMapper.getAll();
    assertEquals(1, count);

    int no = diaryMapper.getNo(diary1.getId());
    DiaryDTO diary = diaryService.selectDiary(no);
    assertNotNull(diary);
    log.info("일기 :{}", diary);

  }

  // 일기 목록 조회
  @Test
  void diaryList() {
    // 유저 생성 -> foreinkey 때문에 유저 생성
    int flag = userService.createUser(user);
    assertEquals(1, flag);
    // 일기 작성
    flag = diaryService.createDiary(diary1);
    assertEquals(1, flag);
    flag = diaryService.createDiary(diary2);
    assertEquals(1, flag);
    flag = diaryService.createDiary(diary3);
    assertEquals(1, flag);

    int count = diaryMapper.getAll();
    assertEquals(3, count);

    List<DiaryDTO> list = diaryService.diaryList(user.getId());
    assertNotNull(list);

    for (DiaryDTO dto : list) {
      log.info("일기 : {}", dto);
    }

  }

  // 일기 작성
  @Test
  void createDiary() {
    // 유저 생성 -> foreinkey 때문에 유저 생성
    int flag = userService.createUser(user);
    assertEquals(1, flag);
    // 일기 작성
    flag = diaryService.createDiary(diary1);
    assertEquals(1, flag);

    int count = diaryMapper.getAll();
    assertEquals(1, count);
  }
}
