/**
 * Name: Rusho Binnabi
 * Date: 4/15/2023 at 10:45 PM
 * Project: Unifier - LeetText Function
 */

package rusho.app.unifer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

/**
 * this LeetText class has all the code needed for the leet text function of my app.
 */

public class LeetText extends AppCompatActivity {

    // this class converts text entered by the user and converts it into its leetspeak equivalent.

    private EditText textInput;
    private TextView oldPlainText;
    private TextView newLeetText;
    private Button clearButton;
    private Button generateLeetTextButton;
    private String plainText;
    private String leet;
    private HashMap<Character, String> leets;

    /**
     * this getLeets() method gets the hashmap.
     * @return the hashmap.
     */

    public HashMap<Character, String> getLeets() {
        return leets;
    }

    /**
     * this setLeets() method sets the hashmap.
     */

    public void setLeets() {
        leets = new HashMap<>();
    }

    /**
     * this getTextInput() method gets the text input edit text.
     * @return the text input edit text.
     */

    public EditText getTextInput() {
        return textInput;
    }

    /**
     * this setTextInput() method sets the text input edit text.
     */

    public void setTextInput() {
        textInput = findViewById(R.id.TextInput);
    }

    /**
     * this getNewLeetText() method gets the new leet text text view.
     * @return the new leet text text view.
     */

    public TextView getNewLeetText() {
        return newLeetText;
    }

    /**
     * this setNewLeetText() method sets the new leet text text view.
     */

    public void setNewLeetText() {
        newLeetText = findViewById(R.id.NewLeetText);
    }

    /**
     * this getOldPlainText() method gets the old plain text.
     * @return the old plain text.
     */

    public TextView getOldPlainText() {
        return oldPlainText;
    }

    /**
     * this setOldPlainText() method sets the old plain text.
     */

    public void setOldPlainText() {
        oldPlainText = findViewById(R.id.OldPlainText);
    }

    /**
     * this getClearButton() method gets the clear button.
     * @return the clear button.
     */

    public Button getClearButton() {
        return clearButton;
    }

    /**
     * this setClearButton() method sets the clear button.
     */

    public void setClearButton() {
        clearButton = findViewById(R.id.ClearButton);
    }

    /**
     * this getGenerateLeetTextButton() method gets the generate leet text button.
     * @return the generate leet text button.
     */

    public Button getGenerateLeetTextButton() {
        return generateLeetTextButton;
    }

    /**
     * this setGenerateLeetTextButton() method sets the generate leet text button.
     */

    public void setGenerateLeetTextButton() {
        generateLeetTextButton = findViewById(R.id.GenerateLeetTextButton);
    }

    /**
     * this setPlainText() method sets the plain text.
     * @param string the plain text being set.
     */

    public void setPlainText(String string) {
        plainText = string;
    }

    /**
     * this getPlainText() method gets the plain text.
     * @return the plain text.
     */

    public String getPlainText() {
        return plainText;
    }

    /**
     * this setLeet() method sets the leet text.
     * @param string the leet text being set.
     */

    public void setLeet(String string) {
        leet += string;
    }

    /**
     * this getLeet() method gets the leet text.
     * @return the leet text.
     */

    public String getLeet() {
        return leet;
    }

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, has the code for the Leet Text function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leet_text);
        activate();
        getGenerateLeetTextButton().setOnClickListener(v -> getLeetText());
        getClearButton().setOnClickListener(v -> clearData());
    }

    /**
     * this private void getLeetText() method takes input from the user and converts into its leetspeak equivalent.
     */

    @SuppressLint("SetTextI18n") // suppresses some text error notifications because there was nothing wrong with the text.
    private void getLeetText() {
        try {
            setLeet(""); // clears the leetText variable so that new conversions of text won't get added on to the previously existing one.
            setPlainText(getTextInput().getText().toString());
            getOldPlainText().setText("Old Plain Text: " + getPlainText());

            setPlainText(getPlainText().toLowerCase());

            for (char c : getPlainText().toCharArray()) {
                setLeet(getLeets().get(c));
            }

            getNewLeetText().setText("New Leet Text: " + getLeet());
        }
        catch (Exception e) {
            Toast toast = Toast.makeText(this, "Error. Please enter Text", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 120);
            toast.show();
        }
    }

    /**
     * this private void activateHashMap() method reinitializes all the values of the leets HashMap so that when everything is cleared and input is re-entered,
     * it won't output null values because the HashMap wasn't initialized.
     */

    private void activateHashMap() {
        getLeets().put('a', "@");
        getLeets().put('b', "|3");
        getLeets().put('c', "(");
        getLeets().put('d', "|)");
        getLeets().put('e', "£");
        getLeets().put('f', "ƒ");
        getLeets().put('g', "&");
        getLeets().put('h', "]-[");
        getLeets().put('i', "|");
        getLeets().put('j', "_]");
        getLeets().put('k', "|<");
        getLeets().put('l', "|_");
        getLeets().put('m', "^^");
        getLeets().put('n', "И");
        getLeets().put('o', "()");
        getLeets().put('p', "|>");
        getLeets().put('q', "()_");
        getLeets().put('r', "|2");
        getLeets().put('s', "$");
        getLeets().put('t', "-|-");
        getLeets().put('u', "|_|");
        getLeets().put('v', "|/");
        getLeets().put('w', "VV");
        getLeets().put('x', "><");
        getLeets().put('y', "Ч");
        getLeets().put('z', "7_");
        getLeets().put(' ', " "); // if the conversion has a space in it.
    }

    /**
     * this private void clearData() method clears all the data from all the variables, objects, and the HashMap.
     */

    private void clearData() {
        setPlainText("");
        setLeet("");
        getLeets().clear();
        activateHashMap();
        getTextInput().getText().clear();
        getOldPlainText().setText("");
        getNewLeetText().setText("");
    }

    /**
     * this private void activate() method initializes all the variables, objects and the Hashmap.
     */

    private void activate() {
        setLeets();
        getLeets().put('a', "@");
        getLeets().put('b', "|3");
        getLeets().put('c', "(");
        getLeets().put('d', "|)");
        getLeets().put('e', "£");
        getLeets().put('f', "ƒ");
        getLeets().put('g', "&");
        getLeets().put('h', "]-[");
        getLeets().put('i', "|");
        getLeets().put('j', "_]");
        getLeets().put('k', "|<");
        getLeets().put('l', "|_");
        getLeets().put('m', "^^");
        getLeets().put('n', "И");
        getLeets().put('o', "()");
        getLeets().put('p', "|>");
        getLeets().put('q', "()_");
        getLeets().put('r', "|2");
        getLeets().put('s', "$");
        getLeets().put('t', "-|-");
        getLeets().put('u', "|_|");
        getLeets().put('v', "|/");
        getLeets().put('w', "VV");
        getLeets().put('x', "><");
        getLeets().put('y', "Ч");
        getLeets().put('z', "7_");
        getLeets().put(' ', " ");
        setTextInput();
        setOldPlainText();
        setNewLeetText();
        setClearButton();
        setGenerateLeetTextButton();
    }

    /**
     * this public void leetTextChangetoMainMenuScreen() method changes the screen to main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void leetTextChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }
}