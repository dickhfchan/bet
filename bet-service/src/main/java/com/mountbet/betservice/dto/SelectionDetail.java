package com.mountbet.betservice.dto;

public class SelectionDetail {
    private Long selectionId;
    private String selectionName;

    public Long getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(Long selectionId) {
        this.selectionId = selectionId;
    }

    public String getSelectionName() {
        return selectionName;
    }

    public void setSelectionName(String selectionName) {
        this.selectionName = selectionName;
    }

    @Override
    public String toString() {
        return "SelectionDetail{" +
                "selectionId=" + selectionId +
                ", selectionName='" + selectionName + '\'' +
                '}';
    }
}
