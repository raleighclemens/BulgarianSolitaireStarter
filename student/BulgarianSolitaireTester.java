import java.util.*;
/**
   Tests the game of Bulgarian Solitaire.
   Raleigh Clemens
*/
public class BulgarianSolitaireTester
{
   public static void main(String[] args)
   {
      /*
      Piles deck = new Piles(new int[]{ 20, 5, 1, 9, 10 });
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [19, 4, 8, 9, 5]");
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [18, 3, 7, 8, 4, 5]");
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [17, 2, 6, 7, 3, 4, 6]");
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [16, 1, 5, 6, 2, 3, 5, 7]");      
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [15, 4, 5, 1, 2, 4, 6, 8]");
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [14, 3, 4, 1, 3, 5, 7, 8]"); 
      */
     
      Random gen = new Random();
      
      //generates a random num of piles
      int numPiles = gen.nextInt(9) + 1;
      
      //generates the starting hand array with the random number of piles
      int[] startingHand = new int[numPiles];
      
      int sum = 0;
      
      //fills in each number of cards in the starting hand (except the last element)
      for(int i=0; i<numPiles-1; i++){
          //generates a random number within range for each element in the starting
          //hand, depending on the number of piles in the starting hand
          int rand = gen.nextInt(45/numPiles) + 1;
          //this underapproximates how many cards are allowed to go in each element
          //of the starting hand, so we will never have a negative number
          //for the last card in the starting hand
          
          startingHand[i] = rand;
          
          sum += rand; //counts the total number of cards so we can fill in
          //the last element, having the sum of all cards in the starting hand
          //equal 45
        }
      startingHand[numPiles-1] = 45 - sum; //makes sure the last element always
      //makes the total cards add up to 45; since the elements above are
      //underapproximated due to integer division, this last element will never
      //be negative, which is what we want
      
      Piles deck = new Piles(startingHand);
      
      System.out.println("STARTING: " + deck);
      
      //just a fun counter to see how long each arrangement takes to win
      int moves =0;
      
      while(true){ //keeps running deck.playRound unless loop is broken
          if(deck.getSize() == 9){ //makes sure we dont get an index out of bounds
              //when we test the number of cards in each element of the deck
              
              int truths = 0;
              for(int i=0; i<9; i++){
                  if(deck.getElement(i) == i+1){ //the 0th element in deck=1 & so on
                      //this is how to win Bulgarian solitare
                      
                      truths++; 
                    }
                }
              if(truths == 9){ //if all nine elements in the deck are in the
                  //winning configuration, break the loop. we've finished
                  break;
              }
            }
          deck.playRound(); //otherwise, keep playing rounds
          //System.out.println(deck);
          moves++;
        }
        
      System.out.println("FINISHED: " + deck);
      System.out.println("This took " + moves + " moves.");
   }
}
