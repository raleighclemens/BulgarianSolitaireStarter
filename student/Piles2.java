import java.util.ArrayList;
import java.util.Random;
/**
 * A class that plays Bulgarian Solitare. 
 * Version 1: Implement the playRound and toString methods.
 * Raleigh Clemens
 */
public class Piles2
{
   private ArrayList<Integer> piles;

   /**
      Create a set of piles with a known (non-random) configuration for testing.
      @param pileSizes an array of numbers whose sum is 45
   */
   public Piles2(int[] pileSizes)
   {
      piles = new ArrayList<>();
      for (int s : pileSizes)
         piles.add(s);
   }
   
   public Piles2(Random generator)
   {
      piles = new ArrayList<Integer>();
      /* randomly divide up the deck into piles */
      int TOTAL_SIZE = 45;  // number of cards in a deck
      int numCards = TOTAL_SIZE;
      while (numCards > 0)
      {
         int pile = generator.nextInt(numCards) + 1;
         piles.add(pile);
         numCards -= pile; //omg this is so smart, i wish i had
         //thought of it yesterday :((. thank you for the code though
         //mr hayes.
      }
   }
   
   /**
    * Return the string representation of the piles.
    * @return the string representation of the piles.
    */
   public String toString()
   {
      String data = "";
      for(int i=0; i<piles.size()-1; i++){
          data += piles.get(i) + ", ";
        }
      data += piles.get(piles.size()-1);
      return data;
   }

   /**
      Play one round of the game.
   */
   public void playRound()
   {
       int nextPile = 0;
       for(int i=0; i<piles.size(); i++){
          piles.set(i,piles.get(i)-1); //sets each element equal to 
          //the integer at that element minus 1
          nextPile++; //sums the total subtracted from each element and 
          //adds it to the end of the list
        }
       piles.add(nextPile);
       
       //removes every 0 from the arraylist
       for(int i=0; i<piles.size(); ){ 
           if(piles.get(i) == 0){
               piles.remove(i); 
            }
           else{
               i++;
            }
        }
   }

   public boolean isDone(){
       if(piles.size() != 9){
           return false;
        }
        
        //checks to see if each number is contained in the sequence
        //exactly once
        int truths = 0;
       String sequence = this.toString().replace(", ","");
       for(int i=0; i<9; i++){
           Integer j = new Integer(i+1); //turning int into Integer
           //so we can use the Integer class toString method
           if(sequence.indexOf(j.toString()) != -1){
               truths ++;
            }
        }
       if(truths == 9){ //seeing if all numbers, 1-9, are present exactly once
           return true;
        }
       return false; //else return false
    }
}