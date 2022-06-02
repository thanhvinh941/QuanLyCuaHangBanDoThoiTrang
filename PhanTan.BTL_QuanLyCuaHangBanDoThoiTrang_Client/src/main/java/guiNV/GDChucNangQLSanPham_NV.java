package guiNV;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.SessionFactory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import dao.ChuCuaHangDAO;
import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import dao_imp.ChuCuaHangImp;
import dao_imp.MySessionFactory;
import dao_imp.NhanVienImp;
import dao_imp.TaiKhoanImp;
import entity.ChuCuaHang;
import entity.NhanVienBanHang;
import entity.TaiKhoan;
import gui.DangNhap;
import gui.GiaoDienChinh_ChuCuaHang;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;

public class GDChucNangQLSanPham_NV extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pKhachHang;
	private JPanel pHoaDon;
	private JPanel pSanPham;
	private JPanel pKho;
	private JPanel pQuanLyHoaDon;
	private JPanel pQuanLySanPham;
	private JPanel pQuanLyThongKe;
	private JPanel pQuanLyKho;
	private JPanel pQuanLyBaoCao;
	private JPanel pQuanLyNhanVien;
	private JPanel pQuanLyKhachHang;
	private JPanel pHD;
	private JPanel pKH;
	private JPanel pSP;
	private JPanel pK;
	private JTable table;
	private DefaultTableModel tableKHMode;
	private TableModel tablePQMode;
	private JTable tableKH;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable tableHDBH;
	private JTable tableSanPham;
	private JLabel lblHangSanXuat;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel pAnBoLocHDBH;
	private JPanel pBoLocHDBH;
	private JTable tableNhanVien;
	private JTable tableHDKho;
	private JPanel pBoLocHDKho;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private QuanLyKhachHang qlkh;

	private QuanLyKho qlK;

	private QuanLySanPham qlSP;

	private QuanLyBanHang qlbh;

	SessionFactory sessionFactory = new MySessionFactory().getSessionFactory();
	private JLabel lblMaNV;
	private JLabel lblTenNV;
	private JLabel lblTenNVBH;
	private JLabel lblMaNVBH;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDChucnangQLBanHang_NV frame = new GDChucnangQLBanHang_NV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GDChucNangQLSanPham_NV() {
		setResizable(false);
		setFont(new Font("Dialog", Font.BOLD, 16));
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setTitle("Phần mềm quản lý thời trang SSPN12");
		setBounds(20, 10, 1500, 800);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_fire_50px.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		qlkh = new QuanLyKhachHang();
		

		qlK = new QuanLyKho();

		try {
			qlSP = new QuanLySanPham();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		qlbh = new QuanLyBanHang();
		qlSP.setBounds(240, 0, 1298, 839);
		contentPane.add(qlSP);

		JPanel pLuaChonChucNang = new JPanel();
		pLuaChonChucNang.setBackground(Color.WHITE);
		pLuaChonChucNang.setBounds(0, 0, 240, 839);
		contentPane.add(pLuaChonChucNang);
		pLuaChonChucNang.setLayout(null);

		pKhachHang = new JPanel();
		pKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*pQuanLyKhachHang.setVisible(true);
				pQuanLyThongKe.setVisible(false);
				pQuanLySanPham.setVisible(false);
				pQuanLyHoaDon.setVisible(false);
				pQuanLyBaoCao.setVisible(false);
				pQuanLyKho.setVisible(false);
				pQuanLyNhanVien.setVisible(false);*/

				contentPane.add(qlkh);
				qlkh.setVisible(true);
				setVisibleOfJPanel(new JPanel[] {qlbh, qlSP, qlK}, false);
				
				setColorTrangThai(pKH);
				resetColorTrangThai(new JPanel[] { pHD, pSP, pK });
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setColor(pKhachHang);
				resetColor(new JPanel[] { pHoaDon, pSanPham, pKho});

				setColorTrangThai(pKH);
				resetColorTrangThai(new JPanel[] { pHD, pSP, pK });
			}
		});
		pKhachHang.setBackground(Color.WHITE);
		pKhachHang.setBounds(0, 110, 240, 60);
		pLuaChonChucNang.add(pKhachHang);
		pKhachHang.setLayout(null);

		pKH = new JPanel();
		pKH.setBackground(Color.WHITE);
		pKH.setBounds(0, 0, 10, 60);
		pKhachHang.add(pKH);

		JLabel lblKhachHang = new JLabel("KHÁCH HÀNG");
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKhachHang.setBounds(100, 10, 94, 39);
		pKhachHang.add(lblKhachHang);

		JLabel lblIconSP_2 = new JLabel();
		lblIconSP_2.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/customer.png")));
		lblIconSP_2.setBounds(25, 10, 40, 40);
		pKhachHang.add(lblIconSP_2);

		pHoaDon = new JPanel();
		pHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*pQuanLyKhachHang.setVisible(false);
				pQuanLyThongKe.setVisible(false);
				pQuanLySanPham.setVisible(false);
				pQuanLyHoaDon.setVisible(true);
				pQuanLyBaoCao.setVisible(false);
				pQuanLyKho.setVisible(false);
				pQuanLyNhanVien.setVisible(false);*/
				
				contentPane.add(qlbh);
				qlbh.setVisible(true);
				setVisibleOfJPanel(new JPanel[] {qlkh, qlSP, qlK}, false);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setColor(pHoaDon);
				resetColor(new JPanel[] { pKhachHang, pSanPham, pKho });

				setColorTrangThai(pHD);
				resetColorTrangThai(new JPanel[] { pKH, pSP, pK});
			}
		});
		pHoaDon.setBackground(Color.WHITE);
		pHoaDon.setLayout(null);
		pHoaDon.setBounds(0, 170, 240, 60);
		pLuaChonChucNang.add(pHoaDon);

		pHD = new JPanel();
		pHD.setBackground(Color.WHITE);
		pHD.setBounds(0, 0, 10, 60);
		pHoaDon.add(pHD);
		pHD.setLayout(null);

		JLabel lblChucNangHoaDon = new JLabel("HÓA ĐƠN");
		lblChucNangHoaDon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChucNangHoaDon.setBounds(99, 10, 94, 39);
		pHoaDon.add(lblChucNangHoaDon);

		JLabel lblIconSP_1 = new JLabel();
		lblIconSP_1.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/bill.png")));
		lblIconSP_1.setBounds(25, 10, 40, 40);
		pHoaDon.add(lblIconSP_1);

		pSanPham = new JPanel();
		pSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*pQuanLyKhachHang.setVisible(false);
				pQuanLyThongKe.setVisible(false);
				pQuanLySanPham.setVisible(true);
				pQuanLyHoaDon.setVisible(false);
				pQuanLyBaoCao.setVisible(false);
				pQuanLyKho.setVisible(false);
				pQuanLyNhanVien.setVisible(false);*/
				
				contentPane.add(qlSP);
				qlSP.setVisible(true);
				setVisibleOfJPanel(new JPanel[] {qlbh, qlkh, qlK}, false);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setColor(pSanPham);
				resetColor(new JPanel[] { pHoaDon, pKhachHang, pKho });

				setColorTrangThai(pSP);
				resetColorTrangThai(new JPanel[] { pHD, pKH, pK });
			}
		});
		pSanPham.setBackground(new Color(169, 169, 169));
		pSanPham.setLayout(null);
		pSanPham.setBounds(0, 230, 240, 60);
		pLuaChonChucNang.add(pSanPham);

		pSP = new JPanel();
		pSP.setEnabled(false);
		pSP.setBackground(new Color(0, 255, 255));
		pSP.setBounds(0, 0, 10, 59);
		pSanPham.add(pSP);

		JLabel lblNewLabel_2 = new JLabel("SẢN PHẨM");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(97, 10, 94, 39);
		pSanPham.add(lblNewLabel_2);

		JLabel lblIconSP = new JLabel();
		lblIconSP.setBounds(25, 10, 40, 40);
		lblIconSP.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/sanpham.png")));
		lblIconSP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pSanPham.add(lblIconSP);

		pKho = new JPanel();
		pKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*pQuanLyKhachHang.setVisible(false);
				pQuanLyThongKe.setVisible(false);
				pQuanLySanPham.setVisible(false);
				pQuanLyHoaDon.setVisible(false);
				pQuanLyBaoCao.setVisible(false);
				pQuanLyKho.setVisible(true);
				pQuanLyNhanVien.setVisible(false);*/
				
				contentPane.add(qlK);
				qlK.setVisible(true);
				setVisibleOfJPanel(new JPanel[] {qlbh, qlSP, qlkh}, false);

				setColorTrangThai(pK);
				resetColorTrangThai(new JPanel[] { pHD, pSP, pKH});
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setColor(pKho);
				resetColor(new JPanel[] { pHoaDon, pSanPham, pKhachHang});

				setColorTrangThai(pK);
				resetColorTrangThai(new JPanel[] { pHD, pSP, pKH});
			}
		});
		pKho.setBackground(Color.WHITE);
		pKho.setLayout(null);
		pKho.setBounds(0, 290, 240, 60);
		pLuaChonChucNang.add(pKho);

		pK = new JPanel();
		pK.setEnabled(false);
		pK.setBackground(Color.WHITE);
		pK.setBounds(0, 0, 10, 59);
		pKho.add(pK);

		JLabel lblNewLabel_3 = new JLabel("KHO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(100, 10, 94, 39);
		pKho.add(lblNewLabel_3);

		JLabel lblIconSP_3 = new JLabel();
		lblIconSP_3.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/kho.png")));
		lblIconSP_3.setBounds(25, 10, 40, 40);
		pKho.add(lblIconSP_3);

		Panel panel_4 = new Panel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)){
	                //contextmenu.add(TexetObjcet);
	                //contextmenu.show(TexetObjcet, 0, 0);
					JTextArea textArea = new JTextArea();
					//DefaultContextMenu.addDefaultContextMenu(textArea);
	            }
			}
		});
		panel_4.setBackground(Color.CYAN);
		panel_4.setBounds(0, 0, 242, 83);
		pLuaChonChucNang.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/user2.png")));
		lblNewLabel.setBounds(25, 10, 60, 60);
		panel_4.add(lblNewLabel);

		lblTenNVBH = new JLabel("Chủ cửa hàng");
		lblTenNVBH.setForeground(Color.BLACK);
		lblTenNVBH.setBackground(Color.CYAN);
		lblTenNVBH.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTenNVBH.setBounds(95, 10, 137, 26);
		panel_4.add(lblTenNVBH);
		
		lblMaNVBH = new JLabel("CCH001");
		lblMaNVBH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaNVBH.setBounds(95, 46, 66, 13);
		panel_4.add(lblMaNVBH);
		
		layThongTinNhanVien();
		
		JButton btnDoiMK = new JButton("Đổi mật khẩu");
		btnDoiMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GD_DoiMatKhau gui = new GD_DoiMatKhau();
				gui.setVisible(true);
				gui.setLocationRelativeTo(null);
				gui.setAlwaysOnTop(true);
				gui.setResizable(false);
			}
		});
		btnDoiMK.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnDoiMK.setBackground(Color.WHITE);
		btnDoiMK.setBounds(0, 672, 240, 68);
		pLuaChonChucNang.add(btnDoiMK);
		
		JButton btnNewButton = new JButton("THOÁT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChuCuaHang chu;
				try {



					NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
					ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
					
					chu = chucuahangDAO.layThongTinChuCuaHangTheoMa("CCH001");
					ChuCuaHang cch = new ChuCuaHang(chu.getMaChuCuaHang(), chu.getTenChuCuaHang(), chu.isGioiTinh(), chu.getSoCMND(), 
							chu.getSoDienThoai(), chu.getDiaChi(), chu.getThanhPho(), chu.getNgaySinh());
					//NhanVienBanHang nvbh = nhanvienDAO.layDanhSachNhanVienTheoTinhTrang(true);
					//NhanVienBanHang nv = new NhanVienBanHang()));
					String ma = lblMaNVBH.getText();
					NhanVienBanHang nv = nhanVienDAO.layNhanVienTheoMa(ma);
					//nhanvienDAO.capnhatTinhTrangNhanVien(ma);
					NhanVienBanHang nhanVien = new NhanVienBanHang(nv.getMaNhanVien(), nv.getTenNhanVien(), nv.isGioiTinh(), nv.getSoCMND(), nv.getSoDienThoai(), nv.getDiaChi(), nv.getThanhPho(), nv.getNgaySinh(),  nv.getNgayVaoLam(), nv.isTinhTrang());
					TaiKhoanDAO taikhoanDAO = new TaiKhoanImp(sessionFactory);
					TaiKhoan tk = taikhoanDAO.layThongTinTaiKhoanTheoTenDangNhap(ma);
					TaiKhoan taiKhoan = new TaiKhoan(tk.getTenDangNhap(), tk.getMatKhau(), tk.getQuyen(), true, false, cch, nhanVien);
					boolean rs = taikhoanDAO.cpanhatTaiKhoan(taiKhoan);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				System.exit(0);
				DangNhap gui = new DangNhap();
				gui.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_shutdown_60px.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton.setBounds(0, 750, 240, 68);
		pLuaChonChucNang.add(btnNewButton);
		

	}

	public void setColor(JPanel panel) {
		panel.setBackground(new Color(169, 169, 169));
	}

	public void resetColor(JPanel[] panel) {
		for (int i = 0; i < panel.length; i++) {
			panel[i].setBackground(new Color(255, 255, 255));
		}

	}

	public void setColorTrangThai(JPanel panel) {
		panel.setBackground(new Color(0, 255, 255));
	}

	public void resetColorTrangThai(JPanel[] panel) {
		for (int i = 0; i < panel.length; i++) {
			panel[i].setBackground(new Color(255, 255, 255));
		}

	}
	
	public void setVisibleOfJPanel(JPanel[] panel, boolean rs) {
		for (int i = 0; i < panel.length; i++) {
			panel[i].setVisible(rs);
		}
		
	}
	
	public void layThongTinNhanVien() {
		ChuCuaHang cch = new ChuCuaHang("CCH001");
		//NhanVienBanHang nvbh = nhanvienDAO.layDanhSachNhanVienTheoTinhTrang(true);
		//NhanVienBanHang nv = new NhanVienBanHang()));
		TaiKhoanDAO taikhoanDAO;
		try {
			taikhoanDAO = new TaiKhoanImp(sessionFactory);
			TaiKhoan tk = taikhoanDAO.layThongTinTaiKhoanTheoTrangThai(true);
			//System.out.println(tk);
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			NhanVienBanHang nv = nhanVienDAO.layNhanVienTheoMa(tk.getNhanVienBanHang().getMaNhanVien());
			
			lblMaNVBH.setText(nv.getMaNhanVien());
			lblTenNVBH.setText(nv.getTenNhanVien());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
