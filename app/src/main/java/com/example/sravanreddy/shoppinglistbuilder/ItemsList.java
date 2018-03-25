package com.example.sravanreddy.shoppinglistbuilder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItemsList extends AppCompatActivity {
Button cheese, fruit, juice, veggies, rice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);
        cheese=findViewById(R.id.button_cheese);
        fruit=findViewById(R.id.button_fruits);
        veggies=findViewById(R.id.button_veggies);
        juice=findViewById(R.id.button_juice);
        rice=findViewById(R.id.button_rice);
    }

    public void clickhandler(View view) {
        switch (view.getId()){
            case R.id.button_cheese:
                Intent addItem=new Intent();
                addItem.putExtra("Key", "Cheese");
                setResult(RESULT_OK, addItem);
                finish();
                break;
            case R.id.button_fruits:
                Intent addItem2=new Intent();
                addItem2.putExtra("Key", "Fruits");
                setResult(RESULT_OK, addItem2);
                finish();
                break;
            case R.id.button_juice:
                Intent addItem3=new Intent();
                addItem3.putExtra("Key", "Juice");
                setResult(RESULT_OK, addItem3);
                finish();
                break;
            case R.id.button_veggies:
                Intent addItem4=new Intent();
                addItem4.putExtra("Key", "Vegetables");
                setResult(RESULT_OK, addItem4);
                finish();
                break;
            case R.id.button_rice:
                Intent addItem5=new Intent();
                addItem5.putExtra("Key", "Rice");
                setResult(RESULT_OK, addItem5);
                finish();
                break;
        }
    }
}
