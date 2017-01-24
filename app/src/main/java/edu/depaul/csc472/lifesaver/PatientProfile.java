package edu.depaul.csc472.lifesaver;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PatientProfile extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);
        final EditText edit_name = (EditText)findViewById(R.id.edit_pname);
        final TextView txt_name =(TextView)findViewById(R.id.txt_pname);
        TextView name_edit = (TextView)findViewById(R.id.name_edit);
        final EditText edit_type = (EditText)findViewById(R.id.edit_pbloodtype);
        final TextView txt_type =(TextView)findViewById(R.id.txt_pbloodtype);
        TextView type_edit = (TextView)findViewById(R.id.edit_type);
        final EditText edit_donation = (EditText)findViewById(R.id.edit_pdonation);
        final TextView txt_donation =(TextView)findViewById(R.id.txt_pdonation);
        TextView donation_edit = (TextView)findViewById(R.id.edit_donation);
        name_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_name.setVisibility(View.GONE);
                edit_name.setVisibility(View.VISIBLE);
                edit_name.setText(txt_name.getText().toString());
            }
        });
        donation_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_donation.setVisibility(View.GONE);
                edit_donation.setVisibility(View.VISIBLE);
                edit_donation.setText(txt_donation.getText().toString());
            }
        });

        type_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_type.setVisibility(View.GONE);
                edit_type.setVisibility(View.VISIBLE);
                edit_type.setText(txt_type.getText().toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_patient_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
