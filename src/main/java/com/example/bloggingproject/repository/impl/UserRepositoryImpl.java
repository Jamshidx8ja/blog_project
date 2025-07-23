package com.example.bloggingproject.repository.impl;

import com.example.bloggingproject.entity.User;
import com.example.bloggingproject.filter.UserFilter;
import com.example.bloggingproject.repository.UserCompositeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserCompositeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<User> findAllByFilter(UserFilter filter) {

        StringBuilder sql = new StringBuilder("select t from User t where 1=1 ");

        if (StringUtils.isNotBlank(filter.getSearchKey())) {
            sql.append(" and lower(t.name) like :searchKey");
        }


        String countSql = sql.toString().replace("select t", "select count(t)");
        TypedQuery<User> query = entityManager.createQuery(sql.toString(), User.class);
        TypedQuery<Long> countQuery = entityManager.createQuery(countSql, Long.class);

        if (StringUtils.isNotBlank(filter.getSearchKey())) {
            query.setParameter("searchKey", filter.getSearchForQuery());
            countQuery.setParameter("searchKey", filter.getSearchForQuery());
        }

        return new PageImpl<>(query.getResultList(), filter.getPageable(), countQuery.getSingleResult());
    }
}
