package com.example.stp.findjob;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ListView listView_jobs;
    private customJobListAdapter adapter;
    private List<Jobs> mJobsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_jobs=(ListView)findViewById(R.id.job_list);
        mJobsList=new ArrayList<>();

        //add jobs data
        mJobsList.add(new Jobs("Diver","( Minimum 2 year experience )","Hobby/Entertainment"));
        mJobsList.add(new Jobs("Surgeon","( Special in Neurology )","Health"));
        mJobsList.add(new Jobs("Accountant","( 3 year working experience )","Bank"));
        mJobsList.add(new Jobs("Waitress","( 1 year experience )","Hospitality"));
        mJobsList.add(new Jobs("QS Engineer","( Trainer )","Engineering"));
        mJobsList.add(new Jobs("Security Officer","( 1 year experience )","Defence"));
        mJobsList.add(new Jobs("Counsellor","( Well managed knowledge in the field )","Social"));
        mJobsList.add(new Jobs("Tourist Guider","( 2 year experience )","Tourism"));
        mJobsList.add(new Jobs("Attendant","( 1 year experience )","Health"));
        mJobsList.add(new Jobs("Private Secretary","( 1 year experience )","Personal assistant"));
        mJobsList.add(new Jobs("Chef","( 2 year minimum experience )","Hotel"));
        mJobsList.add(new Jobs("Tourist Guider","( 1 year experience )","Tourism"));

        //add job icons
        int[]icons={R.drawable.diver,
                R.drawable.assistant,
                R.drawable.businessman,
                R.drawable.croupier,
                R.drawable.engineer,
                R.drawable.loader,
                R.drawable.priest,
                R.drawable.sheriff,
                R.drawable.surgeon,
                R.drawable.teacher,
                R.drawable.chef,
                R.drawable.sheriff
        };

        //init Adapter
        adapter=new customJobListAdapter(getApplicationContext(),mJobsList,icons);
        listView_jobs.setAdapter(adapter);

    }
}
