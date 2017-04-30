package id.co.blogspot.wimsonevel.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private int quantity = 2;
    private boolean isWhippedCream = false;
    private boolean isChocolate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        displayPrice(10 * quantity);
    }

    public void increment(View view) {
        if(quantity == 10) {
            return;
        }

        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity == 0) {
            return;
        }

        quantity = quantity - 1;
        display(quantity);
    }

    public void display(int number) {
        TextView tvValue = (TextView) findViewById(R.id.value);
        tvValue.setText("" + number);
    }

    public void displayPrice(int number) {
        EditText textNama = (EditText) findViewById(R.id.name);
        CheckBox cbWhippedCream = (CheckBox) findViewById(R.id.cb_cream);
        CheckBox cbChocolate = (CheckBox) findViewById(R.id.cb_chocolate);

        isWhippedCream = cbWhippedCream.isChecked();
        isChocolate = cbChocolate.isChecked();

        if(isWhippedCream) {
            number = number + 1;
        }

        if(isChocolate) {
            number = number + 2;
        }

        TextView tvTotal = (TextView) findViewById(R.id.total);
        tvTotal.setText("Name : " + textNama.getText() + "\n" +
                "Add Whipped Cream : " + isWhippedCream + "\n" +
                "Add Chocolate : " + isChocolate + "\n" +
                "Quantity : " + quantity + "\n" +
                "Total : " + NumberFormat.getCurrencyInstance().format(number) + "\n" +
                "Thank you!");
    }

}
