package restaurante

class Cliente {
	
	//atributos tabela cliente
	
	String nome
	String email
	String senha
	
//	relacao um para muitos cliente x pedido ( chave estrangeira fica nos pedidos)
	static hasMany = [pedidos:Pedido, produtosPreferidos: Produto]

    static constraints = {
		nome nullable:false, blank: false
		email email:true, unique:true //email para padrao e unique nao deixa salvar emails iguais
		senha size: 6..10 //min 6 caracteres e max 10
		
    }
	//mapping permite renomear atributos na tabela relacionada, também criar
	//tabela para relacionamento da classe que esta entre as principais
	static mapping = {
		produtosPreferidos joinTable: [name:"preferencias_clientes", key: "id_produto", column: "id_cliente"]
		
	 }
	
}
