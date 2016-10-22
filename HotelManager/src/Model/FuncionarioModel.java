package Model;

public class FuncionarioModel extends PessoaModel{
    private long codigo;
    private long salario;
    private boolean isAdmin;

    //Getters and setters
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario < 0 ? salario : 0;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
