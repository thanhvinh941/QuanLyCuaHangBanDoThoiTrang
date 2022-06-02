package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import guiNV.GD_DoiMatKhau;

public class GDChucnangQLBanHang extends JFrame {

	private JPanel contentPane;
	private ImageIcon iconQuanLyKhachNang = new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/customer.png"));
	private ImageIcon iconQuanLyHoaDon = new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/bill.png"));
	private ImageIcon iconQuanLySanPham = new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/sanpham.png"));
	private ImageIcon iconQuanLyKho = new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/kho.png"));
	// private ImageIcon iconBaoCao = new
	// ImageIcon(TrangChu.class.getResource("/img/baocao.png"));
	private ImageIcon iconQuanLyNhanVien = new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/nhanvien.png"));
	private ImageIcon iconQuanLyThongKe = new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/thongke.png"));
	private JPanel pKhachHang;
	private JPanel pHoaDon;
	private JPanel pSanPham;
	private JPanel pKho;
	private JPanel pNhanVien;
	private JPanel pThongKe;
	private JPanel pQuanLyHoaDon;
	private JPanel pQuanLySanPham;
	private JPanel pQuanLyThongKe;
	private JPanel pQuanLyKho;
	private JPanel pQuanLyBaoCao;
	private JPanel pQuanLyNhanVien;
	private JPanel pQuanLyKhachHang;
	private JPanel pHD;
	private JPanel pTK;
	private JPanel pNV;
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
	private QuanLyBaoCao qlBC;
	private QuanLyKho qlK;
	private QuanLyNhanVien qlNV;
	private QuanLySanPham qlSP;
	private QuanLyThongKe qlTK;
	private QuanLyBanHang qlbh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDChucnangQLBanHang frame = new GDChucnangQLBanHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public GDChucnangQLBanHang() throws RemoteException {
		setResizable(false);
		setFont(new Font("Dialog", Font.BOLD, 16));
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setTitle("Phần mềm quản lý shop thời trang");
		setBounds(20, 10, 1500, 800);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_fire_50px.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		qlkh = new QuanLyKhachHang();
		
		qlBC = new QuanLyBaoCao();
		qlK = new QuanLyKho();
		qlNV = new QuanLyNhanVien();
		qlSP = new QuanLySanPham();
		qlTK = new QuanLyThongKe();
		qlbh = new QuanLyBanHang();
		qlbh.setBounds(240, 0, 1298, 839);
		contentPane.add(qlbh);
		

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
				setVisibleOfJPanel(new JPanel[] {qlbh, qlSP, qlK, qlBC, qlNV, qlTK}, false);
				
				setColorTrangThai(pKH);
				resetColorTrangThai(new JPanel[] { pHD, pSP, pK,pNV, pTK });
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setColor(pKhachHang);
				resetColor(new JPanel[] { pHoaDon, pSanPham, pKho, pNhanVien, pThongKe });

				setColorTrangThai(pKH);
				resetColorTrangThai(new JPanel[] { pHD, pSP, pK, pNV, pTK });
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
				setVisibleOfJPanel(new JPanel[] {qlkh, qlSP, qlK, qlBC, qlNV, qlTK}, false);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setColor(pHoaDon);
				resetColor(new JPanel[] { pKhachHang, pSanPham, pKho, pNhanVien, pThongKe });

				setColorTrangThai(pHD);
				resetColorTrangThai(new JPanel[] { pKH, pSP, pK, pNV, pTK });
			}
		});
		pHoaDon.setBackground(new Color(169, 169, 169));
		pHoaDon.setLayout(null);
		pHoaDon.setBounds(0, 170, 240, 60);
		pLuaChonChucNang.add(pHoaDon);

		pHD = new JPanel();
		pHD.setBackground(new Color(0, 255, 255));
		pHD.setBounds(0, 0, 10, 60);
		pHoaDon.add(pHD);
		pHD.setLayout(null);

		JLabel lblChucNangHoaDon = new JLabel("BÁN HÀNG");
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
				setVisibleOfJPanel(new JPanel[] {qlbh, qlkh, qlK, qlBC, qlNV, qlTK}, false);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setColor(pSanPham);
				resetColor(new JPanel[] { pHoaDon, pKhachHang, pKho, pNhanVien, pThongKe });

				setColorTrangThai(pSP);
				resetColorTrangThai(new JPanel[] { pHD, pKH, pK, pNV, pTK });
			}
		});
		pSanPham.setBackground(Color.WHITE);
		pSanPham.setLayout(null);
		pSanPham.setBounds(0, 230, 240, 60);
		pLuaChonChucNang.add(pSanPham);

		pSP = new JPanel();
		pSP.setEnabled(false);
		pSP.setBackground(Color.WHITE);
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
				setVisibleOfJPanel(new JPanel[] {qlbh, qlSP, qlkh, qlBC, qlNV, qlTK}, false);

				setColorTrangThai(pK);
				resetColorTrangThai(new JPanel[] { pHD, pSP, pKH, pNV, pTK });
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setColor(pKho);
				resetColor(new JPanel[] { pHoaDon, pSanPham, pKhachHang, pNhanVien, pThongKe });

				setColorTrangThai(pK);
				resetColorTrangThai(new JPanel[] { pHD, pSP, pKH, pNV, pTK });
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

		pNhanVien = new JPanel();
		pNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*pQuanLyKhachHang.setVisible(false);
				pQuanLyThongKe.setVisible(false);
				pQuanLySanPham.setVisible(false);
				pQuanLyHoaDon.setVisible(false);
				pQuanLyBaoCao.setVisible(false);
				pQuanLyKho.setVisible(false);
				pQuanLyNhanVien.setVisible(true);*/
				
				contentPane.add(qlNV);
				qlNV.setVisible(true);
				setVisibleOfJPanel(new JPanel[] {qlbh, qlSP, qlK, qlBC, qlkh, qlTK}, false);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setColor(pNhanVien);
				resetColor(new JPanel[] { pHoaDon, pSanPham, pKho, pKhachHang, pThongKe });

				setColorTrangThai(pNV);
				resetColorTrangThai(new JPanel[] { pHD, pSP, pK,pKH, pTK });
			}
		});
		pNhanVien.setBackground(Color.WHITE);
		pNhanVien.setLayout(null);
		pNhanVien.setBounds(0, 350, 240, 60);
		pLuaChonChucNang.add(pNhanVien);

		pNV = new JPanel();
		pNV.setEnabled(false);
		pNV.setBackground(Color.WHITE);
		pNV.setBounds(0, 0, 10, 59);
		pNhanVien.add(pNV);

		JLabel lblNewLabel_5 = new JLabel("NHÂN VIÊN");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(95, 10, 94, 39);
		pNhanVien.add(lblNewLabel_5);

		JLabel lblIconSP_5 = new JLabel();
		lblIconSP_5.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/nhanvien.png")));
		lblIconSP_5.setBounds(25, 10, 40, 40);
		pNhanVien.add(lblIconSP_5);

		Panel panel_4 = new Panel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)){
	                //contextmenu.add(TexetObjcet);
	                //contextmenu.show(TexetObjcet, 0, 0);
					JTextArea textArea = new JTextArea();
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

		JLabel lblNewLabel_1 = new JLabel("CHỦ CỬA HÀNG");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(95, 10, 137, 26);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_11 = new JLabel("CCH001");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(95, 46, 66, 13);
		panel_4.add(lblNewLabel_11);

		pThongKe = new JPanel();
		pThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*pQuanLyKhachHang.setVisible(false);
				pQuanLyThongKe.setVisible(true);
				pQuanLySanPham.setVisible(false);
				pQuanLyHoaDon.setVisible(false);
				pQuanLyBaoCao.setVisible(false);
				pQuanLyKho.setVisible(false);
				pQuanLyNhanVien.setVisible(false);*/
				
				contentPane.add(qlTK);
				qlTK.setVisible(true);
				setVisibleOfJPanel(new JPanel[] {qlbh, qlSP, qlK, qlBC, qlNV, qlkh}, false);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setColor(pThongKe);
				resetColor(new JPanel[] { pHoaDon, pSanPham, pKho, pNhanVien, pKhachHang });

				setColorTrangThai(pTK);
				resetColorTrangThai(new JPanel[] { pHD, pSP, pK,pNV, pKH });
			}
		});
		pThongKe.setLayout(null);
		pThongKe.setBackground(Color.WHITE);
		pThongKe.setBounds(0, 410, 240, 60);
		pLuaChonChucNang.add(pThongKe);

		pTK = new JPanel();
		pTK.setEnabled(false);
		pTK.setBackground(Color.WHITE);
		pTK.setBounds(0, 0, 10, 60);
		pThongKe.add(pTK);

		JLabel lblNewLabel_5_1 = new JLabel("THỐNG KÊ");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_1.setBounds(95, 10, 94, 39);
		pThongKe.add(lblNewLabel_5_1);

		JLabel lblIconSP_6 = new JLabel();
		lblIconSP_6.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/thongke.png")));
		lblIconSP_6.setBounds(25, 10, 40, 40);
		pThongKe.add(lblIconSP_6);
		
		JButton btnDoiMK = new JButton("Đổ mật khẩu");
		btnDoiMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.GD_DoiMatKhau gui = new gui.GD_DoiMatKhau();
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
				System.exit(0);
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

}
