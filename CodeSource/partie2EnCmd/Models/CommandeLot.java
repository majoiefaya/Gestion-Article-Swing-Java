package Tp1.partie2EnCmd.Models;

public class CommandeLot {
	
	
	private int idCmdLot;
	
	private LotArticle lot;
	
	private Client client;
	
	private int qtLot;

	public static int id=0;
	
	public CommandeLot(int idCmdLot, LotArticle lot, Client client, int qtLot) {
		super();
		this.idCmdLot=++id;
		this.setLot(lot);
		this.setClient(client);
		this.setQtLot(qtLot);
	}

	public int getIdCmdLot() {
		return idCmdLot;
	}

	public void setIdCmdLot(int idCmdLot) {
		this.idCmdLot = idCmdLot;
	}

	public LotArticle getLot() {
		return lot;
	}

	public void setLot(LotArticle lot) {
		this.lot = lot;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getQtLot() {
		return qtLot;
	}

	public void setQtLot(int qtLot) {
		this.qtLot = qtLot;
	}
	
	
	

}
