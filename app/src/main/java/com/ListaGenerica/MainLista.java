package com.ListaGenerica;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.ListaGenerica.R.id.txtlista;

public class MainLista extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_lista, container, false);

            /**
             * USO DE UNA LISTA GENERICA
             * ESTA LISTA DEVOLVERA LOS DATOS COMO STRING
             * MODIFICAR AL GUSTO EL VIEW LAYOUT lista_layout
             * */


            /*
                Solo imprimiremos numeros
            * */

            List<String> listado = new ArrayList<String>();
            for(int i =0 ; i < 10 ; i++)
                listado.add(String.valueOf((i+1)));

            ListView lista = (ListView) rootView.findViewById(R.id.lista_view);
            lista.setAdapter(new GenericList(rootView.getContext() , listado , R.layout.lista_layout , txtlista));


            return rootView;
        }
    }

}
