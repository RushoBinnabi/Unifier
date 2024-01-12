/**
 * Name: Rusho Binnabi
 * Date: 4/15/2023 at 10:45 PM
 * Project: Unifier - LeetText Function
 * Code File Updated: 4/16/2023 at 10:54 PM
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

/**
 * this LeetText class has all the code needed for the leet text function of my app.
 */

public class LeetText extends AppCompatActivity {

    // this class converts text entered by the user and converts it into its leetspeak equivalent.

    EditText textInput;
    TextView oldPlainText;
    TextView newLeetText;
    Button clearButton;
    Button generateLeetTextButton;
    String plainText;
    String leetText;
    HashMap<Character, String> leets;

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, has the code for the Leet Text function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leet_text);
        activate();
        generateLeetTextButton.setOnClickListener(v -> getLeetText());
        clearButton.setOnClickListener(v -> clearData());
    }

    /**
     * this private void getLeetText() method takes input from the user and converts into its leetspeak equivalent.
     */

    @SuppressLint("SetTextI18n") // supresses some text error notifications because there was nothing wrong with the text.
    private void getLeetText() {
        try {
            plainText = textInput.getText().toString();
            oldPlainText.setText("Old Plain Text: " + plainText);

            plainText = plainText.toLowerCase();

            for (char c : plainText.toCharArray()) {
                leetText += leets.get(c);
            }

            newLeetText.setText("New Leet Text: " + leetText);
            leetText = ""; // clears the leetText variable so that new conversions of text won't get added on to the previously existing one.
        }
        catch (Exception e) {
            Toast toast = Toast.makeText(this, "Error. Please enter Text", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 120);
            toast.show();
        }
    }

    /**
     * this private void activateHashMap() method reinitializes all the values of the leets HashMap so that when everything is cleared and input is re-enterred, 
     * it won't output null values because the HashMap wasn't initialized.
     */

    private void activateHashMap() {
        leets.put('a', "@");
        leets.put('b', "|3");
        leets.put('c', "(");
        leets.put('d', "|)");
        leets.put('e', "£");
        leets.put('f', "ƒ");
        leets.put('g', "&");
        leets.put('h', "]-[");
        leets.put('i', "|");
        leets.put('j', "_]");
        leets.put('k', "|<");
        leets.put('l', "|_");
        leets.put('m', "^^");
        leets.put('n', "И");
        leets.put('o', "()");
        leets.put('p', "|>");
        leets.put('q', "()_");
        leets.put('r', "|2");
        leets.put('s', "$");
        leets.put('t', "-|-");
        leets.put('u', "|_|");
        leets.put('v', "|/");
        leets.put('w', "VV");
        leets.put('x', "><");
        leets.put('y', "Ч");
        leets.put('z', "7_");
        leets.put(' ', " "); // if the conversion has a space in it.
    }

    /**
     * this private void clearData() method clears all the data from all the variables, objects, and the HashMap.
     */

    private void clearData() {
        plainText = "";
        leetText = "";
        leets.clear();
        activateHashMap();
        textInput.getText().clear();
        oldPlainText.setText("");
        newLeetText.setText("");
    }

    /**
     * this private void activate() method initializes all the variables, objects, and the Hashmap.
     */

    private void activate() {
        leets = new HashMap<>();
        leets.put('a', "@");
        leets.put('b', "|3");
        leets.put('c', "(");
        leets.put('d', "|)");
        leets.put('e', "£");
        leets.put('f', "ƒ");
        leets.put('g', "&");
        leets.put('h', "]-[");
        leets.put('i', "|");
        leets.put('j', "_]");
        leets.put('k', "|<");
        leets.put('l', "|_");
        leets.put('m', "^^");
        leets.put('n', "И");
        leets.put('o', "()");
        leets.put('p', "|>");
        leets.put('q', "()_");
        leets.put('r', "|2");
        leets.put('s', "$");
        leets.put('t', "-|-");
        leets.put('u', "|_|");
        leets.put('v', "|/");
        leets.put('w', "VV");
        leets.put('x', "><");
        leets.put('y', "Ч");
        leets.put('z', "7_");
        leets.put(' ', " ");
        textInput = findViewById(R.id.TextInput);
        oldPlainText = findViewById(R.id.OldPlainText);
        newLeetText = findViewById(R.id.NewLeetText);
        clearButton = findViewById(R.id.ClearButton);
        generateLeetTextButton = findViewById(R.id.GenerateLeetTextButton);
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