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
@Table(name ="HoaDonBanHang")
public class HoaDonBanHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2464755778377682487L;
	@Id
	@Column(name = "maHoaDonBanHang")
	private String maHoaDonBanHang;
	@Column(name = "ngayLapHoaDon", nullable = false, columnDefinition = "Date")
	private Date ngayLapHoaDon = new Date();
	@Column(name = "ghiChu")
	private String ghiChu;
	@Column(name = "tienKhachDua")
	private double tienKhachDua;
	
	@OneToMany(mappedBy = "hoaDonBanHang")
	private List<ChiTietHoaDonBanHang> danhSachChiTietHoaDonBanHang;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maKhachHang")
	private KhachHang khachHang;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhanVien")
	private NhanVienBanHang nhanVienBanHang;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maChuCuaHang")
	private ChuCuaHang chuCuaHang;
	
	public String getMaHoaDonBanHang() {
		return maHoaDonBanHang;
	}
	public void setMaHoaDonBanHang(String maHoaDonBanHang) {
		this.maHoaDonBanHang = maHoaDonBanHang;
	}
	public List<ChiTietHoaDonBanHang> getDanhSachChiTietHoaDonBanHang() {
		return danhSachChiTietHoaDonBanHang;
	}
	public void setDanhSachChiTietHoaDonBanHang(List<ChiTietHoaDonBanHang> danhSachChiTietHoaDonBanHang) {
		this.danhSachChiTietHoaDonBanHang = danhSachChiTietHoaDonBanHang;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
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
	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}
	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	public double getTienKhachDua() {
		return tienKhachDua;
	}
	public void setTienKhachDua(double tienKhachDua) {
		this.tienKhachDua = tienKhachDua;
	}
	public HoaDonBanHang(String maHoaDonBanHang) {
		super();
		this.maHoaDonBanHang = maHoaDonBanHang;
	}
	public HoaDonBanHang() {
	}
	
	
	public HoaDonBanHang(String maHoaDonBanHang, Date ngayLapHoaDon, String ghiChu, KhachHang khachHang,
			NhanVienBanHang nhanVienBanHang) {
		super();
		this.maHoaDonBanHang = maHoaDonBanHang;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.ghiChu = ghiChu;
		this.khachHang = khachHang;
		this.nhanVienBanHang = nhanVienBanHang;
	}
	
	public HoaDonBanHang(String maHoaDonBanHang, Date ngayLapHoaDon, String ghiChu, KhachHang khachHang,
			ChuCuaHang chuCuaHang) {
		super();
		this.maHoaDonBanHang = maHoaDonBanHang;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.ghiChu = ghiChu;
		this.khachHang = khachHang;
		this.chuCuaHang = chuCuaHang;
	}
	
	public HoaDonBanHang(String maHoaDonBanHang, Date ngayLapHoaDon, String ghiChu, KhachHang khachHang,
			NhanVienBanHang nhanVienBanHang, ChuCuaHang chuCuaHang) {
		super();
		this.maHoaDonBanHang = maHoaDonBanHang;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.ghiChu = ghiChu;
		this.khachHang = khachHang;
		this.nhanVienBanHang = nhanVienBanHang;
		this.chuCuaHang = chuCuaHang;
	}
	
	public HoaDonBanHang(String maHoaDonBanHang, Date ngayLapHoaDon, String ghiChu, double tienKhachDua,
			KhachHang khachHang, NhanVienBanHang nhanVienBanHang, ChuCuaHang chuCuaHang) {
		super();
		this.maHoaDonBanHang = maHoaDonBanHang;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.ghiChu = ghiChu;
		this.tienKhachDua = tienKhachDua;
		this.khachHang = khachHang;
		this.nhanVienBanHang = nhanVienBanHang;
		this.chuCuaHang = chuCuaHang;
	}
	@Override
	public String toString() {
		return "HoaDonBanHang [maHoaDonBanHang=" + maHoaDonBanHang + ", ngayLapHoaDon=" + ngayLapHoaDon + "]";
	}
	
	
}
