package com.debloater.shell;

import android.util.Log;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Shell extends Plugin {
    private static final String TAG = "ShellPlugin";

    @PluginMethod
    public void executeCommand(PluginCall call) {
        String command = call.getString("command");

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            reader.close();
            String result = output.toString();
            JSObject response = new JSObject();
            response.put("output", result);
            call.resolve(response);
        } catch (Exception e) {
            Log.e(TAG, "Error executing shell command", e);
            call.reject("Error executing shell command: " + e.getMessage());
        }
    }
}
