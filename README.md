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
* Page de connection 
* Animer l'image de la pokeball (une seule animation actuellement)
<img src="https://github.com/thibautbesancon/TGE_app/blob/master/img_readme/loginmenu.PNG" width="360" height="640" />
<img src="https://github.com/Rosutovein/Projet3A/blob/master/img_readme/Share.jpg" width="360" height="640" />

### Ecran du pokedex
* Afficher la liste des pokemon avec une barre de recherche
* Possibilité de raffraichir la liste avec un glissement vers le bas (swipe refresh)
<img src="https://github.com/Rosutovein/Projet3A/blob/master/img_readme/PokedexActivity.jpg" width="360" height="640" />
<img src="https://github.com/Rosutovein/Projet3A/blob/master/img_readme/Search.jpg" width="360" height="640" />

### Ecran du pokemon
* Affiche les détails du pokemon sélectionné dans le pokedex
<img src="https://github.com/Rosutovein/Projet3A/blob/master/img_readme/PokemonActivity.jpg" width="360" height="640" />

### Notification push
* Exemple de notification (Firebase)
<img src="https://github.com/Rosutovein/Projet3A/blob/master/img_readme/NotifiationFirebase.jpg" width="360" height="640" />
