import java.util.ArrayList;
import java.util.Random;
/**
 * A class that plays Bulgarian Solitare. 
 * Version 1: Implement the playRound and toString methods.
 * Raleigh Clemens
 */
public class Piles
{
   private ArrayList<Integer> piles;

   /**
      Create a set of piles with a known (non-random) configuration for testing.
      @param pileSizes an array of numbers whose sum is 45
   */
   public Piles(int[] pileSizes)
   {
      piles = new ArrayList<>();
      for (int s : pileSizes)
         piles.add(s);
   }
   
   /**
    * Return the string representation of the piles.
    * @return the string representation of the piles.
    */
   public String toString()
   {
      String data = "[";
      for(int i=0; i<piles.size()-1; i++){
          data += piles.get(i) + ", ";
        }
      data += piles.get(piles.size()-1);
      data += "]";
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
   
   //getters to use in the testcode
   public int getSize(){
       return piles.size();
    }
    
   public int getElement(int index){
       return piles.get(index);
    }
}
