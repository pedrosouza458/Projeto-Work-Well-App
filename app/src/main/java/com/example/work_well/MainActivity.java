package com.example.work_well;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        //gerarResenhas();

        getTasks();

    }

    private void getTasks() {
        Call<Results> call = RetrofitClient.getInstance().getMyApi().getTasks("pedrosouza.ch453@academico.ifsul.edu.br", "12345");
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Log.d("teste", "ENTROU");
                Log.d("teste", response.body().toString());
                Results results = response.body();
                Log.d("teste", results.getMessage());
                tasks = results.getTasks();
                Log.d("teste", tasks.toString());
                RecyclerView rvresenhas = findViewById(R.id.rvresenhas);
                MeuAdaptador adaptador = new MeuAdaptador(tasks);
                RecyclerView.LayoutManager layout =
                        new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                rvresenhas.setLayoutManager(layout);
                rvresenhas.setAdapter(adaptador);
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro", Toast.LENGTH_LONG).show();
            }
        });
    }

}