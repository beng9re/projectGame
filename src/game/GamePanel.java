package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/*�������� ���гξȿ��� �׷��� ������ 
 * �ƹ��� ������ ����� �پ��ϴ��� ,�г��� ���� 1���� ����ȴ�
 * 
 * ��������Ʈ�� �ᱹ �� �гο� �׷����� �ϹǷ�,
 * ���г��� paint �޼����� �μ��� ���Ǵ� Graphics��ü�� ���ӿ� ������ ��� 
 * ������Ʈ�� ���޹ٴپƾ� �Ѵ�..
 * 
 * 
 * */
public class GamePanel extends JPanel implements Runnable{

	public static final int WIDTH=400;
	public static final int HEIGHT=300;
	public static final int SCALE=2;
	boolean flag=true;//���Ӱ������θ� �����ϴ� ����
	Thread thread; //�������� � ������
	Player player;
	ObjectManager objectManager; //��ü ��� ������
	Enemy enemy;
	
	public GamePanel() {
		//ũ�� ����
		thread =new Thread(this);
		thread.start();// ��ŸƮ����� ��ŸƮ��
		
		init();
		
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
	}
	
	public void init(){
		
		
		//��ܰ����� ����
		objectManager=new ObjectManager();
		
		
		//���ΰ� ���� ��Ű��
		player=new Player(objectManager,ObjectId.Player,100, 200,50, 50);
		objectManager.addObject(player);
		
		Random r=new Random();
		
		//��������
		for(int i=0;i<10;i++){
		int y=r.nextInt((HEIGHT*SCALE-50-(50)+1+50));
		int x=r.nextInt(WIDTH*SCALE+500);
		enemy=new Enemy(objectManager,ObjectId.Enemy,x,y,50,50);
		objectManager.addObject(enemy);
		}
		
		//�гΰ� Ű���� ������ ����
		this.addKeyListener(new KeyBoard(player));
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		//��ü��
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
			
			//������Ʈ �Ŵ����� ��ϵ� ��� ��ü�� ������� tick() ȣ��
			for (int i = 0; i < objectManager.list.size(); i++) {
				GameObject obj=objectManager.list.get(i);
				obj.tick();
			}
			
			//player.tick();
			repaint();
			
		
		}
	}

}
