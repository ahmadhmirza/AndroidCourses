package com.example.android.coffeeshoporder;
/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0;
    final int COFFEE_COST=5;
    final int WHIPPEDCREAM_COST=1;
    final int CHOCO_COST=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox wcreamTopping = (CheckBox) findViewById(R.id.topping_chkbox);
        CheckBox chocoTopping = (CheckBox) findViewById(R.id.topping_chocho_chkbox);
        EditText nameField = (EditText) findViewById(R.id.customer_name);
        String customerName = nameField.getText().toString();

        boolean whippedCream = false;
        boolean chocolate = false;

        if(customerName.matches(""))
        {
            customerName = "Jhon Doe";
        }
        if(wcreamTopping.isChecked()){
            whippedCream=true;
        }
        if (chocoTopping.isChecked()) {
            chocolate = true;
        }
        float totalBill=caluclatePrice(quantity,whippedCream,chocolate);

        //displayMessage(createOrderSummary(customerName,totalBill,whippedCream,chocolate));

        final String subject ="Order details for Mr." + customerName;

        composeEmail(subject,createOrderSummary(customerName,totalBill,whippedCream,chocolate));


        //Log.v("MainActivity","whippedCream"+whippedCream);

    }

    public void composeEmail(String subject,String order) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, );
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,order);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public float caluclatePrice(int quantity,boolean addWhippedCream,boolean addChocolate){
        float price = quantity * COFFEE_COST;
        if(addWhippedCream){
            price+=WHIPPEDCREAM_COST;
        }
        if(addChocolate){
            price+=CHOCO_COST;
        }
        return price;
    }
    public void increment(View view) {

        quantity = quantity+1;
        display(quantity);
    }
    public void decrement(View view) {

        quantity = quantity-1;
        if (quantity<=0){
            quantity=0;
        }
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }


    private String createOrderSummary(String customerName,float price,boolean addWhippedCream,boolean addChocolate){
        String orderSummary="";

        orderSummary=getString(R.string.customer_name, customerName);
        orderSummary += "\nAdd Whipped Cream: "+ addWhippedCream;
        orderSummary += "\nAdd Choco Topping: "+ addChocolate;
        orderSummary += "\n"+getString(R.string.quant, quantity);
        orderSummary += "\n"+getString(R.string.total, price);
        orderSummary += "\n"+getString(R.string.thank_you);

        return orderSummary;
    }

}