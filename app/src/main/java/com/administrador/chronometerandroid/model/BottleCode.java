package com.administrador.chronometerandroid.model;

/**
 * Created by rony_2 on 16/5/2017.
 */

public class BottleCode {
    String code;
    boolean enabled;
    String key;

    public String getCode() {
        if(code==null)
            code = "";
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public BottleCode() {
    }

    public BottleCode(String code, boolean enabled, String key) {
        this.code = code;
        this.enabled = enabled;
        this.key = key;
    }
}
