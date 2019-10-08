
package com.oaklandcc;

/**
 *
 * @author cwcis
 */
public class Character {
    private String englishCharacter;
    private String hiraganaCharacter;
    
    public Character(String englishCharacter, String hiraganaCharacter) {
        this.englishCharacter = englishCharacter;
        this.hiraganaCharacter = hiraganaCharacter;
    }
    
    public void setEnglishCharacter(String englishCharacter) {
        this.englishCharacter = englishCharacter;
    }
    
    public String getEnglishCharacter() {
        return englishCharacter;
    }
    
    public void setHiraganaCharacter(String hiraganaCharacter) {
        this.hiraganaCharacter = hiraganaCharacter;
    }
    
    public String getHiraganaCharacter() {
        return hiraganaCharacter;
    }

    @Override
    public String toString() {
        return hiraganaCharacter + " is " + englishCharacter;
    }
    
    
}
