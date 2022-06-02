package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ChuCuaHang")
public class ChuCuaHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6460853071755701804L;
	@Id
	@Column(name = "maChuCuaHang")
	private String maChuCuaHang;
	@Column(name ="tenChuCuaHang", columnDefinition = "nvarchar(50)")
	private String tenChuCuaHang;
	@Column(name = "gioiTinh")
	private boolean gioiTinh;
	@Column(name ="soCMND")
	private String soCMND;
	@Column(name = "soDienThoai")
	private String soDienThoai;
	@Column(name = "diaChi", columnDefinition = "nvarchar(50)")
	private String diaChi;
	@Column(name = "thanhPho", columnDefinition = "nvarchar(20)")
	private String thanhPho;
	@Column(name ="ngaySinh", columnDefinition = "Date")
	private Date ngaySinh;

	@OneToMany(mappedBy = "chuCuaHang")
	private List<HoaDonBanHang> danhSachHoaDonBanHang;
	@OneToMany(mappedBy = "chuCuaHang")
	private List<HoaDonNhapKho> danhSachHoaDonNhapKho;
	@OneToOne
	@PrimaryKeyJoinColumn
	private TaiKhoan taiKhoan;
	
	
	
	public String getMaChuCuaHang() {
		return maChuCuaHang;
	}
	public void setMaChuCuaHang(String maChuCuaHang) {
		this.maChuCuaHang = maChuCuaHang;
	}
	public String getTenChuCuaHang() {
		return tenChuCuaHang;
	}
	public void setTenChuCuaHang(String tenChuCuaHang) {
		this.tenChuCuaHang = tenChuCuaHang;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
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
	public List<HoaDonBanHang> getDanhSachHoaDonBanHang() {
		return danhSachHoaDonBanHang;
	}
	public void setDanhSachHoaDonBanHang(List<HoaDonBanHang> danhSachHoaDonBanHang) {
		this.danhSachHoaDonBanHang = danhSachHoaDonBanHang;
	}
	public List<HoaDonNhapKho> getDanhSachHoaDonNhapKho() {
		return danhSachHoaDonNhapKho;
	}
	public void setDanhSachHoaDonNhapKho(List<HoaDonNhapKho> danhSachHoaDonNhapKho) {
		this.danhSachHoaDonNhapKho = danhSachHoaDonNhapKho;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	

	public ChuCuaHang(String maChuCuaHang, String tenChuCuaHang, boolean gioiTinh, String soCMND, String soDienThoai,
			String diaChi, String thanhPho, Date ngaySinh) {
		super();
		this.maChuCuaHang = maChuCuaHang;
		this.tenChuCuaHang = tenChuCuaHang;
		this.gioiTinh = gioiTinh;
		this.soCMND = soCMND;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.thanhPho = thanhPho;
		this.ngaySinh = ngaySinh;
	}
	public ChuCuaHang() {
	}
	
	public ChuCuaHang(String maChuCuaHang) {
		super();
		this.maChuCuaHang = maChuCuaHang;
	}
	@Override
	public String toString() {
		return "ChuCuaHang [maChuCuaHang=" + maChuCuaHang + ", tenChuCuaHang=" + tenChuCuaHang + ", gioiTinh="
				+ gioiTinh + ", soCMND=" + soCMND + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi
				+ ", thanhPho=" + thanhPho + ", ngaySinh=" + ngaySinh + ", danhSachHoaDonBanHang="
				+ danhSachHoaDonBanHang + ", danhSachHoaDonNhapKho=" + danhSachHoaDonNhapKho + ", taiKhoan=" + taiKhoan
				+ "]";
	}
	

	
}
