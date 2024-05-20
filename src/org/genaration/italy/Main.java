package org.genaration.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] matrice = new String[3][3];
		int nrRighe, nrColonne;
		int counter = 0;
		String player1, player2, risposta;
		boolean win;
		
		// Inizio do while per ricominciare la partita
		do {
			// Assegnazione spazio vuoto nella griglia impostata sia verticalmente che
			// orizzontalmente
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					matrice[r][c] = " ";
				}
			}
			// Inizio partita e richiesta di inserimento nome dei giocatori
			System.out.println("Benvenuto su TicTacToe!");
			System.out.println("Inserire nome del 1° giocatore: ");
			player1 = sc.nextLine();
			System.out.println("Inserire nome del 2° giocatore: ");
			player2 = sc.nextLine();
			// Assegnazione valori a false e a 0 per inizio e riavvio partita
			win = false;
			counter = 0;
			// Inizio do while per inserimento mosse fino al completamento della griglia
			do {
				// Inizio do while per inserimento mossa del player 1
				do {
					// Inserimento mossa giocatore 1
					System.out.println(player1 + " dove vuoi mettere la X?");
					System.out.println("Inserisci la riga: ");
					nrRighe = sc.nextInt();
					System.out.println("Inserisci la colonna: ");
					nrColonne = sc.nextInt();
					win = false;
					// Verifica se la posizione è vuota, se è vuota inserisce la mossa
					if (matrice[nrRighe][nrColonne].equalsIgnoreCase(" ")) {
						counter++;
						matrice[nrRighe][nrColonne] = "X";
						break;
						// Se non è vuota allora il ciclo si ripete per inserire la mossa corretta
					} else {
						System.out.println("La posizione è già occupata! Inserisci nuovamente la tua mossa!");
						continue;
					}
					// Fine do while per inserimento mossa del player 1
				} while (true);
				// Condizione vittoria verticale
				for (int r = 0; r < 3; r++) {
					if (matrice[r][0].equals(matrice[r][1]) && matrice[r][1].equals(matrice[r][2])
							&& matrice[r][0].equals("X")) {
						win = true;
						break;
					}
				}
				// Condizione vittoria orizzontale
				for (int c = 0; c < 3; c++) {
					if (matrice[0][c].equals(matrice[1][c]) && matrice[1][c].equals(matrice[2][c])
							&& matrice[0][c].equals("X")) {
						win = true;
						break;
					}
				}
				// Condizione vittoria diagonale
				if ((matrice[0][0].equals(matrice[1][1]) && matrice[1][1].equals(matrice[2][2])
						&& matrice[0][0].equals("X"))
						|| matrice[0][2].equals(matrice[1][1]) && matrice[1][1].equals(matrice[2][2])
								&& matrice[0][2].equals("X")) {
					win = true;
				}
				// Stampa della griglia dopo l'inserimento mossa
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						System.out.print(matrice[r][c]);
					}
					System.out.println();
				}
				// Condizione di pareggio
				if (counter == 9 && !win) {
					System.out.println("Pareggio");
					break;
				}
				if (win == true) {
					System.out.println("Il vincitore è " + player1);
					break;
				}
				
				System.out.println("Il contatore è di: " + counter);

				// Inizio do while per inserimento mossa del player 2
				do {
					// Inserimento mossa giocatore 2
					System.out.println(player2 + " dove vuoi mettere la O?");
					System.out.println("Inserisci la riga: ");
					nrRighe = sc.nextInt();
					System.out.println("Inserisci la colonna: ");
					nrColonne = sc.nextInt();

					// Verifica se la posizione è vuota, se è vuota inserisce la mossa
					if (matrice[nrRighe][nrColonne].equalsIgnoreCase(" ")) {
						counter++;
						matrice[nrRighe][nrColonne] = "O";
						break;
						// Se non è vuota allora il ciclo si ripete per inserire la mossa corretta
					} else {
						System.out.println("La posizione è già occupata! Inserisci nuovamente la tua mossa!");
						continue;
					}
					// Fine do while inserimento mossa del player 2
				} while (true);

				// Condizione vittoria verticale
				for (int r = 0; r < 3; r++) {
					if (matrice[r][0].equals(matrice[r][1]) && matrice[r][1].equals(matrice[r][2])
							&& matrice[r][0].equals("O")) {
						win = true;
						break;
					}
				}
				// Condizione vittoria orizzontale
				for (int c = 0; c < 3; c++) {
					if (matrice[0][c].equals(matrice[1][c]) && matrice[1][c].equals(matrice[2][c])
							&& matrice[0][c].equals("O")) {
						win = true;
						break;
					}
				}
				// Condizione vittoria diagonale
				if ((matrice[0][0].equals(matrice[1][1]) && matrice[1][1].equals(matrice[2][2])
						&& matrice[0][0].equals("O"))
						|| matrice[0][2].equals(matrice[1][1]) && matrice[1][1].equals(matrice[2][2])
								&& matrice[0][2].equals("O")) {
					win = true;
				}
				// Stampa della grigia
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						System.out.print(matrice[r][c]);
					}
					System.out.println();
				}
				System.out.println("Il contatore è di: " + counter);

				// Condizione di pareggio
				if (counter == 9 && !win) {
					System.out.println("Pareggio");
					break;
				}
				if (win == true) {
					System.out.println("Il vincitore è " + player2);
					break;
				}
				
			} while (true && !win);
			// Messaggio di fine partita e inserimento risposta
			System.out.println("Vuoi fare un'altra partita?");
			sc.nextLine();
			risposta = sc.nextLine();
			// Fine do-while per ricominciare la partita
		} while (risposta.equalsIgnoreCase("s"));

	}

}
