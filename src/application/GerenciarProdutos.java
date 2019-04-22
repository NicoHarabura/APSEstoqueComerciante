package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Eletronico;
import entities.Movel;
import entities.Perecivel;
import entities.Produto;

public class GerenciarProdutos {

	public static List<Produto> produtos = new ArrayList<>();

	public static void adicionar(Produto p) {
		System.out.println("\nPRODUTO ADICIONADO");
		System.out.println("--------------------------------------------");
		produtos.add(p);
	}

	public static boolean remover(int code) {
		boolean resultado = false;
		for (Produto p : produtos) {
			if (p.getCode() == code) {
				System.out.println("\nPRODUTO REMOVIDO");
				;
				System.out.println("--------------------------------------------");
				return resultado = produtos.remove(p);
			}
		}
		System.out.println("\nPRODUTO NÃO ENCONTRADO");
		System.out.println("--------------------------------------------");
		return resultado;
	}

	public static Produto buscarPorCodigo(int code) {
		for (Produto p : produtos) {
			if (p.getCode() == code) {
				System.out.println("\nPRODUTO LOCALIZADO");
				System.out.println(p.toString());
				System.out.println("--------------------------------------------");
				return p;
			}
		}
		System.out.println("\nPRODUTO NÃO LOCALIZADO");
		System.out.println("--------------------------------------------");
		return null;
	}

	public static String listarEletronicos() {
		for (Produto p : produtos) {
			if (p instanceof Eletronico) {
				System.out.println(p.toString());
			}
		}
		return "";
	}

	public static String listarPereciveis() {
		for (Produto p : produtos) {
			if (p instanceof Perecivel) {
				System.out.println(p.toString());
			}
		}
		return "";
	}

	public static String listarMoveis() {
		for (Produto p : produtos) {
			if (p instanceof Movel) {
				System.out.println(p.toString());
			}
		}
		return "";
	}

	public static String listarEstoqueMenorQue(int quantidadeMinima) {
		for (Produto p : produtos) {
			if (p.getStock() < quantidadeMinima) {
				System.out.println(p.toString());
			}
		}
		return "";
	}

	public static String listarEstoqueVazio() {
		for (Produto p : produtos) {
			if (p.getStock() <= 0) {
				System.out.println(p.toString());
			}
		}
		return "";
	}

	public static String listarPorFabricante(String manufacturer) {
		for (Produto p : produtos) {
			if (p.getManufacturer().equalsIgnoreCase(manufacturer)) {
				System.out.println(p.toString());
			}
		}
		return "";
	}

	public static String listarPorValidade(LocalDate expireDate) {
		for (Produto p : produtos) {
			if (p instanceof Perecivel && ((Perecivel) p).getExpireDate().isEqual(expireDate)) {
				System.out.println(p.toString());
			}
		}
		return "";
	}

	public static double venderProduto(int codigoProduto, int quantidade) {
		for (Produto p : produtos) {
			if (p.getCode() == codigoProduto) {
				System.out.print("R$");
				return p.vender(quantidade);
			}
		}
		System.out.println("PRODUTO NÃO ENCONTRADO");
		return -1;
	}

	public static boolean comprarProduto(int codigoProduto, int quantidade) {
		boolean resultado = false;
		for (Produto p : produtos) {
			if (p.getCode() == codigoProduto) {
				System.out.println("COMPRA REALIZADA");
				p.comprar(quantidade);
				return resultado = true;
			}
		}
		System.out.println("PRODUTO NÃO ENCONTRADO");
		return resultado;
	}

