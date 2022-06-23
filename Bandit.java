
/**
 * The Bandit is one of the enemies the user will face. The Bandit class functions similarly to the 
 * Player class when in combat, but will not be controlled by the user.
 * 
 * @author dliu
 *
 */
public class Bandit extends Being implements Dodge, Run {

	//Constructor
	public Bandit(String name, int hp, int strength, int agility, int vitality) {
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
	 * This method sees if the Bandit can run from a Being
	 * @param other
	 */	public boolean run(Being other) {
		//Sees if the Bandit is fast enough to run away from fights
		return this.agility + (int) (Math.random() * 10) > other.agility + (Math.random() * 10);
	}

	/**
	 * This method sees if the Bandit is fast enough to dodge an attack, dodging is based on Agility and luck
	 */
	public boolean dodge(Being other) {
		//Sees if the Bandit is fast enough to dodge an attack
		return this.agility + (int) (Math.random() * 3) > other.agility + (Math.random() * 10);

	}

	/**
	 * This method allows the Bandit to "trash talk" in the middle of a fight or provide
	 * a prompt for the user to read.
	 */
	public void talk(String tell) {
		//Is a prompt for the user
		if (tell.equals("prompt")) {
			String[] prompt = {"\nTHE " + this.getName() + " IS STARING YOUR PARTY DOWN, WHAT WILL YOU DO?", 
					"\nTHE " + this.getName() + " IS CAREFULLY ANALYSING THE SITUATION, WHAT WILL YOU DO?",
					"\nTHE " + this.getName() + " IS GETTING NERVOUS, WHAT WILL YOU DO?"};
			//Output a random prompt
			System.out.println(prompt[(int) (Math.random() * 3)]);

		}
		//If the Bandit is attacking
		else if (tell.equals("attack")) {
			String[] attack = {"I'LL GET YOU!", "TAKE THIS!", "I'M COMING FOR YOU!"};
			//Output a random phrase
			System.out.println(this.getName() + ": " + attack[(int) (Math.random() * 3)]);

		}
		//If the Bandit is being attacked
		else if (tell.equals("defend")) {
			String[] defend = {"THAT DIDN'T EVEN HURT!", "OUCH", "GET OUTTA HERE!"};
			//Output a random phrase
			System.out.println(this.getName() + ": " + defend[(int) (Math.random() * 3)]);
		}
	}

}



