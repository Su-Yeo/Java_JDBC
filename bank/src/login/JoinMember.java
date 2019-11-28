
//구현: 김승현
package login;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bank.Member;
import style.Style;
//정보 등록
public class JoinMember extends JFrame implements ActionListener{
	private Member[] MemberArr;
	private Member newMember;
	private JLabel alert_Label;
	JTextField[] TextField = new JTextField[5];
	
	 public JoinMember(Member[] arr){
		  MemberArr=arr;
	      setLayout(null);
	      JPanel pan = new JPanel(new GridLayout(5,2));
	      JLabel[] lbl = new JLabel[5];
	      JButton btn = new JButton("가입");
	      alert_Label = new JLabel();
	      add(pan);
	      add(alert_Label);
	      pan.setBounds(10,10, 420, 150);
	      btn.setBounds(250,170,130,50);
	      alert_Label.setBounds(10, 170,250,30);
	      String name[] = {"ID", "비밀번호", "이름", "계좌번호", "금액"};
	      
	      for (int i = 0; i < lbl.length; i++) {
	         lbl[i] = new JLabel(name[i]);
	         TextField[i] = new JTextField();
	         pan.add(lbl[i]);
	         pan.add(TextField[i]);
	         new Style(lbl[i]);
	      }
	      add(btn);
	      new Style(btn);
	      btn.addActionListener(this);
	      setTitle("회원가입");
	      //setBounds(300, 250, 450, 270);
	      new Style(450, 270, this);
	      setVisible(true);
	      setResizable(false);
	   }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			newMember=new Member(); 
			boolean flag1=true;
			boolean flag2=true;
			if(TextField[0].getText().equals("") || TextField[1].getText().equals("")) { //아이디, 비번 판별
				new JoinMember2();
				dispose();
			}
	
			if(TextField[3].getText().length()!=5) { //계좌번호 5자리 판별
				new JoinMember1();
				dispose();
			}else {
				for(int i=0; i<MemberArr.length; i++) {
					if(MemberArr[i] != null) {
						if(MemberArr[i].getId().equals(TextField[0].getText())) {
							alert_Label.setText("아이디가 이미 존재합니다.");
							flag1=false;
							break;
						}
						if(MemberArr[i].getAccount().equals(TextField[3].getText())) {
							alert_Label.setText("계좌번호가 이미 존재합니다.");
							flag2=false;
							break;
						}
					}
					break;
				}
				if(flag1 && flag2) {
					newMember.setId(TextField[0].getText());
					newMember.setPw(TextField[1].getText());
					newMember.setName(TextField[2].getText());
					newMember.setAccount(TextField[3].getText());
					newMember.setMoney(Integer.parseInt(TextField[4].getText()));
					newMember.setLev("일반");
					for(int i=0; i<MemberArr.length;  i++) {
						if(MemberArr[i]==null) {
							MemberArr[i]=newMember;
							new JoinMemberRes();
							dispose();
							break;
						}
					}	
				}
			}
		}catch(Exception e1) {
			e1.getMessage();
		}
	}	
}
