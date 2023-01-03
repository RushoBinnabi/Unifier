/**
 * Name: Rusho Binnabi
 * Date: August 16th, 2021
 * Project Name: Unifer App - Pricer Function
 * Contact Information: RushoBinnabi123@yahoo.com
 * Code File Updated: September 19th, 2021 at 1:58pm.
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

public class Pricer extends AppCompatActivity {

    /**
     * this class has everything that the Pricer part of my app needs to run.
     * this class also inherits from the AppCompatActivity class.
     */

    Button mainMenuButton2; // a Button object called mainMenuButton2 gets created.
    Button calculatePriceButton; // a Button object called calculatePriceButton gets created.
    Button clearInputsButton; // a Button object called clearInputsButton gets created.
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress link is here because there was nothing wrong with the material of the Switch object.
    Switch switchButton; // a Switch object called switchButton gets created.
    EditText itemPriceInput; // an EditText called itemPriceInput gets created.
    EditText taxRateInput; // an EditText called taxRateInput gets created.
    EditText discountRateInput; // an EditText called discountRateInput gets created.
    String itemPriceUserInput; // a String variable called itemPriceUserInput gets created.
    String taxRateUserInput; // a String object called taxRateUserInput gets created.
    String discountRateUserInput; // a String object called discountRateUserInput gets created.
    double itemPriceAmount; // a double variable called itemPriceAmount gets created.
    double taxRateAmount; // a double variable called taxRateAmount gets created.
    double taxRate; // a double variable called taxRate gets created.
    double discountRate; // a double variable called discountRate gets created.
    double discountRateAmount; // a double variable called discountRateAmount gets created.
    double finalPrice; // a double variable called finalPrice gets created.
    double taxedMoney; // a double variable called taxedMoney gets created.
    double discountedMoney; // a double variable called discountedMoney gets created.

    /**
     * this onCreate() method has all the functionalities for the Pricer function of my app to run.
     * this method also overrides the method from the AppCompatActivity class.
     * @param savedInstanceState the argument is that so the app can start from where it last left off using the savedInstanceState object from the Bundle class.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // using the super keyword, it calls the onCreate method from the AppCompatActivity class using the savedInstanceState object as the argument for the method.
        setContentView(R.layout.activity_pricer); // sets the view of the app to the xml layout file called "activity_pricer.xml."
        mainMenuButton2 = findViewById(R.id.MainMenuButton2); // mainMenuButton2 gets set to the id called MainMenuButton2 of the Button object that changes the screen to the screen based on the xml file named "activity_main.xml" that has all the functionalities of the app.
        calculatePriceButton = findViewById(R.id.CalculatePriceButton); // calculatePriceButton gets set to the id called CalculatePriceButton of the Button object that calculates the price when pressed.
        switchButton = findViewById(R.id.TaxandDiscountCalculationSwitch); // switchButton gets set to the id called TaxandDiscountCalculationSwitch that will be used to determine whether the calculation will be for tax or discount.
        clearInputsButton = findViewById(R.id.ClearInputsButton); // clearInputsButton gets set to the id called ClearInputsButton that will be used to clear all the data from all the double variables, EditTexts, and string variables.
        itemPriceInput = findViewById(R.id.EnterItemPriceInputField); // itemPriceInput gets set to the id called EnterItemPriceInputField that will be used to enter the price amount as user input.
        taxRateInput = findViewById(R.id.EnterTaxRateInputField); // taxRateInput gets set to the id called EnterTaxRateInputField that will be used to enter the tax rate as user input.
        discountRateInput = findViewById(R.id.EnterDiscountRateInputField); // discountRateInput gets set to the id called EnterDiscountRateInputField that will be used to enter the discount rate as user input.
        calculatePriceButton.setOnClickListener(v -> calculatePrice()); // using the setOnClickListener() method of calculatePriceButton, the calculatePrice() method gets called.
        clearInputsButton.setOnClickListener(v -> clearInputs()); // using the setOnClickListener() method of clearInputsButton, it calls the clearInputs() method gets called.
    }

    /**
     * the clearInputs() method is used to clear the data from the EditTexts objects, double variables, and string variables.
     */

    private void clearInputs() {
        itemPriceInput.getText().clear(); // clears the data from itemPriceInput.
        taxRateInput.getText().clear(); // clears the data from taxRateInput.
        discountRateInput.getText().clear(); // clears the data from discountRateInput.
        itemPriceUserInput = ""; // clears the data from itemPriceUserInput.
        taxRateUserInput = ""; // clears the data from taxRateUserInput.
        discountRateUserInput = ""; // clears the data from discountRateUserInput.
        itemPriceAmount = 0; // resets itemPriceAmount to 0.
        taxRateAmount = 0; // resets taxRateAmount to 0.
        taxRate = 0; // resets taxRate to 0.
        discountRate = 0; // resets discountRate to 0.
        discountRateAmount = 0; // resets discountRateAmount to 0.
        finalPrice = 0; // resets finalPrice to 0.
        taxedMoney = 0; // resets taxedMoney to 0.
        discountedMoney = 0; // resets discountedMoney to 0.
    }

    /**
     * this calculatePrice() method is used to calculate the price, either with a discount or tax rate.
     */

    private void calculatePrice() {
        try { // the code inside the try block gets run.
            if (switchButton.isChecked()) { // if switchButton is checked which allows for discounted price calculations then it runs the code inside the if statement.
                itemPriceUserInput = itemPriceInput.getText().toString(); // itemPriceUserInput gets the user input from itemPriceInput as a string.
                itemPriceAmount = Double.parseDouble(itemPriceUserInput); // itemPriceAmount will have the string discount rate amount from itemPriceUserInput as a double.
                discountRateUserInput = discountRateInput.getText().toString(); // discountRateUserInput gets the user input from discountRateInput as a string.
                discountRateAmount = Double.parseDouble(discountRateUserInput); // discountRateAmount will have the string discount rate amount from discountRateUserInput as a double.
                discountRate = discountRateAmount / 100; // discountRate will have the value of discountRateAmount divided by 100 which is the discount rate.
                discountedMoney = itemPriceAmount * discountRate; // discountedMoney will have the value of itemPriceAmount multiplied by discountRate which will be the amount that the item will be on discount for.
                finalPrice = itemPriceAmount - discountedMoney; // finalPrice will have the value of itemPriceAmount subtracted by discountedMoney which is the final discounted price of the item.
                @SuppressLint("DefaultLocale") // this suppress link is here because there was nothing wrong with the formatting of the string text.
                Toast toast = Toast.makeText(this, String.format("The final price of that item is $%,.2f", finalPrice), Toast.LENGTH_SHORT); // creates a Toast object called toast and using the static makeText() method, using the this keyword which refers to the current object which is the xml file called "activity_pricer.xml" which is also the Pricer function of the app, it sets the text of the popup toast message to finalPrice and formatted to 2 decimal places and it sets the length of the popup toast message to a short length.
                toast.setGravity(Gravity.BOTTOM, 0, 120); // using the setGravity() method of toast, it positions the toast popup text to the bottom of the screen with a xOffset of 0 and a yOffset of 120.
                toast.show(); // using toast, it calls the show() method which shows the popup toast text.
            }
            else if (!switchButton.isChecked()) { // if switchButton is not checked which allows for taxed price calculations then it runs the code inside the else if statement.
                itemPriceUserInput = itemPriceInput.getText().toString(); // itemPriceUserInput gets the user input from itemPriceInput as a string.
                itemPriceAmount = Double.parseDouble(itemPriceUserInput); // itemPriceAmount will have the string item price from itemPriceUserInput as a double.
                taxRateUserInput = taxRateInput.getText().toString(); // taxRateUserInput gets the user input from taxRateInput as a string.
                taxRateAmount = Double.parseDouble(taxRateUserInput); // taxRateAmount will have the string tax rate amount from taxRateUserInput as a double.
                taxRate = taxRateAmount / 100; // taxRate will have the value of taxRateAmount divided by 100 which is the tax rate.
                taxedMoney = itemPriceAmount * taxRate; // taxedMoney will have the value of itemPriceAmount multiplied by taxRate which will be the amount that the item will be taxed for.
                finalPrice = itemPriceAmount + taxedMoney; // finalPrice will have the value of itemPriceAmount added with taxedMoney which is the final taxed price of the item.
                @SuppressLint("DefaultLocale") // this suppress link is here because there was nothing wrong with the formatting of the string text.
                Toast toast = Toast.makeText(this, String.format("The final price of that item is $%,.2f", finalPrice), Toast.LENGTH_SHORT); // creates a Toast object called toast and using the static makeText() method, using the this keyword which refers to the current object which is the xml file called "activity_pricer.xml" which is also the Pricer function of the app, it sets the text of the popup toast message to finalPrice and formatted to 2 decimal places and it sets the length of the popup toast message to a short length.
                toast.setGravity(Gravity.BOTTOM, 0, 120); // using the setGravity() method of toast, it positions the toast popup text to the bottom of the screen with a xOffset of 0 and a yOffset of 120.
                toast.show(); // using toast, it calls the show() method which shows the popup toast text.
            }
        }
        catch (NumberFormatException n) { // if itemPriceUserInput has anything but a number, then it runs the code inside the catch statement.
            Toast toast = Toast.makeText(this, "Error. Please enter a valid price, tax rate, or discount rate.", Toast.LENGTH_SHORT); // creates a Toast object called toast and using the static makeText() method, using the this keyword which refers to the current object which is the xml file called "activity_pricer.xml" which is also the Pricer function of the app, it sets the text of the popup toast message to what the error is and what to do to prevent the error from happening again and it sets the length of the popup toast message to a short length.
            toast.setGravity(Gravity.BOTTOM, 0, 120); // using the setGravity() method of toast, it positions the toast popup text to the bottom of the screen with a xOffset of 0 and a yOffset of 120.
            toast.show(); // using toast, it calls the show() method which shows the popup toast text.
        }
    }

    /**
     * this pricerChangetoMainMenuScreen() method changes the screen to the screen layout based on the xml file called "activity_main.xml" file that has all the functionalities of the app.
     * @param view the argument called view is used so that mainMenuButton2 can use this method to change the screen when mainMenuButton2 is pressed.
     */

    public void pricerChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class); // creates a new Intent object called intent which gets the context using the getContext() method of the View object called view and the "MainActivity.class" which is the file that the screen will be changed into.
        startActivity(intent); // using the startActivity() method, it changes the screen to the "MainActivity.class" file using intent as it's argument for the startActivity() method.
    }
}