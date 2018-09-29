package com.apple_chen.daggerdemo.bean;

public class TestBean {
    private String testDate;
    private String testTip;

    public TestBean(String testDate, String testTip) {
        this.testDate = testDate;
        this.testTip = testTip;
    }

    public String getTestDate() {
        return testDate;
    }

    public String getTestTip() {
        return testTip;
    }
}
