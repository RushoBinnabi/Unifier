/**
 * Name: Rusho Binnabi
 * Date: 8/1/2023
 * Project: Unifier - Measurement Converter - Millimeters to Centimeters Function
 * Code File Updated: 8/1/2023 at 5:36 PM
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

public class MeasurementConverterMillimetersToCentimeters extends AppCompatActivity {

    // this MeasurementConverterMillimetersToCentimeters class has all the code needed for the Millimeters to Centimeters conversion sub function of the main Measurement Converter function.

    EditText measurementConverterMillimetersToCentimetersInput;
    TextView measurementConverterMillimetersToCentimetersInputPrompt;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress text is here because there is nothing wrong with the switch object.
    Switch measurementConverterMillimetersToCentimetersSwitch;
    Button measurementConverterMillimetersToCentimetersConvertButton;
    Button measurementConverterMillimetersToCentimetersClearButton;
    String measurementNumberText;
    double measurementNumber;
    double finalConvertedMeasurementNumber;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Measurement Converter - Millimeters to Centimeters sub function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter_millimeters_to_centimeters);
        activate();
        measurementConverterMillimetersToCentimetersClearButton.setOnClickListener(v -> clearInputs());
        measurementConverterMillimetersToCentimetersConvertButton.setOnClickListener(v -> convertMeasurement());
    }

    /**
     * this private void convertMeasurement() method converts a given measurement input by the user and converts them between millimeters to centimeters, and vice versa.
     */

    @SuppressLint("SetTextI18n") // this suppress text is here because there is nothing wrong with the text.
    private void convertMeasurement() {
        try {
            if (!measurementConverterMillimetersToCentimetersSwitch.isChecked()) {
                measurementConverterMillimetersToCentimetersInputPrompt.setText("Enter Centimeters Value:");
                measurementNumberText = measurementConverterMillimetersToCentimetersInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber * 10;
                @SuppressLint("DefaultLocale") // this suppress text is here because there is nothing wrong with the toast object.
                Toast toast = Toast.makeText(this, String.format("%,.2f centimeters (cm) is about %,.2f millimeters (mm)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            else if (measurementConverterMillimetersToCentimetersSwitch.isChecked()) {
                measurementConverterMillimetersToCentimetersInputPrompt.setText("Enter Millimeters Value:");
                measurementNumberText = measurementConverterMillimetersToCentimetersInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber / 10;
                @SuppressLint("DefaultLocale")
                Toast toast = Toast.makeText(this, String.format("%,.2f millimeters (mm) is about %,.2f centimeters (cm)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
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
        measurementConverterMillimetersToCentimetersSwitch.setChecked(false);
        measurementConverterMillimetersToCentimetersInput.getText().clear();
        measurementConverterMillimetersToCentimetersInputPrompt.setText("Enter Millimeters Value:");
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        measurementConverterMillimetersToCentimetersClearButton = findViewById(R.id.MeasurementConverterMillimetersToCentimetersClearButton);
        measurementConverterMillimetersToCentimetersConvertButton = findViewById(R.id.MeasurementConverterMillimetersToCentimetersConvertButton);
        measurementConverterMillimetersToCentimetersSwitch = findViewById(R.id.MeasurementConverterMillimetersToCentimetersSwitch);
        measurementConverterMillimetersToCentimetersInputPrompt = findViewById(R.id.MeasurementConverterMillimetersToCentimetersInputPrompt);
        measurementConverterMillimetersToCentimetersInput = findViewById(R.id.MeasurementConverterMillimetersToCentimetersInput);
        measurementNumber = 0.00;
        finalConvertedMeasurementNumber = 0.00;
        measurementNumberText = "";
    }

    /**
     * this public void millimetersToCentimetersChangetoMainMenuScreen() method changes the screen to the main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void millimetersToCentimetersChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

    /**
     * this public void millimetersToCentimetersChangetoMeasurementConverterScreen() method changes the screen to the measurement converter screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void millimetersToCentimetersChangetoMeasurementConverterScreen(View view) {
        Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
        startActivity(intent);
    }
}
