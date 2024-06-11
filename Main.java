import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            Conta cc = new ContaCorrente();
            Conta cp = new ContaPoupanca();
            boolean continuar = true;
            
            System.out.println("Digite seu nome: ");
            String client = scanner.nextLine();
            System.out.println("Olá " + client + "! possui Conta Corrente e Conta Poupança");
            System.out.println(" ");
            cc.imprimirExtrato();
            System.out.println(" ");
            cp.imprimirExtrato();
            System.out.println(" ");
            System.out.println("Qual conta deseja movimentar? ");
                
            while (continuar) {
                String contaM = scanner.nextLine();

                switch (contaM) {
                    case "corrente":
                        System.out.println("Conta Corrente: ");
                        cc.imprimirExtrato(); 
                        System.out.println("Deseja depositar ou transferir?");
                        String depositarouTransferir = scanner.nextLine();
                        
                        if (depositarouTransferir.equals("depositar")) {
                            System.out.println("Digite o valor: ");
                            int valor = scanner.nextInt();

                            cc.depositar(valor);
                            cc.imprimirExtrato();

                        } else if (depositarouTransferir.equals("transferir")) {

                            System.out.println("Digite o valor: ");
                            int saldo = scanner.nextInt();

                            cc.transferir(saldo, cp);
                            cc.imprimirExtrato();
                        }
                        
                    break;
                
                    case "poupanca":
                        System.out.println("Conta Poupança: ");
                        cp.imprimirExtrato();
                        System.out.println("Deseja transferir ou depositar?");
                        String transferenciaouDeposito = scanner.nextLine();

                        if ((transferenciaouDeposito.equals("transferir")) && (cp.getSaldo() != 0)) {
                            System.out.println("Digite o valor: ");
                            int valor = scanner.nextInt();
                            cp.transferir(valor, cc);
                            cp.imprimirExtrato();

                        } else if ((transferenciaouDeposito.equals("depositar")) && (cp.getSaldo() != 0)) {
        
                                System.out.println("Digite o valor: "); 
                                int valorr = scanner.nextInt();
                                cc.transferir(valorr, cp);
                                cp.imprimirExtrato();
                           
                            
                        }

                    break;
                    
                    case "0":
                        cc.imprimirExtrato();
                        cp.imprimirExtrato();
                        System.out.println("Programa encerrado");
                        return;

                
                }    
            }
        
        }   
    }                   
}

