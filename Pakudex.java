import java.util.Arrays;

public class Pakudex { // Beginning of Class
    // All comments explaining the method purpose is from Pakudex Project pdf instructions

    private int full = 0;
    private Pakuri[] set;
    private int size;


    public Pakudex() { //Default constructor; if called, the default size for the Pakudex should be 20
        set = new Pakuri[20];
    }

    public Pakudex(int capacity) { //Initializes this object to contain exactly capacity objects when completely full
        set = new Pakuri[capacity];
    }

    public int getSize() { //Returns the number of critters currently being stored in the Pakudex
        //return capacity
        return size;

    }

    public int getCapacity() { //Returns the number of critters that the Pakudex has the capacity to hold at most
        return set.length;
    }

    public String[] getSpeciesArray() {
        //Returns a String array containing the species of the critters as ordered in the Pakudex; if there are no species added yet, this method should return null
        String[] speciesArray = new String[size];

        if (getSize() == 0) {
            return null;
        }
        else {
            for (int i = 0; i < size; i++) {
                speciesArray[i] = set[i].getSpecies();
            }
            return speciesArray;
        }
    }

    public int[] getStats(String species) {
        //Returns an int array containing the attack, defense, and speed statistics of species at indices 0, 1, and 2 respectively; if species is not in the Pakudex, returns null
        int x = 0;
        int [] statsArray = new int[3];
        for (int i = 0; i < size; i++) {
            if (set[i].getSpecies().equals(species)){
                x = 1;
                statsArray[2] = set[i].getSpeed();
                statsArray[1] = set[i].getDefense();
                statsArray[0] = set[i].getAttack();
            }
        }
        switch (x) {
            case 0:
                return null;
                // might need break statement here
            default:
                return statsArray;
        }
    }

    public void sortPakuri() { // Sorts the Pakuri objects in this Pakudex according to Java standard lexicographical ordering of species name
        String [] sortArray = new String[size];

        for (int i = 0; i < size; i++) {
            sortArray[i] = set[i].getSpecies();
        }
        Arrays.sort(sortArray);

        for (int i = 0; i < size; i++) {
            set[i] = new Pakuri(sortArray[i]);
        }
    }

    public boolean addPakuri(String species) { //Adds species to the Pakudex; if successful, return true, and false otherwise
        boolean truth;
        int max = set.length;
        if (size > max || size == max) {
            truth = false;
            if (!truth) {
                return false; //Fix this before submitting
            }
        }
            for (int i = 0; i < size; i++) {

                if (species.equals(set[i].getSpecies())) {

                    System.out.println("Error: Pakudex already contains this species!");
                    truth = false;
                    if (!truth) {
                        return false; //Fix this before submitting
                    }
                }
            }
            set[full] = new Pakuri(species);
            System.out.println("Pakuri species " + species + " successfully added!");
            System.out.println(" ");
            size = size + 1;
            full = full + 1;
            return true;

        }

    public boolean evolveSpecies(String species) { // Attempts to evolve species within the Pakudex; if successful, return true, and false otherwise
        boolean truth = false;
        for (int i = 0; i < size; i++) {

            if (species.equals(set[i].getSpecies())) {
                set[i].evolve();
                truth = true;
            }
        }
        return truth;
    }


} // End of Class
