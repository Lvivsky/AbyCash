package com.example.controllers;

import com.example.models.Categories;
import com.example.models.Users;
import com.example.repositories.CategoriesRepo;
import com.example.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticlesFolderController {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private CategoriesRepo categoriesRepo;

    @GetMapping("/articles_folder")
    public String index(Model model) {
        model.addAttribute("loginUser", usersRepo.findById(1).get().getLogin());

        Iterable<Categories> c1 = categoriesRepo.findIncome();
        Iterable<Categories> c2 = categoriesRepo.findOutcome();

        model.addAttribute("incomeCategory", c1);
        model.addAttribute("outcomeCategory", c2);

        return "articles_folder";
    }

    @GetMapping("/articles_folder/add")
    public String addCategory() {
        return "/fragments/addCategory";
    }

    @PostMapping("/articles_folder/add")
    public String addOutcome (
            @RequestParam String name,
            @RequestParam String comment,
            Model model) {

        System.out.println(name);
        System.out.println(comment);
        Categories categories = new Categories(name, comment, 2);
        categoriesRepo.save(categories);
//        categoriesRepo.i();
        return "articles_folder";
    }

}
