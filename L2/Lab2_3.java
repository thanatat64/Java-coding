import java.util.Scanner;

public class Lab2_3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the first city : ");
        String city1 = keyboard.nextLine();
        System.out.print("Enter the second city : ");
        String city2 = keyboard.nextLine();
        System.out.print("Enter the third city : ");
        String city3 = keyboard.nextLine();
        if(city2.compareTo(city1) < 0 && city2.compareTo(city3) < 0)
        {
            String temp = city1;
            city1 = city2;
            city2 = temp;
        }
        else if(city1.compareTo(city3) > 0)
        {
            String temp = city1;
            city1 = city3;
            city3 = temp;
        }
        if(city2.compareTo(city3) > 0)
        {
            String temp = city2;
            city2 = city3;
            city3 = temp;
        }
        System.out.println("The three city in alphabetical order are "+city1 +" "+city2 +" "+city3);
    }
}