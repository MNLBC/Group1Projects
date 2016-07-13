package com.oocl.mnlbc.staticproxy;
/**
 * 
 * @author BARREPE
 *
 */
public class ProxyBookFacade implements BookFacade {
	
	private RealBookFacade realBookFacade;
	private String title;
	
	public ProxyBookFacade(String title){
		this.title = title;
	}
	public void addBook() {
		if(realBookFacade == null){
			realBookFacade = new RealBookFacade(title);
		}
		realBookFacade.addBook();
	}

}
