import java.util.Scanner;
public class TrafficLightDemo { 
    public static void main(String[] args) 
    { 
        String color;
        Scanner scan =new Scanner(System.in);

        System.out.println("enter your choice of colour");

        color=scan.nextLine();

        String signal=null; 
  
        
        switch (color) { 
        case "red" : 
            signal="Stop";
            break; 

        case "yellow" :  
            signal="ready";
            break;

        case "green" :  
            signal="Go";
            break; 

            default:
            signal="invalid";
            System.out.println("Entered Colour is wrong plz refer traffical singnal Guidelines");
            break;
         
        } 
        System.out.println(signal); 
    } 
} 