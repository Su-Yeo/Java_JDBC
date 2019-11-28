package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import style.Style;

public class Output extends JFrame implements Banking, ActionListener{
	Member loginMember;
	JTextField tf;
	JLabel lbl2;
	
	public Output(Member loginMember) {
		this.loginMember = loginMember;
		setTitle("���");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JLabel lbl = new JLabel("��� �ݾ� : ");
		tf= new JTextField(15);
		new Style(tf);
		new Style(lbl);
		JButton btn1=new JButton("Ȯ��");
		lbl2 = new JLabel();
		add(pan1,"North");
		add(pan2,"South");
		add(pan3,"Center");
		pan1.add(lbl);
		pan1.add(tf);
		pan2.add(btn1);
		pan3.add(lbl2);
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
		if(m2>=m){
			long money = m2-m;
			loginMember.setMoney(money);
			System.out.println("��� - �ѱݾ� : "+money);
			new ShowInfo(loginMember,"���",m);
		}else{
			new ShowInfo(loginMember, "�ܾ׺���");
			System.out.println("�ܾ׺��� - �ѱݾ� : "+m2);
		}
		dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		action();
	}
}
