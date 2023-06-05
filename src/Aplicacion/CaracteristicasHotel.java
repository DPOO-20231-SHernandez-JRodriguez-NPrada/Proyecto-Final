package Aplicacion;

public class CaracteristicasHotel {
    
    private boolean parqueaderoGratis, piscina, zonasHumedas, bbq, 
                    wifiGratis, recepcion24, mascotas;


    public CaracteristicasHotel(boolean parqueaderoGratis, boolean piscina, boolean zonasHumedas, boolean bbq, boolean wifiGratis, boolean recepcion24, boolean mascotas) {
        this.parqueaderoGratis = parqueaderoGratis;
        this.piscina = piscina;
        this.zonasHumedas = zonasHumedas;
        this.bbq = bbq;
        this.wifiGratis = wifiGratis;
        this.recepcion24 = recepcion24;
        this.mascotas = mascotas;
    }

    public boolean isParqueaderoGratis() {
        return parqueaderoGratis;
    }


    public boolean isPiscina() {
        return piscina;
    }


    public boolean isZonasHumedas() {
        return zonasHumedas;
    }


    public boolean isBbq() {
        return bbq;
    }


    public boolean isWifiGratis() {
        return wifiGratis;
    }


    public boolean isRecepcion24() {
        return recepcion24;
    }


    public boolean isMascotas() {
        return mascotas;
    }

}
