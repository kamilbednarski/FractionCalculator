import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        introductionText();

        int quit = 0;
        while (quit == 0) {
            String operation = getOperation();
            if ("q".equals(operation) || "Q".equals(operation)) {
                quit++;
                System.out.println("Thank you for using Fraction Calculator. See you again.");
            } else if ("=".equals(operation)) {
                Fraction firstFraction = getFraction();
                performOperation(firstFraction);
            } else if ("dbl".equals(operation)) {
                Fraction firstFraction = getFraction();
                printFractionToDouble(firstFraction);
            } else {
                Fraction firstFraction = getFraction();
                Fraction secondFraction = getFraction();
                performOperation(operation, firstFraction, secondFraction);
            }
        }

    }

    public static void introductionText() {
        System.out.println("Welcome,");
        System.out.println("this program is fraction calculator.");
        System.out.println("It will add, substract, multiply and divide fractions until you type Q to quit.");
        System.out.println("_______________________________________________________________________________");

    }

    public static String getOperation() {
        Scanner input = new Scanner(System.in);
        String operationType = null;
        int i = 0;
        do {
            try {
                System.out.print("Please enter operation type (+, -, /, *, dbl(to double) = or Q to quit): ");
                String userInput = input.next();
                if ("+".equals(userInput) || "-".equals(userInput) || "/".equals(userInput) || "=".equals(userInput) || "*".equals(userInput) || "dbl".equals(userInput) || "q".equals(userInput) || "Q".equals(userInput)) {
                    operationType = userInput;
                    i = 2;
                } else
                    throw new IllegalArgumentException();
            } catch (Exception e) {
                System.out.println("Wrong input. Please try again :");
            }
        } while (i == 0);

        System.out.println("_______________________________________________________________________________");
        System.out.println();
        return operationType;
    }

    public static Fraction getFraction() {
        Scanner input = new Scanner(System.in);

        //Getting valid fraction n/d:
        System.out.println("Please enter valid fraction n/d ('n' stands for numerator and 'd' stands for denominator).");
        System.out.println("Keep in mind that 'n' and 'd' has to be integer and 'd' cannot equal 0.");

        //Getting numerator value:
        System.out.print("Please enter value for numerator 'n': ");
        while (!input.hasNextInt()) {
            System.out.println("Wrong input. Please try again. Keep in mind that 'n' and 'a' has to be integer.");
            System.out.print("Please enter value for numerator 'n': ");
            input.next();
        }
        int numerator = input.nextInt();

        //Getting denominator value:
        System.out.print("Please enter value for denominator 'd': ");
        while (!input.hasNextInt()) {
            System.out.println("Wrong input. Please try again. Keep in mind that 'd' has to be integer and cannot equal 0.");
            System.out.print("Please enter value for denominator 'n': ");
            input.next();
        }
        int denominator = input.nextInt();

        printFraction(numerator,denominator);

        return new Fraction(numerator, denominator);
    }

    public static void performOperation(String whichOperation, Fraction firstFraction, Fraction secondFraction) {
        if ("+".equals(whichOperation)) {
            printFraction(firstFraction.add(secondFraction));
        } else if ("-".equals(whichOperation)) {
            printFraction(firstFraction.subtract(secondFraction));
        } else if ("/".equals(whichOperation)) {
            printFraction(firstFraction.divide(secondFraction));
        } else { //"*"
            printFraction(firstFraction.multiply(secondFraction));
        }
    }

    public static void performOperation(Fraction firstFraction) {
        Fraction newFraction = new Fraction(firstFraction.toLowestTerms().getNumerator(), firstFraction.toLowestTerms().getDenominator());
        printFraction(newFraction);

    }

    public static void printFraction(int numerator, int denominator) {
        //Printing user's fraction:
        System.out.println("_________________________________________________");
        System.out.println();
        System.out.println("                    " + numerator);
        System.out.println("Your fraction is:  ----");
        System.out.println("                    " + denominator);
        System.out.println();
        System.out.println("_________________________________________________");
    }

    public static void printFraction(Fraction whichFraction) {
        //Printing user's fraction:
        System.out.println("_________________________________________________");
        System.out.println();
        System.out.println("                 " + whichFraction.getNumerator());
        System.out.println("The result is:  ----");
        System.out.println("                 " + whichFraction.getDenominator());
        System.out.println();
        System.out.println("_________________________________________________");
    }

    public static void printFractionToDouble(Fraction whichFraction) {
        //Printing user's fraction:
        System.out.println("_________________________________________________");
        System.out.println();
        System.out.println("The result is: " + whichFraction.toDouble());
        System.out.println();
        System.out.println("_________________________________________________");
    }

}

