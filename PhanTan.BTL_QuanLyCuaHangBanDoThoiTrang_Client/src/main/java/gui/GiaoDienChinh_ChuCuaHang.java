package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JTextField;


import java.awt.Toolkit;

public class GiaoDienChinh_ChuCuaHang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4256929015811790744L;
	private JPanel contentPane;
//	private ImageIcon iconQuanLyKhachNang = new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/customer.png"));
//	private ImageIcon iconQuanLyHoaDon = new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/bill.png"));
//	private ImageIcon iconQuanLySanPham = new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/sanpham.png"));
//	private ImageIcon iconQuanLyKho = new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/kho.png"));
	// private ImageIcon iconBaoCao = new
	// ImageIcon(TrangChu.class.getResource("/img/baocao.png"));
//	private ImageIcon iconQuanLyNhanVien = new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/nhanvien.png"));
//	private ImageIcon iconQuanLyThongKe = new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/thongke.png"));
	private JPanel pKhachHang;
	private JPanel pHoaDon;
	private JPanel pSanPham;
	private JPanel pKho;
	private JPanel pNhanVien;
	private JPanel pThongKe;
//	private JPanel pQuanLyHoaDon;
//	private JPanel pQuanLySanPham;
//	private JPanel pQuanLyThongKe;
//	private JPanel pQuanLyKho;
//	private JPanel pQuanLyBaoCao;
//	private JPanel pQuanLyNhanVien;
//	private JPanel pQuanLyKhachHang;
	private JPanel pHD;
	private JPanel pTK;
	private JPanel pNV;
	private JPanel pKH;
	private JPanel pSP;
	private JPanel pK;
