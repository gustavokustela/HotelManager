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
    private static int num;
    private static long cpf;
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
                    realizarAcao(6);
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
                	realizarAcao(5);
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
            System.out.println("=======================================================================");
        }
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
            System.out.println("=======================================================================");
        }
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
            System.out.println("=======================================================================");
        }
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
                        else {
                            System.out.println("Hospede nao encontrado");
                        }
                    }else {
                        System.out.println("Acesso negado!");
                    }
                    break;
                case 2:
                    if(isFuncionario()) {
                        if (isHospede()){
                            if(isQuarto()){
                                funcionario.realizarCheckin(getHospede(cpf),getQuarto(num));
                            }else {
                                System.out.println("Quarto nao encontrado");
                            }
                        }else {
                            System.out.println("Hospede nao encontrado");
                        }
                    }else {
                        System.out.println("Acesso negado!");
                    }
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
                        firstUser=false;
                    }else{
                        if(isFuncionario()){
                            if(getFuncionario(cod)!=null){
                                if(getFuncionario(cod).isAdmin()){
                                    funcionarios.add(funcionario.cadastrarFuncionario());
                                }else {
                                    System.out.println("Acesso negado!");
                                }
                            }
                        }else{
                            System.out.println("Nao e funcionario!");
                        }
                    }
                    break;
                case 5:
                    if(isFuncionario()){
                        if(getFuncionario(cod)!=null){
                            if(getFuncionario(cod).isAdmin()){
                                quartos.add(funcionario.cadastrarQuarto());
                            }else {
                                System.out.println("Acesso negado!");
                            }
                        }
                    }else{
                        System.out.println("Nao e funcionario!");
                    }
                    break;
                case 6:
                    if(isFuncionario()){
                        if(getFuncionario(cod)!=null){
                            if(getFuncionario(cod).isAdmin()){
                                hospedes.add(funcionario.cadastrarHospede());
                            }else {
                                System.out.println("Acesso negado!");
                            }
                        }
                    }else{
                        System.out.println("Nao e funcionario!");
                    }
                    break;
            }
        System.out.println("=======================================================================");
        System.out.println("Pressione uma tecla para continuar");
        System.in.read();
        clearConsole();
    }

    public static boolean isHospede(){
        boolean isHosp = false;
        HospedeModel hospede = new HospedeModel();
        System.out.print("Digite o cpf do hospede: ");
        hospede.setCpf(reader.nextLong());
        for (HospedeModel hosp:hospedes){
            if(hosp.getCpf()==hospede.getCpf()){
                isHosp=true;
                cpf=hosp.getCpf();
                return isHosp;
            }
        }
        return isHosp;
    }

    public static HospedeModel getHospede(Long cpf){
        HospedeModel hospede = new HospedeModel();
        hospede.setCpf(cpf);
        for (HospedeModel hosp:hospedes){
            if(hosp.getCpf()==hospede.getCpf()){
                return hosp;
            }
        }
        return null;
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
                return is;
            }
        }
        return is;
    }

    public static FuncionarioModel getFuncionario(Long cod){
        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setCodigo(cod);
        for (FuncionarioModel func:funcionarios){
            if(func.getCodigo()==funcionario.getCodigo()){
                return func;
            }
        }
        return null;
    }

    public static boolean isQuarto(){
        boolean is = false;
        QuartoModel quarto = new QuartoModel();
        System.out.print("Digite o numero do quarto: ");
        quarto.setNumero(reader.nextInt());
        for (QuartoModel quar:quartos){
            if(quar.getNumero()==quarto.getNumero()){
                is=true;
                num=quar.getNumero();
                return is;
            }
        }
        return is;
    }

    public static QuartoModel getQuarto(Integer numero){
        QuartoModel quarto = new QuartoModel();
        quarto.setNumero(numero);
        for (QuartoModel quar:quartos){
            if(quar.getNumero()==quarto.getNumero()){
                return quar;
            }
        }
        return null;
    }
}