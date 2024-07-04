/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

/**
 *
 * @author black
 */
//import java.net.URISyntaxException;
//
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Call;
//import com.twilio.type.PhoneNumber;


import java.io.*;
import java.util.concurrent.TimeUnit;


public class SMS {
    
    private static boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

    public static void call(String phonenumber, String message) throws Exception {
        
        String sms = "curl.exe -X POST \"https://api.twilio.com/2010-04-01/Accounts/AC897f38a6ad7b654bf3fa3be1b46ad66c/Messages.json\" ^"
                + "  --data-urlencode \"Body=" + message + "\" ^"
                + "  --data-urlencode \"From=" + ENV.HOST_SMS + "\" ^"
                + "  --data-urlencode \"To=+84" +phonenumber.substring(1)+ "\" ^"
                + "  -u \"" + ENV.SMS_ACOUNT_SID +":"+ENV.SMS_AUTH_TOKEN+"\"";
        // Where we want to execute
        File location = new File("/Users/Saka289/Downloads");

//        runCommand(location, "ls"); // for Mac(Linux based OS) users list files

        runCommand(location, sms); // For Windows users list files
    }

    public static void runCommand(File whereToRun, String command) throws Exception {
        System.out.println("Running in: " + whereToRun);
        System.out.println("Command: " + command);

        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(whereToRun);

        if(isWindows) {
            builder.command("cmd.exe", "/c", command);
        }else {
            builder.command("sh", "-c", command);
        }

        Process process = builder.start();

        OutputStream outputStream = process.getOutputStream();
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();

        printStream(inputStream);
        printStream(errorStream);

        boolean isFinished = process.waitFor(30, TimeUnit.SECONDS);
        outputStream.flush();
        outputStream.close();

        if(!isFinished) {
            process.destroyForcibly();
        }
    }

    private static void printStream(InputStream inputStream) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        }
    }
}
