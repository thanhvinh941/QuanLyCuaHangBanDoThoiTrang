package dao_imp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.TaiKhoanDAO;
import entity.TaiKhoan;

public class TaiKhoanImp extends UnicastRemoteObject implements TaiKhoanDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7952290279707087988L;
	private SessionFactory sessionFactory;

	public TaiKhoanImp(SessionFactory sessionFactory) throws RemoteException {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean themTaiKhoan(TaiKhoan taiKhoan) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(taiKhoan);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public boolean capNhatMatKhau(String tenDangNhap, String newPass) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "select * from TaiKhoan tk where tk.tenDangNhap like ?1";
		try {
			TaiKhoan taiKhoan = session.createNativeQuery(query, TaiKhoan.class).setParameter(1, tenDangNhap)
					.getSingleResult();
			taiKhoan.setMatKhau(newPass);
			session.update(taiKhoan);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public int kiemTraTaiKhoan(String tenDangNhap, String matKhau) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "select * from TaiKhoan tk where tk.tenDangNhap like '%" + tenDangNhap + "%'";
		try {

			TaiKhoan taiKhoan = session.createNativeQuery(query, TaiKhoan.class)
					// .setParameter(1, tenDangNhap)
					.getSingleResult();
			tr.commit();
			if (taiKhoan.getMatKhau().equalsIgnoreCase(matKhau)) {
				// return taiKhoan.getQuyen();
				return 0;
			} else {
				// return "Sai mật khẩu";
				return 1;
			}
		} catch (Exception e) {
			tr.rollback();

		}
		session.close();
		// return "Sai tên đăng nhập";
		return -1;
	}

	@Override
	public boolean kiemtraTinhTrangDangNhap(Boolean tinhTrang, String tenDangNhap) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "update TaiKhoan set  tinhTrang = 1 where tenDangNhap like '" + tenDangNhap + "'";
		try {

			session.createNativeQuery(query, TaiKhoan.class)
					// .setParameter(1, tinhTrang)
					// .setParameter(2, tenDangNhap)
					.getSingleResult();
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();

		}
		session.close();
		// return "Sai tên đăng nhập";
		return false;
	}

	@Override
	public boolean cpanhatTaiKhoan(TaiKhoan taikhoan) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.update(taikhoan);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public TaiKhoan layThongTinTaiKhoanTheoTenDangNhap(String ma) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from TaiKhoan tk where tk.tenDangNhap like ?1";
		try {
			TaiKhoan taiKhoan = session.createNativeQuery(query, TaiKhoan.class).setParameter(1, ma).getSingleResult();
			tr.commit();
			return taiKhoan;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public TaiKhoan layThongTinTaiKhoanTheoTrangThai(boolean tinhTrang) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		int n = 0;
		if (tinhTrang)
			n = 1;
		else
			n = 0;
		String query = "Select * from TaiKhoan tk where tk.tinhTrang = ?1 and tk.ghiChu = 1";
		try {
			TaiKhoan taiKhoan = session.createNativeQuery(query, TaiKhoan.class).setParameter(1, n).getSingleResult();
			tr.commit();
			return taiKhoan;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public boolean capnhatTrangThai(TaiKhoan taiKhoan) {
		/*
		 * Session session = sessionFactory.openSession(); Transaction tr =
		 * session.beginTransaction(); String query =
		 * "select * from TaiKhoan tk where tk.trangThai like ?1"; try { TaiKhoan
		 * taiKhoan = session .createNativeQuery(query, TaiKhoan.class) .setParameter(1,
		 * tenDangNhap) .getSingleResult(); taiKhoan.setMatKhau(newPass);
		 * session.update(taiKhoan); tr.commit(); return true; } catch (Exception e) {
		 * tr.rollback(); } session.close();
		 */
		return false;
	}

	@Override
	public List<TaiKhoan> latTatCaThongTinTaiKhoan() throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from TaiKhoan";
		try {
			List<TaiKhoan> taiKhoan = session
					.createNativeQuery(query, TaiKhoan.class)
					.getResultList();
			tr.commit();
			return taiKhoan;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

}
