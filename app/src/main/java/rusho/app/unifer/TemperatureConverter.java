/**
 * Name: Rusho Binnabi
 * Date: August 16th, 2021
 * Project Name: Unifer App - Temperature Converter Function
 * Contact Information: RushoBinnabi123@yahoo.com
 * Code File Updated: September 19th, 2021 at 1:57pm.
 */

package rusho.app.unifer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class TemperatureConverter extends AppCompatActivity {

    /**
     * this class has everything that the temperature converter part of my app needs to run.
     * this class also inherits from the AppCompatActivity class.
     */

    Button mainMenuButton3; // a Button object called mainMenuButton3 gets created.
    Button convertTemperatureButton; // a Button object called convertTemperatureButton gets created.
    Button clearTemperatureInputButton; // a Button object called clearTemperatureButton gets created.
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress link is here because there was nothing wrong with the material of the Switch object.
    Switch temperatureConversionSwitch; // a Switch object called temperatureConversionSwitch gets created.
    EditText temperatureInput; // an EditText object called temperatureInput gets created.
    String userTemperatureInput; // a String variable called userTemperatureInput gets created.
    double userTemperature = 0; //  a Double variable called userTemperature gets created and initialized to 0.
    double fahrenheit = 0; // a Double variable called fahrenheit gets created and initialized to 0.
    double celsius = 0; // a Double variable called celsius gets created and initialized to 0.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // using the super keyword, it calls the onCreate method from the AppCompatActivity class using the savedInstanceState object as the argument for the method.
        setContentView(R.layout.activity_temperature_converter); // sets the view of the app to the xml layout file called "activity_temperature_converter.xml."
        mainMenuButton3 = findViewById(R.id.MainMenuButton3); // mainMenuButton3 gets to the id called MainMenuButton3 of the Button object that changes the screen to the screen based on the xml file named "activity_main.xml" that has all the functionalities of the app.
        convertTemperatureButton = findViewById(R.id.ConvertTemperatureButton); // convertTemperatureButton gets set to the id called ConvertTemperatureButton of the Button object that shows the converted temperature everytime convertTemperatureButton is pressed and the converted temperature will be based on the temperature that was entered using temperatureInput and whether that temperature was a fahrenheit or celsius.
        temperatureConversionSwitch = findViewById(R.id.TemperatureConversionSwitch); // temperatureConversionSwitch gets set to the id called TemperatureConversionSwitch of the Switch object that determines whether the temperature conversion will be in either fahrenheit or celsius.
        temperatureInput = findViewById(R.id.TemperatureInput); // temperatureInput gets set to the id called TemperatureInput of the EditText object that will be used to get the user input which is the temperature that will be converted into either fahrenheit or celsius.
        clearTemperatureInputButton = findViewById(R.id.ClearTemperatureInputButton); // clearTemperatureInputButton gets set to the id of the Button object that when pressed will clear the data from fahrenheit, celsius, userTemperature, userTemperatureInput, and temperatureInput.
        convertTemperatureButton.setOnClickListener(v -> convertTemperature()); // using the setOnClickListener() method of convertTemperatureButton, via the lambda expression v, it calls the convertTemperature() method.
        clearTemperatureInputButton.setOnClickListener(v -> clearTemperatureInput()); // using the setOnClickListener() method of clearTemperatureInputButton, via the lambda expression v, it calls the clearTemperatureInput() method.
    }

    /**
     * the convertTemperature() method will be used to do the temperature conversion everytime the convertTemperatureButton is pressed.
     * this method is private because only this class will use this method. It will not be used by any other class except this class.
     * this method is also void because it doesn't have a return value.
     */

    private void convertTemperature() {
        if (temperatureConversionSwitch.isChecked()) { // if temperatureConversionSwitch is checked which allows for celsius temperature conversion then it runs the code inside the if statement.
            try { // the code inside the try statement gets run.
                userTemperatureInput = temperatureInput.getText().toString(); // userTemperatureInput gets the user input from temperatureInput as a string.
                userTemperature = Double.parseDouble(userTemperatureInput); // userTemperature will have the string temperature value from userTemperatureInput as a double.
                celsius = (userTemperature - 32) / 1.8; // celsius will have the converted temperature as a celsius temperature using the formula and userTemperature.
                @SuppressLint("DefaultLocale") // this suppress link is here because there was nothing wrong with the formatting of the string text.
                Toast toast = Toast.makeText(this, String.format("The Temperature Conversion is %,.2f °C", celsius), Toast.LENGTH_SHORT); // creates a Toast object called toast and using the static makeText() method, using the this keyword which refers to the current object which is the xml file called "activity_temperature_converter.xml" which is also the Temperature Converter function of the app, it sets the text of the popup toast message to celsius and formatted to 2 decimal places and it sets the length of the popup toast message to a short length.
                toast.setGravity(Gravity.BOTTOM, 0, 120); // using the setGravity() method of toast, it positions the toast popup text to the bottom of the screen with a xOffset of 0 and a yOffset of 120.
                toast.show(); // using toast, it calls the show() method which shows the popup toast text.
            }
            catch (NumberFormatException n) { // if temperatureInput has anything but a number, then it runs the code inside the catch statement.
                Toast toast = Toast.makeText(this, "Error. Please enter a valid number.", Toast.LENGTH_SHORT); // creates a Toast object called toast and using the static makeText() method, using the this keyword which refers to the current object which is the xml file called "activity_temperature_converter.xml" which is also the Temperature Converter function of the app, it sets the text of the popup toast message to what the error is and what to do to prevent the error from happening again and it sets the length of the popup toast message to a short length.
                toast.setGravity(Gravity.BOTTOM, 0, 120); // using the setGravity() method of toast, it positions the toast popup text to the bottom of the screen with a xOffset of 0 and a yOffset of 120.
                toast.show(); // using toast, it calls the show() method which shows the popup toast text.
            }
        }
        else if (!temperatureConversionSwitch.isChecked()) { // if temperatureConversionSwitch is not checked which allows for fahrenheit temperature conversion then it runs the code inside the else if statement.
            try { // the code inside the try statement gets run.
                userTemperatureInput = temperatureInput.getText().toString(); // userTemperatureInput gets the user input from temperatureInput as a string.
                userTemperature = Double.parseDouble(userTemperatureInput); // userTemperature will have the string temperature value from userTemperatureInput as a double.
                fahrenheit = (userTemperature * 1.8) + 32; // fahrenheit will have the converted temperature as a fahrenheit temperature using the formula and userTemperature.
                @SuppressLint("DefaultLocale") // this suppress link is here because there was nothing wrong with the formatting of the string text.
                Toast toast = Toast.makeText(this, String.format("The Temperature Conversion is %,.2f °F", fahrenheit), Toast.LENGTH_SHORT); // creates a Toast object called toast and using the static makeText() method, using the this keyword which refers to the current object which is the xml file called "activity_temperature_converter.xml" which is also the Temperature Converter function of the app, it sets the text of the popup toast message to fahrenheit and formatted to 2 decimal places and it sets the length of the popup toast message to a short length.
                toast.setGravity(Gravity.BOTTOM, 0, 120); // using the setGravity() method of toastMessage, it positions the toast popup text to the bottom of the screen with a xOffset of 0 and a yOffset of 120.
                toast.show(); // using toastMessage, it calls the show() method which shows the popup toast text.
            }
            catch (NumberFormatException n) { // if temperatureInput has anything but a number, then it runs the code inside the catch statement.
                Toast toast = Toast.makeText(this, "Error. Please enter a valid number.", Toast.LENGTH_SHORT); // creates a Toast object called toast and using the static makeText() method, using the this keyword which refers to the current object which is the xml file called "activity_temperature_converter.xml" which is also the Temperature Converter function of the app, it sets the text of the popup toast message to what the error is and what to do to prevent the error from happening again and it sets the length of the popup toast message to a short length.
                toast.setGravity(Gravity.BOTTOM, 0, 120); // using the setGravity() method of toast, it positions the toast popup text to the bottom of the screen with a xOffset of 0 and a yOffset of 120.
                toast.show(); // using toast, it calls the show() method which shows the popup toast text.
            }
        }
    }

    /**
     * the clearTemperatureInput() method is used to clear the data from temperatureInput, userTemperatureInput, userTemperature, fahrenheit, celsius.
     */

    private void clearTemperatureInput() {
        temperatureInput.getText().clear(); // clears the text from temperatureInput.
        userTemperatureInput = ""; // clears the text from the userTemperatureInput.
        userTemperature = 0; // resets userTemperature to 0.
        fahrenheit = 0; // resets fahrenheit to 0.
        celsius = 0; // resets celsius to 0.
    }

    /**
     * this temperatureConverterChangetoMainMenuScreen() method changes the screen to the screen layout based on the xml file called "activity_main.xml" file that has all the functionalities of the app.
     * @param view the argument called view is used so that mainMenuButton3 can use this method to change the screen when mainMenuButton3 is pressed.
     */

    public void temperatureConverterChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class); // creates an Intent object called intent which gets the context using the getContext() method of the View object called view and the "MainActivity.class" which is the file that the screen will be changed into.
        startActivity(intent); // using the startActivity() method, it changes the screen to the "MainActivity.class" file using intent as it's argument for the startActivity() method.
    }
}