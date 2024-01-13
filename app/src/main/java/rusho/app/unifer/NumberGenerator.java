/**
 * Name: Rusho Binnabi
 * Date: 7/21/2023
 * Project: Unifier App - Number Generator Function
 */

package rusho.app.unifer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

/**
 * this NumberGenerator class has all the things needed for the Number Generator function of the app to run.
 */

public class NumberGenerator extends AppCompatActivity {

    // this class generates a random number between a range of two numbers entered by the user.

    private Button clearNumberButton;
    private Button generateNumberButton;
    private String number1Text;
    private String number2Text;
    private int number1;
    private int number2;
    private int randomNumber;
    private EditText enterNumber1;
    private EditText enterNumber2;
    private Random numberGenerator;

    /**
     * this setClearNumberButton() method sets the clear number button.
     */
    public void setClearNumberButton() {
        clearNumberButton = findViewById(R.id.ClearNumberButton);
    }

    /**
     * this getClearNumberButton() method gets the clear number button.
     * @return the clear number button.
     */

    public Button getClearNumberButton() {
        return clearNumberButton;
    }

    /**
     * this setGenerateNumberButton() method sets the generate number button.
     */

    public void setGenerateNumberButton() {
        generateNumberButton = findViewById(R.id.GenerateNumberButton);
    }

    /**
     * this setRandomNumber() method sets the random number.
     * @param number the random number being set.
     */

    public void setRandomNumber(int number) {
        randomNumber = number;
    }

    /**
     * this getRandomNumber() method gets the random number.
     * @return the random number.
     */

    public int getRandomNumber() {
        return randomNumber;
    }

    /**
     * this setNumber1Text() method sets the text for the 1st number.
     * @param string the text for the 1st number.
     */

    public void setNumber1Text(String string) {
        number1Text = string;
    }

    /**
     * this getNumber1Text() method gets the text for the 1st number.
     * @return the text for the 1st number.
     */

    public String getNumber1Text() {
        return number1Text;
    }

    /**
     * this setNumber2Text() method sets the text for the 2nd number.
     * @param string the text for the 1st number.
     */

    public void setNumber2Text(String string) {
        number2Text = string;
    }

    /**
     * this getNumber2Text() method gets the text for the 2nd number.
     * @return the text for the 2nd number.
     */

    public String getNumber2Text() {
        return number2Text;
    }

    /**
     * this setNumber1() method sets the 1st number.
     * @param number the 1st number.
     */

    public void setNumber1(int number) {
        number1 = number;
    }

    /**
     * this getNumber1() method gets the 1st number.
     * @return the 1st number.
     */

    public int getNumber1() {
        return number1;
    }

    /**
     * this setNumber2() method sets the 2nd number.
     * @param number the 2nd number.
     */

    public void setNumber2(int number) {
        number2 = number;
    }

    /**
     * this getNumber2() method gets the 2nd number.
     * @return the 2nd number.
     */

    public int getNumber2() {
        return number2;
    }

    /**
     * this getEnterNumber1() method gets the edit text for the 1st number.
     * @return the edit text for the 1st number.
     */

    public EditText getEnterNumber1() {
        return enterNumber1;
    }

    /**
     * this setEnterNumber1() method sets the edit text for the 1st number.
     */

    public void setEnterNumber1() {
        enterNumber1 = findViewById(R.id.EnterNumber1);
    }

    /**
     * this getEnterNumber2() method gets the edit text for the 2nd number.
     * @return the edit text for the 2nd number.
     */

    public EditText getEnterNumber2() {
        return enterNumber2;
    }

    /**
     * this setEnterNumber2() method sets the edit text for the 2nd number.
     */

    public void setEnterNumber2() {
        enterNumber2 = findViewById(R.id.EnterNumber2);
    }

    /**
     * this setNumberGenerator() method sets the number generator.
     */

    public void setNumberGenerator() {
        numberGenerator = new Random();
    }

    /**
     * this getNumberGenerator() method gets the number generator.
     * @return the number generator.
     */

    public Random getNumberGenerator() {
        return numberGenerator;
    }

    /**
     * this getGenerateNumberButton() method gets the generate number button.
     * @return the generate number button.
     */

    public Button getGenerateNumberButton() {
        return generateNumberButton;
    }
    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Number Generator function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_generator);
        activate();
        getClearNumberButton().setOnClickListener(v -> clearNumber());
        getGenerateNumberButton().setOnClickListener(v -> generateNumber());
    }

    /**
     * this public void numberGeneratorChangetoMainMenuScreen() method changes the screen to main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void numberGeneratorChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

    /**
     * this private void generateNumber() method generates a random number between a range of two numbers entered by the user.
     */

    private void generateNumber() {
        try {
            setNumber1Text(getEnterNumber1().getText().toString());
            setNumber2Text(getEnterNumber2().getText().toString());
            setNumber1(Integer.parseInt(getNumber1Text()));
            setNumber2(Integer.parseInt(getNumber2Text()));
            setRandomNumber(getNumberGenerator().nextInt((getNumber2() - getNumber1()) + 1) + getNumber1()); // randomNumber will have the number that is generated by the range of two numbers within number1 and number2.
            showRandomNumber();
        }
        catch (NumberFormatException n) {
            Toast toast = Toast.makeText(this, "Error. Please enter two numbers", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 120);
            toast.show();
        }
    }

    /**
     * this private void showRandomNumber() method shows the randomly generated number that is between a range of two numbers.
     */

    private void showRandomNumber() {
        Toast toast = Toast.makeText(this, "Randomly generated number between " + getNumber1() + " and " + getNumber2() + ": " + getRandomNumber(), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 120);
        toast.show();
    }

    /**
     * this private void clearNumber() method clears all the data from all the variables and objects.
     */

    private void clearNumber() {
        setNumber1Text("");
        setNumber2Text("");
        setNumber1(0);
        setNumber2(0);
        setRandomNumber(0);
        getEnterNumber1().getText().clear();
        getEnterNumber2().getText().clear();
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        setClearNumberButton();
        setGenerateNumberButton();
        setNumberGenerator();
        setNumber1Text("");
        setNumber2Text("");
        setNumber1(0);
        setNumber2(0);
        setRandomNumber(0);
        setEnterNumber1();
        setEnterNumber2();
    }

}