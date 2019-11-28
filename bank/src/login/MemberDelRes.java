
//구현:김승현
package login;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bank.Member;

public class MemberDelRes extends JFrame implements ActionListener{
	
		
	public MemberDelRes(Member[] memberArr, int idx, String id) {
		setLayout(new GridLayout(2,1));
		for(int i=idx; i<memberArr.length-1; i++) {
			Member temp=memberArr[i+1];
			memberArr[i+1]=null;
			memberArr[i]=temp;
		}
		JButton btn=new JButton("확인");
		JPanel pan1=new JPanel();
		JPanel pan2=new JPanel();
		JLabel text=new JLabel(id+"님의 정보가 삭제되었습니다.");
		add(pan1);
		add(pan2);
		pan1.add(text);
		pan2.add(btn);
		btn.addActionListener(this);
		setTitle("회원삭제");
		setBounds(200,200,300,130);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		dispose();
	}
}
