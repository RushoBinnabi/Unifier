/**
 * Name: Rusho Binnabi
 * Date: 1/2/2023
 * Project: Unifier App - Password Generator Function
 * Code File Updated: 1/2/2023 at 8:37 AM
 * Contact Information: RushoBinnabi123@yahoo.com 
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

    EditText userInput; // an EditText object called userInput gets created.
    TextView passwordOutput; // a TextView object called passwordOutput gets created.
    Button passwordGeneratorResetButton; // a Button object called passwordGeneratorResetButton gets created.
    Button passwordGeneratorGeneratePasswordButton; // a Button object called passwordGeneratorGeneratePasswordButton gets created.
    String generatedPassword; // a String object/variable called generatedPassword gets created which will store the generated password as a string based on a set length that the user enters using userInput.
    int number; // an integer variable called number gets created which will store the integer number that will determine the length of the generated password inside generatedPassword.
    String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz"; // a String variable/object called lowercaseLetters gets created which has all the lowercase letters that will be used to generate a password.
    String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // a String variable/object called uppercaseLetters gets created which has all the uppercase letters that will be used to generate a password.
    String numbers = "0123456789"; // a String variable/object called numbers gets created which has all the numbers that will be used to generate a password.
    String symbols = "!@#$%^&*()_-+={[}]:;?/>.<,/*-+'"; // a String variable/object called symbols gets created which has all the symbols that will be used to generate a password.

    /*
    * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, has the code for the Password Generator function that the Unifier app needs to function.
    * this method is void because it doesn't return anything.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // using the super.onCreate() method, it uses the savedInstanceState object as its argument which means that next time, the program starts off from where it left off from last time.
        setContentView(R.layout.activity_password_generator); // the setContentView() method uses R.layout.activity_password_generator which is the layout file for the Password Generator function of the Unifier app.
        userInput = findViewById(R.id.PasswordGeneratorLengthInput); // userInput gets set to the id called PasswordGeneratorLengthInput of the EditText object that takes input from the user.
        passwordOutput = findViewById(R.id.PasswordGeneratorGeneratedPasswordOutput); // passwordOutput gets set to the id called PasswordGeneratorGeneratedPasswordOutput of the TextView object that displays the generated password.
        passwordGeneratorResetButton = findViewById(R.id.PasswordGeneratorResetButton); // resetButton gets set to the id called PasswordGeneratorResetButton of the Button object that when clicked, resets all the values of the objects/variables that are/were being used back to their default, if any, values.
        passwordGeneratorGeneratePasswordButton = findViewById(R.id.PasswordGeneratorGeneratePasswordsButton); // passwordGeneratorGeneratePasswordButton gets set to the id called PasswordGeneratorGeneratePasswordsButton of the Button object that when clicked, generates and displays the generated password.
        passwordGeneratorResetButton.setOnClickListener(v -> resetValues()); // when passwordGeneratorResetButton is clicked, using the setonClickListener() method, it runs the resetValues() method via the v lambda expression.
        passwordGeneratorGeneratePasswordButton.setOnClickListener(v -> generatePasswords()); // when passwordGeneratorGeneratePasswordButton is clicked, using the setonClickListener() method, it runs the generatePasswords() method via the v lambda expression.
    } // the end of the onCreate() method.

    /**
     * this private resetValues() method resets all the values of the variables/objects that are/were being used back to their default, if any, values.
     * this method is void because it doesn't return anything.
     */

    private void resetValues() {
        userInput.getText().clear(); // clears the text from userInput.
        passwordOutput.setText(""); // clears the text from passwordOutput.
        generatedPassword = ""; // the value of generatedPassword gets set to an empty string.
        number = 0; // resets number to 0.
    } // the end of the resetValues() method.


    /**
     * this private void generatePasswords() method runs the code for generating passwords based on a set length that the user entered in number using userInput.
     * this method is void because it doesn't return anything.
     */

    @SuppressLint("DefaultLocale") // suppresses some errors with the text because there was nothing wrong with the text.
    
    private void generatePasswords() {
        try { // the try block will try to run the code.
            generatedPassword = userInput.getText().toString(); // generatedPassword will get the length of the generated password from userInput as a string.
            number = Integer.parseInt(generatedPassword); // number will store the length of the generated password from generatedPassword as an integer.
            generatedPassword = ""; // generatedPassword gets set to an empty string in order to avoid any errors or undesired lengths in the generated password.
            for (int i = 0; i < number; i++) { // the code inside the for loop as along as the value of the integer variable i is less than the value of number from 0, and every time that is true, the value of i gets increased by 1 each time the loop runs.
                int random = 1 + (int) (5 * Math.random()); // an integer variable called random gets created which stores 5 random numbers from 1 to 5, since it's counting from 1 to 5 by having the additional 1 in it instead of from 0 to 4 if it didn't have that additional 1 in it, using Math.random().
                switch (random) { // the switch statement checks what the randomly generated number inside number is and runs code from inside the statement based on which number from 1 to 5 that it randomly generates.
                    case 1: // if the randomly generated number in number was 1, then the code inside case 1 gets run.
                        generatedPassword += String.valueOf((int)(0 * Math.random())); // generatedPassword will have the string value that's at the value of the integer number of 0 times the current randomly generated number from Math.random.
                        break; // breaks out of the current case statement.
                    case 2: // if the randomly generated number in number was 2, then the code inside case 2 gets run.
                        random = (int) (lowercaseLetters.length() * Math.random()); // random will have the value of the length of lowercaseLetters times the current randomly generated number from Math.random as an integer.
                        generatedPassword += String.valueOf(lowercaseLetters.charAt(random)); // generatedPassword will have the string value that's at the value of the character of lowercaseLetters using random as it's argument.
                        break; // breaks out of the current case statement.
                    case 3: // if the randomly generated number in number was 3, then the code inside case 3 gets run.
                        random = (int) (uppercaseLetters.length() * Math.random()); // random will have the value of the length of uppercaseLetters times the current randomly generated number from Math.random as an integer.
                        generatedPassword += String.valueOf(uppercaseLetters.charAt(random)); // generatedPassword will have the string value that's at the value of the character of uppercaseLetters using random as it's argument.
                        break; // breaks out of the current case statement.
                    case 4: // if the randomly generated number in number was 4, then the code inside case 4 gets run.
                        random = (int) (numbers.length() * Math.random()); // random will have the value of the length of numbers times the current randomly generated number from Math.random as an integer.
                        generatedPassword += String.valueOf(numbers.charAt(random)); // generatedPassword will have the string value that's at the value of the character of numbers using random as it's argument.
                        break; // breaks out of the current case statement.
                    case 5: // if the randomly generated number in number was 5, then the code inside case 5 gets run.
                        random = (int) (symbols.length() * Math.random()); // random will have the value of the length of symbols times the current randomly generated number from Math.random as an integer.
                        generatedPassword += String.valueOf(symbols.charAt(random)); // generatedPassword will have the string value that's at the value of the character of symbols using random as it's argument.
                        break; // breaks out of the current case statement.
                } // the end of the switch statement.
            } // the end of the for loop.
            passwordOutput.setText(String.format("Generated Password of Length %d is: \n\n %s", number, generatedPassword)); // shows the generated password inside generatedPassword that was based on a set length that the user entered from inside number.
        } // the end of the try block.
        catch (NumberFormatException n) { // the code inside the catch statement runs if the user enters anything else other than a number.
            Toast toast = Toast.makeText(this, "Error. Please enter a number", Toast.LENGTH_SHORT); // tells the user to enter a number.
            toast.setGravity(Gravity.BOTTOM, 0, 120); // sets the position of the message pop-up at the bottom.
            toast.show(); // shows the message pop-up.
        } // the end of the catch statement.
    } // the end of the generatePasswords() method.

    /**
     * this public void passwordGeneratorChangetoMainMenuScreen() method changes the screen to main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void passwordGeneratorChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class); // creates a new Intent object called intent that changes the screen of the app to the main menu.
        startActivity(intent); // calls the startActivity() method using intent as its argument.
    } // the end of the passwordGeneratorChangetoMainMenuScreen() method.

} // the end of the PasswordGenerator class.