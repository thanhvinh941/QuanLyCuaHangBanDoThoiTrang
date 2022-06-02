package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.hibernate.SessionFactory;

import entity.ChuCuaHang;
import entity.NhanVienBanHang;
import entity.TaiKhoan;
import gui.DangNhap;
import gui.GiaoDienChinh_ChuCuaHang;
import guiNV.GiaoDienChinh_NhanVienBanHang;
import dao.ChuCuaHangDAO;
import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import javax.swing.JPasswordField;

public class GD_DoiMatKhau extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField txtPassOld;
	private JButton btnDangNhap;
	private ImageIcon iConDangNhap= new ImageIcon(DangNhap.class.getResource("/img/enter.png"));
	private ImageIcon iConExit= new ImageIcon(DangNhap.class.getResource("/img/exit_login.png"));
	private ImageIcon iConuser= new ImageIcon(DangNhap.class.getResource("/img/user.png"));
	private ImageIcon iConpass= new ImageIcon(DangNhap.class.getResource("/img/padlock.png"));
	private ImageIcon iConlogin= new ImageIcon(DangNhap.class.getResource("/img/login.png"));
	private JLabel lblThongBao;
	private JPasswordField passwordField;
	private JPasswordField txtPassNew;
	private JPasswordField txtNhapLaiPassNew;
	private JLabel lblMaNV;
	private JLabel lblTenNV;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_DoiMatKhau frame = new GD_DoiMatKhau();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GD_DoiMatKhau(){
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setBounds(500, 200, 600, 400);
		getContentPane().setLayout(null);
		giaoDien();
	}
	
	void giaoDien() {
		JPanel pDangNhap = new JPanel();
		pDangNhap.setBackground(new Color(176, 224, 230));
		pDangNhap.setBounds(0, 0, 632, 435);
		getContentPane().add(pDangNhap);
		pDangNhap.setLayout(null);
		
		JLabel lblLogin = new JLabel("Mật khẩu cũ");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblLogin.setBounds(60, 156, 120, 30);
		pDangNhap.add(lblLogin);
		
		JLabel lblPassWord = new JLabel("Mật khẩu mới");
		lblPassWord.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPassWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassWord.setBounds(60, 196, 120, 30);
		pDangNhap.add(lblPassWord);
		
		txtPassOld = new JPasswordField();
		txtPassOld.setToolTipText("Nháº­p tĂªn Ä‘Äƒng nháº­p");
		//txtLogin.setText("CCH001");
		txtPassOld.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtPassOld.setBounds(230, 156, 300, 30);
		pDangNhap.add(txtPassOld);
		txtPassOld.setColumns(10);
		
		JPanel pThaoTac = new JPanel();
		pThaoTac.setBackground(new Color(152, 251, 152));
		pThaoTac.setBounds(0, 300, 600, 100);
		pDangNhap.add(pThaoTac);
		pThaoTac.setLayout(null);
		
		btnDangNhap = new JButton("Đổi mật khẩu");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matKhauCu = txtPassOld.getText();
				String matKhauMoi = txtPassNew.getText();
				String matKhauMoiNhapLai = txtNhapLaiPassNew.getText();
				String ma = lblMaNV.getText();
				
				ChuCuaHangDAO chucuahangDAO = null;
				try {
					chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
				} catch (MalformedURLException | RemoteException | NotBoundException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}
				
				ChuCuaHang chu = null;
				try {
					chu = chucuahangDAO.layThongTinChuCuaHangTheoMa("CCH001");
				} catch (RemoteException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
				ChuCuaHang cch = new ChuCuaHang(chu.getMaChuCuaHang(), chu.getTenChuCuaHang(), chu.isGioiTinh(), chu.getSoCMND(), 
						chu.getSoDienThoai(), chu.getDiaChi(), chu.getThanhPho(), chu.getNgaySinh());
				
				NhanVienDAO nhanvienDAO = null;
				try {
					nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
				} catch (MalformedURLException | RemoteException | NotBoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
				NhanVienBanHang nv = null;
				try {
					nv = nhanvienDAO.layNhanVienTheoMa(ma);
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
				NhanVienBanHang nhanVien = new NhanVienBanHang(nv.getMaNhanVien(), nv.getTenNhanVien(), nv.isGioiTinh(), nv.getSoCMND(), nv.getSoDienThoai(), nv.getDiaChi(), nv.getThanhPho(), nv.getNgaySinh(),  nv.getNgayVaoLam(), nv.isTinhTrang());
				
				TaiKhoanDAO taiKhoanDAO = null;
				try {
					taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				TaiKhoan tk = null;
				try {
					tk = taiKhoanDAO.layThongTinTaiKhoanTheoTenDangNhap(ma);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TaiKhoan taiKhoan = new TaiKhoan(tk.getTenDangNhap(), matKhauMoi, tk.getQuyen(), true, true, cch, nhanVien);
				
				if (matKhauCu.equalsIgnoreCase(tk.getMatKhau()) && matKhauMoi.equalsIgnoreCase(matKhauMoiNhapLai)) {
					boolean rs = false;
					try {
						rs = taiKhoanDAO.cpanhatTaiKhoan(taiKhoan);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(rs)
						JOptionPane.showMessageDialog(rootPane, "Đổi mật khẩu thành công");
					else
						JOptionPane.showMessageDialog(rootPane, "Đổi mật khẩu không thành công");
				} else if(!matKhauCu.equalsIgnoreCase(tk.getMatKhau()))
					JOptionPane.showMessageDialog(rootPane, "Mật khẩu cũ không chính xác");
				else 
					JOptionPane.showMessageDialog(rootPane, "Mật khẩu nhâp lại không chính xác");
				
				
				
			}
		});
		btnDangNhap.setIcon(iConDangNhap);
		btnDangNhap.setBackground(new Color(240, 248, 255));
		btnDangNhap.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnDangNhap.setBounds(360, 33, 174, 40);
		pThaoTac.add(btnDangNhap);
		
		JLabel lblThoat = new JLabel("");
		lblThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblThoat.setIcon(iConExit);
		lblThoat.setBounds(71, 26, 64, 60);
		lblThoat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pThaoTac.add(lblThoat);
		
		JLabel lblIconTK = new JLabel("");
		lblIconTK.setIcon(iConuser);
		lblIconTK.setBounds(535, 176, 40, 32);
		pDangNhap.add(lblIconTK);
		
		JLabel lblIconMK = new JLabel("");
		lblIconMK.setIcon(iConpass);
		lblIconMK.setBounds(540, 228, 32, 32);
		pDangNhap.add(lblIconMK);
		
		JLabel lblNewLabel = new JLabel("Phần mềm quản lý");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(230, 10, 345, 73);
		pDangNhap.add(lblNewLabel);
		
		JLabel lblThiTrangSspn = new JLabel("shop thời trang");
		lblThiTrangSspn.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblThiTrangSspn.setBounds(230, 63, 345, 73);
		pDangNhap.add(lblThiTrangSspn);
		
		lblThongBao = new JLabel("");
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblThongBao.setBounds(230, 127, 300, 19);
		pDangNhap.add(lblThongBao);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(211, 271, -134, 19);
		pDangNhap.add(passwordField);
		
		txtPassNew = new JPasswordField();
		txtPassNew.setToolTipText("Nháº­p máº­t kháº©u");
		txtPassNew.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtPassNew.setBounds(230, 196, 300, 30);
		pDangNhap.add(txtPassNew);
		
		JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu mới");
		lblNhpLiMt.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpLiMt.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNhpLiMt.setBounds(30, 236, 190, 30);
		pDangNhap.add(lblNhpLiMt);
		
		txtNhapLaiPassNew = new JPasswordField();
		txtNhapLaiPassNew.setToolTipText("Nháº­p máº­t kháº©u");
		txtNhapLaiPassNew.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNhapLaiPassNew.setBounds(230, 236, 300, 30);
		pDangNhap.add(txtNhapLaiPassNew);
		
		lblTenNV = new JLabel("");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenNV.setBounds(30, 40, 170, 32);
		pDangNhap.add(lblTenNV);
		
		lblMaNV = new JLabel("");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaNV.setBounds(40, 82, 170, 32);
		pDangNhap.add(lblMaNV);
		
		layThongTinNhanVien();
	}
	protected int kiemtraTenDangNhap() {
		TaiKhoanDAO taiKhoanDAO = null;
		try {
			taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String tenDangNhap = txtPassOld.getText();
		String pass = txtPassNew.getText().trim();
		System.out.println(pass);
		
		int s = 0;
		try {
			s = (int) taiKhoanDAO.kiemTraTaiKhoan(tenDangNhap, pass);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
		/*ArrayList<TaiKhoan> listTK = taiKhoanDAO.kiemTraTaiKhoan(tenDangNhap, pass);
		for(TaiKhoan tk:listTK) {
			if(tk.getTenTaiKhoan().equals(tenDN) && tk.getMatKhau().equals(matKhau)) {
				return true;
			}
		}return false;*/
		
	}

	
	
	public void layThongTinNhanVien() {
		TaiKhoanDAO taiKhoanDAO = null;
		try {
			taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		NhanVienDAO nhanvienDAO = null;
		try {
			nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
		} catch (MalformedURLException | RemoteException | NotBoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		ChuCuaHang cch = new ChuCuaHang("CCH001");
		//NhanVienBanHang nvbh = nhanvienDAO.layDanhSachNhanVienTheoTinhTrang(true);
		//NhanVienBanHang nv = new NhanVienBanHang()));
		try {
			TaiKhoan tk = taiKhoanDAO.layThongTinTaiKhoanTheoTenDangNhap("CCH001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(tk);
		NhanVienBanHang nv = null;
		try {
			nv = nhanvienDAO.layNhanVienTheoMa("CCH001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblMaNV.setText(nv.getMaNhanVien());
		lblTenNV.setText(nv.getTenNhanVien());
	}
	
}
