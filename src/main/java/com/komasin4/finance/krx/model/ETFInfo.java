package com.komasin4.finance.krx.model;

import lombok.Data;

@Data
public class ETFInfo {
    //{"full_code":"KR7105190003","short_code":"105190","codeName":"ACE 200"}
    private String full_code;
    private String short_code;
    private String codeName;

    public ETFInfo(String full_code, String short_code, String codeName) {
        this.full_code = full_code;
        this.short_code = short_code;
        this.codeName = codeName;
    }

    @Override
    public String toString() {
        return "ETFInfo{" +
                "full_code='" + full_code + '\'' +
                ", short_code='" + short_code + '\'' +
                ", codeName='" + codeName + '\'' +
                '}';
    }
}
