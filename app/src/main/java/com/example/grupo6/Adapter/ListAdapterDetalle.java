package com.example.grupo6.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.grupo6.Config.DetalleOrden;
import com.example.grupo6.R;

import java.util.List;

public class ListAdapterDetalle extends RecyclerView.Adapter<ListAdapterDetalle.ViewHolder> {

    private List<DetalleOrden> datos;
    private LayoutInflater inflater;
    private Context context;
    //public static int selectedItem = -1;

    public ListAdapterDetalle(List<DetalleOrden> itemList, Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.datos = itemList;
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    //public static int getSelectedItem() {
   //     return selectedItem;
    //}

    @Override
    public ListAdapterDetalle.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
        View view = inflater.inflate(R.layout.disenio_servicio_detalle_orden, null);
        return new ListAdapterDetalle.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterDetalle.ViewHolder holder, final int position) {
        holder.bindData(datos.get(position));

        //PARA QUE EL SELECTOR FUNCIONE
        //final int currentPosition = position;
        //holder.itemView.setSelected(position == selectedItem);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Actualizar el índice del elemento seleccionado
//          //      selectedItem = currentPosition;
//
//                // Notificar al adaptador de los cambios
//            //    notifyDataSetChanged();
//            }
//        });
    }

    public void setItems(List<DetalleOrden> items) {
        datos = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, cantidad, precio;

        ViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            cantidad=(TextView) itemView.findViewById(R.id.cantidad);
            precio=(TextView) itemView.findViewById(R.id.precio);

        }

        void bindData(final DetalleOrden detalleOrden) {
            nombre.setText(detalleOrden.getNombre());
            cantidad.setText(detalleOrden.getCantidad());
            precio.setText(detalleOrden.getPrecio());
        }
    }

    public void setFilteredList(List<DetalleOrden> filteredList) {
        this.datos = filteredList;
        notifyDataSetChanged();
    }
}

