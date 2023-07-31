/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Users;



/**
 *
 * @author nhuta
 */
public class Auth {

    public static Users User = null;

    public static void clear() {
        Auth.User = null;
    }

    public static boolean isLogin() {
        return Auth.User != null;
    }

    public static boolean isManager() {
        return Auth.isLogin() && User.getVaitro();
    }
}
