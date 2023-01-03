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
 * this UsernameGenerator class, which inherits from the AppCompatActivity class, contains everything that the Username Generator function of the app needs to run.
 */

public class UsernameGenerator extends AppCompatActivity {
 
    EditText userInput; // an EditText object called userInput gets created.
    TextView usernameOutput; // a TextView object called usernameOutput gets created.
    Button usernameGeneratorResetButton; // a Button object called usernameGeneratorResetButton gets created.
    Button usernameGeneratorGenerateUsernameButton; // a Button object called usernameGeneratorGenerateUsernameButton gets created.
    String generatedUsername; // a String object/variable called generatedUsername gets created which will store the generated username as a string based on a set length that the user enters using userInput.
    int number; // an integer variable called number gets created which will store the integer number that will determine the length of the generated password inside generatedUsername.
    String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz"; // a String variable/object called lowercaseLetters gets created which has all the lowercase letters that will be used to generate a username.
    String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // a String variable/object called uppercaseLetters gets created which has all the uppercase letters that will be used to generate a username.
    String numbers = "0123456789"; // a String variable/object called numbers gets created which has all the numbers that will be used to generate a username.
    String symbols = "!@#$%^&*()_-+={[}]:;?/>.<,/*-+'"; // a String variable/object called symbols gets created which has all the symbols that will be used to generate a username.

    /*
    * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, has the code for the Username Generator function that the Unifier app needs to function.
    * this method is void because it doesn't return anything.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // using the super.onCreate() method, it uses the savedInstanceState object as its argument which means that next time, the program starts off from where it left off from last time.
        setContentView(R.layout.activity_username_generator); // the setContentView() method uses R.layout.activity_username_generator which is the layout file for the Username Generator function of the Unifier app.
        userInput = findViewById(R.id.UsernameGeneratorLengthInput); // userInput gets set to the id called UsernameGeneratorLengthInput of the EditText object that takes input from the user.
        usernameOutput = findViewById(R.id.UsernameGeneratorGeneratedUsernameOutput); // usernameOutput gets set to the id called UsernameGeneratorGeneratedPasswordOutput of the TextView object that displays the generated username.
        usernameGeneratorResetButton = findViewById(R.id.UsernameGeneratorResetButton); // resetButton gets set to the id called UsernameGeneratorResetButton of the Button object that when clicked, resets all the values of the objects/variables that are/were being used back to their default, if any, values.
        usernameGeneratorGenerateUsernameButton = findViewById(R.id.UsernameGeneratorGenerateUsernamesButton); // usernameGeneratorGenerateUsernameButton gets set to the id called UsernameGeneratorGenerateUsernamesButton of the Button object that when clicked, generates and displays the generated username.
        usernameGeneratorResetButton.setOnClickListener(v -> resetValues()); // when usernameGeneratorResetButton is clicked, using the setonClickListener() method, it runs the resetValues() method via the v lambda expression.
        usernameGeneratorGenerateUsernameButton.setOnClickListener(v -> generatePasswords()); // when usernameGeneratorGenerateUsernameButton is clicked, using the setonClickListener() method, it runs the generateUsernames() method via the v lambda expression.
    } // the end of the onCreate() method.

    /**
     * this private resetValues() method resets all the values of the variables/objects that are/were being used back to their default, if any, values.
     * this method is void because it doesn't return anything.
     */

    private void resetValues() {
        userInput.getText().clear(); // clears the text from userInput.
        usernameOutput.setText(""); // clears the text from usernameOutput.
        generatedUsername = ""; // the value of generatedUsername gets set to an empty string.
        number = 0; // resets number to 0.
    } // the end of the resetValues() method.

    /**
     * this private void generateUsernames() method runs the code for generating usernames based on a set length that the user entered in number using userInput.
     * this method is void because it doesn't return anything.
     */

    @SuppressLint("DefaultLocale") // suppresses some errors with the text because there was nothing wrong with the text.
    
