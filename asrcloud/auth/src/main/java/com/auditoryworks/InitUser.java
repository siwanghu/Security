package com.auditoryworks;

import com.auditoryworks.domain.Authority;
import com.auditoryworks.domain.Role;
import com.auditoryworks.domain.User;
import com.auditoryworks.repository.AuthorityRepository;
import com.auditoryworks.repository.RoleRepository;
import com.auditoryworks.service.UserService;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by SuperS on 2017/9/25.
 *
 * @author SuperS
 */
@Component
@AllArgsConstructor
public class InitUser implements CommandLineRunner {
    private UserService userService;
    private AuthorityRepository authorityRepository;
    private RoleRepository roleRepository;

    @Override
    public void run(String... strings) throws Exception {

        //权限
        Authority authority = new Authority();
        authority.setName("查询");
        authority.setValue("query");
        authorityRepository.save(authority);

        //角色
        Role admin = new Role();
        admin.setName("主用户");
        admin.setValue("ROLE_ADMIN");
        admin.setAuthorities(Sets.newHashSet(authorityRepository.findOne(1L)));
        roleRepository.save(admin);

        //用户
        User fpf = new User();
        fpf.setUsername("ws");
        fpf.setPassword("ws");
        fpf.setRoles(Sets.newHashSet(roleRepository.findOne(1L)));
        userService.createUser(fpf);
    }
}
