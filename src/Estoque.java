import java.util.Scanner;
import java.io.*;

public class Estoque{
	
	//Módulo para definir Estoque
	public static double[][] definirEstoque(double[][] dados , Mascaras InfantilLisa , Mascaras InfantilEstampada , Mascaras AdultaLisa , Mascaras AdultaEstampada   )
	{
		
		Scanner entrada = new Scanner(System.in);

		System.out.print("Quantas máscaras Infantis Lisas adicionar ao estoque?");
		InfantilLisa.setEstoque(entrada.nextInt());
		System.out.print("Quantas máscaras Infantis Estampadas adicionar ao estoque?");
		InfantilEstampada.setEstoque(entrada.nextInt());
		System.out.print("Quantas máscaras Adultas Lisas adicionar ao estoque?");
		AdultaLisa.setEstoque(entrada.nextInt());
		System.out.print("Quantas máscaras Adultas Estampadas adicionar ao estoque?");
		AdultaEstampada.setEstoque(entrada.nextInt());
		
		dados[0][0] = InfantilLisa.getEstoque();
		dados[1][0] = InfantilEstampada.getEstoque();
		dados[2][0] = AdultaLisa.getEstoque();
		dados[3][0] = AdultaEstampada.getEstoque();
	
		return dados;
	}
	//Módulo para preencher o preço da produção
	public static double[][] definirCustoDeProd(Mascaras InfantilLisa , Mascaras InfantilEstampada , Mascaras AdultaLisa , Mascaras AdultaEstampada)
	{
		double[][] dados = new double[4][5];
		Scanner entrada = new Scanner(System.in);

		System.out.print("Qual o custo de produção de cada máscara Infantil Lisa?");
		InfantilLisa.setCustoDeProducao(entrada.nextDouble());
		System.out.print("Qual o custo de produção de cada máscara Infantil Estampada?");
		InfantilEstampada.setCustoDeProducao(entrada.nextDouble());
		System.out.print("Qual o custo de produção de cada máscara Adulta Lisa?");
		AdultaLisa.setCustoDeProducao(entrada.nextDouble());
		System.out.print("Qual o custo de produção de cada máscara Adulta Estampada?");
		AdultaEstampada.setCustoDeProducao(entrada.nextDouble());

		dados[0][1] = InfantilLisa.getCustoDeProducao();
		dados[1][1] = InfantilEstampada.getCustoDeProducao();
		dados[2][1] = AdultaLisa.getCustoDeProducao();
		dados[3][1] = AdultaEstampada.getCustoDeProducao();
		return dados;
	}
	//Módulo para preencher o preço de venda
	public static double[][] precoDeVenda(Mascaras InfantilLisa , Mascaras InfantilEstampada , Mascaras AdultaLisa , Mascaras AdultaEstampada   )
	{
		double[][] dados = new double[4][5];
		Scanner entrada = new Scanner(System.in);

		System.out.print("Qual o preço de venda de cada máscara Infantil Lisa?");
		InfantilLisa.setPrecoDeVenda(entrada.nextDouble());
		System.out.print("Qual o preço de venda de cada máscara Infantil Estampada?");
		InfantilEstampada.setPrecoDeVenda(entrada.nextDouble());
		System.out.print("Qual o preço de venda de cada máscara Adulta lisa?");
		AdultaLisa.setPrecoDeVenda(entrada.nextDouble());
		System.out.print("Qual o preço de venda de cada máscara Adulta Estampada?");
		AdultaEstampada.setPrecoDeVenda(entrada.nextDouble());

		dados[0][2] = InfantilLisa.getPrecoDeVenda();
		dados[1][2] = InfantilEstampada.getPrecoDeVenda();
		dados[2][2] = AdultaLisa.getPrecoDeVenda();
		dados[3][2] = AdultaEstampada.getPrecoDeVenda();
		
		
		return dados;
	}
	//Módulo exibicao menu
	public static void exibirEstoque(double dados[][])
	{
			System.out.printf("Estoque de máscaras infantis lisas : %.0f unidades\n" , dados[0][0]);
			System.out.printf("Estoque de máscaras infantis Estampadas : %.0f unidades\n" , dados[1][0]);
			System.out.printf("Estoque de máscaras adultas Lisas: %.0f unidades\n" , dados[2][0]);
			System.out.printf("Estoque de máscaras adultas Lisas: %.0f unidades\n\n" , dados[3][0]);	
	}
	//Módulo para exibir o estoque
	public static void GravarArquivo(double dados[][] , Mascaras InfantilLisa , Mascaras InfantilEstampada , Mascaras AdultaLisa , Mascaras AdultaEstampada , int i)
	{
	try {	
		
			dados[0][0] = InfantilLisa.getEstoque();
			dados[1][0] = InfantilEstampada.getEstoque();
			dados[2][0] = AdultaLisa.getEstoque();
			dados[3][0] = AdultaEstampada.getEstoque();
	
			dados[0][1] = InfantilLisa.getCustoDeProducao();
			dados[1][1] = InfantilEstampada.getCustoDeProducao();
			dados[2][1] = AdultaLisa.getCustoDeProducao();
			dados[3][1] = AdultaEstampada.getCustoDeProducao();
			
			dados[0][2] = InfantilLisa.getPrecoDeVenda();
			dados[1][2] = InfantilEstampada.getPrecoDeVenda();
			dados[2][2] = AdultaLisa.getPrecoDeVenda();
			dados[3][2] = AdultaEstampada.getPrecoDeVenda();
			
			dados[0][3] = InfantilLisa.getMascarasVendidas();
			dados[1][3] = InfantilEstampada.getMascarasVendidas();
			dados[2][3] = AdultaLisa.getMascarasVendidas();
			dados[3][3] = AdultaEstampada.getMascarasVendidas();
			
			dados[0][4] = InfantilLisa.getlucro();
			dados[1][4] = InfantilEstampada.getlucro();
			dados[2][4] = AdultaLisa.getlucro();
			dados[3][4] = AdultaEstampada.getlucro();
			
			//Cada dia será feito um novo relatório
			FileWriter relatorio = new FileWriter("relatorioDia" + i + ".txt" , true);
			
			//Vetor de strings para escrever no relatório de estoque
			String[] Masks = {"Infantil lisa: ", "Infantil Estampada: ", "Adulta Lisa: ", "Adulta Estampada: "};
			
			//For passando pelo pelas linhas da coluna do estoque e escrevendo no relatório o estoque de cada item
			for(int ln = 0 ; ln < dados.length; ln++){
				relatorio.write("Estoque atual de máscara "+ Masks[ln] +(int) dados[ln][0] +" UN"+"\n");
			}
			
			//For para calcular o lucro e escrever no relatório
			double lucroTotal = 0;
			for(int ln = 0; ln < dados.length; ln++){
				lucroTotal += dados[ln][4];

			}
			//Escrita do lucro no arquivo
			relatorio.write("\nlucro total do dia: R$"+lucroTotal+"0");
			
			relatorio.close();

		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());	
		}		
	}
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Mascaras InfantilLisa = new Mascaras();
		Mascaras InfantilEstampada = new Mascaras();
		Mascaras AdultaLisa = new Mascaras();
		Mascaras AdultaEstampada = new Mascaras();
		double[][] dados = new double[4][5];
		int escolha = 0 ;
			
		//While para o cóigo ser executado até o usuário escolher a opção de sair
		while(escolha != 5)
		{	
			//Menu exibido na tela para o usuário indicar o que fazer
			System.out.println();
			System.out.println("O que deseja fazer?\n\n1 - Adicionar máscaras ao estoque\n2 - Definir custo de produção\n3 - Definir preço de venda\n4 - Exibir o estoque\n\n5 - Ir para o controle de vendas");
			escolha = entrada.nextInt();

			switch (escolha) {
				case 1 -> dados = definirEstoque(dados, InfantilLisa, InfantilEstampada, AdultaLisa, AdultaEstampada);
				case 2 -> dados = definirCustoDeProd(InfantilLisa, InfantilEstampada, AdultaLisa, AdultaEstampada);
				case 3 -> dados = precoDeVenda(InfantilLisa, InfantilEstampada, AdultaLisa, AdultaEstampada);
				case 4 -> exibirEstoque(dados);
				case 5 -> System.out.print("");
				default -> System.out.print("Opção inválida\n");
			}
		}
		
	//For para simular a execução do app durante alguns dias , cada repetição é um dia
	for(int i = 1 ; i < 100; i++){
		System.out.println();
		System.out.println("DIA " + i);
		int  mascara = 0 , tipo = 0 , cont = 1;
	
	//While para o cóigo ser executado até o usuário escolher a opção de sair e switch com lambda
	while(cont != 3 && cont != 2){
		System.out.println("\nVendas\n1 - Registrar venda de Máscara Infantil\n2 - Registrar venda de máscara Adulta");
		mascara = entrada.nextInt();
		switch (mascara) {
			case 1 -> {
				System.out.println("Tipo de máscara: \n1 - Lisa\n2 - Estampada?");
				tipo = entrada.nextInt();
				switch (tipo) {
					case 1 -> {
						System.out.print("Foram quantas vendas de Máscara Infantil Lisa?");
						InfantilLisa.Vendas(entrada.nextInt());
					}
					case 2 -> {
						System.out.print("Foram quantas vendas de Máscara Infantil Estampada?");
						InfantilEstampada.Vendas(entrada.nextInt());
					}
				}
			}
			case 2 -> {
				System.out.println("Tipo de máscara: \n1 - Lisa\n2 - Estampada?");
				tipo = entrada.nextInt();
				switch (tipo) {
					case 1 -> {
						System.out.print("Foram quantas vendas de Máscara Adulta Lisa?");
						AdultaLisa.Vendas(entrada.nextInt());
					}
					case 2 -> {
						System.out.print("Foram quantas vendas de Máscara Adulta Estampada?");
						AdultaEstampada.Vendas(entrada.nextInt());
					}
				}
			}
		}
		System.out.println();
		System.out.println("1 - Registrar mais vendas\n2- adicionar máscaras ao estoque ,encerrar dia e gerar Relatório\n\n3 - Encerrar dia e gerar Relatório");
		cont = entrada.nextInt();

		switch(cont){
			case 2 -> {dados = definirEstoque(dados, InfantilLisa, InfantilEstampada, AdultaLisa, AdultaEstampada);	}

		}
		
	}
	//Ao final do dia , será feito o relatório em arquivo
	GravarArquivo(dados , InfantilLisa , InfantilEstampada , AdultaLisa , AdultaEstampada , i);
	
	//A cada dia novo , será reiniciado o valor de mascaras vendidas
	InfantilLisa.setMascarasVendidas(0);
	InfantilEstampada.setMascarasVendidas(0);
	AdultaLisa.setMascarasVendidas(0);
	
}		
entrada.close();

	}

}

