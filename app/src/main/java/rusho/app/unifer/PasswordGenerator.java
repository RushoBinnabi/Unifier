/**
 * Name: Rusho Binnabi
 * Date: 1/2/2023
 * Project: Unifier App - Password Generator Function
 */

package rusho.app.unifer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * this PasswordGenerator class, which inherits from the AppCompatActivity class, contains everything that the Password Generator function of the app needs to run.
 */

public class PasswordGenerator extends AppCompatActivity {

    // this class generates random passwords based on a length specified by the user.

    private EditText userInput;
    private TextView passwordOutput;
    private Button passwordGeneratorResetButton;
    private Button passwordGeneratorGeneratePasswordButton;
    private String generatedPassword;
    private int number;
    private String lowercaseLetters;
    private String uppercaseLetters;
    private String numbers;
    private String symbols;

    /**
     * this getUserInput() method gets the edit text for the user input.
     * @return the edit text for the user input.
     */

    public EditText getUserInput() {
        return userInput;
    }

    /**
     * this setUserInput() method sets the edit text for the user input.
     */

    public void setUserInput() {
        userInput = findViewById(R.id.PasswordGeneratorLengthInput);
    }

    /**
     * this getPasswordOutput() method gets the text view for the password output.
     * @return the text view for the password output.
     */

    public TextView getPasswordOutput() {
        return passwordOutput;
    }

    /**
     * this setPasswordOutput() method sets the text view for the password output.
     */

    public void setPasswordOutput() {
        passwordOutput = findViewById(R.id.PasswordGeneratorGeneratedPasswordOutput);
    }

    /**
     * this getPasswordGeneratorResetButton() method gets the reset button.
     * @return the reset button.
     */

    public Button getPasswordGeneratorResetButton() {
        return passwordGeneratorResetButton;
    }

    /**
     * this setPasswordGeneratorResetButton() method sets the reset button.
     */

    public void setPasswordGeneratorResetButton() {
        passwordGeneratorResetButton = findViewById(R.id.PasswordGeneratorResetButton);
    }

    /**
     * this setPasswordGeneratorGeneratePasswordButton() method sets the generate password button.
     */

    public void setPasswordGeneratorGeneratePasswordButton() {
        passwordGeneratorGeneratePasswordButton = findViewById(R.id.PasswordGeneratorGeneratePasswordsButton);
    }

    /**
     * this getPasswordGeneratorGeneratePasswordButton() method gets the generate password button.
     * @return the generate password button.
     */
    public Button getPasswordGeneratorGeneratePasswordButton() {
        return passwordGeneratorGeneratePasswordButton;
    }

    /**
     * this getGeneratedPassword() method gets the generated password.
     * @return the generated password.
     */

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    /**
     * this setGeneratedPassword() method sets the generated password.
     * @param string the generated password being set
     */

