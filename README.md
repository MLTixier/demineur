               ---------------    JEU DU DEMINEUR      --------------- 

1 - LANCEMENt DU JEU

Le jeu démineur se lance :
- soit avec un run sur le fichier src/main/java/campus.valence.demineur/Main.java, 
- soit en ouvrant le fichier out/artifacts/demineur_jar/demineur.jar dans le terminal avec la commande suivante :
java -jar demineur.jar 


2 - PARAMETRES

Le jeu positionne par défaut 30 bombes.
Pour modifier cela, on peut ajouter l'un de ces deux paramètres :
facile -> lance le jeu avec 5 bombes
difficile -> lance le jeu avec 40 bombes


3 - REGLES DU JEU

Le but du démineur est d'arriver à repérer toutes les bombes cachées aléatoirement sur le plateau.
Un compteur situé en haut à gauche note le nombre de bombes restantes que le joueur n'a pas encore repérées.

Par un clic droit, le joueur peut choisir de marquer une case par une présumée bombe. La case sera ainsi marquée par un v rouge.
Par un clic gauche, le joeuur peut révéler le contenu d'une case. Si celle-ci est une bombe, il a perdu. 
Dans le cas contraire, la case indiquera par un numéro le nombre de cases voisines contenant une bombe.

Le jeu se termine soit au clic gauche sur une bombe (perdu), soit lorsque l'ensemble des cases du plateau a été marquée et que toutes les bombes ont été correctement localisées (gagné).


4 - VERSIONS A VENIR

Les prochaines versions devront :
- proposer au joueur de choisir son niveau de difficulté
- générer le plateau au premier clic pour éviter de tomber sur une bombe dès le démarrage
- proposer au joueur une version démo avec l'énoncé des règles


               ---------------    BON JEU !      --------------- 