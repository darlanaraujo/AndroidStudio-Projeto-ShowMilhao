package com.darlanbonfim.showdomilhao.ui.slideshow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.darlanbonfim.showdomilhao.R;
import com.darlanbonfim.showdomilhao.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;

    //ImageView imgGithub, imgYoutube, imgTwitter, imgDownloadApp;
    Intent navegacao;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);

            }
        });

        // CHAMADA DOS BOTÕES ======================================================================
        final ImageButton imgBtnGit = binding.imgBtnGit;
        imgBtnGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGithub();
            }
        });

        final ImageButton imgBtnTube = binding.imgBtnTube;
        imgBtnTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setYoutube();
            }
        });

        final ImageButton imgBtnTwitter = binding.imgBtnTwitter;
        imgBtnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTwitter();
            }
        });

        final ImageButton imgBtnLink = binding.imgBtnLink;
        imgBtnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLinkedin();
            }
        });

        final ImageView imgDownloadApp = binding.imgDownloadApp;
        imgDownloadApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void setGithub() {
        Toast.makeText(getContext(), "Você será direcionado para o meu GitHub", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navegacao = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/darlanaraujo?tab=repositories"));
                startActivity(navegacao);
            }
        }, 2000);
    }

    public void setYoutube() {
        Toast.makeText(getContext(), "Você será direcionado para minha página no YouTube", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navegacao = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/c/DarlanPAraujo"));
                startActivity(navegacao);
            }
        }, 2000);
    }

    public void setTwitter() {
        Toast.makeText(getContext(), "Você será direcionado para o meu Twitter", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navegacao = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/DarlanPAraujo2"));
                startActivity(navegacao);
            }
        }, 2000);
    }

    public void setLinkedin() {
        Toast.makeText(getContext(), "Você será direcionado para o meu Linkedin", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navegacao = new Intent(Intent.ACTION_VIEW, Uri.parse("https://br.linkedin.com/in/darlanaraujo"));
                startActivity(navegacao);
            }
        }, 2000);
    }

    public void setDonwApp() {
        Toast.makeText(getContext(), "Você será direcionado para o link do App", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navegacao = new Intent(Intent.ACTION_VIEW, Uri.parse("https://br.linkedin.com/in/darlanaraujo"));
                startActivity(navegacao);
            }
        }, 2000);
    }

}