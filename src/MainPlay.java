/*
 * Use scan.readLine() when reading menu alternatives. Use string.charAt(int index) 
 * to get a specific character from the input string. 
 */

import java.util.Scanner;
import psmodel.PsLogic;

public class MainPlay {

	private final Scanner scan;

    public MainPlay() {
    	scan = new Scanner(System.in);
    }
    
    // main loop
    public void run() {
    	char choice = ' ';
    	String answer;
    	
    	do {
    		printMenu();
    		answer = scan.nextLine();
    		answer = answer.toUpperCase();
    		choice = answer.charAt(0); // first character
    		
    		switch(choice) {
    			case 'A':	playGame(); break;
    			case 'X':	System.out.println("Bye, bye!"); break;
    			default: 	System.out.println("Unknown command");
    		}
    		
    	} while(choice != 'X');
    }

    public void playGame() { 
    	PsLogic play = new PsLogic();
            
        while (!play.isGameOver()) {
            System.out.println("\n" + play.getPiles() + "\n");
            doDraw(play);
        }
        System.out.println("\n" + play.getPiles() + "\n");
        System.out.println("Your Score: "+ play.getPoints());
    }
    
    public void doDraw(PsLogic play) {
        System.out.println("Your card in hand is " + play.pickNextCard());
        doAdd(play);
    }
    
    public void doAdd(PsLogic play) {
            System.out.println("What pile do you want to add to (1-5)?: ");
            int index = scan.nextInt();
            index--;
            scan.nextLine();
            play.addCardToPile(index);
    }
    
    public void printMenu() {
    	System.out.println("---Menu---");
    	System.out.println("A: Start game");
    	System.out.println("X: Exit");
    	System.out.println("----------");
    }
    
    public void printMenu2() {
    	System.out.println("---Play---");
    	System.out.println("A: Draw Card");
    	System.out.println("X: Exit");
    	System.out.println("----------");
    }
    
    public static void main(String[] args) {
    	MainPlay menu = new MainPlay();
    	menu.run();
    }
}