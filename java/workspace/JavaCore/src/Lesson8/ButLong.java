package Lesson8;

import java.io.Serializable;

public class ButLong implements Serializable { // Import thằng này mới in được ra file
	private boolean muc;
	private static final long serialVersionUID = 1111111111 ;
	public ButLong(boolean muc) {
		this.muc = muc;
	}
	
	public boolean isMuc() {
		return muc;
	}

	public void setMuc(boolean muc) {
		this.muc = muc;
	}

}
