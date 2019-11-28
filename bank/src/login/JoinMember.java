
//����: �����
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
//���� ���
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
	      JButton btn = new JButton("����");
	      alert_Label = new JLabel();
	      add(pan);
	      add(alert_Label);
	      pan.setBounds(10,10, 420, 150);
	      btn.setBounds(250,170,130,50);
	      alert_Label.setBounds(10, 170,250,30);
	      String name[] = {"ID", "��й�ȣ", "�̸�", "���¹�ȣ", "�ݾ�"};
	      
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
	      setTitle("ȸ������");
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
			if(TextField[0].getText().equals("") || TextField[1].getText().equals("")) { //���̵�, ��� �Ǻ�
				new JoinMember2();
				dispose();
			}
	
			if(TextField[3].getText().length()!=5) { //���¹�ȣ 5�ڸ� �Ǻ�
				new JoinMember1();
				dispose();
			}else {
				for(int i=0; i<MemberArr.length; i++) {
					if(MemberArr[i] != null) {
						if(MemberArr[i].getId().equals(TextField[0].getText())) {
							alert_Label.setText("���̵� �̹� �����մϴ�.");
							flag1=false;
							break;
						}
						if(MemberArr[i].getAccount().equals(TextField[3].getText())) {
							alert_Label.setText("���¹�ȣ�� �̹� �����մϴ�.");
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
					newMember.setLev("�Ϲ�");
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
