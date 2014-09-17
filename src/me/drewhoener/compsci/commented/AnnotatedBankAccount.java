package me.drewhoener.compsci.commented;

/*
* @author Drew Hoener * */
public class AnnotatedBankAccount {
    /*
    The variable for the balance of the account. It is a double, so, it can contain a decimal (as opposed to an int, which can't)
    It's private because it doesn't need to be directly accessed/viewed from classes creating instances of it. Note that that it
    doesn't have a value yet because we haven't assigned one to it. */
    private double balance;

    /*
    This is the first of our constructors. Constructors are always named after their class, so this will be named "AnnotatedBankAccount".
    Because it's a constructor there is no return type, not even "void". In this constructor, there are no arguments, or accepted
    types. That's because this is our default constructor, and inside, we are giving the balance variable a value of 0. We're setting it
    to zero because we're not giving it a starting balance, and if we don't put in any money from the beginning, then the default balance
    must be zero, right? */
    public AnnotatedBankAccount() {
        balance = 0;
    }

    /*
    This is our second constructor, which looks pretty much like the first one, except for two things. We notice that it is still named
    after the class (AnnotatedBankAccount), but this time it contains a parameter named "a", which is a double. This double is not being
    declared like the balance variable, it only means that when you make a new instance of this class, you can put a double in there.
    Inside the constructor, we're taking whatever value "a" is set to when calling
    the constructor, and making "balance" equal to it. */
    public AnnotatedBankAccount(double a) {
        balance = a;
    }

    /*
    This is our only "getter" in the AnnotatedBankAccount class (Dr. Nguyen calls them "accessors", but I find "getter" more convenient).
    For convenience, I've named it "getBalance", but it can really be named anything. "getBalance" accepts no parameters because it doesn't
    require any value to get what the balance equals. "getBalance" has a return type of "double" because it's returning "balance", which is
    a double itself. The part inside of the method - "return balance;" quite literally means that it is giving you the value of "balance".
    */
    public double getBalance() {
        return balance;
    }

    /*
    This is the first of our "setters" (probably introduced to you as "mutators"). The name of the method is "deposit", and it's a void.
    Now, as opposed to "getBalance" which returns a double, you'll notice that this method is something called a void, meaning that it
    doesn't return anything to you, and you don't need it to. Do you need a value returned to you when you tell it to deposit money? No,
    you only need to tell it how much to deposit, which is the only parameter it takes. The parameter is a double, which is named "value"
    (again, can be named anything). All we're doing is taking the amount that is specified to value, and adding it into the "balance" variable
    as shown below. (We'll go into this more when we create an instance of this class)
    */
    public void deposit(double value) {
        balance += value;
    }

    /*
    This is yet another "setter", only this time, instead of depositing, we're
    withdrawing. Standard for a Bank Account, right? Basically this
    works exactly the same as the deposit method: It's return type is "void"
    because it doesn't return anything, it accepts a double as a parameter,
    only this time, we're subtracting the input value from the current balance
    using the "-=" operator (equivalent to balance = balance - value;). */
    public void withdraw(double value) {
        balance -= value;
    }
/*
Now you might be thinking: "Wait, where's the 'public static void main(String [] args)'?! How will I ever run this thing!? I better create
one in this class right now!", and my response is: Don't. The whole point of the lesson on BankAccount was to teach how to create multiple
instances of a class, based on a blueprint set out, just like this one. I'll explain more in the AnnotatedTest class.
*/
}
