package com.auditoryworks.service;

import com.auditoryworks.domain.Authority;
import com.auditoryworks.domain.Message;
import com.auditoryworks.domain.Role;
import com.auditoryworks.domain.User;
import com.auditoryworks.repository.AuthorityRepository;
import com.auditoryworks.repository.RoleRepository;
import com.auditoryworks.repository.UserRepository;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.constraints.Null;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private RoleRepository roleRepository;

    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public Message createUser(User user) {
        User existing = userRepository.findByUsername(user.getUsername());
        if(existing!= null){
            return new Message(false,"注册失败，用户名被占用",new Date().getTime());
        }
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepository.save(user);
        log.info("new user has been created: {}", user.getUsername());
        return new Message(true,"注册成功",new Date().getTime());
    }

    @Override
    public Message registerUser(User user) {
        Authority authority = new Authority();
        authority.setName("查询");
        authority.setValue("query");
        authorityRepository.save(authority);

        Role admin = new Role();
        admin.setName("主用户");
        admin.setValue("ROLE_ADMIN");
        admin.setAuthorities(Sets.newHashSet(authorityRepository.findOne(1L)));
        roleRepository.save(admin);

        user.setRoles(Sets.newHashSet(roleRepository.findOne(1L)));
        return userService.createUser(user);
    }
}