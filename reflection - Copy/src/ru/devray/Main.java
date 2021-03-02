package ru.devray;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vault federalVault = new Vault();

        Field[] fields = federalVault.getClass().getDeclaredFields();
        Method[] mtds = federalVault.getClass().getDeclaredMethods();
        List<Object> myStorage = new ArrayList<>();

        // Берем значения
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                myStorage.add(field.get(federalVault));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Заносим в своё хранилище
        try {
            Constructor myConstructor = federalVault.getClass().getDeclaredConstructor(
                    int.class, int.class, double.class, String.class
            );
            myConstructor.setAccessible(true);
            Vault myVault = (Vault) myConstructor.newInstance(myStorage.get(0), myStorage.get(1), myStorage.get(2), myStorage.get(3));
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // Обнуляем исходное хранилище
        for (Method methods : mtds) {
            try {
                Method method = federalVault.getClass().getDeclaredMethod(methods.getName(), methods.getParameterTypes());
                method.setAccessible(true);

                if (methods.getName().equals("setDollars") || methods.getName().equals("setEuros") || methods.getName().equals("setTonsOfGold")) {
                    method.invoke(federalVault, 0);
                } else if (methods.getName().equals("setPentagonNukesCodes")) {
                    method.invoke(federalVault, "");
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println(myStorage);
    }
}
