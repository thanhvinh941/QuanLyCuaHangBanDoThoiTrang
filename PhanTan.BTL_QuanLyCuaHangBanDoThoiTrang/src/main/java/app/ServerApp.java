package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import org.hibernate.SessionFactory;

import dao.CaLamViecDAO;
import dao.ChiTietBanHangDAO;
import dao.ChiTietNhapKhoDAO;
import dao.ChuCuaHangDAO;
import dao.GenerateKeyDAO;
import dao.HangSanXuatDAO;
import dao.HoaDonBanHangDAO;
import dao.HoaDonNhapKhoDAO;
import dao.KhachHangDAO;
import dao.LoaiSanPhamDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import dao.TaiKhoanDAO;
import dao_imp.CaLamViecImp;
import dao_imp.ChiTietBanHangImp;
import dao_imp.ChiTietNhapKhoImp;
import dao_imp.ChuCuaHangImp;
import dao_imp.GenerateKeyImp;
import dao_imp.HangSanXuatImp;
import dao_imp.HoaDonBanHangImp;
import dao_imp.HoaDonNhapKhoImp;
import dao_imp.KhachHangImp;
import dao_imp.LoaiSanPhamImp;
import dao_imp.MySessionFactory;
import dao_imp.NhanVienImp;
import dao_imp.SanPhamImp;
import dao_imp.TaiKhoanImp;

public class ServerApp {
	public static void main(String[] args) {
		
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null)
		{
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			LocateRegistry.createRegistry(9999);
			SessionFactory sessionFactory = new MySessionFactory().getSessionFactory();
			
			TaiKhoanDAO taiKhoan = new TaiKhoanImp(sessionFactory);//Remote Object
			KhachHangDAO khachhang = new KhachHangImp(sessionFactory);
			NhanVienDAO nhanvien = new NhanVienImp(sessionFactory);//Remote Object
			LoaiSanPhamDAO loaisanpham = new LoaiSanPhamImp(sessionFactory);
			SanPhamDAO sanpham = new SanPhamImp(sessionFactory);//Remote Object
			HoaDonBanHangDAO hoadonbanhang = new HoaDonBanHangImp(sessionFactory);//Remote Object
			HoaDonNhapKhoDAO hoadonnhapkho = new HoaDonNhapKhoImp(sessionFactory);
			HangSanXuatDAO hangsanxuat = new HangSanXuatImp(sessionFactory);//Remote Object
			GenerateKeyDAO generateKey = new GenerateKeyImp(sessionFactory);
			ChuCuaHangDAO chucuahang = new ChuCuaHangImp(sessionFactory);//Remote Object
			ChiTietBanHangDAO chitietbanhang = new ChiTietBanHangImp(sessionFactory);
			ChiTietNhapKhoDAO chitietnhapkho = new ChiTietNhapKhoImp(sessionFactory);
			CaLamViecDAO calamviec = new CaLamViecImp(sessionFactory);//Remote Object
//			NewsFacade newsFacade = new NewsImpl();
//			JNDI
			Naming.bind("rmi://localhost:9999/taiKhoan", taiKhoan);
			Naming.bind("rmi://localhost:9999/khachhang", khachhang);
			Naming.bind("rmi://localhost:9999/nhanvien", nhanvien);
			Naming.bind("rmi://localhost:9999/loaisanpham", loaisanpham);
			Naming.bind("rmi://localhost:9999/sanpham", sanpham);
			Naming.bind("rmi://localhost:9999/hoadonbanhang", hoadonbanhang);
			Naming.bind("rmi://localhost:9999/hoadonnhapkho", hoadonnhapkho);
			Naming.bind("rmi://localhost:9999/hangsanxuat", hangsanxuat);
			Naming.bind("rmi://localhost:9999/chucuahang", chucuahang);
			Naming.bind("rmi://localhost:9999/chitietbanhang", chitietbanhang);
			Naming.bind("rmi://localhost:9999/chitietnhapkho", chitietnhapkho);
			Naming.bind("rmi://localhost:9999/calamviec", calamviec);
			Naming.bind("rmi://localhost:9999/generateKey", generateKey);
//			Naming.bind("rmi://192.168.1.6:9999/taiKhoan", newsFacade);
			
			System.out.println("Server bound in RMIRegistry");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
