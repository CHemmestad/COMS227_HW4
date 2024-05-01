package hw4;

/**
 * An attached element is one that is associated with another "base" element
 * such as a PlatformElement or a LiftElement. Specifically, the attached
 * element's movement is determined by the movement of the base element, the
 * element always remains a fixed distance away.
 * 
 * @author Caleb Hemmestad
 */
public class AttachedElement extends PlatformElement{
	/**
	 * Variable for the offset
	 */
	private int offset;
	/**
	 * Variable for the hover
	 */
	private int hover;
	/**
	 * Variable to store the base information
	 */
	private api.AbstractElement base;
	/**
	 * Constructs a new AttachedElement. Before being added to an associated "base"
	 * element such as a PlatformElement or LiftElement, the x and y coordinates are
	 * initialized to zero. When the base object is set (not in this constructor),
	 * the x-coordinate will be calculated as the base object's x-coordinate, plus
	 * the given offset, and the y-coordinate will become the base object's
	 * y-coordinate, minus this element's height, minus the hover amount.
	 * 
	 * @param width  element's width
	 * @param height element's height
	 * @param offset when added to a base object, this amount will be added to the
	 *               other object's x-coordinate to calculate this element's
	 *               x-coordinate
	 * @param hover  when added to a base object, this element's y-coordinate is the
	 *               other object's y-coordinate, minus this element's height, minus
	 *               the hover amount
	 */
	public AttachedElement(int width, int height, int offset, int hover) {
		super(0, 0, width, height);
		this.offset = offset;
		this.hover = hover;
	}
	
	/**
	 * Sets the base and saves it for later use
	 * @param b
	 */
	public void setBase(api.AbstractElement b) {
		base = b;
		this.setPosition(b.getXReal() + offset, b.getYReal() - b.getHeight() - hover);
		this.setBounds(b.getXReal(), b.getXReal() + b.getWidth());
	}
	/**
	 * Updates the position and increments frame count
	 */
	@Override
	public void update() {
		addFrameCount();
		if(this.getXReal() + this.getWidth() > this.getMax()) {
			this.setVelocity(getDeltaX()*-1, getDeltaY());
		} else if(this.getXReal() < this.getMin()) {
			this.setVelocity(getDeltaX()*-1, getDeltaY());
		}
		this.setPosition(base.getXReal() + offset, base.getYReal() - this.getHeight() - hover);
	}

}
