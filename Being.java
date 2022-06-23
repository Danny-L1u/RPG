
/**
 * The Being class is an abstract class, class inherits from the Being class.
 * The Beinf class outlines the fundamentals of a character such as 
 * Name, Hp, Strength, Agility, and Vitality.
 * @author dliu
 *
 */
public abstract class Being {

	String name;
	int Hp;
	int strength;
	int agility;
	int vitality;

	
	//Constructor
	public Being(String name, int hp, int strength, int agility, int vitality) {
		super();
		this.name = name;
		this.Hp = hp;
		this.strength = strength;
		this.agility = agility;
		this.vitality = vitality;
	}

	
	//Getters & Setters
	public int getHp() {
		return Hp;
	}

	public void setHp(int hp) {
		Hp = hp;
	}

	public int getVitality() {
		return vitality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}
	
	//Every Being must be able to melee attack another Being
	public abstract void melee(Being other);

}
