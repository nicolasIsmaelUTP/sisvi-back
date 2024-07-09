package com.sisvi.svc_viajes.service;

import java.util.List;

import com.sisvi.svc_viajes.entities.Viaje;
import com.sisvi.svc_viajes.http.request.ViajeRequest;

public interface PViajeService {
    List<Viaje> obtenerViajes();
    List<Viaje> obtenerViajesPorConductor(Long conductorId);
    List<Viaje> obtenerViajesPorVehiculo(Long vehiculoId);
    List<Viaje> obtenerViajesPorEstado(Boolean estado);
    Viaje obtenerViajePorId(Long id);
    void nuevoViaje(ViajeRequest viajeRequest);
    void finalizarViaje(Long id, String ubicacionFin);
    void cambiarEstadoViaje(Long id);
}
