package com.ms.email.models;

import com.ms.email.enums.StatusEmail;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "emails")
@Getter
@Setter
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Builder.Default
    private LocalDateTime sendDateEmail = LocalDateTime.now();

    private StatusEmail statusEmail;
}
