package game;

import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * ���ӿ� ������ ��簴ü���ֻ��� Ŭ������ �����Ѵ�
 * ��? ����� �̿��ϸ� �ڵ��ߺ��� �����Ҽ� �ְ�,�ֻ��� Ŭ���� �ڷ������� �ڽĵ��� ����
 * ų�� ������,�ڵ尡 ����������
 * */
abstract public class GameObject {
	ObjectId id;
	ObjectManager objectManager;
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	
	Rectangle rect;
	public GameObject(ObjectManager objectManager,ObjectId id,int x,int y,int width,int height) {
		this.id=id;
		this.objectManager=objectManager;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		rect=new Rectangle(x,y,width,height);
	}
	
	abstract public void tick();
	abstract public void render(Graphics g);
}
