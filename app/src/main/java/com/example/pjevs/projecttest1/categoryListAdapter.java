package com.example.pjevs.projecttest1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class categoryListAdapter extends ArrayAdapter<Category> {

    private Context mContext;
    int mResources;

  public categoryListAdapter(Context context, int resource, ArrayList<Category> objects) {
      super(context, resource, objects);
      mContext = context;
      mResources = resource;
  }

  //Here the activity_Item is passed the right information to display in the inventory and the text is set
  @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      String name = getItem(position).getName();
      String expirationDateOpen = getItem(position).getTypicalExpirationOpen();
      String expirationDateClosed = getItem(position).getTypicalExpirationClosed();
      String itemStorage = getItem(position).getStorageMethod();

      LayoutInflater inflater = LayoutInflater.from(mContext);
      convertView = inflater.inflate(mResources,parent,false);

      TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
      TextView tvDateOpen = (TextView) convertView.findViewById(R.id.textView2);
      TextView tvDateClosed = (TextView) convertView.findViewById(R.id.textView5);
      TextView tvStorage = (TextView) convertView.findViewById(R.id.textView4);

      tvName.setText(name);
      tvDateOpen.setText(expirationDateOpen + " opened");
      tvDateClosed.setText(expirationDateClosed + " closed");
      tvStorage.setText(itemStorage);

      return convertView;
  }
}
