package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-02 17:50
 */
public class SignInfo4Pool extends SignInfo {

    private String key;


    public SignInfo4Pool(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
