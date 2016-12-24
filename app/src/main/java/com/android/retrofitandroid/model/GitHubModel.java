package com.android.retrofitandroid.model;

import com.android.retrofitandroid.api.GitHubService;
import com.android.retrofitandroid.bean.User;
import com.android.retrofitandroid.net.ServiceGenerator;
import com.android.retrofitandroid.vm.MainViewModel;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitHubModel {
    private GitHubService git;
    private MainViewModel viewModel;


    public GitHubModel(MainViewModel viewModel) {
        this.viewModel = viewModel;
        this.git = ServiceGenerator.createService(GitHubService.class);

    }

    public void getUser(String username) {
        //binding.username.getText().toString()
        Call call = git.getUser(username);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                User model = (User) response.body();

                if (model == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        try {
                            viewModel.setText("responseBody = " + responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        viewModel.setText("responseBody  = null");
                    }
                } else {
                    //200
                    viewModel.setText("Github Name :" + model.getName() + "\nWebsite :" + model.getBlog() + "\nCompany Name :" + model.getCompany());
                }
                viewModel.setPb(false);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                viewModel.setText("t = " + t.getMessage());
                viewModel.setPb(false);
            }
        });
    }

}
