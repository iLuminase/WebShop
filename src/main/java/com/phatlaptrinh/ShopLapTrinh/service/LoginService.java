package com.phatlaptrinh.ShopLapTrinh.service;

import com.phatlaptrinh.ShopLapTrinh.repository.LoginRepository;

public class LoginService {
    private LoginRepository loginRepository = new LoginRepository();

    public String loginProcess(String username, String password)
    {
        if(loginRepository.checkLogin(username,password))
        {
            return "Success";
        }
        else {
            return "Fail!";
        }
    }
}
