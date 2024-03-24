public class Tut1plus {
    private String example;

    public Tut1plus(){
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
        Tut1plus test = new Tut1plus();

        double iAmA = 6.66;
        double iAmB = 9.99;
        
        System.out.println("Variable A : " + iAmA + "\nVariable B : " + iAmB + "\n");
        System.out.println("Addition (A+B) : ");
        System.out.println(String.format("%.2f + %.2f = %.2f\n", iAmA, iAmB, test.Addition(iAmA, iAmB)));
        System.out.println(String.format("Subtraction (A-B) : \n%.2f - %.2f = %.2f\n", iAmA, iAmB, test.Subtraction(iAmA, iAmB)));
        System.out.println(String.format("Multiplication (A*B) : \n%.2f x %.2f = %.2f\n", iAmA, iAmB, test.Multiplication(iAmA, iAmB) ));
        System.out.println(String.format("Division (A/B) : \n%.2f / %.2f = %.2f", iAmA, iAmB, test.Division(iAmA, iAmB)));

    }
}
