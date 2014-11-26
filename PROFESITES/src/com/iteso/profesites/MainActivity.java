package com.iteso.profesites;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import android.support.v7.app.ActionBarActivity;
import android.database.SQLException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

//private final String DATABASE_URL="postgres://puxjrclcpklkol:mwEJFi1HGWtwY2anP8zjBSekJE@ec2-184-73-229-220.compute-1.amazonaws.com:5432/dbbi1r8hsgnct0";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String createtable="CREATE TABLE weather"+ "("+  "city" + "varchar(80),";
		
		setContentView(R.layout.activity_main);
			
		try{
			change();
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(createtable);
		
		}catch(Exception e){
			changeOption();
			
		}
		
		
				
	}
	
	private void  change(){
		Button eleccion=(Button)findViewById(R.id.go_to_maestro_ideal);
		eleccion.setHeight(12);	
	}
	
	private void  changeOption(){
		Button eleccion=(Button)findViewById(R.id.go_to_maestro_ideal);
		eleccion.setHeight(10);	
	}
	private static Connection getConnection() throws URISyntaxException, SQLException, java.sql.SQLException {
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
	    
	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
}
