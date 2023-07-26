package com.locationVoiture.services;

import com.locationVoiture.entities.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
