package com.example.expandabletest;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.sectionedrecyclerview.SectionedRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainAdapter extends SectionedRecyclerViewAdapter<MainAdapter.ViewHolder> {

    Activity activity;
    ArrayList<String> sectionList;
    HashMap<String, ArrayList<String>> itemList= new HashMap<>();
    int selectedSection= -1;
    int selectedItem = -1;

    public MainAdapter(Activity activity, ArrayList<String> sectionList, HashMap<String, ArrayList<String>> itemList){
        this.activity= activity;
        this.sectionList= sectionList;
        this.itemList= itemList;
        notifyDataSetChanged();
    }

    @Override
    public int getSectionCount() {
        return sectionList.size();
    }

    @Override
    public int getItemCount(int section) {
        return itemList.get(sectionList.get(section)).size();
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder viewHolder, int i) {
        //set section value on text view
        viewHolder.textview.setText(sectionList.get(i));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i, int i1, int i2) {
        //initialize string item value
        String sItem= itemList.get(sectionList.get(i)).get(i1);
        viewHolder.textview.setText(sItem);
        
        viewHolder.textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //desplay toast
                Toast.makeText(activity, sItem , Toast.LENGTH_SHORT).show();

                //update both positions
                selectedSection= i;
                selectedItem=i1;
                notifyDataSetChanged();
            }
        });

        //check condition
        if(selectedSection==i && selectedItem==i1){
            //when item is selected
            //set background
            viewHolder.textview.setBackground(ContextCompat.getDrawable(activity, R.drawable.rectangle_fill));
            viewHolder.textview.setTextColor(Color.WHITE);
        }
        else{
            //when item unselected
            //set background
            viewHolder.textview.setBackground(ContextCompat.getDrawable(activity, R.drawable.rectangle_outline));
            viewHolder.textview.setTextColor(Color.BLACK);
        }

    }

    @Override
    public int getItemViewType(int section, int relativePosition, int absolutePosition) {
       //check condition

        if(section==1){
            //when section is 1
            return 0;
        }

        return super.getItemViewType(section, relativePosition, absolutePosition);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //define layout

        int layout;
        //check condition
        if(viewType== VIEW_TYPE_HEADER){
            //when view type is equal to header
            layout= R.layout.item_header;
        }
        else{
            //when view type is equal to item
            layout= R.layout.item_slot;
        }
        View view= LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        //return view holder
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //initialize variables
        TextView textview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textview= itemView.findViewById(R.id.text_view);
        }
    }

}
