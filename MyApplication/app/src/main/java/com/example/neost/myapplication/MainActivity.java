package com.example.neost.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.oc.hnapp.android.HNQueryTask;

import java.security.acl.Group;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Configure RecyclerView
        GroupListAdapter adapter = new GroupListAdapter();
        recycler = (RecyclerView) findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        // Create HNQueryTask
        //HNQueryTask task = new HNQueryTask(adapter,80,1);

    }

    class GroupListAdapter extends RecyclerView.Adapter{

        private Context context;
        private List<String> listString;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType)
        {
            return null;
        }



        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
        {
            // Recupération des contenus des cellules TODO XML DE LA CELLULE
            //holder.itemView.findViewById()
        }

        @Override
        public int getItemCount()
        {
            return listString.size();
        }
    }
}
