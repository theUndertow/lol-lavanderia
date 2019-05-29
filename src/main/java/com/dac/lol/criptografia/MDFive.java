/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.criptografia;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author marco
 */
public class MDFive {

    public MDFive() {
    }
    
    public static String encripta (String senha) {
        /*
         try    {
             MessageDigest digest = MessageDigest.getInstance("MD5");
             digest.update(senha.getBytes());
             BASE64Encoder encoder = new BASE64Encoder(); 
             return encoder.encode(digest.digest()); 
         }catch (NoSuchAlgorithmException ns) {
             ns.printStackTrace ();
             return senha;
         }
        */
        MessageDigest m;
        String s = senha;
        String hexa = null;
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes(), 0, s.length());
            byte[] digest = m.digest();
            hexa = new BigInteger(1, digest).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return hexa;
     }   
}
