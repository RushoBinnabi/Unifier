/**
 * Name: Rusho Binnabi
 * Date: November 8th, 2022
 * Project: Unifier App - Combinations and Permutations Function
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
    private Switch repititionSwitch;
    @SuppressLint("UseSwitchCompatOrMaterialCode") 
    private Switch orderMatters;
    private EditText totalNumberofObjectsEntry;
    private EditText numberofObjectsChosenEntry;
    private Button calculateButton;
    private Button resetButton;
    private String totalNumberofObjectsText;
    private String numberofObjectsChosenText;
    private long totalNumberofObjectsValue;
    private long numberofObjectsChosenValue;

    /**
     * this setRepititionSwitch() method sets the repitition switch.
     */
    public void setRepititionSwitch() {
        repititionSwitch = findViewById(R.id.RepititionSwitch);
    }

    /**
     * this getRepititionSwitch() method gets the repitition switch.
     * @return the repitition switch.
     */

    public Switch getRepititionSwitch() {
        return repititionSwitch;
    }

    /**
     * this setOrderMatters() method sets the order matters switch.
     */

    public void setOrderMatters() {
        orderMatters = findViewById(R.id.OrderSwitch);
    }

    /**
     * this getOrderMatters() method gets the order matters switch.
     * @return the order matters switch.
     */

    public Switch getOrderMatters() {
        return orderMatters;
    }

    /**
     * this setTotalNumberofObjectsEntry() method sets the total number of objects edit text.
     */

    public void setTotalNumberofObjectsEntry() {
        totalNumberofObjectsEntry = findViewById(R.id.TotalNumberofObjectsEntry);
    }

    /**
     * this getTotalNumberofObjectsEntry() method gets the total number of objects edit text.
     * @return the total number of objects edit text.
     */

    public EditText getTotalNumberofObjectsEntry() {
        return totalNumberofObjectsEntry;
    }

    /**
     * this setNumberofObjectsChosenText() method sets the number of objects chosen edit text.
     */

    public void setNumberofObjectsChosenText() {
        numberofObjectsChosenEntry = findViewById(R.id.NumberofObjectsChosenEntry);
    }

    /**
     * this getNumberofObjectsChosenEntry() method gets the number of objects chosen edit text.
     * @return the number of objects chosen edit text.
     */

    public EditText getNumberofObjectsChosenEntry() {
        return numberofObjectsChosenEntry;
    }

    /**
     * this setCalculateButton() method sets the calculate button.
     */

    public void setCalculateButton() {
        calculateButton = findViewById(R.id.CalculateButton);
    }

    /**
     * this getCalculateButton() method gets the calculate button.
     * @return the calculate button.
     */

    public Button getCalculateButton() {
        return calculateButton;
    }

    /**
     * this setResetButton() method sets the reset button.
     */

    public void setResetButton() {
        resetButton = findViewById(R.id.ResetButton);
    }

    /**
     * this getResetButton() method gets the reset button.
     * @return the reset button.
     */

    public Button getResetButton() {
        return resetButton;
    }

    /**
     * this getTotalNumberofObjectsValue() method gets the total number of objects value.
     * @return the total number of objects value.
     */

    public long getTotalNumberofObjectsValue() {
        return totalNumberofObjectsValue;
    }

    /**
     * this setTotalNumberofObjectsValue() method sets the total number of objects value.
     * @param value the total number of objects value.
     */

    public void setTotalNumberofObjectsValue(long value) {
        totalNumberofObjectsValue = value;
    }

    /**
     * this getNumberofObjectsChosenValue() method gets the number of objects chosen value.
     * @return the number of objects chosen value.
     */

    public long getNumberofObjectsChosenValue() {
        return numberofObjectsChosenValue;
    }

    /**
     * this setNumberofObjectsChosenValue() method sets the number of objects chosen value.
     * @param value the number of objects chosen value.
     */

    public void setNumberofObjectsChosenValue(long value) {
        numberofObjectsChosenValue = value;
    }

    /**
     * this setTotalNumberofObjectsText() method sets the text for the total number of objects.
     * @param string the text for the total number of objects.
     */

    public void setTotalNumberofObjectsText(String string) {
        totalNumberofObjectsText = string;
    }

    /**
     * this getTotalNumberofObjectsText() method gets the text for the total number of objects.
     * @return the text for the total number of objects.
     */

    public String getTotalNumberofObjectsText() {
        return totalNumberofObjectsText;
    }

    /**
     * this setNumberofObjectsChosenText() method sets the text for the number of objects chosen.
     * @param string the text for the number of objects chosen.
     */

    public void setNumberofObjectsChosenText(String string) {
        numberofObjectsChosenText = string;
    }

    /**
     * this getNumberofObjectsChosenText() method gets the text for the number of objects chosen.
     * @return the text for the number of objects chosen.
     */

    public String getNumberofObjectsChosenText() {
        return numberofObjectsChosenText;
    }



    /*
    * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, has the code for the Combinations and Permutations function that the Unifier app needs to function.
    * this method is void because it doesn't return anything.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinations_and_permutations);
        activate();
        getResetButton().setOnClickListener(v -> reset());
        getCalculateButton().setOnClickListener(v -> calculateCombinationsandPermutations());
    }

    /*
    * this private void reset() method resets all the values of the variables and the objects.
    * this method is void because it doesn't return anything.
    */
    private void reset() {
        setTotalNumberofObjectsText("");
        setNumberofObjectsChosenText("");
        setTotalNumberofObjectsValue(0);
        setNumberofObjectsChosenValue(0);
        getTotalNumberofObjectsEntry().getText().clear();
        getNumberofObjectsChosenEntry().getText().clear();
        getOrderMatters().setChecked(false);
        getRepititionSwitch().setChecked(false);
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        setRepititionSwitch();
        setOrderMatters();
        setTotalNumberofObjectsEntry();
        setNumberofObjectsChosenText();
        setCalculateButton();
        setResetButton();
        setTotalNumberofObjectsText("");
        setNumberofObjectsChosenText("");
        setTotalNumberofObjectsValue(0);
        setNumberofObjectsChosenValue(0);
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
            if (getRepititionSwitch().isChecked() && getOrderMatters().isChecked()) {
                setTotalNumberofObjectsText(getTotalNumberofObjectsEntry().getText().toString());
                setNumberofObjectsChosenText(getNumberofObjectsChosenEntry().getText().toString());
                setTotalNumberofObjectsValue(Long.parseLong(getTotalNumberofObjectsText()));
                setNumberofObjectsChosenValue(Long.parseLong(getNumberofObjectsChosenText()));
                Toast.makeText(this, permutationsWithRepitition(getTotalNumberofObjectsValue(), getNumberofObjectsChosenValue()) + " permutations with repeats", Toast.LENGTH_SHORT).show();
            }
            else if (!getRepititionSwitch().isChecked() && getOrderMatters().isChecked()) {
                setTotalNumberofObjectsText(getTotalNumberofObjectsEntry().getText().toString());
                setNumberofObjectsChosenText(getNumberofObjectsChosenEntry().getText().toString());
                setTotalNumberofObjectsValue(Long.parseLong(getTotalNumberofObjectsText()));
                setNumberofObjectsChosenValue(Long.parseLong(getNumberofObjectsChosenText()));
                Toast.makeText(this, permutationsWithoutRepitition(getTotalNumberofObjectsValue(), getNumberofObjectsChosenValue()) + " permutations without repeats", Toast.LENGTH_SHORT).show();
            }
            else if (getRepititionSwitch().isChecked() && !getOrderMatters().isChecked()) {
                setTotalNumberofObjectsText(getTotalNumberofObjectsEntry().getText().toString());
                setNumberofObjectsChosenText(getNumberofObjectsChosenEntry().getText().toString());
                setTotalNumberofObjectsValue(Long.parseLong(getTotalNumberofObjectsText()));
                setNumberofObjectsChosenValue(Long.parseLong(getNumberofObjectsChosenText()));
                Toast.makeText(this, combinationsWithRepetition(getTotalNumberofObjectsValue(), getNumberofObjectsChosenValue()) + " combinations with repeats", Toast.LENGTH_SHORT).show();
            }
            else if (!getRepititionSwitch().isChecked() && !getOrderMatters().isChecked()) {
                setTotalNumberofObjectsText(getTotalNumberofObjectsEntry().getText().toString());
                setNumberofObjectsChosenText(getNumberofObjectsChosenEntry().getText().toString());
                setTotalNumberofObjectsValue(Long.parseLong(getTotalNumberofObjectsText()));
                setNumberofObjectsChosenValue(Long.parseLong(getNumberofObjectsChosenText()));
                Toast.makeText(this, combinationsWithoutRepitition(getTotalNumberofObjectsValue(), getNumberofObjectsChosenValue()) + " combinations without repeats", Toast.LENGTH_SHORT).show();
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