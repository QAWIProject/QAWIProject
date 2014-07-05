<?php
$nameTitle = "Administration";
require_once('../rel/header.php');
?>
<center>
	<br />
	<b class="txtAdmin">ADMINISTRATION QAWI</b>
<form class="formAdmin" method="POST" action="verifAdmin.php">
	<input type="text" name="username" placeholder="Pseudo"><br>
	<input type="password" name="password" placeholder="Mot de Passe" ><br>
	<input class="btAdmin" type="submit" value="Connexion" name="submit">
</form>
</center>
<?php
include("../rel/footer.php");
?>