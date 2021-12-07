package data;

import java.util.ArrayList;

import model.Perso;

public class Data {

	char [][] map;
	Perso pacMan;
	int countPoint;
	int nbWall;
	ArrayList<Perso> alGhost;
	int nbGhost;
	boolean gameOn;
	
	public Data() {
		 map = new char[20][20];
		 pacMan = new Perso('@', 9, 9);
		 countPoint = 0;
		 nbWall = 35;
		 nbGhost = 5;
		 alGhost = new ArrayList<Perso>();
		 gameOn = true;
	}

	public char[][] getMap() {
		return map;
	}

	public void setMap(char[][] map) {
		this.map = map;
	}

	public Perso getPacMan() {
		return pacMan;
	}

	public void setPacMan(Perso p) {
		this.pacMan = p;
	}

	public int getCountPoint() {
		return countPoint;
	}

	public void setCountPoint(int countPoint) {
		this.countPoint = countPoint;
	}

	public int getNbWall() {
		return nbWall;
	}

	public void setNbWall(int nbWall) {
		this.nbWall = nbWall;
	}

	public ArrayList<Perso> getAlGhost() {
		return alGhost;
	}

	public void setAlGhost(ArrayList<Perso> alGhost) {
		this.alGhost = alGhost;
	}

	public int getNbGhost() {
		return nbGhost;
	}

	public void setNbGhost(int nbGhost) {
		this.nbGhost = nbGhost;
	}

	public boolean isGameOn() {
		return gameOn;
	}

	public void setGameOn(boolean gameOn) {
		this.gameOn = gameOn;
	}
	
	
}
