package main;

import java.util.Scanner;

import Models.Employe;
import service.EmployeService;

public class MainClass {

	public static void main(String[] args) {

		EmployeService employeService = new EmployeService();

		try (Scanner sc = new Scanner(System.in)) {

			boolean executer = true;

			while (executer) {

				System.out.println("entrez votre choix : ");
				System.out.println("1- insertion : ");
				System.out.println("2- voir toute la liste : ");
				System.out.println("3- voir par id: ");
				System.out.println("4- supprimer : ");
				System.out.println("5- modifier : ");
				System.out.println("5- quitter : ");

				int choix = Integer.parseInt(sc.nextLine());

				switch (choix) {
				case 1:

					System.out.println("entrez successivement le nom , l'email et ensuite le salaire :");

					employeService.ajouterEmploye(
							new Employe(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine())));

					break;
				case 2:
					employeService.getAllEmploye();

					break;

				case 3:
					System.out.println("entrez l'id de l'employe à rechercher :");
					employeService.getEmployeById(Integer.parseInt(sc.nextLine()));

					break;
				case 4:
					System.out.println("entrez l'id de l'employe à supprimer :");
					employeService.deleteEmploye(Integer.parseInt(sc.nextLine()));

					break;

				case 5:
					
					System.out.println("entrez l'id de l'employe à modifier :");
					int id = Integer.parseInt(sc.nextLine());
					boolean isFound =employeService.getEmployeById(id);
					
					if(isFound) {
						
						System.out.println("entrez successivement le nom , l'email et ensuite le salaire :");

						
								Employe employe= new Employe(id,sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
								 employeService.updateEmploye(employe);
						
					}
					break;

				case 6:
					System.out.println("merci et aurevoir");
					executer = false;

					break;

				default:
					System.out.println("saisie incorrect !!");
					break;
				}

			}
		}catch (Exception e) {
			
			throw new RuntimeException("une erreur est survenue",e);
		}

	}

}
