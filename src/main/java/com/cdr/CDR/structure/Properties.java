package com.cdr.CDR.structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Properties {
    private int diabetes;
    private int gender;
    private int ageRange;
    private int smoker;
    private int sbpRange;
    private int cholesterolRange;
    @Setter(AccessLevel.NONE)
    private int hc;

    public void setHc(){
        this.hc=Integer.valueOf(String.valueOf(diabetes) + String.valueOf(gender) + String.valueOf(ageRange) + String.valueOf(smoker) + String.valueOf(sbpRange) + String.valueOf(cholesterolRange));
    }

    @Override
    public int hashCode() {
        setHc();
        return this.hc;
    }


    @Override
    public boolean equals(Object obj) {
        if (this.hc == obj.hashCode()) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return false;
    }
}