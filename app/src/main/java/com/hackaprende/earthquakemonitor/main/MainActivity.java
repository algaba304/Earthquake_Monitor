package com.hackaprende.earthquakemonitor.main;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.hackaprende.earthquakemonitor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "EQACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        if(!esOnline()){
            Toast.makeText(getApplicationContext(), "No hay conexion", Toast.LENGTH_SHORT).show();
        }
        viewModel.getEarthquakes();
        //binding.eqRecycler.setLayoutManager(new LinearLayoutManager(this));

        binding.eqRecycler.setLayoutManager(new GridLayoutManager(this, 1));

        EqAdapter adapter = new EqAdapter();
        adapter.setOnItemClickListener(earthquake ->
                Toast.makeText(MainActivity.this, earthquake.getNombreUsuaio(),
                        Toast.LENGTH_SHORT).show());

        binding.eqRecycler.setAdapter(adapter);

        //Log.d(TAG, viewModel.getEqList().toString());

        viewModel.getEqList().observe(this, eqList -> {
            adapter.submitList(eqList);

            if (eqList.isEmpty()) {
                binding.emptyView.setVisibility(View.VISIBLE);
            } else {
                binding.emptyView.setVisibility(View.GONE);
            }
        });


    }

    private boolean esOnline(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
}