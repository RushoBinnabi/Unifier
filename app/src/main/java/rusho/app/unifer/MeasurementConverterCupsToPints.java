/**
 * Name: Rusho Binnabi
 * Date: 8/1/2023
 * Project: Unifier - Measurement Converter - Cups to Pints Function
 * Code File Updated: 8/1/2023 at 4:39 PM
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

public class MeasurementConverterCupsToPints extends AppCompatActivity {

    // this MeasurementConverterCupsToPints class has all the code needed for the Cups to Pints conversion sub function of the main Measurement Converter function.

    EditText measurementConverterCupsToPintsInput;
    TextView measurementConverterCupsToPintsInputPrompt;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress text is here because there is nothing wrong with the switch object.
    Switch measurementConverterCupsToPintsSwitch;
    Button measurementConverterCupsToPintsConvertButton;
    Button measurementConverterCupsToPintsClearButton;
    String measurementNumberText;
    double measurementNumber;
    double finalConvertedMeasurementNumber;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Measurement Converter - Cups to Pints sub function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter_cups_to_pints);
        activate();
        measurementConverterCupsToPintsClearButton.setOnClickListener(v -> clearInputs());
        measurementConverterCupsToPintsConvertButton.setOnClickListener(v -> convertMeasurement());
    }

    /**
     * this private void convertMeasurement() method converts a given measurement input by the user and converts them between cups and pints, and vice versa.
     */

    @SuppressLint("SetTextI18n") // this suppress text is here because there is nothing wrong with the text.
    private void convertMeasurement() {
        try {
            if (!measurementConverterCupsToPintsSwitch.isChecked()) {
                measurementConverterCupsToPintsInputPrompt.setText("Enter Pints Value:");
                measurementNumberText = measurementConverterCupsToPintsInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber * 2;
                @SuppressLint("DefaultLocale") // this suppress text is here because there is nothing wrong with the toast object.
                Toast toast = Toast.makeText(this, String.format("%,.2f pints (pt) is about %,.2f cups (c)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            else if (measurementConverterCupsToPintsSwitch.isChecked()) {
                measurementConverterCupsToPintsInputPrompt.setText("Enter Cups Value:");
                measurementNumberText = measurementConverterCupsToPintsInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber / 2;
                @SuppressLint("DefaultLocale")
                Toast toast = Toast.makeText(this, String.format("%,.2f cups (c) is about %,.2f pints (pt)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
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
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        measurementConverterCupsToPintsClearButton = findViewById(R.id.MeasurementConverterCupsToPintsClearButton);
        measurementConverterCupsToPintsConvertButton = findViewById(R.id.MeasurementConverterCupsToPintsConvertButton);
        measurementConverterCupsToPintsSwitch = findViewById(R.id.MeasurementConverterCupsToPintsSwitch);
        measurementConverterCupsToPintsInputPrompt = findViewById(R.id.MeasurementConverterCupsToPintsInputPrompt);
        measurementConverterCupsToPintsInput = findViewById(R.id.MeasurementConverterCupsToPintsInput);
        measurementNumber = 0.00;
        finalConvertedMeasurementNumber = 0.00;
        measurementNumberText = "";
    }

    /**
     * the private void clearInputs() method resets all the variables and objects to their default values.
     */

    @SuppressLint("SetTextI18n")
    private void clearInputs() {
        measurementNumberText = "";
        measurementNumber = 0.00;
        finalConvertedMeasurementNumber = 0.00;
        measurementConverterCupsToPintsSwitch.setChecked(false);
        measurementConverterCupsToPintsInput.getText().clear();
        measurementConverterCupsToPintsInputPrompt.setText("Enter Cups Value:");
    }

    /**
     * this public void cupsToPintsChangetoMainMenuScreen() method changes the screen to the main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void cupsToPintsChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

    /**
     * this public void cupsToPintsChangetoMeasurementConverterScreen() method changes the screen to the measurement converter screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void cupsToPintsChangetoMeasurementConverterScreen(View view) {
        Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
        startActivity(intent);
    }
}