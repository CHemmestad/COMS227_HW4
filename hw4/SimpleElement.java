package hw4;

import java.awt.Rectangle;
import api.AbstractElement;

/**
 * Minimal concrete extension of AbstractElement. The <code>update</code> method
 * in this implementation just increments the frame count.
 * 
 * @author Caleb Hemmestad
 */
public class SimpleElement extends AbstractElement{
	/**
	 * Variable for saving the x coordinate for the object
	 */
	private double x;
	/**
	 * Variable for saving the y coordinate for the object
	 */
	private double y;
	/**
	 * Variable for saving the width for the object
	 */
	private int width;
	/**
	 * Variable for saving the height for the object
	 */
	private int height;
	/**
	 * Variable for saving hiw many frames the object has been on the screen
	 */
	private int frameCount;
	/**
	 * Variable for saving whether or not the object should be deleted
	 */
	private boolean delete;
	/**
	 * Variable for saving object shape
	 */
	private Rectangle rect;

	/**
	 * Constructs a new SimpleElement.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public SimpleElement(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.rect = new Rectangle(getXInt(), getYInt(), width, height);
		this.frameCount = 0;
		this.delete = false;
	}
	
	/**
	 * Gets the x coordinate of the object as an int
	 */
	public int getXInt() {
		return (int)x;
	}
	
	/**
	 * Gets the y coordinate of the object as an int
	 */
	public int getYInt() {
		return (int)y;
	}
	
	/**
	 * Gets the width of the object
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	* Gets the height of the object
	*/
	public int getHeight() {
		return height;
	}
	
	/**
	* Sets the position of the object on the screen
	*/
	public void setPosition(double newX, double newY) {
		x = newX;
		y = newY;
		rect.setLocation(getXInt(), getYInt());
	}
	
	/**
	* Gets the rect from the object
	*/
	public Rectangle getRect() {
		return rect;
	}
	
	/**
	* Gets the actual x coordinate of the object
	*/
	@Override
	public double getXReal() {
		return x;
	}
	
	/**
	* Gets the actual y coordinate of the object
	*/
	@Override
	public double getYReal() {
		return y;
	}
	
	/**
	* Updates the scene by incrementing framecount
	*/
	@Override
	public void update() {
		addFrameCount();
	}
	
	/**
	* Gets how many frames the object has been on the screen
	*/
	@Override
	public int getFrameCount() {
		return frameCount;
	}
	
	/**
	* Gets whether or not the object is marked to be deleted
	*/
	@Override
	public boolean isMarked() {
		return delete;
	}
	
	/**
	* Marks the object to be deleted
	*/
	@Override
	public void markForDeletion() {
		delete = true;
	}
	
	/**
	* Determines whether or not the object is colliding with another object
	*/
	@Override
	public boolean collides(AbstractElement other) {
		double x1 = getXReal();
	    double y1 = getYReal();
	    int w1 = getWidth();
	    int h1 = getHeight();

	    double x2 = other.getXReal();
	    double y2 = other.getYReal();
	    int w2 = other.getWidth();
	    int h2 = other.getHeight();

	    return x1 < x2 + w2 && x1 + w1 > x2 && y1 < y2 + h2 && y1 + h1 > y2;
	}
	
	protected void addFrameCount() {
		frameCount++;
	}

}
