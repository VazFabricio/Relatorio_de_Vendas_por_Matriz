import java.util.Scanner;

public class Main {

    private static void exibeVendasSemanais(double [][] matriz, String [] nomeMeses) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Vendas das semanas de "+nomeMeses[i]+" ->");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Semana ("+(j+1)+")= "+matriz[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    private static void exibreVendasMensais(double [] vetor, String [] nomeMes) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Soma do mês de "+ nomeMes[i] + ": R$"+vetor[i]);
        }
    }
    private static double [][] registrarMes (Scanner sc, String [] nomeMes){
        double [][] temperatura = new double [12][4];
        for (int i = 0; i < temperatura.length; i++) {
            for (int j = 0; j < temperatura[i].length; j++) {
                System.out.print("Digite o valor vendido na semana "+ (j+1) +" do mes de " + nomeMes[i]+": R$");
                temperatura[i][j] = sc.nextInt();
            }
        }
        return temperatura;
    }
    private static double [] somaLinhas (double [][] matrizDosMeses){
        double [] somaDasLinhas = new double[12];
        for (int i = 0; i < matrizDosMeses.length; i++) {
            for (int j = 0; j < matrizDosMeses[i].length; j++) {
                somaDasLinhas[i] += matrizDosMeses[i][j];
            }
        }
        return somaDasLinhas;
    }
    private static double somaAnual (double [] vendaMensal){
        double somaAnual = 0.0f;
        for (int i = 0; i < vendaMensal.length; i++) {
            somaAnual += vendaMensal[i];
        }
        return somaAnual;
    }
    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

        String [] nomeMes = {
                "Janeiro", "Fevereiro", "Marco", "Abril",
                "Maio", "Junho", "Julho", "Agosto",
                "Setembro", "Outubro", "Novembro", "Dezembro"
        };

       double [][] matriz = registrarMes(sc, nomeMes);
       double [] somaDasLinhas = somaLinhas(matriz);
       double somaAnual = somaAnual(somaDasLinhas);
       System.out.println("===============Relatorio================");
       System.out.println(" ");
       System.out.println("--------Vendas Mensais-------");
       exibreVendasMensais(somaDasLinhas, nomeMes);
       System.out.println(" ");
       System.out.println("--------Vendas Semanais-------");
       exibeVendasSemanais(matriz, nomeMes);
       System.out.println(" ");
       System.out.println("--------Venda Anual-----------");
       System.out.println("Foram vendidos nesse ano: R$"+somaAnual);

    }
}