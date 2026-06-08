package com.tanmay.typeahead_backend.cache;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SuggestionCacheService {

    private final Map<String, List<String>> nodeA = new HashMap<>();
    private final Map<String, List<String>> nodeB = new HashMap<>();
    private final Map<String, List<String>> nodeC = new HashMap<>();

    private Map<String, List<String>> getNode(String prefix) {

        int nodeIndex =
                Math.abs(prefix.hashCode()) % 3;

        return switch (nodeIndex) {

            case 0 -> nodeA;
            case 1 -> nodeB;
            default -> nodeC;
        };
    }

    public String getNodeName(String prefix) {

        int nodeIndex =
                Math.abs(prefix.hashCode()) % 3;

        return switch (nodeIndex) {

            case 0 -> "Node-A";
            case 1 -> "Node-B";
            default -> "Node-C";
        };
    }

    public List<String> get(String prefix) {

        return getNode(prefix).get(prefix);
    }

    public void put(String prefix, List<String> suggestions) {

        getNode(prefix).put(prefix, suggestions);
    }

    public boolean contains(String prefix) {

        return getNode(prefix).containsKey(prefix);
    }

    public void clear() {

        nodeA.clear();
        nodeB.clear();
        nodeC.clear();
    }
}