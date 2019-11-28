package bank;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update extends JFrame implements ActionListener{
	JButton btn1 = new JButton("Ȯ��");
	JButton btn2 = new JButton("���");
	JLabel[] lbl = new JLabel[8];
	JLabel Grade1 = new JLabel("        0 : �Ϲ� 500 : ����� 1000 : �ǹ�");
	JLabel Grade2 = new JLabel(" 1500 : ��� 2000 : �÷�Ƽ��");
	JPanel pan = new JPanel();
	JTextField[] text = new JTextField[8];
	Member loginMember;
	
	public Update(Member loginMember){
		this.loginMember = loginMember;
	      setLayout(null);
	      pan.setLayout(new GridLayout(9,2));
	      pan.setBounds(10,10, 420, 195);
	      add(pan);
	            
	      btn1.setBounds(80,205,130,50);
	      btn2.setBounds(230,205,130,50);
	      String name[] = {"�̸�", "��й�ȣ","���¹�ȣ", "�ܾ�", "��ݰ��ɱݾ�", "���", "Point"};
	      
	      for (int i = 0; i < lbl.length-1; i++) {
	         lbl[i] = new JLabel(name[i]);
	         text[i] = new JTextField(10);
	         
	         pan.add(lbl[i]);
	         pan.add(text[i]);
	         pan.add(Grade1);
	         pan.add(Grade2);
	         add(btn1);
	         add(btn2);
	      }
	      text[0].setEditable(false);
	      text[2].setEditable(false);
	      text[4].setEditable(false);
	      text[5].setEditable(false);
	      text[0].setText(loginMember.getName());
	      text[1].setText(loginMember.getPw());
	      text[2].setText(loginMember.getAccount());
	      text[3].setText(loginMember.getMoney()+"");
	      text[4].setText(loginMember.getMoney()+"");
	      text[5].setText(loginMember.getLev());
	      text[6].setText(loginMember.getPoint()+"");
	      btn1.addActionListener(this);
	      btn2.addActionListener(this);
	      
		  setTitle("ȸ������ ����");
		  setBounds(300, 250, 450, 300);
		  setVisible(true);
		  setResizable(false);
		}

		@Override
		 public void actionPerformed(ActionEvent e) {    	
	    	Object eBtn = e.getSource();
	    	
	    	String NumStr = text[6].getText();
	    	int NumInt = Integer.parseInt(NumStr);
	    	
			if(eBtn == btn1) {
		    	if(NumInt <= 499)
		    		text[5].setText("�Ϲ�");
		    	else if(NumInt <= 999)
		    		text[5].setText("�����");
		    	else if(NumInt <= 1499)
		    		text[5].setText("�ǹ�");
		    	else if(NumInt <= 1999)
		    		text[5].setText("���");
		    	else
		    		text[5].setText("�÷�Ƽ��");
		    	
				loginMember.setPw(text[1].getText());
	    		loginMember.setMoney(Integer.parseInt(text[3].getText()));
	    		loginMember.setLev(text[5].getText());      	         	 
	    		loginMember.setPoint(Integer.parseInt(text[6].getText()));
				JOptionPane.showMessageDialog(null,"ȸ�������� ����Ǿ����ϴ�.");
				dispose();
			}
			
			if(eBtn == btn2)
				dispose();
				new Check(loginMember);
		}
}