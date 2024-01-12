/**
 * Name: Rusho Binnabi
 * Date: 8/1/2023
 * Project: Unifier - Measurement Converter - Meters to Kilometers Function
 * Code File Updated: 8/1/2023 at 5:23 PM
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

public class MeasurementConverterMetersToKilometers extends AppCompatActivity {

    // this MeasurementConverterMetersToKilometers class has all the code needed for the Meters to Kilometers conversion sub function of the main Measurement Converter function.

    EditText measurementConverterMetersToKilometersInput;
    TextView measurementConverterMetersToKilometersInputPrompt;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress text is here because there is nothing wrong with the switch object.
    Switch measurementConverterMetersToKilometersSwitch;
    Button measurementConverterMetersToKilometersConvertButton;
    Button measurementConverterMetersToKilometersClearButton;
    String measurementNumberText;
    double measurementNumber;
    double finalConvertedMeasurementNumber;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Measurement Converter - Meters to Kilometers sub function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter_meters_to_kilometers);
        activate();
        measurementConverterMetersToKilometersClearButton.setOnClickListener(v -> clearInputs());
        measurementConverterMetersToKilometersConvertButton.setOnClickListener(v -> convertMeasurement());
    }

    /**
     * this private void convertMeasurement() method converts a given measurement input by the user and converts them between meters and kilometers, and vice versa.
     */

    @SuppressLint("SetTextI18n") // this suppress text is here because there is nothing wrong with the text.
    private void convertMeasurement() {
        try {
            if (!measurementConverterMetersToKilometersSwitch.isChecked()) {
                measurementConverterMetersToKilometersInputPrompt.setText("Enter Kilometers Value:");
                measurementNumberText = measurementConverterMetersToKilometersInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber * 1000;
                @SuppressLint("DefaultLocale") // this suppress text is here because there is nothing wrong with the toast object.
                Toast toast = Toast.makeText(this, String.format("%,.2f kilometers (km) is about %,.2f meters (m)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            else if (measurementConverterMetersToKilometersSwitch.isChecked()) {
                measurementConverterMetersToKilometersInputPrompt.setText("Enter Meters Value:");
                measurementNumberText = measurementConverterMetersToKilometersInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber / 1000;
                @SuppressLint("DefaultLocale")
                Toast toast = Toast.makeText(this, String.format("%,.2f meters (m) is about %,.2f kilometers (km)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
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
        measurementConverterMetersToKilometersSwitch.setChecked(false);
        measurementConverterMetersToKilometersInput.getText().clear();
        measurementConverterMetersToKilometersInputPrompt.setText("Enter Meters Value:");
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        measurementConverterMetersToKilometersClearButton = findViewById(R.id.MeasurementConverterMetersToKilometersClearButton);
        measurementConverterMetersToKilometersConvertButton = findViewById(R.id.MeasurementConverterMetersToKilometersConvertButton);
        measurementConverterMetersToKilometersSwitch = findViewById(R.id.MeasurementConverterMetersToKilometersSwitch);
        measurementConverterMetersToKilometersInputPrompt = findViewById(R.id.MeasurementConverterMetersToKilometersInputPrompt);
        measurementConverterMetersToKilometersInput = findViewById(R.id.MeasurementConverterMetersToKilometersInput);
        measurementNumber = 0.00;
        finalConvertedMeasurementNumber = 0.00;
        measurementNumberText = "";
    }

    /**
     * this public void metersToKilometersChangetoMainMenuScreen() method changes the screen to the main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void metersToKilometersChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

    /**
     * this public void metersToKilometersChangetoMeasurementConverterScreen() method changes the screen to the measurement converter screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void metersToKilometersChangetoMeasurementConverterScreen(View view) {
        Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
        startActivity(intent);
    }

}
