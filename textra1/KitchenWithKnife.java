// Kitchen class definition
public class KitchenWithKnife {

    public static void main(String[] args) {
        // Creating an instance of the Knife class
        Knife kitchenKnife = new Knife();

        // Using functions from the Knife class
        System.out.println("Knife Type: " + kitchenKnife.getType());
        System.out.println("Knife Sharpness: " + kitchenKnife.getSharpness());

        // Using a method to cut
        String vegetable = "Carrot";
        String cutResult = kitchenKnife.cut(vegetable);

        System.out.println("Cutting " + vegetable + ": " + cutResult);
    }
}
