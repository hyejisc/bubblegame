package bubble.test.ex06;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable{

	private BufferedImage image;
	private Player player;
	
	public BackgroundPlayerService(Player player) {
		this.player = player;
		try {
			 image = ImageIO.read(new File("image/test.png"));
		 } catch (Exception e) {
			 System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run() {
		// 색상 확인
		while(true) {
		Color color = new Color(image.getRGB(player.getX(), player.getY()));
		System.out.println("색상:" + color);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
