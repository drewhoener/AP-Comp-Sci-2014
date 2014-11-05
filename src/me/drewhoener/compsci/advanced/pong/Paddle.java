package me.drewhoener.compsci.advanced.pong;

import java.awt.*;

public class Paddle {

	private Rectangle paddle;
	private Color paddleColor;

	public Paddle() {

		this(Color.RED);

	}

	public Paddle(Color paddleColor) {

		this(new Rectangle(5, 5, 10, 50), paddleColor);
	}

	public Paddle(Rectangle paddle, Color paddleColor) {

		this.paddleColor = paddleColor;
		this.paddle = paddle;

	}

	public void drawPaddle(Graphics2D graphics) {

		graphics.setColor(this.paddleColor);
		graphics.fill(this.paddle);

	}


}
