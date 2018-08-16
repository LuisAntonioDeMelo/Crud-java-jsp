package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EstudanteUtil {
	private static DataSource datasource;

	public EstudanteUtil(DataSource thedataSource) {
		this.datasource = thedataSource;
	}

	
	public List<Estudante> getEstudantes() throws Exception {
		List<Estudante> ls = new ArrayList<>();
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * from student order by id";
			con = datasource.getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				Estudante estudante = new Estudante();
				estudante.setIdEstudante(rs.getInt("id"));
				estudante.setNome(rs.getString("first_name"));
				estudante.setSobrenome(rs.getString("last_name"));
				estudante.setEmail(rs.getString("email"));
				ls.add(estudante);
			}
			return ls;
		} finally {
			close(con, stm, rs);
		}
	}

	public static void add(Estudante estudante) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		// create sql to insert

		// set a paramt values for the students
		try {
			con = datasource.getConnection();

			String sql = "INSERT INTO web_student_tracker.student (first_name,last_name,email) values(?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, estudante.getNome());
			stm.setString(2, estudante.getSobrenome());
			stm.setString(3, estudante.getEmail());
			stm.execute();

		} finally {
			close(con, stm, null);
		}
		// execute sql

	}

	private static void close(Connection con, Statement stm, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Estudante getStudent(String estudanteId) throws Exception {
		// converter o id do estudante em int
		// pegar a conexao com banco do com o data source
		// criar o sql para o banco
		// criar o prepared statamento pra fazer o bagulho
		// setar os parametros
		// executar os stm
		// retonar o result set do row
		Estudante estudante = null;
		Connection con = null;
		PreparedStatement estm = null;
		ResultSet rs = null;
		int estudanteid;
		try {
			estudanteid = Integer.parseInt(estudanteId);
			con = datasource.getConnection();
			String sql = "Select * from student where id=?";
			estm = con.prepareStatement(sql);
			estm.setInt(1, estudanteid);

			rs = estm.executeQuery();
			if (rs.next()) {
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				String email = rs.getString("email");
				estudante = new Estudante(estudanteid, firstname, lastname, email);
			} else {
				throw new Exception("Nao foi possivel achar o estudante");
			}
		} finally {
			close(con, estm, rs);
		}
		return estudante;
	}

	public static void update(Estudante estud) throws Exception {
		// pegar a conexão com banco de dados
		// criar o sql de update
		//

		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = datasource.getConnection();
			String sql = "UPDATE student" + ""
					+ " set first_name=?,last_name=?,email=?" + 
					" where id=?";

			stm = con.prepareStatement(sql);

			stm.setString(1, estud.getNome());
			stm.setString(2, estud.getSobrenome());
			stm.setString(3, estud.getEmail());
			stm.setInt(4, estud.getIdEstudante());
			stm.execute();

		} finally {
			close(con, stm, null);
		}
	}

	public static void deletar(Estudante estudante) throws Exception {
		 Connection conexao = null;
		 PreparedStatement stm = null;
		 
		 try {
			 conexao = datasource.getConnection();
			 String sql = "DELETE from student where id=?";
			 stm = conexao.prepareStatement(sql);
			 
			 stm.setInt(1, estudante.getIdEstudante());
			 stm.execute();
		 }
		 finally{
			 close(conexao,stm,null);
		 }
		
	}

}
