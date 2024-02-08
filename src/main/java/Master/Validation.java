/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Master;

import java.io.File;

/**
 *
 * @author Ahmed yehia
 */
public class Validation {
    
    public boolean Name(String s){
        if(s.length()==0)return false;
        for(char i:s.toCharArray()){
            if(i>='A'&&i<='Z')continue;
            if(i>='a'&&i<='z')continue;
            if(i==' ')continue;
           return false;
        }
        return true;
    }
    
    public boolean Phone(String s){
        if(s.charAt(0)!='0' || s.charAt(1)!='1')return false;
        if(s.length()!=11)return false;
        for(char i : s.toCharArray()){
            if(i>='0'&&i<='9')continue;
            return false;
        }
        return true;
    }
    
    public boolean Password(String s){
        return s.length() != 0;
    }
    
    public boolean Id(String s){
        if(s.length()==0)return false;
        for(char i : s.toCharArray()){
            if(i>='0'&&i<='9')continue;
            return false;
        }
        return true;
    }
    
    public boolean Photo(String s){
        File PhotoFile=new File(s);
        return PhotoFile.exists();
    }
    
}
