package Application2.application;

import Application2.entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);

        Product produto = new Product();
        System.out.println("Entre com os dados do produto: ");
        System.out.print("Nome: ");
        produto.nome = entrada.nextLine();
        System.out.print("Preço: ");
        produto.preco = entrada.nextDouble();
        System.out.print("Quantidade em estoque: ");
        produto.quantidade = entrada.nextInt();

        System.out.println();
        System.out.println("Dados do produto: " + produto.toString());
        System.out.print("Entre com um número de produtos pra ser aderido no estoque: ");
        produto.adicionarProdutos(entrada.nextInt());
        System.out.println("Dados atualizados do produto: " + produto.toString() );
        System.out.print("Entre com um número de produtos pra ser removido do estoque: ");
        produto.removerProdutos(entrada.nextInt());
        System.out.println("Dados atualizados do produto: " + produto.toString() );

        entrada.close();

    }

}
