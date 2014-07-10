<?php
$nameTitle = "Connexion Administration";
include('../rel/header.php');
include('../connexion.php');
?>
<center>
	<br />
	<b class="txtAdmin">ADMINISTRATION QAWI</b>
<form class="formAdmin" method="POST" action="<?php $_SERVER['PHP_SELF'] ?>">
	<input type="text" name="username" placeholder="Pseudo"><br>
	<input type="password" name="password" placeholder="Mot de Passe" ><br>
	<input class="btAdmin" type="submit" value="Connexion" name="submit">
</form>
</center>
<?php
	if (isset($_POST['submit'])){
			$name = $_POST['username'];
			$password = $_POST['password'];
			$etreAdmin = 1;
			$selUtil = $bdd->prepare('SELECT nom_util FROM utilisateur WHERE nom_util = ? AND pass_util = ? AND est_admin_util = ?');

			$selUtil->execute(array($name,
									$password,
									$etreAdmin));
			if($selUtil != null){
				$flag = true;
				?>
				<script>
				alert("Connecte");
				document.location.href="administration.php" 
				</script>
				<?php
			}else{
				$flag = false;
				$error = "*";
			}
	}


include("../rel/footer.php");

?>