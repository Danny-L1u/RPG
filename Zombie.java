
/**
 * The Zombie is one of the enemies in the user will face. The zombie only
 * attacks when enabled to, and has no sense of strategy.
 * 
 * @author dLIU
 *
 */
public class Zombie extends Being implements Talk {

	//Constructor
	public Zombie(String name, int hp, int strength, int agility, int vitality) {
		super(name, hp, strength, agility, vitality);
		
	}

	/**
	 * This method attacks a Being, damage is based on Strength and luck
	 * @param other
	 */
	public void melee(Being other) {
		//Damages the opponent
		other.setHp(other.getHp() - this.strength + (int) (Math.random() * 5));
	}

	/**
	 * This method allows the Bandit to "trash talk" in the middle of a fight or provide
	 * a prompt for the user to read.
	 */
	public void talk(String tell) {
		//Is a prompt for the user
		if (tell.equals("prompt")) {
			String[] prompt = {"THE " + this.getName() + " LOOKS HUNGRY, WHAT WILL YOU DO?", 
					"THE " + this.getName() + " IS STARING AT YOUR PARTY, WHAT WILL YOU DO?",
					"THE " + this.getName() + " LOOKS WEIRD, WHAT WILL YOU DO?"};
			//Output a random prompt
			System.out.println(prompt[(int) (Math.random() * 3)]);

		}
		//If Zombie is attacking or defending
		else {
			String[] talk = {"ARGGHH!", "AAARRRRGGGHHHHHHHH!", "AAARRRRRRRRRGGGGGGGH!"};
			//Randomly output a response
			System.out.println(this.getName() + ": " + talk[(int) (Math.random() * 3)]);
		}
	}

}
