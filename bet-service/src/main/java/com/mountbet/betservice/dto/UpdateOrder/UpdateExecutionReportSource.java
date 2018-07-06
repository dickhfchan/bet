package com.mountbet.betservice.dto.UpdateOrder;

import java.io.Serializable;

public class UpdateExecutionReportSource implements Serializable {
    private UpdateExecutionReport source;

    public UpdateExecutionReport getSource() {
        return source;
    }

    public void setSource(UpdateExecutionReport source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "UpdateExecutionReportSource{" +
                "source=" + source +
                '}';
    }
}
