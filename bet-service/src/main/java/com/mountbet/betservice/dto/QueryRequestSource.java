package com.mountbet.betservice.dto;

import java.io.Serializable;

public class QueryRequestSource implements Serializable {

    private QueryRequest source;

    public QueryRequest getSource() {
        return source;
    }

    public void setSource(QueryRequest source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "QueryRequestSource{" +
                "source=" + source +
                '}';
    }
}
