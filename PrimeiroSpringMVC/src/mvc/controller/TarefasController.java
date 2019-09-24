package mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.Tarefa;
import mvc.model.TarefasDAO;
import mvc.model.Usuario;

@Controller
public class TarefasController {
	
	@RequestMapping("/")
	public String execute() {
		System.out.println("Lógica do MVC");
		return "info";
	}
	
	@RequestMapping("criaTarefa")
	public String form() {
		return "formTarefa";
	}
	
	@RequestMapping("adicionaTarefa")
	 public String adiciona(Tarefa tarefa, HttpSession session, ModelMap model) {
		TarefasDAO dao = new TarefasDAO();
		session.setAttribute("adicionaTarefa", tarefa.isFinalizado());
		dao.adiciona(tarefa);
		return "adicionada";
	 }
	
	@RequestMapping("apagaTarefa")
	public String formRemove() {
		return "formRemoveTarefa";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		TarefasDAO dao = new TarefasDAO();
		dao.remove(tarefa);
		return "removida";
	}
	
	@RequestMapping("updateTarefa")
	public String formAltera(Tarefa tarefa) {
		return "formAlteraTarefa";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		TarefasDAO dao = new TarefasDAO();
		dao.altera(tarefa);
		return "alterado";
	}
	
}