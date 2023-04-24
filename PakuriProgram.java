import java.util.Scanner;

public class PakuriProgram { //Start of class
    public static void main(String[] args) { //Start of main
        boolean game = true;
        Scanner scanner = new Scanner(System.in);
        int selection = 0; //This is the variable for the capacity of the Pakudex
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!"); //Welcomes the user
        while (selection < 1) { //A while loop that contains a try and catch block, in case a user enters a capacity that is less than 1 or is not an integer
            System.out.println("Enter max capacity of the Pakudex: ");
            String input = scanner.next();

            try {
                selection = Integer.parseInt(input);
                if (selection < 1)
                    System.out.println("Please enter a valid size.");
            } catch (Exception ignored) {
                System.out.println("Please enter a valid size.");
            }
        }
        Pakudex pakudex = new Pakudex(selection); //Creates the pakudex array
        System.out.println("The Pakudex can hold " + selection + " species of Pakuri."); //Tells user how many pakudex it can hold from the user input from before
        System.out.println(" ");

        while(game) { //Start of game. Game will always be true unless user enters '6' on the main menu

        System.out.println("Pakudex Main Menu"); //Lists the main menu
        System.out.println("-----------------");
        System.out.println("1. List Pakuri");
        System.out.println("2. Show Pakuri");
        System.out.println("3. Add Pakuri");
        System.out.println("4. Evolve Pakuri");
        System.out.println("5. Sort Pakuri");
        System.out.println("6. Exit");
        System.out.println("");
        System.out.print("What would you like to do? ");

        String menuInput = scanner.next();

        switch (menuInput) { // Switch statement with 6 different cases, depending on the user's menu input

            case "1": //List Pakuri
                String[] pakuriList = pakudex.getSpeciesArray(); //Creates a string array to list pakuri
                if (pakudex.getSize() == 0) { // If the size is zero, there is no pakuri in the pakudex
                    System.out.println("No Pakuri in Pakudex yet!");
                    //System.out.println(" ");
                }
                else {
                    System.out.println("Pakuri In Pakudex: ");
                    for (int i = 0; i < pakuriList.length; i++) { // for loop to list every pakuri
                        System.out.println((i + 1) + ". " + pakuriList[i]);
                    }
                    System.out.println(" ");
                }
                break;

            case "2": // Show pakuri
                System.out.print("Enter the name of the species to display: ");
                String speciesSearch = scanner.next();
                int[] pakuriStats = pakudex.getStats(speciesSearch); // Creates an int array to receive stats from the species

                if (!(pakuriStats == null)) { // If the search isn't a null, it will list the stats
                    System.out.println(" ");
                    System.out.println("Species: " + speciesSearch);
                    System.out.println("Attack: " + pakuriStats[0]);
                    System.out.println("Defense: " + pakuriStats[1]);
                    System.out.println("Speed: " + pakuriStats[2]);
                    System.out.println(" ");
                }
                else { //If there isn't a match, the error message plays
                    System.out.println("Error: No such Pakuri!");
                    System.out.println(" ");
                }
                break;

            case "3": //Add Pakuri
                if (pakudex.getSize() == pakudex.getCapacity()) { // If the size is equal to the capacity, then it is full
                    System.out.println("Error: Pakudex is full!");
                    System.out.println(" ");
                }
                else {
                    System.out.print("Enter the name of the species to add: ");
                    String speciesAdd = scanner.next();
                    pakudex.addPakuri(speciesAdd); //Adds the species from the user
                }
                break;

            case "4": // Evolve Pakuri
                System.out.print("Enter the name of the species to evolve: ");
                String speciesEvolve = scanner.next();
                if (pakudex.evolveSpecies(speciesEvolve)) { //The species entered by the user will evolve from the list
                    System.out.println(speciesEvolve + " has evolved!");
                    System.out.println(" ");
                }
                else { // If there is no match of the species, it will play the error message
                    System.out.println("Error: No such Pakuri!");
                    System.out.println(" ");
                }
                break;

            case "5": //Sort Pakuri
                pakudex.sortPakuri(); // Calls the sortPakuri method and sorts the pakuri
                System.out.println("Pakuri have been sorted!");
                System.out.println(" ");
                break;

            case "6": //Quit
                System.out.println("Thanks for using Pakudex! Bye!");
                game = false; //Sets the game to false and quits
                break;

            default: // If a user inputs something like "10" or "STFU"
                System.out.println("Unrecognized menu selection!");
                System.out.println(" ");
                break;

        } // End of switch
        } // End of game while loop
    } // End of main
} // End of class
