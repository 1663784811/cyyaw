package com.cyyaw.server.common.jpa;

import com.cyyaw.common.entity.SelectModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseTableService<T, D> {

    List<T> findAll(String jsonStr, SelectModel selectModel, String... selectWhereArr);

    Page<T> findPage(String jsonStr, PageRequest pageRequest, String... selectWhereArr);

    T findId(D id);

    T save(T t);

    void del(D[] idArr);

    void del(D d);
}
