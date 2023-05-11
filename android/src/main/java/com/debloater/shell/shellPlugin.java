package com.debloater.shell;

import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Shell")
public class ShellPlugin extends Plugin {
    private static final String TAG = "ShellPlugin";

    

    @Override
    public void load() {
    }

    @PluginMethod
    public void executeCommand(PluginCall call) {
        try {
            String command = call.getString("command");
            call.setKeepAlive(true);
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            reader.close();
            process.waitFor(); // Wait for the process to complete
            int exitCode = process.exitValue();
            String result = output.toString();
            JSObject response = new JSObject();
            Log.i("Echo",result);
            response.put("output", result);
            response.put("exitCode", exitCode);
            call.resolve(response);
        } catch (Exception e) {
            Log.e(TAG, "Error executing shell command", e);
            call.reject("Error executing shell command: " + e.getMessage());
        }
    }
}
