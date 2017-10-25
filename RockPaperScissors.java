import java.util.Scanner;

public class RockPaperScissors{
  static int playerWins = 0;
  static int playerLosses = 0;
  static int computerWins = 0;
  static int computerLosses = 0;
  static int draws = 0;
  
  public static void main(String[]args){
   rockPaperScissors();
  }
  
  static void rockPaperScissors(){
   System.out.println("Rock Paper Scissors\n3...2...1...");
   Scanner input = new Scanner(System.in);
   String choice = input.nextLine();
   String opponentChoice = randomSelection();
   System.out.println("Opponent Chooses: " + opponentChoice);
  
   playOutcomes(choice,opponentChoice);
   scores();
   
   System.out.println("\nDo you want to play again? ('Y' for Yes, Any Other Key for No)");
   prompt(input.nextLine());
   input.close();
  }
  
  static void playOutcomes(String choice, String opponentChoice){
   if(draw(choice,opponentChoice)){
    System.out.println("DRAW");
    draws++;
   }
   else if(lose(choice,opponentChoice)){
    System.out.println("YOU LOSE");
    computerWins++;
    playerLosses++;
   }
   else if(win(choice,opponentChoice)){
    System.out.println("YOU WIN");
    computerLosses++;
    playerWins++;
   }
   else
    System.out.println("NO OUTCOME: Enter Rock, Paper, or Scissors");
  }
  
  static String randomSelection(){
   switch((int)(Math.random()*3)+1){
    case 1: return "ROCK";
    case 2: return "SCISSORS";
    case 3: return "PAPER";
   }
   return "";
  }
  
  static boolean draw(String user,String computer){
   return user.equalsIgnoreCase(computer);
  }
  
  static boolean lose(String user,String computer){
    return
    (computer.equalsIgnoreCase("Rock") && user.equalsIgnoreCase("Scissors")) ||
    (computer.equalsIgnoreCase("Paper") && user.equalsIgnoreCase("Rock")) ||
    (computer.equalsIgnoreCase("Scissors") && user.equalsIgnoreCase("Paper"))
      ;
  }
  
  static boolean win(String user,String computer){
    return
    (computer.equalsIgnoreCase("Scissors") && user.equalsIgnoreCase("Rock")) ||
    (computer.equalsIgnoreCase("Rock") && user.equalsIgnoreCase("Paper")) ||
    (computer.equalsIgnoreCase("Paper") && user.equalsIgnoreCase("Scissors"))
      ;
  }
  
  static void prompt(String choice){
    if(choice.equals("Y") || choice.equals("y"))
     rockPaperScissors();
    else{
     System.out.println("Total Scores");
     scores();
    }
  }
  
  static void scores(){
   System.out.println("[Player Wins: " + playerWins + "\tPlayer Losses: " +  playerLosses + draws() + 
   "\n[Computer Wins: " + computerWins + "\tComputer Losses: " +  computerLosses + draws());
  }
  
  static String draws(){
    return "\tDraws: " + draws + "]";
  }
  
}
