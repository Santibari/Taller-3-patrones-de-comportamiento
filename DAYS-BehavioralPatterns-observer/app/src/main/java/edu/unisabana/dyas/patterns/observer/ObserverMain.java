package edu.unisabana.dyas.patterns.observer;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import edu.unisabana.dyas.patterns.observer.impl.ConfigurationManager;
import edu.unisabana.dyas.patterns.observer.impl.observers.DateFormatObserver;
import edu.unisabana.dyas.patterns.observer.impl.observers.MoneyFormatObserver;

public class ObserverMain {
    public static void main(String[] args) {
        ConfigurationManager conf = ConfigurationManager.getInstance();

        System.out.println(" Inicializando configuracion del sistema...");

        // Configuración inicial
        conf.setDefaultDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
        conf.setMoneyFormat(new DecimalFormat("##.00"));

        System.out.println("Configuracion inicial establecida:");
        System.out.println("  - Formato de fecha: " + conf.getDefaultDateFormat().toPattern());
        System.out.println("  - Formato de dinero: " + conf.getMoneyFormat().format(1234.56));

        // Agregar Observadores
        System.out.println("Agregando observadores...");
        DateFormatObserver dateObserver = new DateFormatObserver();
        MoneyFormatObserver moneyObserver = new MoneyFormatObserver();
        conf.addObserver(dateObserver);
        conf.addObserver(moneyObserver);

        // Modificar Configuración
        System.out.println("Modificando configuracion...");
        conf.setDefaultDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        conf.setMoneyFormat(new DecimalFormat("###,#00.00"));

        System.out.println("Nueva configuracion aplicada:");
        System.out.println("  - Formato de fecha: " + conf.getDefaultDateFormat().toPattern());
        System.out.println("  - Formato de dinero: " + conf.getMoneyFormat().format(1234.56));

        // Remover Observadores
        System.out.println("Removiendo observadores...");
        conf.removeObserver(dateObserver);
        conf.removeObserver(moneyObserver);

        System.out.println("Finalizacion del programa.");
    }
}
