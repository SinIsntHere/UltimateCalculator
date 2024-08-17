import java.util.Scanner;

// Main.java
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.println("Hello! Welcome to the Ultimate Calculator! This is currently a work in progress.");
            System.out.println("Tell me what calculations you would like to do:");
            System.out.println("For example, type in 'basic' if you need to do basic calculations like addition and subtraction.");
            System.out.println("If you need a list of what this calculator can do, type in 'list'.");
            System.out.println("To exit the program, type 'exit'.");

            // Read user input
            String userInput = sc.nextLine();

            // Create calculator instance based on user input
            Calculator calculator;
            switch (userInput.toLowerCase()) {
                case "basic":
                    calculator = new BasicCalculator();
                    performBasicCalculations((BasicCalculator) calculator, sc);
                    break;
                case "scientific":
                    calculator = new ScientificCalculator();
                    performCalculations(calculator, sc);
                    break;
                case "list":
                    printCalculatorFunctionalities();
                    break;
                case "exit":
                    exitProgram = true;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Please try again or type 'exit' to exit the program.");
            }
        }
    }

    private static void performBasicCalculations(BasicCalculator basicCalculator, Scanner sc) {
        System.out.println("Great! You've selected the Basic Calculator.");

        // Prompt user for the number of operands
        System.out.print("How many numbers are we using? ");
        int numOfOperands = sc.nextInt();

        // Prompt user to enter numbers
        double[] numbers = new double[numOfOperands];
        for (int i = 0; i < numOfOperands; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextDouble();
        }

        // Prompt user to select operation
        System.out.println("Select operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        // Read user operation choice
        int choice = sc.nextInt();

        double result;
        switch (choice) {
            case 1:
                result = basicCalculator.add(numbers);
                System.out.println("Result: " + result);
                break;
            case 2:
                result = basicCalculator.subtract(numbers);
                System.out.println("Result: " + result);
                break;
            case 3:
                result = basicCalculator.multiply(numbers);
                System.out.println("Result: " + result);
                break;
            case 4:
                result = basicCalculator.divide(numbers);
                System.out.println("Result: " + result);
                break;
            default:
                System.out.println("Invalid operation choice. Please try again.");
        }
    }

    private static void performCalculations(Calculator calculator, Scanner sc) {
        System.out.println("Great! You've selected the " + calculator.getClass().getSimpleName() + " calculator.");

        // Example: Addition
        System.out.print("Enter the first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = sc.nextDouble();

        // Perform addition using the selected calculator
        double result = calculator.add(num1, num2);

        System.out.println("Result: " + result);
    }

    private static void printCalculatorFunctionalities() {
        System.out.println("List of calculator functionalities:");
        System.out.println("- 'basic': Basic calculations (addition, subtraction, multiplication, division)");
        System.out.println("- 'scientific': Scientific calculations (square, square root, etc.)");
        System.out.println("- 'list': Display this list");
        // Add more functionalities as needed
    }
}
