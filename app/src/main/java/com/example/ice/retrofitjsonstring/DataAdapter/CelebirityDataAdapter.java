package com.example.ice.retrofitjsonstring.DataAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ice.retrofitjsonstring.Celebirity;
import com.example.ice.retrofitjsonstring.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ICE on 17-May-16.
 */
public class CelebirityDataAdapter extends RecyclerView.Adapter<CelebirityDataAdapter.ViewHolder> {
    private List<Celebirity> cele;
    private String profileUrl;
    Context context;

    public CelebirityDataAdapter(List<Celebirity> cele,Context context) {
        this.cele = cele;
        this.context = context;
    }

    @Override
    public CelebirityDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celebirity_item_info, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CelebirityDataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_celeId.setText(Integer.toString(cele.get(i).getId()));
        viewHolder.tv_birthdate.setText(cele.get(i).getBirthdate());
        viewHolder.tv_summary.setText(cele.get(i).getSummary());
        viewHolder.tv_created_at.setText(cele.get(i).getCreated_at());
      //  viewHolder.tv_profile.setText(cele.get(i).getProfile());
         profileUrl = cele.get(i).getProfile();

    }

    @Override
    public int getItemCount() {
        return cele.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_celeId, tv_name, tv_birthdate, tv_summary, tv_created_at;
        private ImageView tv_profile;
        public ViewHolder(View view) {
            super(view);
            tv_celeId = (TextView)view.findViewById(R.id.tv_celeId);
            tv_birthdate = (TextView)view.findViewById(R.id.tv_birthdate);
            tv_summary = (TextView)view.findViewById(R.id.tv_summmary);
            tv_created_at = (TextView)view.findViewById(R.id.tv_created_at);
            tv_profile = (ImageView)view.findViewById(R.id.tv_profile);
          Picasso.with(context).load(profileUrl).resize(100, 100).into(tv_profile);

        }
    }

}
