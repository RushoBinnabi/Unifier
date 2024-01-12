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

    // this class generates a random username based on a given length by the user.
 
    EditText userInput;
    TextView usernameOutput;
    Button usernameGeneratorResetButton;
    Button usernameGeneratorGenerateUsernameButton;
    String generatedUsername;
    int number;
    String lowercaseLetters;
    String uppercaseLetters;
    String numbers;
    String symbols; 

    /*
    * this protected void onCreate() method, which uses the Bundle savedInstanceObject as its argument, has the code for the Username Generator function that the Unifier app needs to function.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_username_generator); 
        activate();
        usernameGeneratorResetButton.setOnClickListener(v -> resetValues());
        usernameGeneratorGenerateUsernameButton.setOnClickListener(v -> generatePasswords());
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        numbers = "0123456789";
        symbols = "!@#$%^&*()_-+={[}]:;?/>.<,/*-+'"; 
        userInput = findViewById(R.id.UsernameGeneratorLengthInput);
        usernameOutput = findViewById(R.id.UsernameGeneratorGeneratedUsernameOutput);
        usernameGeneratorResetButton = findViewById(R.id.UsernameGeneratorResetButton);
        usernameGeneratorGenerateUsernameButton = findViewById(R.id.UsernameGeneratorGenerateUsernamesButton); 
    }

    /**
     * this private void resetValues() method resets all the values of the variables/objects that are/were being used back to their default, if any, values.
     */

    private void resetValues() {
        userInput.getText().clear();
        usernameOutput.setText(""); 
        generatedUsername = "";
        lowercaseLetters = "";
        uppercaseLetters = "";
        numbers = "";
        symbols = ""; 
        number = 0;
        reActivate();
    }

    /**
     * this private void reActivate() method reinitializes the string variables for the upper and lowercase letters, numbers, and symbols 
     * so that nothing hopefully goes wrong when the user tries to use this function again.
     */

    private void reActivate() {
        lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        numbers = "0123456789";
        symbols = "!@#$%^&*()_-+={[}]:;?/>.<,/*-+'"; 
    }

    /**
     * this private void generateUsernames() method runs the code for generating usernames based on a set length that the user entered in number using userInput.
     */

    @SuppressLint("DefaultLocale") // suppresses some errors with the text because there was nothing wrong with the text.
    
    private void generatePasswords() {
        try {
            generatedUsername = userInput.getText().toString();
            number = Integer.parseInt(generatedUsername);
            generatedUsername = ""; // generatedUsername gets set to an empty string in order to avoid any errors or undesired lengths in the generated username.
            for (int i = 0; i < number; i++) {
                int random = 1 + (int) (5 * Math.random());
                switch (random) {
                    case 1:
                        generatedUsername += String.valueOf((int)(0 * Math.random()));
                        break;
                    case 2:
                        random = (int) (lowercaseLetters.length() * Math.random());
                        generatedUsername += String.valueOf(lowercaseLetters.charAt(random));
                        break;
                    case 3:
                        random = (int) (uppercaseLetters.length() * Math.random());
                        generatedUsername += String.valueOf(uppercaseLetters.charAt(random));
                        break;
                    case 4:
                        random = (int) (numbers.length() * Math.random());
                        generatedUsername += String.valueOf(numbers.charAt(random));
                        break;
                    case 5:
                        random = (int) (symbols.length() * Math.random());
                        generatedUsername += String.valueOf(symbols.charAt(random));
                        break;
                }
            }
            usernameOutput.setText(String.format("Generated Username of Length %d is: \n\n %s", number, generatedUsername));
        }
        catch (NumberFormatException n) {
            Toast toast = Toast.makeText(this, "Error. Please enter a number", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 120);
            toast.show();
        }
    }

    /**
     * this public void usernameGeneratorChangetoMainMenuScreen() method changes the screen to main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void usernameGeneratorChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class); 
        startActivity(intent); 
    } 

}