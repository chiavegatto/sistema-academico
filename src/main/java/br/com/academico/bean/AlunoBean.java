package br.com.academico.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.academico.Aluno;

@ManagedBean(name = "MBAluno")
@RequestScoped
public class AlunoBean {
	
	private Aluno aluno = new Aluno();
    public boolean statusCampoProvaFinal=false;
	public double mediaFinal;
	public String corMensagem;
	public double provaFinal;
	
    public double getProvaFinal() {
		return provaFinal;
	}

	public void setProvaFinal(double provaFinal) {
		this.provaFinal = provaFinal;
	}

	public String getCorMensagem() {
		return corMensagem;
	}

	public void defineCorMensagem(double media) {
		if(media >= 7){
			corMensagem = "color:#238E23; font-size: 24px; list-style-type:none;";
		}else if (media < 4){
			corMensagem = "color:#FF0000; font-size: 24px; list-style-type:none;";
		}else{
			corMensagem = "color:#3232CD; font-size: 24px; list-style-type:none;";
		}
	}

	public boolean isStatusCampoProvaFinal() {
		return statusCampoProvaFinal;
	}

	public void setStatusCampoProvaFinal(boolean statusCampoProvaFinal) {
		this.statusCampoProvaFinal = statusCampoProvaFinal;
	}

	public double getMediaFinal() {
		mediaFinal = aluno.getMedia();
		return mediaFinal;
	}


	public void setMediaFinal(double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}


	public void alterarStatusProvaFinal(boolean status){
    	this.statusCampoProvaFinal= status;
    }
    
    
	public Aluno getAluno() {
		return aluno;
	}
	
	public void limpaAluno(){
		 new Aluno();
	}
	
	public void calcularNotaAluno(){
		aluno.gerarMedia();
		Double media = aluno.getMedia();
		if (media>=7 || media <4){
			alterarStatusProvaFinal(true);
		}else{
			alterarStatusProvaFinal(false);
		}
		
		if (aluno.getMedia() >=4 || aluno.getMedia() <7){
			aluno.setProvaFinal(provaFinal);
		}
		defineCorMensagem(aluno.getMedia());
		adicionarMensagem(aluno.getStatus(),null, null);
	}

	
	public void adicionarMensagem(String sumario, String detalhe, String pagina) {
		FacesMessage mensagem = new FacesMessage(sumario, detalhe);
		FacesContext.getCurrentInstance().addMessage(pagina, mensagem);
	}
	
	public String retornaSituacaoAluno(){
		return aluno.getStatus();
	}
	
	public void preencheValorNotaFinal(Double provaFinal){
		aluno.setProvaFinal(provaFinal);
	}
}
