package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Integer nroQuarto;
    private Date dataCheckIn;
    private Date dataCheckOut;

    public Reserva() {
    }

    public Reserva(Integer nroQuarto, Date dataCheckIn, Date dataCheckOut) {
        this.nroQuarto = nroQuarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    public Integer getNroQuarto() {
        return nroQuarto;
    }

    public void setNroQuarto(Integer nroQuarto) {
        this.nroQuarto = nroQuarto;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }

    public long permanencia(){
        long diff = dataCheckOut.getTime() - dataCheckIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public void atualizaDatas(Date dataCheckIn, Date dataCheckOut){
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    @Override
    public String toString() {
        return "Quarto " + nroQuarto +
                ", Data Check-in: " + sdf.format(dataCheckIn) +
                ", Data Check-out: " + sdf.format(dataCheckOut) +
                ", " + permanencia() + " noites";
    }
}
