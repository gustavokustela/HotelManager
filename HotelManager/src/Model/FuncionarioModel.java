package Model;

import java.text.SimpleDateFormat;

public class FuncionarioModel extends PessoaModel{
    private float salario;
    private int admin;
    private String user;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
    //Getters and setters

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int isAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }
}
