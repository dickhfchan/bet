package com.mountbet.betservice.dto.UpdateOrder;

public class UpdateInstructionReport {
    private static final long serialVersionUID = 1L;

    private String status;
    private String errorCode;
    private UpdateInstruction instruction;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public UpdateInstruction getInstruction() {
        return this.instruction;
    }

    public void setInstruction(UpdateInstruction instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "UpdateInstructionReport{" +
                "status='" + status + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", instruction=" + instruction +
                '}';
    }
}