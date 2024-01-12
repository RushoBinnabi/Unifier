/**
 * Name: Rusho Binnabi
 * Date: August 16th, 2021
 * Project Name: Unifier App - Main Menu Function
 * Contact Information: RushoBinnabi123@yahoo.com
 * Code File Updated: 7/28/2023 at 9:17 PM
 */

package rusho.app.unifer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * this MainActivity class has everything that the main menu part of my app needs to run.
 * this class also inherits from the AppCompatActivity class.
 */

public class MainActivity extends AppCompatActivity {

    // this class has the functionalities of the functions of the app so when the user clicks on a button and confirms their choice, the menu will change to the menu of that function.

    Button functionSelectButton;
    RadioGroup functionRadioButtonGroup;
    RadioButton pricerFunctionRadioButton;
    RadioButton playDiceFunctionRadioButton;
    RadioButton combinationsandPermutationsButton;
    RadioButton passwordGeneratorButton;
    RadioButton usernameGeneratorButton;
    RadioButton leetTextRadioButton;
    RadioButton coinTossRadioButton;
    RadioButton numberGeneratorRadioButton;
    RadioButton measurementConverterRadioButton;

    /**
     * this onCreate() method has all the functionalities for the main menu function of my app to run.
     * this method also overrides the method from the AppCompatActivity class.
     * @param savedInstanceState the argument is that so the app can start from where it last left off using the savedInstanceState object from the Bundle class.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activate();
        functionSelectButton.setOnClickListener(view -> {
            if (playDiceFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), PlayDice.class);
                startActivity(intent);
            }
            else if (pricerFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), Pricer.class);
                startActivity(intent);
            }
            else if (combinationsandPermutationsButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), CombinationsandPermutations.class);
                startActivity(intent);
            }
            else if (passwordGeneratorButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), PasswordGenerator.class);
                startActivity(intent);
            }
            else if (usernameGeneratorButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), UsernameGenerator.class);
                startActivity(intent);
            }
            else if (leetTextRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), LeetText.class);
                startActivity(intent);
            }
            else if (coinTossRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), CoinToss.class);
                startActivity(intent);
            }
            else if (numberGeneratorRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), NumberGenerator.class);
                startActivity(intent);
            }
            else if (measurementConverterRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
                startActivity(intent);
            }
        });
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        functionSelectButton = findViewById(R.id.FunctionSelectButton);
        functionRadioButtonGroup = findViewById(R.id.FunctionButtonsRadioGroup);
        pricerFunctionRadioButton = findViewById(R.id.PricerFunctionRadioButton);
        playDiceFunctionRadioButton = findViewById(R.id.PlayDiceFunctionRadioButton);
        combinationsandPermutationsButton = findViewById(R.id.CombinationsandPermutationsFunctionRadioButton);
        passwordGeneratorButton = findViewById(R.id.PasswordGeneratorFunctionRadioButton);
        usernameGeneratorButton = findViewById(R.id.UsernameGeneratorFunctionRadioButton);
        leetTextRadioButton = findViewById(R.id.LeetTextFunctionRadioButton);
        coinTossRadioButton = findViewById(R.id.CoinTossFunctionRadioButton);
        numberGeneratorRadioButton = findViewById(R.id.NumberGeneratorFunctionRadioButton);
        measurementConverterRadioButton = findViewById(R.id.MeasurementConverterFunctionRadioButton);
    }
}