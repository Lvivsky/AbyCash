package com.example.controllers;

import com.example.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OperationFolderController {

    @Autowired
    private UsersRepo usersRepo;

    @GetMapping("/operation_folder")
    public String index(Model model) {
        model.addAttribute("loginUser", usersRepo.findById(1).get().getLogin());



        return "operation_folder";
    }
}
