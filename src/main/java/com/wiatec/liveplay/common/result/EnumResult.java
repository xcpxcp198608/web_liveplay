package com.wiatec.liveplay.common.result;

/**
 * @author patrick
 */

public enum  EnumResult {

    /**
     * response json result
     */
    SUCCESS(200, "Successfully"),
    ERROR_RE_LOGIN(401, " Login time session expired, please login to your account again."),
    ERROR_UNAUTHORIZED(401, "Unauthorized"),
    ERROR_AUTHORIZED_EXPIRES(401, "Authorization expires"),
    ERROR_NO_FOUND(404, "Resource not exists"),
    ERROR_SERVER_EXCEPTION(500, "Server exception"),
    ERROR_WRONG_PARAM_FORMAT(600, "Request param format incorrect"),
    ERROR_OPERATION_FAILURE(700, "Operation failure"),


    ERROR_USERNAME_EXISTS(6002, "Username already exists"),
    ERROR_USERNAME_FORMAT(6003, "Username format error"),
    ERROR_PASSWORD_FORMAT(6004, "Password format error"),
    ERROR_USERNAME_NOT_EXISTS(6005, "Username not exists"),
    ERROR_USERNAME_PASSWORD_NO_MATCH(6006, "Username and password not match"),
    ERROR_USERNAME_MAC_NO_MATCH(6007, "Username and mac not match"),
    ERROR_USER_NO_ACTIVATE(6008, "No activate"),
    ERROR_SSN_EXISTS(6009, "SSN is exists"),
    ERROR_EMAIL_EXISTS(6010, "Email is exists"),
    ERROR_EMAIL_NOT_EXISTS(6011, "Email not exists"),
    ERROR_EMAIL_NOT_MATCH(6012, "Email not match with register email"),
    ERROR_DEVICE_ALREADY_REGISTER(6013, "This device has been registered"),
    ERROR_DEVICE_NO_REGISTER(6014, "This device is not registered"),
    ERROR_DEVICE_NO_CHECK_IN(6015, "This device is not check in"),
    ERROR_DEVICE_LIMITED(6016, "This device is limited"),
    ERROR_DEVICE_USING(6017, "The device is using"),
    ERROR_KEY_INCORRECT(6018, "The key is incorrect"),
    ERROR_KEY_DEACTIVATE(6019, "The key is not activate"),
    ERROR_OUT_EXPIRATION(6020, "Out expiration date"),
    ERROR_TOKEN_NOT_EXISTS(6021, "Token not exists"),
    ERROR_MAC_FORMAT(6022, "Mac address format error"),
    ERROR_MAC_EXISTS(6023, "Mac address already error"),
    ERROR_MAC_NOT_EXISTS(6024, "Mac address not exists"),
    ERROR_UPDATE_FAILURE(6025, "Update failure"),
    ERROR_TRANSACTION_FAILURE(6026, "transaction failure"),


    ERROR_AUTHORIZE(9001, "Authorize communication exception"),
    ;

    private int code;
    private String message;

    EnumResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
