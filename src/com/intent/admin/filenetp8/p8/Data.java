package com.intent.admin.filenetp8.p8;

import com.intent.admin.filenetp8.UtilFilenetP8;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.log4j.Logger;

public class Data {
	private Logger log = Logger.getLogger(Data.class);
	public static final int TYPE_BINARY = 1;
	public static final int TYPE_BOOLEAN = 2;
	public static final int TYPE_DATETIME = 3;
	public static final int TYPE_FLOAT = 4;
	public static final int TYPE_ID = 5;
	public static final int TYPE_INTEGER = 6;
	public static final int TYPE_OBJECT = 7;
	public static final int TYPE_STRING = 8;
	private String link;
	private String tipo;
	private int type;
	private int rsNumber;
	private String name;
	private String value;
	private String displayName;

	private Data(int type, int rsNumber, String name, String displayName) {
		this.type = type;
		this.rsNumber = rsNumber;
		this.name = name;
		setDisplayName(displayName);
	}

	public Data() {
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setType(String typeValue) {
		if (typeValue.equals("string")) {
			this.type = 8;
		} else if (typeValue.equals("dateTime")) {
			this.type = 3;
		} else if (typeValue.equals("binary")) {
			this.type = 1;
		} else if (typeValue.equals("boolean")) {
			this.type = 2;
		} else if (typeValue.equals("float")) {
			this.type = 4;
		} else if (typeValue.equals("id")) {
			this.type = 5;
		} else if (typeValue.equals("int")) {
			this.type = 6;
		} else if (typeValue.equals("object")) {
			this.type = 7;
		}
	}

	public int getRsNumber() {
		return this.rsNumber;
	}

	public void setRsNumber(int rsNumber) {
		this.rsNumber = rsNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		if (getType() == 3) {
			try {
				UtilFilenetP8.getFormatDate().setTimeZone(TimeZone.getTimeZone("GMT"));

				Date date = UtilFilenetP8.getFormatDate().parse(this.value);

				UtilFilenetP8.getFormatDate().setTimeZone(TimeZone.getTimeZone(UtilFilenetP8.getTimeZone()));

				System.out.println(UtilFilenetP8.getFormatDate().format(date));

				return date;
			} catch (Exception ex) {
				if (this.log.isDebugEnabled()) {
					StringBuffer buffer = new StringBuffer();
					buffer.append("Problems parsing the date: ");
					buffer.append(this.value);
					this.log.debug(buffer.toString(), ex);
				}
				return this.value;
			}
		}
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Data autoClone() {
		return new Data(getType(), getRsNumber(), getName() != null ? new String(getName()) : null,
				getDisplayName() != null ? new String(getDisplayName()) : null);
	}

	public String toString() {
		return

		" <FILENET_RESULT_DATA> { DisplayName='" + getDisplayName() + "' ; name='" + getName() + "' ; value='"
				+ getValue() + "' ; type='" + getType() + "' ; rsNumber='" + getRsNumber() + "' ; link='" + getLink()
				+ "' } </FILENET_RESULT_DATA>";
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
