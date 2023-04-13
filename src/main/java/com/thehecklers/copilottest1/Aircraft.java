package com.thehecklers.copilottest1;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Aircraft {
    @Id
    private String adshex;
    private String reg;
    private String type;

    public Aircraft() {
    }

    public Aircraft(String adshex, String reg, String type) {
        this.adshex = adshex;
        this.reg = reg;
        this.type = type;
    }

    public String getAdshex() {
        return adshex;
    }

    public void setAdshex(String adshex) {
        this.adshex = adshex;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adshex == null) ? 0 : adshex.hashCode());
        result = prime * result + ((reg == null) ? 0 : reg.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aircraft other = (Aircraft) obj;
        if (adshex == null) {
            if (other.adshex != null)
                return false;
        } else if (!adshex.equals(other.adshex))
            return false;
        if (reg == null) {
            if (other.reg != null)
                return false;
        } else if (!reg.equals(other.reg))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Aircraft [adshex=" + adshex + ", reg=" + reg + ", type=" + type + "]";
    }
}