package nowon.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/insert.do")
public class BoafdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	@Override
	public void destroy() {
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			this.conn = ds.getConnection();
			//this.conn=conn;
			System.out.println("DBCP 연결 완료");
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
