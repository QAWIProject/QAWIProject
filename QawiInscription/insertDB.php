<?php
if(isset($_POST['submit']))
{
$username=htmlentities(trim(($_POST['username'])));
$mail=htmlentities(trim(($_POST['mail'])));
$password=htmlentities(trim(($_POST['password'])));
$repeatpassword=htmlentities(trim(($_POST['repeatpassword'])));
$planete=htmlentities(trim(($_POST['planete'])));
	if($username&&$mail&&$password&&$repeatpassword&&$planete)
	{
		if($password==$repeatpassword)
		{
			$query = mysql_query("INSERT INTO planete VALUES ('', '$planete', 200, 200, 200, 200, '')");
			$query2 = mysql_query("INSERT INTO utilisateur VALUES('','$username','$mail','$password', 0, 0, (SELECT id_planete FROM planete WHERE nom_planete = '$planete'))");
		}else echo"Les mots de passe doivent etre identiques";
	}else echo"Veuillez remplir tous les champs";
}
?>