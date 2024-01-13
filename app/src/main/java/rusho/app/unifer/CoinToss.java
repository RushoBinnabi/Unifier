/**
 * Name: Rusho Binnabi
 * Date: 4/15/2023 at 11:01 PM
 * Project: Unifier - LeetText Function
 */

package rusho.app.unifer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

/**
 * this CoinToss class has all the code needed for the coin toss function of my app.
 */

public class CoinToss extends AppCompatActivity {

    // this class simulates a coin toss.

    private Button resetCoinTossButton;
    private Button tossCoinButton;
    private Random randomNumberGenerator;
    private ImageView coinImage;
    private int randomNumber;
    private Coins coin;

    /**
     * this setTossCoinButton() method sets the toss coin button.
     */

    public void setTossCoinButton() {
        tossCoinButton = findViewById(R.id.tossCoinButton);
    }

    /**
     * this getTossCoinButton() method gets the toss coin button.
     * @return the toss coin button.
     */

    public Button getTossCoinButton() {
        return tossCoinButton;
    }

    /**
     * this setResetCoinTossButton() method sets the reset coin toss button.
     */

    public void setResetCoinTossButton() {
        resetCoinTossButton = findViewById(R.id.coinTossResetButton);
    }

    /**
     * this getResetCoinTossButton() method gets the reset coin toss button.
     * @return the reset coin toss button.
     */

    public Button getResetCoinTossButton() {
        return resetCoinTossButton;
    }

    /**
     * this setRandomNumberGenerator() method sets the random number generator.
     */

    public void setRandomNumberGenerator() {
        randomNumberGenerator = new Random();
    }

    /**
     * this getRandomNumberGenerator() method gets the random number generator.
     * @return the random number generator.
     */

    public Random getRandomNumberGenerator() {
        return randomNumberGenerator;
    }

    /**
     * this getCoinImage() method gets the coin image.
     * @return the coin image.
     */

    public ImageView getCoinImage() {
        return coinImage;
    }

    /**
     * this setCoinImage() method sets the coin image.
     */

    public void setCoinImage() {
        coinImage = findViewById(R.id.coinImage);
    }

    /**
     * this getRandomNumber() method gets the random number.
     * @return the random number.
     */

    public int getRandomNumber() {
        return randomNumber;
    }

    /**
     * this setRandomNumber() method sets the random number.
     * @param i the random number being set.
     */

    public void setRandomNumber(int i) {
        randomNumber = i;
    }

    /**
     * this getCoinType() method gets the Coins enum type.
     * @return the Coins enum type as a string.
     */

    public String getCoinType() {
        return coin.name();
    }

    /**
     * this setCoinType() method sets the Coins enum type.
     * @param coin the Coins enum type being set.
     */

    public void setCoinType(Coins coin) {
        this.coin = coin;
    }

    /**
     * this enum Coins will have the two values of either side of a coin and will be used to show what side of the coin it got tossed on in the tossCoin() method.
     */

    enum Coins {
        HEADS,
        TAILS
    }

    /**
     * this protected onCreate() method, which uses the Bundle savedInstanceObject as its argument, has the code for the Coin Toss function that the Unifier app needs to function.
     * @param savedInstanceState the argument is the bundle object that makes it so the app starts off where it last left off.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_toss);
        activate();
        getResetCoinTossButton().setOnClickListener(v -> resetCoinTossValues());
        getTossCoinButton().setOnClickListener(v -> tossCoin());
    }

    /**
     * this private void activate() method initializes all the variables and objects.
     */

    private void activate() {
        setRandomNumber(0);
        setCoinImage();
        setRandomNumberGenerator();
        setTossCoinButton();
        setResetCoinTossButton();
    }

    /**
     * this private void tossCoin() method simulates a coin toss.
     */

    private void tossCoin() {
        setRandomNumber(1 + getRandomNumberGenerator().nextInt(2));
        switch (getRandomNumber()) {
            case 1:
                setCoinType(Coins.HEADS);
                Toast toast = Toast.makeText(this, "Coin Toss: " + getCoinType(), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.show();
                getCoinImage().setBackgroundResource(R.drawable.coinhead); // sets the image to the head side of the coin toss first before animating it so it doesn't animate an empty imageview object.
                animation();
                break;
            case 2:
                setCoinType(Coins.TAILS);
                Toast toast2 = Toast.makeText(this, "Coin Toss: " + getCoinType(), Toast.LENGTH_SHORT);
                toast2.setGravity(Gravity.BOTTOM, 0, 120);
                toast2.show();
                getCoinImage().setBackgroundResource(R.drawable.cointail); // sets the image to the tail side of the coin toss first before animating it so it doesn't animate an empty imageview object.
                animation();
                break;
        }
    }

    /**
     * this private void resetCoinTossValues() method clears all the data from all the variables and objects.
     */

    private void resetCoinTossValues() {
        setRandomNumber(0);
        reverseAnimation();
    }

    /**
     * this private void animation() method animates the coin toss.
     */

    private void animation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.custom_animation_coin_toss);
        getCoinImage().startAnimation(animation);
    }

    /**
     * this private void reverseAnimation() method animates the coin toss in reverse when everything is reset.
     */

    private void reverseAnimation() {
        Animation reverseAnimation = AnimationUtils.loadAnimation(this, R.anim.custom_reverse_animation_coin_toss);
        getCoinImage().startAnimation(reverseAnimation);
    }

    /**
     * this public void leetTextChangetoMainMenuScreen() method changes the screen to main menu screen of the app.
     * @param view the view is the screen of the app being changed.
     */

    public void coinTossChangetoMainMenuScreen(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

}
