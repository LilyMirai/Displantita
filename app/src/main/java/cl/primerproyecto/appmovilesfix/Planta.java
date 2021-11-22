package cl.primerproyecto.appmovilesfix;

import java.io.Serializable;

public class Planta implements Serializable {
    String nombre;
    String fechaasignada;
    String horaasignada;
    String ultimoregado;

    public Planta(String nombre, String fechaasignada, String horaasignada, String ultimoregado){
        this.nombre = nombre;
        this.fechaasignada = fechaasignada;
        this.horaasignada = horaasignada;
        this.ultimoregado = ultimoregado;

    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaasignada() {
        return fechaasignada;
    }

    public String getHoraasignada() {
        return horaasignada;
    }

    public String getUltimoregado() {
        return ultimoregado;
    }


    @Override
    public String toString() {
        return this.nombre;
    }
}
