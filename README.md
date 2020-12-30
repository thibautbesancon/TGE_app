# TGE_app

## Créateur
Thibaut Besancon, étudiant en 4ème année à l'école d'ingénieur ESIEA

## Présentation
Projet consistant en la création d'une application android codé en Kotlin pour le trophée des écoles.
Cette application affiche la liste des membres du trophée des écoles et utilise une API de Github
(JSON stocké sur ce compte github)

## Prérequis
* Installation du logiciel Android Studio (disponible sur Mac, Linux et Windows)
* Récupérer le programme grâce au lien Github suivant:
```
https://github.com/thibautbesancon/TGE_app.git
```

## Consignes respectées:
    ◦    Language Kotlin 
    ◦    Architecture MVVM
    ◦    Clean Architecture
    ◦    Utilisation d’une réelle BDD
    ◦    Utilisation Api REST
    ◦    Affichage d’une liste
    ◦    Design 
* Fonctions supplémentaires:
  * Page de menu non connecté
  * Gestion login
  * Gestion création compte
  * Hashage des mots de passe
  

## Fonctionalités:

### Première écran
* Main Screen au démarage de l'application, l'objectif était d'avoir acces a des fonctionnalité sans avoir besoin de se connecter.
* Un menu en haut à droite permet d'accéder à la page de login
<img src="https://raw.githubusercontent.com/thibautbesancon/TGE_app/master/img_readme/Mainmenu.PNG" width="360" height="640" />

### Login menu
* Page de connection avec un message Oups ! si login ou mot de passe incorrect
* bouton créer un user
<img src="https://github.com/thibautbesancon/TGE_app/blob/master/img_readme/loginmenu.PNG" width="360" height="640" />
<img src="https://github.com/thibautbesancon/TGE_app/blob/master/img_readme/logoups.PNG" width="310" />

### Create Account
* Création de compte avec multiple protection. 
* Entre autre, verification de mot de passe, vérification compte existant, vérification champ email bien rempli
<img src="https://github.com/thibautbesancon/TGE_app/blob/master/img_readme/createmenu.PNG" width="360" height="640" />
<img src="https://github.com/thibautbesancon/TGE_app/blob/master/img_readme/existoups.PNG" width="310" />
<img src="https://github.com/thibautbesancon/TGE_app/blob/master/img_readme/loginoups.PNG" width="310" />
<img src="https://github.com/thibautbesancon/TGE_app/blob/master/img_readme/passwordoups.PNG" width="310" />

### Password stocker hasher
* Les mots de passe ne sont pas stocker en clair, ils sont hasher en Sha-256 et c'est leur Hash qui est stocker
<img src="https://github.com/thibautbesancon/TGE_app/blob/master/img_readme/Chiffrement.PNG"/>

### Menu après log
* affichage des fonctionnalité précedente plus accès au fonctionnalité privé
<img src="https://github.com/thibautbesancon/TGE_app/blob/master/img_readme/mainlog.PNG" width="360" height="640" />

### Voir plus loin,
* Exemple de notification (Firebase)
<img src="https://github.com/Rosutovein/Projet3A/blob/master/img_readme/NotifiationFirebase.jpg" width="360" height="640" />
