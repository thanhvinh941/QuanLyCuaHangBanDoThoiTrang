package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import org.hibernate.SessionFactory;

import com.toedter.calendar.demo.JCalendarDemo;

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

public class CapNhatSanPham extends JFrame {
	private JPanel contentPane;
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private JComboBox cboLoai;
	private JTextField txtMaSP;
	private JTextField txtGia;
	private JTextField txtSL;
	private JComboBox cboMau;
	private JComboBox cboSize;
	private JComboBox cboHSX;
	private JTextField txtTenSP;
	private JLabel lblTenHSX;
	private JLabel lblTenLoai;
	private DefaultComboBoxModel modelComboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatSanPham frame = new CapNhatSanPham();
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
	public CapNhatSanPham() {
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T??n s???n ph???m");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 130, 130, 25);
		contentPane.add(lblNewLabel);
		
		txtTenSP = new JTextField();
		txtTenSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenSP.setBounds(150, 130, 467, 25);
		contentPane.add(txtTenSP);
		txtTenSP.setColumns(10);
		
		JLabel lblSCmnd = new JLabel("Lo???i s???n ph???m");
		lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSCmnd.setBounds(10, 180, 130, 25);
		contentPane.add(lblSCmnd);
		
		JLabel lblNewLabel_2 = new JLabel("C???p nh???t s???n ph???m");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(10, 0, 477, 60);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("H??ng s???n xu???t");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 230, 130, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Size:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 280, 130, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("M??u s???c");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 330, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("S??? l?????ng");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 380, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JCalendarDemo calendarDemo = new JCalendarDemo();
		calendarDemo.setBounds(150, 345, 337, -14);
		contentPane.add(calendarDemo);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Gi?? s???n ph???m");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 430, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JButton btnCapNhat = new JButton("C???p nh???t");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maSP = txtMaSP.getText();
				String tenSP = txtTenSP.getText();
				String loai = String.valueOf(cboLoai.getSelectedItem());
				LoaiSanPham loaiSP = new LoaiSanPham(loai);
				String hsx = String.valueOf(cboHSX.getSelectedItem());
				HangSanXuat hang = new HangSanXuat(hsx);
				String size = String.valueOf(cboSize.getSelectedItem());
				String mau = String.valueOf(cboMau.getSelectedItem());
				int sl = Integer.parseInt(txtSL.getText());
				double gia = Double.parseDouble(txtGia.getText());
	
				SanPhamDAO sanphamDAO = null;
				try {
					sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
				} catch (MalformedURLException | RemoteException | NotBoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					SanPham sp = new SanPham(maSP, tenSP, gia, size, mau, sl, hang, loaiSP);
					try {
						boolean rs = sanphamDAO.capNhatSanPham(sp);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						if(sanphamDAO.capNhatSanPham(sp)) {
							JOptionPane.showMessageDialog(rootPane, "C??????p nh??????t th????ng tin kha?????ch ha?????ng tha?????nh c????ng");
						} else 
							JOptionPane.showMessageDialog(rootPane, "C??????p nh??????t th????ng tin kh????ch h????ng kh????ng tha?????nh c????ng");
					} catch (HeadlessException | RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			
			}
		});
		btnCapNhat.setIcon(new ImageIcon(CapNhatSanPham.class.getResource("/img/icons8_update_40px_2.png")));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhat.setBounds(39, 495, 230, 50);
		contentPane.add(btnCapNhat);
		
		JButton btnThot = new JButton("Tho??t");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				GDChucNangQLSanPham gui = null;
				try {
					gui = new GDChucNangQLSanPham();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gui.setVisible(true);
			}
		});
		btnThot.setIcon(new ImageIcon(ThemKhachHang.class.getResource("/img/cancel.png")));
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThot.setBounds(363, 495, 190, 50);
		contentPane.add(btnThot);
		
		cboHSX = new JComboBox();
		cboHSX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HangSanXuatDAO hsxDAO = null;
				try {
					hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
				} catch (MalformedURLException | RemoteException | NotBoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String nhap = cboHSX.getSelectedItem().toString();
				HangSanXuat hsx = null;
				try {
					hsx = hsxDAO.layHangSanXuatTheoMa(nhap);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblTenHSX.setText(hsx.getTenHangSanXuat());
			}
		});
		cboHSX.setEditable(true);
		cboHSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboHSX.setBounds(150, 230, 170, 25);
		contentPane.add(cboHSX);
		
		cboSize = new JComboBox();
		cboSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSize.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L", "XL", "XXL", "XXXL"}));
		cboSize.setBounds(150, 280, 170, 25);
		contentPane.add(cboSize);
		
		cboMau = new JComboBox();
		cboMau.setEditable(true);
		cboMau.setModel(new DefaultComboBoxModel(new String[] {"??en ", "Tr???ng ", "?????", "Xanh D????ng", "Xanh L??", "Cam", "V??ng", "Tr??m ", "T??m", "N??u"}));
		cboMau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboMau.setBounds(150, 330, 170, 25);
		contentPane.add(cboMau);
		
		txtSL = new JTextField();
		txtSL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSL.setColumns(10);
		txtSL.setBounds(150, 380, 170, 25);
		contentPane.add(txtSL);
		
		txtGia = new JTextField();
		txtGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGia.setColumns(10);
		txtGia.setBounds(150, 430, 467, 25);
		contentPane.add(txtGia);
		
		JLabel lblMSnPhm_1 = new JLabel("M?? s???n ph???m");
		lblMSnPhm_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMSnPhm_1.setBounds(10, 80, 130, 25);
		contentPane.add(lblMSnPhm_1);
		
		txtMaSP = new JTextField();
		txtMaSP.setEditable(false);
		txtMaSP.setEnabled(false);
		txtMaSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(150, 80, 467, 25);
		contentPane.add(txtMaSP);
		
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
		cboLoai.setBounds(150, 180, 170, 25);
		contentPane.add(cboLoai);
		
		lblTenLoai = new JLabel("");
		lblTenLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenLoai.setBounds(330, 180, 138, 25);
		contentPane.add(lblTenLoai);
		
		lblTenHSX = new JLabel("");
		lblTenHSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenHSX.setBounds(330, 230, 138, 25);
		contentPane.add(lblTenHSX);
		
		showComboBox();
		showComboBoxHSX();
	}
	
	public void showData(String maSP) {
		SanPhamDAO sanphamDAO = null;
		try {
			sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SanPham sp = null;
		try {
			sp = sanphamDAO.laySanPhamTheoMa(maSP);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtMaSP.setText(maSP);
        txtTenSP.setText(sp.getTenSanPham());
        cboLoai.setSelectedItem(sp.getLoaiSanPham().getMaLoaiSanPham());
        lblTenLoai.setText(sp.getLoaiSanPham().getTenLoai());
        cboHSX.setSelectedItem(sp.getHangSanXuat().getMaHangSanXuat());
        lblTenHSX.setText(sp.getHangSanXuat().getTenHangSanXuat());
        cboSize.setSelectedItem(sp.getKichThuoc());
        cboMau.setSelectedItem(sp.getMauSac());
        txtSL.setText(String.valueOf(sp.getSoLuong()));
        txtGia.setText(String.valueOf(sp.getGiaSanPham()));		
             
    }
	
	public void showComboBox() {
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
