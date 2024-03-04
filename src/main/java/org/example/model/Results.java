package org.example.model;

import java.util.List;

public class Results {
    //will match json to java objects

    List<Pokemon> results;

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
