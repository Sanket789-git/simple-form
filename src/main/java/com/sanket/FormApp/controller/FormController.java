package com.sanket.FormApp.controller;

import com.sanket.FormApp.model.Form;
import com.sanket.FormApp.service.FormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/api/form")
public class FormController {

    FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveForm(@ModelAttribute Form form,
                                           @RequestParam MultipartFile image) {
        return formService.saveForm(form, image);
    }
}
