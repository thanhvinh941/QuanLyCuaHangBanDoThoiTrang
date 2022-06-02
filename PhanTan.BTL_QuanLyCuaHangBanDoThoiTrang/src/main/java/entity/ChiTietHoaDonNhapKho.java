package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="ChiTietHoaDonNhapKho")
@IdClass(CompositeKeyCTNK.class)
public class ChiTietHoaDonNhapKho implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1846561257179415896L;
	@Column(name= "soLuong")
	private int soLuong;
	@Column(name = "giaNhap")
	private double giaNhap;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSanPham")
	private SanPham sanPham;
	
	@Id
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name = "maHoaDonNhapKho")
	private HoaDonNhapKho hoaDonNhapKho;


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public double getGiaNhap() {
		return giaNhap;
	}


	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}


	public SanPham getSanPham() {
		return sanPham;
	}


	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}


	public HoaDonNhapKho getHoaDonNhapKho() {
		return hoaDonNhapKho;
	}


	public void setHoaDonNhapKho(HoaDonNhapKho hoaDonNhapKho) {
		this.hoaDonNhapKho = hoaDonNhapKho;
	}


	public ChiTietHoaDonNhapKho(int soLuong, double giaNhap) {
		super();
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
	}


	public ChiTietHoaDonNhapKho() {
	}
	

	public ChiTietHoaDonNhapKho(int soLuong, double giaNhap, SanPham sanPham, HoaDonNhapKho hoaDonNhapKho) {
		super();
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.sanPham = sanPham;
		this.hoaDonNhapKho = hoaDonNhapKho;
	}


	public double thanhTien() {
		double attempt = 0;
		if(giaNhap > 0.0 && soLuong > 0 )
			attempt = giaNhap * soLuong;
		return attempt;
	}
	
	
	
}
