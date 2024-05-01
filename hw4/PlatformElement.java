package hw4;

import java.util.ArrayList;
import api.AbstractElement;

/**
 * A PlatformElement is an element with two distinctive behaviors. First, it can
 * be set up to move horizontally within a fixed set of boundaries. On reaching
 * a boundary, the x-component of its velocity is reversed. Second, it maintains
 * a list of <em>associated</em> elements whose basic motion all occurs relative
 * to the PlatformElement.
 * 
 * @author Caleb Hemmestad
 */
public class PlatformElement extends MovingElement{
	/**
	 * Stores all of the elements for the platform
	 */
	private ArrayList<AbstractElement> associated;
	/**
	 * Stores how far the abject can move up or right on the screen
	 */
	private double max;
	/**
	 * Stores how far the object can move left or down on the screen
	 */
	private double min;

	/**
	 * Constructs a new PlatformElement. Initially the left and right boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	public PlatformElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		associated = new ArrayList<AbstractElement>();
		max = Double.POSITIVE_INFINITY;
		min = Double.NEGATIVE_INFINITY;
	}
	
	/**
	 * Adds the objects on the platform to the array
	 * @param attached
	 */
	public void addAssociated(AttachedElement attached) {
		associated.add(attached);
		attached.setBase(this);
	}
	
	/**
	 * Adds the objects on the platform to an array
	 * @param follower
	 */
	public void addAssociated(FollowerElement follower) {
		associated.add(follower);
		follower.setBase(this);
	}
	
	/**
	 * Deletes all of the objects in the array that have been marked for deletion
	 */
	public void deleteMarkedAssociated() {
		ArrayList<AbstractElement> toRemove = new ArrayList<>();
	    for (AbstractElement associated : associated) {
	        if (associated.isMarked()) {
	            toRemove.add(associated);
	        }
	    }
	    this.associated.removeAll(toRemove);
	}
	
	/**
	 * Gets the farthest it can move right or up
	 * @return max
	 */
	public double getMax() {
		return max;
	}
	
	/**
	 * Gets the farthest it can move down or left
	 * @return min
	 */
	public double getMin() {
		return min;
	}
	
	/**
	 * Sets the bounds for the object, the min and max
	 * @param min
	 * @param max
	 */
	public void setBounds(double min, double max) {
		this.min = min;
		this.max = max;	
	}
	
	/**
	 * Gets the array of all the objects
	 * @return the associated objects
	 */
	public ArrayList<AbstractElement> getAssociated() {
		return associated;
	}
	
	/**
	 * Updates the movement for the object and all the objects associated with it
	 */
	@Override
	public void update() {
		addFrameCount();
		if(this.getXReal() + this.getWidth() > max) {
			this.setVelocity(getDeltaX()*-1, getDeltaY());
		} else if(getXReal() < min) {
			this.setVelocity(getDeltaX()*-1, getDeltaY());
		}
		if(this.getYReal() > this.getMax()) {
			this.setVelocity(getDeltaX(), getDeltaY()*-1);
		} else if(getYReal() + this.getHeight() < this.getMin()) {
			this.setVelocity(getDeltaX(), getDeltaY()*-1);
		}
		this.setPosition(this.getXReal() + getDeltaX(), this.getYReal() + getDeltaY());
		for(AbstractElement associated : associated) {
			associated.update();
		}
	}

}
