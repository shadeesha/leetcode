package src.demo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class Solution {

    static Integer totalGoals = 0;

    public static int run(String teamKey) {

        try {
            URL url = new URL("https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/football_session/football.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if(responseCode != 200) {
                throw new RuntimeException("No response");
            } else {
                StringBuilder inline = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }

                scanner.close();

                totalGoals = 0;

                JsonObject data_object = new JsonParser().parse(inline.toString()).getAsJsonObject();
                JsonArray rounds = data_object.getAsJsonArray("rounds");
                rounds.forEach(round -> {
                    JsonObject roundObj = round.getAsJsonObject();
//                    System.out.println(roundObj.get("name"));
                    JsonArray matches = roundObj.getAsJsonArray("matches");

                    matches.forEach(match -> {
                        JsonObject matchObj = match.getAsJsonObject();
//                        System.out.println(matchObj.get("date"));
                        JsonObject teamObj1 = matchObj.getAsJsonObject("team1");
                        JsonObject teamObj2 = matchObj.getAsJsonObject("team2");
                        String team1Key = teamObj1.get("key").getAsString();
                        String team2Key = teamObj2.get("key").getAsString();
                        if(teamKey.equals(team1Key)) {
                            Long goals = matchObj.get("score1").getAsLong();
                            totalGoals = goals.intValue() + totalGoals;
                        }
                        if(teamKey.equals(team2Key)) {
                            Long goals = matchObj.get("score2").getAsLong();
                            totalGoals = goals.intValue() + totalGoals;
                        }
                    });
                });
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return totalGoals;
    }

    public static void main(String[] args) {
        int goals = run("manutd");
        System.out.println(goals);
    }
}
