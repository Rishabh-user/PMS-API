package com.pms.server.authorization.dto;

public class VerifySmsCodeDto {

	private Integer code;
	private String source;
	private String ipAddress;

	public VerifySmsCodeDto(Integer code) {
		this.code = code;
	}

	public VerifySmsCodeDto() {
		super();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
