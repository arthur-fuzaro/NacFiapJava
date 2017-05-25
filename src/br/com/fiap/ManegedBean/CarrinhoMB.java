package br.com.fiap.ManegedBean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Spliterator;
import java.util.Spliterators;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.fiap.DAO.LivroDAO;
import br.com.fiap.Model.Carrinho;
import br.com.fiap.Model.Livro;
import javafx.scene.chart.PieChart.Data;

@ManagedBean
@SessionScoped
public class CarrinhoMB {

	private Livro livro;
	private String dueDate;

	private LivroDAO dao;
	// private List<Livro> carrinhoLivros = new ArrayList();
	private static double totalCarrinho;

	private static List<Carrinho> carrinho = new ArrayList<Carrinho>();

	

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public double getTotalCarrinho() {
		return totalCarrinho;
	}

	public void setTotalCarrinho(double totalCarrinho) {
		this.totalCarrinho = totalCarrinho;
	}

	public CarrinhoMB() {
		livro = new Livro();
		dao = new LivroDAO();
	}

	public List<Carrinho> getCarrinho() {
		// carrinhoLivros.add(livro);
		return carrinho;
	}

	public void setCarrinho(List<Carrinho> carrinhoLivros) {
		this.carrinho = carrinhoLivros;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String adcionarCarrinho() {
		livro = dao.pesquisarLivro(livro.getId());
		Carrinho carrinhoModal = new Carrinho();
		livro.setPreco(livro.getDescontoConta());
		carrinhoModal.setLivro(livro);
		carrinhoModal.setQuantidade(1);
		carrinhoModal.setValor(livro.getPreco());
		carrinho.add(carrinhoModal);
		totalCarrinho();
		return "Carrinho";
	}

	public int getQuantCarrinho() {
		return carrinho.size();
	}

	public List<String> getTotalValor() {
		List<String> total = new ArrayList<String>();

		return total;
	}

	public String atualizarCarrinho() {

		for (int i = 0; i < getQuantCarrinho(); i++) {
			Carrinho carrinho2 = carrinho.get(i);
			if (carrinho2.getQuantidade() == 0) {
				carrinho.remove(i);
			} else {
				carrinho2.setValor(carrinho2.getLivro().getPreco() * carrinho2.getQuantidade());
			}
		}
		totalCarrinho();

		return "Carrinho";
	}

	public void totalCarrinho() {
		setTotalCarrinho(0);
		for (Carrinho carrinho2 : carrinho) {
			setTotalCarrinho(getTotalCarrinho() + carrinho2.getValor());
		}
	}
	
	private Integer frete = 1;
	
	Carrinho c = new Carrinho();
	public Double getCalculaFrete() {
		double valorFrete = 0;
		switch (c.getFrete()) {
		case 1:
			valorFrete = 10;
			break;
		case 2:
			valorFrete = 20;
			break;
		}
		return valorFrete + getTotalCarrinho();
	}
	
	public void atualizarFrete(){
		c.setFrete(frete);
	}

	public Integer getFrete() {
		return frete;
	}

	public void setFrete(Integer frete) {
		this.frete = frete;
	}
	
	public String confirmarPedido(){
		return "Confirmacao";
	}
	
	public String finalizarCompra(){
		return "Confirmacao";
	}
	
	
	public void validarData(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		
		Date vData = (Date) value;
		DateFormat df = new SimpleDateFormat("mm/yy");
		String dataa = df.format(vData);
		/*Integer mes = vData.getMonth();
		Integer ano = vData.getYear()+2001;*/
		String dataSplited[] = dataa.split("/");
		Integer mes = Integer.parseInt(dataSplited[0]); 
		Integer ano = (Integer.parseInt(dataSplited[1]))+2001;
		
		Integer mesAtual = Calendar.getInstance().get(Calendar.MONTH)+1;
		Integer anoAtual = Calendar.getInstance().get(Calendar.YEAR);
		
		
		ResourceBundle text = ResourceBundle.getBundle("language", context.getViewRoot().getLocale());
		FacesMessage message = new FacesMessage(text.getString("validateDate"));
		try {
			Date d1 = (Date) df.parse(mes + "/" + ano);
			Date d2 = (Date) df.parse(mesAtual + "/" + anoAtual);

			System.out.println(""+mesAtual+"\n"+d2+"\n"+d1);
			
			
			if(d1.before(d2)){
				
				throw new ValidatorException(message);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