//	private JTable table;
//	private DefaultTableModel tableKHMode;
//	private TableModel tablePQMode;
//	private JTable tableKH;
//	private JTable table_1;
//	private JTable table_2;
//	private JTable table_3;
//	private JScrollPane scrollPane;
//	private JScrollPane scrollPane_1;
//	private JTable tableHDBH;
//	private JTable tableSanPham;
//	private JLabel lblHangSanXuat;
//	private JTextField textField;
//	private JTextField textField_1;
//	private JPanel pAnBoLocHDBH;
//	private JPanel pBoLocHDBH;
//	private JTable tableNhanVien;
//	private JTable tableHDKho;
//	private JPanel pBoLocHDKho;
//	private JTextField textField_2;
//	private JTextField textField_3;
//	private JTextField textField_4;
//	private JTextField textField_5;
//	private JTextField textField_6;
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
					GiaoDienChinh_ChuCuaHang frame = new GiaoDienChinh_ChuCuaHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				SecurityManager securityManager = System.getSecurityManager();
				if(securityManager == null)
				{
					System.setProperty("java.security.policy", "policy/policy.policy");
					System.setSecurityManager(new SecurityManager());
				}
			}
		});
	}
	
	public void hienthiGiaoDienQLBanDau(JPanel p) {
		p.setBounds(240, 0, 1298, 839);
		contentPane.add(p);
	}
	
	public void hienthiGDQL(JPanel p) {
		p.setBackground(new Color(169, 169, 169));
		
	}

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public GiaoDienChinh_ChuCuaHang() throws RemoteException {
		setResizable(false);
		setFont(new Font("Dialog", Font.BOLD, 16));
		setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setTitle("Phần mềm quản lý shop thời trang");
		setBounds(20, 10, 1200, 780);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_fire_50px.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		qlkh = new QuanLyKhachHang();
		//qlkh.setBounds(240, 0, 1298, 839);
		//contentPane.add(qlkh);
		qlBC = new QuanLyBaoCao();
		qlK = new QuanLyKho();
		qlNV = new QuanLyNhanVien();
		qlSP = new QuanLySanPham();
		qlTK = new QuanLyThongKe();
		qlbh = new QuanLyBanHang();
		
		hienthiGiaoDienQLBanDau(qlkh);

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
		pKhachHang.setBackground(new Color(169, 169, 169));
		pKhachHang.setBounds(0, 110, 240, 60);
		pLuaChonChucNang.add(pKhachHang);
		pKhachHang.setLayout(null);

		pKH = new JPanel();
		pKH.setBackground(new Color(0, 255, 255));
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
		pHoaDon.setBackground(Color.WHITE);
		pHoaDon.setLayout(null);
		pHoaDon.setBounds(0, 170, 240, 60);
		pLuaChonChucNang.add(pHoaDon);

		pHD = new JPanel();
		pHD.setBackground(Color.white);
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
				resetColorTrangThai(new JPanel[] { pHD, pKH, pK,  pNV, pTK });
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

		JLabel lblNewLabel_2 = new JLabel("SẢN PHẨM\r\n");
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
				resetColorTrangThai(new JPanel[] { pHD, pSP, pK, pKH, pTK });
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
		lblNewLabel.setBounds(15, 10, 60, 60);
		panel_4.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CHỦ CỬA HÀNG");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(85, 10, 147, 26);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_11 = new JLabel("CCH001");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
				resetColorTrangThai(new JPanel[] { pHD, pSP, pK, pNV, pKH });
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
		
		JButton btnDoiMK = new JButton("Đổi mật khẩu");
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 1538, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JLabel lblNewLabel_7 = new JLabel("Cá»¬A HĂ€NG BĂ�N QUáº¦N Ă�O SSPN12");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(60, 0, 354, 50);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_fire_50px.png")));
		lblNewLabel_8.setBounds(10, 0, 50, 50);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_delete_32px.png")));
		lblNewLabel_6.setBounds(1490, 10, 35, 35);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblMinimize = new JLabel("");
		lblMinimize.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_horizontal_line_32px.png")));
		lblMinimize.setBounds(1445, 10, 35, 35);
		panel_1.add(lblMinimize);
		
		// =========================================================================================================================================
		// Chá»©c nÄƒng quáº£n lĂ½ á»©ng vá»›i má»¥c Ä‘Ă£ chá»�n

		
		// -----------------------------------------------------------------------------------------------------------------------------------------
		// Chá»©c nÄƒng quáº£n lĂ½ hĂ³a Ä‘Æ¡n
		// ------------------------------------------------------------------------------------------------------------------------------------------
		
		
		/*pQuanLyHoaDon = new JPanel();
		pQuanLyHoaDon.setLayout(null);
		pQuanLyHoaDon.setBackground(new Color(255, 255, 255));
		pQuanLyHoaDon.setBounds(240, 0, 1260, 763);
		contentPane.add(pQuanLyHoaDon);

		JLabel lblQuanLyBanHang = new JLabel("Quáº£n lĂ½ bĂ¡n hĂ ng");
		lblQuanLyBanHang.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQuanLyBanHang.setBounds(20, 21, 358, 60);
		pQuanLyHoaDon.add(lblQuanLyBanHang);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 495, 790, 236);
		pQuanLyHoaDon.add(scrollPane_2);

		JTable tableCTHDBanHang = new JTable();
		scrollPane_2.setViewportView(tableCTHDBanHang);
		tableCTHDBanHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableCTHDBanHang.setBackground(Color.WHITE);
		tableCTHDBanHang
				.setModel(new DefaultTableModel(
						new Object[][] {
								{ 1, "SP007", "Ă�o thá»ƒ thao MU", "XXL", "Ä�á»�", "Ă�o thá»ƒ thao", 1, 95000, 95000,
										"mua má»›i" },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null }, },
						new String[] { "STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
								"K\u00EDch th\u01B0\u1EDBc", "M\u00E0u", "Lo\u1EA1i", "S\u1ED1 l\u01B0\u1EE3ng", "GiĂ¡",
								"Th\u00E0nh ti\u1EC1n", "Ghi ch\u00FA" }));

		JLabel lblNewLabel_12 = new JLabel("Báº£ng hĂ³a Ä‘Æ¡n");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_12.setBounds(20, 110, 250, 34);
		pQuanLyHoaDon.add(lblNewLabel_12);

		JLabel lblNewLabel_12_1 = new JLabel("Báº£ng chi tiáº¿t hĂ³a Ä‘Æ¡n");
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_12_1.setBounds(20, 451, 300, 34);
		pQuanLyHoaDon.add(lblNewLabel_12_1);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(20, 160, 790, 240);
		pQuanLyHoaDon.add(scrollPane_3);

		tableHDBH = new JTable();
		tableHDBH.setModel(new DefaultTableModel(
				new Object[][] { { 1, "HD001", "Nguyá»…n VÄƒn A", "Nguyá»…n VÄƒn B", "29/9/2021", 95000, "Mua má»›i" },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "STT", "M\u00E3 h\u00F3a \u0111\u01A1n", "Kh\u00E1ch h\u00E0ng", "Nh\u00E2n vi\u00EAn",
						"Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n", "T\u1ED5ng ti\u1EC1n", "Ghi ch\u00FA" }));
		scrollPane_3.setViewportView(tableHDBH);
		tableHDBH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableHDBH.setBackground(Color.WHITE);

		/*
		 * pAnBoLocHDBH = new JPanel(); pAnBoLocHDBH.setBackground(Color.WHITE);
		 * pAnBoLocHDBH.setBounds(907, 430, 300, 301); pQuanLyHoaDon.add(pAnBoLocHDBH);
		 * pAnBoLocHDBH.setLayout(null);
		 */

		/*pBoLocHDBH = new JPanel();
		pBoLocHDBH.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pBoLocHDBH.setBackground(Color.WHITE);
		pBoLocHDBH.setBounds(907, 430, 300, 301);
		pQuanLyHoaDon.add(pBoLocHDBH);
		pBoLocHDBH.setLayout(null);

		JLabel lblNgayLapHoaDon = new JLabel("NgĂ y láº­p hĂ³a Ä‘Æ¡n");
		lblNgayLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayLapHoaDon.setBounds(10, 20, 125, 35);
		pBoLocHDBH.add(lblNgayLapHoaDon);

		// Combobox tĂªn nhĂ¢n nháº­p hĂ³a Ä‘Æ¡n

		JLabel lblTenNhanVien = new JLabel("TĂªn nhĂ¢n viĂªn");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNhanVien.setBounds(10, 75, 125, 35);
		pBoLocHDBH.add(lblTenNhanVien);

		JComboBox cboTenNhanVien = new JComboBox();
		cboTenNhanVien.setModel(new DefaultComboBoxModel(new String[] { "Nguyá»…n VÄƒn A", "Nguyá»…n VÄƒn B" }));
		cboTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboTenNhanVien.setBounds(149, 75, 140, 35);
		pBoLocHDBH.add(cboTenNhanVien);

		JLabel lblSinThoi = new JLabel("Sá»‘ Ä‘iá»‡n thoáº¡i");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi.setBounds(10, 130, 125, 35);
		pBoLocHDBH.add(lblSinThoi);

		textField_4 = new JTextField();
		textField_4.setBounds(149, 130, 140, 35);
		pBoLocHDBH.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblSCmnd = new JLabel("Sá»‘ CMND");
		lblSCmnd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSCmnd.setBounds(10, 185, 125, 35);
		pBoLocHDBH.add(lblSCmnd);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(149, 185, 140, 35);
		pBoLocHDBH.add(textField_5);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(145, 20, 140, 35);
		pBoLocHDBH.add(dateChooser_1);

		JLabel lblMHan = new JLabel("MĂ£ hĂ³a Ä‘Æ¡n");
		lblMHan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMHan.setBounds(10, 240, 125, 35);
		pBoLocHDBH.add(lblMHan);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "HD001" }));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2.setBounds(149, 240, 140, 35);
		pBoLocHDBH.add(comboBox_2);
		
		JButton btnNewButton_2 = new JButton("ThĂªm hĂ³a Ä‘Æ¡n");
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8_add_40px.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(907, 240, 240, 60);
		pQuanLyHoaDon.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Cáº­p nháº­t hĂ³a Ä‘Æ¡n");
		btnNewButton_2_1.setBackground(Color.CYAN);
		btnNewButton_2_1.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8_update_40px_2.png")));
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2_1.setBounds(907, 320, 240, 60);
		pQuanLyHoaDon.add(btnNewButton_2_1);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("TĂ¬m kiáº¿m theo tĂªn");
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setBounds(907, 160, 180, 60);
		pQuanLyHoaDon.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8_search_40px.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(1087, 160, 60, 60);
		pQuanLyHoaDon.add(btnNewButton_3);*/

		// ----------------------------------------------------------------------------------------------------------------------------------------------
		// Chá»©c nÄƒng quáº£n lĂ½ khĂ¡ch hĂ ng
		
		/*pQuanLyKhachHang = new JPanel();
		pQuanLyKhachHang.setBackground(new Color(255, 255, 255));
		pQuanLyKhachHang.setBounds(240, 0, 1260, 763);
		contentPane.add(pQuanLyKhachHang);
		pQuanLyKhachHang.setLayout(null);

		JLabel lblQuanLyKhachHang = new JLabel("Quáº£n lĂ½ khĂ¡ch hĂ ng");
		lblQuanLyKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQuanLyKhachHang.setBounds(20, 21, 358, 60);
		pQuanLyKhachHang.add(lblQuanLyKhachHang);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 345, 1200, 376);
		pQuanLyKhachHang.add(scrollPane_1);

		table_3 = new JTable();
		scrollPane_1.setViewportView(table_3);
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_3.setBackground(Color.WHITE);
		table_3.setModel(new DefaultTableModel(
				new Object[][] {
						{ new Integer(1), "KH001", "Nguy\u1EC5n V\u0103n A", "Nam", new Integer(123456789),
								new Integer(123456789), "S\u1ED1 9, \u0111\u01B0\u1EDDng L\u00EA Ninh",
								"H\u00E0 N\u1ED9i", "29/08/2000" },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "STT", "M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng",
						"Gi\u1EDBi t\u00EDnh", "S\u1ED1 CMND", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i",
						"\u0110\u1ECBa ch\u1EC9", "Th\u00E0nh ph\u1ED1", "Ng\u00E0y sinh" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, Double.class,
					Double.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		// ThĂªm má»™t khĂ¡ch hĂ ng
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(224, 255, 255));
		panel_2.setBounds(20, 182, 240, 60);
		pQuanLyKhachHang.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(TrangChu.class.getResource("/img/themKH.png")));
		lblNewLabel_7.setBounds(10, 10, 40, 40);
		panel_2.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("ThĂªm khĂ¡ch hĂ ng");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(72, 10, 139, 40);
		panel_2.add(lblNewLabel_8);

		// Cáº­p nháº­t thĂ´ng tin khĂ¡ch hĂ ng
		JPanel pCapNhatKH = new JPanel();
		pCapNhatKH.setLayout(null);
		pCapNhatKH.setBackground(new Color(224, 255, 255));
		pCapNhatKH.setBounds(20, 260, 240, 60);
		pQuanLyKhachHang.add(pCapNhatKH);

		JLabel lblIconCapNhatKH = new JLabel("New label");
		lblIconCapNhatKH.setIcon(new ImageIcon(TrangChu.class.getResource("/img/updateKH.png")));
		lblIconCapNhatKH.setBounds(10, 10, 40, 40);
		pCapNhatKH.add(lblIconCapNhatKH);

		JLabel lblCapNhatKH = new JLabel("Cáº­p nháº­t khĂ¡ch hĂ ng");
		lblCapNhatKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCapNhatKH.setBounds(72, 10, 158, 40);
		pCapNhatKH.add(lblCapNhatKH);

		// Bá»™ lá»�c tĂ¬m kiáº¿m khĂ¡ch hĂ ng
		JPanel pBoLocTKKH = new JPanel();
		pBoLocTKKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		pBoLocTKKH.setLayout(null);
		pBoLocTKKH.setBackground(new Color(224, 255, 255));
		pBoLocTKKH.setBounds(20, 110, 240, 60);
		pQuanLyKhachHang.add(pBoLocTKKH);

		// Bá»™ lá»�c Ä‘á»ƒ tĂ¬m kiáº¿m thĂ´ng tin khĂ¡ch hĂ ng

		// Icon bá»™ lá»�c
		JLabel lblNewLabel_7_2 = new JLabel("New label");
		lblNewLabel_7_2.setIcon(new ImageIcon(TrangChu.class.getResource("/img/boLoc.png")));
		lblNewLabel_7_2.setBounds(10, 10, 40, 40);
		pBoLocTKKH.add(lblNewLabel_7_2);

		// NhĂ£n bá»™ lá»�c
		JLabel lblNewLabel_9 = new JLabel("Bá»™ lá»�c tĂ¬m kiáº¿m");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(73, 10, 157, 40);
		pBoLocTKKH.add(lblNewLabel_9);

		JPanel pBoLocKH = new JPanel();
		pBoLocKH.setBackground(new Color(255, 255, 255));
		pBoLocKH.setBounds(311, 110, 910, 166);
		pQuanLyKhachHang.add(pBoLocKH);
		pBoLocKH.setLayout(null);

		// Combobox nÄƒm sinh cá»§a khĂ¡ch hĂ ng

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1980", "1981", "1982", "1983", "1984", "1985" }));
		comboBox.setBounds(99, 10, 120, 35);
		pBoLocKH.add(comboBox);

		JLabel lblNewLabel_10 = new JLabel("NÄƒm sinh");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setBounds(10, 10, 79, 35);
		pBoLocKH.add(lblNewLabel_10);

		// Combobox thĂ nh phá»‘ mĂ  khĂ¡ch hĂ ng sá»‘ng

		JLabel lblNewLabel_10_1 = new JLabel("ThĂ nh phá»‘");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10_1.setBounds(247, 10, 79, 35);
		pBoLocKH.add(lblNewLabel_10_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Tp.HCM", "HĂ  Ná»™i", "TĂ¢y Ninh" }));
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox_1.setBounds(345, 10, 120, 35);
		pBoLocKH.add(comboBox_1);

		// Combobox giá»›i tĂ­nh khĂ¡ch hĂ ng

		JLabel lblNewLabel_10_1_1 = new JLabel("Giá»›i tĂ­nh");
		lblNewLabel_10_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10_1_1.setBounds(501, 10, 79, 35);
		pBoLocKH.add(lblNewLabel_10_1_1);

		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Ná»¯" }));
		comboBox_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox_1_1.setBounds(590, 10, 120, 35);
		pBoLocKH.add(comboBox_1_1);

		// NĂºt tĂ¬m kiáº¿m khĂ¡ch hĂ ng

		JButton btnTimKiemKH = new JButton("TĂ¬m kiáº¿m");
		btnTimKiemKH.setBounds(0, 119, 171, 47);
		pBoLocKH.add(btnTimKiemKH);
		btnTimKiemKH.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8_search_40px.png")));

		// NĂºt xĂ³a táº¥t cáº£ bá»™ lá»�c

		JButton btnXoaTatCaBoLoc = new JButton("XĂ³a táº¥t cáº£ bá»™ lá»�c");
		btnXoaTatCaBoLoc.setBounds(205, 119, 171, 47);
		pBoLocKH.add(btnXoaTatCaBoLoc);
		btnXoaTatCaBoLoc.setIcon(new ImageIcon(TrangChu.class.getResource("/img/cancel.png")));

		JLabel lblNewLabel_10_2 = new JLabel("Sá»‘ CMND");
		lblNewLabel_10_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10_2.setBounds(10, 65, 79, 35);
		pBoLocKH.add(lblNewLabel_10_2);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setBounds(99, 65, 120, 35);
		pBoLocKH.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_10_2_1 = new JLabel("Sá»‘ Ä‘iá»‡n thoáº¡i");
		lblNewLabel_10_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10_2_1.setBounds(247, 65, 91, 35);
		pBoLocKH.add(lblNewLabel_10_2_1);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(345, 65, 120, 35);
		pBoLocKH.add(textField_3);

		// Ä�iá»�u chá»‰nh Ä‘á»™ rá»™ng cá»§a cá»™t trong báº£n khĂ¡ch hĂ ng

		table_3.getColumnModel().getColumn(0).setPreferredWidth(20);
		table_3.getColumnModel().getColumn(1).setResizable(false);
		table_3.getColumnModel().getColumn(1).setPreferredWidth(74);
		table_3.getColumnModel().getColumn(3).setPreferredWidth(40);
		table_3.getColumnModel().getColumn(6).setPreferredWidth(100);*/

		// ------------------------------------------------------------------------------------------------------------------------------------------
		// Chá»©c nÄƒng quáº£n lĂ½ sáº£n pháº©m
		/*pQuanLySanPham = new JPanel();
		pQuanLySanPham.setBounds(240, 0, 1260, 763);
		pQuanLySanPham.setLayout(null);
		pQuanLySanPham.setBackground(Color.WHITE);
		contentPane.add(pQuanLySanPham);

		JScrollPane scrollPaneSanPham = new JScrollPane();
		scrollPaneSanPham.setBounds(15, 326, 1210, 414);
		pQuanLySanPham.add(scrollPaneSanPham);

		tableSanPham = new JTable();
		tableSanPham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPaneSanPham.setViewportView(tableSanPham);
		tableSanPham.setModel(new DefaultTableModel(
				new Object[][] { { 1, "SP001", "Ă�o thá»ƒ thao MU", "Addidas", "Ă�o thá»ƒ thao", 25, 95000 },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"H\u00E3ng s\u1EA3n xu\u1EA5t", "Lo\u1EA1i", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1" }));
		tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(15);
		tableSanPham.getColumnModel().getColumn(5).setPreferredWidth(15);

		// Cáº­p nháº­t thĂ´ng tin sáº£n pháº©m
		JPanel pCapNhatSP = new JPanel();
		pCapNhatSP.setLayout(null);
		pCapNhatSP.setBackground(new Color(224, 255, 255));
		pCapNhatSP.setBounds(20, 219, 240, 60);
		pQuanLySanPham.add(pCapNhatSP);

		JLabel lblNewLabel_7_1 = new JLabel("New label");
		lblNewLabel_7_1.setIcon(new ImageIcon(TrangChu.class.getResource("/img/updateKH.png")));
		lblNewLabel_7_1.setBounds(10, 10, 40, 40);
		pCapNhatSP.add(lblNewLabel_7_1);

		JLabel lblNewLabel_8_1 = new JLabel("Cáº­p nháº­t sáº£n pháº©m");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8_1.setBounds(72, 10, 158, 40);
		pCapNhatSP.add(lblNewLabel_8_1);

		// Bá»™ lá»�c tĂ¬m kiáº¿m sáº£n pháº©m
		JPanel pBoLocTKSP = new JPanel();
		pBoLocTKSP.setLayout(null);
		pBoLocTKSP.setBackground(new Color(224, 255, 255));
		pBoLocTKSP.setBounds(20, 110, 240, 60);
		pQuanLySanPham.add(pBoLocTKSP);

		JLabel lblIconBoLocTKSP = new JLabel("New label");
		lblIconBoLocTKSP.setIcon(new ImageIcon(TrangChu.class.getResource("/img/boLoc.png")));
		lblIconBoLocTKSP.setBounds(10, 10, 40, 40);
		pBoLocTKSP.add(lblIconBoLocTKSP);

		JLabel lblBoLocTKSP = new JLabel("Bá»™ lá»�c sáº£n pháº©m");
		lblBoLocTKSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBoLocTKSP.setBounds(72, 10, 158, 40);
		pBoLocTKSP.add(lblBoLocTKSP);

		// Combobox hĂ£ng sáº£n xuáº¥t
		JComboBox cboHangSanXuat = new JComboBox();
		cboHangSanXuat.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboHangSanXuat.setModel(new DefaultComboBoxModel(new String[] { "Nike", "Addidas", "Puma" }));
		cboHangSanXuat.setBounds(430, 110, 120, 35);
		pQuanLySanPham.add(cboHangSanXuat);

		JLabel lblHangSanXuat;
		lblHangSanXuat = new JLabel("HĂ£ng sáº£n xuáº¥t");
		lblHangSanXuat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHangSanXuat.setBounds(310, 110, 90, 35);
		pQuanLySanPham.add(lblHangSanXuat);

		// Combobox loáº¡i sáº£n pháº©m
		JComboBox cboLoaiSP = new JComboBox();
		cboLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboLoaiSP.setModel(new DefaultComboBoxModel(new String[] { "Ă�o thun", "Ă�o khoĂ¡c", "Ă�o len" }));
		cboLoaiSP.setBounds(720, 110, 120, 35);
		pQuanLySanPham.add(cboLoaiSP);

		JLabel lblLoaiSP;
		lblLoaiSP = new JLabel("Loáº¡i sáº£n pháº©m");
		lblLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoaiSP.setBounds(600, 110, 90, 35);
		pQuanLySanPham.add(lblLoaiSP);

		// Nháº­p sá»‘ lÆ°á»£ng

		JLabel lblNhapSoLuongSP;
		lblNhapSoLuongSP = new JLabel("Sá»‘ lÆ°á»£ng sáº£n pháº©m");
		lblNhapSoLuongSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNhapSoLuongSP.setBounds(920, 110, 120, 35);
		pQuanLySanPham.add(lblNhapSoLuongSP);

		textField = new JTextField();
		textField.setBounds(1150, 110, 47, 35);
		pQuanLySanPham.add(textField);
		textField.setColumns(10);

		JLabel lblLoaiSP_1 = new JLabel("Tá»‘i thiá»ƒu");
		lblLoaiSP_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoaiSP_1.setBounds(1070, 110, 68, 35);
		pQuanLySanPham.add(lblLoaiSP_1);

		JLabel lblLoaiSP_1_1 = new JLabel("Tá»‘i Ä‘a");
		lblLoaiSP_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoaiSP_1_1.setBounds(1070, 167, 68, 35);
		pQuanLySanPham.add(lblLoaiSP_1_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(1150, 167, 47, 35);
		pQuanLySanPham.add(textField_1);

		JLabel lblHangSanXuat_1 = new JLabel("Trong táº§m giĂ¡");
		lblHangSanXuat_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHangSanXuat_1.setBounds(310, 167, 90, 35);
		pQuanLySanPham.add(lblHangSanXuat_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("< 100.000Ä‘");
		rdbtnNewRadioButton.setBounds(432, 175, 103, 21);
		pQuanLySanPham.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("100.000Ä‘ Ä‘áº¿n 500.000Ä‘");
		rdbtnNewRadioButton_1.setBounds(557, 175, 152, 21);
		pQuanLySanPham.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("> 500.000Ä‘");
		rdbtnNewRadioButton_2.setBounds(737, 175, 103, 21);
		pQuanLySanPham.add(rdbtnNewRadioButton_2);

		JButton btnNewButton = new JButton("TĂ¬m kiáº¿m");
		btnNewButton.setBounds(310, 232, 171, 47);
		pQuanLySanPham.add(btnNewButton);

		JLabel lblNewLabel_13 = new JLabel("Quáº£n lĂ½ sáº£n pháº©m");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_13.setBounds(20, 21, 358, 60);
		pQuanLySanPham.add(lblNewLabel_13);

		JButton btnNewButton_1 = new JButton("XĂ³a táº¥t cáº£ bá»™ lá»�c");
		btnNewButton_1.setIcon(new ImageIcon(TrangChu.class.getResource("/img/cancel.png")));
		btnNewButton.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8_search_40px.png")));
		btnNewButton_1.setBounds(519, 232, 171, 47);
		pQuanLySanPham.add(btnNewButton_1);*/

		/*pQuanLyThongKe = new JPanel();
		pQuanLyThongKe.setBackground(new Color(255, 235, 205));
		pQuanLyThongKe.setBounds(240, 0, 1260, 763);
		contentPane.add(pQuanLyThongKe);
		pQuanLyThongKe.setLayout(null);*/

		// ----------------------------------------------------------------------------------------------------------------------------------------
		// Chá»©c nÄƒng quáº£n lĂ½ kho

		/*pQuanLyKho = new JPanel();
		pQuanLyKho.setLayout(null);
		pQuanLyKho.setBackground(Color.WHITE);
		pQuanLyKho.setBounds(240, 0, 1260, 763);
		contentPane.add(pQuanLyKho);

		JLabel lblQuanLyKho = new JLabel("Quáº£n lĂ½ kho");
		lblQuanLyKho.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQuanLyKho.setBounds(20, 21, 358, 60);
		pQuanLyKho.add(lblQuanLyKho);

		JScrollPane scrollPaneCTKho = new JScrollPane();
		scrollPaneCTKho.setBounds(20, 495, 790, 236);
		pQuanLyKho.add(scrollPaneCTKho);

		JTable tableCTHDKho = new JTable();
		scrollPaneCTKho.setViewportView(tableCTHDKho);
		tableCTHDKho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableCTHDKho.setBackground(Color.WHITE);
		tableCTHDKho
				.setModel(new DefaultTableModel(
						new Object[][] {
								{ 1, "SP007", "Ă�o thá»ƒ thao MU", "XXL", "Ä�á»�", "Ă�o thá»ƒ thao", 1, 95000, 95000,
										"mua má»›i" },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null },
								{ null, null, null, null, null, null, null, null, null }, },
						new String[] { "STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
								"K\u00EDch th\u01B0\u1EDBc", "M\u00E0u", "Lo\u1EA1i", "S\u1ED1 l\u01B0\u1EE3ng", "GiĂ¡",
								"Th\u00E0nh ti\u1EC1n", "Ghi ch\u00FA" }));

		// NĂºt thĂªm hĂ³a Ä‘Æ¡n kho
		// Ä‘Æ¡n*************************************************************************************************************************
		JPanel pThemHDKho = new JPanel();
		pThemHDKho.setBackground(new Color(224, 255, 255));
		pThemHDKho.setBounds(907, 160, 240, 60);
		pQuanLyKho.add(pThemHDKho);
		pThemHDKho.setLayout(null);

		JLabel lblIconThemHDKho = new JLabel();
		lblIconThemHDKho.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8_add_40px.png")));
		lblIconThemHDKho.setBounds(10, 10, 40, 40);
		pThemHDKho.add(lblIconThemHDKho);

		JLabel lblThemHDKho = new JLabel("ThĂªm hĂ³a Ä‘Æ¡n kho");
		lblThemHDKho.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThemHDKho.setBounds(74, 10, 139, 40);
		pThemHDKho.add(lblThemHDKho);
		// ****************************************************************************************************************************************

		// NĂºt cáº­p nháº­t hĂ³a kho
		// Ä‘Æ¡n*****************************************************************************************************************
		JPanel pCapNhatHDKho = new JPanel();
		pCapNhatHDKho.setLayout(null);
		pCapNhatHDKho.setBackground(new Color(224, 255, 255));
		pCapNhatHDKho.setBounds(907, 240, 240, 60);
		pQuanLyKho.add(pCapNhatHDKho);

		JLabel lblIconCapNhatHDKho = new JLabel();
		lblIconCapNhatHDKho.setIcon(new ImageIcon(TrangChu.class.getResource("/img/updateKH.png")));
		lblIconCapNhatHDKho.setBounds(10, 10, 40, 40);
		pCapNhatHDKho.add(lblIconCapNhatHDKho);

		JLabel lblCapNhatHDKho = new JLabel("Cáº­p nháº­t hĂ³a Ä‘Æ¡n kho");
		lblCapNhatHDKho.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCapNhatHDKho.setBounds(72, 10, 158, 40);
		pCapNhatHDKho.add(lblCapNhatHDKho);
		// ******************************************************************************************************************************************

		JPanel pBoLocTKHDKho = new JPanel();
		pBoLocTKHDKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pAnBoLocHDBH.setVisible(false);

			}
		});
		pBoLocTKHDKho.setLayout(null);
		pBoLocTKHDKho.setBackground(new Color(224, 255, 255));
		pBoLocTKHDKho.setBounds(907, 320, 240, 60);
		pQuanLyKho.add(pBoLocTKHDKho);

		JLabel lblIconBoLocTKHDKho = new JLabel();
		lblIconBoLocTKHDKho.setIcon(new ImageIcon(TrangChu.class.getResource("/img/boLoc.png")));
		lblIconBoLocTKHDKho.setBounds(10, 10, 40, 40);
		pBoLocTKHDKho.add(lblIconBoLocTKHDKho);

		JLabel lblBoLocTKHDKho = new JLabel("Bá»™ lá»�c tĂ¬m kiáº¿m");
		lblBoLocTKHDKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		lblBoLocTKHDKho.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBoLocTKHDKho.setBounds(73, 10, 157, 40);
		pBoLocTKHDKho.add(lblBoLocTKHDKho);

		JLabel lblBangHDKho = new JLabel("Báº£ng hĂ³a Ä‘Æ¡n kho");
		lblBangHDKho.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBangHDKho.setBounds(20, 110, 250, 34);
		pQuanLyKho.add(lblBangHDKho);

		JLabel lblBangCTHDKho = new JLabel("Báº£ng chi tiáº¿t hĂ³a Ä‘Æ¡n");
		lblBangCTHDKho.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBangCTHDKho.setBounds(20, 451, 300, 34);
		pQuanLyKho.add(lblBangCTHDKho);

		JScrollPane scrollPaneKho = new JScrollPane();
		scrollPaneKho.setBounds(20, 160, 790, 240);
		pQuanLyKho.add(scrollPaneKho);

		tableHDKho = new JTable();
		tableHDKho.setModel(new DefaultTableModel(
				new Object[][] {
						{ new Integer(1), "HD001", "Nguy\u1EC5n V\u0103n B", "29/9/2021", new Integer(95000),
								"Mua m\u1EDBi" },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "STT", "M\u00E3 h\u00F3a \u0111\u01A1n", "Nh\u00E2n vi\u00EAn",
						"Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n", "T\u1ED5ng ti\u1EC1n", "Ghi ch\u00FA" }));
		scrollPaneKho.setViewportView(tableHDKho);
		tableHDKho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableHDKho.setBackground(Color.WHITE);

		/*
		 * pAnBoLocHDBH = new JPanel(); pAnBoLocHDBH.setBackground(Color.WHITE);
		 * pAnBoLocHDBH.setBounds(907, 430, 300, 301); pQuanLyHoaDon.add(pAnBoLocHDBH);
		 * pAnBoLocHDBH.setLayout(null);
		 */

		/*pBoLocHDKho = new JPanel();
		pBoLocHDKho.setBackground(Color.WHITE);
		pBoLocHDKho.setBounds(907, 430, 320, 127);
		pQuanLyKho.add(pBoLocHDKho);
		pBoLocHDKho.setLayout(null);

		JLabel lblNgayLapHoaDonKho = new JLabel("NgĂ y láº­p hĂ³a Ä‘Æ¡n kho");
		lblNgayLapHoaDonKho.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayLapHoaDonKho.setBounds(10, 10, 139, 35);
		pBoLocHDKho.add(lblNgayLapHoaDonKho);*/

		// Combobox tĂªn nhĂ¢n nháº­p hĂ³a Ä‘Æ¡n

		/*JLabel lblTenNhanVienNhapKho = new JLabel("TĂªn nhĂ¢n viĂªn");
		lblTenNhanVienNhapKho.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNhanVienNhapKho.setBounds(10, 65, 125, 35);
		pBoLocHDKho.add(lblTenNhanVienNhapKho);

		JComboBox cboTenNhanVienNhapKho = new JComboBox();
		cboTenNhanVienNhapKho.setModel(new DefaultComboBoxModel(new String[] { "Nguyá»…n VÄƒn A", "Nguyá»…n VÄƒn B" }));
		cboTenNhanVienNhapKho.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboTenNhanVienNhapKho.setBounds(170, 65, 140, 35);
		pBoLocHDKho.add(cboTenNhanVienNhapKho);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(170, 10, 140, 35);
		pBoLocHDKho.add(dateChooser);

		JPanel pThemHDKho_1 = new JPanel();
		pThemHDKho_1.setLayout(null);
		pThemHDKho_1.setBackground(new Color(224, 255, 255));
		pThemHDKho_1.setBounds(907, 608, 240, 60);
		pQuanLyKho.add(pThemHDKho_1);

		JLabel lblIconThemHDKho_1 = new JLabel();
		lblIconThemHDKho_1.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8_add_40px.png")));
		lblIconThemHDKho_1.setBounds(10, 10, 40, 40);
		pThemHDKho_1.add(lblIconThemHDKho_1);

		JLabel lblThmSnPhm = new JLabel("ThĂªm sáº£n pháº©m");
		lblThmSnPhm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThmSnPhm.setBounds(74, 10, 139, 40);
		pThemHDKho_1.add(lblThmSnPhm);*/

		// ------------------------------------------------------------------------------------------------------------------------------------------
		// ChÆ°c nÄƒng quáº£n lĂ½ nhĂ¢n viĂªn
		/*pQuanLyNhanVien = new JPanel();
		pQuanLyNhanVien.setLayout(null);
		pQuanLyNhanVien.setBackground(Color.WHITE);
		pQuanLyNhanVien.setBounds(240, 0, 1260, 763);
		contentPane.add(pQuanLyNhanVien);

		JLabel lblQuanLyNhanVien = new JLabel("Quáº£n lĂ½ nhĂ¢n viĂªn");
		lblQuanLyNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQuanLyNhanVien.setBounds(20, 21, 358, 60);
		pQuanLyNhanVien.add(lblQuanLyNhanVien);

		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setBounds(20, 345, 1200, 376);
		pQuanLyNhanVien.add(scrollPaneNV);

		tableNhanVien = new JTable();
		scrollPaneNV.setViewportView(tableNhanVien);
		tableNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableNhanVien.setBackground(Color.WHITE);
		tableNhanVien.setModel(new DefaultTableModel(
				new Object[][] {
						{ new Integer(1), "KH001", "Nguy\u1EC5n V\u0103n A", "Nam", new Integer(123456789),
								new Integer(123456789), "S\u1ED1 9, \u0111\u01B0\u1EDDng L\u00EA Ninh",
								"H\u00E0 N\u1ED9i", "29/08/2000", "14/5/2020" },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "STT", "M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng",
						"Gi\u1EDBi t\u00EDnh", "S\u1ED1 CMND", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i",
						"\u0110\u1ECBa ch\u1EC9", "Th\u00E0nh ph\u1ED1", "Ng\u00E0y sinh", "NgĂ y vĂ o lĂ m" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, Double.class,
					Double.class, String.class, String.class, String.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableNhanVien.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableNhanVien.getColumnModel().getColumn(1).setResizable(false);
		tableNhanVien.getColumnModel().getColumn(1).setPreferredWidth(74);
		tableNhanVien.getColumnModel().getColumn(3).setPreferredWidth(40);
		tableNhanVien.getColumnModel().getColumn(6).setPreferredWidth(100);

		// ThĂªm má»™t nhĂ¢n viĂªn
		JPanel pThemNV = new JPanel();
		pThemNV.setBackground(new Color(224, 255, 255));
		pThemNV.setBounds(20, 182, 240, 60);
		pQuanLyNhanVien.add(pThemNV);
		pThemNV.setLayout(null);

		JLabel lblIconThemNV = new JLabel();
		lblIconThemNV.setIcon(new ImageIcon(TrangChu.class.getResource("/img/themKH.png")));
		lblIconThemNV.setBounds(10, 10, 40, 40);
		pThemNV.add(lblIconThemNV);

		JLabel lblThemNV = new JLabel("ThĂªm nhĂ¢n viĂªn");
		lblThemNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThemNV.setBounds(72, 10, 139, 40);
		pThemNV.add(lblThemNV);

		// Cáº­p nháº­t thĂ´ng tin nhĂ¢n viĂªn
		JPanel pCapNhatNV = new JPanel();
		pCapNhatNV.setLayout(null);
		pCapNhatNV.setBackground(new Color(224, 255, 255));
		pCapNhatNV.setBounds(20, 260, 240, 60);
		pQuanLyNhanVien.add(pCapNhatNV);

		JLabel lblIconCapNhatNV = new JLabel();
		lblIconCapNhatNV.setIcon(new ImageIcon(TrangChu.class.getResource("/img/updateKH.png")));
		lblIconCapNhatNV.setBounds(10, 10, 40, 40);
		pCapNhatNV.add(lblIconCapNhatNV);

		JLabel lblCapNhatNV = new JLabel("Cáº­p nháº­t nhĂ¢n viĂªn");
		lblCapNhatNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCapNhatNV.setBounds(72, 10, 158, 40);
		pCapNhatNV.add(lblCapNhatNV);

		// Bá»™ lá»�c tĂ¬m kiáº¿m nhĂ¢n viĂªn
		JPanel pBoLocTKNV = new JPanel();
		pBoLocTKNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		pBoLocTKNV.setLayout(null);
		pBoLocTKNV.setBackground(new Color(224, 255, 255));
		pBoLocTKNV.setBounds(20, 110, 240, 60);
		pQuanLyNhanVien.add(pBoLocTKNV);

		// Bá»™ lá»�c Ä‘á»ƒ tĂ¬m kiáº¿m thĂ´ng tin khĂ¡ch hĂ ng

		// Icon bá»™ lá»�c
		JLabel lblIconBoLocTKNV = new JLabel();
		lblIconBoLocTKNV.setIcon(new ImageIcon(TrangChu.class.getResource("/img/boLoc.png")));
		lblIconBoLocTKNV.setBounds(10, 10, 40, 40);
		pBoLocTKNV.add(lblIconBoLocTKNV);

		// NhĂ£n bá»™ lá»�c
		JLabel lblBoLocTKNV = new JLabel("Bá»™ lá»�c tĂ¬m kiáº¿m");
		lblBoLocTKNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBoLocTKNV.setBounds(73, 10, 157, 40);
		pBoLocTKNV.add(lblBoLocTKNV);

		JPanel pBoLocNV = new JPanel();
		pBoLocNV.setBackground(new Color(255, 255, 255));
		pBoLocNV.setBounds(311, 110, 910, 149);
		pQuanLyNhanVien.add(pBoLocNV);
		pBoLocNV.setLayout(null);

		// Combobox nÄƒm sinh cá»§a nhĂ¢n viĂªn

		JComboBox cboNamSinhNV = new JComboBox();
		cboNamSinhNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboNamSinhNV
				.setModel(new DefaultComboBoxModel(new String[] { "1980", "1981", "1982", "1983", "1984", "1985" }));
		cboNamSinhNV.setBounds(99, 10, 120, 35);
		pBoLocNV.add(cboNamSinhNV);

		JLabel lblNamSinhNV = new JLabel("NÄƒm sinh");
		lblNamSinhNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNamSinhNV.setBounds(10, 10, 79, 35);
		pBoLocNV.add(lblNamSinhNV);

		// Combobox thĂ nh phá»‘ mĂ  nhĂ¢n viĂªn sá»‘ng

		JLabel lblThanhPhoNV = new JLabel("ThĂ nh phá»‘");
		lblThanhPhoNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThanhPhoNV.setBounds(247, 10, 79, 35);
		pBoLocNV.add(lblThanhPhoNV);

		JComboBox cboThanhPhoNV = new JComboBox();
		cboThanhPhoNV.setModel(new DefaultComboBoxModel(new String[] { "Tp.HCM", "HĂ  Ná»™i", "TĂ¢y Ninh" }));
		cboThanhPhoNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboThanhPhoNV.setBounds(345, 10, 120, 35);
		pBoLocNV.add(cboThanhPhoNV);

		// Combobox giá»›i tĂ­nh nhĂ¢n viĂªn

		JLabel lblGioTinhNV = new JLabel("Giá»›i tĂ­nh");
		lblGioTinhNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGioTinhNV.setBounds(501, 10, 79, 35);
		pBoLocNV.add(lblGioTinhNV);

		JComboBox cboGioiTinhNV = new JComboBox();
		cboGioiTinhNV.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Ná»¯" }));
		cboGioiTinhNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboGioiTinhNV.setBounds(590, 10, 120, 35);
		pBoLocNV.add(cboGioiTinhNV);

		// NĂºt tĂ¬m kiáº¿m nhĂ¢n viĂªn

		JButton btnTimKiemNV = new JButton("TĂ¬m kiáº¿m");
		btnTimKiemNV.setBounds(0, 92, 171, 47);
		pBoLocNV.add(btnTimKiemNV);
		btnTimKiemNV.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8_search_40px.png")));

		// NĂºt xĂ³a táº¥t cáº£ bá»™ lá»�c

		JButton btnXoaTatCaBoLocNV = new JButton("XĂ³a táº¥t cáº£ bá»™ lá»�c");
		btnXoaTatCaBoLocNV.setBounds(205, 92, 171, 47);
		pBoLocNV.add(btnXoaTatCaBoLocNV);
		btnXoaTatCaBoLocNV.setIcon(new ImageIcon(TrangChu.class.getResource("/img/cancel.png")));*/

		/*pQuanLyBaoCao = new JPanel();
		pQuanLyBaoCao.setLayout(null);
		pQuanLyBaoCao.setBackground(new Color(95, 158, 160));
		pQuanLyBaoCao.setBounds(240, 0, 1260, 763);
		contentPane.add(pQuanLyBaoCao);*/

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
