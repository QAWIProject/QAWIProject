<?php
$nameTitle = "Modification";
include('../rel/header.php');
include('../connexion.php');
?>

		<?php
			$id_util = $_GET['id_util'];

		?>		
	
		<center><h1 style="color:white;">Modification information compte utilisateur</h1></center>
		<center>
			<form method="POST" action="modifAction.php?id_util=<?php echo $id_util ?>">
				<table>
						<tr>
						<td>
							<p> E-mail: </p>
						</td>
						<td>
							<input type="text" name="newMail" />
						</td>

					</tr>
					<tr>
						<td>
							<p> Nom de joueur: </p>
						</td>
						<td>
							<input type="text" name="newNom" />
						</td>

					</tr>
					<tr>
						<td>
							<p> Nombre de point: </p>
						</td>
						<td>
							<input type="text" name="newPoint" />
						</td>

					</tr>
					<tr>
						<td>
							<p> Mot de passe: </p>
						</td>
						<td>
							<input type="text" name="newMdp" />
						</td>

					</tr>					
					<tr>
						<td>
							<input type="reset" value="Annuler" />
						</td>
						<td>
							<p><input type="submit" value="Modifier" /></p>
						</td>

					</tr>											 		
		 		</table>

		 	</form>
	 	</center>
<?php
include('../rel/footer.php');
?>