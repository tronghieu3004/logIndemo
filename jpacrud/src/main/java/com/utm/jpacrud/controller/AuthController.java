package com.utm.jpacrud.controller;

import com.utm.jpacrud.Security.JWTUltil;
import com.utm.jpacrud.dao.AuthDAO;
import com.utm.jpacrud.model.Account;
import com.utm.jpacrud.dto.LogInAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {
    @Autowired

    AuthDAO authDAO;
    JWTUltil jwtUltil = new JWTUltil();

    @GetMapping("/login")
    public List<Account> getAllAccounts(){
        return authDAO.findAll();
//        return authController.getAll();
    }
    //POST
    @PostMapping("/login")
    public String LogIn(@RequestBody LogInAccountDTO logInAccountDTO){
        String role = LogInAccount(logInAccountDTO);
        if (role != null) {
//            return "Đăng nhập thành công";
            return jwtUltil.generateToken(logInAccountDTO.getUsername(),role);

        }else {
            return "Đăng nhập thất bại";
        }

    }
    public String LogInAccount (LogInAccountDTO logInAccountDTO){
        String userInput = logInAccountDTO.getUsername();
        String passInput = logInAccountDTO.getPassword();
        String user = authDAO.findByUsername(userInput).getUsername();
        String pass = authDAO.findByUsername(userInput).getPassword();
        String role = authDAO.findByUsername(userInput).getRole();

        if (user != null){
            if (passInput.equals(pass)) {
                return role;
            }
            else {
                return null;
            }
       }
        else {
            return null;
        }
    }
}
