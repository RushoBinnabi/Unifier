/**
 * Name: Rusho Binnabi
 * Date: 8/1/2023
 * Project: Unifier - Measurement Converter - Inches to Feet Function
 * Code File Updated: 8/1/2023 at 5:14 PM
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

public class MeasurementConverterInchesToFeet extends AppCompatActivity {

    // this MeasurementConverterInchesToFeet class has all the code needed for the Inches to Feet conversion sub function of the main Measurement Converter function.

    EditText measurementConverterInchesToFeetInput;
    TextView measurementConverterInchesToFeetInputPrompt;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress text is here because there is nothing wrong with the switch object.
    Switch measurementConverterInchesToFeetSwitch;
    Button measurementConverterInchesToFeetConvertButton;
    Button measurementConverterInchesToFeetClearButton;
    String measurementNumberText;
    double measurementNumber;
    double finalConvertedMeasurementNumber;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Measurement Converter - Inches to Feet sub function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter_inches_to_feet);
        activate();
        measurementConverterInchesToFeetClearButton.setOnClickListener(v -> clearInputs());
        measurementConverterInchesToFeetConvertButton.setOnClickListener(v -> convertMeasurement());
    }

    /**
     * this private void convertMeasurement() method converts a given measurement input by the user and converts them between inches and feet, and vice versa.
     */

    @SuppressLint("SetTextI18n") // this suppress text is here because there is nothing wrong with the text.
    private void convertMeasurement() {
        try {
            if (!measurementConverterInchesToFeetSwitch.isChecked()) {
                measurementConverterInchesToFeetInputPrompt.setText("Enter Feet Value:");
                measurementNumberText = measurementConverterInchesToFeetInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber * 12;
                @SuppressLint("DefaultLocale") // this suppress text is here because there is nothing wrong with the toast object.
                Toast toast = Toast.makeText(this, String.format("%,.2f feet (ft) is about %,.2f inches (in)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            else if (measurementConverterInchesToFeetSwitch.isChecked()) {
                measurementConverterInchesToFeetInputPrompt.setText("Enter Inches Value:");
                measurementNumberText = measurementConverterInchesToFeetInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber / 12;
                @SuppressLint("DefaultLocale")
                Toast toast = Toast.makeText(this, String.format("%,.2f inches (in) is about %,.2f feet (ft)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
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
        measurementConverterInchesToFeetClearButton = findViewById(R.id.MeasurementConverterInchesToFeetClearButton);
        measurementConverterInchesToFeetConvertButton = findViewById(R.id.MeasurementConverterInchesToFeetConvertButton);
        measurementConverterInchesToFeetSwitch = findViewById(R.id.MeasurementConverterInchesToFeetSwitch);
        measurementConverterInchesToFeetInputPrompt = findViewById(R.id.MeasurementConverterInchesToFeetInputPrompt);
        measurementConverterInchesToFeetInput = findViewById(R.id.MeasurementConverterInchesToFeetInput);
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
        measurementConverterInchesToFeetSwitch.setChecked(false);
        measurementConverterInchesToFeetInput.getText().clear();
        measurementConverterInchesToFeetInputPrompt.setText("Enter Inches Value:");
    }

    /**
     * this public void inchesToFeetChangetoMeasurementConverterScreen() method changes the screen to the measurement converter screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void inchesToFeetChangetoMeasurementConverterScreen(View view) {
        Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
        startActivity(intent);
    }

    /**
     * this public void inchesToFeetChangetoMainMenuScreen() method changes the screen to the main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void inchesToFeetChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

}
