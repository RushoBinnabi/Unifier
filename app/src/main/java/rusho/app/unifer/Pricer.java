/**
 * Name: Rusho Binnabi
 * Date: August 16th, 2021
 * Project Name: Unifer App - Pricer Function
 * Contact Information: RushoBinnabi123@yahoo.com
 * Code File Updated: 4/23/2023 at 12:03 PM
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

/*
 * this class has everything that the Pricer function of my app needs to run.
 */

public class Pricer extends AppCompatActivity {

     // this class calculates final prices of items based on a given price value and any associated discount or tax value by the user.

    Button calculatePriceButton;
    Button clearInputsButton;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppress link is here because there was nothing wrong with the material of the Switch object.
    Switch switchButton;
    EditText itemPriceInput;
    EditText taxRateInput;
    EditText discountRateInput;
    String itemPriceUserInput;
    String taxRateUserInput;
    String discountRateUserInput;
    double itemPriceAmount;
    double taxRateAmount;
    double taxRate;
    double discountRate;
    double discountRateAmount;
    double finalPrice;
    double taxedMoney;
    double discountedMoney;

    /**
     * this onCreate() method has all the functionalities for the Pricer function of my app to run.
     * @param savedInstanceState the argument is that so the app can start from where it last left off using the savedInstanceState object from the Bundle class.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pricer);
        activate();
        calculatePriceButton.setOnClickListener(v -> calculatePrice());
        clearInputsButton.setOnClickListener(v -> clearInputs());
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        calculatePriceButton = findViewById(R.id.CalculatePriceButton);
        switchButton = findViewById(R.id.TaxandDiscountCalculationSwitch);
        clearInputsButton = findViewById(R.id.ClearInputsButton);
        itemPriceInput = findViewById(R.id.EnterItemPriceInputField);
        taxRateInput = findViewById(R.id.EnterTaxRateInputField);
        discountRateInput = findViewById(R.id.EnterDiscountRateInputField);
    }

    /**
     * this private void clearInputs() method is used to clear the data from the EditTexts objects, double variables, and string variables.
     */

    private void clearInputs() {
        itemPriceInput.getText().clear();
        taxRateInput.getText().clear();
        discountRateInput.getText().clear();
        itemPriceUserInput = "";
        taxRateUserInput = "";
        discountRateUserInput = "";
        itemPriceAmount = 0;
        taxRateAmount = 0;
        taxRate = 0;
        discountRate = 0;
        discountRateAmount = 0;
        finalPrice = 0;
        taxedMoney = 0;
        discountedMoney = 0;
    }

    /**
     * this private void calculatePrice() method is used to calculate the price, either with a discount or tax rate.
     */

    private void calculatePrice() {
        try {
            if (switchButton.isChecked()) { 
                itemPriceUserInput = itemPriceInput.getText().toString();
                itemPriceAmount = Double.parseDouble(itemPriceUserInput); 
                discountRateUserInput = discountRateInput.getText().toString();
                discountRateAmount = Double.parseDouble(discountRateUserInput);
                discountRate = discountRateAmount / 100;
                discountedMoney = itemPriceAmount * discountRate;
                finalPrice = itemPriceAmount - discountedMoney;
                @SuppressLint("DefaultLocale") // this suppress link is here because there was nothing wrong with the formatting of the string text.
                Toast toast = Toast.makeText(this, String.format("The final price of that item is $%,.2f", finalPrice), Toast.LENGTH_SHORT); 
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
            else if (!switchButton.isChecked()) { 
                itemPriceUserInput = itemPriceInput.getText().toString(); 
                itemPriceAmount = Double.parseDouble(itemPriceUserInput);
                taxRateUserInput = taxRateInput.getText().toString();
                taxRateAmount = Double.parseDouble(taxRateUserInput); 
                taxRate = taxRateAmount / 100; 
                taxedMoney = itemPriceAmount * taxRate;
                finalPrice = itemPriceAmount + taxedMoney;
                @SuppressLint("DefaultLocale") // this suppress link is here because there was nothing wrong with the formatting of the string text.
                Toast toast = Toast.makeText(this, String.format("The final price of that item is $%,.2f", finalPrice), Toast.LENGTH_SHORT); 
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
            }
        }
        catch (NumberFormatException n) {
            Toast toast = Toast.makeText(this, "Error. Please enter a valid price, tax rate, or discount rate.", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 120);
            toast.show();
        }
    }

    /**
     * this pricerChangetoMainMenuScreen() method changes the screen to the screen layout based on the xml file called "activity_main.xml" file that has all the functionalities of the app.
     * @param view the argument called view is used so that mainMenuButton2 can use this method to change the screen when mainMenuButton2 is pressed.
     */

    public void pricerChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }
}