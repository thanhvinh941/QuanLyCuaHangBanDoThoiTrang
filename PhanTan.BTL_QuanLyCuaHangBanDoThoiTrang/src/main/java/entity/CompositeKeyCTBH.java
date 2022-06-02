package entity;

import java.io.Serializable;

public class CompositeKeyCTBH implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HoaDonBanHang hoaDonBanHang;
	private SanPham sanPham;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoaDonBanHang == null) ? 0 : hoaDonBanHang.hashCode());
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
		CompositeKeyCTBH other = (CompositeKeyCTBH) obj;
		if (hoaDonBanHang == null) {
			if (other.hoaDonBanHang != null)
				return false;
		} else if (!hoaDonBanHang.equals(other.hoaDonBanHang))
			return false;
		if (sanPham == null) {
			if (other.sanPham != null)
				return false;
		} else if (!sanPham.equals(other.sanPham))
			return false;
		return true;
	}
	public CompositeKeyCTBH() {
	}
	
	
	
}
