/**
 * Name: Rusho Binnabi
 * Date: August 16th, 2021
 * Project Name: Unifier - Measurement Converter - Temperature Function
 * Contact Information: RushoBinnabi123@yahoo.com
 * Code File Updated: 8/1//2023 at 5:56 PM
 */

package rusho.app.unifer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

/**
 * this class has everything that the temperature converter part of my app needs to run.
 */

public class MeasurementConverterTemperature extends AppCompatActivity {

     // this class converts a given temperature given by the user to either fahrenheit or celsius.

    Button convertTemperatureButton;
    Button clearTemperatureInputButton;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress link is here because there was nothing wrong with the material of the Switch object.
    Switch temperatureConversionSwitch;
    EditText temperatureInput;
    String userTemperatureInput; 
    double userTemperature;
    double fahrenheit; 
    double celsius;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, has the code for the Temperature Converter function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter_temperature);
        activate();
        convertTemperatureButton.setOnClickListener(v -> convertTemperature());
        clearTemperatureInputButton.setOnClickListener(v -> clearTemperatureInput());
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        convertTemperatureButton = findViewById(R.id.ConvertTemperatureButton); 
        temperatureConversionSwitch = findViewById(R.id.TemperatureConversionSwitch);
        temperatureInput = findViewById(R.id.TemperatureInput);
        clearTemperatureInputButton = findViewById(R.id.ClearTemperatureInputButton); 
        userTemperatureInput = "";
        userTemperature = 0;
        fahrenheit = 0;
        celsius = 0;
    }

    /**
     * this private void convertTemperature() method will be used to do the temperature conversion everytime the convertTemperatureButton is pressed.
     */

    private void convertTemperature() {
        if (temperatureConversionSwitch.isChecked()) {
            try {
                userTemperatureInput = temperatureInput.getText().toString();
                userTemperature = Double.parseDouble(userTemperatureInput);
                celsius = (userTemperature - 32) / 1.8;
                @SuppressLint("DefaultLocale") // this suppress link is here because there was nothing wrong with the formatting of the string text.
                Toast toast = Toast.makeText(this, String.format("The Temperature Conversion is %,.2f °C", celsius), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            catch (NumberFormatException n) { 
                Toast toast = Toast.makeText(this, "Error. Please enter a valid number.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
        }
        else if (!temperatureConversionSwitch.isChecked()) {
            try {
                userTemperatureInput = temperatureInput.getText().toString();
                userTemperature = Double.parseDouble(userTemperatureInput);
                fahrenheit = (userTemperature * 1.8) + 32;
                @SuppressLint("DefaultLocale") // this suppress link is here because there was nothing wrong with the formatting of the string text.
                Toast toast = Toast.makeText(this, String.format("The Temperature Conversion is %,.2f °F", fahrenheit), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            catch (NumberFormatException n) {
                Toast toast = Toast.makeText(this, "Error. Please enter a valid number.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
        }
    }

    /**
     * the clearTemperatureInput() method is used to clear the data from temperatureInput, userTemperatureInput, userTemperature, fahrenheit, celsius.
     */

    private void clearTemperatureInput() {
        temperatureConversionSwitch.setChecked(false);
        temperatureInput.getText().clear(); 
        userTemperatureInput = "";
        userTemperature = 0;
        fahrenheit = 0; 
        celsius = 0;
    }

    /**
     * this temperatureConverterChangetoMainMenuScreen() method changes the screen to the screen layout based on the xml file called "activity_main.xml" file that has all the functionalities of the app.
     * @param view the argument called view is used so that mainMenuButton3 can use this method to change the screen when mainMenuButton3 is pressed.
     */

    public void temperatureConverterChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }
}