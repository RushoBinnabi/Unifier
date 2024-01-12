/**
 * Name: Rusho Binnabi
 * Date: August 16th, 2021
 * Project Name: Unifer App - PlayDice Function
 * Contact Information: RushoBinnabi123@yahoo.com
 * Code File Updated: 4/17/2023 at 7:34 AM
 */

package rusho.app.unifer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Random;

/*
 * this class has everything that the PlayDice part of my app needs to run.
 */

public class PlayDice extends AppCompatActivity {

     // this class simulates the rolling of one or two dices based on what the user wants.

    int randomNumber;
    int randomNumber2;
    Random randomNumberGenerator;
    Button rollDiceButton;
    Button resetButton;
    ImageView diceImages;
    ImageView diceImages2;
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppresses some text warnings because there was nothing wrong with the text.
    Switch oneOrTwoDicesSwitch;

    /**
     * this onCreate() method has all the functionalities for the PlayDice function of my app to run.
     * this method also overrides the method from the AppCompatActivity class.
     * @param savedInstanceState the argument is that so the app can start from where it last left off using the savedInstanceState object from the Bundle class.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_play_dice); 
        activate();
        resetButton.setOnClickListener(v -> resetValues());
        rollDiceButton.setOnClickListener(v -> rollDice());
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        randomNumber = 0;
        randomNumber2 = 0;
        randomNumberGenerator = new Random();
        oneOrTwoDicesSwitch = findViewById(R.id.OneorTwoDiceSwitch);
        rollDiceButton = findViewById(R.id.RollDiceButton);
        resetButton = findViewById(R.id.resetButton);
        diceImages = findViewById(R.id.DiceImage);
        diceImages2 = findViewById(R.id.DiceImage2); 
    }

    /**
     * this private void rollDice() method rolls either one or both of the dices.
     */

    private void rollDice() {
        if (oneOrTwoDicesSwitch.isChecked()) {
            diceImages2.setVisibility(View.VISIBLE);
            randomNumber = 1 + randomNumberGenerator.nextInt(6);
            randomNumber2 = 1 + randomNumberGenerator.nextInt(6);
            toastMessage2();
            switch (randomNumber) {
                case 1:
                    diceImages.setBackgroundResource(R.drawable.die1);
                    animation();
                    break;
                case 2:
                    diceImages.setBackgroundResource(R.drawable.die2);
                    animation();
                    break;
                case 3:
                    diceImages.setBackgroundResource(R.drawable.die3);
                    animation();
                    break;
                case 4:
                    diceImages.setBackgroundResource(R.drawable.die4);
                    animation();
                    break;
                case 5:
                    diceImages.setBackgroundResource(R.drawable.die5);
                    animation();
                    break;
                case 6:
                    diceImages.setBackgroundResource(R.drawable.die6);
                    animation();
                    break;
            }
            switch (randomNumber2) {
                case 1:
                    diceImages2.setBackgroundResource(R.drawable.die1);
                    animation2();
                    break;
                case 2:
                    diceImages2.setBackgroundResource(R.drawable.die2);
                    animation2();
                    break;
                case 3:
                    diceImages2.setBackgroundResource(R.drawable.die3);
                    animation2();
                    break; 
                case 4: 
                    diceImages2.setBackgroundResource(R.drawable.die4); 
                    animation2(); 
                    break;
                case 5:
                    diceImages.setBackgroundResource(R.drawable.die5);
                    animation2(); 
                    break; 
                case 6: 
                    diceImages.setBackgroundResource(R.drawable.die6); 
                    animation2(); 
                    break; 
            }
        } 
        else if (!oneOrTwoDicesSwitch.isChecked()) { 
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.custom_reverse_animation); // loads the reverse animation for the 2nd dice.
            diceImages2.startAnimation(anim); // applies the reverse animation to the 2nd dice.
            randomNumber = 1 + randomNumberGenerator.nextInt(6);
            toastMessage();
            switch (randomNumber) { 
                case 1:
                    diceImages.setBackgroundResource(R.drawable.die1);
                    animation();
                    break;
                case 2:
                    diceImages.setBackgroundResource(R.drawable.die2); 
                    animation();
                    break;
                case 3:
                    diceImages.setBackgroundResource(R.drawable.die3);
                    animation();
                    break;
                case 4:
                    diceImages.setBackgroundResource(R.drawable.die4);
                    animation();
                    break; 
                case 5:
                    diceImages.setBackgroundResource(R.drawable.die5);
                    animation(); 
                    break; 
                case 6:
                    diceImages.setBackgroundResource(R.drawable.die6); 
                    animation();
                    break; 
            } 
        }
    }

    /**
     * this private void toastMessage() method will create a popup toast message that says what number/face of the dice they rolled.
     */

    private void toastMessage() {
        Toast toastMessage = Toast.makeText(this, "Rolled Dice: " + randomNumber, Toast.LENGTH_SHORT);
        toastMessage.setGravity(Gravity.BOTTOM, 0, 120);
        toastMessage.show();
    }

    /**
     * this private void reverseAnimation2() method animates the images of the 6 dices within diceImages2 in reverse.
     */

    private void reverseAnimation2() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.custom_reverse_animation); 
        diceImages2.startAnimation(anim); 
    }

    /**
     * this private void toastMessage2() method will create a popup toast message that says what numbers/faces of the 2 dices they rolled.
     */

    private void toastMessage2() {
        Toast toastMessage = Toast.makeText(this, "Rolled Dices: " + randomNumber + " and " + randomNumber2, Toast.LENGTH_SHORT);
        toastMessage.setGravity(Gravity.BOTTOM, 0, 120);
        toastMessage.show();
    }

    /**
     * this private void resetValues() method resets all the values of the variables.
     */

    private void resetValues() {
        randomNumber = 0;
        randomNumber2 = 0;
        reverseAnimation();
        reverseAnimation2();
        oneOrTwoDicesSwitch.setChecked(false);
    }

    /**
     * this private void animation() method animates the images of the 6 dices within diceImages.
     */

    private void animation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.custom_animation);
        diceImages.startAnimation(animation); 
    }

    /**
     * this private void animation2() method animates the images of the 6 dices within diceImages2.
     */

    private void animation2() {
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.custom_animation);
        diceImages2.startAnimation(animation2);
    }

    /**
     * this private void reverseAnimation() method animates the images of the 6 dices within diceImages2 in reverse.
     */

    private void reverseAnimation() {
        Animation reverseAnimation = AnimationUtils.loadAnimation(this, R.anim.custom_reverse_animation);
        diceImages.startAnimation(reverseAnimation);
        diceImages2.startAnimation(reverseAnimation);
    }

    /**
     * this playDiceChangetoMainMenuScreen() method changes the screen to the screen layout based on the xml file called "activity_main.xml" file that has all the functionalities of the app.
     * @param view the argument called view is used so that mainMenuButton can use this method to change the screen when mainMenuButton is pressed.
     */

    public void playDiceChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    } 
}