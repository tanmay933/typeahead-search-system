package com.tanmay.typeahead_backend.service;

import com.tanmay.typeahead_backend.batch.SearchAnalyticsBuffer;
import com.tanmay.typeahead_backend.cache.SuggestionCacheService;
import com.tanmay.typeahead_backend.entity.SearchQuery;
import com.tanmay.typeahead_backend.repository.SearchQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchQueryRepository searchQueryRepository;
    private final SuggestionCacheService suggestionCacheService;
    private final SearchAnalyticsBuffer searchAnalyticsBuffer;

    public void search(String query) {

        searchAnalyticsBuffer.increment(query);

        suggestionCacheService.clear();
    }

    public List<String> getSuggestions(String prefix) {

        if (suggestionCacheService.contains(prefix)) {

            System.out.println("CACHE HIT");

            return suggestionCacheService.get(prefix);
        }

        System.out.println("CACHE MISS");

        List<String> suggestions = searchQueryRepository
                .findByQueryStartingWith(prefix)
                .stream()

                .sorted((a, b) -> {

                    double scoreA = calculateScore(a);
                    double scoreB = calculateScore(b);

                    return Double.compare(scoreB, scoreA);
                })

                .limit(10)

                .map(SearchQuery::getQuery)

                .collect(Collectors.toList());

        suggestionCacheService.put(prefix, suggestions);

        return suggestions;
    }

    private double calculateScore(SearchQuery query) {

        long hoursSinceSearch = Duration.between(
                query.getLastSearchedAt(),
                LocalDateTime.now()).toHours();

        double recencyBoost = Math.max(0, 24 - hoursSinceSearch);

        return (query.getCount() * 0.7)
                + (recencyBoost * 0.3);
    }

    public List<String> getTrendingSearches() {

        return searchQueryRepository
                .findTop10ByOrderByCountDesc()
                .stream()
                .map(SearchQuery::getQuery)
                .collect(Collectors.toList());
    }
}