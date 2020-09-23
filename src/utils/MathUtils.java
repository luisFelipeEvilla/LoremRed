/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Usuario
 */
public class MathUtils {

    public static float lerp(float a, float b, float f) {
        return a + f * (b - a);
    }
}
