package com.example.sourdoughchronicles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;

import java.util.List;

public class ingredients  extends AppCompatActivity {

    String menuItem;
    TextView itemName;
    TextView ing1;
    TextView ing2;
    TextView ing3;
    TextView ing4;

    TextView ingAmt1;
    TextView ingAmt2;
    TextView ingAmt3;
    TextView ingAmt4;

    TextView unit1;
    TextView unit2;
    TextView unit3;
    TextView unit4;

    private SharedPreferences sharedPref;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        final BakeryApplication bApp;

        PreferenceManager.setDefaultValues(this,R.xml.root_preferences,false);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        if (sharedPref.getBoolean("darkTheme",false)){
            setTheme(R.style.DarkTheme);
        }
        else{
            setTheme(R.style.AppTheme);
        }


        setContentView(R.layout.ingredients);
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        itemName = findViewById(R.id.txtIngredients);
        ing1 = findViewById(R.id.txtIngOne);
        ing2 = findViewById(R.id.txtIngTwo);
        ing3 = findViewById(R.id.txtIngThree);
        ing4 = findViewById(R.id.txtIngFour);
        ingAmt1 = findViewById(R.id.txtAmt1);
        ingAmt2 = findViewById(R.id.txtAmt2);
        ingAmt3 = findViewById(R.id.txtAmt3);
        ingAmt4 = findViewById(R.id.txtAmt4);
        unit1 = findViewById(R.id.txtIngOneUnit);
        unit2 = findViewById(R.id.txtIngTwoUnit);
        unit3 = findViewById(R.id.txtIngThreeUnit);
        unit4 = findViewById(R.id.txtIngFourUnit);
        String unitSelected = sharedPref.getString("unit","");
        unit1.setText(unitSelected);
        unit2.setText(unitSelected);
        unit3.setText(unitSelected);
        unit4.setText(unitSelected);

        bApp = ((BakeryApplication)getApplication());

        Intent intent = getIntent();
        menuItem = intent.getStringExtra("menuItem");

