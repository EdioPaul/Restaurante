<html>
<head>
	<meta name="layout" content="main"/>
	<title>Controle de Permissão</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<style type="text/css">
	#divUsuarios {
		width: 30%;
		float: left;
		border: 1px solid #000;
		margin: 5px;
	}
	#divPermissoes {
		width: 30%;
		float: right;
		border: 1px solid #fc0;
		margin: 5px;
	}
	#divDetalhesUsuario {
		width: 35%;
		float : left;
		border: 1px solid #000;
		margin: 5px;
	}
	#divFormUsuario {
		padding: 5px;
	}
	</style>
	<script type="text/javascript">
	$(document).ready(function() {
			carregarListaUsuarios()
		})
		
		function carregarListaUsuarios(){
			$.ajax({
				method: "POST",
				url: "listar",
				data: {},
				success: function(data){
					$("#divListaUsuario").html(data)
				}
			)}	
		}
		function retornoSalvarUsuario(data){
			if(data.mensagem=="OK"){
					$("#divMensagemUsuario").html("Usuário salvo com sucesso.")
					$("#input[name=login]").val("")
					carregarListaUsuarios()
				}else{
					$("#divMensagemUsuario").html("Não foi possivel salvar o usuário.")
					}
		}
		
	</script>
</head>
<body>
	<div id="divUsuarios">
		<div id="divFormUsuario">
			<div id="divMensagemUsuario"></div>
			<g:formRemote name="formUsuario" url="[controller: 'controlePermissao', action: 'salvarUsuario' ]" onSuccess="retornoSalvarUsuario(data)" >
				Login <input type="text" name="login" value="" />
				<input type="submit" name="salvar" value="Salvar" />
			</g:formRemote>
		</div>
		<div id="divListaUsuario">
		
		</div>
		
	</div>
	<div id="divDetalhesUsuario">
	
	
	</div>
	<div id="divPermissoes">
		<table>
		<thead>
			<th>Permissão</th>
		</thead>
		<g:each in="${permissoes}" var="permissao">
			<tr>
				<td>${permissao.authority}</td>
			</tr>	
		</g:each>
		</table>
	</div>
</body>
</html>