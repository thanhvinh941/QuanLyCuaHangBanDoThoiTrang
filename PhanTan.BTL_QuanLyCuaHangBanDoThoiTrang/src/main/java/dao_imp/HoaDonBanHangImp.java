package dao_imp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.HoaDonBanHangDAO;
import entity.ChiTietHoaDonBanHang;
import entity.HoaDonBanHang;
import entity.SanPham;

public class HoaDonBanHangImp extends UnicastRemoteObject implements HoaDonBanHangDAO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6482221420207289989L;
	private SessionFactory sessionFactory;
	
	public HoaDonBanHangImp(SessionFactory sessionFactory) throws RemoteException {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean themHoaDonBanHang(HoaDonBanHang hoaDonBanHang) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(hoaDonBanHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public boolean capNhatHoaDonBanHang(HoaDonBanHang hoaDonBanHang) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.update(hoaDonBanHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public List<HoaDonBanHang> layTatCaHoaDonBanHang() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from HoaDonBanHang hd";
		try {
			List<HoaDonBanHang> danhSachHoaDonBanHang = session
					.createNativeQuery(query, HoaDonBanHang.class)
					.getResultList();
			tr.commit();
			return danhSachHoaDonBanHang;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public HoaDonBanHang layHoaDonTheoMa(String ma) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			HoaDonBanHang hoaDonBanHang = session.find(HoaDonBanHang.class, ma);
			tr.commit();
			return hoaDonBanHang;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public List<HoaDonBanHang> layDanhSachHoaDonBanHangTheoNgay(String date) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from HoaDonBanHang hd where hd.ngayLapHoaDon like ?1";
		try {
			List<HoaDonBanHang> danhSachHoaDonBanHang = session
					.createNativeQuery(query, HoaDonBanHang.class)
					.setParameter(1, date)
					.getResultList();
			tr.commit();
			return danhSachHoaDonBanHang;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public List<HoaDonBanHang> layDanhSachHoaDonBanHangTheoTenKhachHang(String tenKH) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from HoaDonBanHang hd inner join KhachHang kh on hd.maKhachHang = kh.maKhachHang where kh.tenKhachHang like ?1";
		try {
			List<HoaDonBanHang> danhSachHoaDonBanHang = session
					.createNativeQuery(query, HoaDonBanHang.class)
					.setParameter(1, tenKH)
					.getResultList();
			tr.commit();
			return danhSachHoaDonBanHang;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
		
	}

	@Override
	public List<HoaDonBanHang> layDanhSachHoaDonBanHangTheoMaKhachHang(String maKH) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from HoaDonBanHang hd where hd.maKhachHang like ?1";
		try {
			List<HoaDonBanHang> danhSachHoaDonBanHang = session
					.createNativeQuery(query, HoaDonBanHang.class)
					.setParameter(1, maKH)
					.getResultList();
			tr.commit();
			return danhSachHoaDonBanHang;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public List<HoaDonBanHang> layDanhSachHoaDonBanHangTheoMaNhanVien(String maNV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from HoaDonBanHang hd where hd.maNhanVien like ?1";
		try {
			List<HoaDonBanHang> danhSachHoaDonBanHang = session
					.createNativeQuery(query, HoaDonBanHang.class)
					.setParameter(1, maNV)
					.getResultList();
			tr.commit();
			return danhSachHoaDonBanHang;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public List<HoaDonBanHang> layDanhSachHoaDonBanHangTheoTenNhanVien(String tenNV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from HoaDonBanHang hd inner join NhanVienBanHang nv on hd.maNhanVien = nv.maNhanVien where nv.tenNhanVien like ?1";
		try {
			List<HoaDonBanHang> danhSachHoaDonBanHang = session
					.createNativeQuery(query, HoaDonBanHang.class)
					.setParameter(1, tenNV)
					.getResultList();
			tr.commit();
			return danhSachHoaDonBanHang;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public double tinhTongTien(String ma) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "select * from ChiTietHoaDonBanHang  cthd where cthd.maHoaDonBanHang like ?1";
		double tongTien = 0;
		try {
			List<ChiTietHoaDonBanHang> danhSachChiTietBanHang= session
					.createNativeQuery(query, ChiTietHoaDonBanHang.class)
					.setParameter(1, ma)
					.getResultList();
			tr.commit();
			for(ChiTietHoaDonBanHang chiTietHoaDon : danhSachChiTietBanHang) {
				int soLuong = chiTietHoaDon.getSoLuong();
				SanPham sanPham = chiTietHoaDon.getSanPham();
				double gia = sanPham.getGiaSanPham();
				if (soLuong > 0.0 && gia > 0)
				 tongTien += soLuong * gia;
			}
			return tongTien;
		} catch (Exception e) {
			tr.rollback();
		}
		return tongTien;
	}

}
