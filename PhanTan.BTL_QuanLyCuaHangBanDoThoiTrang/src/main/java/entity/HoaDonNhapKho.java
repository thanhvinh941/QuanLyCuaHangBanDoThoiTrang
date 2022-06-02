package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="HoaDonNhapKho")
public class HoaDonNhapKho implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3928617013556154767L;
	@Id
	@Column(name = "maHoaDonNhapKho")
	private String maHoaDonNhapKho;
	@Column(name = "ngayNhapKho", nullable = false, columnDefinition = "Date")
	private Date ngayNhapKho = new Date();
	
	@OneToMany(mappedBy = "hoaDonNhapKho")
	private List<ChiTietHoaDonNhapKho> danhSachChiTietHoaDonNhapKho;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhanVien")
	private NhanVienBanHang nhanVienBanHang;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maChuCuaHang")
	private ChuCuaHang chuCuaHang;

	public String getMaHoaDonNhapKho() {
		return maHoaDonNhapKho;
	}
	public void setMaHoaDonNhapKho(String maHoaDonNhapKho) {
		this.maHoaDonNhapKho = maHoaDonNhapKho;
	}
	public Date getNgayNhapKho() {
		return ngayNhapKho;
	}
	public void setNgayNhapKho(Date ngayNhapKho) {
		this.ngayNhapKho = ngayNhapKho;
	}
	public List<ChiTietHoaDonNhapKho> getDanhSachChiTietHoaDonNhapKho() {
		return danhSachChiTietHoaDonNhapKho;
	}
	public void setDanhSachChiTietHoaDonNhapKho(List<ChiTietHoaDonNhapKho> danhSachChiTietHoaDonNhapKho) {
		this.danhSachChiTietHoaDonNhapKho = danhSachChiTietHoaDonNhapKho;
	}
	public NhanVienBanHang getNhanVienBanHang() {
		return nhanVienBanHang;
	}
	public void setNhanVienBanHang(NhanVienBanHang nhanVienBanHang) {
		this.nhanVienBanHang = nhanVienBanHang;
	}
	public ChuCuaHang getChuCuaHang() {
		return chuCuaHang;
	}
	public void setChuCuaHang(ChuCuaHang chuCuaHang) {
		this.chuCuaHang = chuCuaHang;
	}
	public HoaDonNhapKho() {
	}
	
	public HoaDonNhapKho(String maHoaDonNhapKho) {
		super();
		this.maHoaDonNhapKho = maHoaDonNhapKho;
	}
	
	public HoaDonNhapKho(String maHoaDonNhapKho, Date ngayNhapKho, NhanVienBanHang nhanVienBanHang,
			ChuCuaHang chuCuaHang) {
		super();
		this.maHoaDonNhapKho = maHoaDonNhapKho;
		this.ngayNhapKho = ngayNhapKho;
		this.nhanVienBanHang = nhanVienBanHang;
		this.chuCuaHang = chuCuaHang;
	}
	@Override
	public String toString() {
		return "HoaDonNhapKho [maHoaDonNhapKho=" + maHoaDonNhapKho + ", ngayNhapKho=" + ngayNhapKho
				+ ", danhSachChiTietHoaDonNhapKho=" + danhSachChiTietHoaDonNhapKho + ", nhanVienBanHang="
				+ nhanVienBanHang + ", chuCuaHang=" + chuCuaHang + "]";
	}
}
