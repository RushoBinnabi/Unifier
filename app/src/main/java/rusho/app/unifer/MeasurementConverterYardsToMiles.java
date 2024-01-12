/**
 * Name: Rusho Binnabi
 * Date: 8/1/2023
 * Project: Unifier - Measurement Converter - Yards to Miles Function
 * Code File Updated: 8/1/2023 at 6:06 PM
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
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MeasurementConverterYardsToMiles extends AppCompatActivity {

    // this MeasurementConverterYardsToMiles class has all the code needed for the Yards to Miles conversion sub function of the main Measurement Converter function.

    EditText measurementConverterYardsToMilesInput;
    TextView measurementConverterYardsToMilesInputPrompt;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress text is here because there is nothing wrong with the switch object.
    Switch measurementConverterYardsToMilesSwitch;
    Button measurementConverterYardsToMilesConvertButton;
    Button measurementConverterYardsToMilesClearButton;
    String measurementNumberText;
    double measurementNumber;
    double finalConvertedMeasurementNumber;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Measurement Converter - Yards to Miles sub function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter_yards_to_miles);
        activate();
        measurementConverterYardsToMilesClearButton.setOnClickListener(v -> clearInputs());
        measurementConverterYardsToMilesConvertButton.setOnClickListener(v -> convertMeasurement());
    }

    /**
     * this private void convertMeasurement() method converts a given measurement input by the user and converts them between yards to miles, and vice versa.
     */

    @SuppressLint("SetTextI18n") // this suppress text is here because there is nothing wrong with the text.
    private void convertMeasurement() {
        try {
            if (!measurementConverterYardsToMilesSwitch.isChecked()) {
                measurementConverterYardsToMilesInputPrompt.setText("Enter Miles Value:");
                measurementNumberText = measurementConverterYardsToMilesInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber * 1760;
                @SuppressLint("DefaultLocale") // this suppress text is here because there is nothing wrong with the toast object.
                Toast toast = Toast.makeText(this, String.format("%,.2f miles (mi) is about %,.2f yards (yd)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            else if (measurementConverterYardsToMilesSwitch.isChecked()) {
                measurementConverterYardsToMilesInputPrompt.setText("Enter Yards Value:");
                measurementNumberText = measurementConverterYardsToMilesInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber / 1760;
                @SuppressLint("DefaultLocale")
                Toast toast = Toast.makeText(this, String.format("%,.2f yards (yd) is about %,.2f miles (mi)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
        }
        catch (NumberFormatException n) {
            Toast toast = Toast.makeText(this, "Error. Please enter a number", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 120);
            toast.show();
        }
    }

    /**
     * the private void clearInputs() method resets all the variables and objects to their default values.
     */

    @SuppressLint("SetTextI18n")
    private void clearInputs() {
        measurementNumberText = "";
        measurementNumber = 0.00;
        finalConvertedMeasurementNumber = 0.00;
        measurementConverterYardsToMilesSwitch.setChecked(false);
        measurementConverterYardsToMilesInput.getText().clear();
        measurementConverterYardsToMilesInputPrompt.setText("Enter Yards Value:");
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        measurementConverterYardsToMilesClearButton = findViewById(R.id.MeasurementConverterYardsToMilesClearButton);
        measurementConverterYardsToMilesConvertButton = findViewById(R.id.MeasurementConverterYardsToMilesConvertButton);
        measurementConverterYardsToMilesSwitch = findViewById(R.id.MeasurementConverterYardsToMilesSwitch);
        measurementConverterYardsToMilesInputPrompt = findViewById(R.id.MeasurementConverterYardsToMilesInputPrompt);
        measurementConverterYardsToMilesInput = findViewById(R.id.MeasurementConverterYardsToMilesInput);
        measurementNumber = 0.00;
        finalConvertedMeasurementNumber = 0.00;
        measurementNumberText = "";
    }

    /**
     * this public void yardsToMilesChangetoMainMenuScreen() method changes the screen to the main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void yardsToMilesChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

    /**
     * this public void yardsToMilesChangetoMeasurementConverterScreen() method changes the screen to the measurement converter screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void yardsToMilesChangetoMeasurementConverterScreen(View view) {
        Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
        startActivity(intent);
    }
}