class Mascaras{
	private int estoque;
	private double custoDeProducao;
	private double precoDeVenda;
	private int MascarasVendidas;
	private double lucro;

	public Mascaras(){
		estoque = 000;
		custoDeProducao = 000;
		precoDeVenda = 000;
		MascarasVendidas = 000;
		lucro = 000;
		
	}

	public void setEstoque(int estoque){
		if(estoque >= 0)
		{this.estoque += estoque;}
		else {System.out.println("\nErro - Estoque não pode ser negativo");}
	}
	public int getEstoque()
	{return estoque;}
	
	
	public void setCustoDeProducao(double custoDeProducao ){
		if(custoDeProducao > 0)
		{this.custoDeProducao = custoDeProducao;}
		else {System.out.println("\nErro - Custo de producao deve ser maior que zero");}
	}
	public double getCustoDeProducao()
	{return custoDeProducao;}

	public void setPrecoDeVenda(double precoDeVenda) {
		if(precoDeVenda > 0)
		{this.precoDeVenda = precoDeVenda;}
		else {System.out.println("\nErro - Preco de venda deve ser maior que zero.");}
	}
	public double getPrecoDeVenda()
	{return precoDeVenda;}

	public  void Vendas(int vendas){
		if(estoque >= vendas)
		{
			estoque -= vendas;
			MascarasVendidas += vendas;
		}
		else {System.out.println("\nErro - Estoque insuficiente");}
	}
	
	public void setMascarasVendidas(int zero)
	{
		MascarasVendidas = 0;
	}
	public int getMascarasVendidas() 
	{
		return MascarasVendidas;
	}
	
	public double getlucro()
	{
		return (precoDeVenda - custoDeProducao)*MascarasVendidas;
	}
}
