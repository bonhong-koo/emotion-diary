package com.koo.emotion_diary.diary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

@SpringBootTest
public class DiaryMapperTest {

  private final UserMapper userMapper;
  private final DiaryMapper diaryMapper;

  @Autowired
  public DiaryMapperTest(UserMapper userMapper, DiaryMapper diaryMapper) {
    this.userMapper = userMapper;
    this.diaryMapper = diaryMapper;
  }

  UserDTO user;
  DiaryDTO diary1;
  DiaryDTO diary2;

  Logger log = LoggerFactory.getLogger(getClass());

  @BeforeEach
  void setUp() {
    log.info("setUp");
    user = new UserDTO("user", "1234", "구본홍", "not use");
    diary1 = new DiaryDTO(0, "user", 2, "첫번째일기", "내용1", "2025-10-09");
    diary2 = new DiaryDTO(0, "user", 2, "두번째일기", "내용2", "2025-10-09");
  }

  @AfterEach
  void tearDown() {
    // 전체 삭제
    userMapper.deleteAll();
    diaryMapper.deleteAll();
  }

  // 일기 목록 전체 조회
  @Test
  void diaryList() {
    // diary의 id값이 fk이므로 user 먼저 생성
    int flag = userMapper.createUser(user);
    assertEquals(1, flag);
    // 일기 작성
    flag = diaryMapper.createDiary(diary1);
    assertEquals(1, flag);
    flag = diaryMapper.createDiary(diary2);
    assertEquals(1, flag);

    // 전체 일기 수 조회
    int count = diaryMapper.getAll();
    assertEquals(2, count);

    // 일기 목록 조회
    List<DiaryDTO> list = diaryMapper.diaryList(user.getId());
    for (DiaryDTO dto : list) {
      log.info("dto :{}", dto);
    }
  }

  // 일기 삭제
  @Test
  void deleteDiary() {
    // diary의 id값이 fk이므로 user 먼저 생성
    int flag = userMapper.createUser(user);
    assertEquals(1, flag);
    // 일기 작성
    flag = diaryMapper.createDiary(diary1);
    assertEquals(1, flag);
    // 전체 일기 수 조회
    int count = diaryMapper.getAll();
    assertEquals(1, count);
    // 일기 삭제
    int no = diaryMapper.getNo(diary1.getId());
    flag = diaryMapper.deleteDiary(no);
    count = diaryMapper.getAll();
    assertEquals(1, flag);
    assertEquals(0, count);
  }

  // 일기 수정
  @Test
  void updateDiary() {
    // diary의 id값이 fk이므로 user 먼저 생성
    int flag = userMapper.createUser(user);
    assertEquals(1, flag);
    // 일기 작성
    flag = diaryMapper.createDiary(diary1);
    assertEquals(1, flag);

    // 일기 no 조회
    int no = diaryMapper.getNo(diary1.getId());
    // 일기 단건 조회
    DiaryDTO dto = diaryMapper.selectDiary(no);
    log.info("dto:{}", dto);

    // 일기 수정
    diary1.setTitle("수정된 제목");
    diary1.setEmotion(3);
    diary1.setContent("수정된 내용");
    flag = diaryMapper.updateDiary(diary1);
    assertEquals(1, flag);

    // 수정된 데이터 비교
    DiaryDTO updateDTO = diaryMapper.selectDiary(no);
    assertNotEquals(dto, updateDTO);
    log.info("dto:{}", dto);
    log.info("updateDTO:{}", updateDTO);

  }

  // 일기 작성
  @Test
  void createDiary() {
    // diary의 id값이 fk이므로 user 먼저 생성
    int flag = userMapper.createUser(user);
    assertEquals(1, flag);
    // 일기 작성
    flag = diaryMapper.createDiary(diary1);
    assertEquals(1, flag);

    // 일기 no 조회
    int no = diaryMapper.getNo(diary1.getId());

    // 일기 단건 조회
    DiaryDTO dto = diaryMapper.selectDiary(no);
    log.info("dto:{}", dto);

  }

}
