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
			new Quiz(loginMember); //퀴즈로 바꿔야함! 
			break;
		case 1:
			new RockScissorsPaper(loginMember); //가위,바위,보 게임
			break;
		case 2:
			new ArrowGame(loginMember); //화살표 게임
			break;
		}
	}
}
