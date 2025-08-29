package com.example.mov_tp01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    private Context context;
    @Override
    public void onReceive(Context context, Intent intent) {

        boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
        if (isAirplaneModeOn){
        Toast.makeText(context, "Modo Avión ACTIVADO", Toast.LENGTH_LONG).show();
        // Generar un Intent implícito para abrir la aplicación de llamadas
        Intent callIntent = new Intent(Intent.ACTION_CALL); // Usa ACTION_CALL para llamar directamente
        callIntent.setData(Uri.parse("tel:2664553747"));
        callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // Necesario si se llama desde un BroadcastReceiver
        context.startActivity(callIntent);
    }
    }

}


