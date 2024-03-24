public class Tut1 {

    private String example;

    public Tut1(){
        System.out.println("============================================\n\n" +
                "Tutorial 01 by TEE YU CHENG (2300884)\n\n" +
                "============================================\n\n");

        this.example = "Hello";
    }

    public void module(String moduleName){
        switch (moduleName) {
            case "csc1109":
                System.out.println("Object-Oriented Programming\n");
                break;
            
            case "csc1108":
                System.out.println("Data Structures and Algorithms\n");
                break;

            case "inf1006":
                System.out.println("Computer Networks\n");
                break;

            case "inf1004":
                System.out.println("Mathematics 2\n");
            default:
                break;
        }
    
    }

    public static void main(String args[]){
        
        Tut1 test = new Tut1();
        
        System.out.println("Hello, I am TEE YU CHENG (2300884)\n");
        
        test.module("csc1109");

    }
}