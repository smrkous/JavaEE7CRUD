package javaee7crud.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Record entity.
 */
@Entity
@Table(name="record"
    ,schema="public"
)
public class Record implements java.io.Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique=true, nullable=false)
    private int id;
    
    @Column(name="content")
    private String content;

    public Record() 
    {
    }
	
    public Record(int id) 
    {
        this.id = id;
    }
    
    public Record(int id, String content) 
    {
       this.id = id;
       this.content = content;
    }
    
    public int getId() 
    {
        return this.id;
    }
    
    public void setId(int id) 
    {
        this.id = id;
    }    
    
    public String getContent() 
    {
        return this.content;
    }
    
    public void setContent(String content) 
    {
        this.content = content;
    }
    
}


