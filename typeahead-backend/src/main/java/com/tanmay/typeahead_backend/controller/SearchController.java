package com.tanmay.typeahead_backend.controller;

import com.tanmay.typeahead_backend.cache.SuggestionCacheService;
import com.tanmay.typeahead_backend.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;
    private final SuggestionCacheService suggestionCacheService;

    @PostMapping
    public Map<String, String> search(@RequestBody Map<String, String> request) {

        String query = request.get("query");

        searchService.search(query);

        return Map.of(
                "message", "Search recorded successfully");
    }

    @GetMapping("/suggest")
    public List<String> suggest(@RequestParam String q) {

        return searchService.getSuggestions(q);
    }

    @GetMapping("/trending")
    public List<String> trending() {

        return searchService.getTrendingSearches();
    }

    @GetMapping("/cache/debug")
    public Map<String, String> cacheDebug(
            @RequestParam String prefix) {

        return Map.of(
                "prefix", prefix,
                "cacheNode",
                suggestionCacheService.getNodeName(prefix));
    }
}