package com.highbryds.shoppinglistforromania_mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.highbryds.shoppinglistforromania_mvvm.Adapters.ShoppingListAdapter;
import com.highbryds.shoppinglistforromania_mvvm.Room.DbRepository;
import com.highbryds.shoppinglistforromania_mvvm.Room.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.itemname)
    EditText itemname;

    @BindView(R.id.submit)
    Button submit;
    @BindView(R.id.shoppinglist)
    RecyclerView shoppinglist;
    /* @Inject
     PresenterImpl presenter;*/
    ShoppingListAdapter adapter;
    List<ShoppingItem> list;
    @Inject
    DbRepository repo;
    @BindView(R.id.cat)
    AutoCompleteTextView cat;
    MainActivityViewModel mainacitvituviewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mainacitvituviewmodel = ViewModelProviders.of(this).get(MainActivityViewModel.class);


        ArrayList<String> categories = new ArrayList<>();
        categories.add("Clothings");
        categories.add("Shoes");
        categories.add("Utilities");


        ButterKnife.bind(this);

        populateEditText(categories);
        shoppinglist.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShoppingListAdapter(this, list);
        shoppinglist.setAdapter(adapter);
        mainacitvituviewmodel.getAllItems().observe(this, new Observer<List<ShoppingItem>>() {
            @Override
            public void onChanged(@Nullable List<ShoppingItem> shoppingItems) {
                adapter.loadItems(shoppingItems);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void populateEditText(ArrayList<String> categories) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, categories);
        //Getting the instance of AutoCompleteTextView

        cat.setThreshold(1);//will start working from first character
        cat.setAdapter(adapter);//setting the adapter data

    }

    @OnClick({R.id.cat, R.id.submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cat:
                break;
            case R.id.submit:

                ShoppingItem si = new ShoppingItem();
                si.setCategoryName(cat.getText().toString());
                si.setProductName(itemname.getText().toString());
                /* presenter.submitDataToModel(itemname.getText().toString(), cat.getText().toString());*/
                mainacitvituviewmodel.insert(si);
                break;
        }
    }
}
