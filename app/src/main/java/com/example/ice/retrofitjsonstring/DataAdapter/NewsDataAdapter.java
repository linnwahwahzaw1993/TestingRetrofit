package com.example.ice.retrofitjsonstring.DataAdapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ice.retrofitjsonstring.News;
import com.example.ice.retrofitjsonstring.R;

import java.util.List;


/**
 * Created by ICE on 17-May-16.
 */
public class NewsDataAdapter extends RecyclerView.Adapter<NewsDataAdapter.ViewHolder> {
    private List<News> news;

    public NewsDataAdapter(List<News> news) {
        this.news = news;
    }

    @Override
    public NewsDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsDataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_newid.setText(Integer.toString(news.get(i).getId()));
        viewHolder.tv_title.setText(news.get(i).getTitle());
        viewHolder.tv_celeId.setText(Integer.toString(news.get(i).getCele_id()));
        viewHolder.tv_cele_name.setText(news.get(i).getCele_name());
        viewHolder.textViewCreated_at.setText(news.get(i).getCreated_at());

    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_newid, tv_title, tv_celeId, tv_cele_name, textViewCreated_at;

        public ViewHolder(View view) {
            super(view);
            tv_newid = (TextView) view.findViewById(R.id.textViewNewId);
            tv_title = (TextView) view.findViewById(R.id.textViewTitle);
            tv_celeId = (TextView) view.findViewById(R.id.textViewCeleId);
            tv_cele_name = (TextView) view.findViewById(R.id.textViewCeleName);
            textViewCreated_at = (TextView) view.findViewById(R.id.textViewCreated_at);

        }
    }

}
