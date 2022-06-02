package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "NhanVienBanHang")
public class NhanVienBanHang implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8146782455153857749L;
	@Id
	@Column(name = "maNhanVien")
	private String maNhanVien;
	@Column(name ="tenNhanVien", columnDefinition = "nvarchar(50)")
	private String tenNhanVien;
	@Column(name = "gioiTinh")
	private boolean gioiTinh;
	@Column(name ="soCMND")
	private String soCMND;
	@Column(name = "soDienThoai")
	private String soDienThoai;
	@Column(name = "diaChi",columnDefinition = "nvarchar(50)")
	private String diaChi;
	@Column(name = "thanhPho", columnDefinition = "nvarchar(20)")
	private String thanhPho;
	@Column(name ="ngaySinh", columnDefinition = "Date")
	private Date ngaySinh;
	@Column(name = "ngayVaoLam", columnDefinition = "Date")
	private Date ngayVaoLam = new Date();
	@Column(name = "tinhTrang")
	private boolean tinhTrang; 
	
	@OneToMany(mappedBy = "nhanVienBanHang")
	private List<HoaDonBanHang> danhSachHoaDonBanHang;
	@OneToMany(mappedBy = "nhanVienBanHang")
	private List<HoaDonNhapKho> danhSachHoaDonNhapKho;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private TaiKhoan taiKhoan;
	@OneToMany(mappedBy = "nhanVienBanHang")
	private List<CaLamViec> danhSachCaLamViec;

	
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
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
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
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
	public List<CaLamViec> getDanhSachCaLamViec() {
		return danhSachCaLamViec;
	}
	public void setDanhSachCaLamViec(List<CaLamViec> danhSachCaLamViec) {
		this.danhSachCaLamViec = danhSachCaLamViec;
	}
	

	
	public NhanVienBanHang(String maNhanVien, String tenNhanVien, String soCMND, String soDienThoai,
			String diaChi, String thanhPho, Date ngaySinh, boolean gioiTinh, Date ngayVaoLam) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.soCMND = soCMND;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.thanhPho = thanhPho;
		this.ngaySinh = ngaySinh;
		this.ngayVaoLam = ngayVaoLam;
	}
	public NhanVienBanHang() {
	}
	
	
	public NhanVienBanHang(String maNhanVien, String tenNhanVien, boolean gioiTinh, String soCMND, String soDienThoai,
			String diaChi, String thanhPho, Date ngaySinh, Date ngayVaoLam, boolean tinhTrang) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.soCMND = soCMND;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.thanhPho = thanhPho;
		this.ngaySinh = ngaySinh;
		this.ngayVaoLam = ngayVaoLam;
		this.tinhTrang = tinhTrang;
	}
	public NhanVienBanHang(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	@Override
	public String toString() {
		return "NhanVienBanHang [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", gioiTinh=" + gioiTinh
				+ ", soCMND=" + soCMND + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", thanhPho="
				+ thanhPho + ", ngaySinh=" + ngaySinh + ", ngayVaoLam=" + ngayVaoLam + ", danhSachHoaDonBanHang="
				+ danhSachHoaDonBanHang + ", danhSachHoaDonNhapKho=" + danhSachHoaDonNhapKho + ", taiKhoan=" + taiKhoan
				+ ", danhSachCaLamViec=" + danhSachCaLamViec + "]";
	}

	
	
}
