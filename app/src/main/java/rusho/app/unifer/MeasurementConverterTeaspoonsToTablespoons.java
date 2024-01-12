/**
 * Name: Rusho Binnabi
 * Date: 8/1/2023
 * Project: Unifier - Measurement Converter - Teaspoons to Tablespoons Function
 * Code File Updated: 8/12/2023 at 11:09 PM
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

public class MeasurementConverterTeaspoonsToTablespoons extends AppCompatActivity {

    // this MeasurementConverterTeaspoonsToTablespoons class has all the code needed for the Teaspoons to Tablespoons conversion sub function of the main Measurement Converter function.

    EditText measurementConverterTeaspoonsToTablespoonsInput;
    TextView measurementConverterTeaspoonsToTablespoonsInputPrompt;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress text is here because there is nothing wrong with the switch object.
    Switch measurementConverterTeaspoonsToTablespoonsSwitch;
    Button measurementConverterTeaspoonsToTablespoonsConvertButton;
    Button measurementConverterTeaspoonsToTablespoonsClearButton;
    String measurementNumberText;
    double measurementNumber;
    double finalConvertedMeasurementNumber;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, 
     * has the code for the Measurement Converter - Teaspoons to Tablespoons sub function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter_teaspoons_to_tablespoons);
        activate();
        measurementConverterTeaspoonsToTablespoonsClearButton.setOnClickListener(v -> clearInputs());
        measurementConverterTeaspoonsToTablespoonsConvertButton.setOnClickListener(v -> convertMeasurement());
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        measurementConverterTeaspoonsToTablespoonsClearButton = findViewById(R.id.MeasurementConverterTeaspoonsToTablespoonsClearButton);
        measurementConverterTeaspoonsToTablespoonsConvertButton = findViewById(R.id.MeasurementConverterTeaspoonsToTablespoonsConvertButton);
        measurementConverterTeaspoonsToTablespoonsSwitch = findViewById(R.id.MeasurementConverterTeaspoonsToTablespoonsSwitch);
        measurementConverterTeaspoonsToTablespoonsInputPrompt = findViewById(R.id.MeasurementConverterTeaspoonsToTablespoonsInputPrompt);
        measurementConverterTeaspoonsToTablespoonsInput = findViewById(R.id.MeasurementConverterTeaspoonsToTablespoonsInput);
        measurementNumber = 0.00;
        finalConvertedMeasurementNumber = 0.00;
        measurementNumberText = "";
    }

    /**
     * this private void convertMeasurement() method converts a given measurement input by the user and converts them between teaspoons to tablespoons, and vice versa.
     */

    @SuppressLint("SetTextI18n") // this suppress text is here because there is nothing wrong with the text.
    private void convertMeasurement() {
        try {
            if (!measurementConverterTeaspoonsToTablespoonsSwitch.isChecked()) {
                measurementConverterTeaspoonsToTablespoonsInputPrompt.setText("Enter Tablespoons Value:");
                measurementNumberText = measurementConverterTeaspoonsToTablespoonsInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber * 3;
                @SuppressLint("DefaultLocale") // this suppress text is here because there is nothing wrong with the toast object.
                Toast toast = Toast.makeText(this, String.format("%,.2f tablespoons (tbsp) is about %,.2f teaspoons (tsp)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            else if (measurementConverterTeaspoonsToTablespoonsSwitch.isChecked()) {
                measurementConverterTeaspoonsToTablespoonsInputPrompt.setText("Enter Teaspoons Value:");
                measurementNumberText = measurementConverterTeaspoonsToTablespoonsInput.getText().toString();
                measurementNumber = Double.parseDouble(measurementNumberText);
                finalConvertedMeasurementNumber = measurementNumber / 3;
                @SuppressLint("DefaultLocale")
                Toast toast = Toast.makeText(this, String.format("%,.2f teaspoons (tsp) is about %,.2f tablespoons (tbsp)", measurementNumber, finalConvertedMeasurementNumber), Toast.LENGTH_SHORT);
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
        measurementConverterTeaspoonsToTablespoonsSwitch.setChecked(false);
        measurementConverterTeaspoonsToTablespoonsInput.getText().clear();
        measurementConverterTeaspoonsToTablespoonsInputPrompt.setText("Enter Teaspoons Value:");
    }

    /**
     * this public void teaspoonsToTablespoonsChangetoMainMenuScreen() method changes the screen to the main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void teaspoonsToTablespoonsChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

    /**
     * this public void teaspoonsToTablespoonsChangetoMeasurementConverterScreen() method changes the screen to the measurement converter screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void teaspoonsToTablespoonsChangetoMeasurementConverterScreen(View view) {
        Intent intent = new Intent(view.getContext(), MeasurementConverter.class);
        startActivity(intent);
    }

}
