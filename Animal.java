
/**
 * The Animal will be one of the things the user will control. The Animal class is similar to the Player class 
 * with the exception of some methods and variables. 
 * 
 * @author dliu
 * 
 */
public class Animal extends Being implements Charm, Run, Talk, Dodge {

	int charisma;
	String type;

	//Constructor
	public Animal(String name, int hp, int strength, int agility, int vitality, int charisma, String type) {
		super(name, hp, strength, agility, vitality);

		this.charisma = charisma;
		this.type = type;
	}

	//Getters & Setters
	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getVitality() {
		return vitality;
	}

	public void setVitality(int vitality) {
		this.vitality = vitality;
	}

	public String getType() {
		return type;
	}


	/**
	 * This method sees if the Animal can run from a Being
	 * @param other
	 */
	public boolean run(Being other) {
		//Sees if the animal is fast enough to run
		return this.getAgility() + (int) (Math.random() * 10) > other.getAgility() + (Math.random() * 5);
	}

	/**
	 * This method sees if the Animal can "charm" a bandit to leave 
	 * @param other
	 */
	public boolean charm(Being other) {
		//Can't charm a zombie
		if (other instanceof Zombie) {
			System.out.println("You can't charm a Zombie!");
			return false;
		} 
		//Animal tries to charm a Bandit
		else {
			//Sees if the animal is charismatic enough to charm the opponent
			return (this.getCharisma() + (int) (Math.random() * 5) > 10); 
		}
	}

	/**
	 * This method attacks a Being, damage is based on Strength and luck
	 * @param other
	 */
	public void melee(Being other) {
		//Damages the opponent
		other.setHp(other.getHp() - this.getStrength() + (int) (Math.random() * 5)); 
	}

	/**
	 * Animal eats food, if not enough food, subtract from Strength if not at max
	 * @param food
	 * @return
	 */
	public int eat(int food) {
		//Animals take up 2 food
		food -= 2;

		//If there is not enough food, Strength decreases
		if (food < 0) {
			System.out.println("Food -" + food);
			//If there is strength to take away
			if (strength > 0) {
				System.out.println("WITH LITTLE TO NO FOOD TO EAT, " + name + " FEELS WEAKER.\n"
						+ name + " STRENGTH -1\n");
				//Take away 1 strength
				strength--;
			}
			//return food left over
			return 0;
		}

		System.out.println("Food -2");
		//If there is enough food Strength increases
		if (strength < 10) {
			System.out.println(name + " IS POWERED BY THE FOOD.\n"
					+ name + " STRENGTH +1\n");
			//Add 1 to strength
			strength++;
		}
		//return food left over
		return food;
	}

	/**
	 * This method allows the Animal to "trash talk" in the middle of a fight
	 */
	public void talk(String tell) {
		//If the animal is a dog
		if (this.getType().toLowerCase().equals("dog")) {
			String[] talk = {"WOOF!", "RUFF!", "ARF!"};
			//Randomly output a response
			System.out.println(this.getName() + ": " + talk[(int) (Math.random() * 3)]);
		}
		//If the animal is a cat
		else if (this.getType().toLowerCase().equals("cat")) {
			String[] talk = {"MEOW.", "HISS!", "EEEEEEEEAAAAAAARRRRRRRRRRREIR!"};
			//Randomly output a response
			System.out.println(this.getName() + ": " + talk[(int) (Math.random() * 3)]);
		}
	}

	/**
	 * This method sees if the Animal is fast enough to dodge an attack, dodging is based on Agility and luck
	 */
	public boolean dodge(Being other) {
		//Sees if the Animal is fast enough to dodge an attack
		return this.agility + (int) (Math.random() * 10) > other.agility + (Math.random() * 10);
	}

	//toString
	public String toString() {
		return name 
				+ "\nHp: " + Hp + "/" + vitality 
				+ "\nStrength: " + strength
				+ "\nAgility: " + agility
				+ "\nCharisma: " + charisma
				+ "\nSpecies: " + type;
	}

}
