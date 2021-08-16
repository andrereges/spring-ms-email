package com.ms.email.services;

import com.ms.email.models.EmailModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface EmailService {

    EmailModel send(EmailModel emailModel);

    Page<EmailModel> findAll(Pageable pageable);

    EmailModel findById(UUID id);
}
