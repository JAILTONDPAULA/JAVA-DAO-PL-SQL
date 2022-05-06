package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dataBase.Connect;
import model.dao.DaoFactory;
import model.dao.DefaultDao;
import model.etities.Setor;

public class Program {

	public static void main(String[] args) {
		
		DefaultDao<Setor> setor = DaoFactory.createSetorDao();
		Setor sector            = null;
		List<Setor> setores     = new ArrayList<>();
		Scanner sc              = new Scanner(System.in);
		char resposta;  
		
		///////////////////////////////////////////////////////////////////////
		System.out.println("LISTA DE SETORES CADASTRADOS:");
		//-------------------------------------------------------------------//
		for(Setor sts :  setores = setor.findAll()) {
			System.out.println(sts);
		}
		///////////////////////////////////////////////////////////////////////
		do {
			System.out.print("\nDESEJA BUSCAR UM SETOR POR SEU CÓDIGO?(Y/N) ");
			resposta = Character.toUpperCase(sc.next().charAt(0));
			if(resposta == 'Y'){
				System.out.print("INFORME O CÓDIGO DO SETOR: ");
				Long code = sc.nextLong();
				sector    = setor.findByCode(code);
				System.out.println(sector);
			}
		}while(resposta != 'Y' && resposta != 'N');
		
		///////////////////////////////////////////////////////////////////////
		do {
			System.out.print("\nDESEJA CADASTRAR UM SETOR?(Y/N) ");
			resposta = Character.toUpperCase(sc.next().charAt(0));
			if(resposta == 'Y'){
				System.out.print("INFORME O NOME DO SETOR: ");
				sc.nextLine();
				String nome = sc.nextLine();
				sector = new Setor(0L,nome,null);
				
				do {
					System.out.print("DESEJA INFORMAR O SETOR SUPERIOR?(Y/N): ");
					resposta = Character.toUpperCase(sc.next().charAt(0));
			        if(resposta == 'Y') {
						System.out.print("INFORME O CÓDIGO DO SETOR SUPERIOR: ");
						sector.setSuperior(new Setor(sc.nextLong(),null,null));
			        }
				}while(resposta != 'Y' && resposta != 'N');
				
				setores = new ArrayList<>();
				setores.add(sector);
				setor.insert(setores);
				
				System.out.println("\nLISTA DE SETORES ATUALIZADA:");
				//-------------------------------------------------------------------//
				setores = setor.findAll();
				for(Setor sts : setores) {
					System.out.println(sts);
				}


			}
		}while(resposta != 'Y' && resposta != 'N');

		///////////////////////////////////////////////////////////////////////
		do {
			System.out.print("\nDESEJA EXCLUIR ALGUM SETOR:(Y/N): ");
			resposta = Character.toUpperCase(sc.next().charAt(0));
			if(resposta == 'Y') {
				System.out.print("DIGITE O CÓDIGO DO SETOR: ");
				Long codeDelete = sc.nextLong();
				sector = setor.findByCode(codeDelete);
				setor.deleteByObject(sector);
			}
		}while(resposta != 'Y' && resposta != 'N');
		///////////////////////////////////////////////////////////////////////
		System.out.println("\nLISTA DE SETORES CADASTRADOS:");
		//-------------------------------------------------------------------//
		for(Setor sts : setores = setor.findAll()) {
			System.out.println(sts);
		}

		Connect.close();
		sc.close();
		
	}

}
