package com.locationVoiture.services;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}


