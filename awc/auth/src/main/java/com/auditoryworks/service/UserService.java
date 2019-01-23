package com.auditoryworks.service;

import com.auditoryworks.domain.Message;
import com.auditoryworks.domain.User;

public interface UserService {
    Message createUser(User user);

    Message registerUser(User user);

}
