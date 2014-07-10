<?php
	$nameTitle = "Supprimer";
	include('../rel/header.php');
	include('../connexion.php');
?>
<h1 style="color:white;"> Supression utilisateur </h1>

<?php
	if ($_GET['id_util'] != null) {
		$supp_user = $bdd ->prepare('DELETE FROM utilisateur WHERE id_util = ? AND id_planete = ?');
		$supp_user->bindParam(1, $_GET['id_util']);
		$supp_user->bindParam(2, $_GET['id_planete']);
		$supp_user->execute();
	}
		


?>
<a href="administration.php" style="color:white;text-decoration:none;">RETOUR</a>
<?php
	include('../rel/footer.php');
?>