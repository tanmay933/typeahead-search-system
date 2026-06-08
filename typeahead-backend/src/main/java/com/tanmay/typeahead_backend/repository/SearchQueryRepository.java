package com.tanmay.typeahead_backend.repository;

import com.tanmay.typeahead_backend.entity.SearchQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SearchQueryRepository extends JpaRepository<SearchQuery, Long> {

    Optional<SearchQuery> findByQuery(String query);
    List<SearchQuery> findTop10ByOrderByCountDesc();
    List<SearchQuery> findByQueryStartingWith(String prefix);
}