/**
 * Name: Rusho Binnabi
 * Date: August 16th, 2021
 * Project Name: Unifier App - Main Menu Function
 * Contact Information: RushoBinnabi123@yahoo.com
 * Code File Updated: December 29th, 2022 at 8:47 AM.
 */

package rusho.app.unifer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    /**
     * this class has everything that the main menu part of my app needs to run.
     * this class also inherits from the AppCompatActivity class.
     */

    Button functionSelectButton; // a Button object called functionSelectButton gets created.
    RadioGroup functionRadioButtonGroup; // a RadioGroup object called functionRadioButtonGroup gets created.
    RadioButton temperatureConverterFunctionRadioButton; // a RadioButton object called temperatureConverterFunctionRadioButton gets created.
    RadioButton pricerFunctionRadioButton; // a RadioButton object called pricerFunctionRadioButton gets created.
    RadioButton playDiceFunctionRadioButton; // a RadioButton object called playDiceFunctionRadioButton gets created.
    RadioButton combinationsandPermutationsButton; // RadioButton object called combinationsandPermutationsRadioButton gets created.
    RadioButton passwordGeneratorButton; // RadioButton object called passwordGeneratorButton gets created.
    RadioButton usernameGeneratorButton; // RadioButton object called usernameGeneratorButton gets created.


    /**
     * this onCreate() method has all the functionalities for the main menu function of my app to run.
     * this method also overrides the method from the AppCompatActivity class.
     * @param savedInstanceState the argument is that so the app can start from where it last left off using the savedInstanceState object from the Bundle class.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // using the super keyword, it calls the onCreate method from the AppCompatActivity class using the savedInstanceState object as the argument for the method.
        setContentView(R.layout.activity_main); // sets the view of the app to the xml layout file called "activity_play_dice.xml."
        functionSelectButton = findViewById(R.id.FunctionSelectButton); // functionSelectButton gets set to the id called FunctionSelectButton of the Button object that changes the screen based on which radio button for which function of the app was selected.
        functionRadioButtonGroup = findViewById(R.id.FunctionButtonsRadioGroup); // functionRadioButtonGroup gets set to the id called FunctionButtonsRadioGroup of the RadioGroup object that allows for the radio button objects to be selected individually.
        temperatureConverterFunctionRadioButton = findViewById(R.id.TemperatureConverterFunctionRadioButton); // temperatureConverterFunctionRadioButton gets set to the id called TemperatureConverterFunctionRadioButton of the RadioButton object that changes the screen to the Temperature Converter function of the app.
        pricerFunctionRadioButton = findViewById(R.id.PricerFunctionRadioButton); // pricerFunctionRadioButton gets set to the id called PricerFunctionRadioButton of the RadioButton object that changes the screen to the Pricer function of the app.
        playDiceFunctionRadioButton = findViewById(R.id.PlayDiceFunctionRadioButton); // playDiceFunctionRadioButton gets set to the id called PlayDiceFunctionRadioButton of the RadioButton object that changes the screen to the PlayDice function of the app.
        combinationsandPermutationsButton = findViewById(R.id.CombinationsandPermutationsFunctionRadioButton); // combinationsandPermutationsButton gets set to the id called CombinationsandPermutationsFunctionRadioButton object that changes the screen to the Combinations and Permutations function of the app.
        passwordGeneratorButton = findViewById(R.id.PasswordGeneratorFunctionRadioButton); // passwordGeneratorButton gets set to the id called PasswordGeneratorFunctionRadioButton object that changes the screen to the Password Generator function of the app.
        usernameGeneratorButton = findViewById(R.id.UsernameGeneratorFunctionRadioButton); // usernameGeneratorButton gets set to the id called UsernameGeneratorFunctionRadioButton object that changes the screen to the Username Generator function of the app.
        functionSelectButton.setOnClickListener(view -> { // using the setOnClickListener() method of functionSelectButton, via the view lambda expression, it runs the code inside the method.
            if (playDiceFunctionRadioButton.isChecked()) { // if the radio button for the PlayDice function of the app was selected, it runs the code inside the statement.
                Intent intent = new Intent(view.getContext(), PlayDice.class); // creates a new Intent object called intent which gets the context using the getContext() method of the View object called view and the "PlayDice.class" which is the file that the screen will be changed into.
            startActivity(intent); // using the startActivity() method, it changes the screen to the "PlayDice.class" file using intent as it's argument for the startActivity() method.
            }
            else if (pricerFunctionRadioButton.isChecked()) { // if the radio button for the Pricer function of the app was selected, it runs the code inside the statement.
                Intent intent = new Intent(view.getContext(), Pricer.class); // creates a new Intent object called intent which gets the context using the getContext() method of the View object called view and the "Pricer.class" which is the file that the screen will be changed into.
                startActivity(intent); // using the startActivity() method, it changes the screen to the "Pricer.class" file using intent as it's argument for the startActivity() method.
            }
            else if (temperatureConverterFunctionRadioButton.isChecked()) { // if the radio button for the Temperature Converter function of the app was selected, it runs the code inside the statement.
                Intent intent = new Intent(view.getContext(), TemperatureConverter.class); // creates a new Intent object called intent which gets the context using the getContext() method of the View object called view and the "TemperatureConverter.class" which is the file that the screen will be changed into.
                startActivity(intent); // using the startActivity() method, it changes the screen to the "TemperatureConverter.class" file using intent as it's argument for the startActivity() method.
            }
            else if (combinationsandPermutationsButton.isChecked()) { // if the radio button for the Combinations and Permutations function of the app was selected, it runs the code inside the statement.
                Intent intent = new Intent(view.getContext(),CombinationsandPermutations.class); // creates a new Intent object called intent which gets the context using the getContext() method of the view object called view and the "CombinationsandPermutations.class" which is the file that the screen will be changed into.
                startActivity(intent); // using the startActivity() method, it changes the screen to the "CombinationsandPermutations.class" file using intent as it's argument for the startActivity() method.
            }
            else if (passwordGeneratorButton.isChecked()) { // if the radio button for the Password Generator function of the app was selected, it runs the code inside the statement.
                Intent intent = new Intent(view.getContext(), PasswordGenerator.class); // creates a new Intent object called intent which gets the context using the getContext() method of the view object called view and the "PasswordGenerator.class" which is the file that the screen will be changed into.
                startActivity(intent); // using the startActivity() method, it changes the screen to the "PasswordGenerator.class" file using intent as it's argument for the startActivity() method.
            }
            else if (usernameGeneratorButton.isChecked()) { // if the radio button for the Username Generator function of the app was selected, it runs the code inside the statement.
                Intent intent = new Intent(view.getContext(), UsernameGenerator.class); // creates a new Intent object called intent which gets the context using the getContext() method of the view object called view and the "UsernameGenerator.class" which is the file that the screen will be changed into.
                startActivity(intent); // using the startActivity() method, it changes the screen to the "UsernameGenerator.class" file using intent as it's argument for the startActivity() method.
            }
        });
    }
}