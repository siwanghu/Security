package com.auditoryworks.service;

import com.auditoryworks.domain.User;
import com.auditoryworks.status.Message;

public interface UserService {
    Message createUser(User user);

    Message registerUser(User user);

}
