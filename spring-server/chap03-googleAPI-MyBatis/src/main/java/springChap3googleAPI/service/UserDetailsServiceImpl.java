package springChap3googleAPI.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springChap3googleAPI.mapper.UserMapper;
import springChap3googleAPI.model.UserGoogle;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserGoogle user = userMapper.findByUsername(username);

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                "",
                Collections.emptyList());
    }
}
