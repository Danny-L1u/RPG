
/**
 * The SuperZombie is one of the enemies the user will face
 * The SuperZombie that can do everything a Zombie can
 * and is able to spit and lower a Being's agility
 * 
 * @author dliu
 */
public class SuperZombie extends Zombie{

	//Constructor
	public SuperZombie(String name, int hp, int strength, int agility, int vitality) {
		super(name, hp, strength, agility, vitality);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * This method allows the SuperZombie to "spit" 
	 * and lowers a Beings agility
	 * @param other
	 */
	public void spit(Being other) {
		//Lower Player agility to 0
		other.setAgility(0);
	}
}

