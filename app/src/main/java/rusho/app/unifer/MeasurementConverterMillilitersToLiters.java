/**
 * Name: Rusho Binnabi
 * Date: 8/1/2023
 * Project: Unifier - Measurement Converter - Milliliters to Liters Function
 * Code File Updated: 8/1/2023 at 5:31 PM
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

public class MeasurementConverterMillilitersToLiters extends AppCompatActivity {

    // this MeasurementConverterMillilitersToLiters class has all the code needed for the Milliliters to Liters conversion sub function of the main Measurement Converter function.

    EditText measurementConverterMillilitersToLitersInput;
    TextView measurementConverterMillilitersToLitersInputPrompt;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress text is here because there is nothing wrong with the switch object.
    Switch measurementConverterMillilitersToLitersSwitch;
    Button measurementConverterMillilitersToLitersConvertButton;
    Button measurementConverterMillilitersToLitersClearButton;
    String measurementNumberText;
    double measurementNumber;
    double finalConvertedMeasurementNumber;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Measurement Converter - Milliliters to Liters sub function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter_milliliters_to_liters);
        activate();
        measurementConverterMillilitersToLitersClearButton.setOnClickListener(v -> clearInputs());
        measurementConverterMillilitersToLitersConvertButton.setOnClickListener(v -> convertMeasurement());
    }

    /**
     * this private void convertMeasurement() method converts a given measurement input by the user and converts them between milliliters to liters, and vice versa.
     */

    @SuppressLint("SetTextI18n") // this suppress text is here because there is nothing wrong with the text.
    private void convertMeasurement() {
        try {
            if (!measurementConverterMillilitersToLitersSwitch.isChecked()) {
                measurementConverterMillilitersToLitersInputPrompt.setText("Enter Liters Value:");
                measurementNumberText = measurementConverterMillilitersToLitersInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber * 1000;
                @SuppressLint("DefaultLocale") // this suppress text is here because there is nothing wrong with the toast object.
                Toast toast = Toast.makeText(this, String.format("%,.2f liters (L) is about %,.2f milliliters (mL)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            else if (measurementConverterMillilitersToLitersSwitch.isChecked()) {
                measurementConverterMillilitersToLitersInputPrompt.setText("Enter Milliliters Value:");
                measurementNumberText = measurementConverterMillilitersToLitersInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber / 1000;
                @SuppressLint("DefaultLocale")
                Toast toast = Toast.makeText(this, String.format("%,.2f milliliters (mL) is about %,.2f liters (L)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
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
        measurementConverterMillilitersToLitersSwitch.setChecked(false);
        measurementConverterMillilitersToLitersInput.getText().clear();
        measurementConverterMillilitersToLitersInputPrompt.setText("Enter Milliliters Value:");
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        measurementConverterMillilitersToLitersClearButton = findViewById(R.id.MeasurementConverterMillilitersToLitersClearButton);
        measurementConverterMillilitersToLitersConvertButton = findViewById(R.id.MeasurementConverterMillilitersToLitersConvertButton);
        measurementConverterMillilitersToLitersSwitch = findViewById(R.id.MeasurementConverterMillilitersToLitersSwitch);
        measurementConverterMillilitersToLitersInputPrompt = findViewById(R.id.MeasurementConverterMillilitersToLitersInputPrompt);
        measurementConverterMillilitersToLitersInput = findViewById(R.id.MeasurementConverterMillilitersToLitersInput);
        measurementNumber = 0.00;
        finalConvertedMeasurementNumber = 0.00;
        measurementNumberText = "";
    }

    /**
     * this public void millilitersToLitersChangetoMainMenuScreen() method changes the screen to the main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void millilitersToLitersChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

    /**
     * this public void millilitersToLitersChangetoMeasurementConverterScreen() method changes the screen to the measurement converter screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void millilitersToLitersChangetoMeasurementConverterScreen(View view) {
        Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
        startActivity(intent);
    }

}
