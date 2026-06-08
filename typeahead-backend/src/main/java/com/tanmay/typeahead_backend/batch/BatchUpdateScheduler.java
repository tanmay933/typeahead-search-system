package com.tanmay.typeahead_backend.batch;

import com.tanmay.typeahead_backend.entity.SearchQuery;
import com.tanmay.typeahead_backend.repository.SearchQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BatchUpdateScheduler {

    private final SearchAnalyticsBuffer buffer;
    private final SearchQueryRepository repository;

    @Scheduled(fixedRate = 10000)
    public void flushBufferToDatabase() {

        Map<String, Long> bufferedData = buffer.getBuffer();

        if (bufferedData.isEmpty()) {
            return;
        }

        System.out.println("FLUSHING BUFFER TO DB");

        for (Map.Entry<String, Long> entry : bufferedData.entrySet()) {

            String query = entry.getKey();
            Long increment = entry.getValue();

            SearchQuery existingQuery =
                    repository.findByQuery(query)
                            .orElse(null);

            if (existingQuery != null) {

                existingQuery.setCount(
                        existingQuery.getCount() + increment
                );

                existingQuery.setLastSearchedAt(LocalDateTime.now());

                repository.save(existingQuery);

            } else {

                SearchQuery newQuery = SearchQuery.builder()
                        .query(query)
                        .count(increment)
                        .lastSearchedAt(LocalDateTime.now())
                        .build();

                repository.save(newQuery);
            }
        }

        buffer.clear();
    }
}