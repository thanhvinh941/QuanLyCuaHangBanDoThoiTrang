package entity;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CaLamViec")
@NamedQueries({
	@NamedQuery(name = "layDanhSachCaLamViec", query = "Select clv from CaLamViec clv ")
})
public class CaLamViec implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3568473708770359978L;
	@Id
	@Column(name = "maCa")
	private String maCa;
	@Column(name = "buoi", columnDefinition = "nvarchar(10)")
	private String buoi;
	@Column(name = "ngay", columnDefinition = "Date")
	private Date ngay;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhanVien")
	private NhanVienBanHang nhanVienBanHang;

	public String getMaCa() {
		return maCa;
	}

	public void setMaCa(String maCa) {

		this.maCa = maCa;
	}

	public String getBuoi() {
		return buoi;
	}

	public void setBuoi(String buoi) {
		this.buoi = buoi;
	}

	

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public NhanVienBanHang getNhanVienBanHang() {
		return nhanVienBanHang;
	}

	public void setNhanVienBanHang(NhanVienBanHang nhanVienBanHang) {
		this.nhanVienBanHang = nhanVienBanHang;
	}


	public CaLamViec(String maCa, String buoi, Date ngay) throws ParseException {
		super();
		this.maCa = maCa;
		this.buoi = buoi;
		this.ngay =   ngay;
	}

	public CaLamViec() {
		super();
	}

	@Override
	public String toString() {
		return "CaLamViec [maCa=" + maCa + ", buoi=" + buoi + ", thoiGian=" + ngay + "]";
	}

	
	
	
}
