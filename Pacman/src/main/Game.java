package main;

import data.Data;
import model.Perso;
import utilitaires.Utilitaires;

public class Game {

	Data data;
	
	public Game() {
		data = new Data();
	}
	
	public void game() {
		Utilitaires.fillMap(data.getMap());
		addWallToMap(data.getMap());
		createGhost();
		addGhostToMap();
		printPacManOnMap();
		
		
		do {
			Utilitaires.readMap(data.getMap());
			System.out.print("Nb de point mangé : " + data.getCountPoint());
			handleMovePacMan();
			incrementCountIfNextPositionIsAPoint();
			handleMoveGhost();
			printPacManOnMap();
		}
		while(data.isGameOn());
		
	}

	private void handleMoveGhost() {
		
		for (Perso ghost : data.getAlGhost()) {
			int x = ghost.getX();
			int y = ghost.getY();
			switch(Utilitaires.randomForMouv()) {
			case "z" : 
				if(checkIfMouvAllowed(x,y-1)) {
					if(ghost.isOnPoint()) {
						data.getMap()[x][y]='.';
					}
					ghost.setOnPoint(data.getMap()[x][y-1]=='.');
					
					ghost.setY(y-1);
				}
				break;
			case "s" :
				if(checkIfMouvAllowed(x,y+1)) {
				ghost.setY(y+1);
			}
				break;
			case "q" : if(checkIfMouvAllowed(x-1,y)) {
				ghost.setX(x-1);
			}
				break;
			case "d" : if(checkIfMouvAllowed(x+1,y)) {
				ghost.setX(x+1);
			}
				break;
			}
			printGhostOnMap(ghost);
		}
	}

	private void addGhostToMap() {
		for (Perso ghost : data.getAlGhost()) {
			data.getMap()[ghost.getX()][ghost.getY()] = ghost.getNom();
		}
	}

	private void createGhost() {
		for(int i = 0; i <data.getNbGhost();i++) {
			data.getAlGhost().add(new Perso('#',
					Utilitaires.generateRandomInt(),
					Utilitaires.generateRandomInt()));
		}
		
	}

	private void addWallToMap(char[][] map) {
		for(int i = 0; i<data.getNbWall(); i++) {
			int x = Utilitaires.generateRandomInt();
			int y = Utilitaires.generateRandomInt();
			data.getMap()[x][y] = '0';
		}
		
	}

	private void incrementCountIfNextPositionIsAPoint() {
		if(data.getMap()[data.getPacMan().getX()][data.getPacMan().getY()] == '.'){
				data.setCountPoint(data.getCountPoint()+1);
		}
	}

	private void printPacManOnMap() {
		data.getMap()[data.getPacMan().getX()][data.getPacMan().getY()]= data.getPacMan().getNom();
	}
	
	private void printGhostOnMap(Perso ghost) {
		data.getMap()[ghost.getX()][ghost.getY()]= ghost.getNom();
	}
	
	private void handleMovePacMan() {
		int x = data.getPacMan().getX();
		int y = data.getPacMan().getY();
		
		
		data.getMap()[x][y] = ' ';
		switch(Utilitaires.saisieString()) {
		case "z" : 
			if(checkIfMouvAllowed(x,y-1)) {
				
				data.getPacMan().setY(y-1);
			}
			break;
		case "s" : if(checkIfMouvAllowed(x,y+1)) {
			data.getPacMan().setY(y+1);
		}
			break;
		case "q" : if(checkIfMouvAllowed(x-1,y)) {
			data.getPacMan().setX(x-1);
		}
			break;
		case "d" : if(checkIfMouvAllowed(x+1,y)) {
			data.getPacMan().setX(x+1);
		}
			break;
		default : System.out.println("Erreur saisie");
			break;
		}
		
		checkIfPacManIsDead();
		
	}
	
	private void checkIfPacManIsDead() {
		for (Perso ghost : data.getAlGhost()) {
			if(ghost.getX()==data.getPacMan().getX() 
					&& ghost.getY()==data.getPacMan().getY()) {
				System.out.println("Game over");
				data.setGameOn(false);
			}
		}
	}

	private boolean checkIfMouvAllowed(int x, int y) {
		return (data.getMap()[x][y]!='0');
	}
	
}
