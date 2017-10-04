package com;

public class CommonResp {

    private String result;
    private Object content;

    public CommonResp(String result, Object content) {
        this.result = result;
        this.content = content;
    }

    public CommonResp(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
