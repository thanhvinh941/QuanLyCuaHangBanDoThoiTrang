package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entity.ChuCuaHang;
import entity.NhanVienBanHang;
import entity.TaiKhoan;
import guiNV.GiaoDienChinh_NhanVienBanHang;
import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import javax.swing.JPasswordField;

public class DangNhap extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtLogin;
	private JButton btnDangNhap;
	private ImageIcon iConDangNhap = new ImageIcon(DangNhap.class.getResource("/img/enter.png"));
	private ImageIcon iConExit = new ImageIcon(DangNhap.class.getResource("/img/exit_login.png"));
	private ImageIcon iConuser = new ImageIcon(DangNhap.class.getResource("/img/user.png"));
	private ImageIcon iConpass = new ImageIcon(DangNhap.class.getResource("/img/padlock.png"));
	private ImageIcon iConlogin = new ImageIcon(DangNhap.class.getResource("/img/login.png"));

	private JLabel lblThongBao;
	private JPasswordField passwordField;
	private JPasswordField txtPassword;

	public DangNhap() {
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
		pDangNhap.setBackground(new Color(154, 205, 50));
		pDangNhap.setBounds(0, 0, 632, 400);
		getContentPane().add(pDangNhap);
		pDangNhap.setLayout(null);

		JLabel lblLogin = new JLabel("T\u00EAn T\u00E0i Kho\u1EA3n");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblLogin.setBounds(60, 180, 120, 30);
		pDangNhap.add(lblLogin);

		JLabel lblPassWord = new JLabel("M\u1EADt Kh\u1EA9u");
		lblPassWord.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPassWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassWord.setBounds(60, 230, 120, 30);
		pDangNhap.add(lblPassWord);

		txtLogin = new JTextField();
		txtLogin.setText("CCH001");
		txtLogin.setToolTipText("Nhập tên đăng nhập");
		txtLogin.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtLogin.setBounds(230, 180, 300, 30);
		pDangNhap.add(txtLogin);
		txtLogin.setColumns(10);

		JPanel pThaoTac = new JPanel();
		pThaoTac.setBackground(new Color(0, 255, 255));
		pThaoTac.setBounds(0, 300, 600, 100);
		pDangNhap.add(pThaoTac);
		pThaoTac.setLayout(null);

		btnDangNhap = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienDAO nhanvienDAO = null;
				TaiKhoanDAO taiKhoanDAO = null;
				try {
					nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
					if (kiemtraTenDangNhap() == 0) {
						if (txtLogin.getText().length() == 6) {
							GiaoDienChinh_ChuCuaHang gdChinhChuCuaHang = new GiaoDienChinh_ChuCuaHang();
							gdChinhChuCuaHang.setVisible(true);
						} else if (txtLogin.getText().length() == 5) {
							if (demTaiKhoanDaDangNhap() < 1) {
								ChuCuaHang cch = new ChuCuaHang("CCH001");
								NhanVienBanHang nv = new NhanVienBanHang(txtLogin.getText());
								TaiKhoan tk = null;
								NhanVienBanHang nvbh = null;
								try {
									tk = taiKhoanDAO.layThongTinTaiKhoanTheoTenDangNhap(txtLogin.getText());
									TaiKhoan taiKhoan = new TaiKhoan(tk.getTenDangNhap(), tk.getMatKhau(),
											tk.getQuyen(), true, true, cch, nv);
									taiKhoanDAO.cpanhatTaiKhoan(taiKhoan);
									nvbh = nhanvienDAO.layNhanVienTheoMa(txtLogin.getText());
									NhanVienBanHang nhanVien = new NhanVienBanHang(nvbh.getMaNhanVien(),
											nvbh.getTenNhanVien(), nvbh.isGioiTinh(), nvbh.getSoCMND(),
											nvbh.getSoDienThoai(), nvbh.getDiaChi(), nvbh.getThanhPho(),
											nvbh.getNgaySinh(), nvbh.getNgayVaoLam(), true);
									nhanvienDAO.capNhatNhanVien(nhanVien);
								} catch (RemoteException e2) {
									e2.printStackTrace();
								}
								GiaoDienChinh_NhanVienBanHang gui = new GiaoDienChinh_NhanVienBanHang();
								gui.setVisible(true);
								
								System.out.println(demTaiKhoanDaDangNhap());
							} else if (demTaiKhoanDaDangNhap() >= 1)
								lblThongBao.setText("Đã có tài khoản đăng nhập vui lòng thử lại sau");
						}

					} else if (kiemtraTenDangNhap() == -1) {
						lblThongBao.setText("Sai tên đăng nhập");
						txtLogin.selectAll();
						txtLogin.requestFocus();
					} else
						lblThongBao.setText("Sai mật khẩu");
				} catch (MalformedURLException | RemoteException | NotBoundException e2) {
					e2.printStackTrace();
					lblThongBao.setText("Vui lòng mở server");
					txtPassword.selectAll();
					txtPassword.requestFocus();
				}
			}
		});
		btnDangNhap.setIcon(iConDangNhap);
		btnDangNhap.setBackground(new Color(240, 248, 255));
		btnDangNhap.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnDangNhap.setBounds(384, 33, 150, 40);
		pThaoTac.add(btnDangNhap);

		JLabel lblThoat = new JLabel("");
		lblThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
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

		JLabel lblIconLogin = new JLabel("");
		lblIconLogin.setIcon(iConlogin);
		lblIconLogin.setBounds(60, 10, 124, 124);
		pDangNhap.add(lblIconLogin);

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
		lblThongBao.setBounds(230, 138, 300, 30);
		pDangNhap.add(lblThongBao);

		passwordField = new JPasswordField();
		passwordField.setBounds(211, 271, -134, 19);
		pDangNhap.add(passwordField);

		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Nhập mật khẩu");
		txtPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtPassword.setBounds(230, 230, 300, 30);
		pDangNhap.add(txtPassword);
		txtPassword.setText("987654");

	}

	protected int kiemtraTenDangNhap() {
		String tenDangNhap = txtLogin.getText();
		@SuppressWarnings("deprecation")
		String pass = txtPassword.getText().trim();
		TaiKhoanDAO taiKhoanDAO = null;
		int s = 0;
		try {
			taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
			s = taiKhoanDAO.kiemTraTaiKhoan(tenDangNhap, pass);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		return s;
	}

	public int demTaiKhoanDaDangNhap() {
		int i =0;
		try {
			TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
			List<TaiKhoan> listTK = taiKhoanDAO.latTatCaThongTinTaiKhoan();
			for (TaiKhoan taiKhoan : listTK) {
				if (taiKhoan.isTinhTrang())
					i++;
				else 
					continue;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public static void main(String[] args) {
		new DangNhap().setVisible(true);

		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
	}
}
