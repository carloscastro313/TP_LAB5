package com.example.tp_labv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.tp_labv.adapters.PronosticoAdapter;
import com.example.tp_labv.config.Config;
import com.example.tp_labv.connections.PronosticoFetch;

import java.util.ArrayList;
import java.util.List;

public class Pronostico extends AppCompatActivity implements Handler.Callback {

    static List<com.example.tp_labv.models.Pronostico> pronosticos = new ArrayList<>();
    static PronosticoAdapter pronosticoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pronostico);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Pronostico");


        if(!MainActivity.locationTrack.canGetLocation()) throw new RuntimeException();

        double lon = MainActivity.locationTrack.getLongitude();
        double lat = MainActivity.locationTrack.getLatitude();

        Handler handler = new Handler(this);

        PronosticoFetch pronosticoFetch = new PronosticoFetch(handler, Config.getURL(lat,lon,10));

        pronosticoFetch.start();
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {
        List<com.example.tp_labv.models.Pronostico> pronosticoList = (List<com.example.tp_labv.models.Pronostico>) message.obj;

        pronosticoAdapter = new PronosticoAdapter(pronosticoList,this);

        RecyclerView recyclerView = super.findViewById(R.id.rvPronostico);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(pronosticoAdapter);

        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}