    public void setGeneratedPassword(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') { // if the text is empty,
                generatedPassword = string; // then the generated password is cleared.
            }
            else {
                generatedPassword += string; // otherwise, the generated password gets added onto the end.
            }
        }
    }

    /**
     * this getNumber() method gets the number.
     * @return the number.
     */

    public int getNumber() {
        return number;
    }

    /**
     * this setNumber() method sets the number.
     * @param number the number being set.
     */

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * this setUppercaseLetters() method sets the uppercase letters.
     * @param string the uppercase letters being set.
     */

    public void setUppercaseLetters(String string) {
        uppercaseLetters = string;
    }

    /**
     * this getUppercaseLetters() method gets the uppercase letters.
     * @return the uppercase letters.
     */

    public String getUppercaseLetters() {
        return uppercaseLetters;
    }

    /**
     * this setLowercaseLetters() method sets the lowercase letters.
     * @param string the lowercase letters being set.
     */

    public void setLowercaseLetters(String string) {
        lowercaseLetters = string;
    }

    /**
     * this getLowercaseLetters() method gets the lowercase letters.
     * @return the lowercase letters.
     */

    public String getLowercaseLetters() {
        return lowercaseLetters;
    }

    /**
     * this setNumbers() method sets the numbers.
     * @param string the numbers being set.
     */

    public void setNumbers(String string) {
        numbers = string;
    }

    /**
     * this getNumbers() method gets the numbers.
     * @return the numbers.
     */

    public String getNumbers() {
        return numbers;
    }

    /**
     * this setSymbols() method sets the symbols.
     * @param string the symbols being set.
     */

    public void setSymbols(String string) {
        symbols = string;
    }

    /**
     * this getSymbols() method gets the symbols.
     * @return the symbols.
     */

    public String getSymbols() {
        return symbols;
    }

    /*
    * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, has the code for the Password Generator function that the Unifier app needs to function.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_generator);
        activate();
        getPasswordGeneratorResetButton().setOnClickListener(v -> resetValues());
        getPasswordGeneratorGeneratePasswordButton().setOnClickListener(v -> generatePasswords());
    }

    /**
     * this private resetValues() method resets all the values of the variables/objects that are/were being used back to their default, if any, values.
     */

    private void resetValues() {
        getUserInput().getText().clear();
        getPasswordOutput().setText("");
        setGeneratedPassword("");
        setLowercaseLetters("");
        setUppercaseLetters("");
        setNumbers("");
        setSymbols("");
        setNumber(0);
        reActivate();
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        setUserInput();
        setPasswordOutput();
        setPasswordGeneratorResetButton();
        setPasswordGeneratorGeneratePasswordButton();
        setNumber(0);
        setGeneratedPassword("");
        setLowercaseLetters("abcdefghijklmnopqrstuvwxyz");
        setUppercaseLetters("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        setNumbers("0123456789");
        setSymbols("!@#$%^&*()_-+={[}]:;?/>.<,/*-+'");
    }

    /**
     * this private void reActivate() method reinitializes the string variables for the upper and lowercase letters, numbers, and symbols 
     * so that nothing hopefully goes wrong when the user tries to use this function again.
     */

    private void reActivate() {
        setLowercaseLetters("abcdefghijklmnopqrstuvwxyz");
        setUppercaseLetters("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        setNumbers("0123456789");
        setSymbols("!@#$%^&*()_-+={[}]:;?/>.<,/*-+'");
    }


    /**
     * this private void generatePasswords() method runs the code for generating passwords based on a set length that the user entered in number using userInput.
     */

    @SuppressLint("DefaultLocale") // suppresses some errors with the text because there was nothing wrong with the text.
    
    private void generatePasswords() {
        try {
            setGeneratedPassword(getUserInput().getText().toString());
            setNumber(Integer.parseInt(getGeneratedPassword()));
            setGeneratedPassword(""); // generatedPassword gets set to an empty string in order to avoid any errors or undesired lengths in the generated password.
            for (int i = 0; i < getNumber(); i++) {
                int random = 1 + (int) (5 * Math.random());
                switch (random) {
                    case 1:
                        setGeneratedPassword(String.valueOf((int)(0 * Math.random())));
                        break;
                    case 2:
                        random = (int) (getLowercaseLetters().length() * Math.random());
                        setGeneratedPassword(String.valueOf(getLowercaseLetters().charAt(random)));
                        break;
                    case 3:
                        random = (int) (getUppercaseLetters().length() * Math.random());
                        setGeneratedPassword(String.valueOf(getUppercaseLetters().charAt(random)));
                        break;
                    case 4:
                        random = (int) (getNumbers().length() * Math.random());
                        setGeneratedPassword(String.valueOf(getNumbers().charAt(random)));
                        break;
                    case 5:
                        random = (int) (getSymbols().length() * Math.random());
                        setGeneratedPassword(String.valueOf(getSymbols().charAt(random)));
                        break;
                }
            }
            getPasswordOutput().setText(String.format("Generated Password of Length %d is: \n\n %s", getNumber(), getGeneratedPassword()));
        }
        catch (NumberFormatException n)  {
            Toast toast = Toast.makeText(this, "Error. Please enter a number", Toast.LENGTH_SHORT); 
            toast.setGravity(Gravity.BOTTOM, 0, 120); 
            toast.show();
        }
    }

    /**
     * this public void passwordGeneratorChangetoMainMenuScreen() method changes the screen to main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void passwordGeneratorChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

}