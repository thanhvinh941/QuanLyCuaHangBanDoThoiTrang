package entity;

import java.io.Serializable;
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
@Table(name = "SanPham")
public class SanPham implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7983759246266661872L;
	@Id
	@Column(name = "maSanPham")
	private String maSanPham;
	@Column(name = "tenSanPham", columnDefinition = "nvarchar(50)")
	private String tenSanPham;
	@Column(name = "giaSanPham" )
	private double giaSanPham;
	//@Id
	@Column(name = "kichThuoc")
	private String kichThuoc;
	//@Id
	@Column(name = "mauSac", columnDefinition = "nvarchar(20)")
	private String mauSac;
	@Column(name = "soLuong")
	private int soLuong;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maHangSanXuat")
	private HangSanXuat hangSanXuat;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maLoaiSanPham")
	private LoaiSanPham loaiSanPham;
	
	@OneToMany(mappedBy = "sanPham")
	private List<ChiTietHoaDonBanHang> danhSachChiTietHDBH;
	@OneToMany(mappedBy  ="sanPham")
	private List<ChiTietHoaDonNhapKho> danhSachChiTietHDNK;
	
	
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public double getGiaSanPham() {
		return giaSanPham;
	}
	public void setGiaSanPham(double giaSanPham) {
		this.giaSanPham = giaSanPham;
	}
	public String getKichThuoc() {
		return kichThuoc;
	}
	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}
	public String getMauSac() {
		return mauSac;
	}
	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public HangSanXuat getHangSanXuat() {
		return hangSanXuat;
	}
	public void setHangSanXuat(HangSanXuat hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}
	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}
	public List<ChiTietHoaDonBanHang> getDanhSachChiTietHDBH() {
		return danhSachChiTietHDBH;
	}
	public void setDanhSachChiTietHDBH(List<ChiTietHoaDonBanHang> danhSachChiTietHDBH) {
		this.danhSachChiTietHDBH = danhSachChiTietHDBH;
	}
	public List<ChiTietHoaDonNhapKho> getDanhSachChiTietHDNK() {
		return danhSachChiTietHDNK;
	}
	public void setDanhSachChiTietHDNK(List<ChiTietHoaDonNhapKho> danhSachChiTietHDNK) {
		this.danhSachChiTietHDNK = danhSachChiTietHDNK;
	}
	public SanPham() {
	}
	public SanPham(String maSanPham, String tenSanPham, double giaSanPham, String kichThuoc, String mauSac,
			int soLuong) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.giaSanPham = giaSanPham;
		this.kichThuoc = kichThuoc;
		this.mauSac = mauSac;
		this.soLuong = soLuong;
	}
	
	
	
	public SanPham(String maSanPham, String tenSanPham, double giaSanPham, String kichThuoc, String mauSac, int soLuong,
			HangSanXuat hangSanXuat, LoaiSanPham loaiSanPham) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.giaSanPham = giaSanPham;
		this.kichThuoc = kichThuoc;
		this.mauSac = mauSac;
		this.soLuong = soLuong;
		this.hangSanXuat = hangSanXuat;
		this.loaiSanPham = loaiSanPham;
	}
	public SanPham(String maSanPham) {
		super();
		this.maSanPham = maSanPham;
	}
	
	public SanPham(String maSanPham, int soLuong) {
		super();
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", giaSanPham=" + giaSanPham
				+ ", kichThuoc=" + kichThuoc + ", mauSac=" + mauSac + ", soLuong=" + soLuong + ", hangSanXuat="
				+ hangSanXuat + ", loaiSanPham=" + loaiSanPham + "]";
	}
	
	

	

	
	
	
	
	
	
}
