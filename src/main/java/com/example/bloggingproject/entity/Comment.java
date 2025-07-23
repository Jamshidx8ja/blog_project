package com.example.bloggingproject.entity;

import com.example.bloggingproject.entity.template.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
public class Comment extends BaseEntity {
    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;
}
