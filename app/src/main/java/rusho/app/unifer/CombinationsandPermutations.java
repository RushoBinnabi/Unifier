/**
 * Name: Rusho Binnabi
 * Date: November 8th, 2022
 * Project: Unifier App - Combinations and Permutations Function
 * Contact Information: RushoBinnabi123@yahoo.com
 * Code File Updated: December 30th, 2022 at 6:43 PM 
 */

package rusho.app.unifer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * this CombinationsandPermutations class, which inherits from the AppCompatActivity class, has everything that the Combinations and Permutations function of the Unifier app needs to run. 
 */

public class CombinationsandPermutations extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode") // suppresses some errors with the text because there was nothing wrong with the text.
    Switch repititionSwitch; // creates a Switch object called repititionSwitch.
    @SuppressLint("UseSwitchCompatOrMaterialCode") // suppresses some errors with the text because there was nothing wrong with the text.
    Switch orderMatters; // creates a Switch object called orderMatters.
    EditText totalNumberofObjectsEntry; // creates an EditText object called totalNumberofObjectsEntry.
    EditText numberofObjectsChosenEntry; // creates an EditText object called numberofObjectsChosenEntry.
    Button calculateButton; // creates a Button object called calculateButton.
    Button resetButton; // creates a Button object called resetButton.
    String totalNumberofObjectsText; // creates a String variable called totalNumberofObjectsText.
    String numberofObjectsChosenText; // creates a String variable called numberofObjectsChosenText.
    long totalNumberofObjectsValue; // creates a long variable called totalNumberofObjectsValue.
    long numberofObjectsChosenValue; // creates a long variable called numberofObjectsChosenValue.

