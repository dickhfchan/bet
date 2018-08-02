package com.mountbet.betservice.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public class Order {
    private SideEnum side = null;
    private Double sv = null;
    private PtEnum pt = null;
    private OtEnum ot = null;
    private Double p = null;
    private Double sc = null;
    private String rc = null;
    private Double s = null;
    private Long pd = null;
    private String rac = null;
    private Long md = null;
    private Long ld = null;
    private Double sl = null;
    private Double avp = null;
    private Double sm = null;
    private String rfo = null;
    private String id = null;
    private Double bsp = null;
    private String rfs = null;
    private StatusEnum status = null;
    private Double sr = null;

    public SideEnum getSide() {
        return side;
    }

    public void setSide(SideEnum side) {
        this.side = side;
    }

    public Double getSv() {
        return sv;
    }

    public void setSv(Double sv) {
        this.sv = sv;
    }

    public PtEnum getPt() {
        return pt;
    }

    public void setPt(PtEnum pt) {
        this.pt = pt;
    }

    public OtEnum getOt() {
        return ot;
    }

    public void setOt(OtEnum ot) {
        this.ot = ot;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }

    public Double getSc() {
        return sc;
    }

    public void setSc(Double sc) {
        this.sc = sc;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public Double getS() {
        return s;
    }

    public void setS(Double s) {
        this.s = s;
    }

    public Long getPd() {
        return pd;
    }

    public void setPd(Long pd) {
        this.pd = pd;
    }

    public String getRac() {
        return rac;
    }

    public void setRac(String rac) {
        this.rac = rac;
    }

    public Long getMd() {
        return md;
    }

    public void setMd(Long md) {
        this.md = md;
    }

    public Long getLd() {
        return ld;
    }

    public void setLd(Long ld) {
        this.ld = ld;
    }

    public Double getSl() {
        return sl;
    }

    public void setSl(Double sl) {
        this.sl = sl;
    }

    public Double getAvp() {
        return avp;
    }

    public void setAvp(Double avp) {
        this.avp = avp;
    }

    public Double getSm() {
        return sm;
    }

    public void setSm(Double sm) {
        this.sm = sm;
    }

    public String getRfo() {
        return rfo;
    }

    public void setRfo(String rfo) {
        this.rfo = rfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBsp() {
        return bsp;
    }

    public void setBsp(Double bsp) {
        this.bsp = bsp;
    }

    public String getRfs() {
        return rfs;
    }

    public void setRfs(String rfs) {
        this.rfs = rfs;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Double getSr() {
        return sr;
    }

    public void setSr(Double sr) {
        this.sr = sr;
    }

    public enum PtEnum {
        L("L"),
        P("P"),
        MOC("MOC");

        private String value;

        PtEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String toString() {
            return value;
        }
    }

    public enum StatusEnum {
        E("E"),
        EC("EC");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String toString() {
            return value;
        }
    }

    public enum OtEnum {
        L("L"),
        LOC("LOC"),
        MOC("MOC");

        private String value;

        OtEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String toString() {
            return value;
        }
    }

    public enum SideEnum {
        B("B"),
        L("L");

        private String value;

        SideEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String toString() {
            return value;
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "side=" + side +
                ", sv=" + sv +
                ", pt=" + pt +
                ", ot=" + ot +
                ", p=" + p +
                ", sc=" + sc +
                ", rc='" + rc + '\'' +
                ", s=" + s +
                ", pd=" + pd +
                ", rac='" + rac + '\'' +
                ", md=" + md +
                ", ld=" + ld +
                ", sl=" + sl +
                ", avp=" + avp +
                ", sm=" + sm +
                ", rfo='" + rfo + '\'' +
                ", id='" + id + '\'' +
                ", bsp=" + bsp +
                ", rfs='" + rfs + '\'' +
                ", status=" + status +
                ", sr=" + sr +
                '}';
    }
}