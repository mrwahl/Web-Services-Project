/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.models;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {

    private int id;    
    private String comment;     

    public Comment() {
    }

    public Comment(int id, String comment) {
        this.id = id;
        this.comment = comment;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    
    public String printComment() {
        String str = this.getId()+" "+this.getComment();
        return str;
    }
}
