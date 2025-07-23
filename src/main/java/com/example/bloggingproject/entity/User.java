package com.example.bloggingproject.entity;

import com.example.bloggingproject.entity.template.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Getter
@Setter
@Entity
public class User extends BaseEntity {
    @Column(nullable = false)
    private String name;
}
