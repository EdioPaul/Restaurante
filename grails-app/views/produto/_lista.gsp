<g:if test="${produtos.size() >0 }">
	<table>
	<tr>
		<th>Nome</th>
		<th>Preço</th>
		<th>Qtde. Atual</th>
		<th>Qtde. Mínima</th>
		<th>Ações</th>
	</tr>
	<g:each var="produto" in="${produtos}">
		<tr>
			<td>${produto.nome}</td>
			<td>${produto.preco}</td>
			<td>${produto.estoque?.quantidade}</td> <!-- ? safe operator impede que tente salvar objeto nulo -->
			<td>${produto.estoque?.quantidadeMinima}</td>
			<td>
			    <!-- Preenchendo o form para alterar com dados pelo id -->
				<g:remoteLink controller="produto" action="alterar" update="divForm" id="${produto.id}">Alterar</g:remoteLink>
				&nbsp;
				<a href="#" onclick="excluir('${produto.id}')">Excluir</a>
			</td>
		</tr>
	</g:each>
	</table>
</g:if>
<g:else>
 Não há produtos.
</g:else>
