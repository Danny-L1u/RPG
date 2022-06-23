
/**
 * This class will be one of the things the user will control. The Player class is similar to the Animal class 
 * with the exception of more methods and variables. 
 * 
 * @author dliu
 *
 */
public class Player extends Bandit {

	int medical;
	int charisma;
	int shooting;

	//Constructor
	public Player(String name, int hp, int strength, int agility, int vitality, int medical, int charisma) {
		super(name, hp, strength, agility, vitality);
		this.medical = medical;
		this.charisma = charisma;
	}


	//Getters & Setters
	public int getMedical() {
		return medical;
	}

	public void setMedical(int medical) {
		this.medical = medical;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}


	/**
	 * See if the Player can "charm" a bandit to leave 
	 * @param other
	 * @return
	 */
	public boolean charm(Being other) {
		//Can't charm a zombie
		if (other instanceof Zombie) {
			System.out.println("YOU CAN'T CHARM A ZOMBIE");
			return false;
		} 

		else {
			//Sees if the animal is charismatic enough to charm the opponent
			return this.charisma + (int) (Math.random() * 5) > 10; 
		}
	}


	/**
	 * See if the Player can flee from the attack
	 */
	public boolean run(Being other) {
		//Sees if the Player is fast enough to run away from fights
		return this.agility + (int) (Math.random() * 5) > other.agility + (Math.random() * 8);
	}

	/**
	 * This method sees if the Player is fast enough to dodge an attack, dodging is based on Agility and luck
	 */
	public boolean dodge(Being other) {
		//Sees if the Player is fast enough to dodge an attack
		return this.agility + (int) (Math.random() * 5) > other.agility + (Math.random() * 10);

	}

	/**
	 * This method allows a Player heals a Being based on their Medical ability
	 * @param other
	 */
	public void heal(Being other) {
		other.setHp(other.getHp() + medical * 3);

		//If healing puts the Being other top Hp possible,
		//lower Hp to the top Hp possible
		if (other.getHp() > other.getVitality()) {
			other.setHp(other.getVitality());
		}
	}

	/**
	 * Animal eats food, if not enough food, subtract from Strength if not at max
	 * @param food
	 * @return
	 */
	public int eat(int food) {
		//Players take up 4 food
		food -= 4;

		//If there is not enough food, Strength decreases
		if (food < 0) {
			System.out.println("Food -" + food);
			if (strength > 0) {
				System.out.println("WITH LITTLE TO NO FOOD TO EAT, " + name + " FEELS WEAKER.\n"
						+ name + " STRENGTH -1\n");
				strength--;
			}
			//return food left over
			return 0;
		}

		System.out.println("Food -4");
		//If there is enough food Strength increases
		if (strength < 10) {
			System.out.println(name + " IS POWERED BY THE FOOD.\n"
					+ name + " STRENGTH +1\n");
			strength++;
		}
		//return food left over
		return food;
	}

	/**
	 * This method allows the Bandit to "trash talk" in the middle of a fight or provide
	 * a prompt for the user to read.
	 */
	public void talk(String tell) {
		//If the Player is attacking
		if (tell.equals("attack")) {
			String[] attack = {"I'LL PUT THE HURT ON YOU!", "I'M COMING FOR YOU!", "THIS WILL HURT!"};
			//Output a random phrase
			System.out.println(this.getName() + ": " + attack[(int) (Math.random() * 3)]);

		}
		//If the Player is being attacked
		else if (tell.equals("defend")) {
			String[] defend = {"GET AWAY FROM ME!", "RUN!!!", "HELP ME!"};
			//Output a random phrase
			System.out.println(this.getName() + ": " + defend[(int) (Math.random() * 3)]);
		}
	}

	//toString
	public String toString() {
		return name 
				+ "\nHp: " + Hp + "/" + vitality
				+ "\nAgility: " + agility
				+ "\nStrength: " + strength
				+ "\nCharisma: " + charisma;
	}
}

