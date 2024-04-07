package com.example.grupo6.Config;

public class Ordenes {
    private String numeroOrden;
    private String ciudad;
    private String fecha;
    private String total;

    public Ordenes(String numeroOrden, String ciudad, String fecha, String total) {
        this.numeroOrden = numeroOrden;
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.total = total;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
