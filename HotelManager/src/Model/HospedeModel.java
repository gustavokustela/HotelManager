package Model;

public class HospedeModel extends PessoaModel{
    private boolean isEstrangeiro;
    private int qtdEstadas;

    //Getters and setters
    public boolean isEstrangeiro() {
        return isEstrangeiro;
    }

    public void setEstrangeiro(boolean estrangeiro) {
        isEstrangeiro = estrangeiro;
    }

    public int getQtdEstadas() {
        return qtdEstadas;
    }

    public void setQtdEstadas(int qtdEstadas) {
        this.qtdEstadas = qtdEstadas;
    }
}
