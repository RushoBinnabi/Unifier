/**
 * Name: Rusho Binnabi
 * Date: 8/1/2023
 * Project: Unifier - Measurement Converter Function
 * Code File Updated: 8/12/2023 at 5:27 PM
 * Contact Information: RushoBinnabi123@yahoo.com
 */

package rusho.app.unifer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MeasurementConverter extends AppCompatActivity {

    // this MeasurementConverter class has all the functions that will have sub functions that will be for measurement conversions.

    RadioGroup measurementConverterRadioGroup;
    Button measurementConveterFunctionSelectButton;
    RadioButton ouncesToPoundsFunctionRadioButton;
    RadioButton tonsToMilligramsFunctionRadioButton;
    RadioButton gramsToKilogramsFunctionRadioButton;
    RadioButton cupsToPintsFunctionRadioButton;
    RadioButton quartsToGallonsFunctionRadioButton;
    RadioButton millimetersToCentimetersFunctionRadioButton;
    RadioButton metersToKilometersFunctionRadioButton;
    RadioButton inchesToFeetFunctionRadioButton;
    RadioButton yardsToMilesFunctionRadioButton;
    RadioButton millilitersToLitersFunctionRadioButton;
    RadioButton temperatureFunctionRadioButton;
    RadioButton teaspoonsToTablespoonsFunctionRadioButton;
    RadioButton millilitersToFluidOuncesFunctionRadioButton;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Measurement Converter function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter);
        activate();
        measurementConveterFunctionSelectButton.setOnClickListener(view -> {
            if (ouncesToPoundsFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverterOuncesToPounds.class);
                startActivity(intent);
            }
            else if (tonsToMilligramsFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverterTonsToMilligrams.class);
                startActivity(intent);
            }
            else if (gramsToKilogramsFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverterGramsToKilograms.class);
                startActivity(intent);
            }
            else if (cupsToPintsFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverterCupsToPints.class);
                startActivity(intent);
            }
            else if (quartsToGallonsFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverterQuartsToGallons.class);
                startActivity(intent);
            }
            else if (millimetersToCentimetersFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverterMillimetersToCentimeters.class);
                startActivity(intent);
            }
            else if (metersToKilometersFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverterMetersToKilometers.class);
                startActivity(intent);
            }
            else if (inchesToFeetFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverterInchesToFeet.class);
                startActivity(intent);
            }
            else if (yardsToMilesFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverterYardsToMiles.class);
                startActivity(intent);
            }
            else if (millilitersToLitersFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverterMillilitersToLiters.class);
                startActivity(intent);
            }
            else if (temperatureFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverterTemperature.class);
                startActivity(intent);
            }
            else if (millilitersToFluidOuncesFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverterMillilitersToFluidOunces.class);
                startActivity(intent);
            }
            else if (teaspoonsToTablespoonsFunctionRadioButton.isChecked()) {
                Intent intent = new Intent(view.getContext(), MeasurementConverterTeaspoonsToTablespoons.class);
                startActivity(intent);
            }
        });
    }

    /**
     * this public void measurementConverterChangetoMainMenuScreen() method changes the screen to the main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void measurementConverterChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        measurementConverterRadioGroup = findViewById(R.id.MeasurementConverterRadioGroup);
        measurementConveterFunctionSelectButton = findViewById(R.id.MeasurementConverterFunctionSelectButton);
        ouncesToPoundsFunctionRadioButton = findViewById(R.id.OuncesToPoundsFunctionRadioButton);
        tonsToMilligramsFunctionRadioButton = findViewById(R.id.TonsToMilligramsFunctionRadioButton);
        gramsToKilogramsFunctionRadioButton = findViewById(R.id.GramsToKilogramsFunctionRadioButton);
        cupsToPintsFunctionRadioButton = findViewById(R.id.CupsToPintsFunctionRadioButton);
        quartsToGallonsFunctionRadioButton = findViewById(R.id.QuartsToGallonsFunctionRadioButton);
        millimetersToCentimetersFunctionRadioButton = findViewById(R.id.MillimetersToCentimetersFunctionRadioButton);
        metersToKilometersFunctionRadioButton = findViewById(R.id.MetersToKilometersFunctionRadioButton);
        inchesToFeetFunctionRadioButton = findViewById(R.id.InchesToFeetFunctionRadioButton);
        yardsToMilesFunctionRadioButton = findViewById(R.id.YardsToMilesFunctionRadioButton);
        millilitersToLitersFunctionRadioButton = findViewById(R.id.MillilitersToLitersFunctionRadioButton);
        millilitersToFluidOuncesFunctionRadioButton = findViewById(R.id.MillilitersToFluidOuncesFunctionRadioButton);
        teaspoonsToTablespoonsFunctionRadioButton = findViewById(R.id.TeaspoonsToTablespoonsFunctionRadioButton);
        temperatureFunctionRadioButton = findViewById(R.id.TemperatureFunctionRadioButton);
    }

}
