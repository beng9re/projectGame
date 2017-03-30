package game;

import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * 게임에 등장할 모든객체의최상의 클래스를 정의한다
 * 왜? 상속을 이용하면 코드중복을 방지할수 있고,최상위 클래스 자료형으로 자식들을 가리
 * 킬수 있으모,코드가 유연해진다
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
