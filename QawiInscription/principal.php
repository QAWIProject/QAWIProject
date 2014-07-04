<?php
	include("connexion.php");
	include("header.php");
	// Get planete
	$getPlanete = $bdd->query('SELECT * FROM planete,utilisateur WHERE utilisateur.id_planete = planete.id_planete');
	?>
	<table style="background-color:#CCCCCC;border-radius:5px;margin:10px">
 		<colgroup>
 	  		<col span"1" style="background-color:#CCCCCC">
    		<col style="background-color:#CCCCCC">
    		<col style="background-color:#CCCCCC">
    		<col style="background-color:#CCCCCC">
		</colgroup>
  		<tr style="background-color:#01B0F0">  			
  			<th>Nom Planete</th>
  			<th>Pseudo Joueur</th>
  			<th>Mot de passe</th>
  			<th>E-mail</th>
  			<th style="background-color:#CCCCCC;"><img height="40" width="40" src="image/add.ico" /><th>
  		</tr>
  		
		<?php
			$idLine = 0;
			while($rowPla = $getPlanete->fetch()){
		?>
				<tr>
					<form class="myForm<?php echo($idLine) ?>">
						<td><input id="ip1" type="text" disabled="true" value="<?php echo($rowPla['nom_planete'])?>" /></td>
						<td><input id="ip2" type="text" disabled="true" value="<?php echo($rowPla['nom_util']); ?>"/></td>
						<td><input id="ip3" type="text" disabled="true" value="<?php echo($rowPla['mdp_util']); ?>"/></td>
						<td><input id="ip4" type="text" disabled="true" value="<?php echo($rowPla['email_util']); ?>"/></td>
						<td><img id="btEdit" src="image/edit.ico" height="40" width="40"/></td>
						<td><img height="40" width="40" src="image/del.ico" /></td>
					</form>
				</tr>
		<?php
			$idLine++;
			}
		?>
	</table>
	<script type="text/javascript">
		$("input").prop('disabled', false);
	</script>