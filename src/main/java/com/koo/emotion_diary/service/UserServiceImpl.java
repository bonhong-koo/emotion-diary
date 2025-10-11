package com.koo.emotion_diary.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.koo.emotion_diary.domain.UserDTO;
import com.koo.emotion_diary.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder) {
    this.userMapper = userMapper;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public boolean login(UserDTO param) {
    UserDTO user = userMapper.selectUser(param.getId());
    if (user == null) {
      return false;
    }
    return passwordEncoder.matches(param.getPassword(), user.getPassword());

  }

  @Override
  public int createUser(UserDTO param) {
    String rawPw = passwordEncoder.encode(param.getPassword());
    param.setPassword(rawPw);
    return userMapper.createUser(param);

  }

  @Override
  public UserDTO selectUser(String id) {
    return userMapper.selectUser(id);
  }

  @Override
  public int checkId(String id) {
    return userMapper.checkId(id);
  }

}
