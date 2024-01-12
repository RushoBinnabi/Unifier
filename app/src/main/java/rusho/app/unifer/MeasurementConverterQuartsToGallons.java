/**
 * Name: Rusho Binnabi
 * Date: 8/1/2023
 * Project: Unifier - Measurement Converter - Quarts to Gallons Function
 * Code File Updated: 8/1/2023 at 5:48 PM
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

public class MeasurementConverterQuartsToGallons extends AppCompatActivity {

    // this MeasurementConverterQuartsToGallons class has all the code needed for the Quarts to Gallons conversion sub function of the main Measurement Converter function.

    EditText measurementConverterQuartsToGallonsInput;
    TextView measurementConverterQuartsToGallonsInputPrompt;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress text is here because there is nothing wrong with the switch object.
    Switch measurementConverterQuartsToGallonsSwitch;
    Button measurementConverterQuartsToGallonsConvertButton;
    Button measurementConverterQuartsToGallonsClearButton;
    String measurementNumberText;
    double measurementNumber;
    double finalConvertedMeasurementNumber;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Measurement Converter - Quarts to Gallons sub function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter_quarts_to_gallons);
        activate();
        measurementConverterQuartsToGallonsClearButton.setOnClickListener(v -> clearInputs());
        measurementConverterQuartsToGallonsConvertButton.setOnClickListener(v -> convertMeasurement());
    }

    /**
     * this private void convertMeasurement() method converts a given measurement input by the user and converts them between quarts and gallons, and vice versa.
     */

    @SuppressLint("SetTextI18n") // this suppress text is here because there is nothing wrong with the text.
    private void convertMeasurement() {
        try {
            if (!measurementConverterQuartsToGallonsSwitch.isChecked()) {
                measurementConverterQuartsToGallonsInputPrompt.setText("Enter Gallons Value:");
                measurementNumberText = measurementConverterQuartsToGallonsInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber * 4;
                @SuppressLint("DefaultLocale") // this suppress text is here because there is nothing wrong with the toast object.
                Toast toast = Toast.makeText(this, String.format("%,.2f gallons (gal) is about %,.2f quarts (qt)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            else if (measurementConverterQuartsToGallonsSwitch.isChecked()) {
                measurementConverterQuartsToGallonsInputPrompt.setText("Enter Quarts Value:");
                measurementNumberText = measurementConverterQuartsToGallonsInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber / 4;
                @SuppressLint("DefaultLocale")
                Toast toast = Toast.makeText(this, String.format("%,.2f quarts (qt) is about %,.2f gallons (gal)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
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
        measurementConverterQuartsToGallonsSwitch.setChecked(false);
        measurementConverterQuartsToGallonsInput.getText().clear();
        measurementConverterQuartsToGallonsInputPrompt.setText("Enter Quarts Value:");
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        measurementConverterQuartsToGallonsClearButton = findViewById(R.id.MeasurementConverterQuartsToGallonsClearButton);
        measurementConverterQuartsToGallonsConvertButton = findViewById(R.id.MeasurementConverterQuartsToGallonsConvertButton);
        measurementConverterQuartsToGallonsSwitch = findViewById(R.id.MeasurementConverterQuartsToGallonsSwitch);
        measurementConverterQuartsToGallonsInputPrompt = findViewById(R.id.MeasurementConverterQuartsToGallonsInputPrompt);
        measurementConverterQuartsToGallonsInput = findViewById(R.id.MeasurementConverterQuartsToGallonsInput);
        measurementNumber = 0.00;
        finalConvertedMeasurementNumber = 0.00;
        measurementNumberText = "";
    }

    /**
     * this public void quartsToGallonsChangetoMainMenuScreen() method changes the screen to the main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void quartsToGallonsChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

    /**
     * this public void quartsToGallonsChangetoMeasurementConverterScreen() method changes the screen to the measurement converter screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void quartsToGallonsChangetoMeasurementConverterScreen(View view) {
        Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
        startActivity(intent);
    }

}
