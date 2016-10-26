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
        this.salario = salario;
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

    public EstadaModel realizarCheckin(HospedeModel hospede, QuartoModel quarto){
        EstadaModel estada = new EstadaModel();
        estada.setHospede(hospede);
        estada.setQuarto(quarto);
        System.out.print("Digite o codigo de identificacao da estada: ");
        estada.setCodigoIdentificacao(reader.nextLong());
        System.out.println("E reserva? Digite 'true' para SIM  e 'false' para NAO: ");
        estada.setReserva(reader.nextBoolean());
        System.out.println("Checkin realizado!");
        return estada;
    }

    public void realizarCheckout(HospedeModel hospede){
        System.out.println("Checkout realizado!");
    }

    public FuncionarioModel cadastrarFuncionario() throws ParseException {
        FuncionarioModel funcionario = new FuncionarioModel();

        System.out.print("\n=======================| Cadastro de Funcionarios |=======================\n");

        System.out.print("Nome completo do funcionario: ");
        reader.next();
        funcionario.setNome(reader.nextLine());

        System.out.print("CPF: ");
        funcionario.setCpf(reader.nextLong());

        System.out.print("Data de nascimento (DD-MM-AAAA): ");
        reader.next();
        funcionario.setDataNasc(reader.nextLine());

        System.out.print("Sexo: ");
        reader.next();
        funcionario.setSexo(reader.nextLine());

        System.out.print("Endereco completo: ");
        reader.next();
        funcionario.setEndereco(reader.nextLine());

        System.out.print("Telefone (principal): ");
        reader.next();
        funcionario.setTelefone(reader.nextLine());

        System.out.print("Codigo de identificacao: ");
        funcionario.setCodigo(reader.nextLong());

        System.out.print("Salario: ");
        funcionario.setSalario(reader.nextLong());

        System.out.print("E administrador do sistema? digite 'true' para SIM ou 'false' para NAO: ");
        funcionario.setAdmin(reader.nextBoolean());

        return funcionario;
    }

    public QuartoModel cadastrarQuarto(){
        QuartoModel quarto = new QuartoModel();
        System.out.print("\n=======================| Cadastro de Quartos |========================\n");

        System.out.print("Numero do quarto: ");
        quarto.setNumero(reader.nextInt());

        System.out.print("Andar: ");
        quarto.setAndar(reader.nextInt());

        System.out.print("Quantidade de camas de casal: ");
        quarto.setQtdCamasCasal(reader.nextInt());

        System.out.print("Quantidade de camas de solteiro: ");
        quarto.setQtdCamasSolteiro(reader.nextInt());

        System.out.print("E uma suite especial? Digite 'true' para SIM ou 'false' para NAO: ");
        quarto.setSuiteEspecial(reader.nextBoolean());

        System.out.print("Valor da diaria do quarto: ");
        quarto.setValorDiaria(reader.nextDouble());

        System.out.print("Area do quarto (m2): ");
        quarto.setAreaM2(reader.nextLong());

        return quarto;
    }

    public HospedeModel cadastrarHospede() throws ParseException {
        HospedeModel hospede = new HospedeModel();

        System.out.print("\n=======================| Cadastro de Hospedes |=======================\n");

        System.out.print("Nome completo do hospede: ");
        reader.next();
        hospede.setNome(reader.nextLine());

        System.out.print("CPF: ");
        hospede.setCpf(reader.nextLong());

        System.out.print("Data de nascimento (DD-MM-AAAA): ");
        reader.next();
        hospede.setDataNasc(reader.nextLine());

        System.out.print("Sexo: ");
        reader.next();
        hospede.setSexo(reader.nextLine());

        System.out.print("Endereco completo: ");
        reader.next();
        hospede.setEndereco(reader.nextLine());

        System.out.print("Telefone (principal): ");
        reader.next();
        hospede.setTelefone(reader.nextLine());

        System.out.print("Hospede e estrangeiro? digite 'true' para SIM ou 'false' para NAO: ");
        hospede.setEstrangeiro(reader.nextBoolean());

        return hospede;
    }
}
