package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.RSPAlert;
import style.Style;

public class Loan extends JFrame implements Banking,ActionListener {
	Member loginMember;
	JTextField tf;
	
	public Loan(Member loginMember) {
		this.loginMember = loginMember;
		setTitle("����");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JLabel lbl = new JLabel("���� �ݾ� : ");
		tf= new JTextField(15);
		JButton btn1=new JButton("����");
		new Style(lbl);
		add(pan1,"North");
		add(pan2,"South");
		pan1.add(lbl);
		pan1.add(tf);
		pan2.add(btn1);
		btn1.addActionListener(this);
		//setBounds(100, 150, 400, 300);
		new Style(400, 150, this);
		setVisible(true);
	}
	public void YesLoan(long m, long m2){
		long money = m+m2;
		loginMember.setMoney(money);
		System.out.println("���� - �ѱݾ� : "+money);
		new ShowInfo(loginMember,"����",m);
	}
	
	public void NoLoan(){
		new ShowInfo(loginMember, "����Ұ�");
		System.out.println("����Ұ� - ���緹�� : "+loginMember.getLev());
	}
	
	@Override
	public void action() {
		//�Ϲ�:���� �Ұ�, ����� :100000, �ǹ� :1000000, ��� :1000000, �÷�Ƽ��:������
		long m;
		long m2=loginMember.getMoney();
		String lev = loginMember.getLev();
		try {
			m = Integer.parseInt(tf.getText());
		} catch (Exception e) {
			m=0;
			lev="�������";
		}
		switch (lev) {
		case "�Ϲ�":
				NoLoan();
			break;
		case "�����":
			if(m<=100000){
				YesLoan(m ,m2);
			}else{
				NoLoan();
			}
			break;
		case "�ǹ�":
			if(m<=1000000){
				YesLoan(m ,m2);
			}else{
				NoLoan();
			}
			break;
		case "���":
			if(m<=1000000){
				YesLoan(m ,m2);
			}else{
				NoLoan();
			}
			break;
		case "�÷�Ƽ��":
			YesLoan(m ,m2);
			break;
		default:
			new RSPAlert("���� ���");
			break;
		}
		dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		action();
	}

}
