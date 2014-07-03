<?php
$nameTitle = "Inscription";
include('connexion.php');
include('header.php');
?>
<center><h1 style="color:white;"> <?php echo($nameTitle); ?> </h1>
<form class="formInsc" method="POST" action="insertDB.php">
	<input type="text" name="username" placeholder="Pseudo"><br>
	<input type="mail" name="mail" placeholder="Mail" ><br>
	<input type="password" name="password" placeholder="Mot de Passe" ><br>
	<input type="password" name="repeatpassword" placeholder="Reecrire le mot de passe"><br>
	<input type="planete" name="planete" placeholder="Nom de la Planete"> <br><br>
	<input class="btInsc" type="submit" value="Creer un compte" name="submit">
</form>
</center>