<?php		
try
{
	$bdd = new PDO('mysql:host=localhost;dbname=QAWI', 'root', 'root');
}
catch(Exception $e)
{
        die('Erreur : '.$e->getMessage());
}
?>