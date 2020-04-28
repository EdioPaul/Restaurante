package restaurante

class Pedido {
	
	Date dataHora
	Double valorTotal
	
	Cliente cliente

	static hasMany = [itens: ItemPedido]
	
    static constraints = {
		valorTotal min: new Double(0)
		cliente nullable: false
    }
	
	static mapping = { //alterando o nome do atributo no objeto cliente
	
		cliente column: "id_cliente"
	}
}
