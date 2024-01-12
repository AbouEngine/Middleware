# Projet Middleware
## Groupe
- JMAIEL Skander
- Camara Aboubacar
- MASSAT Islam

## Présentation
L'objectif de ce projet est d'implémenter une 
application distribuée avec java RMI avec de la
synchronization entre le client et le serveur.
Nous avons donc choisi d'implémenter un jeu de quiz
multijoueur avec buzzer. 
## Fonctionnement et principe du jeu
- Une fois que tous les joueurs(clients) ont rejoint
la partie le serveur leur envoie une question avec 4 choix
de réponse.
- Seule la réponse du joueur qui a buzzé (qui a été le plus
rapide à répondre) est prise en compte.
- Si c'est la bonne réponse son score est incrémenté de 1
et il est décrémenté sinon.
- Le joueur qui accumule 10 points en premier a gagné.
## Comment lancer le jeu
:warning: Ce projet utilise Maven et java 17
1. Cloner le projet : *git clone https://gitlab.univ-nantes.fr/E22B268W/quiz-game.git*
2. Il faut se rendre sous la racine du projet : *cd quiz-game*
3. Compiler le projet : *mvn install*
4. Lancer le serveur (le nombre de jouers est passé en argument ici 2) : *java -jar server/target/Server-1.0-SNAPSHOT-shaded.jar 2*
5. Lancer les clients : *java -jar client/target/Client-1.0-SNAPSHOT-shaded.jar*
