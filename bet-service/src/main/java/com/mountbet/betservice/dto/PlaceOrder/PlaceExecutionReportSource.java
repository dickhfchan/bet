package com.mountbet.betservice.dto.PlaceOrder;

import java.io.Serializable;

/**
 * @author AnsonChan
 * @since 4/7/2018
 */
public class PlaceExecutionReportSource implements Serializable {
    private PlaceExecutionReport source;

    public PlaceExecutionReport getSource() {
        return source;
    }

    public void setSource(PlaceExecutionReport source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "PlaceExecutionReportSource{" +
                "source=" + source +
                '}';
    }
}
