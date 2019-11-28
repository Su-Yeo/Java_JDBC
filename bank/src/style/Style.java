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
		Font font=new Font("맑은 고딕", Font.BOLD, 15);
		lbl.setFont(font);
		//lbl.setForeground(new Color(0, 185, 142)); //폰트 색상
		lbl.setOpaque(true); //label만 배경색 설정할때 써야함
		//lbl.setBackground(Color.WHITE); //배경색상
		//lbl.setForeground(Color.WHITE); //폰트 색상 86%, G 187%, B 182%
		//lbl.setBackground(new Color(184, 219, 253)); //배경색상
	}
	public Style(JTextField j) {
		Font font=new Font("맑은 고딕", Font.BOLD, 15);
		j.setFont(font);
	}
	public Style(JButton j) {
		Font font=new Font("맑은 고딕", Font.BOLD, 20);
		j.setFont(font);
		//j.setForeground(Color.WHITE); //폰트 색상 86%, G 187%, B 182%
		//j.setBackground(new Color(184, 219, 253)); //배경색상
	}
	
	public Style(int w, int h, JFrame j) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dm = t.getScreenSize();
		int sw=dm.width;
		int sh=dm.height;
		//스크린 중앙 계산
		int x=(int)(0.5*(sw-w)); //우선순위 때문에 계산 먼저 후 형변환
		int y=(int)(0.5*(sh-h));
		j.setBounds(x, y, w, h);
		//j.getContentPane().setBackground(new Color(184, 219, 253)); //배경색상
	}
	
}
