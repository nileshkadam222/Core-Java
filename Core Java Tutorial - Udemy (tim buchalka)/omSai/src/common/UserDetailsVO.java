/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Nilesh
 */
public class UserDetailsVO {
   private String userid;
   private boolean framemode= false;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public boolean isFramemode() {
        return framemode;
    }

    public void setFramemode(boolean framemode) {
        this.framemode = framemode;
    }
   
   
}
