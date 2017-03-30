/*
 * �� Ŭ������ sun ���� ��ü ������ UI������Ʈ�� �ƴϱ� ������ ȭ�鿡 �׷��� �� ����..
 * ���� JPanel �� �׷������� JPanel�� Graphics �� ���۷����� �̰�ü�� �����ؾ��Ѵ�
 * */

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Player extends GameObject{

	
	
	public Player(ObjectManager obj,ObjectId id,int x,int y,int width,int height){
		super(obj,id,x,y,width,height);
		
		
		
	}
	
	//�Ѿ� �߻� ������ �����Ѵ�!1
	public void fire(){
		Bullet bullet =new Bullet(objectManager,ObjectId.Bullet,x, y, 10, 10);
		objectManager.addObject(bullet);
	}
	
	
	//x,y,w,h���� ������ ������ ��ȭ�� �����ϱ� ���� �޼���!!
	//��� ����-�����ȭ 
	public void tick(){
		x+=velX;
		y+=velY;
		
		//�簭���� ������ ����ٴϰ�
		rect.setBounds(x, y, width, height);
	}
	
	//��ȭ�� ���� ȭ�鿡 �׷����� �� �޼���!!
	public void render(Graphics g){
		g.setColor(Color.WHITE);//����Ʈ �� �ٲٱ�
		//g.drawRect(x, y, width, height);
		Graphics2D g2=(Graphics2D)g;
		g2.draw(rect);
		
		
	}
}
