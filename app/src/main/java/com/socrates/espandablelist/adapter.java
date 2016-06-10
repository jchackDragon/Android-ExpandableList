package com.socrates.espandablelist;

/**
 * Created by juancarloslopez on 6/10/16.
 */


import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class adapter extends BaseExpandableListAdapter {

    private ArrayList<Group> groups;
    public  LayoutInflater inflater;
    public  Activity activity;

    public adapter(Activity act, ArrayList<Group> groups) {
        activity = act;
        this.groups = groups;
        inflater = act.getLayoutInflater();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groups.get(groupPosition).children.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        Child child = (Child) getChild(groupPosition, childPosition);

        CheckBox checkBox = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row_details, null);
        }

        checkBox = (CheckBox) convertView.findViewById(R.id.check_item);
        checkBox.setText(child.toString());

        checkBox.setChecked(child.isCheChecked());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //TODO CHECKET LOGIC

            }
        });

//        convertView.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(activity, children,
//                        Toast.LENGTH_SHORT).show();
//            }
//        });

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).children.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row_group, null);
        }

        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.check_item);
        TextView text     = (TextView) convertView.findViewById(R.id.item);

        Group group = (Group) getGroup(groupPosition);
        text.setText(group.string);

        if(getChildrenCount(groupPosition) > 0)
            checkBox.setVisibility(View.GONE);
        else
            checkBox.setVisibility(View.VISIBLE);

        //((CheckedTextView) convertView).setChecked(isExpanded);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}