package Model;

public class QuartoModel {
    private long numero;
    private long andar;
    private boolean isSuiteEspecial;
    private int qtdCamasSolteiro;
    private int qtdCamasCasal;
    private long areaM2;
    private double valorDiaria;

    //Getters and setters
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public long getAndar() {
        return andar;
    }

    public void setAndar(long andar) {
        this.andar = andar;
    }

    public boolean isSuiteEspecial() {
        return isSuiteEspecial;
    }

    public void setSuiteEspecial(boolean suiteEspecial) {
        isSuiteEspecial = suiteEspecial;
    }

    public int getQtdCamasSolteiro() {
        return qtdCamasSolteiro;
    }

    public void setQtdCamasSolteiro(int qtdCamasSolteiro) {
        this.qtdCamasSolteiro = qtdCamasSolteiro;
    }

    public int getQtdCamasCasal() {
        return qtdCamasCasal;
    }

    public void setQtdCamasCasal(int qtdCamasCasal) {
        this.qtdCamasCasal = qtdCamasCasal;
    }

    public long getAreaM2() {
        return areaM2;
    }

    public void setAreaM2(long areaM2) {
        this.areaM2 = areaM2;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
