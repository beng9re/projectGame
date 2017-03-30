package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Enemy extends GameObject {
	
	
	Random r=new Random();
	ObjectId id;//모든게임 객체에 할당될 아아디
	
	int max;
	int min;
	
	public Enemy(ObjectManager objectManager, ObjectId id,int x, int y, int width, int height) {
		super(objectManager,id, x, y, width, height);
		velX=-5;
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x+=velX;
		max=(GamePanel.HEIGHT*GamePanel.SCALE)-50;
		min=50;
		//화면 좌측 끝에 도달하면 우측부터 시작하게
		if(x<0){
			y=r.nextInt(max-min+1)+min;
					//r.nextInt(max-min+1)+min;
			x=GamePanel.WIDTH*GamePanel.SCALE;
		}
		rect.setBounds(x,y,width,height);
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		Graphics2D g2=(Graphics2D)g;
		g2.draw(rect);
	}
 
}
