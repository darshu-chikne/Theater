package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.TheaterController;

public class TheaterModel {
	static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8?user=root&password=sql123");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	PreparedStatement pstmt;
	
	public double displayTheater(String movieName,int noofticket)
	{       double bill=0.0;
			double gst =0.0;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String query= " select no_of_tickavail,price_per_tickit from theater where movie_name=? ";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, movieName);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				int ticket= rs.getInt(1);
				int price=rs.getInt(2);
				int remaining_ticket=ticket-noofticket;
				if(noofticket<=ticket) {
					bill=noofticket*price;
					gst = bill+bill*0.18;
					
					String query1=" update theater set no_of_tickavail=? where  movie_name=? ";
					pstmt = con.prepareStatement(query1);
					pstmt.setInt(1, remaining_ticket);
					pstmt.setString(2, movieName);
					pstmt.executeUpdate();
				}else if(ticket==0) {
					gst=0.0;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gst;
	
		
	}

}
