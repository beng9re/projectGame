/*
 * �� Ŭ������ sun ���� ��ü ������ UI������Ʈ�� �ƴϱ� ������ ȭ�鿡 �׷��� �� ����..
 * ���� JPanel �� �׷������� JPanel�� Graphics �� ���۷����� �̰�ü�� �����ؾ��Ѵ�
 * */

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;

public class Player{
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	Bullet bullet;
	
	public Player(int x,int y,int width,int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
		
		
	}
	
	//�Ѿ� �߻� ������ �����Ѵ�!1
	public void fire(){
		bullet =new Bullet(x, y, 10, 10);
	}
	
	
	//x,y,w,h���� ������ ������ ��ȭ�� �����ϱ� ���� �޼���!!
	//��� ����-�����ȭ 
	public void tick(){
		x+=velX;
		y+=velY;
	}
	
	//��ȭ�� ���� ȭ�鿡 �׷����� �� �޼���!!
	public void render(Graphics g){
		g.setColor(Color.WHITE);//����Ʈ �� �ٲٱ�
		g.drawRect(x, y, width, height);
		
		
	}
}
