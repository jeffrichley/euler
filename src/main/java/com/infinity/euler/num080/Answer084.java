package com.infinity.euler.num080;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Answer084 {
	
	private static final int NUM_DICE_SIDES = 6;
	private static final int NUM_ROLLS = 10000000;
	private static final Random r = new Random(System.currentTimeMillis());
	
	// need to initialize with garbage rolls to make sure we don't go directly to jail
	private int[] lastThreeRolls = new int[] {20, 30, 40};

	private Board board = new Board();
	private Space currentLocation = board.GO;
	
	private void run() {
		
		// how many moves do we want to try?
		for (int rollNum = 0; rollNum < NUM_ROLLS; rollNum++) {
			
			// roll the dice
			int diceRoll = getRoll();
			
			// move the space
			for (int i = 0; i < diceRoll; i++) {
				currentLocation = currentLocation.nextSpace;
			}
			
			// now apply special rules
			
			// if it is a bad three in a row roll, go to jail
			if (badThreeRoll(diceRoll)) {
				currentLocation = board.JAIL;
			} else
			// if we landed on go to jail, go to jail
			if (currentLocation == board.G2J) {
				currentLocation = board.JAIL;
			} else
			// if we are on a community chest
			if (currentLocation.name.startsWith("CC")) {
				processComunityChest();
			} else
			// if we are on a chance
			if (currentLocation.name.startsWith("CH")) {
				processChance();
			}
			
			// now that we have done all the adjustments, make the space as visited
			currentLocation.visit();
		}
		
		// now print out the probability of landing on each space
		Space tmpSpace = board.GO;
		for (int space = 0; space < 40; space++) {
			System.out.println(tmpSpace.name + " " + (double) tmpSpace.numVisits / (double) NUM_ROLLS);
			tmpSpace = tmpSpace.nextSpace;
		}
		
		List<Space> allSpaces = board.getAllSpaces();
		Collections.sort(allSpaces, new Comparator<Space>() {
			@Override
			public int compare(Space one, Space two) {
				Integer oneI = one.numVisits;
				Integer twoI = two.numVisits;
				return twoI.compareTo(oneI);
			}
		});
		
		System.out.println();
		System.out.println(allSpaces.get(0).name + " " + (double) allSpaces.get(0).numVisits / (double) NUM_ROLLS);
		System.out.println(allSpaces.get(1).name + " " + (double) allSpaces.get(1).numVisits / (double) NUM_ROLLS);
		System.out.println(allSpaces.get(2).name + " " + (double) allSpaces.get(2).numVisits / (double) NUM_ROLLS);
	}
	
	private void processChance() {
		Card card = board.takeChanceCard();
		
		if (card.name.startsWith("GO")) {
			currentLocation = board.GO;
		} else if (card.name.startsWith("JAIL")) {
			currentLocation = board.JAIL;
		} else if (card.name.equals("C1")) {
			currentLocation = board.C1;
		} else if (card.name.equals("E3")) {
			currentLocation = board.E3;
		} else if (card.name.equals("H2")) {
			currentLocation = board.H2;
		} else if (card.name.equals("R1")) {
			currentLocation = board.R1;
		} else if (card.name.equals("NEXT-R")) {
			Space nextR = currentLocation.nextSpace;
			while (!nextR.name.startsWith("R")) {
				nextR = nextR.nextSpace;
			}
			currentLocation = nextR;
		} else if (card.name.equals("NEXT-U")) {
			Space nextU = currentLocation.nextSpace;
			while (!nextU.name.startsWith("U")) {
				nextU = nextU.nextSpace;
			}
			currentLocation = nextU;
		} else if (card.name.equals("BACK-3")) {
			currentLocation = currentLocation.previousSpace.previousSpace.previousSpace;
		}
	}

	private void processComunityChest() {
		Card card = board.takeCommunityChestCard();
		
		if (card.name.startsWith("GO")) {
			currentLocation = board.GO;
		} else if (card.name.startsWith("JAIL")) {
			currentLocation = board.JAIL;
		}
	}

	private boolean badThreeRoll(int diceRoll) {
		lastThreeRolls[0] = lastThreeRolls[1];
		lastThreeRolls[1] = lastThreeRolls[2];
		lastThreeRolls[2] = diceRoll;
		
		return (lastThreeRolls[0] == lastThreeRolls[1]) && (lastThreeRolls[1] == lastThreeRolls[2]);
	}

	private int getRoll() {
		return r.nextInt(6) + 1 + r.nextInt(6) + 1;
	}

	public static void main(String[] args) {
		Answer084 a = new Answer084();
		a.run();
	}

	public class Board {
		
		private final Space GO;
		private final Space G2J;
		private final Space JAIL;
		private final Space C1;
		private final Space E3;
		private final Space H2;
		private final Space R1;
		
		private Card currentCCCard;
		private Card currentChanceCard;
		
		public Board() {
			
			Space GO = new Space("GO");	
			Space A1 = new Space("A1", GO);	
			Space CC1 = new Space("CC1", A1);
			Space A2 = new Space("A2", CC1);
			Space T1 = new Space("T1", A2);
			Space R1 = new Space("R1", T1);
			Space B1 = new Space("B1", R1);
			Space CH1 = new Space("CH1", B1);
			Space B2 = new Space("B2", CH1);
			Space B3 = new Space("B3", B2);
			Space JAIL = new Space("JAIL", B3);
			Space C1 = new Space("C1", JAIL);
			Space U1 = new Space("U1", C1);
			Space C2 = new Space("C2", U1);
			Space C3 = new Space("C3", C2);
			Space R2 = new Space("R2", C3);
			Space D1 = new Space("D1", R2);
			Space CC2 = new Space("CC2", D1);
			Space D2 = new Space("D2", CC2);
			Space D3 = new Space("D3", D2);
			Space FP = new Space("FP", D3);
			Space E1 = new Space("E1", FP);
			Space CH2 = new Space("CH2", E1);
			Space E2 = new Space("E2", CH2);
			Space E3 = new Space("E3", E2);
			Space R3 = new Space("R3", E3);
			Space F1 = new Space("F1", R3);
			Space F2 = new Space("F2", F1);
			Space U2 = new Space("U2", F2);
			Space F3 = new Space("F3", U2);
			Space G2J = new Space("G2J", F3);
			Space G1 = new Space("G1", G2J);
			Space G2 = new Space("G2", G1);
			Space CC3 = new Space("CC3", G2);
			Space G3 = new Space("G3", CC3);
			Space R4 = new Space("R4", G3);
			Space CH3 = new Space("CH3", R4);
			Space H1 = new Space("H1", CH3);
			Space T2 = new Space("T2", H1);
			Space H2 = new Space("H2", T2, GO);
			
			GO.setNextSpace(A1);
			GO.setPreviousSpace(H2);
			
			A1.setNextSpace(CC1);	
			CC1.setNextSpace(A2);
			A2.setNextSpace(T1);
			T1.setNextSpace(R1);
			R1.setNextSpace(B1);
			B1.setNextSpace(CH1);
			CH1.setNextSpace(B2);
			B2.setNextSpace(B3);
			B3.setNextSpace(JAIL);
			JAIL.setNextSpace(C1);
			C1.setNextSpace(U1);
			U1.setNextSpace(C2);
			C2.setNextSpace(C3);
			C3.setNextSpace(R2);
			R2.setNextSpace(D1);
			D1.setNextSpace(CC2);
			CC2.setNextSpace(D2);
			D2.setNextSpace(D3);
			D3.setNextSpace(FP);
			FP.setNextSpace(E1);
			E1.setNextSpace(CH2);
			CH2.setNextSpace(E2);
			E2.setNextSpace(E3);
			E3.setNextSpace(R3);
			R3.setNextSpace(F1);
			F1.setNextSpace(F2);
			F2.setNextSpace(U2);
			U2.setNextSpace(F3);
			F3.setNextSpace(G2J);
			G2J.setNextSpace(G1);
			G1.setNextSpace(G2);
			G2.setNextSpace(CC3);
			CC3.setNextSpace(G3);
			G3.setNextSpace(R4);
			R4.setNextSpace(CH3);
			CH3.setNextSpace(H1);
			H1.setNextSpace(T2);
			T2.setNextSpace(H2);
			
			this.GO = GO;
			this.G2J = G2J;
			this.JAIL = JAIL;
			this.C1 = C1;
			this.E3 = E3;
			this.H2 = H2;
			this.R1 = R1;
			
			// create community chest cards
			List<Card> ccCards = new ArrayList<>();
			ccCards.add(new Card("GO"));
			ccCards.add(new Card("JAIL"));
			ccCards.add(new Card(""));
			ccCards.add(new Card(""));
			ccCards.add(new Card(""));
			ccCards.add(new Card(""));
			ccCards.add(new Card(""));
			ccCards.add(new Card(""));
			ccCards.add(new Card(""));
			ccCards.add(new Card(""));
			ccCards.add(new Card(""));
			ccCards.add(new Card(""));
			ccCards.add(new Card(""));
			ccCards.add(new Card(""));
			ccCards.add(new Card(""));
			ccCards.add(new Card(""));
			
			Collections.shuffle(ccCards);
			
			// create chance cards
			List<Card> chanceCards = new ArrayList<>();
			chanceCards.add(new Card("GO"));
			chanceCards.add(new Card("JAIL"));
			chanceCards.add(new Card("C1"));
			chanceCards.add(new Card("E3"));
			chanceCards.add(new Card("H2"));
			chanceCards.add(new Card("R1"));
			chanceCards.add(new Card("NEXT-R"));
			chanceCards.add(new Card("NEXT-R"));
			chanceCards.add(new Card("NEXT-U"));
			chanceCards.add(new Card("BACK-3"));
			chanceCards.add(new Card(""));
			chanceCards.add(new Card(""));
			chanceCards.add(new Card(""));
			chanceCards.add(new Card(""));
			chanceCards.add(new Card(""));
			chanceCards.add(new Card(""));
			
			Collections.shuffle(chanceCards);
			
			// link the cccards
			for (int i = 0; i < ccCards.size() - 1; i++) {
				ccCards.get(i).setNextCard(ccCards.get(i+1));
			}
			ccCards.get(ccCards.size()-1).setNextCard(ccCards.get(0));
			currentCCCard = ccCards.get(0);
			
			// link the chance cards
			for (int i = 0; i < chanceCards.size() - 1; i++) {
				chanceCards.get(i).setNextCard(chanceCards.get(i+1));
			}
			chanceCards.get(chanceCards.size()-1).setNextCard(chanceCards.get(0));
			currentChanceCard = chanceCards.get(0);
		}
		
		public Card takeChanceCard() {
			Card answer = currentChanceCard;
			currentChanceCard = currentChanceCard.getNextCard();
			return answer;
		}
		
		public Card takeCommunityChestCard() {
			Card answer = currentCCCard;
			currentCCCard = currentCCCard.getNextCard();
			return answer;
		}
		
		public List<Space> getAllSpaces() {
			List<Space> spaces = new ArrayList<>();
			Space tmp = GO;
			for (int i = 0; i < 40; i++) {
				spaces.add(tmp);
				tmp = tmp.nextSpace;
			}
			
			return spaces;
		}
		
	}

	public class Space {
		
		private final String name;
		private int numVisits;
		private Space previousSpace;
		private Space nextSpace;
	
		public Space(String name) {
			this.name = name;
		}
		
		public Space(String name, Space previousSpace) {
			this(name);
			this.previousSpace = previousSpace;
		}
		
		public Space(String name, Space previousSpace, Space nextSpace) {
			this(name, previousSpace);
			this.nextSpace = nextSpace;
		}
		
		public void visit() {
			this.numVisits++;
		}
		
		public int getNumVisits() {
			return this.numVisits;
		}
		
		public void setNextSpace(Space nextSpace) {
			this.nextSpace = nextSpace;
		}
		
		public void setPreviousSpace(Space previousSpace) {
			this.previousSpace = previousSpace;
		}
		
	}
	
	public class Card {
		
		private final String name;
		private Card nextCard;
		
		private Card(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public Card getNextCard() {
			return nextCard;
		}

		public void setNextCard(Card nextCard) {
			this.nextCard = nextCard;
		}
	}
}
