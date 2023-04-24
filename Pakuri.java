public class Pakuri { // Beginning of Class

    private int attack;
    private int defense;
    private int speed;
    String species = null;

    public Pakuri(String species) { //This method should be the only constructor for this class.
        // This is the constructor
        this.species = species;
        speed = (species.length() * 6) + 13;
        defense = (species.length() * 5) + 17;
        attack = (species.length() * 7) + 9;
    }

    public String getSpecies() { //Returns the species of this critter, getter method
        return species;

    }

    public int getAttack() { //Returns the attack value for this critter, getter method
        return attack;
    }

    public int getDefense() { //Returns the defense value for this critter, getter method
        return defense;
    }

    public int getSpeed() { //Returns the speed of this critter, getter method
        return speed;
    }

    public void setAttack(int newAttack) { //Changes the attack value for this critter to newAttack, setter method
        attack = newAttack;
    }

    public void evolve() { // Will evolve the critter as follows: a) double the attack; b) quadruple the defense; and c) triple the speed
        speed = speed * 3;
        defense = defense * 4;
        attack = attack * 2;
    }

} // End of Class
