package com.example.fbu_instagram;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import java.util.List;

public class PostsAdapter2 extends RecyclerView.Adapter<PostsAdapter2.ViewHolder2> {

    private Context context;
    private List<Post> posts;


    public PostsAdapter2(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    class ViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView ivImage;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            itemView.setOnClickListener(this);
        }

        public void bind(Post post) {

            if (post.getImage() != null) {
                Glide.with(context).load(post.getImage().getUrl()).into(ivImage);
            }
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            if (position != RecyclerView.NO_POSITION) {
                Intent intent = new Intent(context, MainActivity.class);
                Post post = posts.get(position);
                PostDetail newPost;
                if (post.getImage() == null) {
                    newPost = new PostDetail(post.getUser().getUsername(), post.getDescription(), "", post.getCreatedAt().toString());
                }
                else {
                    newPost = new PostDetail(post.getUser().getUsername(), post.getDescription(), post.getImage().getUrl(), post.getCreatedAt().toString());
                }
                intent.putExtra("post", Parcels.wrap(newPost));
                context.startActivity(intent);
            }

        }
    }

    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Post> newPosts) {
        posts.addAll(newPosts);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post2, parent, false);
        return new ViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

}
