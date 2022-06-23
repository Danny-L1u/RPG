
import java.io.*;
import java.util.*;

/**
 * This class is a game that takes the user through a series of events.
 * It starts with a title screen, then takes the user to a guided character creation.
 * Once the user creates their character, they then start the game.
 * This game is very similar to a "Choose Your Own Adventure" book
 * where the user can choose what locations to go to and what Beings 
 * to recruit. The user will be forced to go through events and 
 * will fight enemies such as Zombies and Bandits, the user must be strategical 
 * as sometimes it is best option is not fighting.
 * @author dliu
 */
public class Driver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("WELCOME TO DEATH ROAD TO AMERICA!"
				+ "\nYOUR OBJECTIVE: GET TO AMERICA AT ALL COSTS"
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		System.out.println("CHOOSE YOUR CHARACTER TYPE: "
				+ "\n1. WARRIOR"
				+ "\n2. ATHLETE"
				+ "\n3. CHARMER");

		int picked = Choice(1, 3, "TYPE DOES NOT EXIST");

		Player player1;
		//If user picked Warrior
		if (picked == 1) {
			player1 = new Player("", 100, 8, 6, 100, 5, 3);
		}
		//If user picked Athlete
		else if (picked == 2){
			player1 = new Player("", 75, 5, 8, 75, 5, 4);
		}
		//If user picked Charmer
		else {
			player1 = new Player("", 50, 3, 5, 50, 7, 9);
		}
		//ArrayList of party members, the Beings the user can control
		ArrayList <Being> party = new ArrayList<Being>();

		//Array of supplies that can be manipulated in methods
		int[] Supplies = new int[4];
		//Food
		Supplies[0] = 10;
		//Medical Supplies
		Supplies[1] = 5;
		//Gas
		Supplies[2] = 30;

		System.out.print("PLEASE ENTER YOUR PLAYER NAME: ");
		String name = in.nextLine().toUpperCase();

		//Player created by user
		player1.setName(name);
		party.add(player1);

		//Story/Game official start
		System.out.println("\nFOR WEEKS NOW " + name + " HAS BEEN HIDING FROM THE ZOMBIES BY BUNKERING IN THEIR HOUSE, BUT WITH THE "
				+ "FOOD RUNNING OUT, " + name + " NEEDS TO FIND ANOTHER PLACE TO STAY.\nWORD ON THE STREET IS THE UNITED STATES OF AMERICA IS "
				+ "ZOMBIE-FREE BECAUSE OF ALL THE GUNS,SO " + name + " HAS DECIDED TO TRAVEL TO THE UNITED STATES IN HOPE FOR SALVATION."
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		//Scenario One
		ScenarioOne(party, Supplies);
		System.out.println("Food: " + Supplies[0] + "\nMedical Supplies: " + Supplies[1] + "\nGas: " + Supplies[2] + "\n");
		//Output information of Beings in party
		for (int i = 0; i < party.size(); i++) {
			System.out.println(party.get(i).toString());
		}

		//Downtime
		System.out.println("\nWHILE BETWEEN PITSTOPS THERE IS TIME TO WASTE");
		downtime(party, Supplies);
		//Beings need to eat food
		for (Being character : party) {
			//If character is a Player
			if (character instanceof Player) {
				Supplies[0] = ((Player) character).eat(Supplies[0]);
			}
			//If character is an Animal
			else {
				Supplies[0] = ((Animal) character).eat(Supplies[0]);
			}
		}
		//Take away gas for driving
		Supplies[2] -= 10;
		System.out.println("Gas -10\n");
		//If the user runs out of gas
		if (Supplies[2] <= 0 ) {
			Walking (party, Supplies);
		}

		//Scenario Two
		System.out.println("AFTER DRIVING FOR A WHILE " + party.get((int) (Math.random() * party.size())).getName() + " DECIDES IT'S TIME TO MAKE A PIT STOP."
				+ "\n1. SCHOOL"
				+ "\n2. KEEP ON DRIVING");
		//Location selection
		int location = Choice(1, 2, "LOCATION DOES NOT EXIST");
		//If user chooses to go to School
		if (location == 1) {
			School(party, Supplies);
		}

		System.out.println("Food: " + Supplies[0] + "\nMedical Supplies: " + Supplies[1] + "\nGas: " + Supplies[2] + "\n");
		//Downtime
		System.out.println("WHILE BETWEEN PITSTOPS THERE IS TIME TO WASTE");
		downtime(party, Supplies);
		//Beings need to eat food
		for (Being character : party) {
			//If character is a Player
			if (character instanceof Player) {
				Supplies[0] = ((Player) character).eat(Supplies[0]);
			}
			//If character is an Animal
			else {
				Supplies[0] = ((Animal) character).eat(Supplies[0]);
			}
		}
		//Take away gas for driving
		Supplies[2] -= 10;
		System.out.println("Gas -10\n");
		//If the user runs out of gas
		if (Supplies[2] <= 0 ) {
			Walking (party, Supplies);
		}

		//Scenario Two
		System.out.println("AFTER DRIVING FOR A WHILE " + party.get((int) (Math.random() * party.size())).getName() + " DECIDES IT'S TIME TO MAKE A PIT STOP"
				+ "\n1. PET CLINIC"
				+ "\n2. DMV"
				+ "\n3. KEEP DRIVING");
		//Location selection
		location = Choice(1, 3, "LOCATION DOES NOT EXIST");

		//If user picks pet clinic
		if (location == 1) {
			Pet_Clinic(party, Supplies);
		}
		//If user picks DMV
		else if (location == 2) {
			DMV(party, Supplies);
		}

		System.out.println("Food: " + Supplies[0] + "\nMedical Supplies: " + Supplies[1] + "\nGas: " + Supplies[2] + "\n");
		//Downtime
		System.out.println("WHILE BETWEEN PITSTOPS THERE IS TIME TO WASTE");
		downtime(party, Supplies);
		//Beings need to eat food
		for (Being character : party) {
			//If character is a Player
			if (character instanceof Player) {
				Supplies[0] = ((Player) character).eat(Supplies[0]);
			}
			//If character is an Animal
			else {
				Supplies[0] = ((Animal) character).eat(Supplies[0]);
			}
		}
		//Take away gas for driving
		Supplies[2] -= 10;
		System.out.println("Gas -10\n");
		//If the user runs out of gas
		if (Supplies[2] <= 0 ) {
			Walking (party, Supplies);
		}

		//Scenario Three 
		System.out.println("AFTER DRIVING FOR A WHILE " +  party.get((int) (Math.random() * party.size())).getName() + " DECIDES IT'S TIME TO MAKE A PIT STOP"
				+ "\n1. Yall-Mart"
				+ "\n2. KOSTKO"
				+ "\n3. KEEP DRIVING");
		//Location selection
		location = Choice(1, 3, "LOCATION DOES NOT EXIST");

		//If user picks Yall-Mart
		if (location == 1) {
			Yall_Mart(party, Supplies);
		}
		//If user picks KostKo
		else if (location == 2){
			KostKo(party, Supplies);
		}

		System.out.println("Food: " + Supplies[0] + "\nMedical Supplies: " + Supplies[1] + "\nGas: " + Supplies[2] + "\n");
		//Downtime
		System.out.println("WHILE BETWEEN PITSTOPS THERE IS TIME TO WASTE");
		downtime(party, Supplies);
		//Beings need to eat food
		for (Being character : party) {
			//If character is a Player
			if (character instanceof Player) {
				Supplies[0] = ((Player) character).eat(Supplies[0]);
			}
			//If character is an Animal
			else {
				Supplies[0] = ((Animal) character).eat(Supplies[0]);
			}
		}
		//Take away gas for driving
		Supplies[2] -= 10;
		System.out.println("Gas -10\n");
		//If the user runs out of gas
		if (Supplies[2] <= 0 ) {
			Walking (party, Supplies);
		}

		//Final Scenario
		FinalScenario(party, Supplies);
	}


	/**
	 * This method is the first scenario the user is put into, it is easy to
	 * let the user get a feel for the combat, also prepares the user for 
	 * future scenarios.
	 * 
	 * @param party
	 * @param Supplies
	 */
	public static void ScenarioOne(ArrayList <Being> party, int[] Supplies) {
		Scanner in = new Scanner(System.in);

		System.out.println("AFTER PACKING SUPPLIES " + party.get(0).getName() + " DECIDES IT'S TIME TO LEAVE. OUTSIDE THE HOUSE THERE IS A STRAY"
				+ " ZOMBIE WANDERING AROUND. " + party.get(0).getName() + " DECIDES FIGHTING THE ZOMBIE WOULD BE GOOD PRACTICE."
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		//Enemy
		Zombie zombie1 = new Zombie("ZOMBIE", 25, 10, 5, 25);

		//Party & enemy fight each other 
		fight(party, zombie1);

		System.out.println(party.get(0).getName() + ": THAT WAS EASY!\n\n" + party.get(0).getName() + " GETS IN THEIR PONTIAC "
				+ "AND STARTS THE JOURNEY TO AMERICA"
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();
	}


	/**
	 * This method is the final scenario the user has to go through to win.
	 * 
	 * @param party
	 * @param Supplies
	 */
	public static void FinalScenario(ArrayList <Being> party, int[] Supplies) {
		Scanner in = new Scanner(System.in);

		System.out.println("YOUR PARTY IS SO CLOSE TO MAKING IT TO AMERICA, THE BORDER IS WITHIN SIGHT! "
				+ "UNFORTUNATLY YOUR PARTY WAS NOT PAYING ATTENTION AND BANDITS SURROUNDED YOUR PARTY!"
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		//Enemies
		Bandit bandit1 = new Bandit("BANDIT", 40, 5, 5, 40);
		Bandit bandit2 = new Bandit("BANDIT", 25, 3, 5, 25);
		Bandit bandit3 = new Bandit("BANDIT", 45, 5, 5, 45);

		System.out.println(bandit1.getName() + ": GIVE US HALF YOUR FOOD, HALF OF YOUR MEDICAL SUPPLIES,"
				+ " AND WE WILL LEAVE YOU ALONE.\n1. GIVE AWAY SUPPLIES\n2. CHARM THE BANDITS TO LEAVE\n3. FIGHT BACK");
		int action = Choice(1, 3, "ACTION DOES NOT EXIST");;

		//If user chooses to surrender supplies
		if (action == 1) {
			Supplies[0] /= 2;
			Supplies[1] /=2;

			System.out.println(bandit1.getName() + ": THANKS SEE YA!");
		}

		//User tries to charm bandits
		else if (action == 2) {
			System.out.println("WHO SHOULD TALK TO THE BANDITS?");

			//Whose going to do what? (Character selection)
			System.out.println("\nSELECT A CHARACTER IN YOUR PARTY: ");
			for (int i = 0; i < party.size(); i++) {
				//If character selected is a Player
				if (party.get(i) instanceof Player) {
					System.out.println((i + 1) + ": " + party.get(i).getName() + " (Charisma: " + ((Player) party.get(i)).getCharisma() + ")");
				}
				//If character selected is an Animal
				else {
					System.out.println((i + 1) + ": " + party.get(i).getName() + " (Charisma: " + ((Animal) party.get(i)).getCharisma() +")");
				}
			}
			//Character Selection
			int picked = Choice(0, party.size(), "PARTY MEMBER DOES NOT EXIST") - 1;

			//If the convincer is a player
			if (party.get(picked) instanceof Player) {
				//If charm is successful
				if (((Player) party.get(picked)).charm(bandit1)) {
					System.out.println(party.get(picked).getName() + " CONVINCED THE BANDITS TO LEAVE.");
				}
				//If charm isn't successful
				else {
					System.out.println(party.get(picked).getName() + " COULDN'T CONVINCE THE BANDITS TO LEAVE.");
					fight(party, bandit1);
					fight(party, bandit2);
					fight(party, bandit3);
				}
			}
			//If the convincer is an animal
			else {
				if (((Animal) party.get(picked)).charm(bandit1)) {
					System.out.println(party.get(picked).getName() + " CONVINCED THE BANDITS TO LEAVE.");
				}
				//If charm isn't successful
				else {
					System.out.println(party.get(picked).getName() + " COULDN'T CONVINCE THE BANDITS TO LEAVE.");
					fight(party, bandit1);
					fight(party, bandit2);
					fight(party, bandit3);
				}
			}
		}

		//If user wants to fight the bandits
		else if (action == 3) {
			fight(party, bandit1);
			fight(party, bandit2);
			fight(party, bandit3);
		}

		//Downtime
		System.out.println("WITH THE BANDITS GONE THERE IS TIME TO REST");
		downtime(party, Supplies);
		//Beings need to eat food
		for (Being character : party) {
			//If character is a Player
			if (character instanceof Player) {
				Supplies[0] = ((Player) character).eat(Supplies[0]);
			}
			//If character is an Animal
			else {
				Supplies[0] = ((Animal) character).eat(Supplies[0]);
			}
		}

		//Final Fight
		System.out.println("\nAS YOUR PARTY APROACHES THE AMERICAN BORDER, A HORDE OF ZOMBIES GATHER AROUND."
				+ " IN THE CENTER OF THE HORDER IS A LARGER, BIGGER ZOMBIE."
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		//Enemies
		Zombie zombie1 = new Zombie("ZOMBIE", 78, 5, 10, 78);
		Zombie zombie2 = new Zombie("ZOMBIE", 39, 6, 10, 39);
		SuperZombie zombie4 = new SuperZombie("SUPERZOMBIE", 80, 8, 10, 80);

		fight(party, zombie1);
		fight(party, zombie2);

		System.out.println("\nAS YOUR PARTY APPROACHES THE SUPERZOMBIE, THE SUPERZOMBIE SPITS IN EVERYONE'S FACE."
				+ "\nIT GETS EVERYWHERE AND YOUR PARTY HAS DIFFICULTY SEEING.");
		//Spit in every Being to reduce agility
		for (Being character: party) {
			zombie4.spit(character);
			System.out.println(character.getName() + " Agility: " + character.getAgility());
		}

		fight(party, zombie4);

		System.out.println("AS YOUR PARTY TAKES DOWN THE SUPERZOMBIE THE HORDE OF ZOMBIES AHEAD OF YOU ARE TAKEN DOWN"
				+ " \nBY THE AMERICAN SOILDERS AT THE BORDER. YOUR PARTY RUNS THROUGH THE OPENING CREATED IN THE HORDE"
				+ " \nOF ZOMBIES AND MAKE IT THROUGH THE AMERICAN BORDER. AT LAST YOUR PARTY IS SAFE FROM ZOMBIES."
				+ " \nJOE BIDEN PERSONALLY GREETS AND CONGRATULATES YOUR PARTY ON MAKING IT TO AMERICA"
				+ " \n\n---THE END---");
	}


	/**
	 * This method is one of the scenarios the user can get into.
	 * 
	 * @param party
	 * @param Supplies
	 */
	public static void Yall_Mart(ArrayList <Being> party, int[] Supplies) {
		Scanner in = new Scanner(System.in);

		System.out.println("YOUR PARTY STOPS BY A YALL-MART TO RESTOCK ON SUPPLIES."
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		System.out.println("YOUR PARTY ATTRACTED A HORDE OF ZOMBIES, TO GET TO THE SUPPLIES YOUR PARTY"
				+ " MUST FIGHT THEM ALL\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		//Enemies
		Zombie zombie1 = new Zombie("ZOMBIE", 33, 10, 10, 33);
		Zombie zombie2 = new Zombie("ZOMBIE", 14, 10, 10, 14);
		Zombie zombie3 = new Zombie("ZOMBIE", 27, 10, 10, 27);

		//Party fights all the enemies
		fight(party, zombie1);
		fight(party, zombie2);
		fight(party, zombie3);

		//Supplies added
		Supplies[0] += 5;
		Supplies[1] += 5;
		Supplies[2] += 50;

		System.out.println("AFTER SPREADING OUT AND LOOTING THE YALL-MART YOU PARTY REGROUPS"
				+ " AND HITS THE ROAD"
				+ "\nFood +15\nGas +50\nMedical Supplies +5"
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();
	}


	/**
	 * This method is one of the scenarios the user can get into
	 * 
	 * @param party
	 * @param Supplies
	 */
	public static void KostKo(ArrayList <Being> party, int[] Supplies) {
		Scanner in = new Scanner(System.in);

		System.out.println("YOUR PARTY STOPS BY A KOSTKO TO RESTOCK ON SUPPLIES."
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		System.out.println("INSIDE THE KOSTKO ARE A COUPLE OF ZOMBIES, TO GET TO THE SUPPLIES YOUR PARTY"
				+ " MUST FIGHT THEM ALL\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		//Enemies
		Zombie zombie1 = new Zombie("ZOMBIE", 37, 10, 10, 37);
		Zombie zombie2 = new Zombie("ZOMBIE", 14, 10, 10, 14);
		Zombie zombie3 = new Zombie("ZOMBIE", 23, 10, 10, 23);
		Zombie zombie4 = new Zombie("ZOMBIE", 31, 10, 10, 31);

		//Party fights all the enemies
		fight(party, zombie1);
		fight(party, zombie2);
		fight(party, zombie3);
		fight(party, zombie4);

		//Supplies added
		Supplies[0] += 10;
		Supplies[1] += 2;
		Supplies[2] += 100;

		System.out.println("AFTER SPREADING OUT AND LOOTING THE KOSTKO YOU PARTY REGROUPS AND HITS THE ROAD."
				+ "\nFood +10\nGas +100\nMedical Supplies +2"
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();
	}


	/**
	 * this method is one of the scenarios the user can get into
	 * @param party
	 */
	public static void School(ArrayList <Being> party, int[] Supplies) {
		Scanner in = new Scanner(System.in);

		System.out.println("YOUR PARTY DECIDES TO MAKE A PIT STOP AT A SCHOOL IN THE DISTANCE\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		System.out.println("WHILE EXPLORING THE SCHOOL YOUR PARTY STUMBLES INTO A COMPUTER LAB."
				+ "\nTHE DOOR TO THE LAB IS LOCKED\n1. BREAK DOWN THE DOOR\n2. LEAVE THE SCHOOL");

		int action = Choice(1, 2, "ACTION DOES NOT EXIST");

		//If user chooses to break the door down 
		if (action == 1) {

			//Whose going to do what? (Character selection)
			System.out.println("\nSELECT A CHARACTER TO BREAK DOWN THE DOOR: ");
			for (int i = 0; i < party.size(); i++) {
				System.out.println((i + 1) + ": " + party.get(i).getName() + " (Strength: " + (party.get(i)).getStrength() + ")");
			}
			int picked = Choice(0, party.size(), "PARTY MEMBER DOES NOT EXIST") - 1;

			//If the player is strong enough
			if (party.get(picked).getStrength() > 7) {
				//Player strength increases if not at max
				if (party.get(picked).getStrength() < 10) {
					party.get(picked).setStrength(party.get(picked).getStrength() + 1);
				}
				//Supplies are added
				Supplies[0] += 10;
				Supplies[1] += 5;
				Supplies[2] += 50;

				System.out.println(party.get(picked).getName() + " BREAKS THE DOOR DOWN EASILY. INSIDE THE LAB IS A PLETHORA OF SUPPLIES."
						+ "\nFood+10\nMedical Supplies +5\nGas +50\n\n" + party.get(picked).getName() + " FEELS STRONGER!");
			}
			else {
				System.out.println(party.get(picked).getName() + " TRIES TO BREAK THE DOOR DOWN BUT ENDS UP STUBBING THEIR TOE"
						+ party.get(picked).getName() + ": OWIE :(");
			}
			//Enemies
			Bandit bandit1 = new Bandit("BANDIT", 35, 7, 7, 35);
			Bandit bandit2 = new Bandit("BANDIT", 45, 5, 7, 45);

			System.out.println("JUST AS YOUR PARTY GETS READY TO LEAVE A PAIR OF BANDITS SHOW UP."
					+ "\nBANDIT1: WHAT ARE YOU DOING WITH OUT STUFF???!!!"
					+ "\nBANDIT2: WE'LL KILL YOU!!!\nPRESS ENTER TO CONTINUE");
			in.nextLine();

			//Fighting
			fight(party, bandit1);
			fight(party, bandit2);

			//If user beats the bandits
			System.out.println("AS YOUR PARTY IS ABOUT TO LEAVE THEY HEAR POUNDING AND MUFFLING THROUGH THE WASHROOM DOOR."
					+ "\n" + party.get(0).getName() + " DECIDES TO OPEN THE DOOR...\nPRESS ENTER TO CONTINUE");
			in.nextLine();

			System.out.println("OUT BURSTS A TEENAGER WITH BROWN CURLY HAIR."
					+ "\nTEENAGER: WOW THANKS A BUNCH FOR GETTING ME OUT OF THERE. I WAS HIDING IN THERE "
					+ "\nWHEN THE APOCALYPSE FIRST STARTED, BUT THEN ACCIDENTLLY LOCKED MYSELF IN!"
					+ "\nANYWAYS THANKS FOR THE HELP, MY NAME IS bETER."
					+ "\nbETER THEN GOES ON A LONG RANT ABOUT HOW HE CAN'T PLAY HIS FAVORITE GAME ANYMORE"
					+ "\n1. RECRUIT bETER" + "\n2. LEAVE bETER ALONE");
			action = Choice(1, 2, "ACTION DOES NOT EXIST");

			//If user want to add bETER to the party
			if (action == 1) {
				Player bETER = new Player("bETER", 75, 5, 5, 75, 3, 10);
				System.out.println("IT DOESN'T TAKE MUCH CONVINCING FOR bETER TO JOIN YOUR PARTY"
						+ "\nbETER HAS JOINED YOUR PARTY");
				party.add(bETER);
			}
			//If the user does not want to add bETER to the party
			else {
				System.out.println("YOUR PARTY DECIDES THAT THEY DON'T NEED bETER BECAUSE HE TALKS TOO MUCH");
			}
			System.out.println("YOUR PARTY LEAVES THE SCHOOL AND HITS THE ROAD"
					+ "\nPRESS ENTER TO CONTINUE");
			in.nextLine();
		}
		//If the user chooses to leave the school
		else if (action == 2) {
			System.out.println("YOUR PARTY DECIDED TO LEAVE\n");
		}
	}


	/**
	 * This method is one of the scenarios the user can go through
	 * @param party
	 * @param Supplies
	 */
	public static void Pet_Clinic(ArrayList <Being> party, int[] Supplies) {
		Scanner in = new Scanner(System.in);

		System.out.println("YOUR PARTY APPROACHES AN ABANDONED PET CLINIC."
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		System.out.println("THERE ARE A COUPLE OF ZOMBIES, BEFORE LOOTING YOUR PARTY SHOULD TAKE CARE"
				+ "OF THE TRASH."
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		//Enemies
		Zombie zombie1 = new Zombie("ZOMBIE", 12, 10, 10, 12);
		Zombie zombie2 = new Zombie("ZOMBIE", 19, 10, 10, 19);
		Zombie zombie3 = new Zombie("ZOMBIE", 23, 10, 10, 23);

		//Party fights all the enemies
		fight(party, zombie1);
		fight(party, zombie2);
		fight(party, zombie3);

		System.out.println("YOUR PARTY KILLED ALL THE ZOMBIES AND LOOTED THE BUILDING."
				+ "\nFood +5\nMedical Supplies +3"
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();
		//Add supplies
		Supplies[0] += 5;
		Supplies[1] += 3;

		//Random chance the user either gets to tame a dog or a cat
		//If user gets dog
		if ((int) (Math.random() * 2) == 0) {
			System.out.println("WHILE LOOTING THE CLINIC " + party.get((int) (Math.random() * party.size())).getName()
					+ " FINDS A DOG. SHOULD YOUR PARTY TRY TO TAME THE DOG?");
			System.out.println("1. TAME THE DOG (Food -2)\n2. LEAVE THE DOG ALONE");
			int picked = Choice(1, 2, "ACTION DOES NOT EXIST");

			//If user wants to tame the dog
			if (picked == 1) {
				//If user does not have enough food to tame
				if (Supplies[0] < 2) {
					System.out.println("NOT ENOUGH FOOD");
				}
				//If user has enough food to tame
				else {
					Supplies[0] -= 2;
					Animal dog = new Animal ("???", 75, 5, 7, 75, 7, "dog");
					System.out.println("THE DOG GOBBLES UP THE FOOD AND BEGINS TO FOLLOW YOUR PARTY."
							+ "\nWHAT SHOULD THE DOG BE CALLED: ");
					dog.setName(in.nextLine().toUpperCase());
					party.add(dog);
					System.out.println(dog.getName() + " HAS JOINED YOUR PARTY\n");
				}
			}
		}
		//If user gets cat
		else {
			System.out.println("WHILE LOOTING THE CLINIC " + party.get((int) (Math.random() * party.size())).getName()
					+ " FINDS A CAT. SHOULD YOUR PARTY TRY TO TAME THE CAT?");
			System.out.println("1. TAME THE CAT (Food -2)\n2. LEAVE THE CAT ALONE");
			int picked = Choice(1, 2, "ACTION DOES NOT EXIST");

			//If user want to tame the cat
			if (picked == 1) {
				//If user does not have enough food to tame
				if (Supplies[0] < 2) {
					System.out.println("NOT ENOUGH FOOD");
				}
				//If user has enough food to tame
				else {
					Supplies[0] -= 2;
					Animal cat = new Animal ("???", 50, 5, 7, 50, 8, "cat");
					System.out.println("THE CAT TAKES ONE LICK OF THE FOOD AND SEEMS DISGUSTED, REGARDLESS IT BEGINS TO FOLLOW YOUR PARTY."
							+ "\nWHAT SHOULD THE CAT BE CALLED: ");
					cat.setName(in.nextLine().toUpperCase());
					party.add(cat);
					System.out.println(cat.getName() + " HAS JOINED YOUR PARTY\n");
				}
			}
		}

		System.out.println("YOUR PARTY LEAVES THE CLINIC AND HITS THE ROAD"
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();
	}


	/**
	 * This method is one of the scenarios the user can go through
	 * @param party
	 * @param Supplies
	 */
	public static void DMV(ArrayList <Being> party, int[] Supplies) {
		Scanner in = new Scanner(System.in);

		System.out.println("YOUR PARTY APPROACHES THE DMV."
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		System.out.println("INSIDE THE DMV THERE ARE A COUPLE OF ZOMBIES, AND A LONG LINE OF SKELETONS, IN A SINGLE FILE"
				+ "\nLEADING UP TO THE FRONT DESKS. YOUR PARTY IS ABLE TO IGNORE THE ZOMBIES AND LOOT THE PLACE."
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		System.out.println("WHILE SEARCHING FOR LOOT " + party.get((int) (Math.random() * party.size())).getName() + " FINDS A BOOK "
				+ "TITLED: HOW TO BE FUNNY (20 JOKES INCLUDED)"
				+ "\nWHO SHOULD READ THE BOOK?");
		//Whose going to do what? (Character selection)
		for (int i = 0; i < party.size(); i++) {
			System.out.println((i + 1) + ": " + party.get(i).getName());
		}
		int picked = Choice(0, party.size(), "PARTY MEMBER DOES NOT EXIST") - 1;

		System.out.println(party.get(picked).getName() + " READS THE BOOK AND PICKS UP A THING OR TWO. UNFORTUNATLY " 
				+ party.get(picked).getName() + "'S GRIMY FINGERS\nRUINED THE PAGES SO NO ONE ELSE CAN READ IT.");

		//If picked Being was a Player
		if (party.get(picked) instanceof Player) {
			//If Player is not at max charisma, increase charisma
			if (((Player) party.get(picked)).getCharisma() < 10) {
				((Player) party.get(picked)).setCharisma(((Player) party.get(picked)).getCharisma() + 1);
				System.out.println(party.get(picked).getName() + ": Charisma +1");
			}
		}
		//If picked Being was an Animal
		else {
			//If Animal is not at max charisma, increase charisma
			if (((Animal) party.get(picked)).getCharisma() < 10) {
				((Animal) party.get(picked)).setCharisma(((Animal) party.get(picked)).getCharisma() + 1);
				System.out.println(party.get(picked).getName() + ": Charisma +1");
			}
		}

		System.out.println("PRESS ENTER TO CONTINUE");
		in.nextLine();
	}


	/**
	 * This method checks if the user inputs an out of range number
	 * @param start
	 * @param end
	 * @param message
	 * @return
	 */
	public static int Choice(int start, int end, String message) {
		Scanner in = new Scanner(System.in);

		int picked;
		//Loop until a valid number is inputed
		do {
			picked = in.nextInt();

			//If user picks an index out of party range, inform user
			if (picked < start || picked > end) {
				System.out.println(message);
			}
		} while (picked < start || picked > end);

		return picked;
	}


	/**
	 * This method is what happens if the user runs out of gas
	 * @param party
	 */
	public static void Walking (ArrayList <Being> party, int[] Supplies) {
		Scanner in = new Scanner(System.in);

		System.out.println("WITH NO GAS LEFT YOUR PARTY HAS TO GET OUT OF THE CAR AND LOOK FOR GAS."
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		//A chance that the user loses supplies
		int lose = (int) (Math.random() * 3);
		if (lose == 0) {
			System.out.println("AFTER WANDERING AROUND FOR SOMETIME " + party.get((int) (Math.random() * party.size())).getName() 
					+ "NOTICES THERE'S A TEAR IN THEIR BACKPACK, AND THEY'VE BEEN LOSING SUPPLIES THIS ENTIRE TIME!"
					+ "\n Food -" + Supplies[0]/3 + "Medical Supplies -" + Supplies[1]/3
					+ "\nPRESS ENTER TO CONTINUE");
			in.nextLine();

			Supplies[0] /= 3;
			Supplies[1] /= 3;		
		}

		System.out.println("Food: " + Supplies[0] + "\nMedical Supplies: " + Supplies[1] + "\nGas: " + Supplies[2] + "\n");

		//Enemies
		Bandit bandit1 = new Bandit("BANDIT", 50, 5, 5, 50);
		Bandit bandit2 = new Bandit("BANDIT", 35, 3, 5, 35);

		System.out.println("OUT IN THE HORIZON YOUR GROUP SEES A GAS STATION. JUST AS THEY REACH THE GAS STATION\n"
				+ "A DUO OF BANDITS AMBUSHES YOUR PARTY!\nBANDIT1: WHERE DO YOU THINK YOU'RE GOING?"
				+ "\nBANDIT2: THIS IS OUR TERRITORY!"
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();

		fight(party, bandit1);
		fight(party, bandit2);

		System.out.println("\nAFTER DEFEATING THE BANDITS YOUR PARTY EXPLORES THE GAS STATION. THERE NOTHING OF USE IN THE"
				+ "\nGAS STATION, BUT THERE IS STILL GAS IN THE PUMPS. SOMEONE SHOULD SIPHON THE GAS OUT OF THE PUMPS."
				+ "\nWHO SHOULD DO IT?");

		//Whose going to do what? (Character selection)
		System.out.println("\nSELECT A CHARACTER TO SIPHON THE GAS: ");
		for (int i = 0; i < party.size(); i++) {
			System.out.println((i + 1) + ": " + party.get(i).getName());
		}
		int picked = Choice(0, party.size(), "PARTY MEMBER DOES NOT EXIST") - 1;

		System.out.println(party.get(picked).getName() + " SIPHONS THE GAS OUT OF THE PUMPS USING THEIR MOUTH. "
				+ party.get(picked).getName() + " IS ABLE TO SIPHON THE GAS,"
				+ "\nBUT IN THE PROCESS ACCIDENTLY SWALLOWS SOME GAS"
				+ "\nAND GETS A LITTLE SICK"
				+ "\nGas +50");
		//Add gas to supplies
		Supplies[2] += 50;

		System.out.println("PRESS ENTER TO CONTINUE");
		in.nextLine();
	}


	/**
	 * This method happens inbetween pit stops and is a chance for the user to heal 
	 * their Beings
	 * @param party
	 * @param Supplies
	 */
	public static void downtime(ArrayList<Being> party, int[] Supplies) {
		Scanner in = new Scanner(System.in);

		int action;
		//Loop until user is ready to move on
		do {
			//Whose going to do what? (Character selection)
			System.out.println("WITH TIME TO SPARE THERE'S TIME TO DO SOMETHING"
					+ "\n1. HEAL SOMEONE (Medical Supplies: " + Supplies[1] + ")"
					+ "\n2. PREPARE FOR THE FUTURE");
			action = Choice(1, 2, "ACTION DOES NOT EXSIST");

			//If the user wants to heal someone
			if (action == 1) {
				//Checks to see if the user has medical supplies
				if (Supplies[1] != 0) {
					//Whose going to do what? (Character selection)
					System.out.println("SELECT A CHARACTER TO DO THE HEALING:");
					for (int i = 0; i < party.size(); i++) {
						//If character that is healing is a Player
						if (party.get(i) instanceof Player) {
							System.out.println((i + 1) + ": " + party.get(i).getName() + " (Medical: " + ((Player) party.get(i)).getMedical() + ")");
						}
						//If character that is healing is an Animal
						else {
							System.out.println((i + 1) + ": " + party.get(i).getName() + " (Medical: ANIMAL (O_O))");
						}
					}

					int picked;
					//Repeat until user picks a Player 
					do {
						//Person that does the healing
						picked = Choice(0, party.size(), "PARTY MEMBER DOES NOT EXIST\n") - 1;
						//Animals cannot heal
						if (party.get(picked) instanceof Animal) {
							System.out.println("ANIMALS CAN'T HEAL THINGS");
						}
					} while (party.get(picked) instanceof Animal);

					//Whose going to do what? (Character selection)
					System.out.println("SELECT A CHARACTER TO GET HEALED:");
					for (int i = 0; i < party.size(); i++) {
						System.out.println((i + 1) + ": " + party.get(i).getName() + " (Hp: " + party.get(i).getHp() + "/" + party.get(i).getVitality() + ")");
					}
					//Person that gets healed
					int heal = Choice(0, party.size(), "PARTY MEMBER DOES NOT EXIST\n") - 1;

					//Different message outputed based on if person healed was already at full Hp
					//If user is at full Hp
					if (party.get(picked).getHp() == party.get(picked).getVitality()) {
						System.out.println(party.get(heal).getName() + " FEELS NO DIFFERENT THEN BEFORE");
					}
					//If user is not at full Hp
					else{
						System.out.println(party.get(heal).getName() + " FEELS A LOT BETTER");
					}

					//Healing process
					((Player)party.get(picked)).heal(party.get(heal));

					//Take away 1 medical supply
					Supplies[1]--;
					System.out.println("Medical Supplies -1");

					//Output everyone's Hp
					for (int i = 0; i < party.size(); i++) {
						System.out.println(party.get(i).getName() + " Hp: " + party.get(i).getHp() + "/" + party.get(i).getVitality() + "\n");
					}
				}
				//If there are no more medical supplies
				else {
					System.out.println("NO MEDICAL SUPPLIES LEFT\n");
				}
			}
			//If user wants to exit downtime
			else if (action == 2) {
				String[] funny = {"FORKS", "SPOONS", "KNIFES"};
				System.out.println( party.get((int) (Math.random() * party.size())).getName() + " DECIDES TO PREPARE FOR THE FUTURE. "
						+  party.get((int) (Math.random() * party.size())).getName() + " COULD ONLY THINK ABOUT " + funny[(int) (Math.random() * 3)]);
			}

		} while (action != 2);
		System.out.println("THAT WAS A GOOD USE OF TIME! NOW IT'S TIME TO HIT THE ROAD"
				+ "\nPRESS ENTER TO CONTINUE");
		in.nextLine();
	}


	/**
	 * This method takes in a party (ArrayList) and an enemy and makes them fight each other.
	 * 
	 * @param party
	 * @param enemy
	 * @return
	 */
	public static void fight(ArrayList<Being> party, Being enemy) {
		Scanner in = new Scanner(System.in);

		Boolean alone = false;

		//Loop until everyone in party is dead
		do {
			//Checks to see if there is only one person left, if there is enable running
			if (party.size() == 1) {
				alone = true;
			}

			//Display Beings in party stats
			for (Being character : party) {
				//Do Being to.Strings
				//Display players stats
				if (character instanceof Player) {
					System.out.println(((Player) character).toString());
				}
				//Display animals stats
				else {
					System.out.println(((Animal) character).toString());
				}
			}

			//Display enemy stats
			System.out.println("\n" + enemy.getName() + "\nHp: " + enemy.getHp() + "/" + enemy.getVitality());

			if (enemy instanceof Bandit) {
				((Bandit) enemy).talk("prompt");
			}
			else {
				((Zombie) enemy).talk("prompt");
			}

			//User's turn
			//Whose going to do what? (Character selection)
			System.out.println("\nSELECT A CHARACTER IN YOUR PARTY: ");
			for (int i = 0; i < party.size(); i++) {
				System.out.println((i + 1) + ": " + party.get(i).getName());
			}
			int picked = Choice(0, party.size(), "PARTY MEMBER DOES NOT EXIST") - 1;

			int action;
			//Action selection
			//If there is only one party member
			if (alone) {
				System.out.println("1: MELEE THE " + enemy.getName() + "\n2: CHARM THE " + enemy.getName() + "\n3. RUN AWAY");
				action = Choice(1, 3, "ACTION DOES NOT EXIST") ;
			}
			else {
				System.out.println("1: MELEE THE " + enemy.getName() + "\n2: CHARM THE " + enemy.getName());
				action = Choice(1, 2, "ACTION DOES NOT EXIST") ;
			}

			//Being melee attacks the enemy
			if (action == 1) {
				//If enemy is a Bandit give the enemy a chance to dodge
				if (enemy instanceof Bandit) {
					//If enemy is able to dodge, no damage done to the enemy
					if(((Bandit) enemy).dodge(party.get(picked))) {
						System.out.println("THE " + enemy.getName() + " DODGED " + party.get(picked).getName()
								+ "'S ATTACK!");
					}
					//If enemy is unable to dodge, damage done to the enemy
					else {
						//Player trash talk
						if (party.get(picked) instanceof Player) {
							((Player) party.get(picked)).talk("attack");
						}
						//Animal "trash" talk
						else {
							((Animal) party.get(picked)).talk("tell");
						}

						//Zombie "trash" talk
						if (enemy instanceof Zombie) {
							((Zombie) enemy).talk("tell");
						}
						//Bandit trash talk
						else if (enemy instanceof Bandit) {
							((Bandit) enemy).talk("defend");
						}	
						System.out.println(party.get(picked).getName() + " MELEES THE " + enemy.getName() + "\n");

						party.get(picked).melee(enemy);


					}
				}
				//If enemy isn't a Bandit, attack enemy
				else {
					//Player trash talk
					if (party.get(picked) instanceof Player) {
						((Player) party.get(picked)).talk("attack");
					}
					//Animal "trash" talk
					else {
						((Animal) party.get(picked)).talk("tell");
					}

					//Zombie "trash" talk
					if (enemy instanceof Zombie) {
						((Zombie) enemy).talk("tell");
					}
					//Bandit trash talk
					else if (enemy instanceof Bandit) {
						((Bandit) enemy).talk("defend");
					}	
					System.out.println(party.get(picked).getName() + " MELEES THE " + enemy.getName() + "\n");

					party.get(picked).melee(enemy);

				}
				//If enemy dies, break out of loop
				if (enemy.getHp() <= 0) {
					break;
				}
			}

			//Sees if Being can charm the enemy
			else if (action == 2) {
				//If player charms the enemy, encounter stops & player moves on
				//If a Player is charming
				if (party.get(picked) instanceof Player) {
					if(((Player)party.get(picked)).charm(enemy)) {
						System.out.println("THE " + enemy.getName() + " WAS CHARMED! THE " + enemy.getName() + " HAS LEFT YOU ALONE.");
						return;
					}
					System.out.println("THE " + enemy.getName() + " COULDN'T BE CHARMED!");
				}
				//If an Animal is charming
				else {
					if(((Animal)party.get(picked)).charm(enemy)) {
						System.out.println("THE " + enemy.getName() + " WAS CHARMED! THE " + enemy.getName() + " HAS LEFT YOU ALONE.");
						return;
					}
					System.out.println("THE " + enemy.getName() + " COULDN'T BE CHARMED!");
				}
			}

			//Sees if Being can run from fight
			else if (action == 3) {
				if (party.get(picked) instanceof Player) {
					if (((Player) party.get(picked)).run(enemy)) {
						System.out.println(party.get(picked).getName() + ": I'M OUTTA HERE!"
								+ "\n" + party.get(picked).getName() + " ESCAPED FROM THE " + enemy.getName() + "!\n");
						return;
					}
				}
				else {
					if (((Animal) party.get(picked)).run(enemy)) {
						System.out.println(party.get(picked).getName() + " ESCAPED FROM THE " + enemy.getName() + "!\n");
						return;
					}
				}
				System.out.println(party.get(picked).getName() + " COULDN'T ESCAPE!\n");

			}


			//Enemy's turn
			//Bandits try to run away at low health
			if (enemy instanceof Bandit && enemy.getHp() < 10) {
				if (((Bandit) enemy).run(party.get(picked))) {
					System.out.println(enemy.getName() + ": SEE YOU NEVER!"
							+ "\nTHE " + enemy.getName() + " RAN AWAY!");
					return;
				}
				else {
					System.out.println(enemy.getName() + " TRIES TO RUN AWAY BUT THEY WEREN'T FAST ENOUGH!");
				}
				System.out.println();
			}
			//Attack the Being
			else {
				int attack = (int) (Math.random() * party.size());

				//Zombie "trash" talk
				if (enemy instanceof Zombie) {
					((Zombie) enemy).talk("tell");
				}
				//Bandit trash talk
				else if (enemy instanceof Bandit) {
					((Bandit) enemy).talk("attack");
				}
				//Player trash talk
				if (party.get(picked) instanceof Player) {
					((Player) party.get(picked)).talk("defend");
				}
				//Animal "trash" talk
				else {
					((Animal) party.get(picked)).talk("tell");
				}

				System.out.println("THE " + enemy.getName() + " LUNGES FORWARD AND ATTACKS " + party.get(attack).getName() + "!");

				//Sees if the Being can dodge the attack
				if (party.get(attack) instanceof Player) {
					//If Being is able to dodge the attack, damage is avoided
					if (((Player) party.get(attack)).dodge(enemy)) {
						System.out.println(party.get(attack).getName() + " DODGED THE " + enemy.getName() + "'S ATTACK!");
						//Outputs a random response to the dodging the attack
						if((int) (Math.random() * 2) == 0) {
							System.out.println(party.get(attack).getName() + ": I'M IN THE MATRIX!\n");
						}
						else {
							System.out.println(party.get(attack).getName() + ": EAT MY DUST!\n");
						}
					}
					//If unable to dodge, deal damage
					else {
						enemy.melee(party.get(attack));
					}
				}
				//If Being is an Animal
				else {
					//Sees if Animal is able to dodge the enemy
					if (((Animal) party.get(attack)).dodge(enemy)) {
						System.out.println(party.get(attack).getName() + " DODGED THE " + enemy.getName() + "'S ATTACK!");
					}
					else {
						enemy.melee(party.get(attack));
					}
				}
			}

			ArrayList <Being> remove = new ArrayList<Being>();
			//Checks to see if any characters in the party have died
			for (Being character : party) {
				if (character.getHp() <= 0) {
					//Just removing elements from "party" causes a ConcurrentModificationException error
					remove.add(character);
				}
			}
			//If a Being in the party has died
			if (remove.size() > 0) {
				System.out.println(remove.get(0).getName() + " WAS KILLED BY THE " + enemy.getName());
				party.removeAll(remove);
			}

			System.out.println("PRESS ENTER TO CONTINUE");
			in.nextLine();

			//Continues until the entire party or the enemy is dead (Hp <= 0)
		} while (party.size() > 0 && enemy.getHp() > 0);

		//If the player was killed, game is over
		if (party.size() <= 0) {
			System.out.println("YOUR ENTIRE PARTY WAS KILLED! BETTER LUCK NEXT TIME!"
					+ "\nGAME OVER");
			System.exit(0);
		}
		System.out.println("THE " + enemy.getName() + " WAS KILLED!");

	}
}


