package com.sanket.FormApp.service;

import com.sanket.FormApp.model.Form;
import com.sanket.FormApp.repository.FormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FormService {

    FormRepo formRepo;

    @Autowired
    ImageUploadService imageUploadService;

    public FormService(FormRepo formRepo) {
        this.formRepo = formRepo;
    }

    public ResponseEntity<String> saveForm(Form form, MultipartFile image) {
        String url = imageUploadService.uploadImage(image);

        form.setImageUrl(url);
        form.setImageName(image.getOriginalFilename());
        form.setImageType(image.getContentType());

        formRepo.save(form);

        return new ResponseEntity<>("Form uploaded!", HttpStatus.OK);
    }
}
