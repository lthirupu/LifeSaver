package edu.depaul.csc472.lifesaver;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PatientStories extends ListActivity {
    private static final String TAG = "PatientStories";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_patient_stories);
        setListAdapter(new PatientAdapter());
    }
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Log.d(TAG, "onListItemClick position=" + position + " id=" + id + " " + Patient_details[position].getName());
        Intent intent = new Intent(PatientStories.this, ViewFullStory.class);
        intent.putExtra("PatientName", Patient_details[position].getName());
        intent.putExtra("StoryDescription", Patient_details[position].getLongDescription());
        intent.putExtra("PatientPic", PatientInfo.getIconResource(Patient_details[position].getType()));
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_patient_stories, menu);
        return true;
    }
    class PatientAdapter extends BaseAdapter{
        private LayoutInflater inflater;

        @Override
        public int getCount() {
            return Patient_details.length;
        }

        @Override
        public Object getItem(int i) {
            return Patient_details[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView (int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (convertView == null) {
                if (inflater == null)
                    inflater = (LayoutInflater) PatientStories.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.activity_patient_stories, parent, false);
            }

            ImageView icon = (ImageView) row.findViewById(R.id.image);
            TextView name = (TextView) row.findViewById(R.id.text1);
            TextView description = (TextView) row.findViewById(R.id.text2);

            PatientInfo info = Patient_details[position];
            name.setText(info.getName());
            description.setText(info.getShortDescription());
            icon.setImageResource(PatientInfo.getIconResource(info.getType()));
            return row;
        }
    }
    private static final PatientInfo[] Patient_details = {
            new PatientInfo("Sandra",
                    PatientInfo.Type.PatientPic,
                    "My Daughter's successful Story",
                    "My daughter was born very sick. We had no idea that anything was wrong with her but within 12 hours of being born, she desperately needed platelets. She was at 9,000 when she should have been at 200,000. From that point on, she needed multiple platelet and blood donations. Unfortunatly, she became an angel at 109 days old. But with that time, Josephine got to meet her brothers, her cousins and other family members. She got to go up north and see God's nature creations and go a Detroit Tigers game. She got to feel LOVE. All of that was because of generous donors. Thank you, from the depths of my heart."),
    };
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
