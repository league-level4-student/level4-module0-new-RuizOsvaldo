package _04_Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGame implements ActionListener, KeyListener {

	/*
	 * BEFORE YOU START
	 * 
	 * 1. Create a Location class with a x and y member variables encapsulated.
	 * 
	 * 2. Create an equals method in Location that takes in a Location and returns
	 * true if the member variable x and y match the passed in Location's x and y.
	 * 
	 * 3. Create a Direction enum with UP, DOWN, LEFT, and RIGHT values.
	 */

	public static final Color BORDER_COLOR = Color.WHITE;
	public static final Color BACKGROUND_COLOR = Color.BLACK;
	public static final Color FOOD_COLOR = Color.RED;
	public static final int WIDTH = 15;
	public static final int HEIGHT = 12;
	public static final int WINDOW_SCALE = 50;
	public static final int WINDOW_WIDTH = WINDOW_SCALE * WIDTH;
	public static final int WINDOW_HEIGHT = WINDOW_SCALE * HEIGHT;

	private JFrame window;
	private JPanel panel;

	private Snake snake;

	private Timer timer;

	private Location foodLocation;

	public SnakeGame() {
		snake = new Snake(new Location(WIDTH / 2, HEIGHT / 2));

		window = new JFrame("Snake");
		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;

				g2.setColor(BACKGROUND_COLOR);
				g2.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

				g2.setColor(FOOD_COLOR);
				g2.drawOval(foodLocation.getX() * WINDOW_SCALE, foodLocation.getY() * WINDOW_SCALE, Snake.BODY_SIZE,
						Snake.BODY_SIZE);
				snake.draw(g);
			}
		};

		panel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		window.add(panel);

		timer = new Timer(0, this);

		window.pack();
		window.addKeyListener(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

		randomizeFoodLocation();

		startGame();
	}

	public void startGame() {
		String instructions = "Collect food to grow your snake.\nThe game is "
				+ "over if you run into your tail or the edge of the window." + "\nClick OK to begin!";

		JOptionPane.showMessageDialog(null, instructions);

		// Note: Adjust delay here if you want snake to go slower or faster.

		timer.setDelay(250);

		timer.start();
	}

	public static void main(String[] args) {
		new SnakeGame();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		/*
		 * Use a switch statement to determine if an arrow key is pressed, and set the
		 * snake's direction accordingly.
		 * 
		 * Hint: KeyEvent.VK_UP.
		 */

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			snake.setDirection(Direction.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.setDirection(Direction.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.setDirection(Direction.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.setDirection(Direction.RIGHT);
			break;
		}

	}

	private void randomizeFoodLocation() {

		/*
		 * Create a new Location object that is set to a random x and y values between 0
		 * and the WIDTH and HEIGHT variables respectively.
		 */
		Random rand = new Random();
		Location loc = new Location(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));

		/*
		 * Set the foodLocation equal to the Location object you just created.
		 * 
		 * Hint: Use the snake's isLocationOnSnake method to make sure you don't put the
		 * food on top of the snake.
		 */
		if (snake.isLocationOnSnake(loc)) {
			randomizeFoodLocation();
		} else {
			foodLocation = loc;
		}

	}

	private void gameOver() {

		// Stop the timer.
		timer.stop();
		// Tell the user their snake is dead.
		JOptionPane.showMessageDialog(null, "Your snake is dead :(");
		// Ask the user if they want to play again.
		String retry = JOptionPane.showInputDialog(null, "Do you want to play again?");

		/*
		 * If the user wants to play again, call the snake's resetLocation method and
		 * this class's randomizeFoodLocation method then restart the timer. Otherwise,
		 * exit the game.
		 */
		if (retry.equals("yes")) {
			snake.resetLocation();
			randomizeFoodLocation();
			timer.start();
		} else {
			System.exit(0);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Call the snake's update method.

		snake.update();

		/*
		 * If the snake's head is colliding with its own body or out of bounds call the
		 * gameOver method.
		 */

		Location headLoc = snake.getHeadLocation();

		if (snake.isHeadCollidingWithBody() || snake.isOutOfBounds()) {
			gameOver();
		}

		/*
		 * If the location of the snake's head is equal to the location of the food,
		 * feed the snake and randomize the food location.
		 */

		if (headLoc.equals(foodLocation)) {
			snake.feed();
			randomizeFoodLocation();
		}

		panel.repaint();
	}
}
