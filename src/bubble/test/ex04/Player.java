package bubble.test.ex04;

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

	private ImageIcon playerR, playerL;
	/**
	 * @wbp.nonvisual location=26,239
	 */
	private final JButton button = new JButton("New button");
	/**
	 * @wbp.nonvisual location=111,349
	 */
	private final JRadioButton radioButton = new JRadioButton("New radio button");

	public Player() {
		initObject();
		initSetting();
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

	@Override
	public void left() {
		
		left = true;
		new Thread(() -> {
			while (left) {
				setIcon(playerL);
				x -= 1;
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
				x += 1;
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
	public void up() {

	}

	@Override
	public void down() {

	}
}
