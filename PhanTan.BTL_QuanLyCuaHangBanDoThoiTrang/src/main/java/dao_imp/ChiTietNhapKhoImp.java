package dao_imp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.ChiTietNhapKhoDAO;
import entity.ChiTietHoaDonNhapKho;

public class ChiTietNhapKhoImp extends UnicastRemoteObject implements ChiTietNhapKhoDAO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -445878957117007233L;
	private SessionFactory sessionFactory;
	public ChiTietNhapKhoImp(SessionFactory sessionFactory) throws RemoteException {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean themChiTietNhapKho(ChiTietHoaDonNhapKho chiTietNhapKho) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(chiTietNhapKho);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public boolean capNhatChiTietNhapKho(ChiTietHoaDonNhapKho chiTietNhapKho) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.update(chiTietNhapKho);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public boolean xoaChiTietNhapKho(ChiTietHoaDonNhapKho chiTietNhapKho) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.delete(chiTietNhapKho);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public List<ChiTietHoaDonNhapKho> layDanhSachCTHoaDonNhapKhoTheoMaHDBH(String ma) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from ChiTietHoaDonNhapKho cthd where cthd.maHoaDonNhapKho like ?1";
		try {
			List<ChiTietHoaDonNhapKho> danhSachCTHoaDonNhapKho = session
					.createNativeQuery(query, ChiTietHoaDonNhapKho.class)
					.setParameter(1, ma)
					.getResultList();
			tr.commit();
			return danhSachCTHoaDonNhapKho;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public List<ChiTietHoaDonNhapKho> layDanhSachCTHoaDonNhapKhoTheoMaSP(String ma) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from ChiTietHoaDonNhapKho cthd where cthd.maSanPham like ?1";
		try {
			List<ChiTietHoaDonNhapKho> danhSachCTHoaDonNhapKho = session
					.createNativeQuery(query, ChiTietHoaDonNhapKho.class)
					.setParameter(1, ma)
					.getResultList();
			tr.commit();
			return danhSachCTHoaDonNhapKho;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	

}
