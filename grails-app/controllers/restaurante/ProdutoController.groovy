package restaurante

class ProdutoController {

    def index() { 
		def lista = Produto.list() //gera lista da classe Produto
		
		render(view:"/produto/index", model:[produtos: lista])
	}
	
	def adicionar(){
		
		//criando novo objeto 
		Produto novoProduto = new Produto()
		novoProduto.preco = 0
		novoProduto.estoque = new Estoque()
		novoProduto.estoque.quantidade = 0
		novoProduto.estoque.quantidadeMinima = 0
		
		render(template:"/produto/form", model:[produto: novoProduto])
	}
	
	def alterar(){
		Produto produto = Produto.get(params.id)
		render(template:"/produto/form", model:[produto: produto])
	}
	
	def lista(){
		def lista = Produto.list()
		render(template:"/produto/lista", model:[produtos: lista])
	}
	
	def salvar(){
		
		//verifica pelo id se o registro já existe antes de salvar
		Produto produto = null
		if(params.id)
		{
			produto = Produto.get(params.id)
		}else{
			produto = new Produto()
			produto.estoque = new Estoque()
		}
		//pegando dados com params pelo name do input
		produto.nome = params.nome
		produto.preco = params.preco.toDouble()
		produto.estoque = new Estoque()
		produto.estoque.quantidade = params.quantidade.toInteger()
		produto.estoque.quantidadeMinima = params.quantidadeMinima.toInteger()
		
		produto.validate()
		if(!produto.hasErrors()){// se não há erros
			
			produto.save(flush:true) //salva no banco
			render("Salvou com sucesso!")
		}else{
		render("Ops...deu erro!")
		}
	}
	
	def excluir(){
		Produto produto = Produto.get(params.id)
		produto.delete(flush:true)
		
		def lista = Produto.list()
		render(template:"/produto/lista", model:[produtos: lista])
	}
}
