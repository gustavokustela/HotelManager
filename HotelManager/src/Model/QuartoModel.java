package Model;

public class QuartoModel {
    private int numero;
    private int andar;
    private String suiteEspecial;
    private int qtdCamasSolteiro;
    private int qtdCamasCasal;
    private float areaM2;
    private float valorDiaria;

    //Getters and setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public String getSuiteEspecial() {
        return suiteEspecial;
    }

    public void setSuiteEspecial(String suiteEspecial) {
        this.suiteEspecial = suiteEspecial;
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

    public float getAreaM2() {
        return areaM2;
    }

    public void setAreaM2(float areaM2) {
        this.areaM2 = areaM2;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
