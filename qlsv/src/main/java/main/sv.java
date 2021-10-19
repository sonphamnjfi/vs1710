package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class sv {
	
	private String masv;
	private String hodem;
	private String tensv;
	private String telsv;
	private String emailsv;
	
	
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getHodem() {
		return hodem;
	}
	public void setHodem(String hodem) {
		this.hodem = hodem;
	}
	public String getTensv() {
		return tensv;
	}
	public void setTensv(String tensv) {
		this.tensv = tensv;
	}
	public String getTelsv() {
		return telsv;
	}
	public void setTelsv(String telsv) {
		this.telsv = telsv;
	}
	public String getEmailsv() {
		return emailsv;
	}
	public void setEmailsv(String emailsv) {
		this.emailsv = emailsv;
	}
	
	public int themSV() throws SQLException{
		int result=0;
		if(this.masv==null || this.masv.length()<=0) return 0;
		if(this.tensv==null || this.tensv.length()<=0 || this.hodem==null || this.hodem.length()<=0) return 1;
		String sql ="";
		Connection conn=null;
		Statement statement=null;
		ResultSet rs=null;

		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=qlsv;", "sa","Sa@123");
            
			statement = conn.createStatement();
			//MASV da co trong bang tblSV chua
			sql="SELECT * FROM dbo.sv WHERE MASV='"+this.masv+"'" ;
			rs = statement.executeQuery(sql);
			if(!rs.next()){//Thuc hien INSERT INTO
				sql="INSERT INTO dbo.sv (MASV, TENSV, HODEM,TELSV,EMAILSV)VALUES ('"+this.masv+"','"+this.tensv+"','"+this.hodem+"'";
				if(this.emailsv!=null && this.emailsv.length()>0) sql=sql+",'"+this.emailsv+"'";
				if(this.telsv!=null && this.telsv.length()>0) sql=sql+",'"+this.telsv+"'";
				sql=sql+")" ;
				if(statement.executeUpdate(sql)>0) result=10;
			}else result = 3;

			rs.close();
			statement.close();
			conn.close();

		}catch(Exception e){
			rs.close();
			statement.close();
			conn.close();
			System.out.println(e.toString());
		}
		return result;
	}//themSV

}
