package com.example.fbu_instagram.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fbu_instagram.PostDetail;
import com.example.fbu_instagram.R;

import org.parceler.Parcels;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PostDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PostDetailFragment extends Fragment {

    private TextView tvCaption;
    private TextView tvUsername;
    private TextView tvTime;
    private ImageView ivImage;

    private PostDetail post;

    public PostDetailFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PostDetailFragment newInstance(String param1, String param2) {
        PostDetailFragment fragment = new PostDetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        post = Parcels.unwrap(getArguments().getParcelable("post"));
        return inflater.inflate(R.layout.fragment_post_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvUsername = view.findViewById(R.id.tvUsername);
        tvCaption = view.findViewById(R.id.tvCaption);
        ivImage = view.findViewById(R.id.ivImage);
        tvTime = view.findViewById(R.id.tvTime);

        tvTime.setText(post.getTime());
        if (post.getImage() != "") {
            Glide.with(getContext()).load(post.getImage()).into(ivImage);
        }
        tvUsername.setText(post.getUsername());
        tvCaption.setText(post.getCaption());
    }
}