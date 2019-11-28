package bank;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import style.Style;

public class Input extends JFrame implements Banking, ActionListener{
	Member loginMember;
	JTextField tf;
	
	public Input(Member loginMember) {
		this.loginMember = loginMember;
		setTitle("입금");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JLabel lbl = new JLabel("입금 금액 : ");
		tf= new JTextField(15);
		new Style(tf);
		new Style(lbl);
		JButton btn1=new JButton("확인");
		add(pan1,"North");
		add(pan2,"South");
		pan1.add(lbl);
		pan1.add(tf);
		pan2.add(btn1);
		btn1.addActionListener(this);
		new Style(400, 150, this);
		setVisible(true);
	}

	@Override
	public void action() {
		long m;
		try {
			m = Integer.parseInt(tf.getText());
		} catch (Exception e) {
			m=0;
		}
		long m2=loginMember.getMoney();
		long money = m+m2;
		loginMember.setMoney(money);
		System.out.println("입금 - 총금액 : "+money);
		new ShowInfo(loginMember,"입금",m);
		dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		action();
	}
	
	
}
