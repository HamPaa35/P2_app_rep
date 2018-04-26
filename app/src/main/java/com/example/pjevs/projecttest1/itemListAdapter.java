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

  private Context mContext;
  int mResources;

  public itemListAdapter(Context context, int resource, ArrayList<ItemClass> objects) {
      super(context, resource, objects);
      mContext = context;
      mResources = resource;
  }

  @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      String name = getItem(position).getName();
      String itemcategory = getItem(position).getItemCategory();
      String expirationDate = getItem(position).getExpirationDate();
      String storageMethod = getItem(position).getStorageMethod();
      String openClosed = getItem(position).getOpenClosed();

      //ItemClass ItemClass = new ItemClass(name, itemcategory, expirationDate, storageMethod, openClosed);

      LayoutInflater inflater = LayoutInflater.from(mContext);
      convertView = inflater.inflate(mResources,parent,false);

      TextView tvName = (TextView) convertView.findViewById(R.id.textView);
      TextView tvItemCategory = (TextView) convertView.findViewById(R.id.textView3);
      TextView tvDate = (TextView) convertView.findViewById(R.id.textView4);
      TextView tvStorage = (TextView) convertView.findViewById(R.id.textView5);
      TextView tvOpenClosed = (TextView) convertView.findViewById(R.id.textView6);

      tvName.setText(name);
      tvItemCategory.setText((CharSequence) itemcategory);
      tvDate.setText((CharSequence) expirationDate);
      tvStorage.setText((CharSequence) storageMethod);
      tvStorage.setText((CharSequence) tvOpenClosed);

      return convertView;
  }
    }
