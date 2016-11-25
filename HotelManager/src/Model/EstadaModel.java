package Model;

public class EstadaModel {
    private long codigoIdentificacao;
    private int hospede;
    private int quarto;
    private String dataCheckIn;
    private String dataCheckOut;
    private int isReserva;

    //Constructor
    public EstadaModel(){}

    //Getters and setters
    public long getCodigoIdentificacao() {
        return codigoIdentificacao;
    }

    public void setCodigoIdentificacao(long codigoIdentificacao) {
        this.codigoIdentificacao = codigoIdentificacao;
    }

    public int getHospede() {
        return hospede;
    }

    public void setHospede(int hospede) {
        this.hospede = hospede;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(String dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(String dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public int isReserva() {
        return isReserva;
    }

    public void setReserva(int reserva) {
        isReserva = reserva;
    }

    /*public double calcularDespesa(){
        if(dataCheckOut!=null){
            double despesa = quarto.getValorDiaria();
            if(dataCheckOut.getDay()-dataCheckIn.getDay()>1){
                despesa += (dataCheckOut.getDay()-dataCheckIn.getDay())*quarto.getValorDiaria();
            }
            return despesa;
        } else{
            return 0;
        }
    }*/
}
