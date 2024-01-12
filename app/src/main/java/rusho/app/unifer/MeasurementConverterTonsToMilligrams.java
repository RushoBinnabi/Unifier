/**
 * Name: Rusho Binnabi
 * Date: 8/1/2023
 * Project: Unifier - Measurement Converter - Tons to Milligrams Function
 * Code File Updated: 8/1/2023 at 5:59 PM
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

public class MeasurementConverterTonsToMilligrams extends AppCompatActivity {

    // this MeasurementConverterTonsToMilligrams class has all the code needed for the Tons to Milligrams conversion sub function of the main Measurement Converter function.

    EditText measurementConverterTonsToMilligramsInput;
    TextView measurementConverterTonsToMilligramsInputPrompt;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress text is here because there is nothing wrong with the switch object.
    Switch measurementConverterTonsToMilligramsSwitch;
    Button measurementConverterTonsToMilligramsConvertButton;
    Button measurementConverterTonsToMilligramsClearButton;
    String measurementNumberText;
    double measurementNumber;
    double finalConvertedMeasurementNumber;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Measurement Converter - Tons to Milligrams sub function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter_tons_to_milligrams);
        activate();
        measurementConverterTonsToMilligramsClearButton.setOnClickListener(v -> clearInputs());
        measurementConverterTonsToMilligramsConvertButton.setOnClickListener(v -> convertMeasurement());
    }

    /**
     * this private void convertMeasurement() method converts a given measurement input by the user and converts them between tons and milligrams, and vice versa.
     */

    @SuppressLint("SetTextI18n") // this suppress text is here because there is nothing wrong with the text.
    private void convertMeasurement() {
        try {
            if (!measurementConverterTonsToMilligramsSwitch.isChecked()) {
                measurementConverterTonsToMilligramsInputPrompt.setText("Enter Milligrams Value:");
                measurementNumberText = measurementConverterTonsToMilligramsInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber * 907184740;
                @SuppressLint("DefaultLocale") // this suppress text is here because there is nothing wrong with the toast object.
                Toast toast = Toast.makeText(this, String.format("%,.2f milligrams (mg) is about %,.2f tons (t)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            else if (measurementConverterTonsToMilligramsSwitch.isChecked()) {
                measurementConverterTonsToMilligramsInputPrompt.setText("Enter Tons Value:");
                measurementNumberText = measurementConverterTonsToMilligramsInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber / 907184740;
                @SuppressLint("DefaultLocale")
                Toast toast = Toast.makeText(this, String.format("%,.2f tons (t) is about %,.2f milligrams (mg)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
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
        measurementConverterTonsToMilligramsSwitch.setChecked(false);
        measurementConverterTonsToMilligramsInput.getText().clear();
        measurementConverterTonsToMilligramsInputPrompt.setText("Enter Tons Value:");
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        measurementConverterTonsToMilligramsClearButton = findViewById(R.id.MeasurementConverterTonsToMilligramsClearButton);
        measurementConverterTonsToMilligramsConvertButton = findViewById(R.id.MeasurementConverterTonsToMilligramsConvertButton);
        measurementConverterTonsToMilligramsSwitch = findViewById(R.id.MeasurementConverterTonsToMilligramsSwitch);
        measurementConverterTonsToMilligramsInputPrompt = findViewById(R.id.MeasurementConverterTonsToMilligramsInputPrompt);
        measurementConverterTonsToMilligramsInput = findViewById(R.id.MeasurementConverterTonsToMilligramsInput);
        measurementNumber = 0.00;
        finalConvertedMeasurementNumber = 0.00;
        measurementNumberText = "";
    }

    /**
     * this public void tonsToMilligramsChangetoMainMenuScreen() method changes the screen to the main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void tonsToMilligramsChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

    /**
     * this public void tonsToMilligramsChangetoMeasurementConverterScreen() method changes the screen to the measurement converter screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void tonsToMilligramsChangetoMeasurementConverterScreen(View view) {
        Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
        startActivity(intent);
    }

}
