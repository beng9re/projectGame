package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/*모든게임은 이패널안에서 그려질 예정임 
 * 아무리 게임의 장면이 다양하더라도 ,패널은 오직 1개만 실행된다
 * 
 * 모든오브젝트는 결국 이 패널에 그려져야 하므로,
 * 이패널의 paint 메서드의 인수로 전되는 Graphics객체를 게임에 등장할 모든 
 * 오브젝트가 전달바다아야 한다..
 * 
 * 
 * */
public class GamePanel extends JPanel implements Runnable{

	public static final int WIDTH=400;
	public static final int HEIGHT=300;
	public static final int SCALE=2;
	boolean flag=true;//게임가동여부를 결정하는 변수
	Thread thread; //게임진행 운영 쓰레드
	Player player;
	ObjectManager objectManager; //객체 명단 관리자
	Enemy enemy;
	
	public GamePanel() {
		//크기 지정
		thread =new Thread(this);
		thread.start();// 스타트해줘야 스타트됨
		
		init();
		
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
	}
	
	public void init(){
		
		
		//명단관리자 생성
		objectManager=new ObjectManager();
		
		
		//주인공 등장 시키기
		player=new Player(objectManager,ObjectId.Player,100, 200,50, 50);
		objectManager.addObject(player);
		
		Random r=new Random();
		
		//적군등장
		for(int i=0;i<10;i++){
		int y=r.nextInt((HEIGHT*SCALE-50-(50)+1+50));
		int x=r.nextInt(WIDTH*SCALE+500);
		enemy=new Enemy(objectManager,ObjectId.Enemy,x,y,50,50);
		objectManager.addObject(enemy);
		}
		
		//패널과 키보드 리스너 연결
		this.addKeyListener(new KeyBoard(player));
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		//색체움
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		for (int i = 0; i < objectManager.list.size(); i++) {
			GameObject obj=objectManager.list.get(i);
			obj.render(g);
		}
	
	
	}
	
	public void run() {
		while(flag){
			try {
				Thread.sleep(10);
			}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//오브젝트 매니져에 등록된 모든 객체를 대상으로 tick() 호출
			for (int i = 0; i < objectManager.list.size(); i++) {
				GameObject obj=objectManager.list.get(i);
				obj.tick();
			}
			
			//player.tick();
			repaint();
			
		
		}
	}

}
