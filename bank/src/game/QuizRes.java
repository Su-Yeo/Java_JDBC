
//±¸Çö: ±è½ÂÇö
package game;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bank.Member;

public class QuizRes extends JFrame {
	
	
	public QuizRes(Member member, int point, String result) {
		String name=member.getName();
		JLabel text=new JLabel(result + "  " + name + "´Ô ÀÇÆ÷ÀÎÆ®: " + point);
		JPanel pan = new JPanel();
		member.setPoint(point);
//		new ChangeLev(member);
		add(pan);
		pan.add(text);
		setTitle("Quiz°á°ú");
		setBounds(200, 300, 400, 150);
		setVisible(true);
		setResizable(false);
	}
}
