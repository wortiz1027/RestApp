package com.developer.restapp.ui.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.developer.restapp.R;
import com.developer.restapp.common.BaseFragment;
import com.developer.restapp.common.BasePresenter;
import com.developer.restapp.component.DaggerMyComponent;
import com.developer.restapp.domain.Post;
import com.developer.restapp.module.PostModule;
import com.developer.restapp.presenter.Presenter;
import com.developer.restapp.ui.adapter.PostsResultsAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

public class LoadPostFragment extends BaseFragment implements com.developer.restapp.ui.view.View {

    @Inject
    Presenter presenter;

    @Inject
    PostsResultsAdapter adapter;

    public LoadPostFragment() {

    }

    @Override
    protected int getFragmentLayout() {
        return 0;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    public void injectDependencies() {
        super.injectDependencies();

        DaggerMyComponent.builder()
                .postModule(new PostModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void displayPosts(ArrayList<Post> posts) {
        presenter.onPostFound(posts);
    }

    @Override
    public void displayErrorPost() {
        Toast.makeText(CONTEXT, R.string.error_load_posts_message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayNetworkError() {
        Toast.makeText(CONTEXT, R.string.error_network_message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayServerError() {
        Toast.makeText(CONTEXT, R.string.error_server_message, Toast.LENGTH_LONG).show();
    }



    /*private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    @Inject
    Presenter presenter;

    public LoadPostFragment() {

    }

    public static LoadPostFragment newInstance(String param1, String param2) {
        LoadPostFragment fragment = new LoadPostFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_load_post, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }*/
}
