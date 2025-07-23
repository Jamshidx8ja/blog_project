package com.example.bloggingproject.entity;

import com.example.bloggingproject.entity.enums.Reaction;
import com.example.bloggingproject.entity.template.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "post_likes")
@Entity
public class Like extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Reaction reaction;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

}
