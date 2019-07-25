package com.javastudio.tutorial.api;

import com.javastudio.tutorial.dto.User;

public interface UserService extends GeneralServiceApi<User> {

    User findByUsername(String username);

    User findByEmail(String email);
}
