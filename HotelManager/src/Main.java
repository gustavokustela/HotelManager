import Model.FuncionarioModel;
import Model.HospedeModel;
import Model.QuartoModel;

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
            System.out.println("=======================| [1] Cadastrar Hóspede     |=======================");
            System.out.println("=======================| [2] Realizar Reserva      |=======================");
            System.out.println("=======================| [3] Fazer Check-in        |=======================");
            System.out.println("=======================| [4] Fazer Check-out       |=======================");
            System.out.println("=======================| [5] Calcular Despesas     |=======================");
            System.out.println("=======================| [6] Cadastrar Funcionário |=======================");
            System.out.println("=======================| [7] Cadastrar Quarto      |=======================");
            System.out.println("=======================| [0]       SAIR            |=======================");
            System.out.println("===========================================================================");
            System.out.print("Digite a opção desejada: ");
            
            op=reader.nextInt();
            clearConsole();
            

            switch (op){
                case 0:
                    break;

                case 1:
                    cadastrarHospede();
                    clearConsole();
                    break;
                    
                case 6:
                	cadastrarFuncionario();
                	clearConsole();
                	break;
                	
                case 7:
                	cadastrarQuarto();
                	clearConsole();

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
        //clearConsole();
        
        System.out.print("=======================| Cadastro de Hóspedes |=======================\n");
        
        System.out.print("\nNome Completo do Hóspede: ");
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
        
        System.out.print("Hospede é estrangeiro? digite 'true' para SIM ou 'false' para NÃO. ");
        hospede.setEstrangeiro(reader.nextBoolean());
    }
    
    
    
    public static void cadastrarFuncionario() throws ParseException {
        FuncionarioModel funcionario = new FuncionarioModel();
        //clearConsole();
        
        System.out.print("=======================| Cadastro de Funcionários |=======================\n");
        
        System.out.print("\nNome Completo do Funcionário: ");
        funcionario.setNome(reader.next());
        
        System.out.print("CPF: ");
        funcionario.setCpf(reader.nextLong());
        
        System.out.print("Data de nascimento (DD-MM-AAAA): ");
        funcionario.setDataNasc(formatter.parse(reader.next()));
        
        System.out.print("Sexo: ");
        funcionario.setSexo(reader.next());
        
        System.out.print("Endereço Completo: ");
        funcionario.setEndereco(reader.next());
        
        System.out.print("Telefone (principal): ");
        funcionario.setTelefone(reader.next());
        
        System.out.print("Código de Identificação: ");
        funcionario.setCodigo(reader.nextLong());
        
        System.out.print("Salario");
        funcionario.setSalario(reader.nextLong());
        
        System.out.print("É administrador do Sistema? digite 'true' para SIM ou 'false' para NÃO. ");
        funcionario.setAdmin(reader.nextBoolean());
    }
    
    
    
    public static void cadastrarQuarto() throws ParseException{
    	QuartoModel quarto = new QuartoModel();
    	//clearConsole();
    	System.out.print("=======================| Cadastro de Quartos |=======================\n");
    	
    	System.out.print("\nNúmero do Quarto: ");
    	quarto.setNumero(reader.nextInt());
    	
    	System.out.println("Andar: ");
    	quarto.setAndar(reader.nextInt());
    	
    	System.out.println("Quantidade de Camas de Casal: ");
    	quarto.setQtdCamasCasal(reader.nextInt());
    	
    	System.out.println("Quantidade de Camas de Solteiro: ");
    	quarto.setQtdCamasSolteiro(reader.nextInt());
    	
    	System.out.println("É uma Suíte Especial? digite 'true' para SIM ou 'false' para NÃO. ");
    	quarto.setSuiteEspecial(reader.nextBoolean());
    	
    	System.out.print("Valor da Diária do Quarto: ");
    	quarto.setValorDiaria(reader.nextDouble());
    	
    	System.out.println("Área do Quarto (m²): ");
    	quarto.setAreaM2(reader.nextLong());
    }
}
