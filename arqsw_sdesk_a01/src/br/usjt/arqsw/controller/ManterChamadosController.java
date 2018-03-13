package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.FilaService;


/**
 * 
 * @author 816124616 - Vitor Fonseca de Souza
 */


@Controller
public class ManterChamadosController {
	private FilaService filaService;
	private ChamadoService chamadoService;

	public ManterChamadosController() {
		filaService = new FilaService();
		chamadoService = new ChamadoService();
	}

	@RequestMapping("index")
	public String inicio() {
		return "index";
	}

	private ArrayList<Fila> listarFilas() throws IOException{
			return filaService.listarFilas();
	}
	
	@RequestMapping("/listar_filas_exibir")
	public String listarFilasExibir(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "ChamadoListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/listar_filas")
	public String novoChamado(Model model){
		try{
			model.addAttribute("lista",listarFilas());
			return "NovoChamado";
		}catch(IOException e){
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/listar_chamados_exibir")
	public String listarChamadosExibir(@Valid Fila fila, BindingResult result, Model model) {
		try {
			if (result.hasFieldErrors("id")) {
				model.addAttribute("filas", listarFilas());
				System.out.println("Deu erro " + result.toString());
				return "ChamadoListar";
				//return "redirect:listar_filas_exibir";
			}else{
			fila = filaService.carregar(fila.getId());
			model.addAttribute("fila", fila);
			
			ArrayList<Chamado> chamados = chamadoService.listarChamados(fila);
			model.addAttribute("chamados", chamados);
			return "ChamadoListarExibir";
			}

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/novo_chamado")
	public String criarChamado(@Valid Chamado chamado, BindingResult result, Model model) {
			try {
				int id = chamadoService.criarChamado(chamado);
				chamado.setNumero(id);
				return "NumeroChamado";
			} catch (IOException e) {
				e.printStackTrace();
				return "Erro";
			}
		}
	}

