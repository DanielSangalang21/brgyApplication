package com.dcs.brgy.util;

import java.awt.GraphicsEnvironment;

public class ListFonts {
    public static void main(String args[]) {
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        for(String font:e.getAvailableFontFamilyNames()) {
            System.out.println(font);
        }
    }
}