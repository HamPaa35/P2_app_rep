package com.example.pjevs.projecttest1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

public class itemListAdapter extends ArrayAdapter<ItemClass> {

    private static final String TAG = "itemListAdapter";

    private Context mContext;
    int mResources;

  public itemListAdapter(Context context, int resource, ArrayList<ItemClass> objects) {
      super(context, resource, objects);
      mContext = context;
      mResources = resource;
  }
  //Here the activity_Item is passed the right information to display in the inventory and the text is set
  @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      String name = getItem(position).getName();
      String expirationDate = getItem(position).getExpirationDate();
      String openClosed = getItem(position).getOpenClosed();
      String itemCategory = getItem(position).getItemCategory();
      String itemStorage = getItem(position).getStorageMethod();

      LayoutInflater inflater = LayoutInflater.from(mContext);
      convertView = inflater.inflate(mResources,parent,false);

      TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
      TextView tvDate = (TextView) convertView.findViewById(R.id.textView2);
      TextView tvOpenClosed = (TextView) convertView.findViewById(R.id.textView3);
      TextView tvCategory = (TextView) convertView.findViewById(R.id.textView4);
      TextView tvStorage = (TextView) convertView.findViewById(R.id.textView5);

      tvName.setText(name);
      tvDate.setText(expirationDate);
      tvOpenClosed.setText(openClosed);
      tvCategory.setText(itemCategory);
      tvStorage.setText(itemStorage);

      return convertView;
  }
    }
