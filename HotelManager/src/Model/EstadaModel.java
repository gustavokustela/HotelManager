package Model;

import java.util.Date;

public class EstadaModel {
    private long codigoIdentificacao;
    private HospedeModel hospede;
    private QuartoModel quarto;
    private Date dataCheckIn;
    private Date dataCheckOut;
    private boolean isReserva;

    //Constructor
    EstadaModel(){
        dataCheckIn = new Date();
    }

    //Getters and setters
    public long getCodigoIdentificacao() {
        return codigoIdentificacao;
    }

    public void setCodigoIdentificacao(long codigoIdentificacao) {
        this.codigoIdentificacao = codigoIdentificacao;
    }

    public HospedeModel getHospede() {
        return hospede;
    }

    public void setHospede(HospedeModel hospede) {
        this.hospede = hospede;
    }

    public QuartoModel getQuarto() {
        return quarto;
    }

    public void setQuarto(QuartoModel quarto) {
        this.quarto = quarto;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(Date dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(Date dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public boolean isReserva() {
        return isReserva;
    }

    public void setReserva(boolean reserva) {
        isReserva = reserva;
    }
}
