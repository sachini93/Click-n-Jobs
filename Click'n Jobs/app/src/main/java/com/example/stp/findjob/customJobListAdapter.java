package com.example.stp.findjob;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class customJobListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Jobs> mJobList;
    private int[] micons;

    public customJobListAdapter(Context mContext, List<Jobs> mJobs,int [] icons) {
        this.mContext = mContext;
        this.mJobList = mJobs;
        this.micons=icons;
    }

    @Override
    public int getCount() {
        return mJobList.size();
    }

    @Override
    public Object getItem(int position) {
        return mJobList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view=View.inflate(mContext,R.layout.new_job_list,null);

            TextView title=(TextView)view.findViewById(R.id.job_title_txt);
            TextView category=(TextView)view.findViewById(R.id.job_cat_txt);
            TextView description=(TextView)view.findViewById(R.id.job_description_txt);
            ImageView icon=(ImageView)view.findViewById(R.id.job_icon_img);

            title.setText(mJobList.get(position).get_jobTitle());
            category.setText(mJobList.get(position).get_category());
            description.setText(mJobList.get(position).get_description());
            icon.setImageResource(micons[position]);

            //set tag
            view.setTag(mJobList.get(position).get_id());

            Button apply=(Button)view.findViewById(R.id.button_apply_jobs);
            apply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(parent.getContext(), ApplyJob.class);
                    parent.getContext().startActivity(intent);
                }
            });

        return view;
    }
}

