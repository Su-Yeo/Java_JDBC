
//구현: 김승현
package game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bank.Member;

public class Quiz extends JFrame implements ActionListener{
	private Member member;
	private int point=0;
	private JLabel question = new JLabel();
	private JTextField answer=new JTextField(15);
	private JButton btnStart=new JButton("게임시작");
	private JButton btnCheck=new JButton("정답확인");
	private JButton btnClose=new JButton("종 료");
	
	private final String Q1="붉은길에 동전 하나가 떨어져 있다. 그 동전의 이름은?";
	private final String Q2="타이타닉의 구명보트에는 몇 명이 탈수 있을까?";
	private final String Q3="중학생과 고등학생이 타는 차는? ";
	private final String Q4="라면은 라면인데 달콤한 라면은? ";
	private final String Q5="눈이 녹으면 뭐가 될까? ";
	private final String Q6="창으로 찌를려고 할 때 하는 말은?";
	private final String Q7="도둑이 훔친돈을 뭐라고 할까?";
	private final String Q8="소금을 죽이면? ";
	private final String Q9="소금장수가 좋아하는 사람은?";
	private final String Q10="바닷가에서는 해도 되는 욕은?";
	
	private final String A1="홍길동전";
	private final String A2="9명";
	private final String A3="중고차";
	private final String A4="그대와 함께라면";
	private final String A5="눈물";
	private final String A6="창피해";
	private final String A7="슬그머니";
	private final String A8="죽염";
	private final String A9="싱거운사람";
	private final String A10="해수욕";
	
	public Quiz(Member mem) {
		this.member=mem;
		point=mem.getPoint();
		
		setLayout(new GridLayout(3,3));
		
		JPanel pan1=new JPanel();
		JPanel pan2=new JPanel();
		JPanel pan3=new JPanel();
		
		add(pan1);
		add(pan2);
		add(pan3);

		JLabel lbl=new JLabel("답: ");

		pan1.add(question);
		pan2.add(lbl);
		pan2.add(answer);
		pan3.add(btnStart);
		pan3.add(btnCheck);
		pan3.add(btnClose);
		btnStart.addActionListener(this);
		btnCheck.addActionListener(this);
		btnClose.addActionListener(this);
		setTitle("Quiz");
		setBounds(200, 300, 400, 150);
		setVisible(true);
	}
	int num;
	@Override
	public void actionPerformed(ActionEvent a) {
		Object btn=a.getSource();
		String[] ques= {Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10};
		String[] ans= {A1, A2, A3, A4, A5, A6, A7, A8, A9, A10};
		Random rand=new Random(System.currentTimeMillis());
		if(btn==btnStart) {
			num=rand.nextInt(10);
			question.setText(ques[num]);
		}
		if(btn==btnCheck) {
			if(answer.getText().equals(ans[num])) {
				point+=200;
				question.setText(ques[num]);
				new QuizRes(member, point, "맞았습니다.");
			}else {
				if(member.getPoint()-100<0) {
					point=0;
					new QuizRes(member, point, "틀렸습니다.");
				}else {
					point-=100;
					new QuizRes(member,point, "틀렸습니다.");
				}
			}
		}
		if(btn==btnClose) {
			dispose();
		}
		
		
		
		
	}
}
