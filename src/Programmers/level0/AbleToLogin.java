package Programmers.level0;
/*
* 로그인 성공?
* */
public class AbleToLogin {
    public static void main(String[] args) {

    }

    private final static String LOGIN_SUCCESS = "login";
    private final static String NO_SUCH_ID = "fail";
    private final static String WRONG_PW = "wrong pw";

    public String solution(String[] id_pw, String[][] db) {
        String inputId = id_pw[0];
        String inputPw = id_pw[1];

        for (String[] idPw : db) {
            String dbId = idPw[0];
            String dbPw = idPw[1];
            if (validId(inputId, dbId)) {
                return validPassword(inputPw, dbPw);
            }
        }
        return NO_SUCH_ID;
    }

    private boolean validId(String id, String dbId) {
        if (id.equals(dbId)) {
            return true;
        }
        return false;
    }


    private String validPassword(String pw, String dbPw) {
        if (pw.equals(dbPw)) {
            return LOGIN_SUCCESS;
        }
        return WRONG_PW;
    }
}
