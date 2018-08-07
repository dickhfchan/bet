package com.mountbet.betservice.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Date range container.
 */
public class TimeRange implements Serializable {

    private Date from;
    private Date to;

    public TimeRange() {
    }

    public TimeRange(Date from) {
        this.from = from;
    }

    public TimeRange(Date from, Date to) {
        this.from = from;
        this.to = to;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "TimeRange{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}

