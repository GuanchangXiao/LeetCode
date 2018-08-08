
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class FiveChessGame {
	/**
	 * �ؼ�����
	 */
	private JFrame frame; // ��������Ϸ�Ĵ��ڿ��
	private GameMap map; // ��������Ϸ�Ĵ�������
	private JMenuBar bar; // �˵�
	private JMenu game; // �˵���
	private JMenuItem[] items; // �˵�������
 
	/**
	 * ��̬��������
	 */
	private static final int BOARD_SIZE = 15; // ���̴�С(15 * 15)
	private static final int ROW_WIDTH = 36; // ���
	private static final int SPACE = ROW_WIDTH / 2; // ���±߼��
 
	/**
	 * ��������
	 */
	private boolean player; // true��,false��
	private char[][] board; // ��̨��������
 
	public FiveChessGame() {
		player = true; // ��Ϸ�Ⱥ�����
		board = new char[BOARD_SIZE][BOARD_SIZE]; // ������̨��������
		clearMap();
		createGUI();
	}
 
	/**
	 * ��GUI�ؼ��Ĵ���
	 */
	private void createGUI() {
		frame = new JFrame("������"); // ʵ����������Ϸ���ڿ��
		map = new GameMap(); // ʵ����������Ϸ��������
		bar = new JMenuBar(); // �����˵���
		game = new JMenu("��Ϸ"); // ������Ϊ����Ϸ���Ĳ˵�
		items = new JMenuItem[2]; // game�˵��´���2���Ӳ˵���
		game.add(items[0] = new JMenuItem("���¿�ʼ"));// ��һ���Ӳ˵�Ϊ�����¿�ʼ��
		game.add(items[1] = new JMenuItem("�˳�")); // �ڶ����Ӳ˵�Ϊ���˳���
	}
 
	/**
	 * �������
	 */
	protected void clearMap() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = '+';
			}
		}
	}
 
	/**
	 * ������Ϸ
	 */
	public void start() {
		map.setPreferredSize(new Dimension(ROW_WIDTH * (BOARD_SIZE - 1) + SPACE
				* 2, ROW_WIDTH * (BOARD_SIZE - 1) + SPACE * 2));
		map.addMouseListener(new MouseAdapter() {
			// ������¼�
			public void mouseClicked(MouseEvent e) {
				// ���û�����¼�������ת����������������ꡣ
				int xPos = (int) (e.getX() / ROW_WIDTH);
				int yPos = (int) (e.getY() / ROW_WIDTH);
				if (board[xPos][yPos] == '+') {// �ж��Ƿ��¹���
					board[xPos][yPos] = player ? 'b' : 'w'; // ��������̸�ֵ
					map.repaint(); // ͨ����ȡboard���������ͼ
					if (isWin(xPos, yPos)) {// ���������ʤ�������������
						map.repaint(); // ˢ��ͼ��
						String str = player ? "�ڷ�ʤ��" : "�׷�ʤ��";
						JOptionPane.showMessageDialog(null, str, "��Ϸ����",
								JOptionPane.PLAIN_MESSAGE); // ������Ϣ��
						clearMap(); // �������
						map.repaint(); // ˢ������
						player = true; // ��һ�ּ�����������
					} else {
						player = player ? false : true; // �л����
					}
				}
			}
		});
		// ������¿�ʼ�¼�
		items[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "�Ƿ�Ҫ���¿�ʼ��Ϸ?";
				// �����Ϣ�Ի���
				if (JOptionPane.showConfirmDialog(null, str, "���¿�ʼ",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					clearMap(); // �������
					map.repaint(); // ˢ������
					player = true; // ���Ϊ����
				}
			}
		});
		// ����˳��¼�
		items[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "�Ƿ�Ҫ�˳���Ϸ?";
				// �����Ϣ�Ի���
				if (JOptionPane.showConfirmDialog(null, str, "���¿�ʼ",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0); // �˳�
				}
			}
		});
		// ��رհ�ť�¼�
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				String str = "�Ƿ�Ҫ�˳���Ϸ?";
				// �����Ϣ�Ի���
				if (JOptionPane.showConfirmDialog(null, str, "�˳���Ϸ",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0); // �˳�
				}
			}
		});
		bar.add(game);
		frame.setJMenuBar(bar);
		frame.add(map);
		frame.pack();
		frame.setLocation(250, 50);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
 
	/**
	 * ������
	 */
	protected boolean find(int x, int y) {
		int i, num = 1;
		char temp = player ? 'b' : 'w';
		for (i = x + 1; i < 15; i++) {// ������
			if (board[i][y] == temp) {
				num++;
				if (num == 5) {
					return true;
				}
			} else {
				break;
			}
		}
		for (i = x - 1; i >= 0; i--) {// ������
			if (board[i][y] == temp) {
				num++;
				if (num == 5) {
					return true;
				}
			} else {
				break;
			}
		}
		return false;
	}
 
	/**
	 * ������
	 */
	protected boolean find2(int x, int y) {
		int i, num = 1;
		char temp = player ? 'b' : 'w';
		for (i = y + 1; i < 15; i++) { // ������
			if (board[x][i] == temp) {
				num++;
				if (num == 5) {
					return true;
				}
			} else {
				break;
			}
		}
		for (i = y - 1; i >= 0; i--) {// ������
			if (board[x][i] == temp) {
				num++;
				if (num == 5) {
					return true;
				}
			} else {
				break;
			}
		}
		return false;
	}
 
	/**
	 * \����
	 */
	protected boolean find3(int x, int y) {
		int i, j, num = 1;
		char temp = player ? 'b' : 'w';
		for (i = x + 1, j = y + 1; i < 15 && j < 15; i++, j++) {// ���·�
			if (board[i][j] == temp) {
				num++;
				if (num == 5) {
					return true;
				}
			} else {
				break;
			}
		}
		for (i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {// ���Ϸ�
			if (board[i][j] == temp) {
				num++;
				if (num == 5) {
					return true;
				}
			} else {
				break;
			}
		}
		return false;
	}
 
	/**
	 * /����
	 */
	protected boolean find4(int x, int y) {
		int i, j, num = 1;
		char temp = player ? 'b' : 'w';
		for (i = x + 1, j = y - 1; i < 15 && j >= 0; i++, j--) {// ����
			if (board[i][j] == temp) {
				num++;
				if (num == 5) {
					return true;
				}
			} else {
				break;
			}
		}
		for (i = x - 1, j = y + 1; i >= 0 && j < 15; i--, j++) { // ����
			if (board[i][j] == temp) {
				num++;
				if (num == 5) {
					return true;
				}
			} else {
				break;
			}
		}
		return false;
	}
 
	/**
	 *�ж�ʤ��
	 */
	protected boolean isWin(int x, int y) {
		return (find(x, y) || find2(x, y) || find3(x, y) || find4(x, y));
	}
 
	/**
	 * �ڲ������࣬����ʵ��ͼ����
	 */
	private class GameMap extends JPanel {
		private static final long serialVersionUID = 16578987565248L;
 
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// ����
			g.setColor(new Color(200, 100, 50)); // ��Ϊ�ۻ�ɫ
			g.fillRect(0, 0, ROW_WIDTH * (BOARD_SIZE + 1), ROW_WIDTH
					* (BOARD_SIZE + 1)); // �������
			g.setColor(Color.black); // ��Ϊ��ɫ
			for (int i = 0; i < BOARD_SIZE; i++) {// ������
				g.drawLine(SPACE + ROW_WIDTH * i, SPACE, SPACE + ROW_WIDTH * i,
						SPACE + ROW_WIDTH * (BOARD_SIZE - 1));
			}
			for (int i = 0; i < BOARD_SIZE; i++) {// ������
				g.drawLine(SPACE, SPACE + ROW_WIDTH * i, SPACE + ROW_WIDTH
						* (BOARD_SIZE - 1), SPACE + ROW_WIDTH * i);
			}
			// ����
			g.fillOval(SPACE + 3 * ROW_WIDTH - 3, SPACE + 3 * ROW_WIDTH - 3, 7,
					7);
			g.fillOval(SPACE + 11 * ROW_WIDTH - 3, SPACE + 3 * ROW_WIDTH - 3,
					7, 7);
			g.fillOval(SPACE + 3 * ROW_WIDTH - 3, SPACE + 11 * ROW_WIDTH - 3,
					7, 7);
			g.fillOval(SPACE + 7 * ROW_WIDTH - 3, SPACE + 7 * ROW_WIDTH - 3, 7,
					7);
			g.fillOval(SPACE + 11 * ROW_WIDTH - 3, SPACE + 11 * ROW_WIDTH - 3,
					7, 7);
 
			// ����
			// �������飬�������ӡ�
			for (int i = 0; i < BOARD_SIZE; i++) {
				for (int j = 0; j < BOARD_SIZE; j++) {
					if (board[i][j] == 'b') {// ���ƺ���
						g.setColor(Color.black);
						g.fillOval(SPACE + i * ROW_WIDTH - ROW_WIDTH / 2, SPACE
								+ j * ROW_WIDTH - ROW_WIDTH / 2, ROW_WIDTH,
								ROW_WIDTH);
					}
					if (board[i][j] == 'w') {// ���ư���
						g.setColor(Color.white);
						g.fillOval(SPACE + i * ROW_WIDTH - ROW_WIDTH / 2, SPACE
								+ j * ROW_WIDTH - ROW_WIDTH / 2, ROW_WIDTH,
								ROW_WIDTH);
					}
				}
			}
		}
	}
 
	public static void main(String[] args) {
		FiveChessGame game = new FiveChessGame();
		game.start();
	}
}
