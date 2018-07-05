package com.mountbet.betservice.dto.CancelOrder;

import java.io.Serializable;

public class CancelExecutionReportSource implements Serializable {
    private CancelExecutionReport source;

    public CancelExecutionReport getSource() {
        return source;
    }

    public void setSource(CancelExecutionReport source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "CancelExecutionReportSource{" +
                "source=" + source +
                '}';
    }
}
