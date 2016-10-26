package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        reader.nextLine();
        System.out.print("E reserva? Digite 'true' para SIM  e 'false' para NAO: ");
        estada.setReserva(reader.nextBoolean());
        reader.nextLine();
        System.out.println("Checkin realizado!");
        return estada;
    }

    public void realizarCheckout(EstadaModel estada){
        estada.setDataCheckOut(new Date());
        System.out.println("Checkout realizado!");
    }

    public FuncionarioModel cadastrarFuncionario() throws ParseException {
        FuncionarioModel funcionario = new FuncionarioModel();
        System.out.print("\n=======================| Cadastro de Funcionarios |=======================\n");

        System.out.print("Codigo de identificacao: ");
        funcionario.setCodigo(reader.nextLong());
        reader.nextLine();

        System.out.print("Nome completo do funcionario: ");
        funcionario.setNome(reader.nextLine());

        System.out.print("CPF: ");
        funcionario.setCpf(reader.nextLong());
        reader.nextLine();

        System.out.print("Data de nascimento (DD-MM-AAAA): ");
        funcionario.setDataNasc(reader.nextLine());

        System.out.print("Sexo: ");
        funcionario.setSexo(reader.nextLine());

        System.out.print("Endereco completo: ");
        funcionario.setEndereco(reader.nextLine());

        System.out.print("Telefone (principal): ");
        funcionario.setTelefone(reader.nextLine());

        System.out.print("Salario: ");
        funcionario.setSalario(reader.nextLong());
        reader.nextLine();

        System.out.print("E administrador do sistema? digite 'true' para SIM ou 'false' para NAO: ");
        funcionario.setAdmin(reader.nextBoolean());
        reader.nextLine();

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
        hospede.setNome(reader.nextLine());

        System.out.print("CPF: ");
        hospede.setCpf(reader.nextLong());
        reader.nextLine();

        System.out.print("Data de nascimento (DD-MM-AAAA): ");
        hospede.setDataNasc(reader.nextLine());

        System.out.print("Sexo: ");
        hospede.setSexo(reader.nextLine());

        System.out.print("Endereco completo: ");
        hospede.setEndereco(reader.nextLine());

        System.out.print("Telefone (principal): ");
        hospede.setTelefone(reader.nextLine());

        System.out.print("Hospede e estrangeiro? digite 'true' para SIM ou 'false' para NAO: ");
        hospede.setEstrangeiro(reader.nextBoolean());
        reader.nextLine();

        return hospede;
    }
}
