<?php

include('connexion.php');
include('insertDB.php');

?>

<form method="POST" action="inscription.php">
	<p>Pseudo :</p>
	<input type="text" name="username"> 
	<p>Adresse mail :</p>
	<input type="mail" name="mail">
	<p>Mot de passe :</p>
	<input type="password" name="password">
	<p>Repetez votre mot de passe :</p>
	<input type="password" name="repeatpassword">
	<p>Nom planete :</p>
	<input type="planete" name="planete"> <br><br>
	<input type="submit" value="Creer un compte" name="submit" onclick="def();">
</form>