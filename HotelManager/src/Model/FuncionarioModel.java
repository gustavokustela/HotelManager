package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FuncionarioModel extends PessoaModel{
    private long codigo;
    private long salario;
    private boolean isAdmin;

    private Scanner reader = new Scanner(System.in);
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");

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

    public void realizarReserva(HospedeModel hospede){
        System.out.println("Reserva realizada!");
    }

    public void realizarCheckin(HospedeModel hospede){
        System.out.println("Checkin realizado!");
    }

    public void realizarCheckout(HospedeModel hospede){
        System.out.println("Checkout realizado!");
    }

    public FuncionarioModel cadastrarFuncionario() throws ParseException {
        FuncionarioModel funcionario = new FuncionarioModel();

        System.out.print("\n=======================| Cadastro de Funcionarios |=======================\n");

        System.out.print("Nome completo do funcionario: ");
        funcionario.setNome(reader.nextLine());

        System.out.print("CPF: ");
        funcionario.setCpf(reader.nextLong());

        System.out.print("Data de nascimento (DD-MM-AAAA): ");
        funcionario.setDataNasc(formatter.parse(reader.next()));

        System.out.print("Sexo: ");
        funcionario.setSexo(reader.next());

        System.out.print("Endereco completo: ");
        reader.nextLine();
        funcionario.setEndereco(reader.nextLine());

        System.out.print("Telefone (principal): ");
        funcionario.setTelefone(reader.next());

        System.out.print("Codigo de identificacao: ");
        funcionario.setCodigo(reader.nextLong());

        System.out.print("Salario: ");
        funcionario.setSalario(reader.nextLong());

        System.out.print("E administrador do sistema? digite 'true' para SIM ou 'false' para NAO: ");
        funcionario.setAdmin(reader.nextBoolean());

        return funcionario;
    }
}
