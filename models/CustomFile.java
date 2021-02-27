/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author juandre
 */
public class CustomFile {
    private String name;
    private String location;
    private String extension;
    private String fullName;
    private String absolutePath;
    private String content;

    public CustomFile(){
        
    }
    
    public CustomFile(String name, String location, String extension, String content){
        this.name = name;
        this.location = location;
        this.extension = extension;
        this.fullName = name + "." + extension;
        this.absolutePath = location + "/" + fullName;
        this.content = content;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the absolutePath
     */
    public String getAbsolutePath() {
        return absolutePath;
    }

    /**
     * @param absolutePath the absolutePath to set
     */
    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }
    
    public String getContent(){
        return content;
    }
    
    public void setContent(String content){
        this.content = content;
    }
    
    public void Save(){
        //Write/Override file
    }
    
    public void Open(){
        //Read file
    }
    
    @Override
    public String toString(){
        return String.format("Name: %s\nAbsolutePath: %s\nContent: %s", name, absolutePath, content);
    }
}
