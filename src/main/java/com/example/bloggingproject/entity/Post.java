package com.example.bloggingproject.entity;

import com.example.bloggingproject.entity.template.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Post extends BaseEntity {

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    private Integer likesCount = 0;
    private Integer dislikesCount = 0;


    public String getUserName() {
        if (this.user == null) {
            return null;
        }
        return this.user.getName();
    }

}
