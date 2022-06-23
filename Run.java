/**
 * This interface allows Beings to see if they are able to run from a fight
 * Being
 * @author dliu
 *
 */
public interface Run {

	/**
	 * Allows a Being to see if they can run from a fight
	 * @param other
	 * @return
	 */
	boolean run(Being other);
	
}
