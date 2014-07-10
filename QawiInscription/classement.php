<?php
$nameTitle = "Classement Joueurs";
include('rel/header.php');
include('connexion.php');
?>
<style>
a{
	text-decoration: none;
	color: white;
}
a:hover{
	color: red;
}
.center{
	margin-top:20%;
	margin-left:5%;
}
body{
	background-image: url('image/bg.jpg');
	margin: 0px;
	color: white;
}
</style>
<center>
<h1 style="color:white;"> Classement des joueurs </h1>

<table border="2">

	<tr>
	
	<td >Nom Utilisateur</td>	
	<td >Nombre Point</td>


	</tr>

<?php
	$classUser = $bdd->prepare('SELECT nom_util, point_util FROM utilisateur ORDER BY point_util DESC');
	$classUser->execute();

	while($rows=$classUser->fetch(PDO::FETCH_OBJ)){
?>
	<tr>
	
	<td ><?php echo $rows->nom_util; ?></td>
	<td ><?php echo $rows->point_util; ?></td>


	</tr>
<?php
	} 
?>
</table>
</center>
<?php
include('rel/footer.php');
?>