<?php
include("../connexion.php");
include("../rel/header.php");
/*
 RECUPERATION DONNEES FORMULAIRE
*/
$flag = true;
if(isset($_POST['submit']))
{
	$username= $_POST['username'];
	$mail= $_POST['mail'];
	$password= $_POST['password'];
	$repeatpassword= $_POST['repeatpassword'];
	$planete= $_POST['planete'];
	/*
	 VERIFICATION EN BASE DE DONNEES
	*/

	//  Si le nom d'utilisateur existe déjà
	$selUtil = $bdd->prepare('SELECT nom_util FROM utilisateur WHERE nom_util = ?');
	$selUtil->execute(array($username));
	
	if($selUtil->rowCount()>0){
		$err_us = "Erreur Pseudo";
		header('Location: inscription.php?'.$err_us);
		$flag = false;
	}
	//  Si le mail existe déjà
	$selMail = $bdd->prepare('SELECT email_util FROM utilisateur WHERE email_util = ?');
	$selMail->execute(array($mail));
	
	if($selMail->rowCount()>0){
		header('Location: inscription.php');
		$flag = false;
	}
	//  Si la planete existe déjà
	$selPlanet = $bdd->prepare('SELECT nom_planete FROM planete WHERE nom_planete = ?');
	$selPlanet->execute(array($planete));
	
	if($selPlanet->rowCount()>0){
		header('Location: inscription.php');
		$flag = false;
	}

	/*
	 INSERTION EN BASE DE DONNEES
	*/
	 if($flag == true){
		if($username&&$mail&&$password&&$repeatpassword&&$planete){
			if($password==$repeatpassword){
				$reqPlanete = $bdd->prepare('INSERT INTO planete VALUES ("",:nom_planete, 200, 200, 200, 200)');
				$reqPlanete->execute(array(
								'nom_planete' => $planete
								));
				$reqUtilisateur = $bdd->prepare('INSERT INTO utilisateur VALUES ("",:user_name,:user_mail,:user_password, 0, 0, (SELECT id_planete FROM planete WHERE nom_planete = :nom_planete ))');
				$reqUtilisateur->execute(array(
								'user_name'	  => $username,
								'user_mail'   => $mail,
								'user_password' => $password,
								'nom_planete' => $planete
								));
				if(!$reqPlanete){
					$flag = false;
					?>
				<center>
					<h1 style="color:white;"> Le nom de la planete existe déjà ! </h1>
					<a style="color:white;" href="inscription.php" alt="Accueil">Retour au formulaire </a>
				</center>
				<?php
				}
				if(!$reqUtilisateur){
					$flag = false;
				?>
				<center>
					<h1 style="color:white;"> Le pseudo existe déjà ! </h1>
					<a style="color:white;" href="inscription.php" alt="Accueil">Retour au formulaire </a>
				</center>
				<?php
				}
				?>
				<center>
					<h1 style="color:white;">Félicitation vous avez été inscris !</h1>
					<a style="color:white;" href="../Index.php" alt="Accueil">Retour à la page d'accueil </a>
				</center>
				<?php
			}else {
				$flag = false;
				?>
				<script>
					alert("Les mots de passe doivent etre identiques");
				</script>
				<?php
				header('Location: insciption.php');
			}
		}
	}else{
		echo("Raté");
	}
}