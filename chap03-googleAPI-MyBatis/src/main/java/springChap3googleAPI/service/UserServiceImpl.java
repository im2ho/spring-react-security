package springChap3googleAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springChap3googleAPI.mapper.UserMapper;
import springChap3googleAPI.model.UserGoogle;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserGoogle findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void saveUser(UserGoogle user) {
    	userMapper.addUser(user);
    }
}