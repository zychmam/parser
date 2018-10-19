package com.aaa.bbb;

public class POJO {
	
	private String type;
	private String key;
	private String identifier;
	private SimpleAttributes simpleAttributes = new SimpleAttributes();

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public SimpleAttributes getSimpleAttributes() {
		return simpleAttributes;
	}

	public void setSimpleAttributes(SimpleAttributes simpleAttributes) {
		this.simpleAttributes = simpleAttributes;
	}

	@Override
	public String toString() {
		return "POJO [identifier=" + identifier + ", key=" + key + ", type=" + type + ", simpleAttributes=" + simpleAttributes + "]";
	}



}