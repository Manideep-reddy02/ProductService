package com.example.productservice.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Date createdAt;
    Date UpdatedAt;
    Boolean isDeleted;
}
