package com.example.bloggingproject.repository.impl;

import com.example.bloggingproject.entity.Post;
import com.example.bloggingproject.filter.PostFilter;
import com.example.bloggingproject.repository.PostCompositeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl implements PostCompositeRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Page<Post> findALlByFilter(PostFilter filter) {

        StringBuilder sql = new StringBuilder("select t from Post t where 1=1 ");

        if (StringUtils.isNotEmpty(filter.getSearchKey())) {
            sql.append(" and lower(t.searchKey) like :searchKey ");
        }

        if (filter.getUserId() != null) {
            sql.append(" and t.user.id = :userId ");
        }

        String countSql = sql.toString().replace("select t", "select count(t)");

        if (filter.getSortType() != null) {
            sql.append(" order by t.createdAt ").append(filter.getSortType());
        }

        TypedQuery<Post> query = entityManager.createQuery(sql.toString(), Post.class)
                .setFirstResult(filter.getStart()).setMaxResults(filter.getSize());

        TypedQuery<Long> countQuery = entityManager.createQuery(countSql, Long.class);

        if (StringUtils.isNotEmpty(filter.getSearchKey())) {
            query.setParameter("searchKey", filter.getSearchForQuery());
            countQuery.setParameter("searchKey", filter.getSearchForQuery());
        }

        if (filter.getUserId() != null) {
            query.setParameter("userId", filter.getUserId());
            countQuery.setParameter("userId", filter.getUserId());
        }

        return new PageImpl<>(query.getResultList(), filter.getPageable(), countQuery.getSingleResult());
    }
}
