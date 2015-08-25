package com.tourplanner.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.res.Resources;
import android.app.Activity;
import android.view.LayoutInflater;
import com.tourplanner.dto.Attraction;
import com.tourplanner.R;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.ListView;

public class AttractionsListAdapter extends BaseAdapter {
    private Activity activity;
    private Resources resources;
    private ArrayList<Attraction> data;
    private static LayoutInflater inflater;
    private Attraction attraction;
    private Context context;
    public AttractionsListAdapter(Activity activity, Resources resources, ArrayList<Attraction> data) {
        this.activity = activity;
        this.resources = resources;
        this.data = data;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public AttractionsListAdapter(Context context, Resources resources, ArrayList<Attraction> data) {
        this.context = context;
        this.resources = resources;
        this.data = data;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ListView listView = (ListView) parent;
      //  View rowView = inflater.inflate(R.layout.list_item, parent, false);
        View rowView = null;
        ViewHolder viewHolder= null;
        if(rowView == null){
           // convertView = inflater.inflate(R.layout.attractions_list_item,null);
            rowView = inflater.inflate(R.layout.attractions_list_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.contactName = (TextView)rowView.findViewById(R.id.textView_contact_name);

            viewHolder.contactRole = (TextView)rowView.findViewById(R.id.textView_contact_role);
            viewHolder.checkBoxContact = (CheckBox)rowView.findViewById(R.id.checkBox_contact);
            rowView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder)rowView.getTag();

        if(data!=null && data.size()>0){
            attraction = data.get(position);
            viewHolder.contactName.setText(attraction.getAttractionName());
            viewHolder.contactRole.setText(attraction.getAttractionType());
            viewHolder.checkBoxContact.setChecked(attraction.isSelected());
           // viewHolder.contactName.setText("dfds");
           // viewHolder.contactRole.setText(" dfad ");
        }
        return rowView;
    }

    @Override
    public int getCount() {
        if(data !=null)
            return data.size();
        return 0;
    }

    static class ViewHolder {
        TextView contactName;
        TextView contactRole;
        CheckBox checkBoxContact;
    }
}
