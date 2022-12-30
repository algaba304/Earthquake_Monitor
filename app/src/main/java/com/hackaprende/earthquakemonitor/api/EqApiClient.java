package com.hackaprende.earthquakemonitor.api;

import com.hackaprende.earthquakemonitor.UsuarioDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.GET;

public class EqApiClient {

    public interface EqService {
        @GET("api/administradores/US05/refugios")
        Call<List<UsuarioDTO>> getEarthquakes();
    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build();

    private EqService service;

    private static final EqApiClient ourInstance = new EqApiClient();

    public static EqApiClient getInstance() {
        return ourInstance;
    }

    private EqApiClient() {
    }

    public EqService getService() {
        if (service == null) {
            service = retrofit.create(EqService.class);
        }
        return service;
    }
}
