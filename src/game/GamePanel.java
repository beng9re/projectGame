package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

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
	
	public GamePanel() {
		//ũ�� ����
		thread =new Thread(this);
		thread.start();// ��ŸƮ����� ��ŸƮ��
		
		init();
		
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
	}
	
	public void init(){
		//���ΰ� ���� ��Ű��
		
		player=new Player(100, 200,50, 50);
	
		//�гΰ� Ű���� ������ ����
		this.addKeyListener(new KeyBoard(player));
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		//��ü��
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
	
		player.render(g);
	
	}
	
	public void run() {
		while(flag){
			try {
				Thread.sleep(10);
			}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			player.tick();
			repaint();
			
		
		}
	}

}
