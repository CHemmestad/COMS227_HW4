package hw4;

/**
 * An element in which the <code>update</code> method updates the position each
 * frame according to a <em>velocity</em> vector (deltaX, deltaY). The units are
 * assumed to be "pixels per frame".
 * 
 * @author Caleb Hemmestad
 */
public class MovingElement extends SimpleElement{
	/**
	 * Variable for storing the change in the x axis
	 */
	private double deltaX;
	/**
	 * Variable for storing the change in the y axis
	 */
	private double deltaY;

	/**
	 * Constructs a MovingElement with a default velocity of zero in both
	 * directions.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	public MovingElement(double x, double y, int width, int height) {
		super(x, y, width, height);
	}
	
	/**
	 * Gets the amount of change in the x axis
	 * @return deltaX
	 */
	public double getDeltaX() {
		return deltaX;
	}
	
	/**
	 * Gets the amount of change in the y axis
	 * @return deltaY
	 */
	public double getDeltaY() {
		return deltaY;
	}
	
	/**
	 * Sets the amount of change for the x and y axis
	 * @param deltaX
	 * @param deltaY
	 */
	public void setVelocity(double deltaX, double deltaY) {
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
	
	/**
	 * Updates the position of the object and increments the framecount
	 */
	@Override
	public void update() {
		addFrameCount();
		this.setPosition(this.getXReal() + getDeltaX(), this.getYReal() + getDeltaY());
	}

}
