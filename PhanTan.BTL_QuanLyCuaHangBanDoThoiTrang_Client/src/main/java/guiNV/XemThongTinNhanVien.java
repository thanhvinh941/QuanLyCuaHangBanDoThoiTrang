package guiNV;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

import gui.QuanLyThongKe;

public class XemThongTinNhanVien extends JPanel {

	/**
	 * Create the panel.
	 */
	public XemThongTinNhanVien() {
		setBackground(Color.WHITE);
		setBounds(240, 0, 1298, 816);
	
		setLayout(null);
		
		JLabel lblQunLThng = new JLabel("Thông tin nhân viên");
		lblQunLThng.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQunLThng.setBounds(10, 20, 358, 60);
		add(lblQunLThng);
		

	}

}
