/**
 * This interface allows Beings to see if they can dodge an attack from another being
 * Being
 * @author dliu
 *
 */
public interface Dodge {

	/**
	 * Allows a Being to see if they can dodge an attack from another Being
	 * @param other
	 * @return
	 */
	boolean dodge(Being other);
	
}
