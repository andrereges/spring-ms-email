package com.ms.email.controllers;

import com.ms.email.dtos.EmailDto;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/emails")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<EmailModel> send(@RequestBody @Valid EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);

        emailService.send(emailModel);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(emailModel);
    }

    @GetMapping
    public ResponseEntity<Page<EmailModel>> getAll(
            @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(emailService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value="id") UUID id){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(emailService.findById(id));
    }
}
