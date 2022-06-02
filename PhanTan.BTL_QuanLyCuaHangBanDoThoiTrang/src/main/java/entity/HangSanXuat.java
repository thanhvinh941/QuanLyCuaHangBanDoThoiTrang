package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HangSanXuat")

public class HangSanXuat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1808324261530877063L;
	@Id
	@Column(name = "maHangSanXuat")
	private String maHangSanXuat;
	@Column(name = "tenHangSanXuat", columnDefinition = "nvarchar(50)")
	private String tenHangSanXuat;
	@Column(name = "soDienThoai")
	private String soDienThoai;
	@Column(name = "diaChi", columnDefinition = "nvarchar(50)")
	private String diaChi;
	@Column(name = "thanhPho", columnDefinition = "nvarchar(20)")
	private String thanhPho;
	@Column(name = "quocGia", columnDefinition = "nvarchar(20)")
	private String quocGia;
	
	@OneToMany(mappedBy = "hangSanXuat")
	private List<SanPham> danhSachSanPham;
	
	

	public String getMaHangSanXuat() {
		return maHangSanXuat;
	}

	public void setMaHangSanXuat(String maHangSanXuat) {
		this.maHangSanXuat = maHangSanXuat;
	}

	public String getTenHangSanXuat() {
		return tenHangSanXuat;
	}

	public void setTenHangSanXuat(String tenHangSanXuat) {
		this.tenHangSanXuat = tenHangSanXuat;
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

	public String getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

	public List<SanPham> getDanhSachSanPham() {
		return danhSachSanPham;
	}

	public void setDanhSachSanPham(List<SanPham> danhSachSanPham) {
		this.danhSachSanPham = danhSachSanPham;
	}

	
	public HangSanXuat(String maHangSanXuat, String tenHangSanXuat, String soDienThoai, String diaChi, String thanhPho,
			String quocGia) {
		super();
		this.maHangSanXuat = maHangSanXuat;
		this.tenHangSanXuat = tenHangSanXuat;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.thanhPho = thanhPho;
		this.quocGia = quocGia;
	}

	public HangSanXuat() {
	}

	
	public HangSanXuat(String maHangSanXuat) {
		super();
		this.maHangSanXuat = maHangSanXuat;
	}

	@Override
	public String toString() {
		return "HangSanXuat [maHangSanXuat=" + maHangSanXuat + ", tenHangSanXuat=" + tenHangSanXuat + ", soDienThoai="
				+ soDienThoai + ", diaChi=" + diaChi + ", thanhPho=" + thanhPho + ", quocGia=" + quocGia
				+ "]";
	}
	
	
}
