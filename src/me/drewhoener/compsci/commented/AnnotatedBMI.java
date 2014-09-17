package me.drewhoener.compsci.commented;

import java.util.Scanner;

public class AnnotatedBMI {

     /*
    BMI = (weight/height^2) * 703
     */

    /*
    So here I'm just declaring some variables, because I'm going to be using them to compare to whatever we get for
    a person's bmi to determine their weight class. They're doubles because I need them to contain decimals.
    They're static because they're accessed by static methods, as I explain later
     */
    static double underWeight = 18.5;
    static double normalWeight = 24.9;
    static double overWeight = 29.9;


    /*
    Here's the main method, this is where the program officially begins, and the first thing we're going to do is create
    that instance of the Scanner class. So we say that "scanner" - the variable we've just created - is a "new" instance of "Scanner",
    and as a parameter we provide "System.in", which happens to be the input from the console, which is what we'll be inputting to.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        Because we'll be accepting the height and weight from two people in this class, we'll have to make variables for
        them. They're doubles because not everyone is exactly 5 feet or 6 feet, there are decimals involved. Notice we
        don't start off giving them values because they'll be assigned values by the console input.
         */
        double h1;
        double h2;
        double w1;
        double w2;

        /*
        Here, all we're doing is prompting the user for an input of the first person's height and weight. Old hat, moving
        on people....
         */

        System.out.println("Enter Information for Person 1");
        System.out.print("Height (In Inches): ");
        //Simply reading the double that they input and assigning it to the first height variable.

        h1 = scanner.nextDouble();

        //Printing out a blank line, simply because I want a gap there.

        System.out.println();

        //Prompting the user for the weight, and reading in the double they input and setting it to the first weight
        //variable

        System.out.print("Weight (In Pounds): ");
        w1 = scanner.nextDouble();

        /*
        Second verse, same as the first, we're just asking for the information for the second person and saving the values
        to the second height and weight variables, INSTEAD of the first ones, remember, we need two BMIs to compare.
         */

        //Just printing out 2 lines of space for readaility
        System.out.println();
        System.out.println();

        System.out.println("Enter Information for Person 2");

        System.out.print("Height (In Inches): ");
        h2 = scanner.nextDouble();

        System.out.println();

        System.out.print("Weight (In Pounds): ");
        w2 = scanner.nextDouble();

        /*
        Now to calculate the BMI. To see how I've done that, jump down to the calcBMI method.
         */

        //Print out a couple blank lines
        System.out.println();
        System.out.println();


        //Here, we print out the BMI for the first person using the method we made, and providing it the first height
        //and weight as the parameters that it needs. Remember I asked for the height first, then the weight in the method
        //so I put height and then weight into the method. (h1, then w1)
        System.out.println("BMI for person 1: " + calcBMI(h1, w1));
        System.out.println();
        //Now that we've printed out their BMI, we'll find out what weight class they're in. To do that, we'll use the
        //method we made that returns a String. All we have to do is give it a BMI. Hm, how can we easily get a BMI?
        //OH YEAH! WE MADE A METHOD FOR IT!
        System.out.println("Weight Category: " + weightClass(calcBMI(h1, w1)));

        //More spacers
        System.out.println();
        System.out.println();

        //Exactly the same as we just did, but with the second person's data. We calculate the BMI and give it h2 and w2
        //as parameters and then print out their weight class based on that
        System.out.println("BMI for person 2: " + calcBMI(h2, w2));
        System.out.println();
        System.out.println("Weight Category: " + weightClass(calcBMI(h2, w2)));

        System.out.println();
        System.out.println();

        //Last thing to do is just print out the difference of the two BMIs. Idek why, it was in the powerpoint so I put
        //it in. Just getting the two BMIs and doing a bit of simple subtraction...
        System.out.println("Difference of both BMIs: " + (calcBMI(h1, w1) - calcBMI(h2, w2)));


    }

    public static double calcBMI(double height, double weight) {
        /*
        BMI = (weight/height^2) * 703

        So instead of performing the same math twice, let's just make a method to do the math and spit it back out at us
        This method is a double because it returns a double to us - the BMI. You'll also notice that this method is static.
        It has to be static because it's being called from inside the main() method, which is static itself. Methods called
        from a static method must themselves be static. We'll undoubtedly come back to this.

        All we have to do here is "return" the math required for the BMI (I have the formula above, just compare the return statement
        and the equation and you'll understand)

        This method accepts 2 doubles as parameters, and you'll notice that we use them below. That's where we'll input the height and
        weight when we call this method.
        */

        return (weight / (height * height)) * 703;

    }

    /*
    Just like the method to calculate the BMI, we can also use a method to get what weight class someone is in based on
    their BMI. Here's where if/else statements come into play, as well as the && operator. Also note this is static because
    It's being used by a static method ( main() )

    So, this method returns a String because obviously, we're returning a String. String is capitalized. That's on purpose.
    All Strings are objects of the String class which is part of the java library.

    Starting off, we take the parameter supplied to us ( a double which I've called bmi ) and we see if it's less than the
    maximum BMI a person needs to be underweight.
        If it is, we'll say that the person is underweight

        If it's not, we move on and see if it's between the max for being overweight and the max for being normal. Here we use
        the && operator so that It will only say the person is normal weight IF AND ONLY IF both conditions are true
        (Condition 1: bmi > underWeight)
        (Condition 2: bmi < normalWeight)

        If it is, say they're normal weight.

        If they're not, move on and see if they're in between the max for normal weight, and the max for overweight

        If they are, say they're overweight

        OTHERWISE (else) they MUST be Obese because we've tried every other option, so if none of the other things are true
        we'll say that they're obese.
     */

    public static String weightClass(double bmi) {
        if (bmi < underWeight) {
            return "Underweight";
        } else if (bmi > underWeight && bmi < normalWeight) {
            return "Normal Weight";
        } else if (bmi > normalWeight && bmi < overWeight) {
            return "Overweight";
        } else {
            return "Obese";
        }


    }


}
