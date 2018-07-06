package com.mountbet.betservice.dto.ReplaceOrder;

import java.io.Serializable;

public class ReplaceExecutionReportSource implements Serializable {
    private ReplaceExecutionReport source;

    public ReplaceExecutionReport getSource() {
        return source;
    }

    public void setSource(ReplaceExecutionReport source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "ReplaceExecutionReportSource{" +
                "source=" + source +
                '}';
    }
}
