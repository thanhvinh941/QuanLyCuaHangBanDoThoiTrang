package dao_imp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.LoaiSanPhamDAO;
import entity.LoaiSanPham;

public class LoaiSanPhamImp extends UnicastRemoteObject implements LoaiSanPhamDAO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4286750314719992810L;
	private SessionFactory sessionFactory;
	public LoaiSanPhamImp(SessionFactory sessionFactory) throws RemoteException {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean themLoaiSanPham(LoaiSanPham loaiSP) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(loaiSP);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean capNhatLoaiSanPham(LoaiSanPham loaiSP) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.update(loaiSP);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<LoaiSanPham> layTatCaLoaiSanPham() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from LoaiSanPham lsp";
		try {
			List<LoaiSanPham> danhSachLoaiSanPham = session
					.createNativeQuery(query, LoaiSanPham.class)
					.getResultList();
			tr.commit();
			return danhSachLoaiSanPham;
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}

	@Override
	public LoaiSanPham layLoaiSanPhamTheoMa(String ma) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from LoaiSanPham lsp where lsp.maLoaiSanPham like ?1";
		try {
			LoaiSanPham loaiSanPham = session
					.createNativeQuery(query, LoaiSanPham.class)
					.setParameter(1, ma)
					.getSingleResult();
			tr.commit();
			return loaiSanPham;
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}

	@Override
	public LoaiSanPham layLoaiSanPHamTheoTen(String ten) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from LoaiSanPham lsp where lsp.tenLoai like N'%"+ten+"%' ";
		try {
			LoaiSanPham loaiSanPham = session
					.createNativeQuery(query, LoaiSanPham.class)
					//.setParameter(1, ten)
					.getSingleResult();
			tr.commit();
			return loaiSanPham;
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}

}
