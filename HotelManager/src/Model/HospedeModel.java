package Model;

public class HospedeModel extends PessoaModel{
    private boolean isEstrangeiro;
    private int qtdEstadas;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
