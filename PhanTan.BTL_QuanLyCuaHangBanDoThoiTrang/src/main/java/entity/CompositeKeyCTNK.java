package entity;

import java.io.Serializable;

public class CompositeKeyCTNK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SanPham sanPham;
	private HoaDonNhapKho hoaDonNhapKho;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoaDonNhapKho == null) ? 0 : hoaDonNhapKho.hashCode());
		result = prime * result + ((sanPham == null) ? 0 : sanPham.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKeyCTNK other = (CompositeKeyCTNK) obj;
		if (hoaDonNhapKho == null) {
			if (other.hoaDonNhapKho != null)
				return false;
		} else if (!hoaDonNhapKho.equals(other.hoaDonNhapKho))
			return false;
		if (sanPham == null) {
			if (other.sanPham != null)
				return false;
		} else if (!sanPham.equals(other.sanPham))
			return false;
		return true;
	}
	public CompositeKeyCTNK() {
	}
	
	
}
