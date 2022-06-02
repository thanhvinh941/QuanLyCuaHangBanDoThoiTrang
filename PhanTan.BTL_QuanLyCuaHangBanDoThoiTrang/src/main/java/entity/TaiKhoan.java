package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="TaiKhoan")

public class TaiKhoan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3188047617349711877L;
	@Id
	@Column(name = "tenDangNhap")
	private String tenDangNhap;
	@Column(name = "matKhau")
	private String matKhau;
	@Column (name = "quyen")
	private String quyen;
	@Column(name ="ghiChu")
	private boolean ghiChu;
	@Column(name="tinhTrang")
	private boolean tinhTrang;
	
	@OneToOne
	@JoinColumn(name = "maChuCuaHang")
	private ChuCuaHang chuCuaHang;
	@OneToOne
	@JoinColumn(name = "maNhanVien")
	private NhanVienBanHang nhanVienBanHang;
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getQuyen() {
		return quyen;
	}
	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}
	public boolean isGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(boolean ghiChu) {
		this.ghiChu = ghiChu;
	}
	public ChuCuaHang getChuCuaHang() {
		return chuCuaHang;
	}
	public void setChuCuaHang(ChuCuaHang chuCuaHang) {
		this.chuCuaHang = chuCuaHang;
	}
	public NhanVienBanHang getNhanVienBanHang() {
		return nhanVienBanHang;
	}
	public void setNhanVienBanHang(NhanVienBanHang nhanVienBanHang) {
		this.nhanVienBanHang = nhanVienBanHang;
	}
	
	
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public TaiKhoan(String tenDangNhap, String matKhau, String quyen, boolean ghiChu) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.quyen = quyen;
		this.ghiChu = ghiChu;
	}
	public TaiKhoan() {
	}
	
	
	public TaiKhoan(String tenDangNhap) {
		super();
		this.tenDangNhap = tenDangNhap;
	}
	public TaiKhoan(String tenDangNhap, String matKhau, String quyen, boolean ghiChu, boolean tinhTrang,
			ChuCuaHang chuCuaHang, NhanVienBanHang nhanVienBanHang) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.quyen = quyen;
		this.ghiChu = ghiChu;
		this.tinhTrang = tinhTrang;
		this.chuCuaHang = chuCuaHang;
		this.nhanVienBanHang = nhanVienBanHang;
	}
	@Override
	public String toString() {
		return "TaiKhoan [tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", quyen=" + quyen + ", ghiChu="
				+ ghiChu + ", tinhTrang=" + tinhTrang + ", chuCuaHang=" + chuCuaHang + ", nhanVienBanHang="
				+ nhanVienBanHang + "]";
	}
	
	
	
}
