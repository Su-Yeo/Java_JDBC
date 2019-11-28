package bank;

import java.util.Random;

import game.ArrowGame;
import game.Quiz;
import game.RockScissorsPaper;

public class LevelUp {
	Member loginMember;
	
	public LevelUp(Member loginMember) {
		this.loginMember = loginMember;
		Random random = new Random();
		int i = random.nextInt(3);
		
		switch (i) {
		case 0:
			new Quiz(loginMember); //����� �ٲ����! 
			break;
		case 1:
			new RockScissorsPaper(loginMember); //����,����,�� ����
			break;
		case 2:
			new ArrowGame(loginMember); //ȭ��ǥ ����
			break;
		}
	}
}
