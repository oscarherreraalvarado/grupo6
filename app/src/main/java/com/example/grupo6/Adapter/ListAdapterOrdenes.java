package com.example.grupo6.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.grupo6.Config.Ordenes;
import com.example.grupo6.R;

import java.util.List;

public class ListAdapterOrdenes extends RecyclerView.Adapter<ListAdapterOrdenes.ViewHolder> {

    private static final long DOUBLE_CLICK_TIME_DELTA = 300; // Intervalo máximo entre dos toques consecutivos (en milisegundos)
    private long lastClickTime = 0; // Tiempo del último toque
    private OnItemDoubleClickListener doubleClickListener;
    private List<Ordenes> datos;
    private LayoutInflater inflater;
    private Context context;
    public static int selectedItem = -1;

    public interface OnItemDoubleClickListener {
        void onItemDoubleClick(Ordenes ordenes);
    }
    public ListAdapterOrdenes(List<Ordenes> itemList, Context context, OnItemDoubleClickListener doubleClickListener) {
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
    public ListAdapterOrdenes.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
        View view = inflater.inflate(R.layout.disenio_ordenes, null);
        return new ListAdapterOrdenes.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterOrdenes.ViewHolder holder, final int position) {
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

    public void setItems(List<Ordenes> items) {
        datos = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ciudad, fecha, total, numOrden;

        ViewHolder(View itemView) {
            super(itemView);
            ciudad = (TextView) itemView.findViewById(R.id.ciudad_txt);
            fecha=(TextView) itemView.findViewById(R.id.fecha_txt);
            total=(TextView) itemView.findViewById(R.id.total_txt);
            numOrden=(TextView) itemView.findViewById(R.id.id_txt);

        }

        void bindData(final Ordenes ordenes) {
            ciudad.setText(ordenes.getCiudad());
            fecha.setText(ordenes.getFecha());
            total.setText(ordenes.getTotal());
           numOrden.setText(ordenes.getNumeroOrden());
        }
    }

    public void setFilteredList(List<Ordenes> filteredList) {
        this.datos = filteredList;
        notifyDataSetChanged();
    }
}

