package com.wiatec.liveplay.common.result;

public class XException extends RuntimeException {

    private int code;

    public XException(EnumResult enumResult) {
        super(enumResult.getMessage());
        this.code = enumResult.getCode();
    }

    public XException(ResultInfo resultInfo) {
        super(resultInfo.getMessage());
        this.code = resultInfo.getCode();
    }

    public XException(int code, String message) {
        super(message);
        this.code = code;
    }

    public XException(String message) {
        super(message);
        this.code = 101;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