	public static String listarTudo() {
		for (Produto p : produtos) {
			System.out.println(p);
			System.out.println("--------------------------------------------");
		}
		return "";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("----------------BEM VINDO AO APS STOCK SYSTEM----------------");
		System.out.println("---------------------------------------------------------------");
		int op = 14;
		while (op != 0) {
			// MENU PRINCIPAL
			System.out.println();
			System.out.println("Digite o número correspondente a opção desejada: ");
			System.out.println("1 - Cadastrar um novo produto");
			System.out.println("2 - Remover um produto");
			System.out.println("3 - Localizar um produto pelo código");
			System.out.println("4 - Listar todos Eletrônicos");
			System.out.println("5 - Listar Perecíveis");
			System.out.println("6 - Listar Móveis");
			System.out.println("7 - Listar itens que estejam com estoque abaixo do desejado");
			System.out.println("8 - Listar itens fora de estoque");
			System.out.println("9 - Filtrar produtos por fabricante");
			System.out.println("10 - Mostrar produtos que vencerão em uma data específica");
			System.out.println("11 - Vender produto");
			System.out.println("12 - Comprar Produto");
			System.out.println("13 - Listar todos os produtos");
			System.out.println();
			System.out.println("Ou 0 - Para sair do sistema");
			op = sc.nextInt();
			while (op < 0 || op > 13) {
				System.out.println();
				System.out.println("-------------------OPÇÃO INVÁLIDA-------------------------");
				System.out.println();
				System.out.println("Digite o número correspondente a opção desejada: ");
				System.out.println("1 - Cadastrar um novo produto");
				System.out.println("2 - Remover um produto");
				System.out.println("3 - Localizar um produto pelo código");
				System.out.println("4 - Listar todos Eletrônicos");
				System.out.println("5 - Listar Perecíveis");
				System.out.println("6 - Listar Móveis");
				System.out.println("7 - Listar itens que estejam com estoque abaixo do desejado");
				System.out.println("8 - Listar itens fora de estoque");
				System.out.println("9 - Filtrar produtos por fabricante");
				System.out.println("10 - Mostrar produtos que vencerão em uma data específica");
				System.out.println("11 - Vender produto");
				System.out.println("12 - Comprar Produto");
				System.out.println("13 - Listar todos os produtos");
				System.out.println();
				System.out.println("Ou 0 - Para sair do sistema");
				op = sc.nextInt();
			}

			// MENU LISTAR TODOS OS PRODUTOS:
			if (op == 13) {
				listarTudo();
				op = 14;
			}

			// MENU ADICIONAR PRODUTO
			while (op == 1) {
				System.out.println();
				System.out.println("Digite o número correspondente ao tipo de produto que será adicionada:");
				System.out.println("1 - Eletrônico");
				System.out.println("2 - Móvel");
				System.out.println("3 - Perecível");
				System.out.println();
				System.out.println("Ou 0 - Para voltar");
				op = sc.nextInt();
				while (op < 0 || op > 3) {
					System.out.println("-------------------OPÇÃO INVÁLIDA-------------------------");
					System.out.println();
					System.out.println("Digite o número correspondente ao tipo de produto que será adicionada:");
					System.out.println("1 - Eletrônico");
					System.out.println("2 - Móvel");
					System.out.println("3 - Perecível");
					System.out.println();
					System.out.println("Ou 0 - Para voltar");
					op = sc.nextInt();
				}
				// MENU ELETRONICO
				if (op == 1) {
					System.out.println();
					System.out.println("DIGITE OS DADOS DO PRODUTO---");
					System.out.println();
					System.out.println("Código:");
					int code = sc.nextInt();
					System.out.println("Nome:");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.println("Fabricante:");
					String manufacturer = sc.nextLine();
					System.out.println("Quantidade em estoque:");
					int stock = sc.nextInt();
					System.out.println("Preço Unitário:");
					double price = sc.nextDouble();
					System.out.println("Voltagem:");
					sc.nextLine();
					String voltage = sc.nextLine();
					System.out.println("Potência: ");
					Integer power = sc.nextInt();
					System.out.println("Classificação de Eficiência:");
					Character efficiency = sc.next().charAt(0);
					adicionar(new Eletronico(code, name, manufacturer, stock, price, voltage, power, efficiency));
					buscarPorCodigo(code);
					System.out.println("Gostaria de adicionar mais um produto?\ns/n?");
					char sn = sc.next().charAt(0);
					if (sn == 's') {
						op = 1;
					} else {
						op = 0;
					}
				}
				// MENU MOVEL
				if (op == 2) {
					System.out.println();
					System.out.println("DIGITE OS DADOS DO PRODUTO---");
					System.out.println();
					System.out.println("Código:");
					int code = sc.nextInt();
					System.out.println("Nome:");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.println("Fabricante:");
					String manufacturer = sc.nextLine();
					System.out.println("Quantidade em estoque:");
					int stock = sc.nextInt();
					System.out.println("Preço Unitário:");
					double price = sc.nextDouble();
					System.out.println("Tipo de Material:");
					sc.nextLine();
					String materialType = sc.nextLine();
					System.out.println();
					adicionar(new Movel(code, name, manufacturer, stock, price, materialType));
					buscarPorCodigo(code);
					System.out.println("Gostaria de adicionar mais um produto?\ns/n?");
					char sn = sc.next().charAt(0);
					if (sn == 's') {
						op = 1;
					} else {
						op = 0;
					}
				}
				// MENU PERECIVEL
				if (op == 3) {
					System.out.println();
					System.out.println("DIGITE OS DADOS DO PRODUTO---");
					System.out.println();
					System.out.println("Código:");
					int code = sc.nextInt();
					System.out.println("Nome:");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.println("Fabricante:");
					String manufacturer = sc.nextLine();
					System.out.println("Quantidade em estoque:");
					int stock = sc.nextInt();
					System.out.println("Preço Unitário:");
					double price = sc.nextDouble();
					System.out.println("Digite a data de validade (FORMATO: ANO MES DIA):");
					int ano = Integer.parseInt(sc.next());
					int mes = Integer.parseInt(sc.next());
					int dia = Integer.parseInt(sc.next());
					LocalDate expireDate = LocalDate.of(ano, mes, dia);
					System.out.println("Produto é refrigerado ou não?\ns/n?");
					char r = sc.next().charAt(0);
					boolean reefer;
					if (r == 's') {
						reefer = true;
					} else {
						reefer = false;
					}
					adicionar(new Perecivel(code, name, manufacturer, stock, price, expireDate, reefer));
					buscarPorCodigo(code);
					System.out.println("\nGostaria de adicionar mais um produto?\ns/n?");
					char sn = sc.next().charAt(0);
					if (sn == 's') {
						op = 1;
					} else {
						op = 0;
					}
				}
				if (op == 0) {
					op = 14;
				}
			}
			// MENU REMOVER PRODUTO
			while (op == 2) {
				System.out.println();
				System.out.println("Digite o código do produto que será removido:");
				int codigoProduto = sc.nextInt();
				remover(codigoProduto);
				System.out.println("\nGostaria de remover mais um produto?\ns/n?");
				char sn = sc.next().charAt(0);
				if (sn == 's') {
					op = 2;
				} else {
					op = 14;
				}
			}
			// MENU BUSCAR POR CODIGO
			while (op == 3) {
				System.out.println();
				System.out.println("Digite o código do produto:");
				int codigoProduto = sc.nextInt();
				buscarPorCodigo(codigoProduto);
				System.out.println("\nGostaria de procurar mais um produto?\ns/n?");
				char sn = sc.next().charAt(0);
				if (sn == 's') {
					op = 3;
				} else {
					op = 14;
				}
			}
			// MENU LISTAR ELETRONICOS
			if (op == 4) {
				System.out.println();
				listarEletronicos();
				op = 14;
			}
			// MENU LISTAR MOVEIS
			if (op == 6) {
				System.out.println();
				listarMoveis();
				op = 14;
			}
			// MENU LISTAR PERECIVEIS
			if (op == 5) {
				System.out.println();
				System.out.println(produtos.size());
				op = 14;
			}
			// MENU LISTAR ITENS ABAIXO DE UM NUMERO
			while (op == 7) {
				System.out.println();
				System.out.println("Digite o numero para filtragem: ");
				int quantidadeMinima = sc.nextInt();
				listarEstoqueMenorQue(quantidadeMinima);
				System.out.println("\nGostaria de filtrar por outra quantidade?\ns/n?");
				char sn = sc.next().charAt(0);
				if (sn == 's') {
					op = 7;
				} else {
					op = 14;
				}
			}
			// MENU LISTAR POR FORA DE ESTOQUE
			if (op == 8) {
				listarEstoqueVazio();
			}
			// MENU LISTAR POR FABRICANTE
			while (op == 9) {
				System.out.println();
				System.out.println("Digite o nome do fabricante: ");
				System.out.println("Fabricantes cadastrados são:");
				for (Produto p : produtos) {
					System.out.println(p.getManufacturer());
				}
				System.out.println();
				sc.nextLine();
				String fabricante = sc.nextLine();
				listarPorFabricante(fabricante);
				System.out.println("\nGostaria de filtrar por outro fabricante?\ns/n?");
				char sn = sc.next().charAt(0);
				if (sn == 's') {
					op = 9;
				} else {
					op = 14;
				}
			}
			// MENU LISTAR PRODUTOS VENCIDOS
			while (op == 10) {
				System.out.println();
				System.out.println("Digite a data de validade (FORMATO: ANO MES DIA):");
				int ano = Integer.parseInt(sc.next());
				int mes = Integer.parseInt(sc.next());
				int dia = Integer.parseInt(sc.next());
				LocalDate expireDate = LocalDate.of(ano, mes, dia);
				listarPorValidade(expireDate);
				System.out.println("\nGostaria de filtrar por outra data?\ns/n?");
				char sn = sc.next().charAt(0);
				if (sn == 's') {
					op = 10;
				} else {
					op = 14;
				}
			}
			// MENU VENDER
			while (op == 11) {
				System.out.println("Digite o código do produto:");
				int codigoProduto = sc.nextInt();
				System.out.println("Digite a quantidade");
				int quantidade = sc.nextInt();
				venderProduto(codigoProduto, quantidade);
				System.out.println("\nGostaria de vender outro produto?\ns/n?");
				char sn = sc.next().charAt(0);
				if (sn == 's') {
					op = 11;
				} else {
					op = 14;
				}
			}
			// MENU COMPRAR
			while (op == 12) {
				System.out.println("Digite o código do produto:");
				int codigoProduto = sc.nextInt();
				System.out.println("Digite a quantidade");
				int quantidade = sc.nextInt();
				comprarProduto(codigoProduto, quantidade);
				System.out.println("\nGostaria de comprar outro produto?\ns/n?");
				char sn = sc.next().charAt(0);
				if (sn == 's') {
					op = 12;
				} else {
					op = 14;
				}
			}

		}

		System.out.println("-------------OBRIGADO POR USAR O APS STOCK SYSTEM--------------");

		sc.close();
	}
}
