import Model.FuncionarioModel;
import Model.HospedeModel;
import Model.QuartoModel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{
    private static boolean firstUser = true;
    private static Scanner reader = new Scanner(System.in);
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
    private static List<HospedeModel> hospedes = new ArrayList<HospedeModel>();
    private static List<FuncionarioModel> funcionarios = new ArrayList<FuncionarioModel>();
    private static List<QuartoModel> quartos = new ArrayList<QuartoModel>();
    private static long cod;
    public static void main(String[] args) throws ParseException, IOException {
        int op = -1;
        do {
            System.out.println("   \n" +
                    "    _   _       _       _                                               \n" +
                    "   | | | | ___ | |_ ___| |  _ __ ___   __ _ _ __   __ _  __ _  ___ _ __ \n" +
                    "   | |_| |/ _ \\| __/ _ \\ | | '_ ` _ \\ / _` | '_ \\ / _` |/ _` |/ _ \\ '__|\n" +
                    "   |  _  | (_) | ||  __/ | | | | | | | (_| | | | | (_| | (_| |  __/ |   \n" +
                    "   |_| |_|\\___/ \\__\\___|_| |_| |_| |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_|   \n" +
                    "                                                        |___/           \n" +
                    "   \n" +
                    "===========================================================================");
            System.out.println("=======================|    SELECIONE UMA OPÇAO    |=======================");
            System.out.println("===========================================================================");
            System.out.println("=======================| [1] Cadastrar hospede     |=======================");
            System.out.println("=======================| [2] Listar hospedes       |=======================");
            System.out.println("=======================| [3] Realizar reserva      |=======================");
            System.out.println("=======================| [4] Fazer check-in        |=======================");
            System.out.println("=======================| [5] Fazer check-out       |=======================");
            System.out.println("=======================| [6] Calcular despesas     |=======================");
            System.out.println("=======================| [7] Cadastrar funcionario |=======================");
            System.out.println("=======================| [8] Listar funcionarios   |=======================");
            System.out.println("=======================| [9] Cadastrar quarto      |=======================");
            System.out.println("=======================| [10] Listar quartos       |=======================");
            System.out.println("=======================| [0]       SAIR            |=======================");
            System.out.println("===========================================================================");
            System.out.print("Digite a opcao desejada: ");

            op=reader.nextInt();

            System.out.println("\n");

            switch (op){
                case 0:
                    break;

                case 1:
                    cadastrarHospede();
                    break;

                case 2:
                    listarHospedes();
                    break;

                case 3:
                    realizarAcao(1);
                    break;

                case 4:
                    realizarAcao(2);
                    break;

                case 5:
                    realizarAcao(3);
                    break;

                case 6:
                    break;

                case 7:
                    realizarAcao(4);
                	break;

                case 8:
                    listarFuncionarios();
                    break;

                case 9:
                	cadastrarQuarto();
                    break;

                case 10:
                    listarQuartos();
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    System.out.println("Pressione uma tecla para continuar");
                    System.in.read();
                    clearConsole();
                    break;
            }
        }while(op!=0);
    }

    private static void clearConsole(){
        char c = '\n';
        int length = 30;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        System.out.print(String.valueOf(chars));
    }

    public static void cadastrarHospede() throws ParseException {
        HospedeModel hospede = new HospedeModel();

        System.out.print("\n=======================| Cadastro de Hospedes |=======================\n");

        System.out.print("Nome completo do hospede: ");
        reader.nextLine();
        hospede.setNome(reader.nextLine());

        System.out.print("CPF: ");
        hospede.setCpf(reader.nextLong());

        System.out.print("Data de nascimento (DD-MM-AAAA): ");
        hospede.setDataNasc(formatter.parse(reader.next()));

        System.out.print("Sexo: ");
        hospede.setSexo(reader.next());

        System.out.print("Endereco completo: ");
        reader.nextLine();
        hospede.setEndereco(reader.nextLine());

        System.out.print("Telefone (principal): ");
        hospede.setTelefone(reader.next());

        System.out.print("Hospede e estrangeiro? digite 'true' para SIM ou 'false' para NAO: ");
        hospede.setEstrangeiro(reader.nextBoolean());

        hospedes.add(hospede);

        clearConsole();
    }

    public static void cadastrarQuarto() throws ParseException{
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

        quartos.add(quarto);
        clearConsole();
    }

    public static void listarHospedes() throws IOException {
        System.out.print("\n=======================| Hospedes cadastrados |========================\n");

        for(HospedeModel hospede:hospedes){
            System.out.println("Nome: "+hospede.getNome());
            System.out.println("CPF: "+hospede.getCpf());
            System.out.println("Data de nascimento: "+hospede.getCpf());
            System.out.println("Sexo: "+hospede.getSexo());
            System.out.println("Endereco: "+hospede.getEndereco());
            System.out.println("Telefone: "+hospede.getTelefone());

            if(hospede.isEstrangeiro()==true){
                System.out.println("Estrangeiro");
            } else {
                System.out.println("Nao e estrangeiro");
            }
            System.out.println("Numero de estadas: "+hospede.getQtdEstadas());
        }
        System.out.println("=======================================================================");
        System.out.println("Pressione uma tecla para continuar");
        System.in.read();
        clearConsole();
    }

    public static void listarFuncionarios() throws IOException {
        System.out.print("\n=======================| Funcionarios cadastrados |========================\n");

        for(FuncionarioModel funcionario:funcionarios){
            System.out.println("Nome: "+funcionario.getNome());
            System.out.println("Codigo: "+funcionario.getCodigo());
            System.out.println("CPF: "+funcionario.getCpf());
            System.out.println("Data de nascimento: "+funcionario.getCpf());
            System.out.println("Sexo: "+funcionario.getSexo());
            System.out.println("Endereco: "+funcionario.getEndereco());
            System.out.println("Telefone: "+funcionario.getTelefone());
            System.out.println("Salario: "+funcionario.getSalario());

            if(funcionario.isAdmin()==true){
                System.out.println("E administrador do sistema");
            }else{
                System.out.println("Nao e administrador do sistema");
            }
        }
        System.out.println("=======================================================================");
        System.out.println("Pressione uma tecla para continuar");
        System.in.read();
        clearConsole();
    }

    public static void listarQuartos() throws IOException {
        System.out.print("\n=======================| Quartos Cadastrados |========================\n");

        for(QuartoModel quarto:quartos){
            System.out.println(quarto.getAndar()+"o andar");
            System.out.println("Numero: "+quarto.getNumero());
            System.out.println("Camas de casal: "+quarto.getQtdCamasCasal());
            System.out.println("Camas de solteiro: "+quarto.getQtdCamasSolteiro());
            System.out.println("Valor da diaria: R$"+quarto.getValorDiaria());
            System.out.println(quarto.getAreaM2()+" metros quadrados");

            if(quarto.isSuiteEspecial()==true){
                System.out.println("Suite especial");
            }else {
                System.out.println("Nao e suite especial");
            }
        }
        System.out.println("=======================================================================");
        System.out.println("Pressione uma tecla para continuar");
        System.in.read();
        clearConsole();
    }

    public static void realizarAcao(Integer acao) throws IOException, ParseException {
        HospedeModel hospede = new HospedeModel();
        FuncionarioModel funcionario = new FuncionarioModel();
            switch (acao){
                case 1:
                    if(isFuncionario()) {
                        if (isHospede())
                            funcionario.realizarReserva(hospede);
                        else
                            System.out.println("Hospede nao encontrado");
                    }else System.out.println("Acesso negado!");
                    break;
                case 2:
                    if(isFuncionario()) {
                        if (isHospede())
                            funcionario.realizarCheckin(hospede);
                        else
                            System.out.println("Hospede nao encontrado");
                    }else System.out.println("Acesso negado!");

                    break;
                case 3:
                    if(isFuncionario()) {
                        if (isHospede())
                            funcionario.realizarCheckout(hospede);
                        else
                            System.out.println("Hospede nao encontrado");
                    }else System.out.println("Acesso negado!");
                    break;
                case 4:
                    if (firstUser){
                        funcionarios.add(funcionario.cadastrarFuncionario());
                    }else{
                        if(verificaAdm(getFuncionario(cod))){
                            funcionarios.add(funcionario.cadastrarFuncionario());
                        }else {
                            System.out.println("Acesso negado!");
                        }
                    }
                    break;
            }
        System.out.println("=======================================================================");
        System.out.println("Pressione uma tecla para continuar");
        System.in.read();
        clearConsole();
    }

    public static boolean isFuncionario(){
        boolean is = false;
        FuncionarioModel funcionario = new FuncionarioModel();
        System.out.print("Digite o seu codigo de identificacao: ");
        funcionario.setCodigo(reader.nextLong());
        for (FuncionarioModel func:funcionarios){
            if(func.getCodigo()==funcionario.getCodigo()){
                is=true;
                cod=func.getCodigo();
            }
        }
        return is;
    }

    public static boolean isHospede(){
        boolean isHosp = false;
        HospedeModel hospede = new HospedeModel();
        System.out.print("Digite o nome do hospede: ");
        reader.nextLine();
        hospede.setNome(reader.nextLine());
        for (HospedeModel hosp:hospedes){
            if(hosp.getNome().equals(hospede.getNome())){
                isHosp=true;
            }
        }
        return isHosp;
    }

    public static FuncionarioModel getFuncionario(Long cod){
        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setCodigo(cod);
        if(isFuncionario()){
            for (FuncionarioModel func:funcionarios){
                if(func.getCodigo()==funcionario.getCodigo()){
                    return func;
                }
            }
        }else {
            System.out.println("Não é funcionario!");
        }
        return null;
    }

    public static boolean verificaAdm(FuncionarioModel func){
        if(isFuncionario()){
            return getFuncionario(func.getCodigo()).isAdmin();
        }else{
            System.out.println("Acesso negado!");
        }
        return false;
    }
}