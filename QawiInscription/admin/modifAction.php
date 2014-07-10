<?php
$nameTitle = "Supprimer";
	include('../rel/header.php');
	include('../connexion.php');
?>
<h1 style="color:white;"> Modificaton utilisateur </h1>

<?php
	if($_GET['id_util'] != "") {
		$modif_user = $bdd ->prepare('UPDATE utilisateur SET email_util=?, nom_util=?, point_util=?, mdp_util=? WHERE id_util =?');
		$modif_user->bindParam(1, $_POST['newMail']);
		$modif_user->bindParam(2, $_POST['newNom']);
		$modif_user->bindParam(3, $_POST['newPoint']);
		$modif_user->bindParam(4, $_POST['newMdp']);
		$modif_user->bindParam(5, $_GET['id_util']);
		$modif_user->execute();
	}
?>
<a href="administration.php" style="color:white;text-decoration:none;">RETOUR</a>
<?php
	include('../rel/footer.php');
?>