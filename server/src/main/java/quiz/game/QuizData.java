package quiz.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizData {
    private static final String QUIZ_DATA = """
            Quelle est la capitale de la France?,Berlin,Paris,Londres,Madrid,2
            Quelle est la planete connue sous le nom de la planete rouge?,Terre,Mars,Jupiter,Venus,2
            Combien de continents y a-t-il dans le monde?,5,6,7,8,3
            Quelle est la plus grande mer du monde?,Mer Mediterranee,Mer Noire,Mer Rouge,Ocean Pacifique,4
            Quelle est la langue la plus parlee au monde?,Anglais,Chinois,Espagnol,Hindi,2
            Quel est le plus grand ocean de la Terre?,Ocean Atlantique,Ocean Indien,Ocean Arctique,Ocean Pacifique,4
            Combien de cotes a un pentagone?,3,4,5,6,3
            Quel est le symbole chimique de l'oxygene?,O,OX,O2,O3,3
            Quel est le plus grand mammifere terrestre?,Elephant,Girafe,Rhinoceros,Baleine bleue,4
            Quel est le pays le plus peuple du monde?,Inde,Chine,Etats-Unis,Russie,2
            Quel est le plus grand desert du monde?,Sahara,Gobi,Arctique,Kalahari,1
            Quel est le plus grand fleuve du monde?,Nil,Amazone,Indus,Yangtse,2
            Combien de planetes dans notre systeme solaire?,8,9,10,11,1
            Quelle est la vitesse de la lumiere?,300 000 km/s,500 000 km/s,1 000 000 km/s,3 000 000 km/s,1
            Quel est le plus haut sommet du monde?,Mont Everest,Mont Kilimandjaro,Mont McKinley,Mont Fuji,1
            Quel est le plus grand animal du monde?,Elephant,Baleine bleue,Girafe,Lion de mer,2
            Quel est le plus grand lac d'Afrique?,Lac Victoria,Lac Tanganyika,Lac Malawi,Lac Turkana,1
            Quel est le plus grand ocean de la Terre?,Ocean Atlantique,Ocean Indien,Ocean Arctique,Ocean Pacifique,4
            Quelle est la monnaie du Japon?,Yuan,Won,Yen,Franc suisse,3
            Quel est le plus grand reptile du monde?,Alligator,Crocodile,Iguane,Serpent anaconda,2
            Quel est le plus grand poisson du monde?,Requin baleine,Requin tigre,Requin marteau,Poisson-lune,1
            Quel est le plus grand Etat des Etats-Unis?,Alaska,Californie,Texas,Floride,1
            Quel est le plus grand mammifere marin du monde?,Baleine bleue,Orque,Requin blanc,Calmar geant,1
            Quel est le plus grand pays d'Amerique du Sud?,Bresil,Argentine,Colombie,Perou,1
            Quel est le plus grand lac du monde en termes de superficie?,Lac Superieur,Lac Baikal,Lac Michigan,Lac Victoria,2
            Quel est le plus grand desert chaud du monde?,Sahara,Arabie,Mojave,Gobi,1
            Quel est le plus grand ocean de la Terre?,Ocean Atlantique,Ocean Indien,Ocean Arctique,Ocean Pacifique,4
            Quelle est la distance moyenne entre la Terre et le Soleil?,100 000 km,150 000 km,200 000 km,250 000 km,2
            Quel est le plus grand insecte du monde?,Fourmi,Sauterelle,Libellule,Papillon monarque,1
            Quel est le plus grand mammifere volant?,Chauve-souris,Condor,Albatros,Colibri,3
            Quelle est la plus grande ile du monde?,Ile de Paques,Ile de Baffin,Ile de Borneo,Ile de Groenland,4
            Quelle est la plus longue riviere du monde?,Fleuve Amazone,Fleuve Nil,Fleuve Congo,Fleuve Mississippi,1
            Quel est le plus grand arbre du monde?,Sequoia geant,Sequoia a feuilles d'if,Chene,Pins de Bristlecone,1
            Quelle est la plus grande cascade du monde?,Chutes du Niagara,Chutes d'Iguacu,Chutes du Victoria,Chutes d'Angel,4
            Quel est le plus grand organe du corps humain?,Coeur,Poumons,Peau,Foie,3
            Quel est le plus grand reptile du monde?,Alligator,Crocodile,Iguane,Serpent anaconda,2
            Quel est le plus grand poisson du monde?,Requin baleine,Requin tigre,Requin marteau,Poisson-lune,1
            Quel est le plus grand parc national du monde?,Parc national de Yellowstone,Parc national de Banff,Parc national d'Everglades,Parc national de Wrangell-St. Elias,4
            Quel est le plus grand mammifere marin du monde?,Baleine bleue,Orque,Requin blanc,Calmar geant,1
            Quel est le plus grand pays d'Amerique du Sud?,Bresil,Argentine,Colombie,Perou,1
            Quel est le plus grand lac du monde en termes de superficie?,Lac Superieur,Lac Baikal,Lac Michigan,Lac Victoria,2
            Quel est le plus grand desert chaud du monde?,Sahara,Arabie,Mojave,Gobi,1
            Quel est le plus grand ocean de la Terre?,Ocean Atlantique,Ocean Indien,Ocean Arctique,Ocean Pacifique,4
            """;
    public static List<Question> getData(){
        List<Question> questions = new ArrayList<>();
        for(String question : QUIZ_DATA.split("\n") ){
            String[] arr = question.split(",");
            String[] options = Arrays.copyOfRange(arr, 1,5);
            questions.add(new Question(arr[0], options,Integer.parseInt(arr[5])));
        }

        return questions;
    }
}


