import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("----------------------");
                System.out.println("      Calculator      ");
                System.out.println("----------------------");
                System.out.println("1. Addition (+)");
                System.out.println("2. Subtraction (-)");
                System.out.println("3. Multiplication (*)");
                System.out.println("4. Division (/)");
                System.out.println("5. Square of Number (²)");
                System.out.println("6. Exit");
                System.out.println("----------------------");

                int choice = getValidChoice(scanner);

                if (choice == 6) {
                    System.out.println("Exiting Calculator. Bye!");
                    break;
                }

                double result;
                switch (choice) {
                    case 1:
                        System.out.println("1. Addition (+)");
                        result = performAddition(scanner);
                        System.out.printf("Result: %.2f\n", result);
                        break;
                    case 2:
                        System.out.println("2. Subtraction (-)");
                        result = performSubtraction(scanner);
                        System.out.printf("Result: %.2f\n", result);
                        break;
                    case 3:
                        System.out.println("3. Multiplication (*)");
                        result = performMultiplication(scanner);
                        System.out.printf("Result: %.2f\n", result);
                        break;
                    case 4:
                        System.out.println("4. Division (/)");
                        result = performDivision(scanner);
                        if (!Double.isNaN(result)) {
                            System.out.printf("Result: %.2f\n", result);
                        }
                        break;
                    case 5:
                        System.out.println("5. Square of Number (²)");
                        result = performSquare(scanner);
                        System.out.printf("Result: %.2f\n", result);
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } finally {
            scanner.close();
        }
    }

    private static double performAddition(Scanner scanner) {
        int numCount = getNumberOfOperands(scanner);
        double result = 0;
        for (int i = 0; i < numCount; i++) {
            double num = getValidNumber(scanner, "Enter number " + (i + 1) + ": ");
            result += num;
        }
        return result;
    }

    private static double performSubtraction(Scanner scanner) {
        System.out.println("Enter the first number: ");
        double num1 = getValidNumber(scanner, "");
        System.out.println("Enter the second number: ");
        double num2 = getValidNumber(scanner, "");
        return num1 - num2;
    }

    private static double performMultiplication(Scanner scanner) {
        int numCount = getNumberOfOperands(scanner);
        double result = 1;
        for (int i = 0; i < numCount; i++) {
            double num = getValidNumber(scanner, "Enter number " + (i + 1) + ": ");
            result *= num;
        }
        return result;
    }

    private static double performDivision(Scanner scanner) {
        System.out.println("Enter the first number: ");
        double num1 = getValidNumber(scanner, "");
        System.out.println("Enter the second number: ");
        double num2 = getValidNumber(scanner, "");
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.println("Error: Division by zero!");
            return Double.NaN;
        }
    }

    private static double performSquare(Scanner scanner) {
        System.out.println("Enter the number: ");
        double num = getValidNumber(scanner, "");
        return num * num;
    }

    private static int getNumberOfOperands(Scanner scanner) {
        int numCount;
        while (true) {
            try {
                System.out.print("Enter the number of operands between (1 to 20): ");
                numCount = scanner.nextInt();
                if (numCount > 0) {
                    break;
                } else {
                    System.out.println("Invalid number of operands! Please enter a positive integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return numCount;
    }

    private static int getValidChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 6) {
                    break;
                } else {
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return choice;
    }

    private static double getValidNumber(Scanner scanner, String message) {
        double num;
        while (true) {
            try {
                System.out.print(message);
                num = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return num;
    }
}
