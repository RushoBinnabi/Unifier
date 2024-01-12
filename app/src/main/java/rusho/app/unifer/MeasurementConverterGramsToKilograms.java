/**
 * Name: Rusho Binnabi
 * Date: 8/1/2023
 * Project: Unifier - Measurement Converter - Grams to Kilograms Function
 * Code File Updated: 8/1/2023 at 5:07 PM
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

public class MeasurementConverterGramsToKilograms extends AppCompatActivity {

    // this MeasurementConverterGramsToKilograms class has all the code needed for the Grams to Kilograms conversion sub function of the main Measurement Converter function.

    EditText measurementConverterGramsToKilogramsInput;
    TextView measurementConverterGramsToKilogramsInputPrompt;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress text is here because there is nothing wrong with the switch object.
    Switch measurementConverterGramsToKilogramsSwitch;
    Button measurementConverterGramsToKilogramsConvertButton;
    Button measurementConverterGramsToKilogramsClearButton;
    String measurementNumberText;
    double measurementNumber;
    double finalConvertedMeasurementNumber;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Measurement Converter - Grams to Kilograms sub function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter_grams_to_kilograms);
        activate();
        measurementConverterGramsToKilogramsClearButton.setOnClickListener(v -> clearInputs());
        measurementConverterGramsToKilogramsConvertButton.setOnClickListener(v -> convertMeasurement());
    }

    /**
     * this private void convertMeasurement() method converts a given measurement input by the user and converts them between grams and kilograms, and vice versa.
     */

    @SuppressLint("SetTextI18n") // this suppress text is here because there is nothing wrong with the text.
    private void convertMeasurement() {
        try {
            if (!measurementConverterGramsToKilogramsSwitch.isChecked()) {
                measurementConverterGramsToKilogramsInputPrompt.setText("Enter Kilograms Value:");
                measurementNumberText = measurementConverterGramsToKilogramsInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber * 1000;
                @SuppressLint("DefaultLocale") // this suppress text is here because there is nothing wrong with the toast object.
                Toast toast = Toast.makeText(this, String.format("%,.2f kilograms (kg) is about %,.2f grams (g)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            else if (measurementConverterGramsToKilogramsSwitch.isChecked()) {
                measurementConverterGramsToKilogramsInputPrompt.setText("Enter Grams Value:");
                measurementNumberText = measurementConverterGramsToKilogramsInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber / 1000;
                @SuppressLint("DefaultLocale")
                Toast toast = Toast.makeText(this, String.format("%,.2f grams (g) is about %,.2f kilograms (kg)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
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
        measurementConverterGramsToKilogramsClearButton = findViewById(R.id.MeasurementConverterGramsToKilogramsClearButton);
        measurementConverterGramsToKilogramsConvertButton = findViewById(R.id.MeasurementConverterGramsToKilogramsConvertButton);
        measurementConverterGramsToKilogramsSwitch = findViewById(R.id.MeasurementConverterGramsToKilogramsSwitch);
        measurementConverterGramsToKilogramsInputPrompt = findViewById(R.id.MeasurementConverterGramsToKilogramsInputPrompt);
        measurementConverterGramsToKilogramsInput = findViewById(R.id.MeasurementConverterGramsToKilogramsInput);
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
        measurementConverterGramsToKilogramsSwitch.setChecked(false);
        measurementConverterGramsToKilogramsInput.getText().clear();
        measurementConverterGramsToKilogramsInputPrompt.setText("Enter Grams Value:");
    }

    /**
     * this public void gramsToKilogramsChangetoMeasurementConverterScreen() method changes the screen to the measurement converter screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void gramsToKilogramsChangetoMeasurementConverterScreen(View view) {
        Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
        startActivity(intent);
    }

    /**
     * this public void gramsToKilogramsChangetoMainMenuScreen() method changes the screen to the main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void gramsToKilogramsChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }
}
