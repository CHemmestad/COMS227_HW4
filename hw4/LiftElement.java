package hw4;

import api.AbstractElement;

/**
 * An element with two distinctive behaviors. First, it can be set up to move
 * vertically within a fixed set of boundaries. On reaching a boundary, the
 * y-component of its velocity is reversed. Second, it maintains a list of
 * <em>associated</em> elements whose basic motion all occurs relative to the
 * LiftElement.
 * 
 * @author Caleb Hemmestad
 */
public class LiftElement extends PlatformElement{
// Is the same as the platform object except it goes up and down
	/**
	 * Constructs a new Elevator. Initially the upper and lower boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public LiftElement(double x, double y, int width, int height) {
		super(x, y, width, height);
	}
	
	/**
	 * Updates the movement for the object and all the objects associated with it
	 */
	@Override
	public void update() {
		addFrameCount();
		this.setPosition(this.getXReal() + getDeltaX(), this.getYReal() + getDeltaY());
		if(this.getYReal() > this.getMax()) {
			this.setVelocity(getDeltaX(), getDeltaY()*-1);
		} else if(getYReal() - this.getHeight() < this.getMin() - this.getHeight()) {
			this.setVelocity(getDeltaX(), getDeltaY()*-1);
		}
		for(AbstractElement associated : getAssociated()) {
			associated.update();
		}
	}
}