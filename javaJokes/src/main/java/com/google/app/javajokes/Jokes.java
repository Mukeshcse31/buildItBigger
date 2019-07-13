package com.google.app.javajokes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Jokes {
    public String getJokes(){

//http://mistupid.com/jokes/page128.htm
        ArrayList<String> jokes = new ArrayList<String>( Arrays.asList(
            "The roundest knight at King Arthur's round table was Sir Cumference. He acquired his size from too much pi.",

            "I thought I saw an eye doctor on an Alaskan island, but it turned out to be an optical Aleutian.",

            "She was only a whisky maker, but he loved her still.",

            "A rubber band pistol was confiscated from algebra class because it was a weapon of math disruption.",

            "The butcher backed into the meat grinder and got a little behind in his work.",

            "No matter how much you push the envelope, it'll still be stationery.",

            "A dog gave birth to puppies near the road and was cited for littering.",

            "A grenade thrown into a kitchen in France would result in Linoleum Blownapart.",

            "Two silk worms had a race. They ended up in a tie.",

            "Time flies like an arrow. Fruit flies like a banana.",

            "A hole has been found in the nudist camp wall. The police are looking into it.",

            "Atheism is a non-prophet organization.",

            "Two hats were hanging on a hat rack in the hallway. One hat said to the other, 'You stay here, I'll go on ahead.'",

            "I wondered why the baseball kept getting bigger. Then it hit me.",

            "A sign on the lawn at a drug rehab center said: 'Keep off the Grass.'",

            "A small boy swallowed some coins and was taken to a hospital. When his grandmother telephoned to ask how he was, a nurse said, 'No change yet.'",

            "A chicken crossing the road is poultry in motion.",

            "It's not that the man did not know how to juggle, he just didn't have the balls to do it.",

            "The short fortune-teller who escaped from prison was a small medium, at large.",

            "The man who survived mustard gas and pepper spray is now a seasoned veteran.",

            "A backward poet writes in-verse.",

            "In democracy it's your vote that counts. In feudalism it's your count that votes.",

            "When cannibals ate a missionary, they got a taste of religion.",

            "Don't join dangerous cults, practice safe sects!"
        ));

        // pick a random index
        Random rand = new Random();
        int index = rand.nextInt(jokes.size());

        return jokes.get(index);
    }
}
