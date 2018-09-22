package mx.com.metlife.filenet.utils;

import java.util.ArrayList;
import java.util.Collection;

public class MetaDataList extends ArrayList {
	public MetaDataList() {
	}

	public MetaDataList(int paramInt) {
		super(paramInt);
	}

	public MetaDataList(Collection paramCollection) {
		super(paramCollection);
	}

	public void add(int paramInt, Object paramObject) {
		if ((paramObject instanceof MetaData)) {
			super.add(paramInt, paramObject);
		}
	}

	public boolean add(Object paramObject) {
		if ((paramObject instanceof MetaData)) {
			return super.add(paramObject);
		}
		return false;
	}

	public boolean isAnyRequred() {
		boolean bool = false;
		for (int i = 0; i < size(); i++) {
			bool |= ((MetaData) get(i)).isRequired();
		}
		return bool;
	}

	public String[] getKeys() {
		String[] arrayOfString = new String[size()];
		for (int i = 0; i < size(); i++) {
			arrayOfString[i] = ((MetaData) get(i)).getKey();
		}
		return arrayOfString;
	}

	public String[] getValues() {
		String[] arrayOfString = new String[size()];
		for (int i = 0; i < size(); i++) {
			arrayOfString[i] = ((MetaData) get(i)).getValue();
		}
		return arrayOfString;
	}
}
