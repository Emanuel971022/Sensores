package com.example.macaco.verfisensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /***
//sensonrmanager para administrar los sensores
        SensorManager sensonr=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        //obtenemos todos los sensores
       List<Sensor>sensores=sensonr.getSensorList(Sensor.TYPE_ALL);
        int size=sensores.size();
        txtinfo.setText(""+" numero de sensores : "+size);

        for(int i=0;i<size;i++){

            //obtenemos el sensor

            Sensor s=sensores.get(i);
            int tipo=s.getType();

            txtinfo.append(""+"tipo :" +tipo);

            String nombre=s.getName();
            txtinfo.append("" + " nombre  "+nombre );

            String vendedor=s.getVendor();
            txtinfo.append(""+ " Vendedor :"+ vendedor);

            float power=s.getPower();
            txtinfo.append(""+" power: "+power);

            float resolucion =s.getResolution();
            txtinfo.append("" +"Resolcuion "+resolucion);


            float rango =s.getMaximumRange();
            txtinfo.append(""+ "Maximo rango "+rango);



        }
         **/


        SensorManager smm;
        ListView lstinfo =(ListView)findViewById(R.id.lstinfo);
        List<Sensor>sensores;



        smm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensores = smm.getSensorList(Sensor.TYPE_ALL);
        lstinfo.setAdapter(new ArrayAdapter<Sensor>(this, android.R.layout.simple_list_item_1,  sensores));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
