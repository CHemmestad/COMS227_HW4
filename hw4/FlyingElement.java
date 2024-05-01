package hw4;

/**
 * Moving element in which the vertical velocity is adjusted each frame by a
 * gravitational constant to simulate gravity. The element can be set to
 * "grounded", meaning gravity will no longer influence its velocity.
 * 
 * @author Caleb Hemmestad
 */
public class FlyingElement extends MovingElement{
	/**
	 * Variable for knowing if its on the ground
	 */
	private boolean grounded;
	/**
	 * Variable for storing gravity
	 */
	private double gravity;

	/**
	 * Constructs a new FlyingElement. By default it should be grounded, meaning
	 * gravity does not influence its velocity.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public FlyingElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		this.grounded = true;
		this.gravity = 0;
	}
	
	/**
	 * Tells you if the object is grounded
	 * @return is it grounded
	 */
	public boolean isGrounded() {
		return grounded;
	}
	
	/**
	 * Sets grounded to true if it is
	 * @param grounded
	 */
	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}
	
	/**
	 * Sets the amount of gravity affecting the object
	 * @param gravity
	 */
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	/**
	 * Updates the position and the framecount of the object
	 */
	@Override
	public void update() {
		addFrameCount();
		if(grounded) {
			this.setPosition(this.getXReal() + getDeltaX(), this.getYReal() + getDeltaY());
		} else {
			this.setPosition(this.getXReal() + getDeltaX(), this.getYReal() + getDeltaY());
			this.setVelocity(getDeltaX(), getDeltaY() + gravity);
		}
	}
}