    private void generatePasswords() {
        try { // the try block will try to run the code.
            generatedUsername = userInput.getText().toString(); // generatedUsername will get the length of the generated username from userInput as a string.
            number = Integer.parseInt(generatedUsername); // number will store the length of the generated password from generatedPassword as an integer.
            generatedUsername = ""; // generatedUsername gets set to an empty string in order to avoid any errors or undesired lengths in the generated username.
            for (int i = 0; i < number; i++) { // the code inside the for loop as along as the value of the integer variable i is less than the value of number from 0, and every time that is true, the value of i gets increased by 1 each time the loop runs.
                int random = 1 + (int) (5 * Math.random()); // an integer variable called random gets created which stores 5 random numbers from 1 to 5, since it's counting from 1 to 5 by having the additional 1 in it instead of from 0 to 4 if it didn't have that additional 1 in it, using Math.random().
                switch (random) { // the switch statement checks what the randomly generated number inside number is and runs code from inside the statement based on which number from 1 to 5 that it randomly generates.
                    case 1: // if the randomly generated number in number was 1, then the code inside case 1 gets run.
                        generatedUsername += String.valueOf((int)(0 * Math.random())); // generatedUsername will have the string value that's at the value of the integer number of 0 times the current randomly generated number from Math.random.
                        break; // breaks out of the current case statement.
                    case 2: // if the randomly generated number in number was 2, then the code inside case 2 gets run.
                        random = (int) (lowercaseLetters.length() * Math.random()); // random will have the value of the length of lowercaseLetters times the current randomly generated number from Math.random as an integer.
                        generatedUsername += String.valueOf(lowercaseLetters.charAt(random)); // generatedUsername will have the string value that's at the value of the character of lowercaseLetters using random as it's argument.
                        break; // breaks out of the current case statement.
                    case 3: // if the randomly generated number in number was 3, then the code inside case 3 gets run.
                        random = (int) (uppercaseLetters.length() * Math.random()); // random will have the value of the length of uppercaseLetters times the current randomly generated number from Math.random as an integer.
                        generatedUsername += String.valueOf(uppercaseLetters.charAt(random)); // generatedUsername will have the string value that's at the value of the character of uppercaseLetters using random as it's argument.
                        break; // breaks out of the current case statement.
                    case 4: // if the randomly generated number in number was 4, then the code inside case 4 gets run.
                        random = (int) (numbers.length() * Math.random()); // random will have the value of the length of numbers times the current randomly generated number from Math.random as an integer.
                        generatedUsername += String.valueOf(numbers.charAt(random)); // generatedUsername will have the string value that's at the value of the character of numbers using random as it's argument.
                        break; // breaks out of the current case statement.
                    case 5: // if the randomly generated number in number was 5, then the code inside case 5 gets run.
                        random = (int) (symbols.length() * Math.random()); // random will have the value of the length of symbols times the current randomly generated number from Math.random as an integer.
                        generatedUsername += String.valueOf(symbols.charAt(random)); // generatedUsername will have the string value that's at the value of the character of symbols using random as it's argument.
                        break; // breaks out of the current case statement.
                } // the end of the switch statement.
            } // the end of the for loop.
            usernameOutput.setText(String.format("Generated Username of Length %d is: \n\n %s", number, generatedUsername)); // shows the generated username inside generatedUsername that was based on a set length that the user entered from inside number.
        } // the end of the try block.
        catch (NumberFormatException n) { // the code inside the catch statement runs if the user enters anything else other than a number.
            Toast toast = Toast.makeText(this, "Error. Please enter a number", Toast.LENGTH_SHORT); // tells the user to enter a number.
            toast.setGravity(Gravity.BOTTOM, 0, 120); // sets the position of the message pop-up at the bottom.
            toast.show(); // shows the message pop-up.
        } // the end of the catch statement.
    } // the end of the generatePasswords() method.

    /**
     * this public void usernameGeneratorChangetoMainMenuScreen() method changes the screen to main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void usernameGeneratorChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class); // creates a new Intent object called intent that changes the screen of the app to the main menu.
        startActivity(intent); // calls the startActivity() method using intent as its argument.
    } // the end of the passwordGeneratorChangetoMainMenuScreen() method.

} // the end of the PasswordGenerator class.