package net.cmderobertis.languages.controllers;
import net.cmderobertis.languages.models.Language;
import net.cmderobertis.languages.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
public class LanguageController {
    @Autowired
    LanguageService service;
    // ROOT
    @GetMapping("/")
    String index() { return "redirect:/languages";}
    // CREATE
    @PostMapping("/languages")
    String create(
            @Valid
            @ModelAttribute("language") Language language,
            BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            service.createLanguage(language);
            return "redirect:/languages";
        }
    }
    // READ
    @GetMapping("/languages")
    String showAll(Model model) {
        List<Language> languages = service.getAll();
        model.addAttribute("languages", languages);
        model.addAttribute("language", new Language());
        return "index.jsp";
    }
    @GetMapping("/languages/{id}")
    String showOne(@PathVariable("id") Long id, Model model) {
        Language language = service.getOne(id);
        model.addAttribute("language", language);
        return "show.jsp";
    }
    // UPDATE
    @GetMapping("/languages/{id}/edit")
    String edit(@PathVariable("id") Long id, Model model) {
        Language language = service.getOne(id);
        model.addAttribute("language", language);
        return "update.jsp";
    }
    @PutMapping("/languages/{id}")
    String update(
            @Valid
            @ModelAttribute("language") Language language,
            BindingResult result) {
        if (result.hasErrors()) {
            return "update.jsp";
        } else {
            service.update(language);
            return "redirect:/languages";
        }
    }
    // DELETE
    @DeleteMapping("/languages/{id}")
    String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/languages";
    }
}
