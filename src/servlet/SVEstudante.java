package servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Estudante;
import model.EstudanteUtil;
import sun.rmi.server.Dispatcher;

@WebServlet("/SVEstudante")
public class SVEstudante extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EstudanteUtil estudante;
    
    @Resource(name="jdbc/web_student_tracker")
    DataSource source;
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	//criar o init e passar o soure(passar a conexao)
   
    	try {
    		estudante = new EstudanteUtil(source);
    	}catch(Exception e) {
    		throw new ServletException(e);
    	}
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//listar os estudandes no mvc
	
		try {
		 	// ler o coment e mandar 
			String command = request.getParameter("command");
	    	// fazer a rota para
			if(command == null) {
				command = "list";
			}		
			switch(command) {
			case "list":
				listarEstudantes(request,response);
				break;
			case "ADD":
				addEstudantes(request,response);
				break;
			case "LOAD":
				loadEstudantes(request,response);
				break;
			case "UPDATE":
				updateEstudantes(request,response);
				break;
			case "DELETE":
				deletarEstudante(request,response);
				break;
			default: 
				listarEstudantes(request,response);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	private void deletarEstudante(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String idDelete =  request.getParameter("estudanteId");
		Estudante estudanteDel = estudante.getStudent(idDelete);
		EstudanteUtil.deletar(estudanteDel);
		listarEstudantes(request,response);
	
	}
	
	
	private void updateEstudantes(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		// no update precisamos ler o form data
		// criar um novo objecto 
		// fazer um update no sql
		// enviar de volta para pagina principal
		int id = Integer.parseInt(request.getParameter("estudanteId"));
		String name = request.getParameter("firstName");
		String suName = request.getParameter("lastName");
		String email = request.getParameter("email");
		Estudante estud = new Estudante(id,name,suName,email);
		EstudanteUtil.update(estud);
		listarEstudantes(request, response);
	}
	
	private void loadEstudantes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ler o estudante da pagina
		//pegar os dados do estudante no banco
		//colocar o estudante no atributo do java setAtribute
		//enviar o estudante para pagina denovo
		String estudantid = request.getParameter("estudanteId");
		Estudante estud = estudante.getStudent(estudantid);
	
		request.setAttribute("_estudante", estud);
		RequestDispatcher dispachador = request.getRequestDispatcher("atualizarEstudantes.jsp");
		dispachador.forward(request, response);
	}
	
	
	private void addEstudantes(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			
			Estudante estudante = new Estudante(firstName,lastName,email);
			EstudanteUtil.add(estudante);
			listarEstudantes(request,response);
	}
	
	
	private void listarEstudantes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//perga a lista  dos estudantes do util
		//retorna os ids para os estudantes 
		//adicionar os estudades para o request
		//enviar para o jsp
		
		List<Estudante> estudantes = estudante.getEstudantes();
		request.setAttribute("lista_estudantes", estudantes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listarEstudantes.jsp");
		dispatcher.forward(request, response);

		//System.out.println(estudantes.get(0).getIdEstudante());
	}

}
