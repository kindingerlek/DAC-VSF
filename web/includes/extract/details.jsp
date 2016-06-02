<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Extrato</h1>
<hr>

<h2> Intervalo:</h2>

<form class="form-inline">

	<div class="form-group">
		<label for="">De: </label>
		<input type="text" name="from-date" class="form-control" id="from-date" placeholder="dd/mm/aaaa">
	</div>
	<div class="form-group">
		<label for="">&nbsp até &nbsp</label>
		<input type="text" name="to-date" class="form-control" id="to-date" placeholder="dd/mm/aaaa">
	</div>

	<div class="pull-right">
		<button class="btn btn-primary">
			<i class="fa fa-search fa-1x"></i>
			Pesquisar
		</button>
	</div>
</form>

<br>

<table class="table table-striped">
	<thead>
		<td class="col-md-4"> <b> Descrição </b> </td>
		<td class="col-md-2"> <b> Entrada <b> </td>
		<td class="col-md-2"> <b> Saída <b> </td>
		<td class="col-md-2"> <b> Data <b> </td>
	</thead>
	<tbody>
		<td>lorem impsum</td>
		<td>lorem impsum</td>
		<td>lorem impsum</td>
		<td>lorem impsum</td>
	</tbody>
</table>