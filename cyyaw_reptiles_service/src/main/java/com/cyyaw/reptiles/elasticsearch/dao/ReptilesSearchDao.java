package com.cyyaw.reptiles.elasticsearch.dao;

import com.cyyaw.reptiles.elasticsearch.entity.ReptilesContent;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ReptilesSearchDao extends PagingAndSortingRepository<ReptilesContent, String> {



}
