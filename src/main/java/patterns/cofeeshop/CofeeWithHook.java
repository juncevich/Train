package patterns.cofeeshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CofeeWithHook extends CaffeineBeverageWithHook {
    public void brew(){
        System.out.println("Dripping Cofee throught filter");
    }
    public void addCondiments(){
        System.out.println("Adding Sugar and Milk");
    }


    public boolean customersWantsCondiments() {
        String answer = getUserInput();

        return answer.toLowerCase().startsWith("y");
    }

    private String getUserInput(){
        String answer = null;
        System.out.println("Would you like milk and sugar with your cofee (y/n)? ");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe){
            System.err.println("IO error trying to read your answer");
        }

        if (answer == null ){
            return "no";
        }

        return answer;

    }
}
