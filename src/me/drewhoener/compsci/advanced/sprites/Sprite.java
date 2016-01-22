package me.drewhoener.compsci.advanced.sprites;

import javax.activation.UnsupportedDataTypeException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {

	private BufferedImage[] frames;
	private String spriteName;
	private int currentFrame = 0;

	private long lastUpdate = 0;
	private long waitTime = 0;

	public Sprite(String resource, String spriteName, int frames) throws IOException {
		this.spriteName = spriteName;
		this.registerSprites(resource, frames);
	}

	private void registerSprites(String resourceFolder, int frames) throws IOException {
		File resourceOne = new File(resourceFolder);
		if (!resourceOne.isDirectory()) {
			throw new UnsupportedDataTypeException("The File provided MUST be a folder!");
		}
		File[] files = resourceOne.listFiles();
		if (files != null) {
			int count = 0;
			this.frames = new BufferedImage[frames];
			for (File f : files) {

				if (f.isFile() && f.getName().contains(this.spriteName + "_" + count + ".png")) {
					this.frames[count] = ImageIO.read(f);
					count++;
					if (count > frames)
						break;
				}

			}
		}
	}


	public BufferedImage getCurrentFrame() {
		return this.frames[this.currentFrame];
	}

	public BufferedImage getNextFrame() {
		this.currentFrame++;
		if (this.currentFrame >= this.frames.length) {
			this.currentFrame = 0;
		}

		return this.frames[this.currentFrame];
	}

	public BufferedImage getPreviousFrame() {
		this.currentFrame--;
		if (this.currentFrame < 0) {
			this.currentFrame = (this.frames.length - 1);
		}

		return this.frames[this.currentFrame];
	}

	public void resetFrames() {
		this.currentFrame = 0;
	}

}
