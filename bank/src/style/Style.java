package style;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Style {

	public Style(JLabel lbl) {
		Font font=new Font("���� ���", Font.BOLD, 15);
		lbl.setFont(font);
		//lbl.setForeground(new Color(0, 185, 142)); //��Ʈ ����
		lbl.setOpaque(true); //label�� ���� �����Ҷ� �����
		//lbl.setBackground(Color.WHITE); //������
		//lbl.setForeground(Color.WHITE); //��Ʈ ���� 86%, G 187%, B 182%
		//lbl.setBackground(new Color(184, 219, 253)); //������
	}
	public Style(JTextField j) {
		Font font=new Font("���� ���", Font.BOLD, 15);
		j.setFont(font);
	}
	public Style(JButton j) {
		Font font=new Font("���� ���", Font.BOLD, 20);
		j.setFont(font);
		//j.setForeground(Color.WHITE); //��Ʈ ���� 86%, G 187%, B 182%
		//j.setBackground(new Color(184, 219, 253)); //������
	}
	
	public Style(int w, int h, JFrame j) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dm = t.getScreenSize();
		int sw=dm.width;
		int sh=dm.height;
		//��ũ�� �߾� ���
		int x=(int)(0.5*(sw-w)); //�켱���� ������ ��� ���� �� ����ȯ
		int y=(int)(0.5*(sh-h));
		j.setBounds(x, y, w, h);
		//j.getContentPane().setBackground(new Color(184, 219, 253)); //������
	}
	
}
