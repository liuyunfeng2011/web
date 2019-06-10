package com.gezhi.supervise.util;

public enum ResultCode {
	  /** 成功 */
    SUCCESS("200", "成功"),
    /** hibernate validate err */
    VALIDATE_ERR("2001", "参数验证失败"),
    /***/
    /** 操作失败 */
    FAIL("205", "操作失败"),
    /** 操作失败 */
    LOGIN_FAIL("2005", "账户/密码错误"),
    /** 操作失败 */
    ACCOUNT_LOCK("2006", "账户已被禁用"),
    /** 数据已存在 */
    SUCCESS_IS_HAVE("208", "数据已存在"),

    /** 没有结果 */
    NOT_DATA("911", "没有结果"),

    /** 没有登录 */
    NOT_LOGIN("600", "没有登录"),

    /** 发生异常 */
    EXCEPTION("401", "发生异常"),

    /** 系统错误 */
    SYS_ERROR("402", "系统错误"),

    /** 参数错误 */
    PARAMS_ERROR("403", "参数错误 "),

    /** 不支持或已经废弃 */
    NOT_SUPPORTED("410", "不支持或已经废弃");
    // --------------------------------------------------

    private ResultCode(String value, String msg) {
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;

}
