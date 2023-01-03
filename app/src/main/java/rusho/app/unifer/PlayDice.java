/**
 * Name: Rusho Binnabi
 * Date: August 16th, 2021
 * Project Name: Unifer App - PlayDice Function
 * Contact Information: RushoBinnabi123@yahoo.com
 * Code File Updated: August 3rd, 2022 at 1:31 pm.
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

public class PlayDice extends AppCompatActivity {

    /**
     * this class has everything that the PlayDice part of my app needs to run.
     * this class also inherits from the AppCompatActivity class.
     */

    int randomNumber = 0; // an Integer variable called randomNumber is created and initialized to 0.
    int randomNumber2 = 0; // an Integer variable called randomNumber2 is created and initialized to 0.
    Random randomNumberGenerator = new Random(); // a Random object called randomNumberGenerator is created and initialized to a new random object.
    Button rollDiceButton; // a Button object called rollDiceButton gets created.
    Button mainMenuButton; // another Button object called mainMenuButton gets created.
    Button resetButton; // another Button object called resetButton gets created.
    ImageView diceImages; // an ImageView object called diceImages gets created.
    ImageView diceImages2; // an ImageView object called diceImages2 gets created.
    @SuppressLint("UseSwitchCompatOrMaterialCode") // this suppresses some text warnings because there was nothing wrong with the text.
    Switch oneOrTwoDicesSwitch; // a Switch object called oneOrTwoDicesSwitch gets created.

    /**
     * this onCreate() method has all the functionalities for the PlayDice function of my app to run.
     * this method also overrides the method from the AppCompatActivity class.
     * @param savedInstanceState the argument is that so the app can start from where it last left off using the savedInstanceState object from the Bundle class.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // using the super keyword, it calls the onCreate method from the AppCompatActivity class using the savedInstanceState object as the argument for the method.
        setContentView(R.layout.activity_play_dice); // sets the view of the app to the xml layout file called "activity_play_dice.xml."
        oneOrTwoDicesSwitch = findViewById(R.id.OneorTwoDiceSwitch); // oneOrTwoDicesSwitchButton gets set to the id of called OneorTwoDiceSwitch of the Switch object that makes it so that two dices get rolled instead of one if the user uses te switch.
        rollDiceButton = findViewById(R.id.RollDiceButton); // rollDiceButton gets set to the id called RollDiceButton of the Button object that rolls the dice when pressed.
        resetButton = findViewById(R.id.resetButton); // resetButton gets set to the id called resetButton of the Button object that resets all the values that are used.
        diceImages = findViewById(R.id.DiceImage); // diceImages gets set to the id called DiceImage of the ImageView object that changes the images of the dice based on randomNumber each time rollDiceButton is pressed.
        diceImages2 = findViewById(R.id.DiceImage2); // diceImages2 gets set to the id called DiceImage2 of the ImageView object that changes the images of the 2nd dice based on if the user also wants to roll a 2nd dice as well based on randomNumber2 each time rollDiceButton is pressed.
        mainMenuButton = findViewById(R.id.MainMenuButton); // mainMenuButton gets set to the id called MainMenuButton of the Button object that changes the screen to the screen based on the xml file named "activity_main.xml" that has all the functionalities of the app.
        resetButton.setOnClickListener(view -> resetValues()); // using the setOnClickListener() method of resetButton, via the lambda expression, it runs the code inside the method.
        rollDiceButton.setOnClickListener(v -> { // using the setOnClickListener() method of rollDiceButton, via the v lambda expression, it runs the code inside the method.
            if (oneOrTwoDicesSwitch.isChecked()) { // the code inside the if statement will be run if the switch is used so that two dices will be displayed instead of just 1.
                diceImages2.setVisibility(View.VISIBLE); // diceImages2 will be set visible so that the 2nd dice can be shown.
                randomNumber = 1 + randomNumberGenerator.nextInt(6); // randomNumber will have a random number between 1 and 6 generated and randomNumber will be used to determine which one of the 6 dice images will be shown using diceImages when rollDiceButton is pressed.
                randomNumber2 = 1 + randomNumberGenerator.nextInt(6); // randomNumber2 will have a random number between 1 and 6 generated and randomNumber2 will be used to determine which one of the 6 dice images will be shown using diceImages when rollDiceButton is pressed.
                toastMessage2(); // the toastMessage2() method gets called.
                switch (randomNumber) { // using the switch statement, it checks to see which number 1 through 6 got generated inside randomNumber.
                    case 1: // if randomNumber has a 1 in it.
                        diceImages.setBackgroundResource(R.drawable.die1); // sets the backgroundResource of diceImages to die1.
                        animation(); // calls the animation() method.
                        break; // breaks out of the case statement.
                    case 2: // if randomNumber has a 2 in it.
                        diceImages.setBackgroundResource(R.drawable.die2); // sets the backgroundResource of diceImages to die2.
                        animation(); // calls the animation() method.
                        break; // breaks out the case statement.
                    case 3: // if randomNumber has a 3 in it.
                        diceImages.setBackgroundResource(R.drawable.die3); // sets the backgroundResource of diceImages to die3.
                        animation(); // calls the animation() method.
                        break; // breaks out the case statement.
                    case 4: // if randomNumber has a 4 in it.
                        diceImages.setBackgroundResource(R.drawable.die4); // sets the backgroundResource of diceImages to die4.
                        animation(); // calls the animation() method.
                        break; // breaks out the case statement.
                    case 5: // if randomNumber has a 5 in it.
                        diceImages.setBackgroundResource(R.drawable.die5); // sets the backgroundResource of diceImages to die5.
                        animation(); // calls the animation() method.
                        break; // breaks out the case statement.
                    case 6: // if randomNumber has a 6 in it.
                        diceImages.setBackgroundResource(R.drawable.die6); // sets the backgroundResource of diceImages to die6.
                        animation(); // calls the animation() method.
                        break; // breaks out the case statement.
                } // the end of the switch statement.
                switch (randomNumber2) {
                    case 1: // if randomNumber2 has a 1 in it.
                        diceImages2.setBackgroundResource(R.drawable.die1); // sets the backgroundResource of diceImages2 to die1.
                        animation2(); // calls the animation2() method.
                        break; // breaks out the case statement.
                    case 2: // if randomNumber2 has a 2 in it.
                        diceImages2.setBackgroundResource(R.drawable.die2); // sets the backgroundResource of diceImages2 to die2.
                        animation2(); // calls the animation2() method.
                        break; // breaks out the case statement.
                    case 3: // if randomNumber2 has a 3 in it.
                        diceImages2.setBackgroundResource(R.drawable.die3); // sets the backgroundResource of diceImages2 to die3.
                        animation2(); // calls the animation2() method.
                        break; // breaks out the case statement.
                    case 4: // if randomNumber2 has a 4 in it.
                        diceImages2.setBackgroundResource(R.drawable.die4); // sets the backgroundResource of diceImages2 to die4.
                        animation2(); // calls the animation2() method.
                        break; // breaks out the case statement.
                    case 5: // if randomNumber2 has a 5 in it.
                        diceImages.setBackgroundResource(R.drawable.die5); // sets the backgroundResource of diceImages2 to die5.
                        animation2(); // calls the animation2() method.
                        break; // breaks out the case statement.
                    case 6: // if randomNumber2 has a 6 in it.
                        diceImages.setBackgroundResource(R.drawable.die6); // sets the backgroundResource of diceImages2 to die6.
                        animation2(); // calls the animation2() method.
                        break; // breaks out the case statement.
                } // the end of the switch statement.
            } // the end of the if statement.
            else if (!oneOrTwoDicesSwitch.isChecked()) { // the code inside the else if statement will be run if the switch is not used so that only 1 dice will be displayed instead of 2.
                Animation anim = AnimationUtils.loadAnimation(this, R.anim.custom_reverse_animation); // creates an Animation object called anim that animates the image of the 6 dices within diceImages2 and by using the this keyword which refers to the current object which is the xml file called "activity_play_dice.xml" which is also the PlayDice function of the app, it loads the animation that was created from within the "custom_animation.xml" file from the anim folder.
                diceImages2.startAnimation(anim); // using the startAnimation() method of diceImages, it starts the animation for the images of the 6 dices within diceImages2 using animation as it's argument for the startAnimation() method.
                randomNumber = 1 + randomNumberGenerator.nextInt(6); // randomNumber will have a random number between 1 and 6 generated and randomNumber will be used to determine which one of the 6 dice images will be shown using diceImages when rollDiceButton is pressed.
                toastMessage(); // the toastMessage() method gets called.
                switch (randomNumber) { // using the switch statement, it checks to see which number 1 through 6 got generated inside randomNumber.
                    case 1: // if randomNumber has a 1 in it.
                        diceImages.setBackgroundResource(R.drawable.die1); // using the setBackgroundResource() method of diceImages, it sets the image of the 6 dices to the id of the first dice from the drawable folder using diceImages.
                        animation(); // the animation() method gets called.
                        break; // it breaks out of the current case statement.
                    case 2: // if randomNumber has a 2 in it.
                        diceImages.setBackgroundResource(R.drawable.die2); // using the setBackgroundResource() method of diceImages, it sets the image of the 6 dices to the id of the second dice from the drawable folder using diceImages.
                        animation(); // the animation() method gets called.
                        break; // it breaks out of the current case statement.
                    case 3: // if randomNumber has a 3 in it.
                        diceImages.setBackgroundResource(R.drawable.die3); // using the setBackgroundResource() method of diceImages, it sets the image of the 6 dices to the id of the third dice from the drawable folder using diceImages.
                        animation(); // the animation() method gets called.
                        break; // it breaks out the current case statement.
                    case 4: // if randomNumber has a 4 in it.
                        diceImages.setBackgroundResource(R.drawable.die4); // using the setBackgroundResource() method of diceImages, it sets the image of the 6 dices to the id of the fourth dice from the drawable folder using diceImages.
                        animation(); // the animation() method gets called.
                        break; // it breaks out of the current case statement.
                    case 5: // if randomNumber has a 5 in it.
                        diceImages.setBackgroundResource(R.drawable.die5); // using the setBackgroundResource() method of diceImages, it sets the image of the 6 dices to the id of the fifth dice from the drawable folder using diceImages.
                        animation(); // the animation() method gets called.
                        break; // it breaks out of the current case statement.
                    case 6: // if randomNumber has a 6 in it.
                        diceImages.setBackgroundResource(R.drawable.die6); // using the setBackgroundResource() method of diceImages, it sets the image of the 6 dices to the id of sixth dice from the drawable folder using diceImages.
                        animation(); // the animation() method gets called.
                        break; // it breaks out of the current case statement.
                } // the end of the switch statement.
            } // the end of the else if statement.
        }); // the end of the setOnClickListener() method.
    } // the end of the OnCreate() method.

    /**
     * the toastMessage() method will create a popup toast message that says what number/face of the dice they rolled.
     * this method is private because only this class will use this method. It will not be used by any other class except this class.
     * this method is also void because it doesn't have a return value.
     */

    private void toastMessage() {
        Toast toastMessage = Toast.makeText(this, "Rolled Dice: " + randomNumber, Toast.LENGTH_SHORT); // creates a Toast message object called toastMessage and using the static makeText() method, using the this keyword which refers to the current object which is the xml file called "activity_play_dice.xml" which is also the Play Dice function of the app, it sets the text of the popup toast message that says what number/face of the dice they rolled, and it sets the length of the popup toast message to a short length.
        toastMessage.setGravity(Gravity.BOTTOM, 0, 120); // using the setGravity() method of toastMessage, it positions the toast popup text to the bottom of the screen with a xOffset of 0 and a yOffset of 120.
        toastMessage.show(); // using toastMessage, it calls the show() method which shows the popup toast text.
    } // the end of the toastMessage() method.

    private void reverseAnimation2() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.custom_reverse_animation); // creates an Animation object called anim that animates the image of the 6 dices within diceImages2 and by using the this keyword which refers to the current object which is the xml file called "activity_play_dice.xml" which is also the PlayDice function of the app, it loads the animation that was created from within the "custom_animation.xml" file from the anim folder.
        diceImages2.startAnimation(anim); // using the startAnimation() method of diceImages, it starts the animation for the images of the 6 dices within diceImages using animation as it's argument for the startAnimation() method.
    } // the end of the quickReverseAnimation() method.

    /**
     * the toastMessage2() method will create a popup toast message that says what numbers/faces of the 2 dices they rolled.
     * this method is private because only this class will use this method. It will not be used by any other class except this class.
     * this method is also void because it doesn't have a return value.
     */

    private void toastMessage2() {
        Toast toastMessage = Toast.makeText(this, "Rolled Dices: " + randomNumber + " and " + randomNumber2, Toast.LENGTH_SHORT); // creates a Toast message object called toastMessage and using the static makeText() method, using the this keyword which refers to the current object which is the xml file called "activity_play_dice.xml" which is also the Play Dice function of the app, it sets the text of the popup toast message that says what number/face of the dices they rolled, and it sets the length of the popup toast message to a short length.
        toastMessage.setGravity(Gravity.BOTTOM, 0, 120); // using the setGravity() method of toastMessage, it positions the toast popup text to the bottom of the screen with a xOffset of 0 and a yOffset of 120.
        toastMessage.show(); // using toastMessage, it calls the show() method which shows the popup toast text.
    } // the end of the toastMessage2() method.

    /**
     * this resetValues() method resets all the values of the variables.
     * this method is void because it doesn't return anything.
     */

    private void resetValues() {
        randomNumber = 0; // resets randomNumber to 0.
        randomNumber2 = 0; // resets randomNumber2 to 0.
        reverseAnimation(); // calls the reverseAnimation() method.
        reverseAnimation2(); // calls the reverseAnimation2() method.
        oneOrTwoDicesSwitch.setChecked(false); // sets the visibility of oneOrTwoDicesSwitch to false which means it's invisible.
    } // the end of the resetValues() method.

    /**
     * this animation() method animates the images of the 6 dices within diceImages.
     * this method is private is private because only this class will use this method. It will not be used by any other class except this class.
     * this method is also void because it doesn't have any return value.
     */

    private void animation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.custom_animation); // creates an Animation object called animation that animates the image of the 6 dices within diceImages and by using the this keyword which refers to the current object which is the xml file called "activity_play_dice.xml" which is also the PlayDice function of the app, it loads the animation that was created from within the "custom_animation.xml" file from the anim folder.
        diceImages.startAnimation(animation); // using the startAnimation() method of diceImages, it starts the animation for the images of the 6 dices within diceImages using animation as it's argument for the startAnimation() method.
    } // the end of the animation() method.

    /**
     * this animation2() method animates the images of the 6 dices within diceImages2.
     * this method is private is private because only this class will use this method. It will not be used by any other class except this class.
     * this method is also void because it doesn't have any return value.
     */

    private void animation2() {
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.custom_animation); // creates an Animation object called animation that animates the image of the 6 dices within diceImages2 and by using the this keyword which refers to the current object which is the xml file called "activity_play_dice.xml" which is also the PlayDice function of the app, it loads the animation that was created from within the "custom_animation.xml" file from the anim folder.
        diceImages2.startAnimation(animation2); // using the startAnimation() method of diceImages, it starts the animation for the images of the 6 dices within diceImages2 using animation as it's argument for the startAnimation() method.
    } // the end of the animation2() method.

    /**
     * this reverseAnimation() method animates the images of the 6 dices within diceImages2 in reverse.
     * this method is private is private because only this class will use this method. It will not be used by any other class except this class.
     * this method is also void because it doesn't have any return value.
     */

    private void reverseAnimation() {
        Animation reverseAnimation = AnimationUtils.loadAnimation(this, R.anim.custom_reverse_animation); // creates an Animation object called reverseAnimation that animates the image of the 6 dices within diceImages and by using the this keyword which refers to the current object which is the xml file called "activity_play_dice.xml" which is also the PlayDice function of the app, it loads the reverse animation that was created from within the "custom_reverse_animation.xml" file from the anim folder.
        diceImages.startAnimation(reverseAnimation); // using the startAnimation() method of diceImages, it starts the reverse animation for the images of the 6 dices within diceImages using animation as it's argument for the startAnimation() method.
        diceImages2.startAnimation(reverseAnimation); // using the startAnimation() method of diceImages, it starts the reverse animation for the images of the 6 dices within diceImages2 using animation as it's argument for the startAnimation() method.
    } // the end of the reverseAnimation() method.

    /**
     * this playDiceChangetoMainMenuScreen() method changes the screen to the screen layout based on the xml file called "activity_main.xml" file that has all the functionalities of the app.
     * @param view the argument called view is used so that mainMenuButton can use this method to change the screen when mainMenuButton is pressed.
     */

    public void playDiceChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class); // creates an Intent object called intent which gets the context using the getContext() method of the View object called view and the "MainActivity.class" which is the file that the screen will be changed into.
        startActivity(intent); // using the startActivity() method, it changes the screen to the "MainActivity.class" file using intent as it's argument for the startActivity() method.
    } // the end of the playDiceChangetoMainMenuScreen() method.
} // the end of the PlayDice class.