package br.edu.insper;

public class Notes {
	
	private Integer id;
	private Integer id_user;
	private String title;
	private String note;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIdUser() {
		return id_user;
	}
	public void setIdUser(Integer id_user) {
		this.id_user = id_user;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
