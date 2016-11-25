package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FuncionarioModel extends PessoaModel{
    private long codigo;
    private float salario;
    private int isAdmin;
    private String user;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
    //Getters and setters
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int isAdmin() {
        return isAdmin;
    }

    public void setAdmin(int admin) {
        isAdmin = admin;
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
