package com.example.to_do_list;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText item;
    Button add;
    ListView list;
    ArrayList<String> itemlist = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todolist_mainactivity);
    item = findViewById(R.id.edittext);
    add = findViewById(R.id.button);
    list = findViewById(R.id.list);

   try {
       itemlist = Filehelper.readData(this);
       adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, itemlist);
       list.setAdapter(adapter);
   } catch (Exception e){
       e.printStackTrace();
   }
    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String itemName = item.getText().toString();
            itemlist.add(itemName);
            item.setText("");
            Filehelper.writeData(itemlist, getApplicationContext());
            adapter.notifyDataSetChanged();
        }
    });


    }
}


