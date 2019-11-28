
//����: �����
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
	private JButton btnStart=new JButton("���ӽ���");
	private JButton btnCheck=new JButton("����Ȯ��");
	private JButton btnClose=new JButton("�� ��");
	
	private final String Q1="�����濡 ���� �ϳ��� ������ �ִ�. �� ������ �̸���?";
	private final String Q2="Ÿ��Ÿ���� ����Ʈ���� �� ���� Ż�� ������?";
	private final String Q3="���л��� ����л��� Ÿ�� ����? ";
	private final String Q4="����� ����ε� ������ �����? ";
	private final String Q5="���� ������ ���� �ɱ�? ";
	private final String Q6="â���� ����� �� �� �ϴ� ����?";
	private final String Q7="������ ��ģ���� ����� �ұ�?";
	private final String Q8="�ұ��� ���̸�? ";
	private final String Q9="�ұ������ �����ϴ� �����?";
	private final String Q10="�ٴ尡������ �ص� �Ǵ� ����?";
	
	private final String A1="ȫ�浿��";
	private final String A2="9��";
	private final String A3="�߰���";
	private final String A4="�״�� �Բ����";
	private final String A5="����";
	private final String A6="â����";
	private final String A7="���׸Ӵ�";
	private final String A8="�׿�";
	private final String A9="�̰ſ���";
	private final String A10="�ؼ���";
	
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

		JLabel lbl=new JLabel("��: ");

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
				new QuizRes(member, point, "�¾ҽ��ϴ�.");
			}else {
				if(member.getPoint()-100<0) {
					point=0;
					new QuizRes(member, point, "Ʋ�Ƚ��ϴ�.");
				}else {
					point-=100;
					new QuizRes(member,point, "Ʋ�Ƚ��ϴ�.");
				}
			}
		}
		if(btn==btnClose) {
			dispose();
		}
		
		
		
		
	}
}
