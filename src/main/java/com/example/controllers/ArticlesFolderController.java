package com.example.controllers;

import com.example.models.Categories;
import com.example.models.Currencies;
import com.example.repositories.CategoriesRepo;
import com.example.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/articles_folder/{id}/add")
    public String addCategory(@PathVariable(value = "id") int id, Model model) {
        return "/fragments/addCategory";
    }

    @PostMapping("/articles_folder/{id}/add")
    public String addOutcome (
            @PathVariable(value = "id") int id,
            @RequestParam String name,
            @RequestParam String comment,
            Model model) {

        System.out.println(name);
        System.out.println(comment);
        Categories categories = new Categories(name, comment, id);
        categoriesRepo.save(categories);
        return "redirect:/articles_folder";
    }

    /*
    @GetMapping("/articles_folder/{id}/edit")
    public String editCategoryGet(@PathVariable(value = "id") int id, Model model) {
        Optional<Categories> categories = categoriesRepo.findById(id);
        ArrayList<Categories> res = new ArrayList<Categories>();
        categories.ifPresent(res::add);

        model.addAttribute("curr-categ", res);
        return "fragments/editCategory";
    }*/

    @GetMapping("/articles_folder/{id}/edit")
    public String editCategoryGet(@PathVariable(value = "id") int id, Model model) {
        if (!categoriesRepo.existsById(id)) {
            return "redirect:/articles_folder";
        }

        Optional<Categories> categories = categoriesRepo.findById(id);
        ArrayList<Categories> res = new ArrayList<Categories>();
        categories.ifPresent(res::add);
        model.addAttribute("curr", res);

        return "fragments/editCategory";
    }

    @PostMapping("/articles_folder/{id}/edit")
    public String editCategoryPost(@PathVariable(value = "id") int id,
                               @RequestParam String name,
                               @RequestParam String comment, Model model) {

        Categories category = categoriesRepo.findById(id).orElseThrow();
        category.setName(name);
        category.setComment(comment);
        categoriesRepo.save(category);

        return "redirect:/articles_folder";
    }
}
