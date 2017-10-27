package com.example.neost.myapplication.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.neost.myapplication.R;
import com.example.neost.myapplication.data.AdressBookApi;
import com.example.neost.myapplication.data.Group;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by neost on 27/10/2017.
 */

public class GroupListActivity extends AppCompatActivity {
    private RecyclerView ui_groupRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_group_list);

        ui_groupRecyclerView = (RecyclerView) findViewById(R.id.group_recycler_view);
        ui_groupRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ui_groupRecyclerView.setAdapter(new GroupListAdapter());
    }

    class GroupListAdapter extends RecyclerView.Adapter<GroupCaldHolder>
    {
        private List<Group> _groupList;
        public GroupListAdapter()
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:3000")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            AdressBookApi service = retrofit.create(AdressBookApi.class);

            service.getGroupList().enqueue(new Callback<List<Group>>() {
                @Override
                public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {
                    Log.i("retrofit", "Download ok");
                    _groupList = response.body();
                    notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<Group>> call, Throwable t) {

                }
            });
        }

        @Override
        public GroupCaldHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View cell = LayoutInflater.from(GroupListActivity.this).inflate(R.layout.group_cell,parent,false);
            GroupCaldHolder holder = new GroupCaldHolder(cell);

            return holder;
        }

        @Override
        public void onBindViewHolder(GroupCaldHolder holder, int position)
        {
            holder.layoutForGroup(_groupList.get(position));
        }

        @Override
        public int getItemCount()
        {
            int itemCount = 0;
            if (_groupList != null)
            {
                itemCount = _groupList.size();
            }

            return itemCount;
        }

    }

    class GroupCaldHolder extends RecyclerView.ViewHolder
    {
        private final TextView ui_groupTitle;
        public GroupCaldHolder(View cell) {
            super(cell);

            ui_groupTitle = (TextView) cell.findViewById(R.id.group_title);
        }
        public void layoutForGroup(Group group)
        {
            ui_groupTitle.setText(group.getTitle());
        }


    }
}
