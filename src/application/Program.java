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
		
		Setor[] setores = new Setor[3];
		DefaultDao<Setor> setor = DaoFactory.createSetorDao();
		Scanner sc = new Scanner(System.in);
		char resposta;
		
		//-------------------------------------------------------------------//
		System.out.println("BUSCAR SETOR POR CÓDIGO:_____________________");
		setores[0] =  setor.findByCode(1L);
		System.out.println(setores[0]);
		System.out.println();
		//-------------------------------------------------------------------//
		System.out.println("LISTA DE SETORES CADASTRADOS:________________");
		//-------------------------------------------------------------------//
		List<Setor> setoresList1 = setor.findAll();
		for(Setor sts : setoresList1) {
			System.out.println(sts);
		}
		System.out.println();
		//-------------------------------------------------------------------//
		List<Setor> setorList = new ArrayList<>();
		System.out.println("INFORME O NOME DO SETOR:");
		String nomeSetor = sc.nextLine();
		Long codeDad = 0L;
		do {
			System.out.println("DESEJA INFORMAR O SETOR SUPERIOR?(Y/N):");
			resposta = Character.toUpperCase(sc.next().charAt(0));
	        if(resposta == 'Y') {
				System.out.println("INFORME O CÓDIGO DO SETOR SUPERIOR:");
				codeDad = sc.nextLong();
	        }
		}while(resposta != 'Y' && resposta != 'N');
		setorList.add(new Setor(0,nomeSetor,setor.findByCode(codeDad)));
		setor.insert(setorList);
		System.out.println();

		//-------------------------------------------------------------------//
		System.out.println("LISTA DE SETORES CADASTRADOS:________________");
		//-------------------------------------------------------------------//
		List<Setor> setoresList2 = setor.findAll();
		for(Setor sts : setoresList2) {
			System.out.println(sts);
		}
		System.out.println();
		//-------------------------------------------------------------------//
		do {
			System.out.println("DESEJA EXCLUIR ALGUM SETOR:(Y/N):");
			resposta = Character.toUpperCase(sc.next().charAt(0));
			if(resposta == 'Y') {
				System.out.println("DIGITE O CÓDIGO DO SETOR:");
				Long codeDelete = sc.nextLong();
				setor.deleteByObject(setor.findByCode(codeDelete));
			}
		}while(resposta != 'Y' && resposta != 'N');
		List<Setor> setoresList3 = setor.findAll();
		for(Setor sts : setoresList3) {
			System.out.println(sts);
		}
		System.out.println();

		Connect.close();
		sc.close();
		
	}

}
