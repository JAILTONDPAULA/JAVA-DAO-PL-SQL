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
		System.out.println("LISTA DE SETORES CADASTRADOS:\n");
		//-------------------------------------------------------------------//
		for(Setor sts :  setores = setor.findAll()) {
			System.out.println(sts);
		}
		///////////////////////////////////////////////////////////////////////
		do {
			System.out.println("\n DESEJA BUSCAR UM SETOR POR SEU CÓDIGO?(Y/N)");
			resposta = Character.toUpperCase(sc.next().charAt(0));
			System.out.println(resposta);
			if(resposta == 'Y'){
				System.out.println("INFORME O CÓDIGO DO SETOR:\n");
				sector =  setor.findByCode(1L);
				System.out.println(sector+"\n");
			}
		}while(resposta != 'Y' && resposta != 'N');
		
		///////////////////////////////////////////////////////////////////////
		do {
			System.out.println("DESEJA CADASTRAR UM SETOR?(Y/N)");
			resposta = Character.toUpperCase(sc.next().charAt(0));
			if(resposta == 'Y'){
				System.out.println("INFORME O NOME DO SETOR:\n");
				sector = new Setor(0L,sc.nextLine(),null);
				
				do {
					System.out.println("DESEJA INFORMAR O SETOR SUPERIOR?(Y/N):");
					resposta = Character.toUpperCase(sc.next().charAt(0));
			        if(resposta == 'Y') {
						System.out.println("INFORME O CÓDIGO DO SETOR SUPERIOR:");
						sector.setSuperior(new Setor(sc.nextLong(),null,null));
			        }
				}while(resposta != 'Y' && resposta != 'N');
				
				setores = null;
				setores.add(sector);
				setor.insert(setores);

			}
		}while(resposta != 'Y' && resposta != 'N');
		

		///////////////////////////////////////////////////////////////////////
		System.out.println("\n LISTA DE SETORES CADASTRADOS:\n");
		//-------------------------------------------------------------------//
		setores = setor.findAll();
		for(Setor sts : setores) {
			System.out.println(sts);
		}
		///////////////////////////////////////////////////////////////////////
		do {
			System.out.println("DESEJA EXCLUIR ALGUM SETOR:(Y/N):");
			resposta = Character.toUpperCase(sc.next().charAt(0));
			if(resposta == 'Y') {
				System.out.println("DIGITE O CÓDIGO DO SETOR:");
				Long codeDelete = sc.nextLong();
				setor.deleteByObject(setor.findByCode(codeDelete));
			}
		}while(resposta != 'Y' && resposta != 'N');
		///////////////////////////////////////////////////////////////////////
		System.out.println("\n LISTA DE SETORES CADASTRADOS:\n");
		//-------------------------------------------------------------------//
		for(Setor sts : setores = setor.findAll()) {
			System.out.println(sts);
		}

		Connect.close();
		sc.close();
		
	}

}
