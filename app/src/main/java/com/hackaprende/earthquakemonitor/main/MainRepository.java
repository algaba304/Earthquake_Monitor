package com.hackaprende.earthquakemonitor.main;

import com.hackaprende.earthquakemonitor.Earthquake;
import com.hackaprende.earthquakemonitor.UsuarioDTO;
import com.hackaprende.earthquakemonitor.api.EarthquakeJSONResponse;
import com.hackaprende.earthquakemonitor.api.EqApiClient;
import com.hackaprende.earthquakemonitor.api.Feature;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class MainRepository {

    public interface DownloadEqsListener{
        void onEqsDownloaded(List<UsuarioDTO> earthquakeList);
    }

    public void getEarthquakes(DownloadEqsListener downloadEqsListener) {
        EqApiClient.EqService service = EqApiClient.getInstance().getService();

        service.getEarthquakes().enqueue(new Callback<List<UsuarioDTO>>() {
            @Override
            public void onResponse(Call<List<UsuarioDTO>> call, Response<List<UsuarioDTO>> response) {
                List<UsuarioDTO> lista = response.body();
                downloadEqsListener.onEqsDownloaded(lista);
            }

            @Override
            public void onFailure(Call<List<UsuarioDTO>> call, Throwable t) {

            }
        });
    }

    private List<Earthquake> getEarthquakesWithMoshi(EarthquakeJSONResponse body) {
        ArrayList<Earthquake> eqList = new ArrayList<>();

        List<Feature> features = body.getFeatures();
        for (Feature feature: features) {
            String id = feature.getId();
            double magnitude = feature.getProperties().getMag();
            String place = feature.getProperties().getPlace();
            long time = feature.getProperties().getTime();

            double longitude = feature.getGeometry().getLongitude();
            double latitude = feature.getGeometry().getLatitude();
            Earthquake earthquake = new Earthquake(id, place, magnitude, time,
                    latitude, longitude);
            eqList.add(earthquake);
        }

        return eqList;
    }
}
