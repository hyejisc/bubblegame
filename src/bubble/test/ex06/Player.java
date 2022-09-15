package bubble.test.ex06;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends JLabel implements Moveable {

	// 위치 상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	// 플레이어 속도 상태
	// 고정 상수처리
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;

	private ImageIcon playerR, playerL;

	
	private final JButton button = new JButton("New button");
	
	private final JRadioButton radioButton = new JRadioButton("New radio button");

	public Player() {
		initObject();
		initSetting();
		initBackgroundPlayerService();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 55;
		y = 535;

		left = false;
		right = false;
		up = false;
		down = false;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}
	
	private void initBackgroundPlayerService() {
		new Thread(new BackgroundPlayerService(this)).start();
	}

	@Override
	public void left() {
		
		left = true;
		new Thread(() -> {
			while (left) {
				setIcon(playerL);
				x -= JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // 0.01초
			}

		}).start();

	}

	@Override
	public void right() {
		
		right = true;
		new Thread(() -> {
			while (right) {
				setIcon(playerR);
				x += SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	@Override
	// left+up, right+up
	public void up() {
		up = true;
		new Thread(()->{
			for(int i=0; i<130/JUMPSPEED; i++) {
				y -= JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			up = false;
			down();
			
		}).start();
	}

	@Override
	public void down() {
		down = true;
		new Thread(()->{
			for(int i=0; i<130/JUMPSPEED; i++) {
				y += JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			down = false;
		}).start();
	}
}
