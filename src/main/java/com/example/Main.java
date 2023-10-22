package com.example;

import java.net.URL;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

public class Main {

    public static void main(String[] args) {

        try ( Context context = Context.create()) {
            URL url = Main.class.getResource("/script.js");
            Source script = Source.newBuilder("js", url).build();
            Value value = context.eval(script);
            System.out.println("Result: " + value.asString() + " on " + System.getProperty("java.vendor.version"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}