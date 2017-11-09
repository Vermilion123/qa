package section.authtorize.auth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Uzing default java class Url, HttpUrlConnection,
 * smscenter api, smsc.ru
 *
 */
public class SMSCenterHelper {

    private final String login = "clientixcrm";
    private final String login2 = "clientixcrm2";
    private final String pass = "qetuo2468";

    // https://smsc.ru/sys/get.php?get_messages=1&login=clientixcrm2&psw=qetuo2468&phone=79523661303
    public String url1 = "https://smsc.ru/sys/get.php?get_messages=1&login=" + login + "&psw=" + pass +"&phone=";
    private String url2 = "https://smsc.ru/sys/get.php?get_messages=1&login=" + login2 + "&psw=" + pass +"&phone=";

    public String getLastMessage(String url, String phone) throws Exception {
        url+= phone + "&fmt=3";
        //url = "https://smsc.ru/sys/get.php?get_messages=1&login=clientixcrm2&psw=qetuo2468&cnt=2&fmt=3&phone=79523661303";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        // add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Charset", "utf-8");
        con.setRequestProperty("Accept-Language", "ru");

        int responseCode = con.getResponseCode();
        System.out.println("response code " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    private String parsePassword(String url, String phone) throws Exception{
        Pattern p = Pattern.compile("[\\d]{6}.\\s");
        Matcher m = p.matcher(getLastMessage(url, phone));
        String result = "";
        if (m.find()) {
            result = m.group();
            System.out.println("CODE IS : " + m.group());
        }
        return result;
    }

    private String parseCode(String url, String phone) throws Exception {
        Pattern p = Pattern.compile("\\s[\\d]{4}\\W.");
        Matcher m = p.matcher(getLastMessage(url, phone));
        String result = "";
        if (m.find()) {
            result = m.group();
            System.out.println("CODE IS : " + m.group());
        }
        return result;
    }

    private Integer getCode(String url, String phone, String data) throws Exception {
        if (Objects.equals(data, "")) {
            return -1;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            if (Character.isDigit(data.charAt(i)))
                builder.append(data.charAt(i));
        }
        return Integer.valueOf(builder.toString());
    }

    public Integer[] getCodesFromTwoAccounts(String phone) throws Exception{
        return new Integer[]{
                getCode(url1, phone, parseCode(url1, phone)),
                getCode(url2, phone, parseCode(url2, phone))
        };
    }


    public static void main(String[] args) throws Exception {
        SMSCenterHelper sms = new SMSCenterHelper();
        String phone = "79523661303";
        //System.out.println(Arrays.toString(sms.getCodesFromTwoAccounts(phone)));
        System.out.println(Arrays.toString(sms.getCodesFromTwoAccounts(phone)));



    }

}
