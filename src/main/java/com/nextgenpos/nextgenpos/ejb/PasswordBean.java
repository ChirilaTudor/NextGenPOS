package com.nextgenpos.nextgenpos.ejb;
import jakarta.ejb.Stateless;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Stateless
public class PasswordBean {
    private static final Logger LOG = Logger.getLogger(PasswordBean.class.getName());
    public String convertToSha256(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] digest = messageDigest.digest();
            final StringBuilder hexString = new StringBuilder();
            for(int i=0; i<digest.length; i++){
                final String hex = Integer.toHexString(0xff & digest[i]);
                if(hex.length() == 1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            LOG.log(Level.SEVERE, "Could not convert password", ex);
        }
        return null;
    }
}