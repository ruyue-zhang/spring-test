package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.domain.User;
import com.thoughtworks.rslist.dto.UserDto;
import com.thoughtworks.rslist.repository.RsEventRepository;
import com.thoughtworks.rslist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
  @Autowired UserRepository userRepository;
  @Autowired
  RsEventRepository rsEventRepository;

  @PostMapping("/user")
  public void register(@RequestBody @Valid User user) {
    UserDto userDto = new UserDto();
    userDto.setGender(user.getGender());
    userDto.setPhone(user.getPhone());
    userDto.setVoteNum(user.getVoteNum());
    userDto.setAge(user.getAge());
    userDto.setEmail(user.getEmail());
    userDto.setUserName(user.getUserName());
    userRepository.save(userDto);
  }

  @DeleteMapping("/user/{id}")
  public ResponseEntity deleteUser(@PathVariable int id) {
    userRepository.deleteById(id);
    rsEventRepository.deleteAllByUserId(id);
    return ResponseEntity.ok().build();
  }
}
