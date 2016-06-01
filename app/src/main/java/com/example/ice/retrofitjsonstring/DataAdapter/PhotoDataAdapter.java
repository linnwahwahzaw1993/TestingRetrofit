package com.example.ice.retrofitjsonstring.DataAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ice.retrofitjsonstring.Photo;
import com.example.ice.retrofitjsonstring.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ICE on 30-May-16.
 */
public class PhotoDataAdapter extends RecyclerView.Adapter<PhotoDataAdapter.ViewHolder>{
    List<Photo> photo;
    Context context;
    String photOriginalUrl;
    public PhotoDataAdapter(List<Photo>photo, Context context){
        this.photo = photo;
        this.context = context;
    }
    @Override
    public PhotoDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoDataAdapter.ViewHolder holder, int i) {
        holder.tv_id.setText(Integer.toString(photo.get(i).getId()));
        holder.tv_celeID.setText(Integer.toString(photo.get(i).getCele_id()));
        holder.tv_celeName.setText(photo.get(i).getName());
        photOriginalUrl = photo.get(i).getOriginal_url();

    }

    @Override
    public int getItemCount() {
        return photo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_id, tv_celeID, tv_celeName;
        private ImageView img_originalUrl;
        public ViewHolder(View view) {
            super(view);
            tv_id = (TextView)view.findViewById(R.id.tv_id);
            tv_celeID = (TextView)view.findViewById(R.id.tv_celeId);
            tv_celeName = (TextView)view.findViewById(R.id.tv_celeName);
            img_originalUrl = (ImageView)view.findViewById(R.id.img_originalUrl);
            Picasso.with(context).load(photOriginalUrl).resize(100, 100).into(img_originalUrl);

        }
    }
}
