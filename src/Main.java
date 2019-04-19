public class Main {

    public static int steps = 1;
    public static int maxSteps = 1;

    public static void main(String[] args) {

        System.out.println("Hello! This is some code that calculates the multiplicative persistence of numbers. \r\nFor more info on that topic, watch Numberphile's video discussing this.");
        System.out.println("Please enter an initial starting number:");
        String input = System.console().readLine();
        System.out.println("Starting persistence checking starting at " + input + "? (y/n)");
        System.out.println("(the process can be stopped by pressing Ctrl + C)");
        if (System.console().readLine().equals("y") || System.console().readLine().isEmpty()) {
            while (true) {
                steps = 1;
                multiplicativePersistence(input);
                if (steps > maxSteps) {
                    maxSteps = steps;
                    System.out.println("Number: " + input);
                    System.out.println("Steps:  " + maxSteps);
                    System.out.println();
                    input += "1";
                }
                long inputNum = Long.parseLong(input);
                inputNum++;
                input = inputNum + "";
            }
        }
    }

    private static void multiplicativePersistence(String number) {
        String[] stringNums = number.split("\\B");
        int result = 1;
        int[] digits = new int[stringNums.length];
        for (int i = 0; i < stringNums.length; i++) {
            digits[i] = Integer.parseInt(stringNums[i]);
            result *= digits[i];
        }
        //System.out.println(result);
        if (result > 10) {
            steps += 1;
            multiplicativePersistence(result + "");
        }
    }
}
