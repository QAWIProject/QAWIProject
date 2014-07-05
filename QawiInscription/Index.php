<?php
$nameTitle = "Bienvenue";
include("../rel/header.php");
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
}
</style>
<center>
	<div class="center">
		<h1><a href="admin/admin.php"> ADMINISTRATION</a></h1>
		<h1><a href="insc/inscription.php">INSCRIPTION</a></h1>
	</div>
</center>
<?php
include("../rel/footer.php");
?>