import Model.HospedeModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    private static Scanner reader = new Scanner(System.in);
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
    public static void main(String[] args) throws ParseException {
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
            System.out.println("=======================|    SELECIONE UMA OPÇÃO    |=======================");
            System.out.println("===========================================================================");
            System.out.println("=======================| [1] Cadastrar hospede     |=======================");
            System.out.println("=======================| [2] Realizar reserva      |=======================");
            System.out.println("=======================| [3] Fazer check-in        |=======================");
            System.out.println("=======================| [4] Fazer check-out       |=======================");
            System.out.println("=======================| [5] Cadastrar funcionário |=======================");
            System.out.println("=======================| [6] Cadastrar quarto      |=======================");
            System.out.println("=======================| [7] Calcular despesas     |=======================");
            System.out.println("=======================| [0]         SAIR          |=======================");
            System.out.println("===========================================================================");
            System.out.print("Digite a opção: ");
            op=reader.nextInt();
            clearConsole();

            switch (op){
                case 0:
                    break;

                case 1:
                    cadastrarHospede();
                    clearConsole();
                    break;

                default:
                    System.out.println("Opção inválida! Pressione enter para digitar uma nova opção.");
                    reader.next();
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
        clearConsole();
        System.out.print("Nome Completo do Hóspede: ");
        hospede.setNome(reader.next());
        System.out.print("CPF: ");
        hospede.setCpf(reader.nextLong());
        System.out.print("Data de nascimento (DD-MM-AAAA): ");
        hospede.setDataNasc(formatter.parse(reader.next()));
        System.out.print("Sexo: ");
        hospede.setSexo(reader.next());
        System.out.print("Endereço Completo: ");
        hospede.setEndereco(reader.next());
        System.out.print("Telefone (principal): ");
        hospede.setTelefone(reader.next());
        System.out.print("Hospede é estrangeiro? digite 'true' para SIM ou 'false' para NÃO: ");
        hospede.setEstrangeiro(reader.nextBoolean());
    }
}
