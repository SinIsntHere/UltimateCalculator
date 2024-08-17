// BasicCalculator.java
public class BasicCalculator extends Calculator {
    public double add(double... numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }

    public double subtract(double... numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public double multiply(double... numbers) {
        double result = 1;
        for (double num : numbers) {
            result *= num;
        }
        return result;
    }

    public double divide(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No numbers provided for division.");
            return Double.NaN; // Not a Number
        }

        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                result /= numbers[i];
            } else {
                System.out.println("Cannot divide by zero!");
                return Double.NaN; // Not a Number
            }
        }
        return result;
    }
}
