package com.zebra.globalsw.viewtest;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Dummy.NAMES); //android SDK layout
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.item_list, R.id.text, Dummy.NAMES);
        //listView.setAdapter(arrayAdapter);

        MyAdapter myAdapter = new MyAdapter();
        //listView.setAdapter(new MyAdapter());
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    private class MyAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return Dummy.NAMES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        // will be call every time creating a new row
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;

            if (view==null) {

                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false); //load layout during runtime, must use inflater

                viewHolder = new ViewHolder();
                viewHolder.imageView= (ImageView) view.findViewById(R.id.image); // find the Id from the view instance, not from the main activity
                viewHolder.textView = (TextView) view.findViewById(R.id.text);
                view.setTag(viewHolder); //store the holder
            }
            else
            {
                viewHolder = (ViewHolder) view.getTag();
            }
            // set from the position of i
            viewHolder.imageView.setImageResource(Dummy.DRAWABLES[i]);
            viewHolder.textView.setText(Dummy.NAMES[i]);

            return view;
        }
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textView;

    }
}
