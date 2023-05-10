package com.debloater.shell;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

public class ShellPlugin extends Plugin {

    private Shell shell;

    @Override
    public void load() {
        shell = new Shell();
    }

    @PluginMethod
    public void executeCommand(PluginCall call) {
        shell.executeCommand(call);
    }
}
