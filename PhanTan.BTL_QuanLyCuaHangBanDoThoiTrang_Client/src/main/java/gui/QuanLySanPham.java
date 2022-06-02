package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.SessionFactory;

import dao.ChiTietBanHangDAO;
import dao.GenerateKeyDAO;
import dao.HangSanXuatDAO;
import dao.HoaDonBanHangDAO;
import dao.KhachHangDAO;
import dao.LoaiSanPhamDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import entity.HangSanXuat;
import entity.HoaDonBanHang;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.NhanVienBanHang;
import entity.SanPham;
import gui.GiaoDienChinh_ChuCuaHang;

import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLySanPham extends JPanel {

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

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private DefaultTableModel model;
	private JComboBox cboLoaiSP;
	private JComboBox cboHangSanXuat;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtSL;
	private JTextField txtGia;
	private JComboBox cboLoai;
	private JComboBox cboHSX;
	private JComboBox cboSize;
	private JComboBox cboMau;
	private JButton btnCN;
	private JButton btnThoat;
	private JLabel lblThongBao;
	private JLabel lblTenLoai;
	private JLabel lblTenHSX;
	private JPanel pCapNhatSP;
	private JPanel pBoLocTimKiem;
	private DefaultComboBoxModel modelComboBox;
	
	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public QuanLySanPham() throws RemoteException {

		// ------------------------------------------------------------------------------------------------------------------------------------------
		// Chá»©c nÄƒng quáº£n lĂ½ sáº£n pháº©m

		setBounds(240, 0, 1298, 816);
		setLayout(null);
		setBackground(Color.WHITE);

		JScrollPane scrollPaneSanPham = new JScrollPane();
		scrollPaneSanPham.setBounds(15, 277, 1210, 463);
		add(scrollPaneSanPham);

		tableSanPham = new JTable();
		tableSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableSanPham.getSelectedRow();
				
				try {
					SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					SanPham sp = sanphamDAO.laySanPhamTheoMa(tableSanPham.getValueAt(row, 1).toString());
					txtMaSP.setText(tableSanPham.getValueAt(row, 1).toString());
					txtTenSP.setText(tableSanPham.getValueAt(row, 2).toString());
					//cboHSX.setSelectedItem(tableSanPham.getValueAt(row, 3).toString());
					//cboLoai.setSelectedItem(tableSanPham.getValueAt(row, 4).toString());
					cboHSX.setSelectedItem(sp.getHangSanXuat().getMaHangSanXuat());
					cboLoai.setSelectedItem(sp.getLoaiSanPham().getMaLoaiSanPham());
					cboSize.setSelectedItem(tableSanPham.getValueAt(row, 5).toString());
					cboMau.setSelectedItem(tableSanPham.getValueAt(row, 6).toString());
					txtSL.setText(tableSanPham.getValueAt(row, 7).toString());
					txtGia.setText(tableSanPham.getValueAt(row, 8).toString());
					
					//lblTenHSX.setText(tableSanPham.getValueAt(row, 3).toString());
					//lblTenLoai.setText(sp.getLoaiSanPham().getMaLoaiSanPham());
					lblTenHSX.setText(tableSanPham.getValueAt(row, 3).toString());
					lblTenLoai.setText(tableSanPham.getValueAt(row, 4).toString());
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		tableSanPham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPaneSanPham.setViewportView(tableSanPham);
		tableSanPham.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "H\u00E3ng s\u1EA3n xu\u1EA5t", "Lo\u1EA1i", "Size", "M\u00E0u", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1"
			}
		));
		tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(15);
		tableSanPham.getColumnModel().getColumn(5).setPreferredWidth(15);
		
		tableSanPham.setAutoCreateRowSorter(true);
		tableSanPham.setRowHeight(tableSanPham.getRowHeight() + 10);
		tableSanPham.setDefaultEditor(Object.class, null);
		
		model = (DefaultTableModel) tableSanPham.getModel();
		showTableSanPham();
		
		pBoLocTimKiem = new JPanel();
		pBoLocTimKiem.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pBoLocTimKiem.setBackground(Color.WHITE);
		pBoLocTimKiem.setBounds(300, 91, 925, 160);
		add(pBoLocTimKiem);
		pBoLocTimKiem.setLayout(null);

		
		
		// Combobox hĂ£ng sáº£n xuáº¥t
		cboHangSanXuat = new JComboBox();
		cboHangSanXuat.setModel(new DefaultComboBoxModel(new String[] {""}));
		cboHangSanXuat.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboHangSanXuat.setBounds(120, 20, 160, 30);
		pBoLocTimKiem.add(cboHangSanXuat);

		JLabel lblHangSanXuat;
		lblHangSanXuat = new JLabel("Hãng sản xuất");
		lblHangSanXuat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHangSanXuat.setBounds(10, 20, 90, 30);
		pBoLocTimKiem.add(lblHangSanXuat);

		// Combobox loáº¡i sáº£n pháº©m
		cboLoaiSP = new JComboBox();
		cboLoaiSP.setModel(new DefaultComboBoxModel(new String[] {""}));
		cboLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboLoaiSP.setBounds(410, 20, 160, 30);
		pBoLocTimKiem.add(cboLoaiSP);
		
		showComboBox();

		JLabel lblLoaiSP;
		lblLoaiSP = new JLabel("Loại sản phẩm");
		lblLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoaiSP.setBounds(300, 20, 90, 30);
		pBoLocTimKiem.add(lblLoaiSP);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboHangSanXuat.getSelectedIndex() == 0)
					timkiemTheoLoaiSP();
				else if (cboLoaiSP.getSelectedIndex() == 0)
					timkiemTheoHSX();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(10, 80, 175, 50);
		pBoLocTimKiem.add(btnNewButton);

		JLabel lblNewLabel_13 = new JLabel("Quản lý sản phẩm");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_13.setBounds(20, 21, 358, 60);
		add(lblNewLabel_13);

		JButton btnNewButton_1 = new JButton("Xóa bộ lọc");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboHangSanXuat.setSelectedIndex(0);
				cboLoaiSP.setSelectedIndex(0);
				
				xoaHetDuLieuTrenTableModel();
				try {
					showTableSanPham();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/cancel.png")));
		btnNewButton.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_search_40px.png")));
		btnNewButton_1.setBounds(216, 81, 196, 50);
		pBoLocTimKiem.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cập nhật sản phẩm");
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.addActionListener(new ActionListener() {
			private CapNhatSanPham capnhatSP;

			public void actionPerformed(ActionEvent e) {
				/*capnhatSP = new CapNhatSanPham();
				capnhatSP.setVisible(true);
				//capnhatSP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				capnhatSP.setLocationRelativeTo(null);
				capnhatSP.setAlwaysOnTop(true);
				capnhatSP.setResizable(false);
				
				int row = tableSanPham.getSelectedRow();
				String maSP = (String) tableSanPham.getValueAt(row, 1);
				capnhatSP.showData(maSP);*/
				
				add(pCapNhatSP);
				pCapNhatSP.setVisible(true);
				pBoLocTimKiem.setVisible(false);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(QuanLySanPham.class.getResource("/img/icons8_update_40px_2.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(15, 140, 240, 60);
		add(btnNewButton_2);
		
		pCapNhatSP = new JPanel();
		pCapNhatSP.setBorder(new TitledBorder(null, "C\u1EADp nh\u1EADt kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pCapNhatSP.setBackground(Color.WHITE);
		pCapNhatSP.setBounds(300, 77, 925, 190);
		//add(pCapNhatSP);
		pCapNhatSP.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 20, 101, 25);
		pCapNhatSP.add(lblNewLabel);
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(121, 20, 319, 25);
		pCapNhatSP.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm");
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnSnPhm.setBounds(10, 60, 101, 25);
		pCapNhatSP.add(lblTnSnPhm);
		
		txtTenSP = new JTextField();
		txtTenSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(121, 60, 319, 25);
		pCapNhatSP.add(txtTenSP);
		
		JLabel lblSCmnd = new JLabel("Loại sản phẩm");
		lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSCmnd.setBounds(10, 100, 130, 25);
		pCapNhatSP.add(lblSCmnd);
		
		cboLoai = new JComboBox();
		cboLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoaiSanPhamDAO loaiDAO = null;
				try {
					loaiDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String nhap = cboLoai.getSelectedItem().toString();
				LoaiSanPham lsp = null;
				try {
					lsp = loaiDAO.layLoaiSanPhamTheoMa(nhap);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblTenLoai.setText(lsp.getTenLoai());
			}
		});
		cboLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboLoai.setEditable(true);
		cboLoai.setBounds(122, 100, 170, 25);
		pCapNhatSP.add(cboLoai);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hãng sản xuất");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 140, 113, 25);
		pCapNhatSP.add(lblNewLabel_1_1);
		
		cboHSX = new JComboBox();
		cboHSX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HangSanXuatDAO hsxDAO = null;
				try {
					hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
					String nhap = cboHSX.getSelectedItem().toString();
					System.out.println(nhap);
					HangSanXuat hsx = hsxDAO.layHangSanXuatTheoMa(nhap);
					lblTenHSX.setText(hsx.getTenHangSanXuat());
				} catch (MalformedURLException | RemoteException | NotBoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		cboHSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboHSX.setEditable(true);
		cboHSX.setBounds(122, 140, 170, 25);
		pCapNhatSP.add(cboHSX);
		
		lblTenLoai = new JLabel("");
		lblTenLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenLoai.setBounds(302, 100, 138, 25);
		pCapNhatSP.add(lblTenLoai);
		
		lblTenHSX = new JLabel("");
		lblTenHSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenHSX.setBounds(302, 140, 138, 25);
		pCapNhatSP.add(lblTenHSX);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Size:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(470, 20, 75, 25);
		pCapNhatSP.add(lblNewLabel_1_1_1);
		
		cboSize = new JComboBox();
		cboSize.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L", "XL", "XXL", "XXXL"}));
		cboSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSize.setBounds(590, 20, 170, 25);
		pCapNhatSP.add(cboSize);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Màu sắc");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(470, 60, 75, 25);
		pCapNhatSP.add(lblNewLabel_1_1_1_1);
		
		cboMau = new JComboBox();
		cboMau.setModel(new DefaultComboBoxModel(new String[] {"Đen ", "Trắng ", "Đỏ", "Xanh Dương", "Xanh Lá", "Cam", "Vàng", "Tràm ", "Tím", "Nâu"}));
		cboMau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboMau.setEditable(true);
		cboMau.setBounds(590, 60, 170, 25);
		pCapNhatSP.add(cboMau);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Số lượng");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(470, 100, 130, 25);
		pCapNhatSP.add(lblNewLabel_1_1_1_1_1);
		
		txtSL = new JTextField();
		txtSL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSL.setColumns(10);
		txtSL.setBounds(590, 100, 170, 25);
		pCapNhatSP.add(txtSL);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Giá sản phẩm");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(470, 140, 130, 25);
		pCapNhatSP.add(lblNewLabel_1_1_1_1_1_1);
		
		txtGia = new JTextField();
		txtGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGia.setColumns(10);
		txtGia.setBounds(590, 145, 170, 25);
		pCapNhatSP.add(txtGia);
		
		btnCN = new JButton("Cập nhật");
		btnCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maSP = txtMaSP.getText();
				String tenSP = txtTenSP.getText();
				String loai = String.valueOf(lblTenLoai);
				LoaiSanPham loaiSP = new LoaiSanPham(cboLoai.getSelectedItem().toString());
				String hsx = String.valueOf(cboHSX.getSelectedItem().toString());
				HangSanXuat hang = new HangSanXuat(cboHSX.getSelectedItem().toString());
				String size = String.valueOf(cboSize.getSelectedItem());
				String mau = String.valueOf(cboMau.getSelectedItem());
				int sl = Integer.parseInt(txtSL.getText());
				double gia = Double.parseDouble(txtGia.getText());
	
				try {
					SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					SanPham sp = new SanPham(maSP, tenSP, gia, size, mau, sl, hang, loaiSP);
					try {
						boolean rs = sanphamDAO.capNhatSanPham(sp);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						if(sanphamDAO.capNhatSanPham(sp)) {
							lblThongBao.setText("Cập nhật sản phẩm thành công");
							//JOptionPane.showMessageDialog(rootPane, "Cáº­p nháº­t thĂ´ng tin khà�ch hà€ng thà€nh cĂ´ng");
						} else 
							lblThongBao.setText("Cập nhật sản phẩm không thành công");
							//JOptionPane.showMessageDialog(rootPane, "Cáº­p nháº­t thĂ´ng tin khĂ¡ch hĂ ng khĂ´ng thà€nh cĂ´ng");
					} catch (HeadlessException | RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (MalformedURLException | RemoteException | NotBoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					
			}
		});
		btnCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCN.setBounds(792, 60, 123, 21);
		pCapNhatSP.add(btnCN);
		
		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblThongBao.setText("");
				xoaHetDuLieuTrenTableModel();
				try {
					showTableSanPham();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				add(pBoLocTimKiem);
				pBoLocTimKiem.setVisible(true);
				pCapNhatSP.setVisible(false);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(792, 100, 123, 21);
		pCapNhatSP.add(btnThoat);
		
		lblThongBao = new JLabel("");
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThongBao.setBounds(373, 34, 500, 33);
		add(lblThongBao);

		modelComboBox = (DefaultComboBoxModel) cboLoai.getModel();
		modelComboBox = (DefaultComboBoxModel) cboHSX.getModel();
		showComboBoxHSX();
		showComboBoxLoai();
	}
	
	private void xoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) tableSanPham.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	public void showTableSanPham() throws RemoteException {
		SanPhamDAO sanphamDAO;
		try {
			sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
			
			int num = 1;
			for (SanPham sp : sanphamDAO.layTatCaSanPham()) {
				HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
				LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
				HangSanXuat hsx = hsxDAO.layHangSanXuatTheoMa(sp.getHangSanXuat().getMaHangSanXuat());
				LoaiSanPham loai = loaispDAO.layLoaiSanPhamTheoMa(sp.getLoaiSanPham().getMaLoaiSanPham());
				model.addRow(new Object[] { num , sp.getMaSanPham(), sp.getTenSanPham(), hsx.getTenHangSanXuat(), 
						loai.getTenLoai(), sp.getKichThuoc(), sp.getMauSac(), sp.getSoLuong(), sp.getGiaSanPham() });
				num++;
			} 
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void timkiemTheoHSX() {
		int index = cboHangSanXuat.getSelectedIndex();
		SanPhamDAO sanphamDAO = null;
		try {
			sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HangSanXuatDAO hsxDAO = null;
		try {
			hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hang = cboHangSanXuat.getSelectedItem().toString();
		String maHang = "";
		if(index < 10)
			maHang = "HSX00" + String.valueOf(index);
		else
			maHang = "HSX0" + String.valueOf(index);
		int num = 1;
		try {
			//List<HangSanXuat> ListHSX = hsxDAO.layHangSanXuatTheoTen(hang);
			HangSanXuat ListHSX = hsxDAO.layHangSanXuatTheoMa(maHang);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			List<SanPham> listSP = sanphamDAO.layDanhSachSanPhamTheoHSX(maHang);
			DefaultTableModel dm = (DefaultTableModel) tableSanPham.getModel();
			dm.getDataVector().removeAllElements();
			for (SanPham sp : listSP) {
				try {
					HangSanXuat hsx = hsxDAO.layHangSanXuatTheoMa(sp.getHangSanXuat().getMaHangSanXuat());
					LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
					LoaiSanPham loai = loaispDAO.layLoaiSanPhamTheoMa(sp.getLoaiSanPham().getMaLoaiSanPham());
					model.addRow(new Object[] { num , sp.getMaSanPham(), sp.getTenSanPham(), hsx.getTenHangSanXuat(), 
							loai.getTenLoai(), sp.getKichThuoc(), sp.getMauSac(), sp.getSoLuong(), sp.getGiaSanPham() });
					num++;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} 
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void timkiemTheoLoaiSP() {
		int index = cboLoaiSP.getSelectedIndex();
		SanPhamDAO sanphamDAO = null;
		try {
			sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hang = cboLoaiSP.getSelectedItem().toString();
		String maLoai;
		if(index < 10)
			maLoai = "L00" + String.valueOf(index);
		else
			maLoai = "L0" + String.valueOf(index);
		int num = 1;
		
		try {
			List<SanPham> listSP = sanphamDAO.layDanhSachSanPhamTheoLoai(maLoai);
			DefaultTableModel dm = (DefaultTableModel) tableSanPham.getModel();
			dm.getDataVector().removeAllElements();
			for (SanPham sp : listSP) {
				model.addRow(new Object[] { num , sp.getMaSanPham(), sp.getTenSanPham(), sp.getHangSanXuat().getTenHangSanXuat(), 
						sp.getLoaiSanPham().getTenLoai(), sp.getKichThuoc(), sp.getMauSac(), sp.getSoLuong(), sp.getGiaSanPham() });
				num++;
			} 
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void showComboBox() {
		HangSanXuatDAO hsxDAO = null;
		try {
			hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoaiSanPhamDAO loaispDAO = null;
		try {
			loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<HangSanXuat> listHSX = null;
		try {
			listHSX = hsxDAO.layTatCaHangSanXuat();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultComboBoxModel modelHSX = (DefaultComboBoxModel) cboHangSanXuat.getModel();
		for (HangSanXuat hsx : listHSX) {
			modelHSX.addElement(hsx.getTenHangSanXuat());
		}

		List<LoaiSanPham> listLoaiSP = null;
		try {
			listLoaiSP = loaispDAO.layTatCaLoaiSanPham();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultComboBoxModel modelLoaiSP = (DefaultComboBoxModel) cboLoaiSP.getModel();
		for (LoaiSanPham loai : listLoaiSP) {
			modelLoaiSP.addElement(loai.getTenLoai());
		}

		/*DefaultComboBoxModel modelSize = (DefaultComboBoxModel) cboSize.getModel();
		modelSize.addElement(new String[] { "S", "M", "L", "XL", "XXL", "XXXL" });

		DefaultComboBoxModel modelMau = (DefaultComboBoxModel) cboMau.getModel();
		modelMau.addElement(new String[] { "Ä�á»�", "Xanh DÆ°Æ¡ng", "Xanh LĂ¡", "VĂ ng", "Tráº¯ng", "Ä�en", "Cam", "TrĂ m" });*/
	}
	
	public void showComboBoxLoai() {
		LoaiSanPhamDAO loaiDAO = null;
		try {
			loaiDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		modelComboBox = (DefaultComboBoxModel) cboLoai.getModel();
		try {
			for(LoaiSanPham l : loaiDAO.layTatCaLoaiSanPham()) {
				modelComboBox.addElement(l.getMaLoaiSanPham());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showComboBoxHSX() {
		HangSanXuatDAO hangSanXuatDAO = null;
		try {
			SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
			hangSanXuatDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelComboBox = (DefaultComboBoxModel) cboHSX.getModel();
		try {
			for(HangSanXuat h : hangSanXuatDAO.layTatCaHangSanXuat()) {
				modelComboBox.addElement(h.getMaHangSanXuat());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
