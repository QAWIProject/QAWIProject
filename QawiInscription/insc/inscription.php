<?php
$nameTitle = "Inscription";
require_once('../rel/header.php');
?>
<iframe class="vid" width="100%" height="100%" src="//www.youtube.com/embed/ZWoGkrt5Upg?rel=0&autoplay=1;showinfo=0;controls=0;hd=1;iv_load_policy=3" frameborder="0" allowfullscreen></iframe>
<center>
	<br />
	<b class="txtInsc">INSCRIPTION QAWI</b>
<form class="formInsc" method="POST" action="insertDB.php">
	<input type="text" name="username" placeholder="Pseudo"><br /><br />
	<input type="mail" name="mail" placeholder="Mail" ><br /><br />
	<input type="password" name="password" placeholder="Mot de Passe" ><br><br />
	<input type="password" name="repeatpassword" placeholder="Reecrire le mot de passe"><br><br />
	<input type="planete" name="planete" placeholder="Nom de la Planete"> <br><br>
	<input class="btInsc" type="submit" value="Creer un compte" name="submit">
</form>
</center>
<?php
include("../rel/footer.php");
?>