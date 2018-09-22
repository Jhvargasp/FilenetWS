package mx.com.metlife.filenet.utils;

public class MetaData {
	private String key = null;
	private String value = null;
	private boolean isRequired = false;

	public MetaData(String key, String value, boolean required) {
		this.key = key;
		this.value = value;
		this.isRequired = required;
	}

	public boolean isRequired() {
		return this.isRequired;
	}

	public void setRequired(boolean paramBoolean) {
		this.isRequired = paramBoolean;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String paramString) {
		this.key = paramString;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String paramString) {
		this.value = paramString;
	}
}
