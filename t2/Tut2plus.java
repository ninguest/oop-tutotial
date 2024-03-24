package t2;
public class Tut2plus {
    private String example;

    public Tut2plus(){
        System.out.println("============================================\n\n" +
                "Tutorial 01 Plus by TEE YU CHENG (2300884)\n\n" +
                "============================================\n\n");

        this.example = "Hello";
    }

    public double Addition(double a, double b){
        return a + b;
    }

    public double Subtraction(double a, double b){
        return a - b;
    }

    public double Multiplication(double a, double b){
        return a * b;
    }

    public double Division(double a, double b){
        if(b != 0){
            return a / b;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        Tut2plus test = new Tut2plus();
        if (args.length != 2) {
            System.out.println("Usage: java Tut2plus <number1> <number2>");
            System.exit(1);
        }

        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);

        double sum = test.Addition(num1, num2);

        System.out.println("Result: " + String.format("%.0f", sum));

    }
}
