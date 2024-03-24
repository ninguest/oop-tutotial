public class OddNumbers {
    public static void main(String[] args) {
        if (args.length == 1) {
            int inputNumber = Integer.parseInt(args[0]);

            System.out.println("Odd numbers up to " + inputNumber + ":");
            for (int i = 1; i <= inputNumber; i += 2) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println("Error: Please provide exactly one integer as a command-line argument.");
        }
    }
}
