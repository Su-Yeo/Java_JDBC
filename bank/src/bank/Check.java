package bank;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Check extends JFrame implements ActionListener{
	JButton btn1;   
	JButton btn2;
	Member loginMember;
	   
	   public Check(Member loginMember){
	      this.loginMember = loginMember;
	      setLayout(null);
	      JPanel pan = new JPanel();
	      pan.setLayout(new GridLayout(8,2));
	      pan.setBounds(10,10, 420, 195);
	      add(pan);
	      
	      JLabel[] lbl = new JLabel[8];
	      btn1 = new JButton("Ȯ��");
	      btn2 = new JButton("ȸ������ ����");
	      btn1.setBounds(80,205,130,50);
	      btn2.setBounds(230,205,130,50);
	      JTextField[] text = new JTextField[8];
	      String name[] = {"�̸�", "��й�ȣ","���¹�ȣ", "�ܾ�", "��ݰ��ɱݾ�", "���", "Point"};
	      
	      for (int i = 0; i < lbl.length-1; i++) {
	         lbl[i] = new JLabel(name[i]);
	         text[i] = new JTextField(10);
	         
	         pan.add(lbl[i]);
	         pan.add(text[i]);
	         add(btn1);
	         add(btn2);
	         text[i].setEditable(false);
	      }
	      text[0].setText(loginMember.getName());
	      text[1].setText(loginMember.getPw());
	      text[2].setText(loginMember.getAccount());
	      text[3].setText(loginMember.getMoney()+"");
	      text[4].setText(loginMember.getMoney()+"");
	      text[5].setText(loginMember.getLev());
	      text[6].setText(loginMember.getPoint()+"");
	      btn1.addActionListener(this);
	      btn2.addActionListener(this);
	      setTitle("�� ������ȸ");
	      setBounds(300, 250, 450, 300);
	      setVisible(true);
	      setResizable(false);
	   }

	   @Override
		public void actionPerformed(ActionEvent e) {
			Object eBtn = e.getSource();
			if(eBtn == btn1)
				dispose();
			
			if(eBtn == btn2)
				eBtn = new Update(loginMember);
				dispose();
		}
}
