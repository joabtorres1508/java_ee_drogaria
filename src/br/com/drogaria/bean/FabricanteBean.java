package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {

	private ListDataModel<Fabricante> itens;

	public ListDataModel<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fabricante> itens) {
		this.itens = itens;
	}
	
	/* roda antes de exibir a tela*/
	@PostConstruct
	public void preparaPesquisa() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			ArrayList<Fabricante> lista = dao.listar();
			this.itens = new ListDataModel<Fabricante>(lista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}