/*
* this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, has the code for the Combinations and Permutations function that the Unifier app needs to function.
* this method is void because it doesn't return anything.
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // using the super.onCreate() method, it uses the savedInstanceState object as its argument which means that next time, the program starts off from where it left off from last time.
        setContentView(R.layout.activity_combinations_and_permutations); // the setContentView() method uses R.layout.activity_combinations_and_permutations which is the layout file for the Combinations and Permutations function of the Unifier app.
        repititionSwitch = findViewById(R.id.RepititionSwitch); // repititionSwitch gets set to the id called RepititionSwitch of the Switch object that determines whether the calculation has values that repeat or not.
        orderMatters = findViewById(R.id.OrderSwitch); // orderMatters gets set to the id called OrderSwitch of the Switch object that determines whether the order of the values of the calculation matters or not.
        totalNumberofObjectsEntry = findViewById(R.id.TotalNumberofObjectsEntry); // totalNumberofObjectsEntry gets set to the id called TotalNumberofObjectsEntry of the EditText object that gets the input from the user of the total number of objects in the calculation.
        numberofObjectsChosenEntry = findViewById(R.id.NumberofObjectsChosenEntry); // numberofObjectsChosenEntry gets set to the id called numberofObjectsChosenEntry of the EditText object that gets the input from the user of the number of objects chosen that will be in the calculation.
        calculateButton = findViewById(R.id.CalculateButton); // calculateButton gets set to the id called CalculateButton of the Button object that when clicked, calculates the combination and permutation based on if there are any repeats in the total number of objects and the number of objects chosen and if the order matters or not.
        resetButton = findViewById(R.id.ResetButton); // resetButton gets set to the id called ResetButton of the Button object that when clicked, will reset the values of the variables and objects.

        resetButton.setOnClickListener(v -> reset()); // when resetButton is clicked, using the setonClickListener() method, it runs the reset() method via the v lambda expression.
        calculateButton.setOnClickListener(v -> calculateCombinationsandPermutations()); // when calculateButton is clicked, using the setonClickListener() method, it runs the calculateCombinationsandPermutations() method via the v lambda expression.
    } // the end of the onCreate() method.

/*
* this private void reset() method resets all the values of the variables and the objects.
* this method is void because it doesn't return anything.
*/
    private void reset() {
        totalNumberofObjectsText = ""; // the value of totalNumberofObjectsText gets set to an empty string.
        numberofObjectsChosenText = ""; // the value of numberofObjectsChosenText gets set to an empty string.
        totalNumberofObjectsValue = 0; // the value of totalNumberofObjectsValue gets set to 0.
        numberofObjectsChosenValue = 0; // the value of numberofObjectsChosenValue gets set to 0.
        totalNumberofObjectsEntry.getText().clear(); // clears the text from totalNumberofObjectsEntry.
        numberofObjectsChosenEntry.getText().clear(); // clears the text from numberofObjectsChosenEntry.
        orderMatters.setChecked(false); // sets the value of the orderMatters switch to false.
        repititionSwitch.setChecked(false); // sets the value of the repititionSwitch switch to false.
    } // the end of the reset() method.

    /**
     * this private static long factorialNumber() method calculates the factorial of number.
     * this method is private because only this function of the app will be using it.
     * this method is also static so that it can be referenced and used from anywhere in the code file.
     * @param number the number that the user enters from which a factorial will be calculated.
     * @return the factorial of number.
     */

    private static long factorialNumber(long number) {
        for (int i = (int) number - 1; i>= 1; i--) { // as long as the value of the integer variable i is the value of number minus 1 and the value of i is greater than or equal to 1, the value of i will be decreased by 1 each time the loop runs and the code in the for loop will run.
            number = number * i; // number will have the value of itself multiplied by the current value of i.
        } // the end of the for loop.
        return number; // returns number.
    } // the end of the factorialNumber() method.

    /**
     * this private static long permutationsWithRepitition() method calculates the number of permutations with repitition using n and r.
     * this method is private because only this function of the app will be using it.
     * this method is also static so that it can be referenced and used from anywhere in the code file.
     * @param n the total number of objects that are specified by the user.
     * @param r the number of objects that will be chosen by the user.
     * @return the number of permutations with repitition using n and r.
     */

    private static long permutationsWithRepitition(long n, long r) {
        return (long) Math.pow(n, r); // returns the value of n to the power of r.
    } // the end of the permutationWithRepitition() method.

    /**
     * this private static long permutationsWithoutRepitition() method calculates the number of permutations without repitition using n and r.
     * this method is private because only this function of the app will be using it.
     * this method is static so that it can be referenced and used from anywhere in the code file.
     * @param n the total number of objects that are specified by the user.
     * @param r the number of objects that will be chosen by the user.
     * @return the number of permutations without repitition using n and r.
     */ 

    private static long permutationsWithoutRepitition(long n, long r) {
        long num1 = factorialNumber(n); // creates a long variable called num1 which will have the factorial of n using the factorialNumber() method.
        long num2 = n - r; // creates a long variable called num2 which will have the subtracted value of n and r.
        long num3 = factorialNumber(num2); // creates a long variable called num3 which will have the factorial of num2 using the factorialNumber() method.
        return num1 / num3; // returns the value of num1 divided by num3.
    } // the end of the permutationWithoutRepitition() method.

    /**
     * this private static long combinationsWithRepitition() method calculates the number of combinations with repitition using n and r.
     * this method is private because only this function of the app will be using it.
     * this method is static so that it can be referenced and used from anywhere in the code file.
     * @param n the total number of objects that are specified by the user.
     * @param r the number of objects that will be chosen by the user.
     * @return the number of combinations with repitition using n and r.
     */

    private static long combinationsWithRepetition(long n, long r) {
        long num1 = factorialNumber((r + n) - 1); // creates a long variable called num1 which will have the factorial of (r + n) - 1 using the factorialNumber() method.
        long num2 = factorialNumber(n - 1); // creates a long variable called num2 which will have the factorial of n - 1 using the factorialNumber() method.
        long num3 = num2 * factorialNumber(r); // creates a long variable called num3 which will have the multiplied values of num2 and the factorial of r using the factorialNumber() method.
        return num1 / num3; // returns the value of num1 divided by num3.
    } // the end of the combinationsWithRepitition() method.

    /**
     * this private static long combinationsWithoutRepitition() method calculates the number of combinations without repitition using n and r.
     * this method is private because only this function of the app will be using it.
     * this method is private so that it can be referenced and used from anywhere in the code file.
     * @param n the total number of objects that will be specified by the user.
     * @param r the number of objects that will be chosen by the user.
     * @return the number of combinations without repitition using n and r.
     */

    private static long combinationsWithoutRepitition(long n, long r) {
        long num1 = factorialNumber(n); // creates a long variable called num1 which will have the factorial of n using the factorialNumber() method.
        long num2 = factorialNumber(r); // creates a long variable called num2 which will have the factorial of r using the factorialNumber() method.
        long num3 = n - r; // creates a long variable called num3 which will have the subtracted values of n - r.
        long num4 = factorialNumber(num3); // creates a long variable called num4 which will have the factorial of num3 using the factorialNumber() method.
        long num5 = num2 * num4; // creates a long variable called num5 which will have the multiplied values of num2 and num4.
        return num1 / num5; // returns the value of num1 divided by num5.
    } // the end of the combinationsWithoutRepitition() method.

    /**
     * this private void calculateCombinationsandPermutations() method runs the code for calculating combinations and permutations with or without repitition based on what the user selected for n and r.
     * this method is void because it doesn't return anything.
     */

    private void calculateCombinationsandPermutations() {
        try { // the try block will try to run the code.
            if (repititionSwitch.isChecked() && orderMatters.isChecked()) { // the code inside the if statement will run if both repititionSwitch and orderMatters is checked.
                totalNumberofObjectsText = totalNumberofObjectsEntry.getText().toString(); // totalNumberofObjectsText will convert the text entered by the user for n into a text string.
                numberofObjectsChosenText = numberofObjectsChosenEntry.getText().toString(); // numberofObjectsChosenText will convert the text entered by the user for r into a text string.
                totalNumberofObjectsValue = Long.parseLong(totalNumberofObjectsText); // totalNumberofObjectsValue will convert the text string inside totalNumberofObjectsText into a usable long value.
                numberofObjectsChosenValue = Long.parseLong(numberofObjectsChosenText); // numberofObjectsChosenValue will convert the text string inside numberofObjectsChosenText into a usable long value.
                Toast.makeText(this, permutationsWithRepitition(totalNumberofObjectsValue, numberofObjectsChosenValue) + " permutations with repeats", Toast.LENGTH_SHORT).show(); // shows the user the number of permutations with repitition using the permutationsWithRepitition() method along with totalNumberofObjectsValue and numberofObjectsChosenValue as its arguments.
            } // the end of the if statement.
            else if (!repititionSwitch.isChecked() && orderMatters.isChecked()) { // the code inside the else if statement will run if repititionSwitch is not checked and orderMatters is checked.
                totalNumberofObjectsText = totalNumberofObjectsEntry.getText().toString(); // totalNumberofObjectsText will convert the text entered by the user for n into a text string.
                numberofObjectsChosenText = numberofObjectsChosenEntry.getText().toString(); // numberofObjectsChosenText will convert the text entered by the user for r into a text string.
                totalNumberofObjectsValue = Long.parseLong(totalNumberofObjectsText); // totalNumberofObjectsValue will convert the text string inside totalNumberofObjectsText into a usable long value.
                numberofObjectsChosenValue = Long.parseLong(numberofObjectsChosenText); // numberofObjectsChosenValue will convert the text string inside numberofObjectsChosenText into a usable long value.
                Toast.makeText(this, permutationsWithoutRepitition(totalNumberofObjectsValue, numberofObjectsChosenValue) + " permutations without repeats", Toast.LENGTH_SHORT).show(); // shows the user the number of permutations without repitition using the permutationsWithoutRepitition() method along with totalNumberofObjectsValue and numberofObjectsChosenValue as its arguments.
            } // the end of the else if statement.
            else if (repititionSwitch.isChecked() && !orderMatters.isChecked()) { // the code inside the else if statement will run if repititionSwitch is checked and orderMatters is not checked.
                totalNumberofObjectsText = totalNumberofObjectsEntry.getText().toString(); // totalNumberofObjectsText will convert the text entered by the user for n into a text string.
                numberofObjectsChosenText = numberofObjectsChosenEntry.getText().toString(); // numberofObjectsChosenText will convert the text entered by the user for r into a text string.
                totalNumberofObjectsValue = Long.parseLong(totalNumberofObjectsText); // totalNumberofObjectsValue will convert the text string inside totalNumberofObjectsText into a usable long value.
                numberofObjectsChosenValue = Long.parseLong(numberofObjectsChosenText); // numberofObjectsChosenValue will convert the text string inside numberofObjectsChosenText into a usable long value.
                Toast.makeText(this, combinationsWithRepetition(totalNumberofObjectsValue, numberofObjectsChosenValue) + " combinations with repeats", Toast.LENGTH_SHORT).show(); // shows the user the number of combinations with repitition using the combinationsWithRepitition() method along with totalNumberofObjectsValue and numberofObjectsChosenValue as its arguments.
            } // the end of the else if statement.
            else if (!repititionSwitch.isChecked() && !orderMatters.isChecked()) { // the code inside the else if statement will run if both the repititionSwitch is not checked and orderMatters is not checked.
                totalNumberofObjectsText = totalNumberofObjectsEntry.getText().toString(); // totalNumberofObjectsText will convert the text entered by the user for n into a text string.
                numberofObjectsChosenText = numberofObjectsChosenEntry.getText().toString(); // numberofObjectsChosenText will convert the text entered by the user for r into a text string.
                totalNumberofObjectsValue = Long.parseLong(totalNumberofObjectsText); // totalNumberofObjectsValue will convert the text string inside totalNumberofObjectsText into a usable long value.
                numberofObjectsChosenValue = Long.parseLong(numberofObjectsChosenText); // numberofObjectsChosenValue will convert the text string inside numberofObjectsChosenText into a usable long value.
                Toast.makeText(this, combinationsWithoutRepitition(totalNumberofObjectsValue, numberofObjectsChosenValue) + " combinations without repeats", Toast.LENGTH_SHORT).show(); // shows the user the number of combinations without repitition using the combinationsWithoutRepitition() method along with totalNumberofObjectsValue and numberofObjectsChosenValue as its arguments.
            } // the end of the else if statement.
        } catch (NumberFormatException n) { // the code inside the catch statement runs if the user enters anything else other than a number.
            Toast toast = Toast.makeText(this, "Error. Please enter a number", Toast.LENGTH_SHORT); // tells the user to enter a number.
            toast.setGravity(Gravity.BOTTOM, 0, 120); // sets the position of the message pop-up at the bottom.
            toast.show(); // shows the message pop-up.
        } // the end of the catch statement.
    } // the end of the calculateCombinationsandPermutations() method.

    /**
     * this public void combinationsAndPermutationsChangetoMainMenuScreen() method changes the screen to main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void combinationsAndPermutationsChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class); // creates a new Intent object called intent that changes the screen of the app to the main menu.
        startActivity(intent); // calls the startActivity() method using intent as its argument.
    } // the end of the combinationsAndPermutationsChangetoMainMenuScreen() method.

} // the end of the CombinationsandPermutations class.