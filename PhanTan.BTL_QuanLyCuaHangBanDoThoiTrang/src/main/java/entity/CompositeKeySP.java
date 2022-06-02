package entity;

import java.io.Serializable;
import java.util.Objects;

public class CompositeKeySP implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kichThuoc;
	private String mauSac;
	private String maSanPham;
	public CompositeKeySP() {
	}
	@Override
	public int hashCode() {
		return Objects.hash(kichThuoc, maSanPham, mauSac);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKeySP other = (CompositeKeySP) obj;
		return Objects.equals(kichThuoc, other.kichThuoc) && Objects.equals(maSanPham, other.maSanPham)
				&& Objects.equals(mauSac, other.mauSac);
	}


	
	
}
