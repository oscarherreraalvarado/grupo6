package com.example.grupo6.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.grupo6.Config.Locales;
import com.example.grupo6.Config.Ordenes;
import com.example.grupo6.Config.Servicios;
import com.example.grupo6.R;

import java.util.List;

public class ListAdapterLocales extends RecyclerView.Adapter<ListAdapterLocales.ViewHolder> {

    private static final long DOUBLE_CLICK_TIME_DELTA = 300; // Intervalo máximo entre dos toques consecutivos (en milisegundos)
    private long lastClickTime = 0; // Tiempo del último toque
    private ListAdapterLocales.OnItemDoubleClickListener doubleClickListener;
    public static int selectedItem = -1;
    private List<Locales> datos;
    private LayoutInflater inflater;
    private Context context;


    public interface OnItemDoubleClickListener {
        void onItemDoubleClick(Locales locales);
    }
    public ListAdapterLocales(List<Locales> itemList, Context context, ListAdapterLocales.OnItemDoubleClickListener doubleClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.datos = itemList;
        this.doubleClickListener = doubleClickListener;
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static int getSelectedItem() {
         return selectedItem;
    }

    @Override
    public ListAdapterLocales.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
        View view = inflater.inflate(R.layout.disenio_locales, null);
        return new ListAdapterLocales.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterLocales.ViewHolder holder, final int position) {
        holder.bindData(datos.get(position));

        //PARA QUE EL SELECTOR FUNCIONE
        final int currentPosition = position;
        holder.itemView.setSelected(position == selectedItem);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Actualizar el índice del elemento seleccionado
                selectedItem = currentPosition;

                // Notificar al adaptador de los cambios
                notifyDataSetChanged();


                //*************************DETECTAR EL DOBLE CLIC*******************************************
                // Obtener el tiempo actual del sistema
                long clickTime = System.currentTimeMillis();

                // Verificar si el tiempo transcurrido desde el último toque es menor que el intervalo máximo
                if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA) {
                    // Doble clic detectado
                    if (doubleClickListener != null) {
                        doubleClickListener.onItemDoubleClick(datos.get(position));
                        //Toast.makeText(context.getApplicationContext(), "Hola  ", Toast.LENGTH_LONG).show();
                    }
                }

                // Actualizar el tiempo del último toque
                lastClickTime = clickTime;
            }
        });
    }

    public void setItems(List<Locales> items) {
        datos = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, ciudad, direccion;

        ViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombreLocal);
            ciudad=(TextView) itemView.findViewById(R.id.ciudadLocal);
            direccion=(TextView) itemView.findViewById(R.id.direccionLocal);

        }

        void bindData(final Locales locales) {
            nombre.setText(locales.getNombre());
            ciudad.setText(locales.getCiudad());
            direccion.setText(locales.getDireccion());
        }
    }

    public void setFilteredList(List<Locales> filteredList) {
        this.datos = filteredList;
        notifyDataSetChanged();
    }
}

