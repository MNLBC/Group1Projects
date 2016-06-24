package chatConnection;


public class App {

	public static void main(String[] args) {
		
		DBConnect.insert(new History("Limos","HelloWorld!"));
		DBConnect.getAllHistory();
		
		DBConnect.insert(new Logs("It works!"));
		DBConnect.getAllLogs();
		
	}

}
