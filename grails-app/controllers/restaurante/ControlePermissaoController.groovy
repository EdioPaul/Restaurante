package restaurante

import grails.converters.JSON;
import comum.Permissao;
import comum.Usuario;

class ControlePermissaoController {

    def index() { 
		def listaUsuarios = Usuario.list()
		def listaPermissoes = Permissao.list()
		render(view:"index", model: [usuarios: listaUsuarios, permissoes: listaPermissoes ])
	}
	
	def listar(){
		def listaUsuarios = Usuario.list()
		render(template:"listaUsuarios", model:[usuarios: listaUuarios])
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
