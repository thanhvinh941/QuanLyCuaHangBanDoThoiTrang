package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="KhachHang")
public class KhachHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8555293660602865605L;
	@Id
	@Column(name = "maKhachHang")
	private String maKhachHang;
	@Column(name = "tenKhachHang", columnDefinition = "nvarchar(50)")
	private String tenKhachHang;
	@Column(name = "soCMND")
	private String soCMND;
	@Column(name = "soDienThoai")
	private String soDienThoai;
	@Column(name = "diaChi",columnDefinition = "nvarchar(50)")
	private String diaChi;
	@Column(name = "thanhPho", columnDefinition = "nvarchar(20)")
	private String thanhPho;
	@Column(name = "ngaySinh", columnDefinition = "Date")
	private Date ngaySinh;
	@Column(name = "gioiTinh")
	private boolean gioiTinh;
	
	@OneToMany(mappedBy = "khachHang")
	private List<HoaDonBanHang> danhSachHoaDonBanHang;

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getThanhPho() {
		return thanhPho;
	}

	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public List<HoaDonBanHang> getDanhSachHoaDonBanHang() {
		return danhSachHoaDonBanHang;
	}

	public void setDanhSachHoaDonBanHang(List<HoaDonBanHang> danhSachHoaDonBanHang) {
		this.danhSachHoaDonBanHang = danhSachHoaDonBanHang;
	}

	public KhachHang(String maKhachHang, String tenKhachHang, String soCMND, String soDienThoai, String diaChi,
			String thanhPho, Date ngaySinh, boolean gioiTinh) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.soCMND = soCMND;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.thanhPho = thanhPho;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}

	public KhachHang() {
	}
	
	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", soCMND=" + soCMND
				+ ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", thanhPho=" + thanhPho + ", ngaySinh="
				+ ngaySinh + ", gioiTinh=" + gioiTinh  + "]";
	}

}
