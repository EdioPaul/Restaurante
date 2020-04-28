package restaurante

class Estoque {

	Integer quantidade
	Integer quantidadeMinima
	Produto produto    //relacao um pra um EstoquexProduto
	
	static belongsTo = [Produto]

	static constraints = {
		quantidade min: 0
		quantidadeMinima min: 0
		produto nullable: false
	}
}
