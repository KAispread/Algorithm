package hacker_rank;

import java.io.*;
import java.net.*;
import com.google.gson.*;

public class RestApiExample {

    public static int getTotalGoals(String team, int year) throws Exception {
        return totalGoals(year, team);
    }
    private static final String MATCH_URL = "https://jsonmock.hackerrank.com/api/football_matches";

    public static int totalGoals(int year, String team) throws Exception {
        String team1Url = String.format(MATCH_URL+"?year=%d&team1=%s", year, URLEncoder.encode(team,"UTF-8"));
        String team2Url = String.format(MATCH_URL+"?year=%d&team2=%s", year, URLEncoder.encode(team,"UTF-8"));

        return getTeamGoals(team1Url,"team1", 1,0) + getTeamGoals(team2Url,"team2", 1,0);
    }

    // String Response to Json
    private static int getTeamGoals(String teamUrl, String teamtype, int page, int totalGoals) throws Exception {
        String response = getResponsePerPage(teamUrl, page);

        JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
        int totalPages = jsonResponse.get("total_pages").getAsInt();
        JsonArray data = jsonResponse.getAsJsonArray("data");
        for (JsonElement e : data) {
            totalGoals += e.getAsJsonObject().get(teamtype+"goals").getAsInt();
        }

        return totalPages==page? totalGoals : getTeamGoals(teamUrl, teamtype, page+1, totalGoals);
    }

    // HTTP Response
    private static String getResponsePerPage(String endpoint, int page) throws IOException {
        URL url = new URL(endpoint+"&page="+page);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("Content-Type", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response;
        StringBuilder sb = new StringBuilder();
        while((response = br.readLine())!=null) {
            sb.append(response);
        }

        br.close();
        con.disconnect();

        return sb.toString();
    }
}
