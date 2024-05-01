package hw4;

/**
 * An element that does not move. Instead, it is intended to appear on the
 * screen for a fixed number of frames.
 * 
 * @author Caleb Hemmestad
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class VanishingElement extends SimpleElement{
	/**
	 * Variable for storing how many frames the object should be on the screen
	 */
	private int initialLife;

	/**
	 * Constructs a new VanishingElement.
	 * 
	 * @param x           x-coordinate of upper left corner
	 * @param y           y-coordinate of upper left corner
	 * @param width       element's width
	 * @param height      element's height
	 * @param initialLife the number of frames until this element marks itself for
	 *                    deletion
	 */
	public VanishingElement(double x, double y, int width, int height, int initialLife) {
		super(x, y, width, height);
		this.initialLife = initialLife;
	}
	
	/**
	 * Updates the object and increments the framecount and decrements the amount of life
	 */
	@Override
	public void update() {
		addFrameCount();
		initialLife--;
		if(initialLife < 1) {
			this.markForDeletion();
		}
	}

}
