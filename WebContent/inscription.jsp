<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.html" />
		<form id="form_connex" method="POST" action="#" onsubmit="return nullValue();">
           <input type="text" placeholder="Pseudo" id="pseudo"/><br /><br />
           <input type="password" placeholder="Password" id="pass" /><br /><br />
           <input type="submit" value="Connexion" id="bt_connex" />
        </form>
        <br />
        <h4 onclick="displayForm();"> Inscrivez-vous </h4>
        <form  style="display:none;" id="form_insc" method="POST" action="#" onsubmit="return verifCaptcha();">
           <input type="text" placeholder="Pseudonyme" id="pseudoInsc"/><br /><br />
           <input type="password" placeholder="Mot de Passe" id="passInsc"/><br /><br />
           <input type="text" placeholder="Adresse Mail" id="mailInsc"/><br /><br />
           <input type="text" id="captcha" /><br /><br />
           Saisir les numéros ci-dessus :
           <input type="text" id="valueCaptcha" /><br /><br />
           <input type="submit" value="S'inscrire" id="bt_insc" />
        </form>
        <script>
            // Appel de la fonction de random du captcha
            function random(){
                var captcha = 0;
                var i=0;
                for(i=0;i<5;i++){
                    captcha += Math.floor((Math.random() * 100000) + 1);
                }
                document.getElementById("captcha").value = String(captcha);
                document.getElementById("captcha").style.color = "red";
                document.getElementById("captcha").style.fontSize = "17px";
                document.getElementById("captcha").disabled="disabled"
                document.getElementById("captcha").style.textAlign = "center";
            }
            // Lancement du premier random du Captcha
            random();
            // Vérification Pseudo et Mot de passe null
            function nullValue(){
                if((document.getElementById("pseudo").value == "") && (document.getElementById("pass").value == "")){
                    document.getElementById("pseudo").style.backgroundColor = "#FFB6B8";
                    document.getElementById("pass").style.backgroundColor = "#FFB6B8";
                    return false;
                }else if(document.getElementById("pseudo").value == ""){
                    document.getElementById("pseudo").style.backgroundColor = "#FFB6B8";
                    return false;
                }
                else if(document.getElementById("pass").value == ""){
                    document.getElementById("pass").style.backgroundColor = "#FFB6B8";
                    return false;
                }
                else{
                    return true;
                }
            }
            // Vérification du Captcha
            function verifCaptcha(){
                if(document.getElementById("valueCaptcha").value != document.getElementById("captcha").value){
                    alert("false");
                    random();
                    return false;
                }else{
                    alert("true");
                    return true;
                }
            }
            // Rendre visible le formulaire d'inscription'
            function displayForm(){
                document.getElementById("form_insc").style.display = "block";
            }
        </script>
<jsp:include page="footer.html" />