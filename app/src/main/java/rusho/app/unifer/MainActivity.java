/**
 * Name: Rusho Binnabi
 * Date: August 16th, 2021
 * Project Name: Unifier App - Main Menu Function
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

    private Button functionSelectButton;
    private RadioGroup functionRadioButtonGroup;
    private RadioButton pricerFunctionRadioButton;
    private RadioButton playDiceFunctionRadioButton;
    private RadioButton combinationsandPermutationsButton;
    private RadioButton passwordGeneratorButton;
    private RadioButton usernameGeneratorButton;
    private RadioButton leetTextRadioButton;
    private RadioButton coinTossRadioButton;
    private RadioButton numberGeneratorRadioButton;
    private RadioButton measurementConverterRadioButton;

    /**
     * this getFunctionSelectButton() method gets the function select button.
     * @return the function select button.
     */
    public Button getFunctionSelectButton() {
        return functionSelectButton;
    }

    /**
     * this setFunctionSelectButton() method sets the function select button.
     */

    public void setFunctionSelectButton() {
        functionSelectButton = findViewById(R.id.FunctionSelectButton);
    }

    /**
     * this getFunctionRadioButtonGround() method gets the radio button group of functions.
     * @return the radio button group of functions.
     * currently unused.
     */

    public RadioGroup getFunctionRadioButtonGroup() {
        return functionRadioButtonGroup;
    }

    /**
     * this setFunctionRadioButtonGroup() method sets the radio button group of functions.
     */

    public void setFunctionRadioButtonGroup() {
        functionRadioButtonGroup = findViewById(R.id.FunctionButtonsRadioGroup);
    }

    /**
     * this getPricerFunctionRadioButton() method gets the radio button for the pricer function.
     * @return the radio button for the pricer function.
     */

    public RadioButton getPricerFunctionRadioButton() {
        return pricerFunctionRadioButton;
    }

    /**
     * this setPricerFunctionRadioButton() method sets the radio button for the pricer function.
     */

    public void setPricerFunctionRadioButton() {
        pricerFunctionRadioButton = findViewById(R.id.PricerFunctionRadioButton);
    }

    /**
     * this getPlayDiceFunctionRadioButton() method gets the radio button for the play dice function.
     * @return the radio button for the play dice function.
     */

    public RadioButton getPlayDiceFunctionRadioButton() {
        return playDiceFunctionRadioButton;
    }

    /**
     * this setPlayDiceFunctionRadioButton() method sets the radio button for the play dice function.
     */

    public void setPlayDiceFunctionRadioButton() {
        playDiceFunctionRadioButton = findViewById(R.id.PlayDiceFunctionRadioButton);
    }

    /**
     * this getCombinationsAndPermutationsButton() method gets the radio button for the combinations and permutations function.
     * @return the radio button for the combinations and permutations function.
     */

    public RadioButton getCombinationsAndPermutationsButton() {
        return combinationsandPermutationsButton;
    }

    /**
     * this setCombinationsandPermutationsButton() method sets the radio button for the combinations and permutations function.
     */

    public void setCombinationsandPermutationsButton() {
        combinationsandPermutationsButton = findViewById(R.id.CombinationsandPermutationsFunctionRadioButton);
    }

    /**
     * this getPasswordGeneratorButton() method gets the radio button for the password generator function.
     * @return the radio button for the password generator function.
     */

    public RadioButton getPasswordGeneratorButton() {
        return passwordGeneratorButton;
    }

    /**
     * this setPasswordGeneratorButton() method sets the radio button for the password generator function.
     */

    public void setPasswordGeneratorButton() {
        passwordGeneratorButton = findViewById(R.id.PasswordGeneratorFunctionRadioButton);
    }

    /**
     * this getUsernameGeneratorButton() method gets the radio button for the username generator function.
     * @return the radio button for the username function.
     */

    public RadioButton getUsernameGeneratorButton() {
        return usernameGeneratorButton;
    }

    /**
     * this setUsernameGeneratorButton() method sets the radio button for the username generator function.
     */

    public void setUsernameGeneratorButton() {
        usernameGeneratorButton = findViewById(R.id.UsernameGeneratorFunctionRadioButton);
    }

    /**
     * this setLeetTextRadioButton() method sets the radio button for the leet text function.
     */

    public void setLeetTextRadioButton() {
        leetTextRadioButton = findViewById(R.id.LeetTextFunctionRadioButton);
    }

    /**
     * this getLeetTextRadioButton() method gets the radio button for the leet text function.
     * @return the radio button for the leet text function.
     */

    public RadioButton getLeetTextRadioButton() {
        return leetTextRadioButton;
    }

    /**
     * this setCoinTossRadioButton() method sets the radio button for the coin toss function.
     */

    public void setCoinTossRadioButton() {
        coinTossRadioButton = findViewById(R.id.CoinTossFunctionRadioButton);
    }

    /**
     * this getCoinTossRadioButton() method gets the radio button for the coin toss function.
     * @return the radio button for the coin toss function.
     */

    public RadioButton getCoinTossRadioButton() {
        return coinTossRadioButton;
    }

    /**
     * this getNumberGeneratorRadioButton() method gets the radio button for the number generator function.
     * @return the radio button for the number generator function.
     */

    public RadioButton getNumberGeneratorRadioButton() {
        return numberGeneratorRadioButton;
    }

    /**
     * this setNumberGeneratorRadioButton() method sets the radio button for the number generator function.
     */

    public void setNumberGeneratorRadioButton() {
        numberGeneratorRadioButton = findViewById(R.id.NumberGeneratorFunctionRadioButton);
    }

    /**
     * this getMeasurementConverterRadioButton() method gets the radio button for the measurement converter function.
     * @return the radio button for the measurement converter function.
     */

    public RadioButton getMeasurementConverterRadioButton() {
        return measurementConverterRadioButton;
    }

    /**
     * this setMeasurementConverterRadioButton() method sets the radio button for the measurement converter function.
     */

    public void setMeasurementConverterRadioButton() {
        measurementConverterRadioButton = findViewById(R.id.MeasurementConverterFunctionRadioButton);
    }


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
        getFunctionSelectButton().setOnClickListener(view -> {
            if (getPlayDiceFunctionRadioButton().isChecked()) {
                Intent intent = new Intent(view.getContext(), PlayDice.class);
                startActivity(intent);
            }
            else if (getPricerFunctionRadioButton().isChecked()) {
                Intent intent = new Intent(view.getContext(), Pricer.class);
                startActivity(intent);
            }
            else if (getCombinationsAndPermutationsButton().isChecked()) {
                Intent intent = new Intent(view.getContext(), CombinationsandPermutations.class);
                startActivity(intent);
            }
            else if (getPasswordGeneratorButton().isChecked()) {
                Intent intent = new Intent(view.getContext(), PasswordGenerator.class);
                startActivity(intent);
            }
            else if (getUsernameGeneratorButton().isChecked()) {
                Intent intent = new Intent(view.getContext(), UsernameGenerator.class);
                startActivity(intent);
            }
            else if (getLeetTextRadioButton().isChecked()) {
                Intent intent = new Intent(view.getContext(), LeetText.class);
                startActivity(intent);
            }
            else if (getCoinTossRadioButton().isChecked()) {
                Intent intent = new Intent(view.getContext(), CoinToss.class);
                startActivity(intent);
            }
            else if (getNumberGeneratorRadioButton().isChecked()) {
                Intent intent = new Intent(view.getContext(), NumberGenerator.class);
                startActivity(intent);
            }
            else if (getMeasurementConverterRadioButton().isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
                startActivity(intent);
            }
        });
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        setFunctionSelectButton();
        setFunctionRadioButtonGroup();
        setPricerFunctionRadioButton();
        setPlayDiceFunctionRadioButton();
        setCombinationsandPermutationsButton();
        setPasswordGeneratorButton();
        setUsernameGeneratorButton();
        setLeetTextRadioButton();
        setCoinTossRadioButton();
        setNumberGeneratorRadioButton();
        setMeasurementConverterRadioButton();
    }
}