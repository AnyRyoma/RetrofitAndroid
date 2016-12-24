package com.android.retrofitandroid;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.retrofitandroid.databinding.ActivityMainBinding;
import com.android.retrofitandroid.model.GitHubModel;
import com.android.retrofitandroid.vm.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private GitHubModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setModel(viewModel = new MainViewModel());
        model = new GitHubModel(viewModel);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setPb(true);
                model.getUser(binding.username.getText().toString());
            }
        });
    }
}
