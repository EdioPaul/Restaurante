package restaurante

class Produto {

	String nome
	Double preco
	Estoque estoque
	
	static hasMany = [clientes: Cliente, itens: ItemPedido]
	
	//belongTo - A classe cliente manda nessa associação
	static belongsTo = [Cliente]
	
	//contraints definem regras ao salvar no banco
    static constraints = {
		nome nullable: false, blank: false
		preco min: new Double(0)
    }
	
	static mapping = {
		discriminator column: "tipo", value:"GERAL"
	   estoque column: "id_estoque"	
	   clientes joinTable: [name:"preferencias_clientes", key: "id_cliente", column: "id_produto"]
	   
	}
}
