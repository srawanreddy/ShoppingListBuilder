package com.example.sravanreddy.shoppinglistbuilder;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView[] items;
    private static int itemnumber;
    Button addItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemnumber=0;
        items=new TextView[5];
        items[0]=findViewById(R.id.textView);
        items[1]=findViewById(R.id.textView2);
        items[2]=findViewById(R.id.textView3);
        items[3]=findViewById(R.id.textView4);
        items[4]=findViewById(R.id.textView5);
        if(savedInstanceState!=null){
            boolean isVisible=savedInstanceState.getBoolean("item_1_visible");
            if(isVisible==true){
                items[0].setVisibility(View.VISIBLE);
                items[0].setText(savedInstanceState.getString("item_1"));
            }
            if(savedInstanceState.getBoolean("item_2_visible")){
                items[1].setVisibility(View.VISIBLE);
                items[1].setText(savedInstanceState.getString("item_2"));
            }
            if(savedInstanceState.getBoolean("item_3_visible")){
                items[2].setVisibility(View.VISIBLE);
                items[2].setText(savedInstanceState.getString("item_3"));
            }
            if(savedInstanceState.getBoolean("item_4_visible")){
                items[3].setVisibility(View.VISIBLE);
                items[3].setText(savedInstanceState.getString("item_4"));
            }
            if(savedInstanceState.getBoolean("item_5_visible")){
                items[4].setVisibility(View.VISIBLE);
                items[4].setText(savedInstanceState.getString("item_5"));
            }
        }
        addItem=findViewById(R.id.button);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itemIntent=new Intent(MainActivity.this, ItemsList.class);
                startActivityForResult(itemIntent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                items[itemnumber].setVisibility(View.VISIBLE);
                items[itemnumber++].setText(data.getExtras().getString("Key"));
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Toast.makeText(MainActivity.this, "true", Toast.LENGTH_SHORT).show();
        if(items[0].getVisibility()==View.VISIBLE){

            outState.putBoolean("item_1_visible",true);
            outState.putString("item_1", items[0].getText().toString());
        }
        if(items[1].getVisibility()==View.VISIBLE){
            outState.putBoolean("item_2_visible",true);
            outState.putString("item_2", items[1].getText().toString());
        }
        if(items[2].getVisibility()==View.VISIBLE){
            outState.putBoolean("item_3_visible",true);
            outState.putString("item_3", items[2].getText().toString());
        }
        if(items[3].getVisibility()==View.VISIBLE){
            outState.putBoolean("item_4_visible",true);
            outState.putString("item_4", items[3].getText().toString());
        }
        if(items[4].getVisibility()==View.VISIBLE){
            outState.putBoolean("item_5_visible",true);
            outState.putString("item_5", items[4].getText().toString());
        }
    }
}
