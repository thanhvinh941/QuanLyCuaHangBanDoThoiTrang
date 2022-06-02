package dao_imp;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import entity.CaLamViec;
import entity.ChiTietHoaDonBanHang;
import entity.ChiTietHoaDonNhapKho;
import entity.ChuCuaHang;
import entity.HangSanXuat;
import entity.HoaDonBanHang;
import entity.HoaDonNhapKho;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.NhanVienBanHang;
import entity.SanPham;
import entity.TaiKhoan;

public class MySessionFactory {
		private SessionFactory sessionFactory;
		
		public MySessionFactory() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(CaLamViec.class)
				.addAnnotatedClass(ChiTietHoaDonBanHang.class)
				.addAnnotatedClass(ChiTietHoaDonNhapKho.class)
				.addAnnotatedClass(ChuCuaHang.class)
				.addAnnotatedClass(HangSanXuat.class)
				.addAnnotatedClass(HoaDonBanHang.class)
				.addAnnotatedClass(HoaDonNhapKho.class)
				.addAnnotatedClass(KhachHang.class)
				.addAnnotatedClass(LoaiSanPham.class)
				.addAnnotatedClass(NhanVienBanHang.class)
				.addAnnotatedClass(SanPham.class)
				.addAnnotatedClass(TaiKhoan.class)
				.getMetadataBuilder()
				.build();
		sessionFactory = metadata
				.getSessionFactoryBuilder()
				.build();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void close() {
		sessionFactory.close();
	}
}
