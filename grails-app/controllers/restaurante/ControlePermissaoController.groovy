package restaurante

import grails.converters.JSON;
import comum.Permissao;
import comum.Usuario;

class ControlePermissaoController {

    def index() { 
		render(view:"index")
	}
	
	def getUsuario(){
		
	}
	
	def getPermissao(){
		Permissao permissao = Permissao.get(params.id)
		render permissao as JSON
	}
	
	def listarPermissao(){
		def listaPermissoes = Permissao.list()
		render(template: "listaPermissoes", model:[permissoes: listaPermissoes])
	}
	
	def salvarPermissao(){
		def retorno = [:]
		Permissao permissao 
		if (params.id){
			permissao = Permissao.get(params.id)
		}else{
			permissao = new Permissao()
		}
		permissao.authority = params.permissao
		permissao.validate()
		if (!permissao.hasErrors()){
			permissao.save(flush:true)
			retorno["mensagem"]=["OK"]
		}else{
			retorno["mensagem"]=["ERRO"]
	}
		render retorno as JSON
	}
	
	def excluirUsuario(){
		
	}
	
	def excluirPermissao(){
		
	}
	
	def listarUsuario(){
		def listaUsuarios = Usuario.createCriteria().list{
			order("username")
		}
		render(template:"listaUsuarios", model:[usuarios: listaUsuarios])
	}
	
	def salvarUsuario() {
		def retorno = [:]
		
		Usuario usuario = new Usuario()
		usuario.username = params.login
		usuario.enabled = true
		usuario.passwordExpired = false
		usuario.accountExpired = false
		usuario.accountLocked = false
		usuario.password = "1234"
		usuario.validate()
		if (!usuario.hasErrors()){
			usuario.save(flush:true)
			retorno["mensagem"]="OK"
		}else{
			retorno["mensagem"]="ERRO"  
		}
		render retorno as JSON
	}
}
