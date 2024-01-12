/**
 * Name: Rusho Binnabi
 * Date: 8/1/2023
 * Project: Unifier - Measurement Converter - Ounces to Pounds Function
 * Code File Updated: 8/1/2023 at 5:40 PM
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

public class MeasurementConverterOuncesToPounds extends AppCompatActivity {

    // this MeasurementConverterOuncesToPounds class has all the code needed for the Ounces to Pounds conversion sub function of the main Measurement Converter function.

    EditText measurementConverterOuncesToPoundsInput;
    TextView measurementConverterOuncesToPoundsInputPrompt;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress text is here because there is nothing wrong with the switch object.
    Switch measurementConverterOuncesToPoundsSwitch;
    Button measurementConverterOuncesToPoundsConvertButton;
    Button measurementConverterOuncesToPoundsClearButton;
    String measurementNumberText;
    double measurementNumber;
    double finalConvertedMeasurementNumber;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Measurement Converter - Ounces to Pounds sub function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter_ounces_to_pounds);
        activate();
        measurementConverterOuncesToPoundsClearButton.setOnClickListener(v -> clearInputs());
        measurementConverterOuncesToPoundsConvertButton.setOnClickListener(v -> convertMeasurement());
    }

    /**
     * this private void convertMeasurement() method converts a given measurement input by the user and converts them between ounces to pounds, and vice versa.
     */

    @SuppressLint("SetTextI18n") // this suppress text is here because there is nothing wrong with the text.
    private void convertMeasurement() {
        try {
            if (!measurementConverterOuncesToPoundsSwitch.isChecked()) {
                measurementConverterOuncesToPoundsInputPrompt.setText("Enter Pounds Value:");
                measurementNumberText = measurementConverterOuncesToPoundsInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber * 16;
                @SuppressLint("DefaultLocale") // this suppress text is here because there is nothing wrong with the toast object.
                Toast toast = Toast.makeText(this, String.format("%,.2f pounds (lbs) is about %,.2f ounces (oz)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            else if (measurementConverterOuncesToPoundsSwitch.isChecked()) {
                measurementConverterOuncesToPoundsInputPrompt.setText("Enter Ounces Value:");
                measurementNumberText = measurementConverterOuncesToPoundsInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber / 16;
                @SuppressLint("DefaultLocale")
                Toast toast = Toast.makeText(this, String.format("%,.2f ounces (oz) is about %,.2f pounds (lbs)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
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
        measurementConverterOuncesToPoundsSwitch.setChecked(false);
        measurementConverterOuncesToPoundsInput.getText().clear();
        measurementConverterOuncesToPoundsInputPrompt.setText("Enter Ounces Value:");
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        measurementConverterOuncesToPoundsClearButton = findViewById(R.id.MeasurementConverterOuncesToPoundsClearButton);
        measurementConverterOuncesToPoundsConvertButton = findViewById(R.id.MeasurementConverterOuncesToPoundsConvertButton);
        measurementConverterOuncesToPoundsSwitch = findViewById(R.id.MeasurementConverterOuncesToPoundsSwitch);
        measurementConverterOuncesToPoundsInputPrompt = findViewById(R.id.MeasurementConverterOuncesToPoundsInputPrompt);
        measurementConverterOuncesToPoundsInput = findViewById(R.id.MeasurementConverterOuncesToPoundsInput);
        measurementNumber = 0.00;
        finalConvertedMeasurementNumber = 0.00;
        measurementNumberText = "";
    }

    /**
     * this public void ouncesToPoundsChangetoMeasurementConverterScreen() method changes the screen to the main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void ouncesToPoundsChangetoMeasurementConverterScreen(View view) {
        Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
        startActivity(intent);
    }

    /**
     * this public void ouncesToPoundsChangetoMainMenuScreen() method changes the screen to the measurement converter screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void ouncesToPoundsChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

}
