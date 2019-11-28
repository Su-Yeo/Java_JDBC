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
		setTitle("대출");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JLabel lbl = new JLabel("대출 금액 : ");
		tf= new JTextField(15);
		JButton btn1=new JButton("대출");
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
		System.out.println("대출 - 총금액 : "+money);
		new ShowInfo(loginMember,"대출",m);
	}
	
	public void NoLoan(){
		new ShowInfo(loginMember, "대출불가");
		System.out.println("대출불가 - 현재레벨 : "+loginMember.getLev());
	}
	
	@Override
	public void action() {
		//일반:대출 불가, 브론즈 :100000, 실버 :1000000, 골드 :1000000, 플레티넘:무제한
		long m;
		long m2=loginMember.getMoney();
		String lev = loginMember.getLev();
		try {
			m = Integer.parseInt(tf.getText());
		} catch (Exception e) {
			m=0;
			lev="대출취소";
		}
		switch (lev) {
		case "일반":
				NoLoan();
			break;
		case "브론즈":
			if(m<=100000){
				YesLoan(m ,m2);
			}else{
				NoLoan();
			}
			break;
		case "실버":
			if(m<=1000000){
				YesLoan(m ,m2);
			}else{
				NoLoan();
			}
			break;
		case "골드":
			if(m<=1000000){
				YesLoan(m ,m2);
			}else{
				NoLoan();
			}
			break;
		case "플레티넘":
			YesLoan(m ,m2);
			break;
		default:
			new RSPAlert("대출 취소");
			break;
		}
		dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		action();
	}

}
