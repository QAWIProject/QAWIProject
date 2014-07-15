<?php
$nameTitle = "Administration";
include('../rel/header.php');
include('../connexion.php');
?>
<center><h1 style="color:white;"> Administration </h1></center>

<br />
<center>
	<table border="2" style="font-weight: bold;text-align: center;background-color: #000;font-family:helvetica;">

	<tr style="color:red;">
		<td >ID Utilisateur</td>
		<td >Nom Utilisateur</td>	
		<td >Email Utilisateur</td>
		<td >Est Administrateur</td>
		<td >ID Planete</td>
		<td >MDP Utilisateur</td>
		<td >Nombre Point</td>
		<td >Modifier</td>
		<td >Supprimer</td>
	</tr>
	<?php
	$selectUsers = $bdd->prepare('SELECT * FROM utilisateur ');
		$selectUsers->execute();
		while($rows=$selectUsers->fetch(PDO::FETCH_OBJ)){
?>
	<tr>
		<td ><?php echo $rows->id_util; ?></td>
		<td ><?php echo $rows->nom_util; ?></td>
		<td ><?php echo $rows->email_util; ?></td>
		<td ><?php echo $rows->est_admin_util; ?></td>
		<td ><?php echo $rows->id_planete; ?></td>
		<td ><?php echo $rows->mdp_util; ?></td>
		<td ><?php echo $rows->point_util; ?></td>
		<td ><a href="modifier.php?id_util=<?php echo $rows->id_util; ?>&amp;id_planete=<?php echo $rows->id_planete; ?>"><img src="../image/modify.ico"></a></td>
		<td ><a href="supprimer.php?id_util=<?php echo $rows->id_util; ?>&amp;id_planete=<?php echo $rows->id_planete; ?>"><img src="../image/del.ico"></a></td>
	</tr>
<?php
	}
?>
?>
	</table></center>
<?php
include('../rel/footer.php');
?>