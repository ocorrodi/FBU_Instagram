package com.example.fbu_instagram.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fbu_instagram.PostDetail;
import com.example.fbu_instagram.R;
import com.parse.ParseUser;

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
    private ImageButton imageButton;
    final FragmentManager fragmentManager = getFragmentManager();

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
        imageButton = view.findViewById(R.id.ibProfile);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("user", Parcels.wrap(post.getUser()));
                ProfileFragment fragobj = new ProfileFragment();
                fragobj.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.flContainer, fragobj).commit();
            }
        });

        tvTime.setText(post.getTime());
        if (post.getImage() != "") {
            Glide.with(getContext()).load(post.getImage()).into(ivImage);
        }
        Glide.with(getContext()).load(post.getProfile()).into(imageButton);
        tvUsername.setText(post.getUsername());
        tvCaption.setText(post.getCaption());
    }
}