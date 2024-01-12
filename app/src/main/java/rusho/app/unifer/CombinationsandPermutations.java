/**
 * Name: Rusho Binnabi
 * Date: November 8th, 2022
 * Project: Unifier App - Combinations and Permutations Function
 * Contact Information: RushoBinnabi123@yahoo.com
 * Code File Updated: 4/16/2023 at 10:55 PM 
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

    // this class calculates combinations and permutations with or without repeats based on what the user inputs as numbers for total number of objects and the number of chosen objects.

    @SuppressLint("UseSwitchCompatOrMaterialCode") 
    Switch repititionSwitch;
    @SuppressLint("UseSwitchCompatOrMaterialCode") 
    Switch orderMatters;
    EditText totalNumberofObjectsEntry; 
    EditText numberofObjectsChosenEntry;
    Button calculateButton; 
    Button resetButton;
    String totalNumberofObjectsText; 
    String numberofObjectsChosenText; 
    long totalNumberofObjectsValue;
    long numberofObjectsChosenValue;

/*
* this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, has the code for the Combinations and Permutations function that the Unifier app needs to function.
* this method is void because it doesn't return anything.
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinations_and_permutations);
        activate();
        resetButton.setOnClickListener(v -> reset()); 
        calculateButton.setOnClickListener(v -> calculateCombinationsandPermutations()); 
    }

/*
* this private void reset() method resets all the values of the variables and the objects.
* this method is void because it doesn't return anything.
*/
    private void reset() {
        totalNumberofObjectsText = ""; 
        numberofObjectsChosenText = ""; 
        totalNumberofObjectsValue = 0; 
        numberofObjectsChosenValue = 0; 
        totalNumberofObjectsEntry.getText().clear();
        numberofObjectsChosenEntry.getText().clear(); 
        orderMatters.setChecked(false);
        repititionSwitch.setChecked(false); 
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        repititionSwitch = findViewById(R.id.RepititionSwitch);
        orderMatters = findViewById(R.id.OrderSwitch);
        totalNumberofObjectsEntry = findViewById(R.id.TotalNumberofObjectsEntry); 
        numberofObjectsChosenEntry = findViewById(R.id.NumberofObjectsChosenEntry); 
        calculateButton = findViewById(R.id.CalculateButton); 
        resetButton = findViewById(R.id.ResetButton); 
    }

    /**
     * this private static long factorialNumber() method calculates the factorial of number.
     * this method is private because only this function of the app will be using it.
     * this method is also static so that it can be referenced and used from anywhere in the code file.
     * @param number the number that the user enters from which a factorial will be calculated.
     * @return the factorial of number.
     */

    private static long factorialNumber(long number) {
        for (int i = (int) number - 1; i >= 1; i--) { 
            number = number * i; 
        }
        return number;
    }

    /**
     * this private static long permutationsWithRepitition() method calculates the number of permutations with repitition using n and r.
     * this method is private because only this function of the app will be using it.
     * this method is also static so that it can be referenced and used from anywhere in the code file.
     * @param n the total number of objects that are specified by the user.
     * @param r the number of objects that will be chosen by the user.
     * @return the number of permutations with repitition using n and r.
     */

    private static long permutationsWithRepitition(long n, long r) {
        return (long) Math.pow(n, r);
    }

    /**
     * this private static long permutationsWithoutRepitition() method calculates the number of permutations without repitition using n and r.
     * this method is private because only this function of the app will be using it.
     * this method is static so that it can be referenced and used from anywhere in the code file.
     * @param n the total number of objects that are specified by the user.
     * @param r the number of objects that will be chosen by the user.
     * @return the number of permutations without repitition using n and r.
     */ 

    private static long permutationsWithoutRepitition(long n, long r) {
        long num1 = factorialNumber(n);
        long num2 = n - r;
        long num3 = factorialNumber(num2); 
        return num1 / num3; 
    } 

    /**
     * this private static long combinationsWithRepitition() method calculates the number of combinations with repitition using n and r.
     * this method is private because only this function of the app will be using it.
     * this method is static so that it can be referenced and used from anywhere in the code file.
     * @param n the total number of objects that are specified by the user.
     * @param r the number of objects that will be chosen by the user.
     * @return the number of combinations with repitition using n and r.
     */

    private static long combinationsWithRepetition(long n, long r) {
        long num1 = factorialNumber((r + n) - 1);
        long num2 = factorialNumber(n - 1); 
        long num3 = num2 * factorialNumber(r); 
        return num1 / num3;
    }

    /**
     * this private static long combinationsWithoutRepitition() method calculates the number of combinations without repitition using n and r.
     * this method is private because only this function of the app will be using it.
     * this method is private so that it can be referenced and used from anywhere in the code file.
     * @param n the total number of objects that will be specified by the user.
     * @param r the number of objects that will be chosen by the user.
     * @return the number of combinations without repitition using n and r.
     */

    private static long combinationsWithoutRepitition(long n, long r) {
        long num1 = factorialNumber(n); 
        long num2 = factorialNumber(r); 
        long num3 = n - r;
        long num4 = factorialNumber(num3); 
        long num5 = num2 * num4; 
        return num1 / num5;
    }

    /**
     * this private void calculateCombinationsandPermutations() method runs the code for calculating combinations and permutations with or without repitition based on what the user selected for n and r.
     * this method is void because it doesn't return anything.
     */

    private void calculateCombinationsandPermutations() {
        try { 
            if (repititionSwitch.isChecked() && orderMatters.isChecked()) { 
                totalNumberofObjectsText = totalNumberofObjectsEntry.getText().toString();
                numberofObjectsChosenText = numberofObjectsChosenEntry.getText().toString();
                totalNumberofObjectsValue = Long.parseLong(totalNumberofObjectsText); 
                numberofObjectsChosenValue = Long.parseLong(numberofObjectsChosenText); 
                Toast.makeText(this, permutationsWithRepitition(totalNumberofObjectsValue, numberofObjectsChosenValue) + " permutations with repeats", Toast.LENGTH_SHORT).show();
            }
            else if (!repititionSwitch.isChecked() && orderMatters.isChecked()) { 
                totalNumberofObjectsText = totalNumberofObjectsEntry.getText().toString(); 
                numberofObjectsChosenText = numberofObjectsChosenEntry.getText().toString();
                totalNumberofObjectsValue = Long.parseLong(totalNumberofObjectsText); 
                numberofObjectsChosenValue = Long.parseLong(numberofObjectsChosenText);
                Toast.makeText(this, permutationsWithoutRepitition(totalNumberofObjectsValue, numberofObjectsChosenValue) + " permutations without repeats", Toast.LENGTH_SHORT).show(); 
            }
            else if (repititionSwitch.isChecked() && !orderMatters.isChecked()) { 
                totalNumberofObjectsText = totalNumberofObjectsEntry.getText().toString(); 
                numberofObjectsChosenText = numberofObjectsChosenEntry.getText().toString(); 
                totalNumberofObjectsValue = Long.parseLong(totalNumberofObjectsText);
                numberofObjectsChosenValue = Long.parseLong(numberofObjectsChosenText);
                Toast.makeText(this, combinationsWithRepetition(totalNumberofObjectsValue, numberofObjectsChosenValue) + " combinations with repeats", Toast.LENGTH_SHORT).show();
            }
            else if (!repititionSwitch.isChecked() && !orderMatters.isChecked()) { 
                totalNumberofObjectsText = totalNumberofObjectsEntry.getText().toString();
                numberofObjectsChosenText = numberofObjectsChosenEntry.getText().toString(); 
                totalNumberofObjectsValue = Long.parseLong(totalNumberofObjectsText); 
                numberofObjectsChosenValue = Long.parseLong(numberofObjectsChosenText);
                Toast.makeText(this, combinationsWithoutRepitition(totalNumberofObjectsValue, numberofObjectsChosenValue) + " combinations without repeats", Toast.LENGTH_SHORT).show();
            } 
        } catch (NumberFormatException n) { 
            Toast toast = Toast.makeText(this, "Error. Please enter a number", Toast.LENGTH_SHORT); 
            toast.setGravity(Gravity.BOTTOM, 0, 120);
            toast.show();
        }
    }

    /**
     * this public void combinationsAndPermutationsChangetoMainMenuScreen() method changes the screen to main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void combinationsAndPermutationsChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class); 
        startActivity(intent); 
    } 

}