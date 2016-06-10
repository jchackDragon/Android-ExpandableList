package com.socrates.espandablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.widget.ExpandableListView;

public class MainActivity extends Activity {
    // more efficient than HashMap for mapping integers to objects
    ArrayList<Group> groups = new ArrayList<Group>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createData();
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);
        adapter adapter = new adapter(this, groups);

        listView.setAdapter(adapter);
    }

    public void createData() {
        for (int j = 0; j < 5; j++) {
            Group group = new Group("Socrato " + j);
            for (int i = 0; i < 5; i++) {
                group.children.add( new Child("Sub Item" + i));
            }

            groups.add(group);
        }

        Group g = new Group("Socratos sin testo");

        groups.add(groups.size(), g);
    }

}
