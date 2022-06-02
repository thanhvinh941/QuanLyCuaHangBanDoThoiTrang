package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.SessionFactory;
import org.hibernate.event.internal.DirtyCollectionSearchVisitor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.demo.JCalendarDemo;

import dao.GenerateKeyDAO;
import dao.KhachHangDAO;
import entity.KhachHang;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CapNhatKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtThanhPho;

	
	SimpleDateFormat df;
	private JDateChooser dateChooser;
	private JComboBox cboGioiTinh;
	private JTextField txtMaKH;
	private JLabel lblMaKH;
	private JLabel lblLoi;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemKhachHang frame = new ThemKhachHang();
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
	public CapNhatKhachHang() {
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên khách hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 130, 130, 25);
		contentPane.add(lblNewLabel);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenKH.setBounds(150, 130, 337, 25);
		contentPane.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblSCmnd = new JLabel("Số CMND");
		lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSCmnd.setBounds(10, 180, 130, 25);
		contentPane.add(lblSCmnd);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCMND.setColumns(10);
		txtCMND.setBounds(150, 180, 337, 25);
		contentPane.add(txtCMND);
		
		JLabel lblNewLabel_2 = new JLabel("Cập nhật khách hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(10, 0, 477, 60);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 230, 130, 25);
		contentPane.add(lblNewLabel_1_1);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(150, 230, 337, 25);
		contentPane.add(txtSDT);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 280, 130, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(150, 280, 337, 25);
		contentPane.add(txtDiaChi);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Thành phố");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 330, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txtThanhPho = new JTextField();
		txtThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtThanhPho.setColumns(10);
		txtThanhPho.setBounds(150, 330, 337, 25);
		contentPane.add(txtThanhPho);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 380, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JCalendarDemo calendarDemo = new JCalendarDemo();
		calendarDemo.setBounds(150, 345, 337, -14);
		contentPane.add(calendarDemo);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(150, 380, 337, 25);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 430, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		cboGioiTinh = new JComboBox();
		cboGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cboGioiTinh.setBounds(150, 430, 110, 25);
		contentPane.add(cboGioiTinh);
		
		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validData();
				kiemtraUpdate();
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/img/updateKH.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(30, 521, 190, 50);
		contentPane.add(btnNewButton);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				//GiaoDienChinh_ChuCuaHang gui = null;
				/*try {
					gui = new GiaoDienChinh_ChuCuaHang();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				QuanLyKhachHang qlkh = new QuanLyKhachHang();*/
				//QuanLyBanHang qlkh = new QuanLyBanHang();
				//qlkh.setVisibleTrang(true);
				//gui.setVisible(true);
				//gui.giaoDien(qlkh);
				//qlkh.layMaKH_Update(txtMaKH.getText());
				//qlkh.xoaHetDuLieuTrenTableModel();
				//qlkh.showTable();
				//setVisible(false);
				
			}
		});
		btnThot.setIcon(new ImageIcon(ThemKhachHang.class.getResource("/img/cancel.png")));
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThot.setBounds(280, 521, 190, 50);
		contentPane.add(btnThot);
		
		lblMaKH = new JLabel("Mã khách hàng");
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaKH.setBounds(10, 80, 130, 25);
		contentPane.add(lblMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setEnabled(false);
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(150, 80, 337, 25);
		contentPane.add(txtMaKH);
		
		lblLoi = new JLabel("");
		lblLoi.setForeground(Color.RED);
		lblLoi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLoi.setBounds(10, 476, 477, 13);
		contentPane.add(lblLoi);
	}
	
	public void showData(String maKH) throws MalformedURLException, RemoteException, NotBoundException {
		KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");

		KhachHang kh = khachHangDAO.layKhachHangTheoMa(maKH);
		txtMaKH.setText(maKH);
        txtTenKH.setText(kh.getTenKhachHang());
        txtSDT.setText(kh.getSoDienThoai());
        txtCMND.setText(kh.getSoCMND());
        txtDiaChi.setText(kh.getDiaChi());
        txtThanhPho.setText(kh.getThanhPho());
        cboGioiTinh.setSelectedItem(kh.isGioiTinh());
        
        Date date;
        df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse( df.format(kh.getNgaySinh()) );
			dateChooser.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
             
    }
	
	public String layMa(String ma) {
		return ma;
	}
	
	public void showTableAfterUpdate() {
		
	}
	
	public boolean kiemtraUpdate() {
		String maKH = txtMaKH.getText();
		String tenKH = txtTenKH.getText();
		//String gioiTinh =  cboGioiTinh.getSelectedItem().toString();
		
		//Boolean gioiTinh = Boolean.parseBoolean(cboGioiTinh.getSelectedItem().toString());
		boolean gioiTinh = true;
		if(cboGioiTinh.getSelectedItem().equals("Nam"))
			gioiTinh = false;
		String cmnd = txtCMND.getText();
		String sdt  = txtSDT.getText();
		String diaChi = txtDiaChi.getText();
		String thanhPho = txtThanhPho.getText();
		Date ngaySinh = dateChooser.getDate();
		//String ngaySinh = txtNgaySinh.getText();
		
		df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			KhachHang kh = new KhachHang(maKH, tenKH, cmnd, sdt, diaChi, thanhPho, ngaySinh, gioiTinh);
			boolean rs = khachHangDAO.capNhatKhachHang(kh);
			if(khachHangDAO.capNhatKhachHang(kh)) {
				JOptionPane.showMessageDialog(rootPane, "Cập nhật khách hàng thành công");
				return true;
			} else 
				JOptionPane.showMessageDialog(rootPane, "Cập nhật khách hàng không thành công");
				return false;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}
	
	public boolean kiemtraThoat() {
		boolean rs = true;
		
		return true;
	}
	
	private boolean validData() {
		String tenKH = txtTenKH.getText().trim();
		java.sql.Date ns;
		ns = new java.sql.Date(System.currentTimeMillis());
		String sdt = txtSDT.getText().trim();
		String cmnd = txtCMND.getText().trim();
		String dc = txtDiaChi.getText().trim();
		String tp = txtThanhPho.getText().trim();
		Date ngaySinh = dateChooser.getDate();

		if (!(tenKH.length() > 0)) {
			/*showMessage(
					"Error: TÄ‚Âªn khÄ‚Â¡ch hÄ‚Â ng khÄ‚Â´ng Ă„â€˜Ă†Â°Ă¡Â»Â£c bĂ¡Â»ï¿½ trĂ¡Â»â€˜ng",
					txtTenKH);*/
			lblLoi.setText("Error: TÄ‚Âªn khÄ‚Â¡ch hÄ‚Â ng khÄ‚Â´ng Ă„â€˜Ă†Â°Ă¡Â»Â£c bĂ¡Â»ï¿½ trĂ¡Â»â€˜ng");
			txtTenKH.requestFocus();
			txtTenKH.selectAll();
			return false;
		}
		if (!((sdt.length() > 0 || sdt.length() == 0) && (sdt.matches("[0-9]{10}") || sdt.matches("[0-9]{11}") ) )) {
			/*showMessage("Error: Sai cù€ï¿½ phà€ï¿½p! SÄ‚Â´̀€ï¿½ Ă„â€˜iÄ‚Âª̀€Â£n thoà€Â£i phà€â€°i nhÄ‚Â¢̀€Â£p theo mĂ¡ÂºÂ«u: GÄ‚Â´̀€â‚¬m 10 hoĂ¡ÂºÂ·c 11 chĂ†Â°̀€Æ’ sÄ‚Â´̀€ï¿½",
					txtSDT);*/
			lblLoi.setText("Error: Sai cù€ï¿½ phà€ï¿½p! SÄ‚Â´̀€ï¿½ Ă„â€˜iÄ‚Âª̀€Â£n thoà€Â£i phà€â€°i nhÄ‚Â¢̀€Â£p theo mĂ¡ÂºÂ«u: GÄ‚Â´̀€â‚¬m 10 hoĂ¡ÂºÂ·c 11 chĂ†Â°̀€Æ’ sÄ‚Â´̀€ï¿½");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}
		if (!(cmnd.length() >= 0 && (cmnd.matches("[0-9]{12}") || cmnd.matches("[0-9]{9}")))) {
			/*showMessage("Error: Sai cù€ï¿½ phà€ï¿½p! MÄ‚Â£ sÄ‚Â¡ch phà€â€°i nhÄ‚Â¢̀€Â£p theo mĂ¡ÂºÂ«u: gÄ‚Â´̀€â‚¬m 12 chĂ†Â°̀€Æ’ sÄ‚Â´̀€ï¿½", txtCMND);*/
			lblLoi.setText("Error: Sai cù€ï¿½ phà€ï¿½p! MÄ‚Â£ sÄ‚Â¡ch phà€â€°i nhÄ‚Â¢̀€Â£p theo mĂ¡ÂºÂ«u: gÄ‚Â´̀€â‚¬m 12 chĂ†Â°̀€Æ’ sÄ‚Â´̀€ï¿½");
			txtCMND.requestFocus();
			txtCMND.selectAll();
			return false;
		}
		if (!(tp.length() > 0)) {
			/*showMessage("Error: Sai cù€ï¿½ phà€ï¿½p! Thà€â‚¬nh phÄ‚Â´̀€ï¿½ phà€â€°i nhÄ‚Â¢̀€Â£p theo mĂ¡ÂºÂ«u: GÄ‚Â´̀€â‚¬m dà€Æ’y cà€ï¿½c chĂ†Â°̀€Æ’ cà€ï¿½i",
					txtThanhPho);*/
			lblLoi.setText("Error: Sai cù€ï¿½ phà€ï¿½p! Thà€â‚¬nh phÄ‚Â´̀€ï¿½ phà€â€°i nhÄ‚Â¢̀€Â£p theo mĂ¡ÂºÂ«u: GÄ‚Â´̀€â‚¬m dà€Æ’y cà€ï¿½c chĂ†Â°̀€Æ’ cà€ï¿½i");
			txtThanhPho.requestFocus();
			txtThanhPho.selectAll();
			return false;
		}
		if(ngaySinh == null) {
			lblLoi.setText("LĂ¡Â»â€”i: NgÄ‚Â y sinh khÄ‚Â´ng Ă„â€˜Ă†Â°Ă¡Â»Â£c Ă„â€˜Ă¡Â»Æ’ trĂ¡Â»â€˜ng!");
			dateChooser.requestFocus();

		}

		return true;
	}
	
}