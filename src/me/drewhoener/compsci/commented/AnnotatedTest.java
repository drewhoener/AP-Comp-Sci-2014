package me.drewhoener.compsci.commented;

/*
     * @author Drew Hoener
  * */
public class AnnotatedTest {
    /*
    Here it is! The method you've all been waiting for! The official start of the program! So why didn't we make one of
    these inside of the AnnotatedBankAccount class?? The answer: We didn't need to. We're making instances of the
    BankAccount class, which are Objects, which we can use completely seperately of each other. So, instead of making
    12 different classes for different Bank Accounts, we can make 12 "Instances" of the AnnotatedBankAccount class.
    Neat huh? Of course, we won't be making 12 because that's effort, and I only really need to make 2-3 to get the
    point across. */
    public static void main(String[] args) { /*
Ok, let's break this down. The first part "AnnotatedBankAccount" simply states what type of data the variable is
representing. In this case, it's an Object of the AnnotatedBankAccount class.
The next part is "aba1". That's simply the name I've given it; you can name
it whatever.
Now, we're taking that variable, and making it equal a 'new' instance of the
AnnotatedBankAccount class.
This is the important part. The "AnnotatedBankAccount()", represents one
of your constructors that you've made
in that class. Any guesses which one this is? This one is the one without a
starting balance, so the balance will start off at $0.
*/
        AnnotatedBankAccount aba1 = new AnnotatedBankAccount();
/*
This is another instance of the AnnotatedBankAccount class. The only differences are: 1: The name. I've named
this one "aba2" because you can't have two Objects/variables or methods with the same name, and 2: The
constructor. As you'll see, this one has the number 100 in it. This is telling the second constructor that we
defined (the one with a double as a parameter?) that we should start out
the account with a balance of $100 (Look back at the constructors in the AnnotatedBankAccount class if you're
confused). It should be noted that "aba1" and "aba2" are completely and totally seperate, even though they're instances of
the same class. One currently has a balance of $0 (The first one. Why? Because we didn't give it any money to
start out with!), and the other has a balance of $100 (Because we specified that in the constructor!). They have
the same methods as the AnnotatedBankAccount class we created, but their values are their own and are not to be
used for others. Each one of these has their own balance variable, their own deposit and withdraw methods, and
their own method to getBalance, simply because the class we're creating an instance of (AnnotatedBankAccount)
has those. */

        AnnotatedBankAccount aba2 = new AnnotatedBankAccount(100);
/*
To show that they are seperate, I'm setting depositing $20 into the first one , and withdrawing $30 from the
second one, and we'll break it down to see what I'm doing.
aba1.deposit(20) is taking the class we created above (called "aba1") and getting the method "deposit". Into
that method, we put the number 20, because it needs a double, as a parameter (Yes, technically it's an integer,
but you can look at it as being 20.0. See? A decimal!). Then that double that we specified is added to the
"balance" variable that's unique to "aba1" (remember, it has it's own balance variable, because it's a seperate
instance).
aba2.withdraw(30) is doing almost the same thing. It's getting the withdraw method from aba2, and giving it 30
(or 30.0, if you're picky) as the parameter it needs (remember it needs a double to withdraw/subtract from the
total balance?). Then, inside of the aba2 Object, it's subtracting 30 from the total balance, which started at
$100 (the constructor, remember?). */
        aba1.deposit(20);
        aba2.withdraw(30);
/*
Now, if we print out the balance of both of those Objects, we should get $20 for the first one, because we
started at $0 and added $20, and $70 for the second one, because we started at $100 and subtracted $30.
Let's print them out and see. We can run through what's happening in these lines too.
Things we've already learned, we're printing out a complete line to the console with the text "Balance of..etc."
and then we're joining that text (using "+") with...a method???? Why? Well , it's the same as if you had joined
it with the number 20, or the number 70 (which happen to be the balances of those two accounts). Remember how
we made the method "getBalance" return a double? Well, aba1. getBalance() or aba2.getBalance() are actually
numbers, they're just represented by that method ("getBalance"). */
        System.out.println("Balance of first account: $" + aba1.getBalance());
        System.out.println("Balance of second account: $" + aba2.getBalance());
/*
If you run it, you'll find that it works just fine. You can experiment by creating other instances of the
AnnotatedBankAccount class, and depositing, withdrawing, and checking the balance. The more you practice, the
better you'll get with it.
- If you're feeling adventurous, try using the Scanner class to get user input for deposits/withdrawals, and
checking balance, but only do it if you feel like you've totally got this entire thing down.
-Drew Hoener
(AP Comp Sci Day1 R3, if anyone was wondering :D)
*/
    }
}
