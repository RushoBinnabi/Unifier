/**
 * Name: Rusho Binnabi
 * Date: 8/6/2023
 * Project: Unifier - Measurement Converter - Milliliters to Fluid Ounces Function
 * Code File Updated: 8/6/2023 at 5:00 PM
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

public class MeasurementConverterMillilitersToFluidOunces extends AppCompatActivity {

    // this MeasurementConverterMillilitersToFluidOunces class has all the code needed for the Milliliters to Fluid Ounces conversion sub function of the main Measurement Converter function.

    EditText measurementConverterMillilitersToFluidOuncesInput;
    TextView measurementConverterMillilitersToFluidOuncesInputPrompt;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress text is here because there is nothing wrong with the switch object.
    Switch measurementConverterMillilitersToFluidOuncesSwitch;
    Button measurementConverterMillilitersToFluidOuncesConvertButton;
    Button measurementConverterMillilitersToFluidOuncesClearButton;
    String measurementNumberText;
    double measurementNumber;
    double finalConvertedMeasurementNumber;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Measurement Converter - Milliliters to Fluid Ounces sub function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter_milliliters_to_fluid_ounces);
        activate();
        measurementConverterMillilitersToFluidOuncesClearButton.setOnClickListener(v -> clearInputs());
        measurementConverterMillilitersToFluidOuncesConvertButton.setOnClickListener(v -> convertMeasurement());
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        measurementConverterMillilitersToFluidOuncesClearButton = findViewById(R.id.MeasurementConverterMillilitersToFluidOuncesClearButton);
        measurementConverterMillilitersToFluidOuncesConvertButton = findViewById(R.id.MeasurementConverterMillilitersToFluidOuncesConvertButton);
        measurementConverterMillilitersToFluidOuncesSwitch = findViewById(R.id.MeasurementConverterMillilitersToFluidOuncesSwitch);
        measurementConverterMillilitersToFluidOuncesInputPrompt = findViewById(R.id.MeasurementConverterMillilitersToFluidOuncesInputPrompt);
        measurementConverterMillilitersToFluidOuncesInput = findViewById(R.id.MeasurementConverterMillilitersToFluidOuncesInput);
        measurementNumber = 0.00;
        finalConvertedMeasurementNumber = 0.00;
        measurementNumberText = "";
    }

    /**
     * this private void convertMeasurement() method converts a given measurement input by the user and converts them between milliliters to fluid ounces, and vice versa.
     */

    @SuppressLint("SetTextI18n") // this suppress text is here because there is nothing wrong with the text.
    private void convertMeasurement() {
        try {
            if (!measurementConverterMillilitersToFluidOuncesSwitch.isChecked()) {
                measurementConverterMillilitersToFluidOuncesInputPrompt.setText("Enter Fluid Ounces Value:");
                measurementNumberText = measurementConverterMillilitersToFluidOuncesInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber * 29.574;
                @SuppressLint("DefaultLocale") // this suppress text is here because there is nothing wrong with the toast object.
                Toast toast = Toast.makeText(this, String.format("%,.2f fluid ounces (fl oz) is about %,.2f milliliters (mL)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            else if (measurementConverterMillilitersToFluidOuncesSwitch.isChecked()) {
                measurementConverterMillilitersToFluidOuncesInputPrompt.setText("Enter Milliliters Value:");
                measurementNumberText = measurementConverterMillilitersToFluidOuncesInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber / 29.574;
                @SuppressLint("DefaultLocale")
                Toast toast = Toast.makeText(this, String.format("%,.2f milliliters (mL) is about %,.2f fluid ounces (fl oz)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
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
        measurementConverterMillilitersToFluidOuncesSwitch.setChecked(false);
        measurementConverterMillilitersToFluidOuncesInput.getText().clear();
        measurementConverterMillilitersToFluidOuncesInputPrompt.setText("Enter Milliliters Value:");
    }

    /**
     * this public void inchesToFeetChangetoMainMenuScreen() method changes the screen to the main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void millilitersToFluidOuncesChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

    /**
     * this public void millilitersToFluidOuncesChangetoMeasurementConverterScreen() method changes the screen to the measurement converter screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void millilitersToFluidOuncesChangetoMeasurementConverterScreen(View view) {
        Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
        startActivity(intent);
    }

}
