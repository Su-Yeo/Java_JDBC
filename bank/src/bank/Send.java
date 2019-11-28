//2018-06-01 22:40 cording by ChoiWoojung
package bank;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Send extends JFrame implements Banking, ActionListener {
	private Member loginMember;
	private Member MemberArr[];
	private JLabel aNumber_Label = new JLabel("계좌번호 : ");;
	private JLabel Money_Label = new JLabel("잔액 : ");;
	private JTextField aNumber_Text;
	private JTextField Money_Text;
	private JLabel rev_Money_Label = new JLabel("보낼 금액 : ");
	private JTextField rev_Money_Text = new JTextField();
	private JLabel rev_aNumber_Label = new JLabel("받는 분 계좌 번호 : ");
	private JTextField rev_aNumber_Text = new JTextField();
	private JButton submit_Btn = new JButton("보내기");
	
	public Send(Member[] MemberArr, Member loginMember) {
		this.loginMember = loginMember;
		this.MemberArr = MemberArr;
		
		setLayout(null);
		
		aNumber_Text= new JTextField(loginMember.getAccount());
		Money_Text = new JTextField(loginMember.getMoney()+"");
		aNumber_Text.setEditable(false);
		Money_Text.setEditable(false);
		
		aNumber_Label.setBounds(20, 0, 65, 30);
		aNumber_Text.setBounds(85, 0, 100, 30);
		Money_Label.setBounds(220, 0, 40, 30);
		Money_Text.setBounds(260, 0, 100, 30);
		
		
		rev_Money_Label.setBounds(35, 55, 125, 30);
		rev_Money_Text.setBounds(125, 55, 150, 30);
		rev_aNumber_Label.setBounds(10, 115, 125, 30);
		rev_aNumber_Text.setBounds(125, 115, 150, 30);
		submit_Btn.setBounds(285, 55, 90, 90);
		
		add(aNumber_Label);
		add(aNumber_Text);
		add(Money_Label);
		add(Money_Text);
		add(rev_aNumber_Label);
		add(rev_aNumber_Text);
		add(rev_Money_Label);
		add(rev_Money_Text);
		add(submit_Btn);
		
		submit_Btn.addActionListener(this);
		
		setTitle("송금");
		setBounds(200, 300, 400, 200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		action();
	}

	@Override
	public void action() {
		if (rev_Money_Text.getText().equals("") || rev_aNumber_Text.getText().equals("")) {
			new SendAlert("금액과 계좌번호를 입력해주세요");
			return;
		}
		
		long sendMoney = Integer.parseInt(rev_Money_Text.getText());
		
		if(sendMoney<100){
			new SendAlert("송금 실패! 100원 이상부터 송금가능합니다.");
			return;
		}
		
		long ownMoney= loginMember.getMoney();
		String aNumber = "";
		String rev_aNumber = "";
		String rev_Name = "";
		Member rev_Member = MemberArr[0];
		long rev_Money = 0;
			for (int i = 0; i<MemberArr.length; i++) {
				if (MemberArr[i] == null)
					break;
				rev_Member = MemberArr[i];
				aNumber = rev_Member.getAccount();
				rev_aNumber = rev_aNumber_Text.getText();
				if (aNumber.equals(rev_aNumber)) {
					rev_Money = rev_Member.getMoney();
					rev_Name = rev_Member.getName();
					break;
				}
			}
			
			if (!aNumber.equals(rev_aNumber)) {
				new SendAlert("송금 실패! 계좌번호를 확인해주세요");
				return;
			}
			
			if(ownMoney<sendMoney){
				new SendAlert("송금 실패! 잔액을 확인해주세요");
				return;
			}
			
			ownMoney -= sendMoney;
			
			loginMember.setMoney(ownMoney);
			Money_Text.setText(loginMember.getMoney()+"");
			rev_Member.setMoney(rev_Money+sendMoney);
			new SendAlert(rev_Name+"님에게 "+sendMoney+"원을 보냈습니다.");
	}

}
