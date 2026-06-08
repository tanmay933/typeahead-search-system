package com.tanmay.typeahead_backend.batch;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SearchAnalyticsBuffer {

    private final Map<String, Long> buffer = new ConcurrentHashMap<>();

    public void increment(String query) {

        buffer.merge(query, 1L, Long::sum);
    }

    public Map<String, Long> getBuffer() {

        return buffer;
    }

    public void clear() {

        buffer.clear();
    }
}