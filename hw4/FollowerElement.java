package hw4;

/**
 * A follower element is one that is associated with another "base" element such
 * as a PlatformElement or LiftElement. Specifically, the follower element's
 * movement is determined by the movement of the base element, when the base
 * move up 10 pixels, the follower moves up 10 pixels. However, the follower may
 * not always be at a fixed location relative to the base. When the horizontal
 * velocity of the follower is set to a non-zero value, the follower will
 * oscillate between the left and right edges of the PlatformElement or
 * LiftElement it is associated with.
 * 
 * @author Caleb Hemmestad
 */
public class FollowerElement extends PlatformElement{
	/**
	 * Variable for the amount of offset for the object
	 */
	private int offset;
	/**
	 * Variable for storing the base object
	 */
	private api.AbstractElement base;

	/**
	 * Constructs a new FollowerElement. Before being added to a "base" element such
	 * as a PlatformElement or LiftElement, the x and y coordinates are zero. When a
	 * base element is set, the initial x-coordinate becomes the base's
	 * x-coordinate, plus the given offset, and the y-coordinate becomes the base's
	 * y-coordinate, minus this element's height.
	 * 
	 * @param width         element's width
	 * @param height        element's height
	 * @param initialOffset when added to a base, this amount will be added to the
	 *                      bases's x-coordinate to calculate this element's initial
	 *                      x-coordinate
	 */
	public FollowerElement(int width, int height, int initialOffset) {
		super(0, 0, width, height);
		this.offset = initialOffset;
	}
	
	/**
	 * Sets the base and saves it for later use
	 * @param b
	 */
	public void setBase(api.AbstractElement b) {
		base = b;
		this.setPosition(b.getXReal() + offset, b.getYReal() - b.getHeight());
		this.setBounds(b.getXReal(), b.getXReal() + b.getWidth());
	}
	
	/**
	 * Updates the position and the framecount for the object
	 */
	@Override
	public void update() {
		addFrameCount();
		this.setPosition(this.getXReal() + this.getDeltaX() + ((PlatformElement)base).getDeltaX(), base.getYReal() - this.getHeight());
		this.setBounds(base.getXReal(), base.getXReal() + base.getWidth());
		if(this.getXReal() + this.getWidth() >= this.getMax()) {
			this.setVelocity(getDeltaX()*-1, getDeltaY());
			this.setPosition(this.getMax() - this.getWidth(), base.getYReal() - this.getHeight());
		} else if(this.getXReal() <= this.getMin()) {
			this.setVelocity(getDeltaX()*-1, getDeltaY());
			this.setPosition(this.getMin(), base.getYReal() - this.getHeight());
		} else if(this.getYReal() + this.getHeight() > this.getMax()) {
			this.setVelocity(getDeltaX(), getDeltaY()*-1);
		} else if(this.getYReal() < this.getMin()) {
			this.setVelocity(getDeltaX(), getDeltaY()*-1);
		}
//		this.setPosition(this.getXReal() + this.getDeltaX() + ((PlatformElement)base).getDeltaX(), base.getYReal() - this.getHeight());
//		this.setBounds(base.getXReal(), base.getXReal() + base.getWidth());
	}

}
