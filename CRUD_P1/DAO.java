package br.edu.insper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	private Connection connection = null;
	
	public DAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/projeto1", "root", "Bia130899");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Login> getLista() {
		List<Login> logins = new ArrayList<Login>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM login");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Login login = new Login();
				login.setId(rs.getInt("id"));
				login.setName(rs.getString("user"));
				login.setSenha(rs.getString("senha"));
				login.setConfirmaSenha(rs.getString("confirma_senha"));
				logins.add(login);
			}	
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logins;
	}
	
	public Login getLogin(Login login) {
		String sql = "SELECT * FROM login WHERE user=? AND senha=?";
		PreparedStatement stmt = null;
		ResultSet rs;
		Login returnLogin = new Login();
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, login.getName());
			stmt.setString(2, login.getSenha());
			rs = stmt.executeQuery();
			while(rs.next()) {
				returnLogin.setId(rs.getInt("id"));
				returnLogin.setName(rs.getString("user"));
				returnLogin.setSenha(rs.getString("senha"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnLogin;
	}
	
	
	public void adicionaLogin(Login login) {
		String sql = "INSERT INTO login" + "(user,senha,confirma_senha) values(?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1,login.getName());
			stmt.setString(2,login.getSenha());
			stmt.setString(3,login.getConfirmaSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alteraLogin(Login login) {
		String sql = "UPDATE login SET " + "user=?, senha=?, confirma_senha=? WHERE id=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, login.getName());
			stmt.setString(2, login.getSenha());
			stmt.setString(3, login.getConfirmaSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	####################NOTAS##########################
	
	
	public List<Notes> getNotes() {
		List<Notes> notes = new ArrayList<Notes>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM notes");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Notes note = new Notes();
				note.setId(rs.getInt("id"));
				note.setIdUser(rs.getInt("id_user"));
				note.setTitle(rs.getString("title"));
				note.setNote(rs.getString("note"));
				notes.add(note);
			}	
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notes;
	}
	
	public List<Notes> getUserNotes(Integer id) {
		List<Notes> notes = new ArrayList<Notes>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM notes WHERE id_user=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Notes note = new Notes();
				note.setId(rs.getInt("id"));
				note.setIdUser(rs.getInt("id_user"));
				note.setTitle(rs.getString("title"));
				note.setNote(rs.getString("note"));
				notes.add(note);
			}	
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notes;
	}
	
	public void adicionaNota(Notes notes) {
		String sql = "INSERT INTO notes" + "(id_user,title,note) values(?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, notes.getIdUser());
			stmt.setString(2,notes.getTitle());
			stmt.setString(3,notes.getNote());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void userName(Notes notes) {
		String sql = "SELECT login.user FROM notes JOIN login ON notes."+"(id_user) values(?)"+"=login.id;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, notes.getIdUser());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alteraNota(Notes notes) {
		String sql = "UPDATE notes SET " + "id_user=?, title=?, note=? WHERE id=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, notes.getIdUser());
			stmt.setString(2, notes.getTitle());
			stmt.setString(3, notes.getNote());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void removeNota(String title) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM notes WHERE title=?");
			stmt.setString(1, title);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
