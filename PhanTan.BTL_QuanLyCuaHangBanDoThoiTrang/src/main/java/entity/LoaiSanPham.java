package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LoaiSanPham")
public class LoaiSanPham implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3315015331527187236L;
	@Id
	@Column(name = "maLoaiSanPham")
	private String maLoaiSanPham;
	@Column(name = "tenLoai",columnDefinition = "nvarchar(20)")
	private String tenLoai;
	@Column(name = "moTa", columnDefinition = "nvarchar(200)")
	private String moTa;
	
	@OneToMany(mappedBy = "loaiSanPham")
	private List<SanPham> sanPham;
	
	public String getMaLoaiSanPham() {
		return maLoaiSanPham;
	}


	public void setMaLoaiSanPham(String maLoaiSanPham) {
		this.maLoaiSanPham = maLoaiSanPham;
	}


	public String getTenLoai() {
		return tenLoai;
	}


	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}


	public String getMoTa() {
		return moTa;
	}


	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}


	public List<SanPham> getSanPham() {
		return sanPham;
	}


	public void setSanPham(List<SanPham> sanPham) {
		this.sanPham = sanPham;
	}


	public LoaiSanPham() {
		
	}

	public LoaiSanPham(String maLoaiSanPham, String tenLoai, String moTa) {
		super();
		this.maLoaiSanPham = maLoaiSanPham;
		this.tenLoai = tenLoai;
		this.moTa = moTa;
	}
	
	

	public LoaiSanPham(String maLoaiSanPham) {
		super();
		this.maLoaiSanPham = maLoaiSanPham;
	}


	@Override
	public String toString() {
		return "LoaiSanPham [maLoaiSanPham=" + maLoaiSanPham + ", tenLoai=" + tenLoai + ", moTa=" + moTa  + "]";
	}

}