        if (menuItem.equals("boule")){
            itemName.setText("Ingredients in a Sourdough Boule");
            List<String> ingList = bApp.getBoule();
            ing1.setText(ingList.get(0));
            ing2.setText(ingList.get(1));
            ing3.setText(ingList.get(2));
            ing4.setText(ingList.get(3));
            if (unitSelected.equals("gm")){
                ingAmt1.setText(ingList.get(4));
                ingAmt2.setText(ingList.get(5));
                ingAmt3.setText(ingList.get(6));
                ingAmt4.setText(ingList.get(7));
            }
            else if(unitSelected.equals("cups")){
                float amt1 = Float.parseFloat(ingList.get(4))/125;
                String amtString1 = String.valueOf(amt1);
                ingAmt1.setText(amtString1);
                float amt2 = Float.parseFloat(ingList.get(5))/125;
                String amtString2 = String.valueOf(amt2);
                ingAmt2.setText(amtString2);
                float amt3 = Float.parseFloat(ingList.get(6))/125;
                String amtString3 = String.valueOf(amt3);
                ingAmt3.setText(amtString3);
                float amt4 = Float.parseFloat(ingList.get(7))/125;
                String amtString4 = String.valueOf(amt4);
                ingAmt4.setText(amtString4);
            }

        }
        else if(menuItem.equals("majorca")){
            List<String> ingList = bApp.getBoule();
            ing1.setText(ingList.get(0));
            ing2.setText(ingList.get(1));
            ing3.setText(ingList.get(2));
            ing4.setText(ingList.get(3));
            if (unitSelected.equals("gm")){
                ingAmt1.setText(ingList.get(4));
                ingAmt2.setText(ingList.get(5));
                ingAmt3.setText(ingList.get(6));
                ingAmt4.setText(ingList.get(7));
            }
            else if(unitSelected.equals("cups")){
                float amt1 = Float.parseFloat(ingList.get(4))/125;
                String amtString1 = String.valueOf(amt1);
                ingAmt1.setText(amtString1);
                float amt2 = Float.parseFloat(ingList.get(5))/125;
                String amtString2 = String.valueOf(amt2);
                ingAmt2.setText(amtString2);
                float amt3 = Float.parseFloat(ingList.get(6))/125;
                String amtString3 = String.valueOf(amt3);
                ingAmt3.setText(amtString3);
                float amt4 = Float.parseFloat(ingList.get(7))/125;
                String amtString4 = String.valueOf(amt4);
                ingAmt4.setText(amtString4);
            }
        }
        else if (menuItem.equals("cherry")){
            List<String> ingList = bApp.getBoule();
            ing1.setText(ingList.get(0));
            ing2.setText(ingList.get(1));
            ing3.setText(ingList.get(2));
            ing4.setText(ingList.get(3));
            if (unitSelected.equals("gm")){
                ingAmt1.setText(ingList.get(4));
                ingAmt2.setText(ingList.get(5));
                ingAmt3.setText(ingList.get(6));
                ingAmt4.setText(ingList.get(7));
            }
            else if(unitSelected.equals("cups")){
                float amt1 = Float.parseFloat(ingList.get(4))/125;
                String amtString1 = String.valueOf(amt1);
                ingAmt1.setText(amtString1);
                float amt2 = Float.parseFloat(ingList.get(5))/125;
                String amtString2 = String.valueOf(amt2);
                ingAmt2.setText(amtString2);
                float amt3 = Float.parseFloat(ingList.get(6))/125;
                String amtString3 = String.valueOf(amt3);
                ingAmt3.setText(amtString3);
                float amt4 = Float.parseFloat(ingList.get(7))/125;
                String amtString4 = String.valueOf(amt4);
                ingAmt4.setText(amtString4);
            }
        }
        else if (menuItem.equals("brioche")){
            List<String> ingList = bApp.getBoule();
            ing1.setText(ingList.get(0));
            ing2.setText(ingList.get(1));
            ing3.setText(ingList.get(2));
            ing4.setText(ingList.get(3));
            if (unitSelected.equals("gm")){
                ingAmt1.setText(ingList.get(4));
                ingAmt2.setText(ingList.get(5));
                ingAmt3.setText(ingList.get(6));
                ingAmt4.setText(ingList.get(7));
            }
            else if(unitSelected.equals("cups")){
                float amt1 = Float.parseFloat(ingList.get(4))/125;
                String amtString1 = String.valueOf(amt1);
                ingAmt1.setText(amtString1);
                float amt2 = Float.parseFloat(ingList.get(5))/125;
                String amtString2 = String.valueOf(amt2);
                ingAmt2.setText(amtString2);
                float amt3 = Float.parseFloat(ingList.get(6))/125;
                String amtString3 = String.valueOf(amt3);
                ingAmt3.setText(amtString3);
                float amt4 = Float.parseFloat(ingList.get(7))/125;
                String amtString4 = String.valueOf(amt4);
                ingAmt4.setText(amtString4);
            }
        }
        else if(menuItem.equals("cheddar")){
            List<String> ingList = bApp.getBoule();
            ing1.setText(ingList.get(0));
            ing2.setText(ingList.get(1));
            ing3.setText(ingList.get(2));
            ing4.setText(ingList.get(3));
            if (unitSelected.equals("gm")){
                ingAmt1.setText(ingList.get(4));
                ingAmt2.setText(ingList.get(5));
                ingAmt3.setText(ingList.get(6));
                ingAmt4.setText(ingList.get(7));
            }
            else if(unitSelected.equals("cups")){
                float amt1 = Float.parseFloat(ingList.get(4))/125;
                String amtString1 = String.valueOf(amt1);
                ingAmt1.setText(amtString1);
                float amt2 = Float.parseFloat(ingList.get(5))/125;
                String amtString2 = String.valueOf(amt2);
                ingAmt2.setText(amtString2);
                float amt3 = Float.parseFloat(ingList.get(6))/125;
                String amtString3 = String.valueOf(amt3);
                ingAmt3.setText(amtString3);
                float amt4 = Float.parseFloat(ingList.get(7))/125;
                String amtString4 = String.valueOf(amt4);
                ingAmt4.setText(amtString4);
            }
        }
        else if (menuItem.equals("pumpkin")){
            List<String> ingList = bApp.getBoule();
            ing1.setText(ingList.get(0));
            ing2.setText(ingList.get(1));
            ing3.setText(ingList.get(2));
            ing4.setText(ingList.get(3));
            if (unitSelected.equals("gm")){
                ingAmt1.setText(ingList.get(4));
                ingAmt2.setText(ingList.get(5));
                ingAmt3.setText(ingList.get(6));
                ingAmt4.setText(ingList.get(7));
            }
            else if(unitSelected.equals("cups")){
                float amt1 = Float.parseFloat(ingList.get(4))/125;
                String amtString1 = String.valueOf(amt1);
                ingAmt1.setText(amtString1);
                float amt2 = Float.parseFloat(ingList.get(5))/125;
                String amtString2 = String.valueOf(amt2);
                ingAmt2.setText(amtString2);
                float amt3 = Float.parseFloat(ingList.get(6))/125;
                String amtString3 = String.valueOf(amt3);
                ingAmt3.setText(amtString3);
                float amt4 = Float.parseFloat(ingList.get(7))/125;
                String amtString4 = String.valueOf(amt4);
                ingAmt4.setText(amtString4);
            }
        }

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean ret = true;

        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;

            default:
                ret = super.onOptionsItemSelected(item);
        }
        return ret;
    }

}
