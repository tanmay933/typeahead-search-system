package com.tanmay.typeahead_backend.config;

import com.tanmay.typeahead_backend.entity.SearchQuery;
import com.tanmay.typeahead_backend.repository.SearchQueryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final SearchQueryRepository repository;

    @PostConstruct
    public void loadData() {

        if (repository.count() > 0) {
            return;
        }

        List<SearchQuery> queries = List.of(

                SearchQuery.builder()
                        .query("amazon")
                        .count(210L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("amazon prime")
                        .count(180L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("anime")
                        .count(140L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("attack on titan")
                        .count(130L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("apple")
                        .count(170L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("batman")
                        .count(85L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("barcelona")
                        .count(75L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("bitcoin")
                        .count(160L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("burger king")
                        .count(90L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("chatgpt")
                        .count(250L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("coldplay")
                        .count(95L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("cristiano ronaldo")
                        .count(140L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("calculator")
                        .count(120L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("discord")
                        .count(145L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("dragon ball")
                        .count(115L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("elon musk")
                        .count(155L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("facebook")
                        .count(200L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("fifa")
                        .count(110L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("github")
                        .count(230L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("gmail")
                        .count(220L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("harry potter")
                        .count(130L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("instagram")
                        .count(150L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("instagram reels")
                        .count(80L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("interstellar")
                        .count(95L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("india vs australia")
                        .count(110L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("iphone")
                        .count(120L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("iphone 15")
                        .count(90L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("iphone charger")
                        .count(70L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("ipad")
                        .count(60L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("java")
                        .count(170L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("jujutsu kaisen")
                        .count(125L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("kotlin")
                        .count(80L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("linkedin")
                        .count(145L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("messi")
                        .count(190L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("minecraft")
                        .count(150L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("naruto")
                        .count(135L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("netflix")
                        .count(200L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("openai")
                        .count(175L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("python")
                        .count(160L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("spotify")
                        .count(180L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("steam")
                        .count(140L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("tesla")
                        .count(170L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("twitter")
                        .count(160L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("valorant")
                        .count(145L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("weather today")
                        .count(210L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build(),

                SearchQuery.builder()
                        .query("youtube")
                        .count(260L)
                        .lastSearchedAt(LocalDateTime.now())
                        .build());

        repository.saveAll(queries);

        System.out.println("SAMPLE DATA LOADED");
    }
}