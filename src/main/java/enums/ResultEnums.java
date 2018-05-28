package enums;

public enum ResultEnums {
	UNKNOW_ERROR("-1", "未知错误"),
	NO_DATA("300", "数据不存在"),
	YOUNG_ERROR("200", "年龄不能小于16岁"),
	;
	private String code;
	private String message;
	private ResultEnums(String code, String message) {
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
