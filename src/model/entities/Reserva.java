package model.entities;

import model.exceptions.DomainException;

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
        if (!dataCheckOut.after(dataCheckIn)) {
            throw new DomainException("Data Check-out deve ser maior que a Data Check-in");
        }
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
    public void atualizaDatas(Date dataCheckIn, Date dataCheckOut) {
        Date agora = new Date();
        if (dataCheckIn.before(agora) || dataCheckOut.before(agora)){
            throw new DomainException("Datas da reserva devem ser datas futuras");
        }
        if (!dataCheckOut.after(dataCheckIn)) {
            throw new DomainException("Data Check-out deve ser maior que a Data Check-in");
        }
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
